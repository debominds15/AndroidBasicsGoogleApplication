package com.example.testapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_add_edit_note.*
import kotlinx.android.synthetic.main.activity_main.*

const val ADD_NOTE_REQUEST = 1
const val EDIT_NOTE_REQUEST = 2

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var vm: NoteViewModel
    private lateinit var adapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate called!!")

        vm = ViewModelProviders.of(this)[NoteViewModel ::class.java]
        vm.getAllNotes().observe(this, Observer {
            Log.i("Notes observed", "$it")
            adapter.submitList(it)
        })

        var layoutManager= LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view.layoutManager = layoutManager

        setListeners()

       /* var list = mutableListOf<Note>()
        list.apply {
            add(Note("Work", "Hard work pays off", 9))
            add(Note("Time", "Time is money", 3))
            add(Note("Sleep", "It's bed time", 1))
            add(Note("Workout", "Go to gym and sweat it out", 7))
        }*/

        adapter = NoteAdapter{ note ->
            var intent = Intent(this, AddEditNoteActivity::class.java)

            intent.putExtra(EXTRA_ID, note.id)
            intent.putExtra(EXTRA_TITLE, note.title)
            intent.putExtra(EXTRA_DESCRIPTION, note.description)
            intent.putExtra(EXTRA_PRIORITY, note.priority)

            startActivityForResult(intent, EDIT_NOTE_REQUEST)
        }
        recycler_view.adapter = adapter
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK){
            invokeInsertNote(data)
        }
        else if(requestCode == EDIT_NOTE_REQUEST && resultCode == Activity.RESULT_OK){
            updateNote(data)
        }
        else{
            Toast.makeText(this, "Not saved",Toast.LENGTH_LONG).show()
        }
    }

    private fun updateNote(data: Intent?) {
        var id = data?.getIntExtra(EXTRA_ID, -1)
        var title = data?.getStringExtra(EXTRA_TITLE)
        var description = data?.getStringExtra(EXTRA_DESCRIPTION)
        var prioirity = data?.getIntExtra(EXTRA_PRIORITY, 0)

        var note = Note(title!!, description!!, prioirity!!, id)
        vm.update(note)
    }

    private fun invokeInsertNote(data: Intent?) {
        var title = data?.getStringExtra(EXTRA_TITLE)
        var description = data?.getStringExtra(EXTRA_DESCRIPTION)
        var prioirity = data?.getIntExtra(EXTRA_PRIORITY, 0)

        var note = Note(title!!, description!!, prioirity!!)
        vm.insert(note)
    }

    private fun setListeners(){
        button_add_note.setOnClickListener {
            var intent = Intent(this, AddEditNoteActivity :: class.java)
            startActivityForResult(intent, ADD_NOTE_REQUEST)
        }

        // swipe listener
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                when (direction) {
                    ItemTouchHelper.RIGHT -> {
                        var note = adapter.getNoteAt(viewHolder.adapterPosition)
                        vm.delete(note)

                    }
                    ItemTouchHelper.LEFT -> {
                        var note = adapter.getNoteAt(viewHolder.adapterPosition)
                        vm.delete(note)
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "Please try again!!",Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }).attachToRecyclerView(recycler_view)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menu = menuInflater.inflate(R.menu.main_menu, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_all_notes -> {
                vm.deleteAllNotes()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called!!")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called!!")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called!!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called!!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called!!")
    }
}
