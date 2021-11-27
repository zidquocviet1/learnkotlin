package basic

class Looper {
    /*
    * For loop in kotlin
    * We have two types of for loop:
    * 1. Foreach item using "in" keyword
    * 2. Traversal each item using index
    * */

    /*
    * While and do-While loop in kotlin
    * */

    // Using the companion object to access the static field, or methods
    // According to the official coding convention. The companion object should be at the end of class
    companion object {
        private val listItem = listOf("java", "kotlin", "android", "intellij")

        fun forEachItem() {
            println("For each item using in keyword")
            for (item in listItem) {
                println("Item with index at: ${listItem.indexOf(item)}, value: $item")
            }
        }

        fun forEachItemUsingIndex() {
            println("For each item using indices")
            for (index in listItem.indices) {
                println("Item with index at: $index, value: ${listItem[index]}")
            }
        }

        fun forEachItemUsingIndexAndForRange(start: Int) {
            println("For each item using Range")
            for (i in start until listItem.size) {
                println("Item with index at $i, value: ${listItem[i]}")
            }
        }

        fun forEachUsingDownTo(to: Int, step: Int) {
            println("For each item using DownTo and Step")
            for (i in listItem.size - 1 downTo to step step) {
                println("Index at $i, value: ${listItem[i]}")
            }
        }

        fun forEachUsingWithIndex() {
            println("For each item using withIndex")
            for ((index, value) in listItem.withIndex()) {
                println("The element at $index is $value")
            }
        }

        fun whileLoop() {
            println("For each item using while loop")

            var i = 0
            while (i < listItem.size) {
                println("The element at $i is ${listItem[i++]}")
            }
        }

        fun doWhileLoop() {
            println("For each item using do-while loop")

            var i = 0
            do {
                println("The element at $i is ${listItem[i++]}")
            } while (i < listItem.size)
        }

        // @ it's mean label is used in break and return in loop
        fun forLoopUsingBreak() {
            loop@ for (i in 0..100) {
                println("Value of i = $i")
                for (j in i..i + 10) {
                    println("Value of j = $j")
                    if (j == 20) break@loop
                }
            }
        }

        fun forLoopUsingReturn() {
            println("Return from for loop")
            listItem.forEach {
                if (it == "java") return
                println(it)
            }
            println("this point is unreachable")
        }

        // When using label in for loop, it's mean the condition value is omitted otherwise the others keep going process
        fun forLoopUsingReturnWithLabel() {
            println("Return from for loop with label")
//            listItem.forEach lit@{
//                if (it == "java") return@lit
//                println(it)
//            }

            // or can use
            listItem.forEach {
                if (it == "java") return@forEach
                println(it)
            }
            println("this point is unreachable")
        }
    }
}
