package com.example.orderfood.feature.cart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderfood.R
import com.example.orderfood.model.Food
import kotlinx.android.synthetic.main.item_cart.view.*
import kotlinx.android.synthetic.main.item_food.view.*
import java.text.DecimalFormat

class CartAdapter(
    var cartList: ArrayList<Food>,
    var listener: onItemListener
) :RecyclerView.Adapter<CartAdapter.MyViewHolder>() {
    interface onItemListener{
        fun onPlus(position: Int) //truyen du lieu vao
        abstract fun onMinus(position: Int)
//        fun onMinus(item: Food)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        )
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = cartList[position]
        holder.itemView.title.text = item.name
        holder.itemView.img.setImageResource(item.img)
        holder.itemView.quantity.text = item.quantity.toString()
        holder.itemView.historicalCost.text = item.price.toString()
        val df = DecimalFormat("#.##")

        holder.itemView.totalPrice.text = df.format(item.price * item.quantity)
        holder.itemView.plusButton.setOnClickListener {
            listener.onPlus(position)
            notifyDataSetChanged()
//            holder.itemView.quantity.text = "${item.quantity++}"
        }
        holder.itemView.minusButton.setOnClickListener {
            listener.onMinus(position)
            notifyDataSetChanged() //load re


//            holder.itemView.quantity.text = "${item.quantity--}"

        }





    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}