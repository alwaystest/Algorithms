package problems

fun validateBinaryTreeNodes(n: Int, leftChild: IntArray, rightChild: IntArray): Boolean {
    val parentCountArray = IntArray(n)
    for (i in 0 until n) {
        if (!addParentCountAndValidate(leftChild[i], parentCountArray)) return false
        if (!addParentCountAndValidate(rightChild[i], parentCountArray)) return false
    }
    var rootCount = 0
    var root = -1
    parentCountArray.forEachIndexed { index, parentCount ->
        if (parentCount == 0) {
            rootCount++
            root = index
            if (rootCount > 1) return false
        }
    }
    if (root == -1) return false
    val visited = BooleanArray(n)
    visited[root] = true
    if (!validateCircle(leftChild[root], leftChild, rightChild, visited)) return false
    if (!validateCircle(rightChild[root], leftChild, rightChild, visited)) return false
    return visited.all { it }
}

fun addParentCountAndValidate(node: Int, parentCountArray: IntArray): Boolean {
    if (node != -1) {
        parentCountArray[node]++
        if (parentCountArray[node] > 1) return false
    }
    return true
}

fun validateCircle(node: Int, leftChildren: IntArray, rightChildren: IntArray, visited: BooleanArray): Boolean {
    if (node == -1) return true
    if (visited[node]) return false
    visited[node] = true
    return validateCircle(leftChildren[node], leftChildren, rightChildren, visited) &&
            validateCircle(rightChildren[node], leftChildren, rightChildren, visited)
}
