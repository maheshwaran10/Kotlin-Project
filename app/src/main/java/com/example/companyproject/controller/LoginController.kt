package com.example.companyproject.controller

import com.example.companyproject.MvcPatternActivity
import com.example.companyproject.model.User

class LoginController(
    private val loginView: MvcPatternActivity
):ILoginController {

    override fun OnLogin(email: String?, password: String?) {
        val user = User(email, password)
        val loginCode = user.isValid()

        when (loginCode) {
            0 -> {
                loginView.OnLoginError("Please enter Email");
            }
            1 -> {
                loginView.OnLoginError("Please enter A valid Email");
            }
            2 -> {
                loginView.OnLoginError("Please enter Password");
            }
            3 -> {
                loginView.OnLoginError("Please enter Password greater the 6 char");
            }
            else -> {
                loginView.OnLoginSuccess("login Successful");
            }
        }

    }
}