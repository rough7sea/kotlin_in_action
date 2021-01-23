package chapter_5.lambda

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
}