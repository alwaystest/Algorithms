package problems

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.*
import org.junit.Assert.assertEquals
import org.junit.Test


class CoroutinesPlaygroundTest {

    private val dispatcher: CoroutineDispatcher = StandardTestDispatcher()

    @Test
    fun schedule_byDefault_runsMaxCount() = runTest(dispatcher) {
        val playground = CoroutinesPlayground(dispatcher)
        playground.schedule()
        runCurrent()
        assertEquals(1, playground.count)
        println(currentTime)
        Thread.sleep(200)
        // sleep would not increase currentTime
        println(currentTime)
        assertEquals(1, playground.count)

        delay(300)
        println(currentTime)
        // delay would increase currentTime
        assertEquals(CoroutinesPlayground.COUNT_MAX, playground.count)
        println("complete")
    }

    @Test
    fun schedule_reset_cancelCurrentJobAndStartOver() = runTest(dispatcher) {
        val playground = CoroutinesPlayground(dispatcher)
        playground.schedule()
        delay(50)
        assertEquals(1, playground.count)
        playground.reset()
        delay(300)
        assertEquals(0, playground.count)
        playground.schedule()
        println(currentTime)
        runCurrent()
        assertEquals(1, playground.count)
        advanceUntilIdle()
        assertEquals(CoroutinesPlayground.COUNT_MAX, playground.count)
    }
}