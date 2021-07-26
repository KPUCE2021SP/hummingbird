package codevinci.com.kotlinretrofitrestexample.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codevinci.com.kotlinretrofitrestexample.R
import codevinci.com.kotlinretrofitrestexample.model.RecyclerViewItems
import kotlinx.android.synthetic.main.activity_user_details.*
import kotlinx.android.synthetic.main.profile_item_row.view.*

class RecyclerViewAdapter(var context: Context, var list: List<RecyclerViewItems>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvText.text = list[position].text

        //handle clicks
        holder.tvText.setOnClickListener{view->
            if(list[position].link!!.isNotBlank()){
                /*val intents = Intent(Intent.ACTION_VIEW, Uri.parse(list[position].link))
                context.startActivity(intents)*/
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var v = LayoutInflater.from(context).inflate(R.layout.profile_item_row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvText = itemView.tvText
    }
}
