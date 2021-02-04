package chapter_8

fun lookForAlice(people: List<Person>){
    people.forEach {
        if (it.firstName == "Alice"){
            println("Found!")
            return // non-local return
        }
    }
    println("Alice not found")
}

//fun lookForAlice(people: List<Person>){
//    people.forEach label@{
//        if (it.firstName == "Alice"){
//            println("Found!")
//            return@label // label return
//        }
//    }
//    println("Alice not found")
//}

//fun lookForAlice(people: List<Person>){
//    people.forEach {
//        if (it.firstName == "Alice"){
//            println("Found!")
//            return@forEach // local return
//        }
//    }
//    println("Alice not found")
//}

fun lookForBob(people: List<Person>){
    people.forEach(fun (person){
        if (person.firstName == "Bob") return
        println("${person.firstName} in not Bob")
    })
}

fun main() {

    people.filter(fun (person): Boolean{
        return person.age < 30
    })

    people.filter(fun (person) = person.age < 30) // the same

}