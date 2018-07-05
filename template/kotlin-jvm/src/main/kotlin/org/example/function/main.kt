package org.example.function

import org.example.function.handler.handle

fun main(args: Array<String>) {
	print("What is your name: ")
	val resp = handle(readLine())
	println(resp)
}
