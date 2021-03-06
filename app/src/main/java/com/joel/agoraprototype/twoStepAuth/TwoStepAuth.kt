package com.joel.agoraprototype.twoStepAuth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import com.joel.agoraprototype.MainActivity
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_two_step_auth.*

class TwoStepAuth : AppCompatActivity() {

    lateinit var snackBar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_step_auth)
        customActionBar()
        bt_otp_verify.setOnClickListener {
            verifyOtp()
        }
    }

    //function for otp verification
    private fun verifyOtp() {
        if (edit_otp.text.length == 6) {
            otp_verfication_progress.visibility = View.VISIBLE
            //to simulate otp verification
            Handler().postDelayed({
                otp_verfication_progress.visibility = View.INVISIBLE
                var intent: Intent = Intent(this@TwoStepAuth, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }, 2000)
        } else {
            edit_otp.setError("OTP number must be 6 characters")
            edit_otp.requestFocus()
        }
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Two Step Authentication"
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
