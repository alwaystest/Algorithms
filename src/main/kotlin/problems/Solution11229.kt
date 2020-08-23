package problems

fun shortestAlternatingPaths(n: Int, red_edges: Array<IntArray>, blue_edges: Array<IntArray>): IntArray {
    val result = IntArray(n) { -1 }
    val graph = buildGraph(n, red_edges, blue_edges)
    return result
}

fun buildGraph(
    n: Int,
    red_edges: Array<IntArray>,
    blue_edges: Array<IntArray>
): ArrayList<Node> {
    val graph = arrayListOf<Node>()
    for (i in 0 until n) {
        graph.add(Node(i, mutableListOf(), mutableListOf()))
    }
    red_edges.forEach {
        graph[it[0]].redNode.add(graph[it[1]])
    }
    blue_edges.forEach {
        graph[it[0]].blueNode.add(graph[it[1]])
    }
    return graph
}

data class Node(val value: Int, val blueNode: MutableList<Node>, val redNode: MutableList<Node>)
