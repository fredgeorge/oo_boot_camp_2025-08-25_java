plugins {
    java
}

group = "com.nrkei.project.template"
version = "0.0.1-SNAPSHOT"

dependencies {
    implementation(project(":exercises"))

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    testRuntimeOnly(libs.junit.platform.launcher)
}

tasks.test {
    useJUnitPlatform()
}
