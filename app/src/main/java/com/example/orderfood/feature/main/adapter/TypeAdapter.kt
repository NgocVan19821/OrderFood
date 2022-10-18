package com.example.orderfood.feature.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.orderfood.R
import com.example.orderfood.model.Type
import kotlinx.android.synthetic.main.item_type.view.*

class TypeAdapter(
    var listener: onItemListener,
    var typeList: ArrayList<Type>
):RecyclerView.Adapter<TypeAdapter.MyViewHolder>() {
    interface onItemListener{
        fun onClickItem(item: Type)
        fun onClickDelete(item: Type)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = typeList[position]
        holder.itemView.itemImg.setImageResource(item.img)
        holder.itemView.itemText.text = item.title

        holder.itemView.item.setOnClickListener {
            listener.onClickItem(item)
        }

        holder.itemView.itemImg.setOnClickListener {
            listener.onClickDelete(item)
        }
    }

    override fun getItemCount(): Int {
        return typeList.size
    }
}