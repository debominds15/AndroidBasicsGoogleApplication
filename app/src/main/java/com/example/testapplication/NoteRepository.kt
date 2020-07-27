package com.example.testapplication

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.testapplication.utils.subscribeOnBackground

class NoteRepository(application: Application) {
    private var noteDao: NoteDao
    private var allNotes: LiveData<List<Note>>

    private val noteDatabase = NoteDatabase.getInstance(application)
    init {
        noteDao = noteDatabase.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Note){
        subscribeOnBackground {
            noteDao.insert(note)
        }
    }

    fun update(note: Note){
        subscribeOnBackground {
            noteDao.update(note)
        }
    }

    fun delete(note: Note){
        subscribeOnBackground {
            noteDao.delete(note)
        }
    }

    fun deleteAllNotes(){
        subscribeOnBackground {
            noteDao.deleteAllNotes()
        }
    }

    fun getAllNotes(): LiveData<List<Note>>{
        return allNotes
    }
}