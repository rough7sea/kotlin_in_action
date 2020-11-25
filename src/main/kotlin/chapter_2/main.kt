package chapter_2

import kotlin.random.Random

val random = Random(33)

fun main(args: Array<String>) {
    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello, $name! \$")
    println(max(1, 3))
    println(createRandomPerson().name)
    println(createRandomPerson().isSquare)
}

fun max (a : Int, b: Int): Int{
    return if (a > b) a else b
}
//the same
//fun syntax.max (a : Int, b: Int): Int = if (a > b) a else b
//fun syntax.max (a : Int, b: Int) = if (a > b) a else b

// val -> final variable
// var -> just variable

class Person(
        val name: String, // only for read(inmutable)
        var isMarried: Boolean, // mutable
){
    //    val isSquare: Boolean = Random(33).nextBoolean()
    val isSquare: Boolean
        get() {
            return random.nextBoolean()
        }
}

fun createRandomPerson(): Person{
    return Person(
            "${random.nextInt(1000)}",
            random.nextBoolean())
}

