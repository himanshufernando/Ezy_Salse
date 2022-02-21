package tkhub.project.ezysales

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Ezy : Application(){
    companion object {
        private var instance: Ezy? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }

    }

    init {
        instance = this
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }

    override fun onCreate() {
        super.onCreate()

    }

}