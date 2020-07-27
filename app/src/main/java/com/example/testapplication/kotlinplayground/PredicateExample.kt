package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){
    val myNumbers = listOf<Int>(2, 3, 4, 98, 76,54,7)

    var allNumbers = myNumbers.all { it > 10}
    println(allNumbers)

    var anyNumbers = myNumbers.any { it > 10}
    println(anyNumbers)

    var countNo = myNumbers.count { it > 10}
    println(countNo)

    var findNumber = myNumbers.find { it > 10}
    println(findNumber)

}