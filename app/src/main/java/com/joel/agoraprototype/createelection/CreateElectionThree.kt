package com.joel.agoraprototype.createelection

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_create_election_three.*

class CreateElectionThree : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_election_three)
        customActionBar()

        //spinner for algorithms
        val algorithmsList = resources.getStringArray(R.array.algorithms)
        spinner_algorithms.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, algorithmsList)

        //next button
        bt_next3.setOnClickListener {
            startActivity(Intent(this@CreateElectionThree, CreateElectionFour::class.java))
        }

        bt_prev3.setOnClickListener {
            startActivity(Intent(this@CreateElectionThree, CreateElectionTwo::class.java))
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
