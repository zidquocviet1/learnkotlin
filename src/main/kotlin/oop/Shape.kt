package oop

abstract class Shape(var name: String) : Drawable{
    abstract fun calculatePerimeter(): Double

    abstract fun calculateArea(): Double

    override fun toString(): String {
        return "$name perimeter = ${calculatePerimeter()} and area = ${calculateArea()}"
    }
}