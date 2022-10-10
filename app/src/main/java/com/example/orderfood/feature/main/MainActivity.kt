package com.example.orderfood.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orderfood.R
import com.example.orderfood.feature.detail.DetailActivity
import com.example.orderfood.feature.main.adapter.FoodAdapter
import com.example.orderfood.feature.main.adapter.TypeAdapter
import com.example.orderfood.model.Food
import com.example.orderfood.model.Type
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val list = arrayListOf(
        Type(R.drawable.ic_chinese_food, "Burger"),
        Type(R.drawable.ic_chinese_food, "Pizza"),
        Type(R.drawable.ic_chinese_food, "Tung"),
        Type(R.drawable.ic_sushi_svgrepo_com, "Van"),
        Type(R.drawable.ic_sushi_svgrepo_com, "Chin")
    )
    val listFood = arrayListOf(
        Food("Spaghetti", 44, R.drawable.ic_chinese_food, 3.2),
    )

    private val foodAdapter: FoodAdapter by lazy { FoodAdapter(listFood) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData()
        eventListener()
    }

    private fun fetchData(){
        list_item_type.adapter = TypeAdapter(list)
        list_food.adapter = FoodAdapter(listFood)

    }


    private fun eventListener(){
        searchButton.setOnClickListener {
            listFood.add(Food("Spaghetti", 44, R.drawable.ic_chinese_food, 3.2))
        }

        menu.setOnClickListener {
            val i = Intent(this@MainActivity, DetailActivity::class.java)
            startActivity(i)
        }
    }
}