package com.dsckiet.petapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dsckiet.petapp.R
import com.dsckiet.petapp.view.model.ChatsItem

class ChatsAdapter(private val context: Context) : RecyclerView.Adapter<ChatsAdapter.ViewHolder>() {


    private var chatsList: ArrayList<ChatsItem> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chats, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val single = chatsList[position]
        Glide.with(context).load(single.profileImage).into(holder.profileImage)
        holder.name.text = single.name
        holder.lastMessage.text = single.messages
        holder.chatTime.text = single.chatTime


        //navigate to chat page
        holder.itemView.setOnClickListener {
           it.findNavController().navigate(R.id.action_forumFragment2_to_particularChatFragment)
        }
    }

    override fun getItemCount(): Int {
        return chatsList.size
    }

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage: ImageView = itemView.findViewById(R.id.chatItemProfileImage)
        val name: TextView = itemView.findViewById(R.id.chatItemName)
        val lastMessage: TextView = itemView.findViewById(R.id.chatItemLastMessage)
        val chatTime: TextView = itemView.findViewById(R.id.chatItemTime)
    }

    fun setData(element: ArrayList<ChatsItem>) {
        this.chatsList = element
        notifyDataSetChanged()
    }
}