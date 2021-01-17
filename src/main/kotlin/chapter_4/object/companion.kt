package chapter_4.`object`.compamion

import chapter_4.`interface`.getFacebookName
import com.beust.klaxon.Klaxon

class A {
    companion object{
        fun bar(){
            println("Companion object called")
        }
    }
}

//class User {
//    val nickname: String
//
//    constructor(email: String){
//        nickname = email.substringBefore('@')
//    }
//
//    constructor(facebookAccountId: Int){
//        nickname = getFacebookName(facebookAccountId)
//    }
//}

class User private constructor(val nickname: String){
    companion object{
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))
    }
}

private class Person (val name: String){
    companion object Loader {
        fun fromJSON(jsonText: String): Person {
            return Klaxon().parse<Person>(jsonText)!! // very low performance
        }
    }
}


fun main() {
    A.bar()
    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname)

    var person = Person.fromJSON("""{"name": "Klaus"}""")
    println(person.name)

    person = Person.Loader.fromJSON("""{"name": "Brent"}""")
    println(person.name)
}