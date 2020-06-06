package problem827

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.core.Is
import org.junit.Test

import org.junit.Assert.*

infix fun <T> T.shouldBe(t: T) = assertThat(this, `is`(t))

class SolutionKtTest {

    @Test
    fun largestIsland() {
        val data = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        largestIsland(data) shouldBe 1
    }
}