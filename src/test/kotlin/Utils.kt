import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

infix fun <T> T.shouldBe(t: T) = assertThat(this, `is`(t))
fun <T> T.shouldBe(t: T, msg: () -> String) = assertThat(msg(), this, `is`(t))

