plugins {
    java
    application
}

group = "orika-demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation("ma.glasnost.orika", "orika-core", "1.5.4")
    testImplementation("junit", "junit", "4.12")
    testImplementation ("org.testng", "testng", "7.0.0")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

application {
    mainClassName = "mapper.ObjectAToObjectBDemo"
}

tasks {
    test {
        useTestNG()
    }
}