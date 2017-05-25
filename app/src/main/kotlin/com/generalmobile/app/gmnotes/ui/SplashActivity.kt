package com.generalmobile.app.gmnotes.ui

import android.content.Intent
import android.os.Bundle
import com.generalmobile.app.gmnotes.core.BaseActivity
import com.generalmobile.app.gmnotes.ui.main.MainActivity


class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}