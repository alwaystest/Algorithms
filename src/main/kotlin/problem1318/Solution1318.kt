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
    TODO()
}
