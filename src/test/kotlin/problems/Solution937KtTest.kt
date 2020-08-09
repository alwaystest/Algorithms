package problems

import org.junit.Assert.*
import org.junit.Test
import shouldBe

class Solution937KtTest {

    @Test
    fun reorderLogFiles_example_verify() {
        val raw = arrayOf(
            "dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"
        )
        val expect = arrayOf(
            "let1 art can", "let3 art zero", "let2 own kit dig", "dig1 8 1 5 1", "dig2 3 6"
        )
        reorderLogFiles(raw) shouldBe expect
    }

    @Test
    fun reorderLogFiles_example1_verify() {
        val raw = arrayOf(
            "a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"
        )
        val expect = arrayOf(
            "g1 act car", "a8 act zoo", "ab1 off key dog", "a1 9 2 3 1", "zo4 4 7"
        )
        reorderLogFiles(raw) shouldBe expect
    }
}