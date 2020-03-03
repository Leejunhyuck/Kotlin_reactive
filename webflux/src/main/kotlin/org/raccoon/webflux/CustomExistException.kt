package org.raccoon.webflux

import java.lang.Exception

class CustomExistException (override val message:String):Exception(message)