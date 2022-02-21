package tkhub.project.ezysales.repo

import android.content.Context
import android.content.res.Resources
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import tkhub.project.ezysales.R
import tkhub.project.ezysales.data.model.BaseApiModal
import tkhub.project.ezysales.data.model.user.User
import tkhub.project.ezysales.data.model.user.UserBase
import tkhub.project.ezysales.services.network.api.APIInterface
import tkhub.project.ezysales.services.network.connecion.InternetConnection
import tkhub.project.ezysales.services.utilities.AppPrefs


class LoginRepo(private var client: APIInterface) {
    var appPref = AppPrefs

    suspend fun userLogin(user: User): UserBase {
        var userBase = UserBase()
        when {
            user.user_mobile.isNullOrEmpty() || user.user_mobile == "null" -> {
                userBase = setBaseApiModalData(
                    "Please enter your mobile number !",
                    appPref.ERROR_USER_EMPTY_MOBILE
                )
                return userBase
            }
            user.user_mobile.length != 10 -> {
                userBase = setBaseApiModalData(
                    "Please enter valid mobile number !",
                    appPref.ERROR_USER_INVALID_MOBILE
                )
                return userBase
            }
            user.user_password.isNullOrEmpty() || user.user_password == "null" -> {
                userBase = setBaseApiModalData(
                    "Please enter your password !",
                    appPref.ERROR_USER_EMPTY_PASSWORD
                )
                return userBase
            }
            else -> {
                return client.userLogin(user.user_mobile, user.user_password)
            }
        }

        return userBase
    }


    suspend fun pushTokenUpdate(userID: Long): BaseApiModal {
        var userBase = BaseApiModal()
        return userBase
    }

     fun setBaseApiModalData(error : String,code : Int): UserBase {
        return UserBase(true,error,code,User())
    }

}