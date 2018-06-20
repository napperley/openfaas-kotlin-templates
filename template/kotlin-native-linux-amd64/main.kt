package function

import function.handler.handle

fun main(args: Array<String>) {
	val resp = handle(readLine())

	println(resp)
}
