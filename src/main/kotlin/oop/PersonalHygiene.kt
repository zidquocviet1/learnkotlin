package oop

interface PersonalHygiene {
    val prop: Int // Abstract property
    val wakeUpTime: String
    val propertyWithImplementation: String
        get() = "foo"

    fun brushTeeth()
    fun brushHair()
    fun clean() {
        // Optional body
    }
}