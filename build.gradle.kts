plugins {
    kotlin("jvm") version "1.5.10"
    id("com.google.protobuf") version "0.8.15"
}

allprojects {
    group = "me.dgahn"
    version = "0.0.1"

    apply(plugin = "kotlin")

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.1")
    }
}
