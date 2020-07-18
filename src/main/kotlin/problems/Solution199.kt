package problems

import java.util.*

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
    var currentLevel = LinkedList<TreeNode>().apply { add(root) }
    while (currentLevel.isNotEmpty()) {
        result.add(currentLevel.last().`val`)
        val nextLevel = LinkedList<TreeNode>()
        currentLevel.forEach {
            it.left?.let { nextLevel.add(it) }
            it.right?.let { nextLevel.add(it) }
        }
        currentLevel = nextLevel
    }
    return result
}
