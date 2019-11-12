package br.com.impacta.kotlin.carrosimpacta

import android.app.Application
import android.util.Log
import androidx.multidex.MultiDexApplication
import java.lang.IllegalStateException

class CarrosApplication : MultiDexApplication() {

    private val TAG = "CarrosApplication"

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance : CarrosApplication? = null

        fun getInstance(): CarrosApplication {
            if(appInstance == null){
                throw IllegalStateException("Configure a calasse Application no Android Manifest.xml")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "CarrosApplication.onTerminate()")
    }
}