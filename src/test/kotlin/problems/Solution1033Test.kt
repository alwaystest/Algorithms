package problems

import org.junit.Test
import shouldBe

class Solution1033Test {

    @Test
    fun numMovesStones_consecutive_verifyResult() {
        val numMovesStones = numMovesStones(1, 2, 3)
        numMovesStones.forEach { it shouldBe 0 }
    }

    @Test
    fun numMovesStones_consecutiveOneSide_verifyResult() {
        val numMovesStones = numMovesStones(1, 2, 4)
        numMovesStones[0] shouldBe 1
        numMovesStones[1] shouldBe 1
    }

    @Test
    fun numMovesStones_fillTheGap_verifyResult() {
        val numMovesStones = numMovesStones(0, 2, 4)
        numMovesStones[0] shouldBe 1
        numMovesStones[1] shouldBe 2
    }

    @Test
    fun numMovesStones_bothSideFar_verifyResult() {
        val numMovesStones = numMovesStones(0, 5, 10)
        numMovesStones[0] shouldBe 2
        numMovesStones[1] shouldBe 8
    }
}