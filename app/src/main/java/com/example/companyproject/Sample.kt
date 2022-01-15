package com.example.companyproject

fun main(){
    var emp=Employee()
    emp.age=20
    emp.name="mahesh"

    println(emp.age)
    println(emp.name)

    emp.let {
        println(it.name)
        println(it.age)
    }


}
data class Employee(var name:String="", var age:Int=18)