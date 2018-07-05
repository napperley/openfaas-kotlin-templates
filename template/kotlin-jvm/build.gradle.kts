group = "org.example"
version = "0.1-SNAPSHOT"

plugins {
	kotlin("jvm") version "1.2.41"
	application
}

application {
	mainClassName = "org.example.function.MainKt"
}

repositories {
	mavenCentral()
}

dependencies {
	val kotlinVer = "1.2.41"

	compile(kotlin(module = "stdlib-jdk8", version = kotlinVer))
}
