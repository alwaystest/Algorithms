package problems

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val dp = BooleanArray(s.length + 1)
    val dict = wordDict.toSet()
    dp[0] = true
    for (i in 1..s.length) {
        val current = s.substring(0, i)
        for (j in 0..i) {
            dp[i] = dp[j] && current.substring(j) in dict
            if (dp[i]) break
        }
    }
    return dp.last()
}
