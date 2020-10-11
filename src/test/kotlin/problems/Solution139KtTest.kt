package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution139KtTest {

    @Test
    fun wordBreak_sample1_returnTrue() {
        wordBreak("leetcode", listOf("leet", "code")) shouldBe true
    }

    @Test
    fun wordBreak_sample2_returnTrue() {
        wordBreak("applepenapple", listOf("apple", "pen")) shouldBe true
    }

    @Test
    fun wordBreak_sample3_returnTrue() {
        wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")) shouldBe false
    }
}