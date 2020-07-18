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
    TODO()
}