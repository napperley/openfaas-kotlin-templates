package org.example.hello_kotlin.function

/** 
 * Handles a [request][req] to the OpenFaaS Function.
 * @param req The *incoming* function input.
 * @return Sends back the result.
 */
fun handle(req: String?) = 
	if (req != null && !req.isEmpty()) "Hello $req :), have a good Kotlin!"
	else ""
