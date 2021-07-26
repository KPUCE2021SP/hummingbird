package codevinci.com.kotlinretrofitrestexample

import codevinci.com.kotlinretrofitrestexample.model.User
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import kotlin.test.assertEquals

class UserTest {
    @Mock
    lateinit var user: User

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testUsernameComes() {
        Mockito.`when`(user.login).thenReturn("bktowett")

        assertEquals("bktowett", user.login)
    }
}