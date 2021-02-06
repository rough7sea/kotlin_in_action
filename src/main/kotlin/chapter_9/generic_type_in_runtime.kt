package chapter_9

fun printSum(c: Collection<*>){
    val intList = c as? List<Int>
        ?: throw IllegalArgumentException("List is expected")
    println(intList.sum())
}

inline fun <reified T> isA(value: Any) = value is T // reified mark, that type will not erasure

fun main() {
    printSum(listOf(1, 2, 3))
    try {
        printSum(setOf(1, 2, 3))
    } catch (e : Exception){
        println(e.javaClass)
    }
    println(isA<String>("abc"))
    println(isA<String>(123))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())

}
