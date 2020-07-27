package com.example.testapplication.viewmodelcourse

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R

/**
 * Creates an Activity that hosts all of the fragments in the app
 */
class GuessWordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_word_guess)
    }

}