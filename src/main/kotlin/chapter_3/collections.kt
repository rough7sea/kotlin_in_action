package chapter_3

import chapter_3.strings.lastChar as last
import chapter_3.strings.*

fun main(){
    var set = hashSetOf(1, 7, 5)
    var list = arrayListOf(1, 7, 5)
    var map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
    // 1.to("one") the same
    // 1 to "some" -> инфиксная форма записи

    println(list.last())
    println(set.maxOrNull())

    println(list)
    println(list.joinToString("; ", "(", ")"))
    println(list.joinToString())
    println(list.joinToString(prefix = "#"))

    reportOperationCount()

    println("Kotlin".last()) // like function
    println("Kotlin".last) // like property
    val sb = StringBuilder("Kotlin?")
    sb.last = '!'
    println(sb)

    val view: View = Button()
    view.click() // override
    view.showOff() // not override

}

infix fun Any.to(other: Any) = Pair(this, other)