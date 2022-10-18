package com.example.orderfood.feature.checkout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orderfood.R
import com.example.orderfood.feature.checkout.adapter.AddressAdapter
import com.example.orderfood.feature.main.adapter.FoodAdapter
import com.example.orderfood.feature.main.adapter.TypeAdapter
import com.example.orderfood.model.Address
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_check_out.*
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_address.*
import java.lang.reflect.Type

class CheckOutActivity : AppCompatActivity() {
    var listAddress = arrayListOf(
        Address(R.drawable.img_hamburger, "Home", "Ngo Van So"),
        Address(R.drawable.img_hamburger, "Home", "Ngo Van So"),
        Address(R.drawable.img_hamburger, "Home", "Ngo Van So")



    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        fetchData()
        eventListener()


    }

    private fun fetchData(){
        list_item_address.adapter = AddressAdapter(listAddress )

    }
    private fun eventListener(){

    }


}