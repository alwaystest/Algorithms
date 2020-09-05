package challenge.september.week1

import java.util.*

// All Elements in Two Binary Search Trees
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {

    fun getAllElements(root1: TreeNode?, root2: TreeNode?): List<Int> {
        val list1 = getOrder(root1)
        val list2 = getOrder(root2)
        return merge(list1, list2)
    }

    fun getOrder(root: TreeNode?): LinkedList<Int> {
        if (root == null) return LinkedList()
        val result = LinkedList<Int>()
        result.addAll(getOrder(root.left))
        result.add(root.`val`)
        result.addAll(getOrder(root.right))
        return result
    }

    fun merge(list1: LinkedList<Int>, list2: LinkedList<Int>): List<Int> {
        val result = LinkedList<Int>()
        while (list1.isNotEmpty() || list2.isNotEmpty()) {
            if (list1.isEmpty()){
                result.addAll(list2)
                break
            }
            if (list2.isEmpty()) {
                result.addAll(list1)
                break
            }
            if (list1[0] < list2[0]) {
                result.add(list1.poll())
            } else {
                result.add(list2.poll())
            }
        }
        return result
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
