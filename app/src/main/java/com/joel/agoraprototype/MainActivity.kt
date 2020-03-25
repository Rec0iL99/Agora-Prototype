package com.joel.agoraprototype

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var snackbar: Snackbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
            welcome message for users logging in
            will not show if user is already logged (below code shows everytime, but this is just for simulation)
         */
        snackbar = Snackbar.make(layout_main_activity, "Welcome to Agora Vote", Snackbar.LENGTH_SHORT)
        snackbar.show()
    }
}
