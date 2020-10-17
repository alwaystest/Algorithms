package problems

import kotlin.math.max

fun maxSubArray(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    var sum = nums[0]
    var maxSum = sum
    for (i in 1 until nums.size) {
        if (sum < 0 && nums[i] > sum) {
            sum = nums[i]
        } else {
            sum += nums[i]
        }
        maxSum = max(maxSum, sum)
    }
    return maxSum
}
