package com.example.testapplication.kotlinplayground

//Inheritance concept
open class Car(mileAge: Int) {
    init {
        println("in Car..$mileAge")
    }
    open fun start(){
        println("Starting my car..")
    }
}

interface ExtraFeatures{
    fun coolFeature()
    fun startEngine(){
        println("Starting Audi's Engine..")
    }
}
class Mercedes(mileAge: Int) : Car(mileAge) , ExtraFeatures{
    init {
        println("in Mercedes..$mileAge")
    }
    override fun start() {
        //super.start()
        println("Starting mercedes car..")
    }

    override fun coolFeature() {
        println("Extra features are incorporated in Mercedes..")
    }
}

fun main(args: Array<String>){
    /*var car = Car()
    car.start()*/

    var mercedes = Mercedes(40)
    mercedes.startEngine()
    mercedes.start()
    mercedes.coolFeature()

}