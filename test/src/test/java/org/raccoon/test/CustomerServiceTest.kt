package org.raccoon.test

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest
class CustomerServiceTest {
    @Autowired
    lateinit var customerService: CustomerService


    @Test
    fun `we should get a customer with a valid id`() {
        val customer = customerService.getCustomer(1)
        assertNotNull(customer)
        assertEquals(customer?.name,"Kotlin")
    }

    @Test
    fun `we should get all customers`() {
        customerService.getAllCustomer()
        val customers = customerService.getAllCustomer()
        assertEquals(customers.size,3)
    }
}