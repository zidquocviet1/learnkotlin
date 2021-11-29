package oop

/*
* Functional interface (Single Abstract Method)
* It's mean the interface have exactly one fun method and start with fun before interface
* */
fun interface KRunnable {
    fun run() // Only one abstract method is accepted

    // More than one methods has body are accepted
    fun accept() {
    }
}