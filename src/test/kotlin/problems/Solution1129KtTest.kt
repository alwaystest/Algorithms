package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution1129KtTest {

    @Test
    fun shortestAlternatingPaths_inputN_resultLengthN() {
        shortestAlternatingPaths(3, arrayOf(), arrayOf()).size shouldBe 3
    }

    @Test
    fun shortestAlternatingPaths_example1_verifyResult() {
        val result = shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)), arrayOf())

        result shouldBe intArrayOf(0, 1, -1)
    }

    @Test
    fun shortestAlternatingPaths_example2_verifyResult() {
        val result = shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1)), arrayOf(intArrayOf(2, 1)))

        result shouldBe intArrayOf(0, 1, -1)
    }

    @Test
    fun shortestAlternatingPaths_example3_verifyResult() {
        val result = shortestAlternatingPaths(3, arrayOf(intArrayOf(1, 0)), arrayOf(intArrayOf(2, 1)))

        result shouldBe intArrayOf(0, -1, -1)
    }

    @Test
    fun shortestAlternatingPaths_example4_verifyResult() {
        val result = shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1)), arrayOf(intArrayOf(1, 2)))

        result shouldBe intArrayOf(0, 1, 2)
    }

    @Test
    fun shortestAlternatingPaths_example5_verifyResult() {
        val result = shortestAlternatingPaths(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)), arrayOf(intArrayOf(1, 0)))

        result shouldBe intArrayOf(0, 1, 1)
    }

    @Test
    fun shortestAlternatingPaths_example6_verifyResult() {
        val result = shortestAlternatingPaths(
            5,
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4)),
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1))
        )

        result shouldBe intArrayOf(0, 1, 2, 3, 7)
    }

    @Test
    fun buildGraph_always_verifyGraph() {
        val graph = buildGraph(3, arrayOf(intArrayOf(0, 1)), arrayOf(intArrayOf(1, 2)))

        graph.size shouldBe 3
        graph[0].redNode shouldBe listOf(graph[1])
        graph[1].blueNode shouldBe listOf(graph[2])
    }

    @Test
    fun wfs_always_verifyResult() {
        val n2 = Node(2, mutableListOf(), mutableListOf())
        val n1 = Node(1, mutableListOf(), mutableListOf(n2))
        val n0 = Node(0, mutableListOf(n1), mutableListOf())
        val graph = arrayListOf(n0, n1, n2)
        val result = IntArray(3) { -1 }

        wfs(graph, result)

        result shouldBe intArrayOf(0, 1, 2)
    }
}