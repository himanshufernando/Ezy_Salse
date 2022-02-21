package tkhub.project.ezysales

import okhttp3.OkHttpClient
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class TestDataSourceRule  {

    val server = MockWebServer()
    val okHttp: OkHttpClient = OkHttpClient().newBuilder()
        .readTimeout(100, TimeUnit.MILLISECONDS)
        .build()
    val retrofit: Retrofit = Retrofit.Builder()
        .client(okHttp)
        .baseUrl(server.url("http://192.168.1.101:3000/"))
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()


}