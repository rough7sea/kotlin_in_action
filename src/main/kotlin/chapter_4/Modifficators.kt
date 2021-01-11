package chapter_4

open class RichButton : Clickable {

    fun disable(){}

    open fun animate() {}

    final override fun click() {}

}

abstract class Animated{
    abstract fun animated()

    open fun stopAnimating(){}

    fun animaTwice(){}
}

internal open class TalkativeButton : Focusable{
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//fun TalkativeButton.giveSpeech(){ // error -  internal!
//    yell() // error - private!
//    whisper() // error - protected!
//}

class LengthCounter{
    var counter: Int = 0 // can't be set outside
    private set
    fun addWord(word: String){
        counter += word.length
    }
}
