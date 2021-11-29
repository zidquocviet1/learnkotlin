package oop

// Sealed class/interface are abstract by itself
sealed class IOError {
    constructor() // Protected by default

    private constructor(msg: String) // Private constructor is OK

//    public constructor(msg: String, a: Int) Public and internal are not allowed
}
