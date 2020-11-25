package chapter_2

fun main(){
    println(Color.INDIGO.rgb())
    println(getMnemonic(Color.INDIGO))
    println(getWarmth(Color.RED))
    println(mix(Color.GREEN, Color.RED))
    println(mixOptimized(Color.GREEN, Color.BLACK))
//    println(Color.RED.hex())
}

public enum class Color(
        val r: Int, val g: Int,val b: Int,
){
    RED(255, 0, 0), GREEN(0, 255, 0),
    BLACK(0, 0, 0), INDIGO(75, 0, 130);

    fun rgb() = (r * 256 + g) * 256 + b
//    fun hex() = "#${"%X".format(r)}${"%X".format(g)}${"%X".format(b)}"

}
fun getMnemonic(color: Color) =
        when (color){
            Color.RED -> "Красный"
            Color.BLACK -> "Черный"
            Color.GREEN -> "Зеленый"
            Color.INDIGO -> "Индиго"
        }

fun getWarmth(color: Color) = when(color){
    Color.RED -> "Теплый"
    Color.GREEN -> "Нейтральный"
    Color.BLACK, Color.INDIGO -> "Холодный"
}

fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)){
            setOf(Color.RED, Color.GREEN) -> "Yellow"
            setOf(Color.BLACK, Color.GREEN) -> "Dark Green"
            else -> throw Exception("dirty color")
        }


fun mixOptimized(c1: Color, c2: Color) =
        when {
            (c1 == Color.RED && c2 == Color.GREEN) ||
                    (c1 == Color.GREEN && c2 == Color.RED)-> "Yellow"
            (c1 == Color.BLACK && c2 == Color.GREEN) ||
                    (c1 == Color.GREEN && c2 == Color.BLACK)-> "Dark Green"
            else -> throw Exception("dirty color")
        }