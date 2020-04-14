package com.joel.agoraprototype.createpoll

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_create_poll_three.*

class CreatePollThree : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_poll_three)
        customActionBar()

        //spinner for algorithms
        val algorithmsList = resources.getStringArray(R.array.algorithms)
        spinner_algorithms_poll.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, algorithmsList)

        bt_next3_poll.setOnClickListener {
            startActivity(Intent(this@CreatePollThree, CreatePollFour::class.java))
        }

        bt_prev3_poll.setOnClickListener {
            startActivity(Intent(this@CreatePollThree, CreatePollTwo::class.java))
        }
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Select Voting Algorithm"
        actionBar?.elevation = 0F
        actionBar?.setHomeAsUpIndicator(R.drawable.close)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
