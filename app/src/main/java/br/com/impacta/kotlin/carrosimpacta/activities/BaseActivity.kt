package br.com.impacta.kotlin.carrosimpacta.activities

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {
    protected val context : Context get() = this
}