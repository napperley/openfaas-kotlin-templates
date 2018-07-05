package org.example.function

import org.example.function.handler.handle

fun main(args: Array<String>) {
	val resp = handle(readLine())
	println(resp)
}
