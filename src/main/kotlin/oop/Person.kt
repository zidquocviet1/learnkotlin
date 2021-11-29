package oop

import java.time.LocalDateTime

open class Person {
    open val age: Int = 0

    constructor()
    constructor(name: String)
    constructor(name: String, gender: Boolean)
    constructor(name: String, gender: Boolean, birthday: LocalDateTime)

    open fun getTitle(): String = "Employee"

    open fun brushTeeth() {
        println("Brush brush")
    }
}