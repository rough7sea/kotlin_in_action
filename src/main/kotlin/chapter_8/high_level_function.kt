package chapter_8

fun twoAndTree(operation: (Int, Int) -> Int){
    val result = operation(2, 3)
    println("The result is $result")
}

fun String.filter(predicate: (Char) -> Boolean): String{
    val sb = StringBuilder()
    for (index in 0 until length){
        val element = get(index)
        if (predicate(element))
            sb.append(element)
    }
    return sb.toString()
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }
) : String{
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        result.append(transform(element))
    }
    result.append(postfix)
    return result.toString()
}

fun <T> Collection<T>.joinToString2(
    separator: String = ", ", prefix: String = "", postfix: String = "",
    transform: ((T) -> String)? = null
) : String{
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()){
        if (index > 0) result.append(separator)
        val str = transform?.invoke(element)
            ?: element.toString()
        result.append(str)

    }
    result.append(postfix)
    return result.toString()
}

enum class Deliver { STANDARD, EXPEDITED}

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Deliver): (Order) -> Double{ // return other function
    if (delivery == Deliver.EXPEDITED){
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
}
data class Person(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean{
        val startWithPrefix = { p: Person ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if (!onlyWithPhoneNumber){
            return startWithPrefix
        }
        return { startWithPrefix(it) && it.phoneNumber != null}
    }
}

fun main() {
    val action = { println(42) }
    val sum = { x: Int, y: Int -> x + y}
//    var canReturnNull: (Int, Int) -> Int? =  { null }
    var funOrNull: ((Int, Int) -> Int)? = null

    twoAndTree(sum)
    twoAndTree {a, b -> a * b}

    println("ab3x2".filter { it in 'a' .. 'z' })

    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString())
    println(letters.joinToString { it.toLowerCase() })
    println(letters.joinToString(
        separator = "! ", postfix = "! ",
        transform = { it.toUpperCase() }) )

    val calculator =
        getShippingCostCalculator(Deliver.EXPEDITED)
    println("Shipping cost ${calculator(Order(4))}")

    val contacts = listOf(
        Person("Me", "Me2", "777"),
        Person("Dima", "Dimovich", "11"),
        Person("Don", "Nedon", null))

    val contactListFilters = ContactListFilters()
    with(contactListFilters){
        prefix = "D"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contactListFilters.getPredicate()))
}