package chapter_9

fun printContents(list: List<Any>){
    println(list.joinToString())
}

fun addAnswer(list: MutableList<Any>){
    list.add(42)
}

interface Producer<out T>{ // out -> declare class covariant
    fun produce(): T
}

open class Animal {
    fun feed() { }
}

//class Herd<out T : Animal>{
//    private val animals = mutableListOf<T>()
//    val size: Int get() = animals.size
//    operator fun get(i: Int): T { return animals[i] }
//}

class Herd<Animal>{
    private val animals = mutableListOf<Animal>()
    val size: Int get() = animals.size
    operator fun get(i: Int): Animal { return animals[i] }
    operator fun add(animal: Animal) {}
}

fun feedAll(animals: Herd<Animal>){
    for (i in 0 until animals.size){
        animals[i].feed()
    }

}

class Cat: Animal(){
    fun cleanLitter(){}
}

fun takeCareOfCats(cats: Herd<Cat>){
    for (i in 0 until cats.size){
        cats[i].cleanLitter()
    }
    feedAll(cats) // get Herd<Cat> when require Herd<Animal> if out in Herd<out T: Animal> not exist
}


fun main() {
    printContents(listOf("abc", "bac"))
    val strings = mutableListOf("abc", "bac")
//    addAnswer(strings) //
}