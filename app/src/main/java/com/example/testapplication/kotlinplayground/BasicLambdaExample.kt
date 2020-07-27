package com.example.testapplication.kotlinplayground

interface MyInterface {
    fun printResult(sum: Int)
}

fun main(args: Array<String>) {


    val myLambda: (Int) -> Unit = { s -> println(s) } //Lambda Expression [Function]
    add(2, 3, myLambda)

    //passing interface object
    add(5, 2, object: MyInterface{
        override fun printResult(sum: Int) {
            println("The result is $sum")
        }
    })
}

//High Level Function with Lambda as a parameter
fun add(
    a: Int,
    b: Int,
    lambda: (Int) -> Unit
) {
    var sum = a + b
    lambda(sum)
}

//Using Interface / Object Oriented way
fun add(a: Int, b: Int, action: MyInterface) {
    var sum = a + b
    action.printResult(sum)
}


