package oop.outerAndNested

interface OuterInterface {
    class InnerClass {
        private val foo: Int = 10

        fun foo() = 2
    }

    interface InnerInterface {
        fun foo()
        fun bar()
    }
}