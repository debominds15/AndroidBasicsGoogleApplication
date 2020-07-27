package com.example.testapplication.kotlinplayground

abstract class Planet {
    abstract fun rotate(days : Int)
}

class Earth : Planet(){
    override fun rotate(days: Int) {
        println("Earth rotates Sun in $days days..")
    }
}
fun main(args : Array<String>){
    var planet = Earth()
    planet.rotate(365)
}