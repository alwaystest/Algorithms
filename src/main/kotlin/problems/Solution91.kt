package problems

fun numDecodings(s: String): Int {
    if (s.isBlank() || s[0] == '0') return 0
    val n = s.length
    val memo = IntArray(n)
    memo[0] = 1
    for (i in 1 until n) {
        if (s[i] == '0') {
            if (s[i - 1] == '1' || s[i - 1] == '2') {
                memo[i] = if (i - 2 < 0) 1 else memo[i - 2]
            } else {
                return 0
            }
        } else {
            // s[i] in 1..9
            when(s[i - 1]) {
                '1' -> memo[i] = if (i - 2 < 0) 2 else memo[i - 1] + memo[i - 2]
                '2' -> {
                    if (s[i] in '1'..'6') {
                        memo[i] = if (i - 2 < 0) 2 else memo[i - 1] + memo[i - 2]
                    } else {
                        memo[i] = memo[i - 1]
                    }
                }
                else -> memo[i] = memo[i - 1]
            }
        }
    }
    return memo[n - 1]
}
