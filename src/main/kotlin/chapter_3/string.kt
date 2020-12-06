package chapter_3

import java.io.File
import java.lang.IllegalArgumentException

fun main(){
    println("12.345-6.A".split("[.\\-]".toRegex()))
    println("12.345-6.A".split(".","-"))

    val filePath = File("new_file.abc").absolutePath
    parsePath(filePath)
    parsePathWithRegex(filePath)
}

fun parsePath(path: String){
    val directory = path.substringBeforeLast("\\")
    val fullName = path.substringAfterLast("\\")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")

    println(kotlinLogo.trimMargin("."))
}

const val kotlinLogo =
        """| //
          .|//
          .|/ \"""

fun parsePathWithRegex(path: String){
    val regex = """(.+)\\(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null){
        val (directory, fileName, extension) = matchResult.destructured
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}

class User(val id: Int, val name: String, val address: String)

fun saveUserClassic(user: User){
    if(user.name.isEmpty()){
        throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Name")
    }

    if(user.address.isEmpty()){
        throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Address")
    }

    //saving
}

fun saveUserWithNestedFunction(user: User){
    fun validate(user: User,
                 value: String,
                 fieldName: String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user, user.name, "Name")
    validate(user, user.address, "Address")

    //saving
}

fun saveUserWithNestedFunction2(user: User){
    fun validate(value: String, fieldName: String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user ${user.id}: empty $fieldName")
        }
    }

    validate(user.name, "Name")
    validate(user.address, "Address")

    //saving
}

fun User.validateBeforeSave(){
    fun validate(value: String, fieldName: String){
        if (value.isEmpty()){
            throw IllegalArgumentException(
                    "Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")

    //saving
}
fun saveUserWithExtensionFunction(user: User){
    user.validateBeforeSave()
}