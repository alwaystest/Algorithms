package problem239

import java.util.*

fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    assert(nums.size >= k)
    if (k == 1) {
        return nums
    }
    val window = TreeMap<Int, Int>()
    val result = ArrayList<Int>(nums.size - k + 1)
    nums.forEachIndexed { index, i ->
        window[i] = (window[i] ?: 0) + 1
        if (index >= k) {
            val last = nums[index - k]
            if (window[last] == 1) {
                window.remove(last)
            } else {
                window[last] = window[last]!! - 1
            }
        }
        if (index >= k - 1) {
            result.add(window.lastKey())
        }
    }
    return result.toIntArray()
}
