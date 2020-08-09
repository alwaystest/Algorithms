package problems

fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val result = IntArray(n)
    bookings.forEach {
        if (it[1] < n) result[it[1]] -= it[2]
        result[it[0] - 1] += it[2]
    }
    for (i in 1 until result.size) {
        result[i] += result[i - 1]
    }
    return result
}
