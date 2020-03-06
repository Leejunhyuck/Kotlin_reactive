package org.raccoon.configclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConfigclientApplication

fun main(args: Array<String>) {
	runApplication<ConfigclientApplication>(*args)
}
