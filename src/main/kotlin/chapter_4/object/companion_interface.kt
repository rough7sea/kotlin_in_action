package chapter_4.`object`

import com.beust.klaxon.Klaxon

interface JSONFactory<T>{
    fun fromJSON(jsonText: String): T
}

class Person2(val name: String){
    companion object : JSONFactory<Person2>{
        override fun fromJSON(jsonText: String): Person2 {
            return Klaxon().parse<Person2>(jsonText)!! // very low performance
        }
    }
}

class Person3(val firstName: String, val lastName: String = "default"){
    companion object{

    }
}

fun Person3.Companion.fromJSON(json: String): Person3{
    return Klaxon().parse<Person3>(json)!! // very low performance
}

fun main() {
    println(Person2.fromJSON("""{"name": "Klaus"}""").name)
    println(Person3.fromJSON("""{"firstName": "Klaus"}""").firstName)

}