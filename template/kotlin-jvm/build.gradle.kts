import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

group = "org.example"
version = "0.1-SNAPSHOT"

buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		val shadowVer = "2.0.4"
		classpath("com.github.jengelman.gradle.plugins:shadow:$shadowVer")
	}
}

// Can't use Kotlin 1.2.51 due to a Gradle error (raises a IllegalStateException).
plugins {
	id("com.github.johnrengelman.shadow") version "2.0.4"
	kotlin("jvm") version "1.2.41"
	application
}

application {
	mainClassName = "org.example.function.MainKt"
}

val shadowJar by tasks.getting(ShadowJar::class) {
	baseName = rootProject.name
    classifier = ""
    manifest.attributes["Main-Class"] = application.mainClassName
}

repositories {
	mavenCentral()
}

dependencies {
	val kotlinVer = "1.2.41"

	compile(kotlin(module = "stdlib-jdk8", version = kotlinVer))
}
