package chapter_6

fun strLen(s: String) = s.length
fun strLenSafe(s: String?) = s?.length

fun main() {
//    strLen(null) // error -> s can't be null
    println(strLenSafe(null))

    val x : String? = null
//    var y: String = x // can't assign x
}