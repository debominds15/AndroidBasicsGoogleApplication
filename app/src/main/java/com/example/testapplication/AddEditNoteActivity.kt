package com.example.testapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_edit_note.*
import kotlinx.android.synthetic.main.note_item.*
import org.w3c.dom.Node

const val EXTRA_ID = "com.example.testapplication.EXTRA_ID"
const val EXTRA_TITLE = "com.example.testapplication.EXTRA_TITLE"
const val EXTRA_DESCRIPTION = "com.example.testapplication.EXTRA_DESCRIPTION"
const val EXTRA_PRIORITY = "com.example.testapplication.EXTRA_PRIORITY"

class AddEditNoteActivity : AppCompatActivity() {
    private lateinit var mode: Mode
    private var noteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)

        number_picker_priority.minValue = 1
        number_picker_priority.maxValue = 10

        noteId = intent.getIntExtra(EXTRA_ID, -1)
        mode =  if( noteId == -1) Mode.AddNote
                else Mode.EditNote

        when (mode) {
            Mode.AddNote -> setTitle("Add Note")
            Mode.EditNote -> {
                setTitle("Edit Note")
                var noteTitle = intent.getStringExtra(EXTRA_TITLE)
                var noteDescription = intent.getStringExtra(EXTRA_DESCRIPTION)
                var notePriority = intent.getIntExtra(EXTRA_PRIORITY, -1)
                et_title.setText(noteTitle?:"0")
                et_desc.setText(noteDescription?:"")
                number_picker_priority.value = notePriority
            }

            else -> {
                Toast.makeText(this, "Invalid option", Toast.LENGTH_SHORT).show()
            }
        }

        //setSupportActionBar(toolbar)
/*
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }

    private fun saveNote(){
        val title = et_title.text.toString()
        val description = et_desc.text.toString()
        val priority = number_picker_priority.value

        if(title.isEmpty() || description.isEmpty()){
            Toast.makeText(this,"Please insert title and description",Toast.LENGTH_SHORT).show()
            return
        }

        var intent = Intent()

        if(noteId > 0)
            intent.putExtra(EXTRA_ID, noteId)

        intent.putExtra(EXTRA_TITLE, title)
        intent.putExtra(EXTRA_DESCRIPTION, description)
        intent.putExtra(EXTRA_PRIORITY, priority)


        setResult(Activity.RESULT_OK, intent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater = menuInflater
            .inflate(R.menu.add_note_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.save_note -> {
                saveNote()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private sealed class Mode{
        object AddNote : Mode()
        object EditNote : Mode()
    }
}
