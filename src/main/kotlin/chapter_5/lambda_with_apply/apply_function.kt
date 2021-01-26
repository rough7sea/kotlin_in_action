package chapter_5.lambda_with_apply

fun alphabet_2() = StringBuilder().apply {
    for (letter in 'A' .. 'Z')
        append(letter)
    append("\nNow I know the alphabet!")
}.toString()

fun alphabet_3() = buildString { // simpler
    for (letter in 'A' .. 'Z')
        append(letter)
    append("\nNow I know the alphabet!")
}

fun main() {
    println(alphabet_2())
}
