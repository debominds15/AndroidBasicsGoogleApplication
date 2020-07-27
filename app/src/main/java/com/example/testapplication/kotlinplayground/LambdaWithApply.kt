package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){

    var person = Person()

   /* with(person){
        name = "Debo"
        age = 20
    }*///Cannot call startRun() using with

    //person.startRun()

    person.apply {
        name = "Susmita"
        age = 18
    }.startRun()
}

class Person{
    var name: String = ""
    var age: Int = -1

    fun startRun(){
        println("I am $name , age : $age and now I am ready to run")
    }
}