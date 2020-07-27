/*
package com.example.testapplication.login.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.testapplication.R
import com.example.testapplication.databinding.ActivityLoginBinding
import com.example.testapplication.login.ui.auth.AuthListener
import com.example.testapplication.login.ui.auth.AuthViewModel


const val EXTRA_EMAIL_ID = "com.example.testapplication.login.view.EXTRA_EMAIL_ID"
const val EXTRA_PASSWORD = "com.example.testapplication.login.view.EXTRA_PASSWORD"

class LoginActivity : AppCompatActivity(), AuthListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_login)

        //val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        */
/*viewModel.l.observe(this, Observer {
            Log.i("Notes observed", "$it")
            adapter.submitList(it)
        })*//*


        binding.viewmodel = viewModel

        viewModel.authListener = this

        //setViews()
    }

  */
/*  private fun setViews() {
        var emailId = ed_username.text
        var password = ed_password.text

        btn_login.setOnClickListener {
            var intent = Intent(this, HomeActivity::class.java)
            intent.putExtra(EXTRA_EMAIL_ID, emailId)
            intent.putExtra(EXTRA_PASSWORD, password)
            startActivity(intent)
        }
    }*//*


    override fun onStarted() {
        Toast.makeText(this, "onStarted", Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            Toast.makeText(this, "onSuccess.. $it", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        })

    }

    override fun onFailure(message: String) {
        Toast.makeText(this, "onFailure", Toast.LENGTH_SHORT).show()
    }

}*/
