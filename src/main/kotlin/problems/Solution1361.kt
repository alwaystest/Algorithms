package problems

fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
    val parentCountArray = IntArray(n)
    for (i in 0 until n) {
        if (!parentCountValid(leftChild[i], parentCountArray)) return false
        if (!parentCountValid(rightChild[i], parentCountArray)) return false
    }
    TODO()
}

fun parentCountValid(node: Int, parentCountArray: IntArray): Boolean {
    TODO("Not yet implemented")
}
