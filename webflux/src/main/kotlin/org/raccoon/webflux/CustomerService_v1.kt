package org.raccoon.webflux

interface CustomerService_v1 {
    fun getCustomer(id:Int):Customer?
    fun searchCustomers(nameFillter : String):List<Customer>
}
