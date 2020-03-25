package com.joel.agoraprototype.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.login.LoginActivity
import com.joel.agoraprototype.R
import com.joel.agoraprototype.signup.SignUpActivity
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        //hiding the appbar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        bt_welcome_sign_up.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, SignUpActivity::class.java))
        }

        bt_welcome_login.setOnClickListener {
            startActivity(Intent(this@WelcomeActivity, LoginActivity::class.java))
        }
    }
}
