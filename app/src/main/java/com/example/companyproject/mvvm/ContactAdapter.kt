package com.example.companyproject.mvvm

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.companyproject.R
import com.example.companyproject.mvvm.ContactAdapter.*

class ContactAdapter(private val context: Context, private val contacts: List<Contact>)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    private val TAG = "ContactAdapter"

    // Usually involves inflating a layout from XML and returning the holder - THIS IS EXPENSIVE
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false))
    }

    // Returns the total count of items in the list
    override fun getItemCount() = contacts.size

    // Involves populating data into the item through holder - NOT expensive
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder at position $position")
        val contact = contacts[position]
        holder.bind(contact)
    }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val title2 =itemView.findViewById<TextView>(R.id.tvName)
        val description = itemView.findViewById<TextView>(R.id.tvAge)
        val image = itemView.findViewById<ImageView>(R.id.ivProfile)
        @SuppressLint("SetTextI18n")
        fun bind(contact: Contact) {
            title2.text= contact.name
            description.text = "Age: ${contact.age}"
            image.setImageResource(R.drawable.tajmahal)

        }
    }
}