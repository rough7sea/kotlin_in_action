package chapter_11

import kotlinx.html.*
import kotlinx.html.stream.createHTML

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

fun createSimpleTable() = createHTML().
table{
    (this@table).tr {
        td{ +"cell"}
    }
}

fun createAnotherTable() = createHTML().
table {
    for (i in 1..2){
        tr {
            td { +"$i" }
        }
    }
}

fun buildDropdown() = createHTML()
    .div(classes = "dropdown") {
        button(classes = "btn dropdown-toggle") {
            +"Dropdown"
            span(classes = "caret")
        }

//    ul("dropdown-menu") {
        dropdownMenu {

//        li { a("#") { +"Action" } }
//        li { a("#") { +"Another action" } }
//        li { role = "separator"; classes = setOf("divider") }
//        li { classes = setOf("dropdown-header"); +"Header" }
//        li { a("#") { +"Separated link" } }
            item("#", "Action")
            item("#", "Another action")
            divider()
            dropdownHeader("Header")
            item("#", "Separated link")
        }
    }

fun UL.item(href: String , name: String) = li { a(href) { +name } }
fun UL.divider() = li { role = "separator"; classes = setOf("divider") }
fun UL.dropdownHeader(text: String) =
    li { classes = setOf("dropdown-header"); +text }

fun DIV.dropdownMenu(block: UL.() -> Unit) = ul("dropdown-menu", block)

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

    println(createSimpleTable())
    println(createAnotherTable())
    println(buildDropdown())
}