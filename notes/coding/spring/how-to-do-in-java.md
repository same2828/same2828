# Table of Contents

- [Table of Contents](#table-of-contents)- [Table of Contents](#table-of-contents)
  - [Accessing Properties in Spring Boot (`@Value` + `@ConfigurationProperties`) - HowToDoInJava](#accessing-properties-in-spring-boot-value--configurationproperties---howtodoinjava)
    - [Register Properties Files with `@PropertySource`](#register-properties-files-with-propertysource)
      - [Spring Boot Automatically Loads `application.properties`](#spring-boot-automatically-loads-applicationproperties)
        - [How to Specify Which Spring Profile to Use](#how-to-specify-which-spring-profile-to-use)
      - [Loading Custom Properties Files](#loading-custom-properties-files)
      - [Duplicate Property Resolution](#duplicate-property-resolution)
    - [Inject Property Values with @Value](#inject-property-values-with-value)
      - [Insert a List of Values in an Array/List](#insert-a-list-of-values-in-an-arraylist)
    - [Bind Fields to Property Values with @ConfigurationProperties](#bind-fields-to-property-values-with-configurationproperties)
    - [Validate Property Values](#validate-property-values)
    - [Include Additional Configuration Files](#include-additional-configuration-files)
  - [JMeter Tutorial - HowToDoInJava](#jmeter-tutorial---howtodoinjava)
    - [Starting JMeter](#starting-jmeter)
    - [Creating a Test Plan](#creating-a-test-plan)
      - [Create Thread Group](#create-thread-group)
      - [Create HTTP Request](#create-http-request)
      - [Add Listener](#add-listener)
    - [Perform Load Testing](#perform-load-testing)

# Links

- Spring Framework
  - [Spring Tutorials](https://howtodoinjava.com/series/spring-tutorials/)
  - [Spring Framework - Folder](https://howtodoinjava.com/spring/)
- Spring Boot
  - [Spring Boot - Tutorial](https://howtodoinjava.com/spring-boot/)
  - [Spring Boot - Folder](https://howtodoinjava.com/tag/spring-boot/)
- JUnit5
  - [JUnit5 - Tutorial](https://howtodoinjava.com/junit-5-tutorial/)
    - Has been updated, need to add more
  - [JUnit5 - Folder](https://howtodoinjava.com/junit5/)
- Mockito
  - [Mockito - Tutorial](https://howtodoinjava.com/mockito/junit-mockito-example/)
  - [Mockito - Folder](https://howtodoinjava.com/mockito/)
  - [Mockito - Tag](https://howtodoinjava.com/tag/mockito/)
- Gson
  - [Gson - Tutorial](https://howtodoinjava.com/gson/gson/)
  - [Gson - Folder](https://howtodoinjava.com/gson/)
- Jackson
  - [Jackson - Tutorial](https://howtodoinjava.com/jackson/jackson-read-write-json/)
  - [Jackson - Folder](https://howtodoinjava.com/jackson/)
  - [Jackson - Tag](https://howtodoinjava.com/tag/jackson/)
- Java
  - [Java Libraries - Folder](https://howtodoinjava.com/java/library/)

## Accessing Properties in Spring Boot (`@Value` + `@ConfigurationProperties`) - HowToDoInJava

- [Accessing Properties in Spring Boot (`@Value` + `@ConfigurationProperties`) - HowToDoInJava](https://howtodoinjava.com/spring-boot/properties-with-spring-boot/)

### Register Properties Files with `@PropertySource`

The `@PropertySource` annotation is used to register the property files in a Spring application.

#### Spring Boot Automatically Loads `application.properties`

By default, Spring Boot automatically loads the `application.properties` whenever it starts up

We can access the properties defined in application.properties using `@Value` annotation.

Let us assume that we have the following `application.properties` file

```conf
# application.properties
application.name=Demo App
```

```yaml
# application.properties
application:
  name: Demo App
```

If we have to access this property in a Spring `@Component`, we can use the `@Value` annotation

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppProperties {
  @Value("${application.name}")
  private String appName;

  // Getter for appName
  public String getAppName() {
    return appName;
  }
}
```

In addition to `application.properties`, **Spring boot automatically loads the profile-specific property file**

- For example, if the active profile is `dev` then Spring boot will load the `application-dev.properties` file along with `application.properties` file.

**Note: If there are any conflicts between values in the two files, then the profile-specific file wins**

- Ideally, we should specify the default values in `application.properties` and override them with profile-specific values in `application-dev.properties` file.

##### How to Specify Which Spring Profile to Use

> 1. In application.properties or application.yml file:

```conf
spring-profiles.active=dev
```

```yaml
spring:
  profiles:
    active: dev
```

> 2. As a command-line argument:

```sh
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

```sh
java -jar your-application.jar --spring-profiles.active=dev
```

> 3. As an environment variable:

```sh
export SPRING_PROFILES_ACTIVE=dev
```

#### Loading Custom Properties Files

If we want to change which file Spring Boot reads by default then we can use the `spring.config.name` property

```conf
export SPRING_CONFIG_NAME=foo
```

Now when we run the spring boot application, it will load all the properties from `foo.properties` file.

If we have a different properties file or multiple properties files, then we can
explicitly use the `@PropertySources` annotation to specify those property files.

Note: Specifying `application.properties` is optional

```java
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
  @PropertySource("classpath:jms.properties"), // <-- HERE
  @PropertySource("classpath:datasource.properties") // <-- HERE
})
public class AppProperties {
  //...
}
```

Note: By default, `@PropertySource` does NOT load/support YAML/YML files

- "YAML files cannot be loaded by using the @PropertySource or @TestPropertySource annotations. So, in the case that you need to load values that way, you need to use a properties file."

Note: Ensure your custom YAML file is placed in the `src/main/resources` directory:

```java
// YamlPropertySourceFactory.java
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import java.io.Exception;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {
  @Override
  public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource)
    throws IOException {
    YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
    factory.setResources(encodedResource.getResource());
    Properties properties = factory.getObject();
    return new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
  }
}
```

```java
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import com.example.config.YamlPropertySourceFactory; // Import custom YamlPropertySourceFactory class here

@Component
@PropertySources({
  @PropertySource(value = "classpath:custom.yml", factory = YamlPropertySourceFactory.class)
})
public class AppProperties {
  //...
}
```

#### Duplicate Property Resolution

Note: If there are two or more properties with the SAME name then the property value will be chosen from the LAST occurrence in the property file.

Duplicate property values do NOT raise any exceptions

### Inject Property Values with @Value

The `@Value` is used at the field or method/constructor parameter level to initialize
the field with a default value expression populated from the property file.

- SpEL (Spring Expression Language) expressions can be used to inject values using `#{systemProperties.myProp}` syntax
- Property values can be injected using `${my.app.myProp}` style property placeholders.

**Note: We can also assign a default value to a property key using `:defaultValue` suffix**

- This helps in preventing the exception when the property key is missing or not found in the properties file.

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySources({
  @PropertySource("classpath:jms.properties"),
  @PropertySource("classpath:datasource.properties")
})
public class AppProperties {
  @Value("${application.name:My App}") // <-- HERE
  private String appName;

  @Value("${spring.datasource.url}") // <-- HERE
  private String datasourceUrl;

  public String getAppName() {
    return appName;
  }

  public String getDatasourceUrl() {
    return datasourceUrl;
  }

  public void setDatasourceUrl(String datasourceUrl) {
    this.datasourceUrl = datasourceUrl;
  }
}
```

#### Insert a List of Values in an Array/List

For reference, the property name and value are:

```conf
# application.properties
app.environments=local,dev,test,prod
```

```yaml
# application.yaml
app:
  environments: local,dev,test,prod
```

**Injecting Values into String[] array is supported**

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

  @Value("${app.environments}") // <-- HERE
  private String[] environments;

  // Getters and setters (optional)
  public String[] getEnvironments() {
    return environments;
  }

  public void setEnvironments(String[] environments) {
    this.environments = environments;
  }
}
```

**To inject these values into a List, we need to use the SpEL syntax**

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

  @Value("#{'${app.environments}'.split(',')}") // <-- HERE
  private String[] environmentList;

  // Getters and setters (optional)
  public String[] getEnvironments() {
    return environmentList;
  }

  public void setEnvironments(String[] environments) {
    this.environmentList = environments;
  }
}
```

### Bind Fields to Property Values with @ConfigurationProperties

The `@ConfigurationProperties` is used to bind the member fields in a bean with the property values defined in a properties file.

- Binding is either performed by calling setters on the annotated class or, if `@ConstructorBinding` is in use, by binding to the constructor parameters.

Note that contrary to `@Value`, SpEL expressions are NOT evaluated since property values are externalized.

For example, suppose we have the following properties in `application.properties` file.

```conf
# application.properties
spring.datasource.url=jdbc:h2:file:C:/temp/test
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.dialect=org.hibernate.dialect.H2Dialect
```

```yaml
spring:
  datasource:
    url: jdbc:h2:file:C:/temp/test
    username: sa
    password: ''
    driverClassName: org.h2.Driver
    dialect: org.hibernate.dialect.H2Dialect
```

To bind these properties in class fields, we need to **create fields with the exactly same name as the property name**

Note: We must mention the `prefix` (if any)

Note:

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;
// import lombok.Data;

// @Data
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceProps {
  private String url;
  private String username;
  private String password;
  private String driverClassName;
  private String dialect;
}
```

If the above properties are part of a separate file datasource.properties,
then we can use `@PropertySource` to specify the property file name.

```java
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import lombok.Data;

@Data
@Component
@PropertySource("classpath:datasource.properties")
@ConfigurationProperties(prefix = "spring.datasource")
public class DatasourceProps {
  private String url;
  private String username;
  private String password;
  private String driverClassName;
  private String dialect;
}
```

### Validate Property Values

Start with importing spring-boot-starter-validation module in the project

This module imports the hibernate-validator project that implements the JSR-303 specification.

- https://howtodoinjava.com/hibernate/hibernate-validator-java-bean-validation/
- https://howtodoinjava.com/spring-mvc/spring-bean-validation-example-with-jsr-303-annotations/

```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

For validating the field-property bindings, we can use `@Validated` annotation.

- It is a variant of JSR-303's `@Valid`, supporting the specification of validation groups.

In addition to `@Validated`, we need to apply specific constraints on the fields using the `javax.validation.constraints` annotations.

If any of these validations fail, then the application would fail to start with an `IllegalStateException`

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Component
@Validated
public class AppProperties {
  @NotEmpty
  @Value("${application.name}")
  private String appName;

  @NotEmpty
  @Value("${spring.datasource.url}")
  private String datasourceUrl;
}
```

### Include Additional Configuration Files

To include additional property files, we can use the `spring.config.import` property within the `application.properties` or `application.yml` file.

Imports are processed as they are discovered, and are treated as additional documents
inserted immediately below the one that declares the import.

For example, we can have the following import statement in `application.properties` file

```conf
application.name=Demo App
spring.config.import=optional:file:./dev.properties
```

```yaml
application:
  name: 'Demo App'

spring:
  config:
    import: 'optional:file:./dev.properties'
```

The above import will try to search and import the `dev.properties` file in the current working directory.

- If the file is found then its values will take precedence over the file that triggered the import.
- If the file is not found then no error is reported.

Note that the position of `spring.config.import` statement in the existing property file does NOT matter.
It will always produce the same result, as discussed above.

If we specify multiple locations then all the locations will be processed in the order that they are defined,
with later imports taking precedence. We can also specify a directory containing multiple property files.

```conf
spring.config.import=classpath:datasource.properties,
                      classpath:mysql-properties.yml,
                      optional:file:./cloud-deployment.properties,
                      classpath:test-properties/
```

```yaml
spring:
  config:
    import:
      - 'classpath:datasource.properties'
      - 'classpath:mysql-properties.yml'
      - 'optional:file:./cloud-deployment.properties'
      - 'classpath:test-properties/'
```

If a directory is imported then loaded files are sorted alphabetically.
If we need a different order, then we should list each location as a separate import.

The `spring.config.import` property can be set using the server startup arguments as well:

```sh
mvn spring-boot:run -Dspring-boot.run.arguments="--spring.config.import=\
  classpath:datasource.properties,\
  classpath:mysql-properties.properties,\
  optional:file:./cloud-deployment.properties,\
  classpath:test-properties/"
```

```sh
java -jar myproject.jar --spring.config.import=\
  classpath:datasource.properties,\
  classpath:mysql-properties.properties,\
  optional:file:./cloud-deployment.properties,\
  classpath:test-properties/
```

## JMeter Tutorial - HowToDoInJava

- [JMeter Tutorial - HowToDoInJava](https://howtodoinjava.com/java/library/jmeter-beginners-tutorial/)

### Starting JMeter

Navigate to `/jmeter/bin` and click on the `jmeter` executable

```sh
# Add JMeter Path
export PATH=$PATH:/path/to/jmeter/bin

# Launch JMeter GUI
jmeter
```

It will start the JMeter UI with no test plan initially.

![](https://howtodoinjava.com/wp-content/uploads/2018/11/JMeter-initial-screen.png)

### Creating a Test Plan

A useful test plan is created with minimum 3 components:

1. **Thread Group**

- Contains the simulation of multiple concurrent users
- A single thread represent a single user
- We can create any number of threads to put the desired load on the application
- It also help us in scheduling the delay between two threads, and any repetition of request batches

2. **HTTP Request**

- Consist the HTTP request configuration which thread group will be invoking
- It is the application URL which you want to load test

3. **Listener**:

- Helps in viewing the result of the whole testing process
- There are multiple listener available in JMeter to verify the testing results

#### Create Thread Group

To create a thread group, navigate to `Right click Test Plan > Add > Threads > Thread Group`

![](https://howtodoinjava.com/wp-content/uploads/2018/11/Create-Thread-Group-Option.png)

Fill in the values as per your requirements

Name the thread group and save it to any location in your workstation

![](https://howtodoinjava.com/wp-content/uploads/2018/11/Thread-Group-Created.png)

#### Create HTTP Request

To add HTTP request details, navigate to `Right click thread group > Add > Sampler > HTTP Request`

![](https://howtodoinjava.com/wp-content/uploads/2018/11/Create-HTTP-Request.png)

Fill in the application URL details which we are going to test.

In the example below we are using the rest api created for Spring boot hello world example

- The API URL is `http://localhost:8080/employees`
- https://howtodoinjava.com/spring-boot/spring-boot-hateoas-example/

![](https://howtodoinjava.com/wp-content/uploads/2018/11/Filled-HTTP-Request.png)

#### Add Listener

To see the results of test plan, add listener named "" by navigating to `Right click thread group > Add > Listener > View Results Tree`

![](https://howtodoinjava.com/wp-content/uploads/2018/11/Add-Listener.png)

### Perform Load Testing

To perform the load testing, start the thread group using the green play icon at the top ribbon in tool.

![](https://howtodoinjava.com/wp-content/uploads/2018/11/Start-Load-Test.png)

Let all threads run and invoke the configured application URL.

After the test is finished, we can review the load test results in consolidated manner in listener tab.

![](https://howtodoinjava.com/wp-content/uploads/2018/11/Load-testing-results.png)
