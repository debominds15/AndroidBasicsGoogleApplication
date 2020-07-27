package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){

    reverseAndDisplay("Debojyoti") { it.reversed()}
}

fun reverseAndDisplay(str: String,exp: (String) -> String){
    println("My name is: ${exp(str)}") //it.reversed() => str.reversed() => "Debojyoti".reversed()
}