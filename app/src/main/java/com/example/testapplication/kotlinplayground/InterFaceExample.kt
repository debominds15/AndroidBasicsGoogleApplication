package com.example.testapplication.kotlinplayground

interface A{
    fun work()
    fun abc(){
        println("in abc A")
    }
}
interface B{
    fun work()
    fun speak()
    fun abc(){
        println("in abc B")
    }
}
class InterfaceImpl : A, B{
    override fun work() {
        println("Working..")
    }

    override fun speak() {
        println("Speaking..")
    }

    override fun abc() {
        super<A>.abc()
        println("in abc C")
    }
}
fun main(args: Array<String>){
    var interfaceImpl = InterfaceImpl()
    interfaceImpl.work()
    interfaceImpl.speak()
    interfaceImpl.abc()
}


/*
interface A{
    fun work()
}
interface B{
    fun work()
    fun speak()
}

interface C: A, B{
    override fun work()
    override fun speak()
    fun write()
}

class InterfaceImpl : C{
    override fun work() {
        println("Working..")
    }

    override fun speak() {
        println("Speaking..")
    }

    override fun write() {
        println("Writing..")
    }
}
fun main(args: Array<String>){
    var interfaceImpl = InterfaceImpl()
    interfaceImpl.work()
    interfaceImpl.speak()
    interfaceImpl.write()
}*/
