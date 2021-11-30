package oop.inline

import javax.swing.tree.TreeNode

class ResizableView(var width: Int, var height: Int) {
    fun resize(width: Width, height: Height) {
        this.width = width.value
        this.height = height.value
    }
}

inline fun close(work: String, process: (String) -> Unit) {
    process(work)
    println("close")
}

// Reified in inline function
inline fun <reified T> TreeNode.findParentOfType(): T? {
    var p = parent
    while (p != null && p !is T) {
        p = p.parent
    }
    return p as T?
}

fun main() {
    val view = ResizableView(1080, 2340)
    val newWidth = Width(120)
    val newHeight = Height(120)

    view.resize(newWidth, newHeight)

    close("coding") {
        println(it)
    }
}