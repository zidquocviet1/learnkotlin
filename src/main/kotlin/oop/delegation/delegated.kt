package oop.delegation

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class Example {
    var s: String by Delegate()
}

class Delegate {
    operator fun getValue(example: Example, property: KProperty<*>): String {
        return "$example, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(example: Example, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $example.")
    }
}

class User {
    var nameObserver: String by Delegates.observable("User ABC") { _, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
    var password: String by Delegates.vetoable("12345678") { _, oldValue, newValue ->
        oldValue != newValue
    }
    var age: Int by Delegates.vetoable(0) { _, oldValue, newValue ->
        oldValue < newValue
    }
}

class ClassWithDelegate(val anotherClassInt: Int) {

}

var topLevelInt: Int = 0

// Using the '::' before the property are delegated
class MyClass(var memberInt: Int, private val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}

var MyClass.extDelegated: Int by ::topLevelInt

// Storing properties in a map, just like parsing JSON
class Message(private val map: Map<String, Any?>) {
    val content: String by map
    val id: Int by map

    fun print() {
        println("The content: $content with id: $id")
    }
}

fun localDelegated(computeFoo: () -> Int) {
    val memoizedFoo: Int by lazy(computeFoo)

    if (memoizedFoo > 10) {
        println("The value is accepted")
    }
}

fun main() {
    val example = Example()
    println(example.s)
    example.s = "NEW"

    // Lazy delegate will call the callback function and remember the value, the subsequent will return remember value
    // By default, lazy property is synchronized, it is computed in one thread, and others will see the same value
    val lazyValue: String by lazy {
        println("First call to lazy")
        "Hello"
    }

    println(lazyValue)
    println(lazyValue)

    val user = User()
    println(user.nameObserver)
    println(user.password)

    user.nameObserver = "Mai Quoc Viet"
    user.password = "1234"
    println(user.password)

    println(user.age)
    user.age = 10
    println(user.age)
    user.age = 5
    println(user.age)

    val myClass = MyClass(20, ClassWithDelegate(30))
    println(myClass.delegatedToMember)
    println(myClass.delegatedToTopLevel)

    val message = Message(
        mapOf(
            "content" to "Hello",
            "id" to 123123
        )
    )

    message.print()

    localDelegated { 20 }
}