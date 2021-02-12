package chapter_11

import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import java.time.LocalDate
import java.time.Period

class Greeter(val greeting: String){
    operator fun invoke(name: String){
        println("$greeting, $name!")
    }
}

data class Issue(
    val id : String, val project: String, val type: String,
    val priority: String, val description: String
)

class ImportantIssuePredicate(val project: String) : (Issue) -> Boolean {
    override fun invoke(issue: Issue): Boolean {
        return issue.project == project && issue.isImportant()
    }
    private fun Issue.isImportant(): Boolean {
        return type == "Bug" &&
                (priority == "Major" || priority == "Critical")
    }
}

class DependencyHandler {
    fun compile(coordinate: String) {
        println("Added dependency on $coordinate")
    }

    operator fun invoke(body: DependencyHandler.() -> Unit){
        body()
    }
}
//object ago
//
//infix fun Int.days(t: ago): Period = TimeWrapper()(this)
//
//class TimeWrapper{
//    operator fun invoke(value: Int): Period = Period.ofDays(value)
//}
val Int.days: Period
    get() = Period.ofDays(this)

val Period.ago : LocalDate
    get() = LocalDate.now() - this

val Period.fromNow : LocalDate
    get() = LocalDate.now() + this

object Country : Table(){
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
    override val primaryKey = PrimaryKey(id)
}



fun main() {
    val helloGreeter = Greeter("Hello")
    helloGreeter("Danila")

    val i1 = Issue("IDEA-123","IDEA", "Bug", "Major",
        "Save failed")
    val i2 = Issue("KT-1234","Kotlin", "Feature", "Normal",
        "Something strange")

    val predicate = ImportantIssuePredicate("IDEA")
    for (issue in listOf(i1, i2).filter(predicate)){
        println(issue.id)
    }

    val y = 1.days.ago
    val t = 1.days.fromNow

    println("y is $y and t is $t")

//    SchemaUtils.create(Country)

}
