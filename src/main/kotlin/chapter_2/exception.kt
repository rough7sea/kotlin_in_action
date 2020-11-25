package chapter_2

import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException

fun main(){
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
    println(readNumber(BufferedReader(StringReader("not a number"))))
}

//val percentage =
//        if (number in 0..100)
//            number
//        else
//            throw IllegalArgumentException(
//                    "A percentage value must be between 0 and 100: $number"
//            )
//if (percentage !in 0..100){
//    throw IllegalArgumentException(
//            "A percentage value must be between 0 and 100: $percentage"
//    )
//}

fun readNumber(reader: BufferedReader): Int?{
    return try {
        val line = reader.readLine();
        Integer.parseInt(line)
    } catch (e: NumberFormatException){
        null
    }
    finally {
        reader.close()
    }
}