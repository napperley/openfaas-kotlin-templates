package org.example.hello_kotlin.entrypoint

import org.example.hello_kotlin.function.handle

fun main(args: Array<String>) {
	val resp = handle(readLine())
	println(resp)
}
