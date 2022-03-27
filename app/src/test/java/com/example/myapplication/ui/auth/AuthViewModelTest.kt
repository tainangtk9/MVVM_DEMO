package com.example.myapplication.ui.auth

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.entities.User
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Spy
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(manifest = Config.NONE)
class AuthViewModelTest : TestCase() {
    private var authViewModel: AuthViewModel? = null
    private var fakeUserData = MutableLiveData<User?>()

    @Before
    public override fun setUp() {
        super.setUp()
        authViewModel = AuthViewModel()
        view = Mockito.mock(View::class.java)
    }


    public override fun tearDown() {}

    @Spy
    lateinit var view:View

//    @Test
//    fun testGetEmail() {
//        assertEquals(authViewModel?.email, "eve.holt@reqres.in")
//    }
//
//    fun testSetEmail() {
//
//    }
//    @Test
//    fun testGetPassword() {
//        assertEquals(authViewModel?.password, "cityslicka")
//    }

    fun testSetPassword() {}

    fun testGetAuthListener() {}

    fun testSetAuthListener() {}

    fun testIsShowProgressBar() {}

    fun testSetShowProgressBar() {}

    fun testGetUserLiveData() {}

    fun testSetUserLiveData() {}
    @Test
    fun testOnLoginButtonClick() {
        authViewModel?.onLoginButtonClick(view)
    }

    fun testGetUserInfo() {}

    /**
     * Validate data when user login
     * <p>
     *  case email or pass is  empty
     * </p>
     */
    @Test
    fun `Input data is invalid when email or password is empty`() {
        val testValue ="123456"
        authViewModel?.validateData("",testValue)
        assertNull(authViewModel?.email)
        assertNotNull(authViewModel?.password)
        assertEquals(authViewModel?.password,testValue)
    }
    /**
     * Validate data when user login
     * <p>
     *  case email or pass is  empty
     * </p>
     */
    @Test
    fun `Input data is invalid when email is invalidate `() {
        val testValue ="nangpt"
         authViewModel?.validateData(testValue,testValue)
         authViewModel?.login(testValue,testValue)
    }

    @Test
    fun testLogin(){

    }
}