plugins {
    `java-base`
}

subprojects {
    apply(plugin = "java-base")

    extensions.configure<org.gradle.api.plugins.JavaPluginExtension> {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    repositories {
        mavenCentral()
    }
}
