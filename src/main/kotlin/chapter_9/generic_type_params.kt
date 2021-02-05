package chapter_9

import java.lang.Appendable
import java.lang.StringBuilder

val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun <T: Number> List<T>.sum(): T? {
    return null
}

fun <T : Number> oneHalf(value: T): Double{  // T can be Double or Int or other number
    return value.toDouble() / 2.0
}

fun <T: Comparable<T>> max(first: T, second: T): T{
    return if (first > second) first else second
}

fun <T> ensureTrailingPeriod(seq: T)
        where T : CharSequence, T : Appendable {
    if (!seq.endsWith('.')){
        seq.append('.')
    }
}

class Processor<T: Any> { // T : Any -> T can not be null
    fun process(value: T){
        value.hashCode()
    }
}

fun main() {
//    val readers: MutableList<String> = mutableListOf() // the same
//    val readers = mutableListOf<String>()  // the same

    var letters = ('a'..'z').toList()
    println(letters.slice(0..2))
//    println(letters.slice<Char>(0..2))

    val authors = listOf("Dmitry", "Svetlana")
    val readers = mutableListOf<String>()

    readers.filter { it !in authors }

    println(oneHalf(3L))
    println(max("kotlin", "java"))

    val helloWorld = StringBuilder("Hello World")
    ensureTrailingPeriod(helloWorld)
    println(helloWorld)
}
