import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat

infix fun <T> T.shouldBe(t: T) = assertThat(this, `is`(t))

