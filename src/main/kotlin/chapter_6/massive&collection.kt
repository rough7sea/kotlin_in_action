package chapter_6

import java.io.BufferedReader
import java.io.StringReader

fun readNumbers(reader: BufferedReader): List<Int?>{
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()){
        result.add(line.toIntOrNull())
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>){
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers : ${validNumbers.sum()}")
    println("Invalid numbers : ${numbers.size - validNumbers.size}")
}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>){
    for (item in source)
        target.add(item)
}

fun main() {
    val reader = BufferedReader(StringReader("1\nabc\n42"))
    val numbers = readNumbers(reader)
    addValidNumbers(numbers)

    val source: Collection<Int> = arrayListOf(3, 5, 7)
    val target: MutableCollection<Int> = arrayListOf(1)

    copyElements(source, target)
    println(target)
}