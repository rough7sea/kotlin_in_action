package chapter_5.lambda

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>): Person? {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people){
        if (person.age > maxAge){
            maxAge = person.age
            theOldest = person
        }
    }
    return theOldest
}


fun main() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(findTheOldest(people))
    println(people.maxByOrNull { p: Person -> p.age })
    println(people.maxByOrNull( Person::age ))
    println(people.maxByOrNull { it.age  })

    val getAge = { p: Person -> p.age } // must be declared explicitly
    people.maxByOrNull(getAge) // no context to extract parameter

    var sum = { x: Int, y: Int -> x + y}
    println(sum(3, 4))

    sum = {x: Int, y: Int ->
        println("Computing the sum of $x and $y . . . ")
        x + y
    }
    println(sum(3, 5));

    { println(42) }() // call lambda directly
    run { println(42) } // call lambda directly

    var names = people.joinToString(separator = " ", transform = { it.name })
    println(names)
    names = people.joinToString(" ") { it.name }
    println(names)


}