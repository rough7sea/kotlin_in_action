package chapter_5.lambda

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String){
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>){
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")){
            clientErrors++
        } else if (it.startsWith("5")){
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

data class Person1(val name: String, val age: Int)


fun main() {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)

    fun salute() = println("Salute!")
    run(::salute) // top function reference

    val createPerson = ::Person1
    val p = createPerson("Alice", 21)
    println(p)

    fun Person1.isAdult() = age >= 21
    val predicate = Person1::isAdult // function-extension link
}