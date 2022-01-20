package com.example.companyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.companyproject.controller.ILoginController
import com.example.companyproject.controller.LoginController
import com.example.companyproject.view.ILoginView

class MvcPatternActivity : AppCompatActivity() , ILoginView {
    var email: EditText? = null
    var password: EditText? = null
    var loginb: Button? = null
    var loginPresenter: ILoginController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvc_pattern)
        email = findViewById(R.id.edtUserName)
        password = findViewById(R.id.edtPassword)
        loginb = findViewById(R.id.mButtonLogin)
        loginPresenter = LoginController(this)

        loginb?.setOnClickListener {
            (loginPresenter as LoginController).OnLogin(
                email?.text.toString(),
                password?.text.toString().trim()
            )
        }
    }

    override fun OnLoginSuccess(message: String?) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun OnLoginError(message: String?) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}