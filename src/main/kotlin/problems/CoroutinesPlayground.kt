package problems

import kotlinx.coroutines.*
import org.jetbrains.annotations.VisibleForTesting

class CoroutinesPlayground(private val dispatcher: CoroutineDispatcher = Dispatchers.Unconfined) :
    CoroutineScope by CoroutineScope(SupervisorJob() + dispatcher) {

    companion object {

        @VisibleForTesting
        const val COUNT_MAX = 3
    }

    private var currentJob: Job? = null

    @VisibleForTesting
    var count = 0

    fun schedule() = launch { run() }

    private fun run() {
        if (count >= COUNT_MAX) {
            cancel()
            return
        }
        println("Running $count")
        count++
        currentJob = launch {
            delay(100)
            run()
        }
    }

    fun reset() {
        currentJob?.cancel()
        count = 0
    }

}

fun main() {
    val playground = CoroutinesPlayground()
    playground.schedule()
    runBlocking {
        delay(150)
        playground.reset()
        playground.schedule()
        playground.coroutineContext[Job]?.join()
    }
}