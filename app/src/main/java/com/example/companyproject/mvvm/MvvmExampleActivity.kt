package com.example.companyproject.mvvm

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.companyproject.R

class MvvmExampleActivity : AppCompatActivity() {
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_example)
        Log.i(TAG, "onCreate")
        val recyclerView:RecyclerView=findViewById(R.id.rvContacts)
        val swipeContainer:SwipeRefreshLayout=findViewById(R.id.swipeContainer)

        val contacts = mutableListOf<Contact>()
        val contactAdapter = ContactAdapter(this, contacts)
        recyclerView.adapter = contactAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val model = ViewModelProviders.of(this)[MainActivityViewModel::class.java]
        model.getContacts().observe(this, Observer { contactsSnapshot ->
            // Update the UI
            Log.i(TAG, "Received contacts from view model")
            contacts.clear()
            contacts.addAll(contactsSnapshot)
            contactAdapter.notifyDataSetChanged()
        })
        model.getIsRefreshing().observe(this, Observer { isRefreshing ->
            Log.i(TAG, "Received isRefreshing from view model")
            swipeContainer.isRefreshing = isRefreshing
        })

        swipeContainer.setOnRefreshListener {
            // Show the refreshing UI and fetch new data
            model.fetchNewContact()
        }
    }
}