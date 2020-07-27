package com.example.testapplication.kotlinplayground

//Extension function
fun main(args: Array<String>) {

    //Extension function
    var a1 = Alien()
    a1.skill = "Java"
    a1.show()

    var a2 = Alien()
    a2.skill = "Kotlin"
    a2.show()

    a1.plus(a2).show()
}

// Extension function declaration
fun Alien.plus(a: Alien): Alien {
    var newAlien = Alien()
    newAlien.skill = "${a.skill} and  ${this.skill}"

    return newAlien
}
