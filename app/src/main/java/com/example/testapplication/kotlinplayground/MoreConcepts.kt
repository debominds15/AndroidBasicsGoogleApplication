package com.example.testapplication.kotlinplayground

import java.math.BigInteger

//Recursion
fun main(args : Array<String>) {

    var num = BigInteger("70000")
    println(fact(num, BigInteger.ONE))
}

//Tail Recursion (it will immediately calculate result and not wait like in the case of normal recursion)
tailrec fun fact(num : BigInteger, result : BigInteger): BigInteger{
    if(num == BigInteger.ONE || num == BigInteger.ZERO)
        return result
    else
        return fact(num - BigInteger.ONE, num * result)  //5 * 4!  ->  4 * 3!
}
//Operator Overloading
/*fun main(args : Array<String>) {

    //Extension function
    var a1 = Alien()
    a1.skill = "Java"
    a1.show()

    var a2 = Alien()
    a2.skill = "Kotlin"
    a2.show()

    var a = a1 + a2
    a.show()
}
//Operator Overloading declaration
 operator infix fun Alien.plus(a : Alien): Alien{
    var newAlien = Alien()
    newAlien.skill = "${a.skill} and  ${this.skill}"

    return newAlien
}*/

//Infix Extension function
/*fun main(args : Array<String>) {

    //Extension function
    var a1 = Alien()
    a1.skill = "Java"
    a1.show()

    var a2 = Alien()
    a2.skill = "Kotlin"
    a2.show()

    var a = a1 plus a2
    a.show()
}
// //Infix Extension function declaration
infix fun Alien.plus(a : Alien): Alien{
    var newAlien = Alien()
    newAlien.skill = "${a.skill} and  ${this.skill}"

    return newAlien
}*/

    //Try as an expression
    /*
    var str: String = "4a"
    var num: Int = try {
        str.toInt()
    }catch (e: NumberFormatException){
        -1
    }

    println(num)*/

    //TreeMap
    /*var map = TreeMap<String, Int>()
    map["Debojyoti"] = 213
    map["Susmita"] = 560

    for ((name, age) in map){
        println(" $name: $age")
    }*/


    /*var list = listOf(1,2,3,4)
    for ((i, e) in list.withIndex()){
        println("$i : $e")
    }*/

    /*var nums = 1..20
    var nums = 1 until 19
    for (a in nums step 2){
     println(a)
    }*/

    /*var nums = 20 downTo 1
    for (a in nums step 2){
        println(a)
    }
}*/