package com.joel.agoraprototype.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.R
import com.joel.agoraprototype.twoStepAuth.TwoStepAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        customActionBar()

        //onclick for login -> opens otp verification
        bt_login.setOnClickListener {
            startActivity(Intent(this@LoginActivity, TwoStepAuth::class.java))
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
