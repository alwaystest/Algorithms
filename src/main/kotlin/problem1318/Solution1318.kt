package problem1318

fun minFlips(a: Int, b: Int, c: Int): Int {
    var flip = 0
    var tempA = a
    var tempB = b
    var tempC = c
    while ((tempA or tempB or tempC) != 0) {
        flip += flipAtLastPosition(tempA, tempB, tempC)
        tempA /= 2
        tempB /= 2
        tempC /= 2
    }
    return flip
}

fun flipAtLastPosition(a: Int, b: Int, c: Int): Int {
    val lastA = a % 2
    val lastB = b % 2
    return when (c % 2) {
        0 -> {
            var diff = 0
            if (lastA != 0) diff++
            if (lastB != 0) diff++
            diff
        }
        1 -> if (lastA == 1 || lastB == 1) 0 else 1
        else -> error("Should not reach here")
    }
}
