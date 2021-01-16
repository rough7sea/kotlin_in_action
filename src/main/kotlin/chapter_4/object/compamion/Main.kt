package chapter_4.`object`.compamion

import chapter_4.`interface`.getFacebookName

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



fun main() {
    A.bar()
    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname)
}