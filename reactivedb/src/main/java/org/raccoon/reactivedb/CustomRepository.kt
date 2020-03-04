package org.raccoon.reactivedb

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import javax.annotation.PostConstruct

@Repository
class CustomRepository(private val template: ReactiveMongoTemplate){
    companion object {
    val initialCustomers = listOf(Customer(1,"Kotlin"),
            Customer(2,"Spring"),Customer(3,"Microservice"),
            Customer(3,"aa", Customer.Telephone("44", "123")))
    }

    @PostConstruct
    fun initializeRepository() = initialCustomers.map(Customer::toMono).map(this::create).map(Mono<Customer>::subscribe)

    fun create(customer: Mono<Customer>) = template.save(customer)
}
//모노나 플럭스같은 리액티브 타입으로 작업을 수행하기 위해서 바꿈


/*
interface CustomRepository : ReactiveCrudRepository<Customer, Int>{
    fun create(customer: Mono<Customer>) = template.save(customer)
}
 */