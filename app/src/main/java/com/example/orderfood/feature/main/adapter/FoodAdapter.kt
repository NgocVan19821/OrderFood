package com.example.orderfood.feature.main.adapter

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderfood.R
import com.example.orderfood.model.Food
import kotlinx.android.synthetic.main.item_food.view.*
import kotlinx.android.synthetic.main.item_type.view.*

class FoodAdapter(
    var listener: onItemListener,
    var foodList: ArrayList<Food>
):RecyclerView.Adapter<FoodAdapter.MyViewHolder>() {
    interface onItemListener{
        fun onClickItem(item: Food)
        fun onClickButton(item: Food)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = foodList[position]
        holder.itemView.name.text = item.name
        holder.itemView.calories.text = "${item.calo} Calories"
        holder.itemView.imgFood.setImageResource(item.img)
        val text = "<font color=#fb6264>$ </font><font color=#00000>${item.price}</font>"
        holder.itemView.price.text = Html.fromHtml(text)
        holder.itemView.imgFood.setOnClickListener {
            listener.onClickItem(item)
        }
        holder.itemView.addCart.setOnClickListener {
            listener.onClickButton(item)
        }

    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}