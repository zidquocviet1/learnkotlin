package basic

class TypeHandler {
    /*
    * In Kotlin we have multiple of type variables such as:
    * 1. Byte(8 bit)
    * 2. Integer(32 bit)
    * 3. Long(64 bit)
    * 4. Short(16 bit)
    * 5. Float(32 bit)
    * 6. Double(64 bit)
    * 7. Decimal, Hexadecimal(Prefix: 0x), Binaries(Prefix: 0b)
    * Note that: Octal literals are not supported
    * */

    private val one = 1
    private val two = 2
    private val threeBillion = 3_000_000_000
    private val oneLong = 1L
    private val oneByte: Byte = 1
    private val pi = 3.14
    private val piFloat = 3.14f
    private val hexByte = 0xFF_AA_BB_CC
    private val twoByte = 0b0010
    private val unsignedOne: UInt = 1u
    private val charOne = '1'

    // Primitive type arrays
    private val x = IntArray(10) { 1 }
    private val i = IntArray(10) { it * 1 }
    private val y = DoubleArray(10)
    private val z = FloatArray(10)
    private val j = longArrayOf(10, 30, 20, 1, 4, 5, 1)

    fun boxing() {
        val boxedA: Int? = one
        val anotherBoxedA: Int? = one

        val b = 129
        val boxedB: Int? = b
        val anotherBoxedB: Int? = b

        println(boxedA === anotherBoxedA)
        println(boxedB === anotherBoxedB)
        println(boxedB == anotherBoxedB)
    }

    fun primitiveArrays() {
        println("Integer arrays with 10 element the same value is 1")
        x.forEach { print("$it ") }
        println()

        println("Integer arrays with 10 element the value same as index")
        i.forEach { print("$it ") }
        println()

        println("Double arrays with 10 element no values initialization")
        y.forEach {
            print("$it ")
        }
        println()

        println("Float arrays with 10 element no values initialization")
        z.forEach {
            print("$it ")
        }
        println()

        println("Long arrays with bunch of element initialization")
        j.forEach { print("$it ") }
        println()
    }

    // Type checks and casts section
    fun smartCast(x: Any) {
        if (x is String) {
            println("The parameter is type String and the length = ${x.length}")
        } else {
            println("The parameter is not type of String so can not check the length")
        }
    }

    fun unsafeCastNonNull(x: Any) {
        val name = x as String

        println("Name: $name")
    }

    fun unsafeCastNullable(x: Any?) {
        val name = x as String?

        println("Name: $name")
    }

    fun safeCast(x: Any) {
        val name = x as? String

        println("Name: $name")
    }
}

fun main() {
    val typeHandler = TypeHandler()

    typeHandler.boxing()
    typeHandler.primitiveArrays()
    typeHandler.smartCast("Mai Quoc Viet")
    typeHandler.smartCast(10)
    typeHandler.unsafeCastNullable("Mai Quoc Viet")
    typeHandler.unsafeCastNullable(null)
    typeHandler.unsafeCastNonNull("Mai Quoc Viet")
    typeHandler.safeCast(10)
}