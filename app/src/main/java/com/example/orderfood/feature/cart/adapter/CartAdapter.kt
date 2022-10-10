package com.example.orderfood.feature.cart.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderfood.R
import com.example.orderfood.feature.main.adapter.FoodAdapter
import com.example.orderfood.model.Cart
import kotlinx.android.synthetic.main.item_cart.view.*
import kotlinx.android.synthetic.main.item_food.view.*

class CartAdapter(
    var cartList: ArrayList<Cart>
) :RecyclerView.Adapter<CartAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        )
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var item = cartList[position]
        holder.itemView.title.text = item.title
        holder.itemView.img.setImageResource(item.img)
        holder.itemView.quantity.text = item.quantity.toString()
        holder.itemView.historicalCost.text = item.price.toString()
        holder.itemView.totalPrice.text = "${item.price * item.quantity}"





    }

    override fun getItemCount(): Int {
        return cartList.size
    }
}