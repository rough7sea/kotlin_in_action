package chapter_7

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

//class Foo {
//    var p: Type by Delegate()
//}

class Email {}
fun loadEmails(person: Person1): List<Email>{
    println("Load emails for ${person.name}")
    return listOf()
}

//class Person1(val name: String){ // standard realization
//    private var _emails: List<Email>? = null // backing property
//    val emails: List<Email>
//    get() {
//        if (_emails == null)
//            _emails = loadEmails(this)
//        return _emails!!
//    }
//}

class Person1(val name: String){
    val emails by lazy { loadEmails(this) }
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeSupportListener(listener: PropertyChangeListener){
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeSupportListener(listener: PropertyChangeListener){
        changeSupport.removePropertyChangeListener(listener)
    }
}

class Person2(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

//    private val _age = ObservableProperty("age", age, changeSupport) // old code
//    var age: Int
//        get() = _age.getValue()
//        set(value) { _age.setValue(value)}
//
//    private val _salary = ObservableProperty("salary", age, changeSupport)
//    var salary: Int
//        get() = _salary.getValue()
//        set(value) { _salary.setValue(value) }

//    var age: Int by ObservableProperty(age, changeSupport)
//    var salary: Int by ObservableProperty(salary, changeSupport)

    private val observer = {
            prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)

}

class ObservableProperty(
    var propValue: Int,
    private val changeSupport: PropertyChangeSupport
){
    operator fun getValue(p: Person2, prop: KProperty<*>): Int = propValue

    operator fun setValue(p: Person2, prop: KProperty<*>, newValue: Int){
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class Person3 {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

//    val name: String // old variant
//        get() = _attributes["name"]!!

    val name: String by _attributes
}


fun main() {
    val p = Person1("Alice")
    p.emails
    p.emails

    val p2 = Person2("Me", 20, 4000)
    p2.addPropertyChangeSupportListener { event ->
        println(
            "property ${event.propertyName} changed " +
                    "from ${event.oldValue} to ${event.newValue}"
        )
    }

    p2.age = 35
    p2.salary = 5000

    val p3 = Person3()
    val data = mapOf("name" to "Me", "company" to "Sweet kingdom")
    for ((attrName, value) in data){
        p3.setAttribute(attrName, value)
    }
    println(p.name)
}
