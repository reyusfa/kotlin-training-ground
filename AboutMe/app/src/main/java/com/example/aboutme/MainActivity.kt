package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val dataAboutMe: DataAboutMe = DataAboutMe("Lorem ipsum")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.dataAboutMe = dataAboutMe
        binding.doneButton.setOnClickListener() {
            addNickname(it)
        }
    }

    private fun addNickname (Button: View) {
        binding.apply {
            dataAboutMe?.nickname =nicknameEditText.text.toString()
            invalidateAll()
            nicknameEditText.visibility = View.GONE
            Button.visibility = View.GONE
            nicknameTextView.visibility = View.VISIBLE
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(Button.windowToken, 0)
    }
}
