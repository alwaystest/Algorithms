package problems

fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
    val result = IntArray(n)
    bookings.forEach {
        assert(it.size == 3)
        for (i in it[0]..it[1]) {
            result[i - 1] += it[2]
        }
    }
    return result
}
