package com.example.testapplication.kotlinplayground

data class Book(val name: String, val price: Int)

object BookShelf{
    var books = arrayListOf<Book>()
    fun showBooks(){
        for (i in books){
            println(i)
        }
    }
}
fun main(args: Array<String>){
    BookShelf.books.apply {
        add(Book("Java",200))
        add(Book("SQL",250))
        add(Book("Kotlin",400))
    }
    println(BookShelf.showBooks())
}