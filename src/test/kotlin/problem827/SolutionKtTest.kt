package problem827

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.Is
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

infix fun <T> T.shouldBe(t: T) = assertThat(this, `is`(t))

@RunWith(Parameterized::class)
class SolutionKtTest(private val data: Array<IntArray>, private val expect: Int) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun params() = listOf(
            arrayOf(
                arrayOf(
                    intArrayOf(0)
                ), 1
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 0)
                ), 1
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 0)
                ), 2
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(0, 0)
                ), 3
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(3, 0)
                ), 4
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                ), 4
            )
        )
    }

    @Test
    fun largestIsland() {
        largestIsland(data) shouldBe expect
    }
}