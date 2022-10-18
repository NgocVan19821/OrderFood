package com.example.orderfood.feature.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.orderfood.R
import com.example.orderfood.feature.cart.adapter.CartAdapter
import com.example.orderfood.feature.checkout.CheckOutActivity
import com.example.orderfood.model.Food
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_intro.*
import kotlinx.android.synthetic.main.item_food.*

class CartActivity : AppCompatActivity(), CartAdapter.onItemListener  {

    var list: ArrayList<Food> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        getData()
        orders.adapter = CartAdapter(list, this)
        eventListener()
    }

    private fun getData(){
        val name = intent.getStringExtra("name").toString()
        val calo = intent.getIntExtra("calo",  0)
        val img = intent.getIntExtra("img", 0)
        val price = intent.getDoubleExtra("price", 0.0)
        val quantity = intent.getIntExtra("quantity", 0)
        val food = Food(name, calo, img, price, quantity)
        list.add(food)
        Log.d("van", "$name $calo")

        Log.d("van", "$food")
    }

    private fun eventListener() {

        Toast.makeText(this, intent.getStringExtra("name") + "${intent.getDoubleExtra("price", 0.0)}" + "${intent.getIntExtra("calo", 0)}" + "${intent.getIntExtra("img", 0)}", Toast.LENGTH_SHORT).show()
        confirm_button.setOnClickListener {
            val i = Intent(this, CheckOutActivity::class.java)
            startActivity(i)
        }
        back_button.setOnClickListener {
            onBackPressed()//finish()
        }
    }


    override fun onPlus(position: Int) {
        list[position].quantity++

    }

    override fun onMinus(position: Int) {
        if (list[position].quantity > 1)
            list[position].quantity--
    }


}