package problem827

fun largestIsland(grid: Array<IntArray>): Int {
    if (grid.size == 1) return 1
    val n = grid.size
    val index2Size = Array(n) { IntArray(n) }
    calculate(grid, index2Size)
    return index2Size.asSequence().map { it.max() }.maxBy { it!! }!!
}

fun calculate(grid: Array<IntArray>, index2Size: Array<IntArray>) {
    TODO()
}
