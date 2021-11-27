package basic

class Condition {
    /*
    * In kotlin we have the if-else and when(also known as switch-case) condition
    * */

    companion object {
        fun maxExpression(a: Int, b: Int): Boolean {
            val max = if (a > b) a else b
            return max == a
        }

        fun ifReturnWithBranches(a: Int, b: Int): Int {
            return if (a > b) {
                print("A is larger than B ")
                a
            } else {
                print("B is larger than A ")
                b
            }
        }

        fun exampleUsingWhen(a: Int) {
            when (a) {
                -1 -> println("Smaller")
                0 -> println("Equals")
                1 -> println("Larger")
                else -> println("Illegal argument")
            }
        }

        fun whenMixFor(numbers: List<Int>) {
            for (number in numbers) {
                when (number % 2) {
                    0 -> println("$number is even")
                    1 -> println("$number is odd")
                    else -> println("$number is invalid")
                }
            }
        }

        fun whenReturnItem(numbers: List<Int>, index: Int): Int? {
            return when (index) {
                !in numbers.indices -> null
                else -> numbers[index]
            }
        }

        // Using is keyword to check the type of object(Any) the same with instance of
        fun whenCheckVarType(x: Any) {
            when (x) {
                is String -> println("Input value is type String")
                is Int -> println("Input value is type Integer")
                is Double -> println("Input value is type Double")
                is Float -> println("Input value is type Float")
                is Byte -> println("Input value is type Byte")
                else -> println("Others type")
            }
        }

        fun checkValueWithNothingType(name: String?): String {
            return name ?: throw IllegalArgumentException("Name required")
        }

        fun returnValueWithNullSafety(name: String?): Int? {
            return name?.length
        }
    }
}