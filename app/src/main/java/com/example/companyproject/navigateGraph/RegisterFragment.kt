package com.example.companyproject.navigateGraph

import android.os.Bundle
import android.text.TextUtils
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


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.show()
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_register, container, false)
        val userNamePattern = "^[a-zA-Z0-9](_(?!(\\.|_))|\\.(?!(_|\\.))|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]\$"
        val passwordPattern = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$"
        val text=view.findViewById<TextView>(R.id.sign)
        val button=view.findViewById<Button>(R.id.register)
        val userName=view.findViewById<EditText>(R.id.userName)
        val userPhone=view.findViewById<EditText>(R.id.phoneNumber)
        val userPassword=view.findViewById<EditText>(R.id.password)
        val userConfirm=view.findViewById<EditText>(R.id.confirmPassword)
        text.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        button.setOnClickListener {
            val name=userName.text.toString()
            val phone=userPhone.text.toString()
            val pass=userPassword.text.toString()
            val confirm=userConfirm.text.toString()

            if(TextUtils.isEmpty(name)){//name.isEmpty()
                userName.error = "Enter your Name"
                return@setOnClickListener
            }
            if (name.matches(userNamePattern.toRegex())) {
                Toast.makeText(activity,"UserName is Valid",Toast.LENGTH_SHORT).show()
            }
            else {
                userName.error="Minimum 6 Characters"
                return@setOnClickListener
            }
            if (phone.length<10){
                userPhone.error = "Enter 10digit"
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(pass)){//name.isEmpty()
                userPassword.error = "Enter Password"
                return@setOnClickListener
            }
            if(pass.equals(confirm)){
                userPassword.clearFocus()
            }else{
                userConfirm.error="Password Not Matched"
                return@setOnClickListener
            }

            if (pass.matches(passwordPattern.toRegex())) {
                Toast.makeText(activity," Registered Successfully", Toast.LENGTH_SHORT).show()
            }
            else {
                userPassword.error="InValid eg:Ma@1"
                return@setOnClickListener
            }
            findNavController().navigate(R.id.action_registerFragment_to_homeFragment)

        }
        return view
    }

}