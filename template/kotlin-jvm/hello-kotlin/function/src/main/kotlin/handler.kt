package org.example.hello_kotlin.function

import org.http4k.core.Method
import org.http4k.core.Response
import org.http4k.core.Request
import org.http4k.core.Status

/**
 * Handles a [request][req] to the OpenFaaS Function.
 * @param req The *incoming* [request][Request].
 * @return Sends back the result as a [Response].
 */
fun handle(req: Request): Response = if (req.method == Method.POST && req.body.length > 0) {
    Response(status = Status.OK).body("Hello ${req.bodyString().trim()} :), have a good Kotlin!\n")
} else {
    Response(status = Status.NOT_ACCEPTABLE)
        .body("HTTP method must be POST, and the HTTP request must have a body.\n")
}
