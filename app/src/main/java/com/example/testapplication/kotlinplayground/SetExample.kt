package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){
    //"Set" contains unique element
    //"HashSet" also contains unique element but Sequence is not guaranteed in output

    //var set = setOf<Int>(2,8,7,99,87,2) // Immutable Set, READ only
    var set = mutableSetOf<Int>(2,8,7,99,87,2) // Mutable Set, READ and WRITE both
    var hashSet = hashSetOf<Int>(2,8,7,99,87,2) // Mutable Set, READ and WRITE both

    hashSet.apply {
        this.remove(99)
        this.add(4)
    }

    for (e in hashSet){
        println(e)
    }
}