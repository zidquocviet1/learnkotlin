package oop.delegation

interface Base {
    val message: String
    fun print()
    fun println()
}

class BaseImpl(private val x: Int) : Base {
    override val message: String = "BaseImpl: $x"
    override fun print() {
        print(message)
    }

    override fun println() {
        println(x)
    }
}

class Derived(b: Base) : Base by b {
    override val message: String = "Message of Derived"
    override fun print() {
        println(message)
    }
}

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
    Derived(b).println()
}