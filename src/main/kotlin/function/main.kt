package function

import java.util.concurrent.locks.Lock

// With the lambda function argument in the last index, can pass it using {}
fun foo(
    bar: Int = 0,
    baz: Int = 1,
    qux: () -> Unit
) {
    qux()
}

// Similar to String... in java
fun bar(vararg strings: String) {
    println("Size of the vararg = ${strings.size}")
}

// Infix function
// Must have single parameter, no default value, not acceptable number as argument
// Must be a member function or extension functions
infix fun Int.shl(x: String): String = "$x: $this"

// Local functions: A functions inside other functions
fun dfs(x: Int, a: String) {
    fun dfs(y: String): String {
        return if (y.isBlank()) "Undefined" else y
    }

    println("${dfs(a)}: $x")
}

/*
* Higher-order function
* That is a function that takes parameters as functions or returns a functions
* Nullable functions are accepted using (function)?
* */
fun <T, R> Collection<T>.fold(
    initialize: R,
    combine: (acc: R, nextElement: T) -> R
): R {
    var accumulator = initialize
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

class IntTransformer: (Int) -> Int {
    override fun invoke(p1: Int): Int {
        TODO("Not yet implemented")
    }
}

inline fun <T> lock(lock: Lock, body: () -> T): T {
    return body()
}

inline fun foo(inlined: () -> Unit, noinline notInlined: () -> Unit) {

}

fun main() {
    foo(2) { println("a") }
    foo(qux = { println("b") })
    foo {
        println("c")
    }
    bar("a", "b", "c")

    println(1 shl "x")
    println(2.shl("y"))

    dfs(10, "")

    val list = listOf("a", "b", "c")
    val joinToInit = list.fold("Init") {
        acc, nextElement ->
        "$acc $nextElement"
    }
    list.forEach { println(it) }
    joinToInit.forEach { println(it) }

    val intFunction: (Int) -> Int = IntTransformer()
    val a = {i: Int -> i + 1} // The inferred type is (Int) -> Int
    val b = a(10)
    println("The value b in call from function a = $b")

    val stringRepeatFun: String.(Int) -> String = { this.repeat(it) }
    val repeatTwoParameters: (String, Int) -> String = stringRepeatFun

    fun runTransform(f: (String, Int) -> String): String {
        return f("-", 10)
    }

    println("*".stringRepeatFun(10))
    println(repeatTwoParameters("#", 10))
    println(runTransform(stringRepeatFun))
}