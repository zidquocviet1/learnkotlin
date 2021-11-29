package oop.enum

import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator {
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    },

    PLUS {
        override fun apply(t: Int, u: Int): Int = t + u
    };

    override fun applyAsInt(left: Int, right: Int): Int = apply(left, right)
}

fun main() {
    val a = 10
    val b = 3
    for (f in IntArithmetics.values()) {
        println("$f($a, $b) = ${f.apply(a, b)}")
    }

    for (f in IntArithmetics.values()) {
        println(f.name)
    }
}