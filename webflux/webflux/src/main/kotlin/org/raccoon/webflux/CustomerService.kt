package org.raccoon.webflux

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
    fun getCustomer(id:Int):Mono<Customer>
    fun serarCustomers(nameFilter: String): Flux<Customer>
    fun createCustomer(customerMono :Mono<Customer>):Mono<*>
}