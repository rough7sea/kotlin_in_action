package chapter_8

import java.io.BufferedReader
import java.io.FileReader
import java.util.concurrent.locks.Lock


inline fun <T> synchronized(lock: Lock, action: () -> T): T {
    lock.lock()
    try {
        return action()
    } finally {
        lock.unlock()
    }

}

fun foo(l: Lock){
    println("Before sync")
    synchronized(l){
        println("Action")
    }
    println("After sync")
}

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit){
    // noinline function can not be embedded
    // do something
}

val people = listOf(chapter_5.lambda.Person("Alice", 29),
    chapter_5.lambda.Person("Bob", 31))

fun readFirstLinerFromFile(path: String): String {
    BufferedReader(FileReader(path)).use { br ->
        return br.readLine()
    }
}

fun main() {
    println(people.filter { it.age < 30 })
}