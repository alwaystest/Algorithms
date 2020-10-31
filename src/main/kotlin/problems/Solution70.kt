package problems

fun climbStairs(n: Int): Int {
    if (n in 1..3) return n
    val memo = IntArray(n + 1)
    (0..2).forEach {
        memo[it] = it
    }
    (3..n).forEach {
        memo[it] = memo[it - 1] + memo[it - 2]
    }
    return memo[n]
}
