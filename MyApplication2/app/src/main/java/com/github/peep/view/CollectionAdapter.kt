package com.github.peep.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.peep.R

//뷰 객체를 그려주는 ViewHolder와 Data와 View를 연결해주는 Adapter
class CollectionAdapter(private val context: Context) : RecyclerView.Adapter<CollectionAdapter.ViewHolder>() {
    var datas = mutableListOf<CollectionData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionAdapter.ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }
    //뷰 객체를 그려준다.
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val txtName = itemView.findViewById<TextView>(R.id.tv_rv_name)
        private val txtCount = itemView.findViewById<TextView>(R.id.tv_rv_count)
        private val imgProfile = itemView.findViewById<ImageView>(R.id.img_rv_photo)

        //뷰에 뿌려주는 함수
        fun bind(item: CollectionData){
            txtName.text = item.name
            txtCount.text = item.count.toString()
            Glide.with(itemView).load(item.img).into(imgProfile)
        }
    }
}