package com.joel.agoraprototype.createelection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_create_election_two.*

class CreateElectionTwo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_election_two)
        customActionBar()

        //for next button
        bt_next2.setOnClickListener {
            startActivity(Intent(this@CreateElectionTwo, CreateElectionThree::class.java))
        }

        bt_prev2.setOnClickListener {
            startActivity(Intent(this@CreateElectionTwo, CreateElectionOne::class.java))
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
