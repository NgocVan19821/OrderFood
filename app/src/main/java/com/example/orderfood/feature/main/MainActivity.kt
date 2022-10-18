package com.example.orderfood.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.orderfood.R
import com.example.orderfood.feature.cart.CartActivity
import com.example.orderfood.feature.detail.DetailActivity
import com.example.orderfood.feature.main.adapter.FoodAdapter
import com.example.orderfood.feature.main.adapter.TypeAdapter
import com.example.orderfood.model.Food
import com.example.orderfood.model.Type
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_food.*

class MainActivity : AppCompatActivity(), TypeAdapter.onItemListener, FoodAdapter.onItemListener {

    val list = arrayListOf(
        Type(R.drawable.ic_chinese_food, "Burger"),
        Type(R.drawable.ic_chinese_food, "Pizza"),
        Type(R.drawable.ic_chinese_food, "Tung"),
        Type(R.drawable.ic_sushi_svgrepo_com, "Van"),
        Type(R.drawable.ic_sushi_svgrepo_com, "Chin qq")
    )
    val listFood = arrayListOf(
        Food("Spaghetti", 44, R.drawable.ic_chinese_food, 3.2, 1),
    )

//    private val foodAdapter: FoodAdapter by lazy { FoodAdapter(listFood) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchData()
        eventListener()
    }

    private fun fetchData(){
        list_item_type.adapter = TypeAdapter(this, list)
        list_food.adapter = FoodAdapter(this, listFood)

    }


    private fun eventListener(){
        searchButton.setOnClickListener {
//            listFood.add(Food("Spaghetti", 44, R.drawable.ic_chinese_food, 3.2))
        }

        menu.setOnClickListener {
            val i = Intent(this@MainActivity, DetailActivity::class.java)
            startActivity(i)
        }
    }

    override fun onClickItem(item: Type) {
        Toast.makeText(this, "${item.img}, ${item.title}", Toast.LENGTH_SHORT).show()
    }

    override fun onClickDelete(item: Type) {
        Log.d("tung", "deleted")
    }

    override fun onClickItem(item: Food) {
        Toast.makeText(this, "${item.name}, ${item.calo}, ${item.img}, ${item.price}", Toast.LENGTH_SHORT).show()
    }


    override fun onClickButton(item: Food) {
            val i = Intent(this@MainActivity, CartActivity::class.java)
        i.putExtra("name", item.name)
        i.putExtra("img", item.img)
        i.putExtra("price", item.price)
        i.putExtra("calo", item.calo)

            startActivity(i)


    }




}