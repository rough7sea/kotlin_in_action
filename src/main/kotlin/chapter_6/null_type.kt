package chapter_6

fun strLen(s: String) = s.length
fun strLenSafe(s: String?): Int = s?.length ?: 0

fun printAllCaps(s : String?){
    val allCaps: String? = s?.toUpperCase()
//    val allCaps = s?.toUpperCase() // the same
//    val allCaps =  s == null ? s.toUpperCase() : null  // the same in java
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)

fun managerName(employee: Employee): String? =
    employee.manager?.name

class Address(val streetAddress: String, val zipcode: Int,
              val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(
    private val firstName: String,
    private val lastName: String = "",
    val company: Company?){
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false

        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}

fun Person.countryName(): String{
    val country = this.company?.address?.country
    return country ?: "Unknown" // ?: -> Elvis operator
}

fun printShippingLabel(person: Person){
    val address = person.company?.address
        ?: throw IllegalArgumentException("No address")
    with(address){
        println(streetAddress)
        println("$zipcode $city, $country")
    }
}

fun main() {
//    strLen(null) // error -> s can't be null
    println(strLenSafe(null))

    val x : String? = null
//    var y: String = x // can't assign x

    printAllCaps("abc")
    printAllCaps(null)

    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob", ceo)

    println("seo manager is ${managerName(ceo)}")
    println("developer manager is ${managerName(developer)}")

    val person = Person("Jeff", company = null)
    println(person.countryName())

    val address = Address("In my heart", 909, "SPb", "Russia")
    val myCompany = Company("Sweetland", address)
    val me = Person("Me", company = myCompany)

    printShippingLabel(me)

//    printShippingLabel(Person("Someone not in my company", company = null)) // no address exception

    println(person == Person("Jeff", company = null))
    println(person.equals(33))

}