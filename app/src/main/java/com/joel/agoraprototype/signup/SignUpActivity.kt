package com.joel.agoraprototype.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        customActionBar()

        //setting the spinner (dropdown menu) for security question
        val securityQuestions = resources.getStringArray(R.array.security_questions)
        spinner_security_question.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, securityQuestions)

        bt_sign_up.setOnClickListener {
            signUp()
        }
    }

    /*function for sign up click (simulation)
      test cases are not taken seriously since this is a prototype
    */
    private fun signUp() {
        if (edit_email_signup.length() > 0
            && edit_fullname_signup.length() > 0
            && edit_security_question_signup.length() > 0
            && edit_password_signup.length() > 0
            && edit_username_signup.length() > 0) {

            sign_up_progress.visibility = View.VISIBLE
            Handler().postDelayed({
                snackbar = Snackbar.make(layout_sign_up, "Check your email to activate account", Snackbar.LENGTH_SHORT)
                snackbar.show()
                sign_up_progress.visibility = View.INVISIBLE
            }, 2000)
        } else {
            edit_username_signup.setError("Username cannot be empty")
            edit_username_signup.requestFocus()
            edit_fullname_signup.setError("Name cannot be empty")
            edit_fullname_signup.requestFocus()
            edit_email_signup.setError("Email cannot be empty")
            edit_email_signup.requestFocus()
            edit_password_signup.setError("Password cannot be empty")
            edit_password_signup.requestFocus()
            edit_security_question_signup.setError("Security question answer cannot be empty")
            edit_security_question_signup.requestFocus()
        }
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
