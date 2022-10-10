package com.example.orderfood.feature.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.example.orderfood.R
import com.example.orderfood.feature.cart.adapter.CartAdapter
import com.example.orderfood.model.Cart
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.item_food.*

class CartActivity : AppCompatActivity() {

    val list = arrayListOf(
        Cart(R.drawable.pizza, "hello", 2.3, 5),
        Cart(R.drawable.pizza, "hello", 2.3, 5),
        Cart(R.drawable.pizza, "hello", 2.3, 5),
        Cart(R.drawable.pizza, "hello", 2.3, 5),
        Cart(R.drawable.pizza, "hello", 2.3, 5),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        orders.adapter = CartAdapter(list)
        eventListener()
    }

    private fun eventListener() {

    }

}