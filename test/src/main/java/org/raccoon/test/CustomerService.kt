package org.raccoon.test

interface CustomerService {
    fun getCustomer(id:Int):Customer?
    fun getAllCustomer():List<Customer>
}