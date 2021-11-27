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

    val rectangle = Rectangle(5, 10)
    val square = Square(2, 10)
    val listShape = listOf(rectangle, square)

    for (item in listShape) {
        println(item.toString())
    }

    println("Value of b in the secondary constructor in Square = ${square.b}")
    println("Value of a in the primary constructor in Square class = ${square.a}")
}