package com.joel.agoraprototype.twoStepAuth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.R

class TwoStepAuth : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_step_auth)
        customActionBar()
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
