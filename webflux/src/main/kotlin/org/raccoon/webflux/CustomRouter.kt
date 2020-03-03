package org.raccoon.webflux

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.toMono

@Component
class CustomRouter(private val customerHandler: CustomerHandler) {
//    @Autowired
//    lateinit var customerHandler : CustomerHandler

    @Bean
    fun customerRoutes()=router{
        "/functional".nest{
            "/customer".nest{
                GET("/{id}",customerHandler::get) }
                POST("/",customerHandler::create)
            "/customers".nest {
                GET("/",customerHandler::search)
            }
        }

    }

/*    GET("/"){
        it:ServerRequest->CustomerHandler.get(it)
    }
*/
}