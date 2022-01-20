package com.example.companyproject.view

interface ILoginView {
    fun OnLoginSuccess(message: String?)
    fun OnLoginError(message: String?)
}