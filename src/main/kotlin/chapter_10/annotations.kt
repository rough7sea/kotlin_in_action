package chapter_10

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import ru.yole.jkid.*
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import java.util.*

@Deprecated("use removeAt(index) instead.", ReplaceWith("removeAt(index)"))
fun remove(index: Int) {}

fun removeAt(index: Int){}

class HasFolder{
    @get:Rule
    val folder = TemporaryFolder()

    @Test
    fun testUsingTempFolder(){
        val createdFile = folder.newFile("myfile.txt")
        val createFolder = folder.newFolder("subfolder")
    }
}

data class Person(
    @JsonName("alias") val firstName: String,
    @JsonExclude val age: Int? = null)

interface Company{
    val name: String
}

data class CompanyImpl(override val name: String): Company

data class Person2(
    val name: String,
    @DeserializeInterface(CompanyImpl::class) val company: Company)

data class Person3(
    val name: String,
    @CustomSerializer(DateSerializer::class) val company: Company)

class DateSerializer : ValueSerializer<Date>{
    override fun fromJsonValue(jsonValue: Any?): Date {
        TODO("Not yet implemented")
    }

    override fun toJsonValue(value: Date): Any? {
        TODO("Not yet implemented")
    }
}

fun main() {
    val person = Person("Alice", 29)
    val strPerson = serialize(person);
    println(strPerson)
    println(deserialize<Person>(strPerson))

}