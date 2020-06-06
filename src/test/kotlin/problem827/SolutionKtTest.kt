package problem827

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
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

@RunWith(Parameterized::class)
class CalculateTest(private val data: Array<IntArray>, private val expect: Array<IntArray>) {
    companion object {
        @Parameterized.Parameters
        @JvmStatic
        fun params() = listOf(
            arrayOf(
                arrayOf(
                    intArrayOf(0, 0),
                    intArrayOf(0, 0)
                ), arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                )
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(1, 0),
                    intArrayOf(0, 0)
                ), arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(2, 1)
                )
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(0, 0)
                ), arrayOf(
                    intArrayOf(2, 2),
                    intArrayOf(3, 3)
                )
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 0)
                ), arrayOf(
                    intArrayOf(3, 3),
                    intArrayOf(3, 4)
                )
            ),
            arrayOf(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1)
                ), arrayOf(
                    intArrayOf(4, 4),
                    intArrayOf(4, 4)
                )
            )
        )
    }

    @Test
    fun calculate() {
        val result = Array(data.size) { IntArray(data.size) }
        calculate(data, result)
        assertThat(result, equalTo(expect))
    }
}

class UnSearchedNeighborsTest {

    @Test
    fun unSearchedNeighbors_leftTop_2neighbors() {
        val data = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        val result = unSearchedNeighbors(data.size, 0 to 0, mutableSetOf())

        assertThat(result.size, equalTo(2))
        val expectations = listOf(0 to 1, 1 to 0)
        result.containsAll(expectations) shouldBe true
        expectations.containsAll(result) shouldBe true
    }

    @Test
    fun unSearchedNeighbors_rightTop_2neighbors() {
        val data = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        val result = unSearchedNeighbors(data.size, 0 to 1, mutableSetOf())

        assertThat(result.size, equalTo(2))
        val expectations = listOf(0 to 0, 1 to 1)
        result.containsAll(expectations) shouldBe true
        expectations.containsAll(result) shouldBe true
    }

    @Test
    fun unSearchedNeighbors_leftBottom_2neighbors() {
        val data = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        val result = unSearchedNeighbors(data.size, 1 to 0, mutableSetOf())

        assertThat(result.size, equalTo(2))
        val expectations = listOf(0 to 0, 1 to 1)
        result.containsAll(expectations) shouldBe true
        expectations.containsAll(result) shouldBe true
    }

    @Test
    fun unSearchedNeighbors_rightBottom_2neighbors() {
        val data = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )

        val result = unSearchedNeighbors(data.size, 1 to 1, mutableSetOf())

        assertThat(result.size, equalTo(2))
        val expectations = listOf(0 to 1, 1 to 0)
        result.containsAll(expectations) shouldBe true
        expectations.containsAll(result) shouldBe true
    }

    @Test
    fun unSearchedNeighbors_middle_4neighbors() {
        val data = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )

        val result = unSearchedNeighbors(data.size, 1 to 1, mutableSetOf())

        assertThat(result.size, equalTo(4))
        val expectations = listOf(0 to 1, 1 to 0, 1 to 2, 2 to 1)
        result.containsAll(expectations) shouldBe true
        expectations.containsAll(result) shouldBe true
    }

    @Test
    fun unSearchedNeighbors_middleWithSearched_unSearchedNeighbors() {
        val data = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )

        val result = unSearchedNeighbors(data.size, 1 to 1, mutableSetOf(1 to 0))

        assertThat(result.size, equalTo(3))
        val expectations = listOf(0 to 1, 1 to 2, 2 to 1)
        result.containsAll(expectations) shouldBe true
        expectations.containsAll(result) shouldBe true
    }
}
