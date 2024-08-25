package com.example.alkye

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CardAdapter(private val eventList: List<CarsModel>,private val viewType:Boolean=true,private val showIcons:Boolean=false,private val onItemClick: (CarsModel) -> Unit) :
    RecyclerView.Adapter<CardAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
       val view= if(this.viewType){
             LayoutInflater.from(parent.context).inflate(R.layout.item_rv_cars, parent, false)
        }else{
        LayoutInflater.from(parent.context).inflate(R.layout.rv_items_recents, parent, false)
        }

        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.titleTextView.text = event.title
        holder.descriptionTextView.text = event.description
        holder.dateTextView.text = event.date
        if (showIcons) {
            holder.ivYoutube?.setImageDrawable(
                ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_instagram)
            )
            holder.ivFav?.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            val pos = position
            if (pos != RecyclerView.NO_POSITION) {
                onItemClick(eventList[pos])
            }
        }
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    inner class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.tv_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.tv_sub_title)
        val dateTextView: TextView = itemView.findViewById(R.id.tv_date)
        val ivYoutube: ImageView? = itemView.findViewById(R.id.iv_yt)
        val ivFav: ImageView? = itemView.findViewById(R.id.iv_share)
    }
}
