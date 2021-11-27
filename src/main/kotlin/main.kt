import basic.Condition
import basic.Looper
import oop.Rectangle
import oop.Square

fun sum(a : Int, b : Int): Int {
    return a + b
}

fun sumInferred(a: Int, b: Int) = a + b

// void return type function
fun voidFunc(a: Int, b: Int): Unit {
    println("Called in void function with type Unit with a = $a, b = $b")
}

fun voidFuncOmittedUnit(a: Int, b: Int) {
    println("Called void function with the Unit value is omitted and sum of a and b is ${a + b}")
}

fun main() {
    val a = 10
    val b = 20
    var c: Int = a + 20

    println("Sum of two number = ${sum(a, b)}")
    println("Sum of two number inferred = ${sumInferred(b, c)}")
    voidFunc(a, c)
    voidFuncOmittedUnit(b, c)

    // Exercise with loop
    println()
    println("*".repeat(20) + " Exercise with loop (For, While) " + "*".repeat(20))
    Looper.forEachItem()
    Looper.forEachItemUsingIndex()
    Looper.forEachItemUsingIndexAndForRange(start = 3)
    Looper.forEachUsingDownTo(to = 1, step = 2)
    Looper.forEachUsingWithIndex()
    Looper.whileLoop()
    Looper.doWhileLoop()
    Looper.forLoopUsingBreak()
    Looper.forLoopUsingReturn()
    Looper.forLoopUsingReturnWithLabel()

    // Exercise with condition
    println()
    println("*".repeat(20) + " Exercise with condition (if-else, when) " + "*".repeat(20))
    println("Is a larger than b? ${Condition.maxExpression(10, 5)}")
    println("The number is picked up: ${Condition.ifReturnWithBranches(5, 10)}")
    Condition.exampleUsingWhen(1)
    Condition.exampleUsingWhen(3)
    Condition.whenMixFor(listOf(-1, 0, 19, 4, 12, 5, 1))
    println("Return item in when condition with value is: ${Condition.whenReturnItem(listOf(-1, 0, 19, 4, 12, 5, 1), 7)}")
    Condition.whenCheckVarType("String")
    Condition.whenCheckVarType(1)
    Condition.whenCheckVarType(1.0)
    Condition.whenCheckVarType(Int.MAX_VALUE.toByte())
    Condition.whenCheckVarType(listOf(Byte.MAX_VALUE))
    println(Condition.returnValueWithNullSafety(null))
    println(Condition.returnValueWithNullSafety(name = "Mai Quoc Viet"))
    println(Condition.checkValueWithNothingType("aba"))
}