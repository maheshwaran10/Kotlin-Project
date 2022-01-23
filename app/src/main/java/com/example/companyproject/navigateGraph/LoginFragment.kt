package com.example.companyproject.navigateGraph

import android.os.Bundle
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.companyproject.R

class LoginFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_login, container, false)
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        val userNamePattern = "^[a-zA-Z0-9](_(?!(\\.|_))|\\.(?!(_|\\.))|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]\$"
        val button=view.findViewById<Button>(R.id.login)
        val name=view.findViewById<EditText>(R.id.name)
        val password=view.findViewById<EditText>(R.id.password)
        val signUps=view.findViewById<TextView>(R.id.signUp)

        signUps.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        button.setOnClickListener {
            val userName=name.text.toString()
            val userPassword=password.text.toString()
            if(TextUtils.isEmpty(userName)){//name.isEmpty()
                name.error = "Enter Your Name"
                return@setOnClickListener
            }
            if (userName.matches(userNamePattern.toRegex())) {
                Toast.makeText(activity,"UserName is Valid",Toast.LENGTH_SHORT).show()
            }
            else {
                name.error="Minimum 6 Characters"
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(userPassword)){//name.isEmpty()
                password.error = "Enter Password"
                return@setOnClickListener
            }


            if (userPassword.matches(passwordPattern.toRegex())) {
               Toast.makeText(activity,"Login Success",Toast.LENGTH_SHORT).show()
            }
            else {
                password.error="InValid eg:Ma@1"
                return@setOnClickListener
            }
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }

        return view
    }

}