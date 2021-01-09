package chapter_4.constructors

//class User constructor(_nickname: String){ // the same
//    val nickname: String
//
//    init {
//        nickname = _nickname
//    }
//}

//class User constructor(_nickname: String){ // the same
//    val nickname: String = _nickname
//}

open class User (val nickname: String,  // the same
            val isSubscribed: Boolean = true) // with default value

class TwitterUser(nickname: String) : User(nickname)

fun main(){
    val alice = User("Alice")
    println(alice.isSubscribed)
    val bob = User("Bob", isSubscribed = false)
    println(bob.isSubscribed)
}

class Secretive private constructor() // can't create constructor outside

//class MyButton : View {
//    constructor(ctx: Context)
//    : super (ctx) {
//        // some code
//    }
//      constructor(ctx: Context, attr: AttributeSet)
//      : this (ctx){
//          // some code
//      }
//}