package oop

interface Source<out T> {
    fun nextT(): T
}

interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun copy(from: Array<out Any>, to: Array<Any>) {

}

// out String corresponds to <? extends String> in java
fun copy1(from: Array<out String>, to: Array<Int>) {

}

// in String corresponds to <? super String> in java
fun copy2(from: Array<in String>, to: Array<Int>) {

}

fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
        return list.filter { it > threshold }.map { it.toString() }
}

fun <T : kotlin.Comparable<T>> sort(list: List<T>) {

}

// Star projection
interface Generic<in T, out E> {
    fun apply(value: T): E
}

// Generic with extension functions
fun <T> T.everythingToString(): String {
    return this.toString()
}

fun main() {
    val strs = object : Source<String> {
        override fun nextT(): String {
            return "string generic"
        }
    }

    val a = object : Source<Any> {
        override fun nextT(): Any {
            return Any()
        }
    }

    val objects: Source<Any> = strs
//    val b: Source<String> = a // This is not allow

    val numberList = object : Comparable<Number> {
        override fun compareTo(other: Number): Int {
            return 1
        }
    }

    numberList.compareTo(1.0)
    val double: Comparable<Double> = numberList

    copy(arrayOf(1, 2, 3, 4), arrayOf(1, 2, 3, 4))
    copy1(arrayOf("a", "b", "c"), arrayOf(1, 2, 3, 4))
    copy2(arrayOf("a", "b", "c"), arrayOf(1, 2, 3, 4))

    sort(listOf("a", "b", "c"))
//    sort(listOf(HashMap<Int, String>)) this is error because it not compatible with generic type

    val nothingToString: Generic<*, String> // This mean Generic<in Nothing, String>
    val intToAny: Generic<Int, *> // This mean Generic<in Int, out Any?>
    val nothingToAny: Generic<*, *> // This mean Generic<in Nothing, out Any?>

    // Generic extension functions
    val oneString = 1.everythingToString()
    val doubleString = 1.0.everythingToString()

    println("One String: $oneString")
    println("Double String: $doubleString")
}