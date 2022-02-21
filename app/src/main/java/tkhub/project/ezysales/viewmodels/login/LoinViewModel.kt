package tkhub.project.ezysales.viewmodels.login

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import tkhub.project.ezysales.data.model.BaseApiModal
import tkhub.project.ezysales.data.model.EzySalesResult
import tkhub.project.ezysales.data.model.user.User
import tkhub.project.ezysales.repo.LoginRepo
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltViewModel
class LoinViewModel  @Inject constructor(private val loginRepo: LoginRepo) : ViewModel(){



    // login fragment
    var editTextLoginPhone = ObservableField<String>()
    var editTextLoginPassword = ObservableField<String>()
    var layoutLoginLoading = ObservableField<Boolean>()



    init {
        layoutLoginLoading.set(false)
    }



    fun userLogin() = liveData(Dispatchers.IO) {
        try {
            layoutLoginLoading.set(true)
            val user = User().apply {
                user_mobile = editTextLoginPhone.get().toString().trim()
                user_password = editTextLoginPassword.get().toString().trim()
            }
            val loginResponse = loginRepo.userLogin(user)
            layoutLoginLoading.set(false)
            if(loginResponse.error){
                val baseApiModal = BaseApiModal().apply {
                    error = true
                    message = loginResponse.message
                    code = loginResponse.code
                }
                emit(EzySalesResult.LogicalError.LogError(baseApiModal))
            }else{
                emit(EzySalesResult.Success(loginResponse))
            }
        } catch (exception: Exception) {
            layoutLoginLoading.set(false)
            emit(EzySalesResult.ExceptionError.ExError(exception))
        }
    }

}