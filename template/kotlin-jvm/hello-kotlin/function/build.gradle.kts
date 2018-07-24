// Can't use Kotlin 1.2.51 due to a Gradle error (raises a IllegalStateException).
plugins {
	id("java-library")
	kotlin("jvm") version "1.2.41"
}

dependencies {
	val kotlinVer = "1.2.41"
    val http4kVer = "3.33.2"
	implementation(kotlin(module = "stdlib-jdk8", version = kotlinVer))
	implementation("org.http4k:http4k-core:$http4kVer")
}
