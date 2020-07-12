package problems

import kotlin.math.floor

fun imageSmoother(M: Array<IntArray>): Array<IntArray> {
    if (M.isEmpty()) return M
    val result = Array(M.size) {
        IntArray(M[it].size)
    }
    for (x in M.indices) {
        for (y in M[x].indices) {
            val average = getAverage(M, x, y)
            result[x][y] = average
        }
    }
    return result
}

fun getAverage(m: Array<IntArray>, x: Int, y: Int): Int {
    val neighbors = getNeighbors(m, x, y)
    return floor(
        neighbors.run {
            add(m[x][y])
            average()
        }
    ).toInt()
}

fun getNeighbors(m: Array<IntArray>, x: Int, y: Int): MutableList<Int> {
    val result = mutableListOf<Int>()
    validateAndAdd(m, x - 1, y - 1, result)
    validateAndAdd(m, x - 1, y, result)
    validateAndAdd(m, x - 1, y + 1, result)
    validateAndAdd(m, x, y - 1, result)
    validateAndAdd(m, x, y + 1, result)
    validateAndAdd(m, x + 1, y - 1, result)
    validateAndAdd(m, x + 1, y, result)
    validateAndAdd(m, x + 1, y + 1, result)
    return result
}

fun validateAndAdd(m: Array<IntArray>, x: Int, y: Int, result: MutableList<Int>) {
    if (isValid(m, x, y)) {
        result.add(m[x][y])
    }
}

fun isValid(m: Array<IntArray>, x: Int, y: Int): Boolean {
    if (x < 0 || x >= m.size) {
        return false
    }
    if (y < 0 || y >= m[x].size) {
        return false
    }
    return true
}
