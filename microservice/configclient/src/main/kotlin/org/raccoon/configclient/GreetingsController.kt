package org.raccoon.configclient

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingsController {

    @Value("\${microservice.example.greeting}")
    private lateinit var greetings:String

    @GetMapping("/greetings")
    fun greetings() = greetings

}