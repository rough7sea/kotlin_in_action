package chapter_9

import java.util.*
import kotlin.reflect.KClass

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

class Herd<out T : Animal>{
    private val animals = mutableListOf<Animal>()
    val size: Int get() = animals.size
    operator fun get(i: Int): T { return animals[i] as T }
    operator fun set(i: Int, animal: Animal) { animals.add(animal)  }
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

fun <T> copyData(source: MutableList<T>, destination: MutableList<T>){
    for(item in source){
        destination.add(item)
    }
}

fun <T: R, R> copyData2(source: MutableList<T>, destination: MutableList<R>){
    for(item in source){
        destination.add(item)
    }
}

fun <T> copyData3(source: MutableList<out T>, // the same java MutableList<? extends T>
                  destination: MutableList<in T>){ // the same java MutableList<? super T>
    for(item in source){
        destination.add(item)
    }
}

fun printFirst(list: List<*>){
    if (list.isNotEmpty()){
        println(list.first())
    }
}

interface FieldValidator<in T> {
    fun validate(input: T): Boolean
}

object DefaultStringValidator : FieldValidator<String>{
    override fun validate(input: String): Boolean = input.isNotEmpty()
}

object DefaultIntValidator : FieldValidator<Int>{
    override fun validate(input: Int): Boolean = input >= 0
}

fun main() {
    printContents(listOf("abc", "bac"))
    val strings = mutableListOf("abc", "bac")
//    addAnswer(strings) //
    val cats = Herd<Cat>()
    cats[0] = Cat()
    cats[1] = Cat()
    takeCareOfCats(cats)

    val ints = mutableListOf(1, 2, 3)
    val anyItems = mutableListOf<Any>()
//    copyData(ints, anyItems) // can't be
    copyData2(ints, anyItems) // can be
    copyData3(ints, anyItems) // can be, kotlin like
    println(anyItems)

    val list: MutableList<Any?> = mutableListOf('a', 1, "qwe")
    val chars = mutableListOf('a', 'b', 'c')
    val unknownElements: MutableList<*> =
        if (Random().nextBoolean()) list else chars

    println(unknownElements.first())
    printFirst(listOf("Svetlana", "Dmitry"))

    val validator = mutableMapOf<KClass<*>, FieldValidator<*>>()
    validator[String::class] = DefaultStringValidator
    validator[Int::class] = DefaultIntValidator

    val stringValidator = validator[String::class] as FieldValidator<String>
    println(stringValidator.validate("c"))

    Validators.registerValidator(String::class, DefaultStringValidator)
    Validators.registerValidator(Int::class, DefaultIntValidator)
    println(Validators[String::class].validate("Kotlin"))
    println(Validators[Int::class].validate(42))
}

object Validators {
    private val validators =
        mutableMapOf<KClass<*>, FieldValidator<*>>()

    fun <T: Any> registerValidator(kClass: KClass<T>, fieldValidator: FieldValidator<T>){
        validators[kClass] = fieldValidator
    }

    @Suppress("UNCHECKED_CAST")
    operator fun <T: Any> get(kClass: KClass<T>): FieldValidator<T> =
        validators[kClass] as? FieldValidator<T>
            ?: throw IllegalArgumentException("No validator for ${kClass.simpleName}")
}

fun enumeratedCats(f: (Cat) -> Number) {} // <in Cat, out Number>

fun Animal.getIndex(): Int = 43
