package com.joel.agoraprototype.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import com.joel.agoraprototype.forgotPassword.ForgotPassword
import com.joel.agoraprototype.R
import com.joel.agoraprototype.twoStepAuth.TwoStepAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        customActionBar()

        //onclick for login -> opens otp verification
        bt_login.setOnClickListener {
            login()
        }

        bt_forgot_password.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPassword::class.java))
        }
    }
    
    //function for login
    private fun login() {
        if (edit_password.length() > 0 && edit_username.length() > 0) {
            login_progress.visibility = View.VISIBLE
            Handler().postDelayed({
                login_progress.visibility = View.INVISIBLE
                startActivity(Intent(this@LoginActivity, TwoStepAuth::class.java))
            }, 2000)
        } else {
            edit_password.setError("Password cannot be empty")
            edit_password.requestFocus();
            edit_username.setError("Username cannot be emoty")
            edit_username.requestFocus();
        }
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Login"
        actionBar?.elevation = 0F
        actionBar?.setHomeAsUpIndicator(R.drawable.back_button)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //function for back button in actionbar
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
