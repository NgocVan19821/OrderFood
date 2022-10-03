package com.example.orderfood.feature.intro

import android.content.Intent
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import com.example.orderfood.R
import com.example.orderfood.feature.main.MainActivity
import kotlinx.android.synthetic.main.activity_intro.*


class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        eventListener()
    }

    private fun eventListener(){
        val text = "<font color=#000000>Quick delivery at\nyour </font><font color=#fb6264>Doorstep</font>"
        change.text = Html.fromHtml(text)

        startButton.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}