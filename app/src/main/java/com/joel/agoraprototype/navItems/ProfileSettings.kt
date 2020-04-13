package com.joel.agoraprototype.navItems

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.snackbar.Snackbar
import com.joel.agoraprototype.R
import kotlinx.android.synthetic.main.activity_profile_settings.*

class ProfileSettings : AppCompatActivity() {

    lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_settings)
        customActionBar()

        bt_edit_profile.setOnClickListener {
            if (profile_setting_first_name.length() > 0 || profile_setting_last_name.length() > 0) {
                snackbar = Snackbar.make(layout_profile_settings, "Profile edited", Snackbar.LENGTH_SHORT)
                snackbar.show()
            } else {
                profile_setting_first_name.setError("Cannot to be empty for profile edit")
                profile_setting_first_name.requestFocus();
                profile_setting_last_name.setError("Cannot to be empty for profile edit")
                profile_setting_last_name.requestFocus();
            }
        }

        bt_change_password.setOnClickListener {
            snackbar = Snackbar.make(layout_profile_settings, "Password changed", Snackbar.LENGTH_SHORT)
            snackbar.show()
        }
    }

    //function to modify actionbar
    private fun customActionBar() {
        val actionBar: ActionBar? = supportActionBar
        actionBar?.title = "Profile Settings"
        actionBar?.elevation = 0F
        actionBar?.setHomeAsUpIndicator(R.drawable.back_button)
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
