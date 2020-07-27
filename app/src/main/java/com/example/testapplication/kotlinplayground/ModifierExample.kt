package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){

}

class TestClass{

    // a, b are not visible
    // c, d are visible

    fun testing(){
        var person = PersonA()
        println(person.c)
    }
}


open class PersonA{          // Super Class
  private var a = 1
  protected var b = 2       // Visible for sub classes
  internal var c = 3        // Visible within same module
   var d = 4                // public by default
}

class Indian: PersonA(){    // Derived Class or Sub Class

    // a is not visible
    // b, c, d are visible

   fun test(){
        println(b)
    }

}