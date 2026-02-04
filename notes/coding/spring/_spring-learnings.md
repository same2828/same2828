# Table of Contents

- [Table of Contents](#table-of-contents)
- [Spring Reactive](#spring-reactive)
- [Random](#random)
- [Jackson](#jackson)
- [IntelliJ Idea Run Locally](#intellij-idea-run-locally)
- [Lombok](#lombok)
- [Fix Missing `jacoco.exec` When Generating Code Coverage Test Report](#fix-missing-jacocoexec-when-generating-code-coverage-test-report)

# Spring Reactive

Do not ever use `.block()`

- This blocks the thread and causes it to wait
- Analogy: Blocks the conveyor belt

Keep adding to the `Mono` or `Flux`

- Analogy: Keep adding to the conveyor belt

At the very end use `.subscribe()`

- This is very similar to `.block()` but it pulls all the `Mono`/`Flux` out of the conveyor belt

# Random

> Cannot "autowire" via constructor/field injection on class/instance/member attributes/fields/variables that have the `@Value` annotation

- I.e. CANNOT add `@AllArgsConstructor` or `@Autowired` on that field/variable since the variable's value will be dynamically injected by Spring (and we WONT have a global variable/bean to be managed by Spring)

> All values inside `${}` need to have a BACKUP/DEFAULT value using `:` in `${value:defaultValue}`

- `${CONTEXT + _ + ENV_VAR_ALL_CAPS + :defaultValue}` (note: all occurrences of `-` in CONTEXT become `_`)f

> Do NOT use `jsonNode.get("key").toString()` (it will add EXTRA ESCAPED QUOTES to existing strings)

- Use `jsonNode.get("key").asText()` instead

> If using `@Value("${parentVal.childVal}")` annotation on MEMBER VARIABLES, we can use `@NoArgsConstructor`

> When using `@ConfigurationProperties(prefix = "asdf")` on CLASS

- CANNOT use `@NoArgsConstructor` annotation/decorator -> Use `@Getter` and `@Setter` annotations/decorators instead
- CANNOT use `boolean` type on variables -> Use `Boolean` type instead

# Jackson

> If objectMapper is NOT respecting `objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)` or `objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)`
> then add the following annotation `@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)` ONTOP of the target/affected class

```java
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // <-- HERE
public class MyClass {
  //...
}
```

> Remove/comment out all occurrences of `@JsonProperty` annotation (causes unnecessary errors)

> When testing complex objects, the easiest way is to do

# IntelliJ Idea Run Locally

```sh
# Main Application
com.example.demo.framework.main.MainApplication

# Program Arguments
-Dbypass.header=true -Dspring.profiles.active=local # Assuming application-local.yml
-Dbypass.header=true --spring.config.location=/Users/same/dev/${USE_REPO_NAME_HERE}/src/main/resources/application-local.yml

# Environment Variables
ENV1=VALUE1;ENV2=VALUE2;ENV3=VALUE3
```

```sh
# Compile
mvn clean compile
# Compile + Run Tests
mvn clean install
# Troubleshooting: Forces a check for missing releases and updated snapshots on remote repositories
mvn clean compile -U
mvn clean install -U
# Skip compilation && execution of tests
mvn clean install -U -Dmaven.test.skip=true
# Skip execution of tests
mvn clean install -U -DskipTests
mvn spring-boot:run
mvn spring-boot:run -Dspring-boot.run.arguments=--debug
mvn spring-boot:run -Dspring-boot.run.profiles=local
mvn spring-boot:run -Dspring-boot.run.arguments=--debug -Dspring-boot.run.profiles=local
mvn dependency:tree | grep pkgOfInterest
mvn dependency:tree > maven-dependencies.txt
```

# Lombok

> If using `@Builder` annotation, you MUST also add `@AllArgsConstructor`, `@NoArgsConstructor` annotations

```java
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true) // <-- HERE
@AllArgsConstructor // <-- HERE
@NoArgsConstructor // <-- HERE
public class MyClass {
  //...
}
```

# Fix Missing `jacoco.exec` When Generating Code Coverage Test Report

> Add `<argLine>${argLine}</argLine>` to maven-surefire-report-plugin's `<configuration></configuration>` property

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-surefire-report-plugin</artifactId>
  <version>3.5.2</version>
  <configuration>
    <!-- Fix for missing jacoco.exec -->
    <argLine>${argLine}</argLine> <!-- HERE -->
    <!-- Generate reports even in test failure -->
    <testFailureIgnore>true</testFailureIgnore>
    <!-- Show @DisplayName -->
    <statelessTestsetReporter implementation="org.apache.maven.plugin.surefire.extensions.junit5.JUnit5Xml30StatelessReporter">
      <usePhrasedTestCaseMethodName>true</usePhrasedTestCaseMethodName>
    </statelessTestsetReporter>
  </configuration>
  <executions>
    <execution>
      <!-- During Maven's test phase -->
      <phase>test</phase>
      <goals>
        <!-- Execute the plugin goal of "report" -> maven-surefire-report-plugin:report -->
        <goal>report</goal>
      </goals>
    </execution>
  </executions>
</plugin>
```
