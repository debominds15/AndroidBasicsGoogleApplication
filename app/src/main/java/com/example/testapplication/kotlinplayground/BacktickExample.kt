package com.example.testapplication.kotlinplayground

//Backtick `` - where "in" is a keyword and we can escape using backtick
fun `in`(){
    println("Executing in method...")
}
fun main(args: Array<String>){
    `in`()
}