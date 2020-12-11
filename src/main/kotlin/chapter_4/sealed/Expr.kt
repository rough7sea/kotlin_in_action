package chapter_4.sealed

sealed class Expr{
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int = //only two options of realization
        when(e){
            is Expr.Num -> e.value
            is Expr.Sum -> eval(e.right) + eval(e.left)
        }

