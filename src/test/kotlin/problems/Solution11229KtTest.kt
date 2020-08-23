package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution11229KtTest {

    @Test
    fun shortestAlternatingPaths_inputN_result_lengthN() {
        shortestAlternatingPaths(3, arrayOf(), arrayOf()).size shouldBe 3
    }
}