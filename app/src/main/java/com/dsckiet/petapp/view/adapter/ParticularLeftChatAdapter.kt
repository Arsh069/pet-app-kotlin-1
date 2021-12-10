package com.dsckiet.petapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dsckiet.petapp.R
import com.dsckiet.petapp.view.model.Message
import com.dsckiet.petapp.view.profilemodel.Profile
import kotlinx.android.synthetic.main.left_chat_msg.view.*

class ParticularLeftChatAdapter(private val context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var msgs: List<Message> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ProfileRecyclerAdapter.profileViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.left_chat_msg, parent, false), context
        )//messages is xml file
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ParticularLeftChatAdapter.LeftChatViewHolder -> {
                holder.bind(msgs.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
       return msgs.size
    }

    class LeftChatViewHolder(itemView: View, val context: Context) :
        RecyclerView.ViewHolder(itemView) {
            val text:TextView = itemView.left_text_msg
        fun bind(m:Message){
            text.setText(m.message)
        }
    }
}

