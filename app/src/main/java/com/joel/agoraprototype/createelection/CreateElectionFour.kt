package com.joel.agoraprototype.createelection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.MainActivity
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_create_election_four.*

class CreateElectionFour : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_election_four)
        customActionBar()

        //button to create the election
        bt_create4.setOnClickListener {
            startActivity(Intent(this@CreateElectionFour, MainActivity::class.java))
            finish()
        }

        bt_prev4.setOnClickListener {
            startActivity(Intent(this@CreateElectionFour, CreateElectionThree::class.java))
        }
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Add Election"
        actionBar?.elevation = 0F
        actionBar?.setHomeAsUpIndicator(R.drawable.close)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
