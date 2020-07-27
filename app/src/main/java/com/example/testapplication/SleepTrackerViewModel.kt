package com.example.testapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.testapplication.trackmysleepquality.database.SleepDatabaseDao

/**
 * ViewModel for SleepTrackerFragment.
 */
class SleepTrackerViewModel(
        val database: SleepDatabaseDao,
        application: Application) : AndroidViewModel(application) {
}