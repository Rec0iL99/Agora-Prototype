package com.joel.agoraprototype.createpoll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.MainActivity
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_create_poll_four.*

class CreatePollFour : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_poll_four)
        customActionBar()

        bt_create4_poll.setOnClickListener {
            startActivity(Intent(this@CreatePollFour, MainActivity::class.java))
        }

        bt_prev4_poll.setOnClickListener {
            startActivity(Intent(this@CreatePollFour, CreatePollThree::class.java))
        }
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Select Options"
        actionBar?.elevation = 0F
        actionBar?.setHomeAsUpIndicator(R.drawable.close)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
