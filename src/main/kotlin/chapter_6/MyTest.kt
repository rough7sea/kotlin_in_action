package chapter_6

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MyTest{
    private lateinit var myService: MyService

    @Before
    fun setUp(){
        myService = MyService()
    }

    @Test
    fun testAction(){
        Assert.assertEquals("foo",
            myService.performAction())
    }

}

class MyService{
    fun performAction(): String = "foo"
}