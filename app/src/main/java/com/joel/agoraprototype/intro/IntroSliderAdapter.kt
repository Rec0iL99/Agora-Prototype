package com.joel.agoraprototype.intro

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joel.agoraprototype.R

class IntroSliderAdapter(private val introSlides: List<IntroSlideContent>)
    : RecyclerView.Adapter<IntroSliderAdapter.IntroSlideViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSlideViewHolder {
        return IntroSlideViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    override fun onBindViewHolder(holder: IntroSlideViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }

    inner class IntroSlideViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val titleText = view.findViewById<TextView>(R.id.intro_title)
        private val descText = view.findViewById<TextView>(R.id.intro_desc)
        private val illustration = view.findViewById<ImageView>(R.id.intro_image)

        fun bind(introSlide: IntroSlideContent) {
            titleText.text = introSlide.title
            descText.text = introSlide.description
            illustration.setImageResource(introSlide.illustration)
        }

    }

}