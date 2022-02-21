package tkhub.project.ezysales.services.network.api

import com.google.gson.JsonObject
import retrofit2.http.*
import tkhub.project.ezysales.data.model.BaseApiModal
import tkhub.project.ezysales.data.model.user.UserBase

interface APIInterface {

    @GET("users/login")
    suspend fun userLogin(
        @Query("user_mobile") user_mobile: String,
        @Query("user_password") user_password: String
    ): UserBase

    @PUT("users/pushtokenupdate/{id}")
    suspend fun pushtokenupdate(@Path("id") id: Long, @Body userInfo: JsonObject): BaseApiModal


}