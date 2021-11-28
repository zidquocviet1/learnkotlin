package basic

import java.util.Scanner

class ExceptionHandler {
    private var a: Int? = null

    fun inputA() {
        val scan = Scanner(System.`in`)
        val input = scan.nextLine().trim()

        try {
            a = input.toInt()
        } catch (e: NumberFormatException) {
            println("The input mismatch")
        }
    }

    fun checkUsernameLength(name: String?): Boolean {
        val validName = name ?: throw IllegalArgumentException()
        return validName.length > 8
    }
}

fun main() {
    val handler = ExceptionHandler()

//    handler.inputA()
    println(handler.checkUsernameLength("51800954@student.tdtu.edu.vn"))
    println(handler.checkUsernameLength("asdb"))
    println(handler.checkUsernameLength(null))
}