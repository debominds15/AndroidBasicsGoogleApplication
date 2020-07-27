package com.example.testapplication.kotlinplayground

//Primary Constructor and Secondary Constructor implementation
class Human (var x: String){
    var hName: String = ""
    var hAge: Int? = null

    //Constructor chaining
    constructor(age: Int = 20, name: String) : this(name){
        this.hName = name
        this.hAge = age
    }

    fun doWork(){
        println("I can work and think..$hName and my age is $hAge")
    }
}


fun main(args: Array<String>){
    var debo = Human("Joker")
    debo.doWork()
}