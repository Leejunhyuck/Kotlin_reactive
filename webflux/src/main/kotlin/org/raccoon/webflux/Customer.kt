package org.raccoon.webflux

data class Customer(var id: Int =0, val name:String ="", val telephone:Telephone? =null){
    data class Telephone(var contryCode: String = "", var telephoneNumber:String ="")
}