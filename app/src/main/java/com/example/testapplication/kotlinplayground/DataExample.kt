package com.example.testapplication.kotlinplayground

data class Computer(var name: String, var price: Int){
    fun show(){
        println("The name of the computer is $name and price is $price")
    }
}

fun main (args: Array<String>){
    var dell = Computer("Dell",20000)
    var apple = Computer("Apple",25000)
    var lap = dell.copy(price = 40000)
    dell.show()
    println(dell.equals(apple))
    println(lap)
}