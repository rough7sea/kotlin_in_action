package chapter_5.lambda

import java.io.File

class Book(val title: String, val author: List<String>)

fun main() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
    val people = mutableListOf(Person("Alice", 21), Person("Bob", 33))
    println(people.filter { it.age > 30 }.map(Person::name))

    val maxAge = people.maxByOrNull(Person::age)?.age
    println(people.filter { it.age == maxAge })

    val canBeInClub27 = { p: Person -> p.age <= 27}
    println(people.all(canBeInClub27))
    println(!people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27)) // findOrNull

    people.add(Person("Carol", 21))
    println(people.groupBy { it.age })
    println(listOf("a", "b", "ab").groupBy(String::first))

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })

    val books = listOf(
        Book("book 1", listOf("author 1")),
        Book("book 2", listOf("author 2")),
        Book("book 3", listOf("author 3", "author 1")))
    println(books.flatMap(Book::author).toSet())
    println(books.map(Book::author).toSet())

    val toList = people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()

    benchmark()

    val naturalNumber = generateSequence(0) { it + 1}  // deferred call
    val numberTo100 = naturalNumber.takeWhile { it <= 100 } // deferred call
    println(numberTo100.sum())

    val file = File("src/main/kotlin/chapter_5/lambda/api.kt")
    println(file.isHiddenDirectory())

    createAllDoneRunnable().run()

}

fun benchmark(){
    val people = mutableListOf<Person>()
    for(i in 0..1000){
        people.add(i, Person("Alice_$i", i))
    }

    val test1 = { // faster than first one in case large amount of elements
            p: List<Person> ->
        p.asSequence()
            .map(Person::name)
            .filter { it.startsWith("A") }
            .toList()
    }

    val test2 = {
            p: List<Person> ->
        p.map(Person::name)
            .filter { it.startsWith("A") }
    }


    test(people, test1)
    test(people, test2)

}

fun test(people: List<Person>, test: (List<Person>) -> List<String>){
    var time = System.currentTimeMillis()

    for (i in 1..100000){
        test(people)
    }

    time = System.currentTimeMillis() - time

    println("test time = $time ms")
}

fun File.isHiddenDirectory() =
    generateSequence(this) { it.parentFile }.any { it.isHidden }

fun createAllDoneRunnable(): Runnable { // SAM-constructor
    return Runnable { println("All done!") }
}