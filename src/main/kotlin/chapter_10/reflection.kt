package chapter_10

import kotlin.reflect.full.memberProperties

class Person4(val name: String, val age: Int)

fun foo(x: Int) = println(x)

fun sum(x: Int, y: Int) = x + y

var counter = 0

fun main() {
    val person = Person4("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) } // all non-extended properties

    val kFunction = ::foo
    kFunction.call(42)

    val kFun = ::sum
    println(kFun.invoke(1, 2) + kFun(3, 4))


    val kProperty = ::counter
    kProperty.setter.call(21)
    println("Counter value is ${kProperty.get()}")

    val memberProperty = Person4::age
    println("Person age = ${memberProperty.get(person)}")

}