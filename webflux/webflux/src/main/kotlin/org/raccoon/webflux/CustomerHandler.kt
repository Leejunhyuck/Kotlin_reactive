package org.raccoon.webflux

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.onErrorResume
import java.net.URI

@Component
class CustomerHandler(val customerService: CustomerService) {
    fun get(serverRequest: ServerRequest) =
        ok().body(customerService.getCustomer(serverRequest.pathVariable("id").toInt()))
                .flatMap { ok().body(fromObject(it)) }
                .switchIfEmpty(notFound().build())

    fun search (serverRequest: ServerRequest)= ok().body(customerService.serarCustomers(serverRequest.queryParam("nameFilter").orElse("")),Customer::class.java)
    fun create (serverRequest: ServerRequest)=customerService.createCustomer(serverRequest.bodyToMono()).flatMap{
        created(URI.create("/functional/customer/${it}")).build() // ${it.id}
    }.onErrorResume(Exception::class){
      badRequest().body(fromObject(ErrorResponse("error",it.message ?:"error")))
    }
}