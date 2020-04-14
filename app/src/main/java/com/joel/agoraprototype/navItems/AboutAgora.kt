package com.joel.agoraprototype.navItems

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.joel.agoraprototype.R
import com.joel.agoraprototype.utilities.AppConstants
import kotlinx.android.synthetic.main.activity_about_agora.*

class AboutAgora : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_agora)
        customActionBar()

        bt_about_gitlab.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(AppConstants.gitlabLink)))
        }

        bt_about_gitter.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(AppConstants.gitterLink)))
        }

        bt_about_website.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(AppConstants.aossieWebsiteLink)))
        }

        bt_about_twitter.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(AppConstants.twitterLink)))
        }
    }

    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "About Agora"
        actionBar?.elevation = 0F
        actionBar?.setHomeAsUpIndicator(R.drawable.back_button)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
