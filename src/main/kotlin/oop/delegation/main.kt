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

typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)

fun main() {
    val b = BaseImpl(10)
    Derived(b).print()
    Derived(b).println()

    val f: (Int) -> Boolean = { it > 0 }
    val p: Predicate<Int> = { it > 0 }

    println(foo(f))
    println(listOf(-1, 2).filter(p))
}