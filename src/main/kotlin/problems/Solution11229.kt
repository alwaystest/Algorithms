package problems

import java.util.*
import kotlin.collections.ArrayList

fun shortestAlternatingPaths(n: Int, red_edges: Array<IntArray>, blue_edges: Array<IntArray>): IntArray {
    val result = IntArray(n) { -1 }
    val graph = buildGraph(n, red_edges, blue_edges)
    wfs(graph ,result)
    return result
}

fun wfs(graph: ArrayList<Node>, result: IntArray) {
    if (graph.isEmpty()) return
    val path = IntArray(2 * result.size)
    var queue = LinkedList<Pair<Node, Boolean>>()
    queue.add(graph[0] to true)
    queue.add(graph[0] to false)
    var depth = 0
    while (!queue.isEmpty()) {
        queue = wfsImpl(depth++, result, path, queue)
    }
}

fun wfsImpl(
    depth: Int,
    result: IntArray,
    path: IntArray,
    queue: LinkedList<Pair<Node, Boolean>>
) :LinkedList<Pair<Node, Boolean>> {
    val nextLevel = LinkedList<Pair<Node, Boolean>>()
    queue.forEach { (node, chooseRed) ->
        if (chooseRed) {
            // next choose red, this is form blue path
            path[node.value * 2 + 1] = 1
        } else {
            path[node.value * 2] = 1
        }

        if (result[node.value] == -1) {
            result[node.value] = depth
        }

        if (chooseRed) {
            node.redNode.forEach {
                if (path[it.value * 2] == 0) {
                    nextLevel.add(it to false)
                }
            }
        } else {
            node.blueNode.forEach {
                if (path[it.value * 2 + 1] == 0) {
                    nextLevel.add(it to true)
                }
            }
        }
    }
    return nextLevel
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
