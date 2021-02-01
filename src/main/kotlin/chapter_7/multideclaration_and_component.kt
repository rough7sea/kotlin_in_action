package chapter_7

//class Point(val x: Int, val y: Int){ // manual multideclaration
//    operator fun component1() = x
//    operator fun component2() = y
//}

data class NameComponents(val name: String, val extension: String)

fun splitFilename(fullName: String): NameComponents{
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

fun printEntries(map: Map<String, String>){
    for ((key, value) in map){
        println("$key -> $value")
    }
}

fun main() {
    val p = Point(10, 20)
    val (x, y) = p
    println("x=$x y=$y")

    val (name, ext) = splitFilename("example.kt")
    println("filename = $name; ext = $ext")

    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
}