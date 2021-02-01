package chapter_7

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
}

