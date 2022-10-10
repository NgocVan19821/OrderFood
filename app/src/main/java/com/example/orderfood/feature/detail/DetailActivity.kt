package com.example.orderfood.feature.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.orderfood.R
import com.example.orderfood.feature.cart.CartActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        eventListener()
    }

    private fun eventListener(){
        addButton.setOnClickListener {
            var quantityNumber = quantity.text.toString().toInt()
            quantityNumber++
            Log.d("tung123", "$quantityNumber")
            quantity.text = quantityNumber.toString()
//            quantity
        }

        minusButton.setOnClickListener {
            var quantityNumber = quantity.text.toString().toInt()
            if (quantityNumber > 1)
                quantityNumber--
            quantity.text = quantityNumber.toString()

        }
        addToCart.setOnClickListener {
            val a = Intent(this@DetailActivity, CartActivity::class.java)
            startActivity(a)
        }

        radio1.setOnClickListener {
            radio2.isChecked = false
            radio3.isChecked = false
        }

        radio2.setOnClickListener {
            radio1.isChecked = false
            radio3.isChecked = false
        }

        radio3.setOnClickListener {
            radio2.isChecked = false
            radio1.isChecked = false
        }
    }

}