package problems

import kotlin.math.abs

fun numMovesStones(a: Int, b: Int, c: Int): IntArray {
    val min = minOf(a, b, c)
    val max = maxOf(a, b, c)
    if (max - min == 2) {
        return intArrayOf(0, 0)
    }
    if (abs(a - b) <= 2 || abs(a - c) <= 2 || abs(b - c) <= 2)
        return intArrayOf(1, max - min - 2)
    return intArrayOf(2, max - min - 2)
}
