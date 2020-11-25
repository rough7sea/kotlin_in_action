package chapter_3

fun main(){
    var set = hashSetOf(1, 7, 5)
    var list = arrayListOf(1, 7, 5)
    var map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")


    println(list.last())
    println(set.max())

    println(list)
    println(joinToString(list, "; ", "(", ")"))
}
fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
) : String{
    val result = StringBuilder(prefix)
    for((index, element) in collection.withIndex()){
        if (index > 0) result.append(separator)
        result.append(element)
    }



    result.append(postfix)
    return result.toString()
}