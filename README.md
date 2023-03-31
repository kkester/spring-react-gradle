# spring-react-gradle

### Overview

This PoC demonstrates the following architecture, design, and coding strategies:

1. A single JAR containing a React frontend and spring boot backend
2. React frontend utilizing react-router-dom and fetch
3. Gradle build file leveraging the `gradle-node-plugin`
4. Utilizing Lombok

### Running the POC

1. Execute `gradlew tasks` to see full list of tasks available with `gradle-node-plugin`
1. Execute `gradlew build --dry-run` to view list of steps included in build when using `gradle-node-plugin`
1. For the initial launch, run `gradlew npmSetup` and `gradlew npmInstall`
1. Execute `gradlew bootRun`

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#web)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#actuator)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
