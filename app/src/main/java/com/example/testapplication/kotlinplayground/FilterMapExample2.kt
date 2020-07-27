package com.example.testapplication.kotlinplayground

/**FILTER
 * Returns a list containing only elements matching the given [predicate].
 */

/**MAP
 * Returns a list containing the results of applying the given [transform] function
 * to each element in the original collection.
 */
fun main(args: Array<String>){

    val numbers = listOf<Int>(24,9,4,3,23)

    //val smallNumbers = numbers.filter { n -> n < 10 }
    val smallNumbers = numbers
        .filter { it < 10 }
        .map { it * it }

    for (num in smallNumbers)
        println(num)

    var personList = listOf<PersonInfo>(PersonInfo(25, "Debo"), PersonInfo(30,"Susmita"),
        PersonInfo(age = 56, name = "Abhay"))

    personList
        .filter { it.age < 50 }
        .map { it.name + " banik"}
        .forEach { println(it) }
}

data class PersonInfo( var age: Int = -1,
                  var name: String = "")