package com.joel.agoraprototype.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        customActionBar()

        //setting the spinner (dropdown menu) for security question
        var securityQuestions = resources.getStringArray(R.array.security_questions)
        spinner_security_question.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, securityQuestions)
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Sign Up"
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
