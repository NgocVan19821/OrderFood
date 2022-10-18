package com.example.orderfood.feature.checkout.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderfood.R
import com.example.orderfood.model.Address
import kotlinx.android.synthetic.main.item_address.view.*

class AddressAdapter (
    var address: ArrayList<Address>
):RecyclerView.Adapter<AddressAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return AddressAdapter.MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_address, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = address[position]
        holder.itemView.image.setImageResource(item.img)
        holder.itemView.name.text = item.name
        holder.itemView.location.text = item.address

    }

    override fun getItemCount(): Int {
        return address.size
    }

}