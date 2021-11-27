// Inline constructor
class Rectangle(private val width: Int, private val height: Int) : Shape(name = "Rectangle") {

    override fun calculatePerimeter(): Double {
        return 2 * (width + height).toDouble()
    }

    override fun calculateArea() = width.times(height).toDouble()
}