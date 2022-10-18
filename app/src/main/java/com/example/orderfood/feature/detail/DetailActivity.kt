package com.example.orderfood.feature.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.orderfood.R
import com.example.orderfood.feature.cart.CartActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    var calo = 300
    var price: Double = 0.0
    var total: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        defaultValue()
        eventListener()
    }

    private fun defaultValue(){
        price = price2.text.toString().toDouble()
        total = price * quantity.text.toString().toInt()

        priceDish.text = "$price"
        fill.text = "$total"
    }

    private fun eventListener(){
        addButton.setOnClickListener {
            var quantityNumber = quantity.text.toString().toInt()
            quantityNumber++
            quantity.text = quantityNumber.toString()

            total = price * quantityNumber
            fill.text = "$$total"
        }

        minusButton.setOnClickListener {
            var quantityNumber = quantity.text.toString().toInt()
            if (quantityNumber > 1)
                quantityNumber--
            quantity.text = quantityNumber.toString()

            total = price * quantityNumber
            fill.text = "$$total"
        }
        addToCart.setOnClickListener {
            val a = Intent(this@DetailActivity, CartActivity::class.java)
            intent.putExtra("name", nameDish.text.toString())
            intent.putExtra("calo", calo)
            intent.putExtra("img", R.drawable.pizza)
            intent.putExtra("price", total)
            intent.putExtra("quantity", quantity.text.toString().toInt())
            Log.d("van", "${nameDish.text.toString()} $calo")
            startActivity(a)
        }

        radio1.setOnClickListener {
            radio2.isChecked = false
            radio3.isChecked = false
            price = price1.text.toString().toDouble()
            priceDish.text = "$price"

            total = price * quantity.text.toString().toInt()
            fill.text = "$$total"
        }

        radio2.setOnClickListener {
            radio1.isChecked = false
            radio3.isChecked = false
            price = price2.text.toString().toDouble()
            priceDish.text = "$price"
            total = price * quantity.text.toString().toInt()
            fill.text = "$$total"
        }

        radio3.setOnClickListener {
            radio2.isChecked = false
            radio1.isChecked = false
            price = price3.text.toString().toDouble()
            priceDish.text = "$price"
            total = price * quantity.text.toString().toInt()
            fill.text = "$$total"
        }
    }

}