package problem239

import java.util.*

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    assert(nums.size >= k)
    if (k == 1) {
        return nums
    }
    val window = LinkedList<Int>()
    val result = ArrayList<Int>(nums.size - k + 1)
    nums.forEachIndexed { index, i ->
        window.addFirst(i)
        if (index >= k) {
            window.removeLast()
        }
        if (index >= k - 1) {
            result.add(window.max()!!)
        }
    }
    return result.toIntArray()
}
