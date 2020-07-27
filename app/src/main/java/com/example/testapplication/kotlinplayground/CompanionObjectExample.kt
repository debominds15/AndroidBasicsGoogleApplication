package com.example.testapplication.kotlinplayground

class Example{
    companion object{
        fun work(){
            println("I am rocking..")
        }
    }

    fun doWorkout(){
        println("Doing Workout...")
    }
}

fun main(args: Array<String>){
    Example.work()
    var example = Example()
    example.doWorkout()
}