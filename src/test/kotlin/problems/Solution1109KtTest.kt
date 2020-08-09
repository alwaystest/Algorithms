package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution1109KtTest {

    @Test
    fun corpFlightBookings_example_verify() {
        val result = corpFlightBookings(
            arrayOf(
                intArrayOf(1, 2, 10),
                intArrayOf(2, 3, 20),
                intArrayOf(2, 5, 25)
            ),
            5
        )

        result shouldBe intArrayOf(10, 55, 45, 25, 25)
    }
}
