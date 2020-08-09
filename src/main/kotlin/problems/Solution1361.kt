package problems

fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
    val parentCountArray = IntArray(n)
    for (i in 0 until n) {
        if (!addParentCountAndValidate(leftChild[i], parentCountArray)) return false
        if (!addParentCountAndValidate(rightChild[i], parentCountArray)) return false
    }
    val rootCount = parentCountArray.count { it == 0 }
    return rootCount == 1
}

fun addParentCountAndValidate(node: Int, parentCountArray: IntArray): Boolean {
    if (node != -1) {
        parentCountArray[node]++
        if (parentCountArray[node] > 1) return false
    }
    return true
}
