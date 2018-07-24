package org.example.hello_kotlin.entrypoint

import org.example.hello_kotlin.function.handle
import org.http4k.server.Netty
import org.http4k.server.asServer

fun main(args: Array<String>) {
    val port = 9000
    println("Starting web server...")
    ::handle.asServer(Netty(port)).start()
    println("Web server listening on http://localhost:$port")
}
