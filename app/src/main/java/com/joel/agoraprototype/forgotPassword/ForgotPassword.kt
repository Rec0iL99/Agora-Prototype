package com.joel.agoraprototype.forgotPassword

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPassword : AppCompatActivity() {

    lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        customActionBar()

        bt_forgot_password_username.setOnClickListener {
            userForgotPassword()
        }

    }

    //function to get username for password reset
    private fun userForgotPassword() {
        if (edit_forgot_password_username.length() > 0) {
            forgot_password_progress.visibility = View.VISIBLE
            Handler().postDelayed({
                forgot_password_progress.visibility = View.INVISIBLE
                snackbar = Snackbar.make(layout_forgot_password, "Check your email for resetting password", Snackbar.LENGTH_SHORT)
                snackbar.show()
            }, 2000)
        } else {
            snackbar = Snackbar.make(layout_forgot_password, "You have a give a username", Snackbar.LENGTH_SHORT)
            snackbar.show()
        }
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Forgot Password"
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
