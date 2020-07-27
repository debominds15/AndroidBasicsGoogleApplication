package com.example.testapplication.kotlinplayground

// Null safety operators - to avoid null pointer exception
// ?. - Safe Call Operator
    // Returns the length if 'name' is not null else returns NULL
    // Use it if you don't mind getting NULL value

// !! - Not-null Assertion
    // Use it when you are sure the value is not NULL
    // Throws NullPointerException if the value is found to be NULL

// ?: - Elvis
    // When we have nullable reference 'name', we can say "is name is not null", use it,
    // otherwise use some non-null value like default value

// ?.let{...} - Safe call with let
    // It executes the block ONLY IF name is not NULL

fun main(args: Array<String>){

    val name: String? = null

    println("The length is ${name?.length}")

    name?.let {
        println("The length is ${name.length}")
    }

    val length = name?.length ?: -1
    println("The length is $length")

    println("The length is ${name!!.length}")



}