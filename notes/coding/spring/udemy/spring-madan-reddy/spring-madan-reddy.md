# Table of Contents

- [Table of Contents](#table-of-contents)
- [Intro to Spring Framework](#intro-to-spring-framework)
  - [Inversion of Control (IoC)](#inversion-of-control-ioc)
  - [Dependency Injection (DI)](#dependency-injection-di)
  - [Spring Beans, Context, SpEL (Spring Expression Language)](#spring-beans-context-spel-spring-expression-language)
  - [Spring IoC Container](#spring-ioc-container)
- [Creating Beans inside Spring Context](#creating-beans-inside-spring-context)
  - [`@Bean` Annotation](#bean-annotation)
  - [`@Primary` Annotation](#primary-annotation)
  - [`@Component` Annotation](#component-annotation)
  - [Spring Stereotype Annotations](#spring-stereotype-annotations)
  - [`@Bean` Vs `@Component`](#bean-vs-component)
  - [`@PostConstruct` Annotation](#postconstruct-annotation)
  - [`@PreDestroy` Annotation](#predestroy-annotation)
  - [Adding New Beans Programatically](#adding-new-beans-programatically)
  - [Adding New Beans via XML Config](#adding-new-beans-via-xml-config)
- [Wiring Beans with `@Autowire`](#wiring-beans-with-autowire)
  - [No Wiring Example](#no-wiring-example)
  - [Wiring Beans Using Method Call](#wiring-beans-using-method-call)
  - [Wiring Beans Using Method Parameters](#wiring-beans-using-method-parameters)
  - [`@Autowired` annotation - Field Injection](#autowired-annotation---field-injection)
  - [`@Autowired` annotation - Setter Injection](#autowired-annotation---setter-injection)
  - [`@Autowired` annotation - Constructor Injection](#autowired-annotation---constructor-injection)
  - [`@Autowired` with Multiple Beans of Same Type](#autowired-with-multiple-beans-of-same-type)

https://github.com/eazybytes/spring

# Intro to Spring Framework

The Spring Framework (Spring) is a mature, powerful and highly flexible framework focused on building web applications in Java.

Spring Core contains following components:

- IoC (Inversion of Control)
- DI (Dependency Injection)
- Beans
- Context
- SpEL (Spring Expression Language)

## Inversion of Control (IoC)

Inversion of Control = IoC = the principle, where the control flow of a program is inverted: instead of the programmer controlling the flow of a program, the framework or service takes control of the program flow.

## Dependency Injection (DI)

Dependency Injection = DI = the pattern through which Inversion of Control achieved

Through Dependency Injection, the responsibility of creating objects is shifted from the application to the Spring IoC container

It reduces coupling between multiple objects as it is dynamically injected by the framework.

Advantages of IoC and DI

- Loose Coupling Between Components

## Spring Beans, Context, SpEL (Spring Expression Language)

Any normal Java class that is instantiated, assembled, and otherwise managed by a Spring IoC container is called Spring Bean.

These beans are created with the configuration metadata that you supply to the container either in the form of XML configs and Annotations.

Spring IoC Container manages the lifecycle of Spring Bean scope and injecting any required dependencies in the bean.

Context is like a memory location of your app in which we add all the object instances that we want the framework to manage.
By default, Spring doesn't know any of the objects you define in your application.
To enable Spring to see your objects, you need to add them to the context.

The SpEL provides a powerful expression language for querying and manipulating an object graph at runtime like setting and getting property values, property assignment, method invocation etc.

```
POJO (Plain Old Java Object)
      |
      v
Spring Framework
      |
      v
    Bean
```

## Spring IoC Container

The Spring IoC container is responsible for:

- Instantiating the application class
- Configuring the object
- Assembling the dependencies between the objects

There are 2 types of IoC containers

- `org.springframework.beans.factory.BeanFactory`
- `org.springframework.context.ApplicationContext`

  The Spring container uses dependency injection (DI) to manage the components/objects that make up an application.

# Creating Beans inside Spring Context

## `@Bean` Annotation

> `@Bean("beanNameCamelCased")`
>
> `@Configuration` annotation indicates that the class has `@Bean` definition methods
> Spring will automatically detect classes annotated with `@Component` during component scanning and register them as beans in the application context
>
> If using `@Bean`, the annotated method MUST return `new ...`

`@Bean` annotation lets Spring know that it needs to call this method when it initializes its context and adds the returned object/value to the Spring context/Spring IoC Container.

By default, Spring will consider the method name as the bean name

```java
package com.example.config;

import com.example.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

  @Bean("toyotaVehicle") // <-- HERE
  Vehicle toyotaVehicle() {
    return new Toyota();
  }

  @Bean(value = "lexusVehicle") // <-- HERE
  Vehicle lexusVehicle() {
    return new Lexus();
  }

  @Bean(name = "porscheVehicle") // <-- HERE
  Vehicle porscheVehicle() {
    return new Porsche();
  }
}
```

```java
package com.example.main;

import com.example.beans.Vehicle;
import com.example.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

    Vehicle v1 = context.getBean("toyotaVehicle", Vehicle.class);
    System.out.println("Vehicle name from Spring Context is: " + vehl.getName());

    Vehicle v2 = context.getBean("lexusVehicle", Vehicle.class);
    System.out.println("Vehicle name from Spring Context is: " + v2.getName());

    Vehicle v3 = context.getBean("porscheVehicle", Vehicle.class);
    System.out.println("Vehicle name from Spring Context is: " + v3.getName());
  }
}
```

## `@Primary` Annotation

When you have multiple beans of the same kind inside the Spring context, you can make one of them primary by using `@Primary` annotation.

`@Primary` bean is the one which Spring will choose if it has multiple options and you don't specify a name.

In other words, it is the default bean that Spring Context will consider in case of confusion due to multiple beans present of same type

## `@Component` Annotation

`@Component` is a Spring Stereotype Annotation used to create and add beans to the Spring Application Context

Using `@ComponentScan` annotation over the configuration class, instruct Spring on where to find the classes you marked with stereotype annotations

```java
package com.example.main;

import org.springframework.stereotype.Component;

@Component
public class Vehicle {
  private String brand;

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }
}
```

```java
package com.example.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.beans")
public class ProjectConfig {
  //...
}
```

## Spring Stereotype Annotations

| Annotation    | Description                                                                                                                      |
| ------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| `@Component`  | Used as general on top of any Java class. It is the base for other annotations.                                                  |
| `@Service`    | Used on top of the classes inside the service layer especially where we write business logic and make external API calls.        |
| `@Repository` | Used on top of the classes which handles the code related to Database access related operations like Insert, Update, Delete etc. |
| `@Controller` | Used on top of the classes inside the Controller layer of MVC applications.                                                      |

```
              @Component
    -----------------------------
    |            |              |
    v            v              v
@Service    @Repository    @Controller
```

## `@Bean` Vs `@Component`

| `@Bean`                                                                        | `@Component`                                             |
| ------------------------------------------------------------------------------ | -------------------------------------------------------- |
| Must exist INSIDE `@Configuration` class                                       | Can be used directly on top of any class                 |
| `@Bean` methods MUST return `new ...`                                          | Spring automatically creates the instance                |
| Method-level annotation                                                        | Class-level annotation                                   |
| Used for classes from external libraries (Jackson, JDBC drivers, HTTP clients) | Used for your own classes that you have control over     |
| Allows custom bean creation logic                                              | Simple bean creation with no custom logic                |
| Requires explicit configuration class                                          | Works with `@ComponentScan`                              |
| Bean name derived from method name (by default)                                | Bean name derived from class name (camelCase by default) |
| More control over instantiation process                                        | Less control, Spring handles instantiation               |
| Preferred when you need conditional bean creation                              | Preferred for straightforward component registration     |

| `@Bean`                                                                                      | `@Component`                                                                                |
| -------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------- |
| One or more instances of the class can be added to the Spring Context                        | Only one instance of the class can be added to the Spring context                           |
| We can create an object instance of any class from external libraries                        | We can create an object instance for application class only which are created by Dev team   |
| Usually we need to write more code like separate methods to create beans instances           | Bean instances can be created with very less code like using @Component on top of the class |
| Developer will have full control in creating and configuring the bean                        | Developer will not have any control in creating and configuring the bean                    |
| Spring framework creates the bean based on the instructions and values provided by developer | Spring framework takes charge of creating the bean                                          |

When you use third-party libraries (like Jackson, Hibernate, Apache Commons, etc.), you cannot add `@Component` annotation to those library classes because:

- You don't own the source code - the classes are in external JAR files
- You cannot modify them - they're compiled `.class` files, not `.java` files you can edit
- Recompiling isn't an option - even if you had the source, modifying library code is bad practice

Example: Let's say you want to use Jackson's ObjectMapper as a Spring bean:

❌ Cannot do this (because you don't own ObjectMapper class):

```java
// This is impossible - ObjectMapper is in jackson-databind.jar
@Component // ❌ You cannot add this to a third-party class
public class ObjectMapper {
  //...
}
```

✅ Must do this instead (using `@Bean`):

```java
@Configuration
public class AppConfig {
  @Bean  // ✅ Create a bean from a third-party class
  public ObjectMapper objectMapper() {
    ObjectMapper objMapper = new ObjectMapper();
    objMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    return objMapper;
  }
}`
```

## `@PostConstruct` Annotation

`@PostConstruct` Annotation instructs Spring to execute that a custom method AFTER bean creation/initialisation

```java
package com.example.main;

import org.springframework.stereotype.Component;
// import javax.annotation.PostConstruct;
import jakarta.annotation.PostConstruct;

@Component
public class Vehicle {
  private String brand;

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @PostConstruct // <-- HERE
  public void initBrand() {
    this.brand = "Toyota";
  }
}
```

## `@PreDestroy` Annotation

`@PreDestroy` Annotation is used on top of the methods that Spring should to call before clearing and destroying the context

- Useful for scenarios where we want to close any IO resources, database connections etc

```java
package com.example.main;

import org.springframework.stereotype.Component;
// import javax.annotation.PostConstruct;
import jakarta.annotation.PostConstruct;

@Component
public class Vehicle {
  private String brand;

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  @PostConstruct // <-- HERE
  public void destroy() {
    this.brand = null;
  }
}
```

## Adding New Beans Programatically

> Use `.registerBean()` on context object

```java
package com.example.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class VehicleConfig {
  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(VehicleConfig.class);

    Supplier<Vehicle> volkswagenSupplier = () -> {
      Vehicle vehicle = new Vehicle();
      vehicle.setBrand("Volkswagen");
      return vehicle;
    };

    context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier); // <-- HERE

    Vehicle volkswagen = (Vehicle) context.getBean("volkswagen");
    System.out.println("Vehicle brand: " + volkswagen.getBrand());

    context.close();
  }
}

class Vehicle {
  private String brand;

  public String getBrand() {
    return this.brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }
}
```

## Adding New Beans via XML Config

In initial versions of Spring, the bean and other configurations used to be done using XML.

But over the time, Spring team brings annotation based configurations to make developers life easy

```xml
<bean id="vehicle" class="com.example.beans.Vehicle">
  <property name="name" value="Honda" />
</bean>
```

# Wiring Beans with `@Autowire`

Inside Java web applications, usually the objects delegate certain responsibilities to other objects.

So in this scenarios, objects will have dependency on others.

In very similar lines when we create various beans using Spring, it our responsibility to understand the dependencies that beans have and wire them.

This concept inside is called Wiring/Autowiring

```
VehicleController -> VehicleService -> VehicleDAO
```

## No Wiring Example

Consider a scenario where we have two java classes Person and Vehicle.

The Person class has a dependency on the Vehicle.

Based on the below code, we are only creating the beans inside the Spring Context and no wiring will be done

Due to this both this beans present inside the Spring context with out knowing about each othe

```java
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Vehicle vehicle() {
    Vehicle vehicle = new Vehicle();
    vehicle.setName("Toyota");
    return vehicle;
  }

  @Bean
  public Person person() {
    Person person = new Person();
    person.setName("Lucy");
    return person;
  }
}
```

## Wiring Beans Using Method Call

```java
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Vehicle vehicle() {
    Vehicle vehicle = new Vehicle();
    vehicle.setName("Toyota");
    return vehicle;
  }

  @Bean
  public Person person() {
    Person person = new Person();
    person.setName("Lucy");
    person.setVehicle(vehicle()); // <-- HERE
    return person;
  }
}
```

## Wiring Beans Using Method Parameters

```java
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public Vehicle vehicle() {
    Vehicle vehicle = new Vehicle();
    vehicle.setName("Toyota");
    return vehicle;
  }

  @Bean
  public Person person(Vehicle vehicle) {
    Person person = new Person();
    person.setName("Lucy");
    person.setVehicle(vehicle); // <-- HERE
    return person;
  }
}
```

## `@Autowired` annotation - Field Injection

Note: `@Autowired(required = false)` will help to avoid the `NoSuchBeanDefinitionException` if the bean is not available during Autowiring process

```java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Person {
  private String name;

  @Autowired // <-- HERE (Field Injection)
  private Vehicle vehicle;

  // Getters and Setters
}
```

## `@Autowired` annotation - Setter Injection

```java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Person {
  private String name;

  private Vehicle vehicle;

  @Autowired // <-- HERE (Setter Injection)
  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  // Getters and Setters
}
```

## `@Autowired` annotation - Constructor Injection

```java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Person {
  private String name;

  private Vehicle vehicle;

  @Autowired // <-- HERE (Constructor Injection)
  public Person(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  // Getters and Setters
}
```

## `@Autowired` with Multiple Beans of Same Type

By default Spring tries autowiring with class type. But this approach will fail if the same class type has multiple beans.

If the Spring context has multiple beans of same class type, then Spring will try to auto-wire based on the parameter name/field name that we use while configuring autowiring annotation.

If no match for the parameter name/field name, then Spring will look for the bean which has `@Primary` annotation configured

If no match for the parameter name/field name and `@Primary` annotation, then Spring will look for the beans with the `@Qualifier` configured
