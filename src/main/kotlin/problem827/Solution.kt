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
            searched.clear()
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
    // if searched, return 0
    if (index in searched) return result
    val (x, y) = index
    // if is first item, 1 --> 1 + sum(neighbors), 0 --> 1 + sum(neighbors)
    // if not first item, 1 --> 1 + sum(neighbors), 0 --> 0
    if (searched.isNotEmpty() && grid[x][y] == 0) {
        return 0
    }
    result++

    searched.add(index)
    val neighbors = unSearchedNeighbors(grid.size, index, searched)
    neighbors.forEach {
        result += dfs(grid, it, searched)
    }

    return result
}

fun unSearchedNeighbors(
    size: Int,
    index: Pair<Int, Int>,
    searched: MutableSet<Pair<Int, Int>>
): List<Pair<Int, Int>> {
    val up = index.copy(first = index.first - 1)
    val bottom = index.copy(first = index.first + 1)
    val right = index.copy(second = index.second + 1)
    val left = index.copy(second = index.second - 1)
    val candidate = listOf(left, bottom, right, up)
    return candidate.filter { it !in searched && it.first in 0 until size && it.second in 0 until size }
}
