package chapter_2

import java.util.*

fun main() {
    for (i in 1..100)
        print(fizzBuzz(i))
    println()
    for (i in 100 downTo 1 step 2)
        print(fizzBuzz(i))
    println()
    for (i in 1..100 step 2)
        print(fizzBuzz(i))
    println()
    for (i in 0 until 100)
        print(fizzBuzz(i))
    println()

    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F'){
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps){
        println("$letter = $binary")
    }
    val list = arrayListOf(10, 11, 1001)
    for ((i, el) in list.withIndex()){
        println("$i: $el")
    }
    println(isLetter('q'))
    println(isNotDigit('x'))

    println(recognize('x'))

}

fun fizzBuzz(i: Int) = when{
    i % 15 == 0 -> "FizzBuzz"
    i % 5 == 0 -> "Buzz"
    i % 3 == 0 -> "Fizz"
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c){
    in '0'..'9' -> "It's a digit"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know"
}