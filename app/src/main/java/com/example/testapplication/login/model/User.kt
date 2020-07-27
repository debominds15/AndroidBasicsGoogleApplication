package com.example.testapplication.login.model

import androidx.room.Entity


@Entity(tableName = "table_user")
data class User(val name: String, val userName: String, val password: String)