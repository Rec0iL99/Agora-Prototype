package com.joel.agoraprototype.moreinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_more_info.*

class MoreInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_info)
        customActionBar()

        info_election_name_content.text = "Election 1"
        info_election_desc_content.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed mauris justo, venenatis in tristique vitae, consectetur volutpat augue. Integer non dui suscipit, vulputate libero quis"
        info_election_candidates_content.text = "Justin Mathew\nJoel Mathew"
        info_election_start_content.text = "Mon Apr 05/03/2020 15:03PM"
        info_election_end_content.text = "Tue Apr 06/03/2020 15:03PM"
        info_election_status_content.text = "Active"
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Election name here.."
        actionBar?.elevation = 0F
        actionBar?.setHomeAsUpIndicator(R.drawable.back_button)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
