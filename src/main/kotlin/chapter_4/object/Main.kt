package chapter_4.`object`

import java.io.File

object Payroll{
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary(){
        for (person in allEmployees){
            // do something
        }
    }

}

object CaseInsensitiveFileComparator: Comparator<File>{
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }
}

data class Person(val  name: String){
    object NameComparator : Comparator<Person>{
        override fun compare(o1: Person, o2: Person): Int =
            o1.name.compareTo(o2.name)
    }
}

fun main() {
    println(CaseInsensitiveFileComparator.compare(
        File("/User"),File("/user") ))
    val persons = listOf(Person("Bob"), Person("Alice"))
    println(persons.sortedWith(Person.NameComparator))
}