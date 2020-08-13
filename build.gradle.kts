plugins {
    java
    application
}
repositories {
    jcenter()
}
dependencies {
    implementation("com.google.guava:guava:29.0-jre")
    implementation("log4j:log4j:1.2.17")
    testImplementation("org.assertj:assertj-core:3.16.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testImplementation("org.mockito:mockito-junit-jupiter:3.4.6")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
}
application {
    // Define the main class for the application.
    mainClassName = "org.paddy.App"
}
val test by tasks.getting(Test::class) {
    // Use junit platform for unit tests
    useJUnitPlatform()
}
