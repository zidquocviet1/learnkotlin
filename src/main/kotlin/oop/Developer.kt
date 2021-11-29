package oop

class Developer(
    override val prop: Int,
    override val wakeUpTime: String
) : PersonalHygiene {
    override fun brushTeeth() {
    }

    override fun brushHair() {
    }

    val run = KRunnable { println("Called from functional interfaces") }
}