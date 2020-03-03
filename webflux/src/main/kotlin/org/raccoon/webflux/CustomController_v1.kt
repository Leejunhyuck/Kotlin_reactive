package org.raccoon.webflux

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomController_v1 {
    @Autowired
    private lateinit var customerService : CustomerServiceImpl_v1

    @GetMapping(value = ["/customer/{id}"])
    fun getCustomer(@PathVariable id: Int):ResponseEntity<Customer>{
        return ResponseEntity(Customer(id,"customer $id"),HttpStatus.OK)
    }
    @GetMapping(value= ["/customers"])
    fun getCustomers(@RequestParam(required = false,defaultValue = "") nameFilter: String){
        customerService.searchCustomers((nameFilter))

    }

}