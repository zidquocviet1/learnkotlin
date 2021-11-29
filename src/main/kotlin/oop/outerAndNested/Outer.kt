package oop.outerAndNested

import oop.outerAndNested.Outer.InnerInterface

class Outer {
    private var bar: Int = 1

    fun bar() {
        println("Bar")
    }

    fun interface InnerInterface {
        fun onClickListener(position: Int)
    }

    // Nested class just like static class in java
    class Nested {
        private val foo: Int = 2

        fun foo() {
            println("Foo")
        }
    }

    // Inner class can access the member of the outer class
    inner class Inner {
        fun foo() = bar

        fun a() {
            this@Outer.bar = 10
        }
    }
}

fun main() {
    val demo = Outer.Nested().foo()
    val demoBar = Outer().bar()
    val innerInterface = InnerInterface { position ->
        if (position == 0) {
            println("This is the first element")
        }
    }
    val outerInterface = OuterInterface.InnerClass().foo()
    val innerClass = Outer().Inner()

    println(innerClass.foo())
    innerClass.a()
    println(innerClass.foo())
}