package chapter_5.lambda_with_apply

import java.lang.StringBuilder

//fun alphabet(): String { // standard realization
//    val result = StringBuilder()
//    for (letter in 'A'..'Z'){
//        result.append(letter)
//    }
//    result.append("\nNow I know the alphaebt!")
//    return result.toString()
//}

//fun alphabet(): String { // 'with' realization
//    val stringBuilder = StringBuilder()
//    return with(stringBuilder) { // the same as with(strBuilder, {...})
//        for (letter in 'A'..'Z'){
//            this.append(letter)
//            // append(letter) // can be without 'this'
//        }
//        this.append("\nNow I know the alphabet!")
//        this.toString()  // return value
//    }
//}

fun alphabet() = with(StringBuilder()){ // final short version
    for (letter in 'A'..'Z'){
        append(letter)
    }
    this.append("\nNow I know the alphabet!")
    toString()
}


fun main() {
    println(alphabet())
}