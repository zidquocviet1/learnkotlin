package oop

open class Student : Person, PersonalHygiene {
    override val age = 18
    override val wakeUpTime: String = "6:00 AM"
    override val prop: Int = 10
    val <T> List<T>.lastIndex: Int // Extension properties are not allowed initialization
        get() = this.size - 1

    var grade = 3
        set(value) {
            if (value > 0)
                field = value
        }
    lateinit var username: String

    init {
        println("Init block is called")
    }

    constructor() : super()

    constructor(name: String) : super(name) {
        println("Constructor block is called")
        println(grade)
        username = "test"
    }

    // Use the final keyword to not allowed the class member override it
    final override fun getTitle(): String {
        return "Student"
    }

    override fun brushHair() {
        TODO("Not yet implemented")
    }

    override fun clean() {
        TODO("Not yet implemented")
    }

    override fun brushTeeth() {
        super.brushTeeth()
        super.brushTeeth()
    }

    // Extension functions
    // Example: Swap 2 element in the list
    fun MutableList<Int>.swap(i1: Int, i2: Int) {
        this[i1] = this[i1] xor this[i2]
        this[i2] = this[i1] xor this[i2]
        this[i1] = this[i1] xor this[i2]
    }

    fun helperSwap(list: MutableList<Int>, i1: Int, i2: Int) {
        list.swap(i1, i2)
    }

    fun Person.getName() = "Person"
    fun Student.getName() = "Student"

    fun printClassName(p: Person) {
        println(p.getName())
    }
}