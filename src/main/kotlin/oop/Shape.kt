package oop

abstract class Shape(var name: String) {
    abstract fun calculatePerimeter(): Double

    abstract fun calculateArea(): Double

    override fun toString(): String {
        return "$name perimeter = ${calculatePerimeter()} and area = ${calculateArea()}"
    }
}