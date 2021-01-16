package chapter_4.`interface`

interface User{
    val nickname : String
}

class PrivateUser(override val nickname : String) : User

class SubscribingUser(val email: String) : User{
    override val nickname: String
    get() = email.substringBefore('@')
}

class FacebookUser(accountId: Int) : User {
    override val nickname = getFacebookName(accountId)

}
fun getFacebookName(accountId: Int) : String{
    // do something
    return "111"
}

fun main() {
    println(PrivateUser("test@kotlin.org").nickname)
    println(SubscribingUser("test@kotlin.org").nickname)

    val user = User1("Alice")
    user.address = "Elsenheimerstrasse 47 , 80687 Muenchen"
}

class User1(val name: String){
    var address: String = "unspecified"
    set(value: String){
        println("""
            Address was changed for $name:
            "$field" -> "$value".""".trimIndent())
        field = value
    }
}