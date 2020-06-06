package problem827

fun largestIsland(grid: Array<IntArray>): Int {
    if (grid.size == 1) return 1
    val n = grid.size
    val index2Size = Array(n) { IntArray(n) }
    calculate(grid, index2Size)
    return index2Size.asSequence().map { it.max() }.maxBy { it!! }!!
}

fun calculate(grid: Array<IntArray>, index2Size: Array<IntArray>) {
    val n = grid.size
    val searched = mutableSetOf<Pair<Int, Int>>()
    for (x in 0 until n) {
        for (y in 0 until n) {
            index2Size[x][y] = dfs(grid, x to y, searched)
        }
    }
}

private fun dfs(
    grid: Array<IntArray>,
    index: Pair<Int, Int>,
    searched: MutableSet<Pair<Int, Int>>
): Int {
    // TODO(optimise: index2Size as cache?)
    var result = 0
    // if is first item, 1 --> 1 + sum(neighbors), 0 --> 1 + sum(neighbors)
    // if not first item, 1 --> 1 + sum(neighbors), 0 --> 0
    val (x, y) = index
    if (searched.isNotEmpty() && grid[x][y] == 0) {
        return 0
    }
    result++

    searched.add(index)
    val neighbors = unSearchedNeighbors(grid.size, index, searched)
    neighbors.forEach {
        result += dfs(grid, it, searched)
    }
    searched.remove(index)

    return result
}

fun unSearchedNeighbors(
    size: Int,
    index: Pair<Int, Int>,
    searched: MutableSet<Pair<Int, Int>>
): List<Pair<Int, Int>> {
    TODO("获取其上下左右合法的 Index，注意可能需要去除已经跑过的地方")
}
