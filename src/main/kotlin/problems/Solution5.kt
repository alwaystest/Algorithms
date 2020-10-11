package problems

fun longestPalindrome(s: String): String {
    val len = s.length
    val dp = Array(len) { BooleanArray(len) }
    var maxLen = 1
    var start = 0
    for (j in 0 until len) {
        dp[j][j] = true
        for (i in 0 until j) {
            if (i + 1 == j) {
                dp[i][j] = s[i] == s[j]
            } else {
                dp[i][j] = s[i] == s[j] && dp[i + 1][j - 1]
            }
            if (dp[i][j] && (j - i + 1) > maxLen) {
                maxLen = j - i + 1
                start = i
            }
        }
    }
    return s.substring(start, start + maxLen)
}
