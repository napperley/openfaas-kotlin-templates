import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		val shadowVer = "2.0.4"
		classpath("com.github.jengelman.gradle.plugins:shadow:$shadowVer")
	}
}

application {
	mainClassName = "org.example.hello_kotlin.entrypoint.MainKt"
}

// Can't use Kotlin 1.2.51 due to a Gradle error (raises a IllegalStateException).
plugins {
	kotlin("jvm") version "1.2.41"
	id("com.github.johnrengelman.shadow") version "2.0.4"
	application
}

val shadowJar by tasks.getting(ShadowJar::class) {
	baseName = rootProject.name
    classifier = ""
    manifest.attributes["Main-Class"] = application.mainClassName
}

dependencies {
	val kotlinVer = "1.2.41"
	val http4kVer = "3.33.2"

	compile(project(":function"))
	compile(kotlin(module = "stdlib-jdk8", version = kotlinVer))
	compile("org.http4k:http4k-server-netty:$http4kVer")
}
