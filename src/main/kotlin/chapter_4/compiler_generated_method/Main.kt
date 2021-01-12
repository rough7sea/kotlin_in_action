package chapter_4.compiler_generated_method

class Client(val name: String, val postalCode: Int){
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client)
            return false
        return name == other.name &&
                postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode

    fun copy(name: String = this.name,
             postalCode: Int = this.postalCode) = Client(name, postalCode)
}

data class Client1(val name: String, val postalCode: Int)

fun main() {
    val client1 = Client("Alice", 35424)
    val client2 = Client("Alice", 35424)
    println(client1)
    println(client1.copy(postalCode = 123))
    println(client1 == client2)

    val cl1 = Client1("Alice", 35424)
    val cl2 = Client1("Alice", 35424)
    println(cl1)
    println(cl1.copy(postalCode = 123))
    println(cl1 == cl2)

}