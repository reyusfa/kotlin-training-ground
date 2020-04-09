package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        val clickableViews: List<View> = listOf(
            boxOneTextView,
            boxTwoTextView,
            boxThreeTextView,
            boxFourTextView,
            boxFiveTextView,
            redButton,
            yellowButton,
            greenButton
        )

        for(item in clickableViews) {
            item.setOnClickListener() { makeColored(it) }
        }
    }

    private fun makeColored(view: View) {
        when(view.id) {
            R.id.boxOneTextView -> view.setBackgroundColor(Color.DKGRAY)
            R.id.boxTwoTextView -> view.setBackgroundColor(Color.GRAY)

            R.id.boxThreeTextView -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.boxFourTextView -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.boxFiveTextView -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.redButton -> boxThreeTextView.setBackgroundResource(R.color.redMe)
            R.id.yellowButton -> boxFourTextView.setBackgroundResource(R.color.yellowMe)
            R.id.greenButton -> boxFiveTextView.setBackgroundResource(R.color.greenMe)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }
}
