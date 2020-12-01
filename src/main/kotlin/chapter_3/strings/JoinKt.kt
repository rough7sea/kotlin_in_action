@file:JvmName("StringFunctions")

package chapter_3.strings

// public static final String
const val UNIX_LINE_SEPARATOR = "\n"

var opCount = 0

fun performOperation(){
    opCount++
}

fun reportOperationCount(){
    println("Operation performed $opCount times")
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
) : String{
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)

    performOperation()

    return result.toString()
}

fun String.lastChar(): Char = this.get(this.length - 1)
//fun String.lastChar(): Char = get(length - 1) // the same

val String.lastChar: Char get() = get(length - 1) // определение свойства-расширения
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char){
        this.setCharAt(length - 1, value)
    }


open class View{
    open fun click() = println("View clicked")
}

fun View.showOff() = println("I'm view!")

class Button: View(){
    override fun click() = println("Button clicked")
}

fun Button.showOff() = println("I'm button!")