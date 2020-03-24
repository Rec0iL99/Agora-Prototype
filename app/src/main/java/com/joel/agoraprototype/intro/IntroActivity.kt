package com.joel.agoraprototype.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.joel.agoraprototype.R
import com.joel.agoraprototype.auth.WelcomeActivity
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    private val introSliderAdapter =
        IntroSliderAdapter(
            listOf(
                IntroSlideContent(
                    "We believe in returning to society",
                    "That's why since 2016, we've been a part of programs to educate youth about open source.",
                    R.drawable.first_intro
                ),
                IntroSlideContent(
                    "Of Course, We have Supporters",
                    "We need help too, and our visions would never haven been met if not for our generous supporters.",
                    R.drawable.second_intro
                ),
                IntroSlideContent(
                    "Eight Projects",
                    "Not alot, not little either. We’re proud to have projects " +
                            "addressing concerns in today's society, from democratic " +
                            "elections to global warming we " +
                            "got it covered.",
                    R.drawable.third_intro
                )
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        //hiding the appbar
        val actionBar: ActionBar? = supportActionBar
        actionBar?.hide()

        //set the slider
        slider_content.adapter = introSliderAdapter

        //set the indicators
        setupIndicators()
        setCurrentIndicator(0)
        slider_content.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                //if it is last intro content show get started button or else show indicators
                if ( position == 2 ) {
                    bt_get_started.visibility = View.VISIBLE
                    bt_skip.visibility = View.INVISIBLE
                    indicator_container.visibility = View.INVISIBLE
                } else {
                    setCurrentIndicator(position)
                }

            }
        })

        bt_skip.setOnClickListener {
            startActivity(Intent(this@IntroActivity, WelcomeActivity::class.java))
            finish()
        }

        bt_get_started.setOnClickListener {
            startActivity(Intent(this@IntroActivity, WelcomeActivity::class.java))
            finish()
        }
    }

    //set indicators
    private fun setupIndicators() {
        val indicators = arrayOfNulls<ImageView>(introSliderAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8,0,8,0)

        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            indicator_container.addView(indicators[i])
        }
    }

    private fun setCurrentIndicator(index: Int) {
        val childCount = indicator_container.childCount
        for (i in 0 until childCount) {
            val imageView = indicator_container[i] as ImageView
            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.indicator_inactive
                    )
                )
            }
        }
    }
}
