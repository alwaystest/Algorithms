class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // build up hash maps
        val map = mutableMapOf<Int, Int>()
        for(i in nums.indices) {
            map[nums[i]] = i
        }
        for(i in nums.indices) {
            val aim = map[target - nums[i]]
            if (aim != null && aim != i) {
                return intArrayOf(i, aim)
            }
        }
        return intArrayOf(0, 0)
    }
}

