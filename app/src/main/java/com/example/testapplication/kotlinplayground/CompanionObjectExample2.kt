package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){

    println(Laptop.count)
    println(Laptop.typeOfLaptops())
}

class MyClass {

    companion object{

        var count: Int = 5                  // Behaves like STATIC variable.. will be converted into STATIC variable while compiler converts the code into bytecode


        fun typeOfLaptops(): String {        // Behaves like STATIC method.. will be converted into STATIC method while compiler converts the code into bytecode
            return "High Configuration Laptop"
        }
    }
}