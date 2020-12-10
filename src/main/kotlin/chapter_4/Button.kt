package chapter_4

class Button: Clickable, Focusable{
    override fun click() = println("I was clicked!")

    //function must be realize to avoid conflict
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }

}

fun main(){
    val button = Button()
    button.showOff()
    button.setFocus(true)
    button.click()
}


