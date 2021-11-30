package oop.objects

// Every new object is created that basically extends from Any
val helloWorldObject = object {
    val hello = "Hello"
    val world = "World"

    override fun toString(): String = "$hello $world"
}

open class A {
    private fun getObject() = object {
        private val x = "x"
        val y = "y"
    }

    fun getAnotherObject() = object {
        val x = "x"
    }

    open fun call() {
        println("Call from A")
    }

    // Can not access to private properties in object
    fun printObject() {
        println(getObject().y)
    }
}

interface B {
    fun run()
}

// If the object is extend or implement multiple class/interface. We must specify return type
val cObject: B = object : A(), B {
    override fun call() {
        println("Call from C")
    }
    override fun run() {
        call()
    }
}

fun accessTypeFromObject() {
    var a: Int? = null

    val o = object {
        fun increaseA() {
            a?.let { a++ }
        }
    }
}

interface Factory<T> {
    fun create(): T
}

class ViewModel {
    companion object : Factory<ViewModel> {
        override fun create(): ViewModel = ViewModel()
    }
}

fun main() {
    println(helloWorldObject)
    cObject.run()
    A().getAnotherObject()
    val userViewModel = ViewModel.create()
}