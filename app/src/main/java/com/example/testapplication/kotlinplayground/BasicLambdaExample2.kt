package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){

    //1st way of calling higher function by passing lambda expression
    /*var myexp: (Int, Int) -> Int = { x, y -> x + y}
    addTwoNumber(10, 15, myexp)*/

    //2nd way of calling higher function by passing lambda expression
    //addTwoNumber(10, 15, { x, y -> x + y})

    //3rd way of calling higher function by passing lambda expression
    addTwoNumber(10, 15) { x, y -> x + y}
}

fun addTwoNumber(a: Int, b: Int,exp: (Int, Int) -> Int){
    println(exp(a,b))
}