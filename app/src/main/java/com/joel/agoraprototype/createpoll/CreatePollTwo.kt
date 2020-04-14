package com.joel.agoraprototype.createpoll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_create_poll_two.*

class CreatePollTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_poll_two)
        customActionBar()

        bt_next2_poll.setOnClickListener {
            startActivity(Intent(this@CreatePollTwo, CreatePollThree::class.java))
        }

        bt_prev2_poll.setOnClickListener {
            startActivity(Intent(this@CreatePollTwo, CreatePollOne::class.java))
        }
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Add Candidates"
        actionBar?.elevation = 0F
        actionBar?.setHomeAsUpIndicator(R.drawable.close)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
