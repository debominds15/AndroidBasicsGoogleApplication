package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){
    val country = Country()
    country.name = "India"
    country.show()
}

class Country{
    lateinit var name: String

    fun show(){
        println("Country name is : $name")
    }
}

// lateinit used only with mutable data type [var]
// lateinit used only with non-nullable data type
// lateinit values must only be initialized before you use it