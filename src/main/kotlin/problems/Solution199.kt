package problems

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    if (root.left == null && root.right == null) {
        return listOf(root.`val`)
    }
    val result = mutableListOf<Int>()
    var currentLevel = listOf(root)
    while (currentLevel.isNotEmpty()) {
        result.add(currentLevel.last().`val`)
        currentLevel = currentLevel.flatMap { listOf(it.left, it.right) }.filterNotNull()
    }
    return result
}
