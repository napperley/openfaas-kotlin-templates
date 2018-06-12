package function.handler

/** 
 * Handles a [request][req] to the OpenFaaS Function.
 @param req The *incoming* function input.
 @return Sends back the result.
 */
internal fun handle(req: String?) = 
	if (req != null && !req.isEmpty()) "Hello $req :), have a good Kotlin!"
	else ""
