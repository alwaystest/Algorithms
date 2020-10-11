package problems

import org.junit.Test
import shouldBe

class Solution5KtTest {

    @Test
    fun longestPalindrome_example1_verify() {
        longestPalindrome("aba") shouldBe "aba"
    }

    @Test
    fun longestPalindrome_example2_verify() {
        longestPalindrome("abba") shouldBe "abba"
    }

    @Test
    fun longestPalindrome_example3_verify() {
        longestPalindrome("a") shouldBe "a"
    }

    @Test
    fun longestPalindrome_example4_verify() {
        longestPalindrome("ab") shouldBe "a"
    }

    @Test
    fun longestPalindrome_example5_verify() {
        longestPalindrome("aa") shouldBe "aa"
    }
}
