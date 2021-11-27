class Square(val a: Int): Shape(name = "Square") {
    var b: Int = 0

    constructor(a: Int, b: Int) : this(a) {
        this.b = b
    }

    override fun calculatePerimeter() = 4 * a.toDouble()

    override fun calculateArea() = a.times(a).toDouble()
}