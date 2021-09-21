package problems

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums1.forEach {
        val count = map.getOrDefault(it, 0)
        map[it] = count + 1
    }

    val result = mutableListOf<Int>()
    nums2.forEach {
        val count = map.getOrDefault(it, 0)
        if (count != 0) {
            result.add(it)
            map[it] = count - 1
        }
    }
    return result.toIntArray()
}