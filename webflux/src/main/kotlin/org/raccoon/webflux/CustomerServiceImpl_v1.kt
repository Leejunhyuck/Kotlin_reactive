package org.raccoon.webflux

import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl_v1 : CustomerService_v1{
    companion object{
        val initialCustomers = arrayOf(Customer(1,"ko"), Customer(2,"Spring"),
                Customer(3,"Microservice", Customer.Telephone("+44","7123")))

    }
    val customers = ConcurrentHashMap<Int,Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int)= customers[id]

    override fun searchCustomers(nameFillter: String): List<Customer> =
            customers.filter{
                it.value.name.contains(nameFillter,true)}.map(Map.Entry<Int,Customer>::value).toList()

}