package chapter_7

import java.time.LocalDate

data class Point(val x: Int, val y: Int)

operator fun Point.plus(other: Point): Point{
    return Point(x + other.x, y + other.y)
}

operator fun Point.times(scale: Double): Point{
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String{
    return toString().repeat(count)
}

operator fun <T> MutableCollection<T>.plusAssign(element: T){
    this.add(element)
}

operator fun Point.unaryMinus(): Point{
    return Point(-x, -y)
}
class Person(val firstName: String,
             val lastName: String): Comparable<Person>{
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other,
            Person::lastName, Person::firstName)
    }
}

operator fun Point.get(index: Int): Int{
    return when(index){
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int){
    when(index){
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean{
    return p.x in upperLeft.x until lowerRight.x && // l.x <= x < r.x
            p.y in upperLeft.y until lowerRight.y
}

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate>{
        var current = start

        override fun hasNext() =
            current <= endInclusive

        override fun next() = current.apply {
            current = plusDays(1)
        }
    }

fun main() {
    var p1 = Point(10, 20)
    val p2 = Point(30, 40)
    println(p1 + p2)
    println(p1 * 1.5)
    println('a' * 5)

    println(0b0101 or 0b1110)
    println(0b0101 and 0b1110)
    println(0b0101 shl 4) // shift left with sign

    p1 += Point(3, 4)
    println(p1)

    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])

    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(newList)

    println(-Point(10, 20))

    println(Person("Alice", "Smith") < Person("Bob", "Johnson"))

    println(p1[0])

    val p = MutablePoint(10, 20)
    p[1] = 42
    println(p)

    val now = LocalDate.now()
    val vacation = now .. now.plusDays(10)
    println(vacation)

    val n = 9
    (0..n).forEach { print(it) }
    println()

    val newYear = LocalDate.ofYearDay(2021, 1)
    val daysOff = newYear.minusDays(1) .. newYear
    for (dayOff in daysOff) {
        print("$dayOff ")
    }
}

