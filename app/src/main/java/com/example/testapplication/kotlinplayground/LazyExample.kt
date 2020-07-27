package com.example.testapplication.kotlinplayground

val pi by lazy {
    3.14f
}


fun main(args: Array<String>){
    println("Initial code...")



    println("Some more code...")
}

// lazy is used to remove unused memory
// Initializing the pi variable above for the first time will save in the cache memory
// Second time initialization of pi variable will be taken from cache memory
// Nullable type is allowed


// Lazy initialization was designed to prevent unnecessary initialization of objects.
// Your variables won't be initialized unless you use it in your code.
// It is initialized only once. Next time when you use it, you get the value from cache memory.

// It is thread safe
// It can be used for both var and val
// It can be used for both nullable and non-nullable data type