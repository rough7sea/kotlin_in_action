package chapter_11

fun buildString(builderAction: (StringBuilder) -> Unit) : String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

fun buildString2(builderAction: StringBuilder.() -> Unit) : String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

val appendExcl : StringBuilder.() -> Unit =
    { this.append("!") }

fun StringBuilder.appendExcl2(): StringBuilder = this.append("?" )

fun main() {
    val s = buildString {
        it.append("Hello, ")
        it.append("World!")
    }
    println(s)
    val s2 = buildString2 {
        this.append("Hello, ")
        append("World!")
    }
    println(s2)

    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl()
    println(stringBuilder)
    stringBuilder.appendExcl2()
    println(stringBuilder)

    val map = mutableMapOf(1 to "one")
    map.apply { this[2] = "two" }
    with(map) { this[3] = "three" }
    println(map)
}