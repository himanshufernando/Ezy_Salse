package tkhub.project.ezysales.repo

import dagger.hilt.android.migration.CustomInjection.inject
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import tkhub.project.ezysales.TestDataSourceRule
import tkhub.project.ezysales.data.model.BaseApiModal
import tkhub.project.ezysales.data.model.user.User
import tkhub.project.ezysales.data.model.user.UserBase
import tkhub.project.ezysales.services.network.api.APIInterface
import tkhub.project.ezysales.services.utilities.AppPrefs

@RunWith(JUnit4::class)
class LoginRepoTest{

    @JvmField
    val dataRule = TestDataSourceRule()
    var appPref = AppPrefs

    private lateinit var repo: LoginRepo


    @Before
    fun setUp() { repo = LoginRepo(client = dataRule.retrofit.create(APIInterface::class.java))
    }

    @Test
    fun `check user login with empty mobile`() = runBlocking {
        val user = User().apply {
            user_mobile = ""
            user_password =""
        }
        val itemResponse =repo.userLogin(user)
        val userBase = repo.setBaseApiModalData("Please enter your mobile number !",appPref.ERROR_USER_EMPTY_MOBILE)
        Assert.assertEquals(userBase, itemResponse)
    }

    @Test
    fun `check user login with invalid1 mobile`() = runBlocking {
        val user = User().apply {
            user_mobile = "07111111"
            user_password =""
        }
        val itemResponse =repo.userLogin(user)
        val userBase = repo.setBaseApiModalData("Please enter valid mobile number !",appPref.ERROR_USER_INVALID_MOBILE)
        Assert.assertEquals(userBase, itemResponse)
    }


    @Test
    fun `check user login with empty password`() = runBlocking {
        val user = User().apply {
            user_mobile = "0711111111"
            user_password =""
        }
        val itemResponse =repo.userLogin(user)
        val userBase = repo.setBaseApiModalData("Please enter your password !",appPref.ERROR_USER_EMPTY_PASSWORD)
        Assert.assertEquals(userBase, itemResponse)
    }

}