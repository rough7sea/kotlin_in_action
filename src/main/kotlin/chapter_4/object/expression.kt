package chapter_4.`object`

import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

fun main() {
    val listener = object : MouseAdapter(){
        override fun mouseClicked(e: MouseEvent?) {
            // do something
        }

        override fun mouseEntered(e: MouseEvent?) {
            // do something
        }
    }
}

fun countClick(window: Window){
    var clickCount = 0;

    window.addMouseListener(object : MouseAdapter(){
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++;
        }
    })
}