package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution11229KtTest {

    @Test
    fun shortestAlternatingPaths_inputN_resultLengthN() {
        shortestAlternatingPaths(3, arrayOf(), arrayOf()).size shouldBe 3
    }

    @Test
    fun buildGraph_always_verifyGraph() {
        val graph = buildGraph(3, arrayOf(intArrayOf(0, 1)), arrayOf(intArrayOf(1, 2)))

        graph.size shouldBe 3
        graph[0].redNode shouldBe listOf(graph[1])
        graph[1].blueNode shouldBe listOf(graph[2])
    }
}