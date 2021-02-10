package chapter_10

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import ru.yole.jkid.JsonExclude
import ru.yole.jkid.JsonName
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize

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

fun main() {
    val person = Person("Alice", 29)
    val strPerson = serialize(person);
    println(strPerson)
    println(deserialize<Person>(strPerson))

}