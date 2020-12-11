package chapter_4.inner

class Button : View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {}

    class ButtonState : State
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer  // ссылка на внешний класс
    }
}