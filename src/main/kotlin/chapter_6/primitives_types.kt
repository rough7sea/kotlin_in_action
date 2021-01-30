package chapter_6

fun showProgress(progress: Int){
    val percent = progress.coerceIn(0, 100)
    println("We're $percent% done!")
}

data class Person1(val name: String, val age: Int? = null){
    fun isOlderThan(other: Person1): Boolean?{
        if (age == null || other.age == null)
            return null
        return age > other.age
    }
}

interface Processor<T>{
    fun process(): T
}
class NoResultProcessor: Processor<Unit>{ // Unit = void
    override fun process() {  // without return type
        // do something
    }
}

fun main() {
    showProgress(146)
    println(Person1("Sam", 35).isOlderThan(Person1("Amy", 42)))
    println(Person1("Sam", 35).isOlderThan(Person1("Amy")))

    val i = 1
    val l: Long = i.toLong() // only explicit cast in kotlin
    val int: Int = "33".toInt() // cast String to Number type
    val hex = 0xCAFEBABE
    val b = 0b10010

    val answer: Any = 23


}