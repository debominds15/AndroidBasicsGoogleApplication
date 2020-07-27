package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){
    var values = listOf<Int>(4,8,3,9,2,1)


    var evens = values
        .filter { it % 2 == 0 }
        .map { it * 2 }
        .forEach(::println)
}