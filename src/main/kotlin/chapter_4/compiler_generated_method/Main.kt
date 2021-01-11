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
}

fun main() {
    val client1 = Client("Alice", 35424)
    val client2 = Client("Alice", 35424)
    println(client1)
    println(client1 == client2)

}