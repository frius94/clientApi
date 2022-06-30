import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
    id("org.openapi.generator") version "6.0.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.moshi:moshi:1.13.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")
    testImplementation(kotlin("test"))
}

openApiGenerate {
    generatorName.set("kotlin")
    inputSpec.set("$rootDir/src/main/resources/api-docs.yaml")
    outputDir.set("$buildDir/generated")
    apiPackage.set("com.pluralsight.conferencedemo.api")
    invokerPackage.set("com.pluralsight.conferencedemo.invoker")
    modelPackage.set("com.pluralsight.conferencedemo.model")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

sourceSets.main {
    java.srcDirs("src/main", "build/generated/src/main")
}