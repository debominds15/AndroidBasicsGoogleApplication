package com.example.testapplication.kotlinplayground

// Infix Extension function
fun main(args: Array<String>) {

    //Extension function
    var a1 = Alien()
    a1.skill = "Java"
    a1.show()

    var a2 = Alien()
    a2.skill = "Kotlin"
    a2.show()

    var a = a1 addSkill a2
    a.show()
}

// Infix Extension function declaration
infix fun Alien.addSkill(a: Alien): Alien {
    var newAlien = Alien()
    newAlien.skill = "${a.skill} and  ${this.skill}"

    return newAlien
}