package problem1318

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import shouldBe

private fun case(a: Int, b: Int, c: Int, flip: Int) = arrayOf(a, b, c, flip)

@RunWith(Parameterized::class)
class Solution1318Test(private val a: Int, private val b: Int, private val c: Int, private val flip: Int) {

    companion object {

        @Parameterized.Parameters
        @JvmStatic
        fun params() = listOf(
            case(2, 6, 5, 3),
            case(4, 2, 7, 1),
            case(1, 2, 3, 0)
        )
    }

    @Test
    fun minFlips_always_returnMinFlips() {
        minFlips(a, b, c) shouldBe flip
    }
}