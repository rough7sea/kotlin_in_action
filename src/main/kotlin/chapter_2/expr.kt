package chapter_2

interface Expr
class Num(val  value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun main(){
    println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}

// old eval
//fun eval(e: Expr): Int {
//    if (e is Num) {
//        val n = e as Num // явное приведение к типу, можно не писать
//        return n.value
//    }
//    if (e is Sum){
//        return eval(e.right) + eval(e.left)
//    }
//    throw IllegalArgumentException("Unknown expression")
//}

// better eval
//fun eval(e: Expr) : Int =
//        if (e is Num) e.value else
//            if (e is Sum) eval(e.right) + eval(e.left) else
//                throw IllegalArgumentException("Unknown expression")

// true eval
fun eval(e: Expr) : Int =
        when (e) {
            is Num -> e.value
            is Sum  -> eval(e.right) + eval(e.left)
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun evalWithLogging(e: Expr): Int =
        when(e){
            is Num -> {
                println("num ${e.value}")
                e.value
            }
            is Sum -> {
                val left = evalWithLogging(e.left)
                val right = evalWithLogging(e.right)
                println("sum: $left + $right")
                left + right
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }

