package com.example.myapplication.ui.auth

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.entities.User
import junit.framework.TestCase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.junit.MockitoJUnitRunner
import org.robolectric.annotation.Config

/**
 * Auth view model test
 *
 * @constructor Create empty Auth view model test
 */
@RunWith(MockitoJUnitRunner::class)
@Config(manifest = Config.NONE)
class AuthViewModelTest : TestCase() {
    var authViewModel: AuthViewModel? = null
    private var fakeUserData = MutableLiveData<User?>()

    @Before
    public override fun setUp() {
        super.setUp()
        MockitoAnnotations.openMocks(this)
        authViewModel = AuthViewModel()
        view = Mockito.mock(View::class.java)
    }


    public override fun tearDown() {}

    @Mock
    lateinit var view: View

    /**
     * Test get email
     *
     */
    @Test
    fun testGetEmail() {
        assertNull(authViewModel?.email)
    }

    /**
     * Test set email
     *
     */
    fun testSetEmail() {

    }

    /**
     * Test get password
     *
     */
    @Test
    fun testGetPassword() {
        assertNull(authViewModel?.password)
    }

    /**
     * Test set password
     *
     */
    fun testSetPassword() {}

    /**
     * Test get auth listener
     *
     */
    fun testGetAuthListener() {}

    /**
     * Test set auth listener
     *
     */
    fun testSetAuthListener() {}

    /**
     * Test is show progress bar
     *
     */
    fun testIsShowProgressBar() {}

    /**
     * Test set show progress bar
     *
     */
    fun testSetShowProgressBar() {}

    /**
     * Test get user live data
     *
     */
    fun testGetUserLiveData() {}

    /**
     * Test set user live data
     *
     */
    fun testSetUserLiveData() {}

    /**
     * Test on login button click
     *
     */
    @Test
    fun `should failed when data is invalid`() {
        authViewModel?.onLoginButtonClick(view)
    }

    @Test
    fun `should success when data is Valid`() {
        val testValue = "123456"
        authViewModel?.email = testValue
        authViewModel?.password = testValue
        authViewModel?.onLoginButtonClick(view)
    }

    /**
     * Test get user info
     *
     */
    fun testGetUserInfo() {}

    /**
     * Input data is invalid when email or password is empty
     *
     */
    @Test
    fun `Input data is invalid when email or password is empty`() {
        val testValue = "123456"
        authViewModel?.validateData("", testValue)
        assertNull(authViewModel?.email)
        assertNull(authViewModel?.password)
    }

    /**
     * Input data is valid when email and password is validate
     *
     */
    @Test
    fun `Input data is valid when email and password is validate `() {
        val testValue = "nangpt"
        authViewModel?.validateData(testValue, testValue)
        assertEquals(authViewModel?.email, testValue)
        assertEquals(authViewModel?.password, testValue)
    }

    /**
     * Input data is invalid when email invalid and password is valid
     *
     */
    @Test
    fun `Input data is invalid when email invalid and password is valid `() {
        val fakeEmail = "nangpt"
        val fakePassword = "12345678"
        authViewModel?.validateData(fakeEmail, fakePassword)
        assertEquals(authViewModel?.email, fakeEmail)
        assertEquals(authViewModel?.password, fakePassword)
    }

    /**
     * Input data is invalid when email valid and password is invalid
     *
     */
    @Test
    fun `Input data is invalid when email valid and password is invalid `() {
        val fakeEmail = "nangpt@runsystem.net"
        val fakePassword = "1234"
        authViewModel?.validateData(fakeEmail, fakePassword)
        assertEquals(authViewModel?.email, fakeEmail)
        assertEquals(authViewModel?.password, fakePassword)
    }

    /**
     * Test login
     *
     */
    @Test
    fun testLogin() {

    }
}