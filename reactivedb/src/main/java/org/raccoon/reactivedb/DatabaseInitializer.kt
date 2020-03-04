package org.raccoon.reactivedb

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoOperations
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


@Component
class DatabaseInitializer {
//    @Autowired
//    lateinit var customerRepository: CustomRepository
//    @Autowired
//    lateinit var mongoOperation :ReactiveMongoOperations
//
//    companion object {
//        val initialCustomers = listOf(Customer(1,"Kotlin"),
//                Customer(2,"Spring"),Customer(3,"Microservice"),
//                Customer(3,"aa", Customer.Telephone("44", "123")))
//    }
//
//    @PostConstruct
//    fun initData(){
//        customerRepository.saveAll(initialCustomers).subscribe{
//            println("Default customers created")
//        }
//    }
/*
    mongoOperation.collectionExists("Customers").subscribe{
        if(it != true)
            mongoOperation.createCollection("Customers").subscribe{
                println("Customers collections created")
            } else println("Customers collections already exist")
        customerRepository.saveAll(initialCustomers).subscribe {
            println("Default customers created")
        }

    }

 */
}