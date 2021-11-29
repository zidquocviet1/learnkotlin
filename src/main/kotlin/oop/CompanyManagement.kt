package oop

fun main() {
    val viet = Student("Mai Quoc Viet")
    val phap = Student()

    val list = mutableListOf(1, 2, 3, 4, 5)
    list.forEach { print("$it ")}
    println()
    phap.helperSwap(list, 1, 2)
    list.forEach{ println("$it ")}

    phap.printClassName(phap)

    val stringList = listOf("java", "android", "kotlin")
    println(stringList.getLongestString())
}