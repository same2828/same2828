# Table of Contents

- [Table of Contents](#table-of-contents)
- [Official Docs](#official-docs)
  - [MapStruct](#mapstruct)
- [Quick Guide to MapStruct - Baeldung](#quick-guide-to-mapstruct---baeldung)
  - [MapStruct and Transfer Object Pattern](#mapstruct-and-transfer-object-pattern)
  - [Maven](#maven)
  - [Basic Mapping](#basic-mapping)
    - [Creating a POJO](#creating-a-pojo)
    - [The Mapper Interface](#the-mapper-interface)
    - [The New Mapper](#the-new-mapper)
    - [Test Case](#test-case)
  - [Mapping With Dependency Injection](#mapping-with-dependency-injection)
    - [Modify the Mapper](#modify-the-mapper)
    - [Inject Spring Components into the Mapper](#inject-spring-components-into-the-mapper)
  - [Mapping Fields With Different Field Names](#mapping-fields-with-different-field-names)
    - [New POJOs](#new-pojos)
    - [The Mapper Interface](#the-mapper-interface-1)
    - [Test Case](#test-case-1)
  - [Mapping Beans With Child Beans](#mapping-beans-with-child-beans)
    - [Modify the POJO](#modify-the-pojo)
    - [Modify the Mapper](#modify-the-mapper-1)
    - [Modify the Test Case](#modify-the-test-case)
  - [Mapping With Type Conversion](#mapping-with-type-conversion)
    - [Modify the Beans](#modify-the-beans)
    - [Modify the Mapper](#modify-the-mapper-2)
    - [Modify the Test Case](#modify-the-test-case-1)
  - [Mapping With an Abstract Class](#mapping-with-an-abstract-class)
    - [Basic Model](#basic-model)
    - [Defining a Mapper](#defining-a-mapper)
    - [Generated Result](#generated-result)
  - [Before-Mapping and After-Mapping Annotations](#before-mapping-and-after-mapping-annotations)
    - [Basic Model](#basic-model-1)
    - [Defining the Mapper](#defining-the-mapper)
    - [Result](#result)
    - [Support for Lombok](#support-for-lombok)
  - [Support for defaultExpression](#support-for-defaultexpression)
  - [Test Case Code](#test-case-code)
- [Custom Mapper with MapStruct - Baeldung](#custom-mapper-with-mapstruct---baeldung)
  - [Maven Dependencies](#maven-dependencies)
  - [Custom Mapper](#custom-mapper)
    - [Custom Mapper With Method](#custom-mapper-with-method)
  - [Custom Mapper With an Annotation](#custom-mapper-with-an-annotation)
- [Ignoring Unmapped Properties with MapStruct - Baeldung](#ignoring-unmapped-properties-with-mapstruct---baeldung)
  - [Mapping](#mapping)
  - [Unmapped Properties](#unmapped-properties)
  - [Ignoring Specific Fields](#ignoring-specific-fields)
  - [Unmapped Target Policy](#unmapped-target-policy)
    - [Set a Policy on Each Mapper](#set-a-policy-on-each-mapper)
    - [Use a Shared MapperConfig](#use-a-shared-mapperconfig)
    - [Configuration Options](#configuration-options)
  - [The Order of Precedence](#the-order-of-precedence)
- [Using Multiple Source Objects with MapStruct - Baeldung](#using-multiple-source-objects-with-mapstruct---baeldung)
  - [Single Source Object](#single-source-object)
  - [Multiple Source Objects](#multiple-source-objects)
  - [Update Existing Objects with `@MappingTarget`](#update-existing-objects-with-mappingtarget)

# Official Docs

## MapStruct

- [MapStruct - JavaDocs](https://mapstruct.org/documentation/stable/api/)
- [MapStruct - Reference](https://mapstruct.org/documentation/stable/reference/html/)
- [MapStruct - Spring Extensions - Annotations JavaDoc](https://mapstruct.org/documentation/spring-extensions/api/annotations/)
- [MapStruct - Spring Extensions - Extensions JavaDoc](https://mapstruct.org/documentation/spring-extensions/api/extensions/)
- [MapStruct - Spring Extensions - Test Extensions JavaDoc](https://mapstruct.org/documentation/spring-extensions/api/test-extensions/)
- [MapStruct - Spring Extensions - Reference](https://mapstruct.org/documentation/spring-extensions/reference/html/)

What is it?

- MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach.
- The generated mapping code uses plain method invocations and thus is fast, type-safe and easy to understand.

Why?

- Multi-layered applications often require to map between different object models (e.g. entities and DTOs).
- Writing such mapping code is a tedious and error-prone task.
- MapStruct aims at simplifying this work by automating it as much as possible.
- In contrast to other mapping frameworks MapStruct generates bean mappings at compile-time which ensures a high performance, allows for fast developer feedback and thorough error checking.

How?

- MapStruct is an annotation processor which is plugged into the Java compiler and can be used in command-line builds (Maven, Gradle etc.) as well as from within your preferred IDE.
- MapStruct uses sensible defaults but steps out of your way when it comes to configuring or implementing special behavior.

# Quick Guide to MapStruct - Baeldung

- [Quick Guide to MapStruct - Baeldung](https://www.baeldung.com/mapstruct)

> MapStruct == A Java Bean mapper.

This API contains functions that automatically map between two Java Beans.

With MapStruct, we only need to create the interface, and the library will automatically create a concrete implementation during compile time.

## MapStruct and Transfer Object Pattern

For most applications, you'll notice a lot of boilerplate code converting POJOs to other POJOs.

E.g. A common type of conversion happens between persistence-backed entities and DTOs that go out to the client-side.

MapStruct solves the problem of "Manually creating bean mappers is time-consuming" by **generating bean mapper classes automatically**

## Maven

```xml
<dependency>
  <groupId>org.mapstruct</groupId>
  <artifactId>mapstruct</artifactId>
  <version>1.6.0</version>
</dependency>
```

Add the `<annotationProcessorPaths></annotationProcessorPaths>` section to the configuration part of the `maven-compiler-plugin` plugin.

The `mapstruct-processor` is used to generate the mapper implementation during the build:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.11.0</version>
  <configuration>
    <annotationProcessorPaths>
      <path>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>1.6.0</version>
      </path>
    </annotationProcessorPaths>
  </configuration>
</plugin>
```

## Basic Mapping

### Creating a POJO

```java
public class MySource {
  private String name;
  private String description;
  // getters and setters
}

public class MyDestination {
  private String name;
  private String description;
  // getters and setters
}
```

### The Mapper Interface

Note: Notice we did NOT create an implementation class for our `MySourceDestinationMapper` (because MapStruct creates it for us)

```java
import org.mapstruct.Mapper;
// import org.mapstruct.factory.Mappers;

@Mapper
public interface MySourceDestinationMapper {
  MyDestination sourceToDestination(MySource source);
  MySource destinationToSource(MyDestination destination);
  // MySourceDestinationMapper INSTANCE = Mappers.getMapper(MySourceDestinationMapper.class);
}
```

### The New Mapper

We can trigger the `MapStruct` processing by executing a `mvn clean install`

This will generate the implementation class under `/target/generated-sources/annotations/`

Here is the class that MapStruct autocreates for us:

```java
public class MySourceDestinationMapperImpl implements MySourceDestinationMapper {
  @Override
  public MyDestination sourceToDestination(MySource source) {
    if (source == null) {
      return null;
    }
    MyDestination MyDestination = new MyDestination();
    MyDestination.setName(source.getName());
    MyDestination.setDescription(source.getDescription());
    return MyDestination;
  }

  @Override
  public MySource destinationToSource(MyDestination destination) {
    if (destination == null) {
      return null;
    }
    MySource MySource = new MySource();
    MySource.setName(destination.getName());
    MySource.setDescription(destination.getDescription());
    return MySource;
  }
}
```

### Test Case

Write a test case showing that values in MySource match values in MyDestination:

```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MySourceDestinationMapperIntegrationTest {

  @Autowired
  MySourceDestinationMapper MySourceDestinationMapper;

  @Test
  public void givenSourceToDestination_whenMaps_thenCorrect() {
    MySource MySource = new MySource();
    MySource.setName("SourceName");
    MySource.setDescription("SourceDescription");
    MyDestination destination = MySourceDestinationMapper.sourceToDestination(MySource);
    assertEquals(MySource.getName(), destination.getName());
    assertEquals(MySource.getDescription(), destination.getDescription());
  }

  @Test
  public void givenDestinationToSource_whenMaps_thenCorrect() {
    MyDestination destination = new MyDestination();
    destination.setName("DestinationName");
    destination.setDescription("DestinationDescription");
    MySource source = MySourceDestinationMapper.destinationToSource(destination);
    assertEquals(destination.getName(), source.getName());
    assertEquals(destination.getDescription(), source.getDescription());
  }
}
```

## Mapping With Dependency Injection

We can manually obtain/get an instance of a mapper in MapStruct by calling `Mappers.getMapper(MyClass.class)`

A better alternative is to inject the mapper directly where we need it (via Dependency Injection solution)

MapStruct has solid support for both Spring and CDI (Contexts and Dependency Injection).

To use Spring IoC in our mapper, we need to add the `componentModel` attribute to `@Mapper` annotation with the value `spring`, and for CDI, it would be `cdi`

### Modify the Mapper

Add the following code to MySourceDestinationMapper:

```java
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MySourceDestinationMapper {
  MyDestination sourceToDestination(MySource source);
  MySource destinationToSource(MyDestination destination);
}
```

### Inject Spring Components into the Mapper

If we need to use other Spring components inside our mapping logic then we MUST to use an **abstract class instead of an interface**:

Note: Do NOT make the injected bean `private`

- This is because MapStruct has to access the object in the generated implementation class

```java
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class MySourceDestinationMapperUsingInjectedService {
  @Autowired
  protected MyService myService;

  @Mapping(target = "name", expression = "java(myService.enrichName(source.getName()))")
  public abstract MyDestination sourceToDestination(MySource source);
}
```

## Mapping Fields With Different Field Names

From our previous example, MapStruct was able to map our beans automatically because they have the same field names.

In the example below, we will be creating a new bean called `Employee` and `EmployeeDTO`

### New POJOs

```java
public class EmployeeDTO {
  private int employeeId;
  private String employeeName;
  // getters and setters
}

public class Employee {
  private int id;
  private String name;
  // getters and setters
}
```

### The Mapper Interface

When mapping different field names, we will need to configure its source field to
its target field and to do that, we will need to add `@Mapping` annotation for each field.

In MapStruct, we can also use dot (`.`) notation to define a member of a bean:

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
// import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
  // EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  @Mapping(target = "employeeId", source = "entity.id")
  @Mapping(target = "employeeName", source = "entity.name")
  EmployeeDTO employeeToEmployeeDTO(Employee entity);

  @Mapping(target = "id", source = "dto.employeeId")
  @Mapping(target = "name", source = "dto.employeeName")
  Employee employeeDTOtoEmployee(EmployeeDTO dto);
}
```

### Test Case

Test that both source and destination object values match:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeMapperTest {
  private EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

  @Test
  public void givenEmployeeDTOwithDiffNametoEmployee_whenMaps_thenCorrect() {
    EmployeeDTO dto = new EmployeeDTO();
    dto.setEmployeeId(1);
    dto.setEmployeeName("John");
    Employee entity = EmployeeMapper.employeeDTOtoEmployee(dto);
    assertEquals(dto.getEmployeeId(), entity.getId());
    assertEquals(dto.getEmployeeName(), entity.getName());
  }
}
```

## Mapping Beans With Child Beans

Showing how to map a bean with references to other beans.

### Modify the POJO

Add a new bean reference to the Employee object:

```java
public class EmployeeDTO {
  private int employeeId;
  private String employeeName;
  private DivisionDTO division;
  // getters and setters omitted
}

public class Employee {
  private int id;
  private String name;
  private Division division;
  // getters and setters omitted
}

public class Division {
  private int id;
  private String name;
  // default constructor, getters and setters omitted
}
```

### Modify the Mapper

Here we need to add a method to convert the `Division` to `DivisionDTO` and vice versa;

If MapStruct detects that the object type needs to be converted and the method to convert exists in the same class, it will use it automatically.

Let's add this to the mapper:

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
// import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
  // EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  @Mapping(target = "employeeId", source = "entity.id")
  @Mapping(target = "employeeName", source = "entity.name")
  EmployeeDTO employeeToEmployeeDTO(Employee entity);

  @Mapping(target = "id", source = "dto.employeeId")
  @Mapping(target = "name", source = "dto.employeeName")
  Employee employeeDTOtoEmployee(EmployeeDTO dto);

  DivisionDTO divisionToDivisionDTO(Division entity);

  Division divisionDTOtoDivision(DivisionDTO dto);
}
```

### Modify the Test Case

Let's modify and add a few test cases to the existing one:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeMapperNestedTest {

  private EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

  @Test
  public void givenEmpDTONestedMappingToEmp_whenMaps_thenCorrect() {
    EmployeeDTO dto = new EmployeeDTO();
    dto.setDivision(new DivisionDTO(1, "Division1"));
    Employee entity = EmployeeMapper.employeeDTOtoEmployee(dto);
    assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
    assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
  }
}
```

## Mapping With Type Conversion

MapStruct also offers a couple of ready-made implicit type conversions.
E.g. We will try to convert a `String` date to an actual `Date` object.

For more details on implicit type conversion see [MapStruct reference guide](https://mapstruct.org/documentation/stable/reference/html/)

### Modify the Beans

We add a start date for our employee:

```java
public class Employee {
  private int id;
  private String name;
  private Division division;
  private Date startDate; // <-- HERE
  // getters and setters
}

public class EmployeeDTO {
  private int employeeId;
  private String employeeName;
  private DivisionDTO division;
  private String employeeStartDate; // <-- HERE
  // getters and setters
}
```

### Modify the Mapper

We modify the mapper and provide the dateFormat for our start date:

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
  EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

  @Mapping(target = "employeeId", source = "entity.id")
  @Mapping(target = "employeeName", source = "entity.name")
  @Mapping(target = "employeeStartDt", source = "entity.startDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
  EmployeeDTO employeeToEmployeeDTO(Employee entity);

  @Mapping(target = "id", source = "dto.employeeId")
  @Mapping(target = "name", source = "dto.employeeName")
  @Mapping(target = "startDt", source = "dto.employeeStartDt", dateFormat = "dd-MM-yyyy HH:mm:ss")
  Employee employeeDTOtoEmployee(EmployeeDTO dto);

  DivisionDTO divisionToDivisionDTO(Division entity);

  Division divisionDTOtoDivision(DivisionDTO dto);
}
```

### Modify the Test Case

Verify the date conversion is correct:

```java
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeMapperTest {

  private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

  private EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);

  @Test
  public void givenEmpStartDtMappingToEmpDTO_whenMaps_thenCorrect() throws ParseException {
    Employee entity = new Employee();
    entity.setStartDt(new Date());
    EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
    assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
  }

  @Test
  public void givenEmpDTOStartDtMappingToEmp_whenMaps_thenCorrect() throws ParseException {
    EmployeeDTO dto = new EmployeeDTO();
    dto.setEmployeeStartDt("01-04-2016 01:00:00");
    Employee entity = mapper.employeeDTOtoEmployee(dto);
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
    assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
  }
}
```

## Mapping With an Abstract Class

Sometimes, we may want to customize our mapper in a way that exceeds `@Mapping` capabilities.

E.g. We may want to transform the values (in addition to type conversion)

In such cases, we can create an `abstract class` and implement methods we want to have customized, and leave abstract those that should be generated by `MapStruct`.

### Basic Model

```java
public class Transaction {
  private Long id;
  private String uuid = UUID.randomUUID().toString();
  private BigDecimal total;
  // getters
}

public class TransactionDTO {
  private String uuid;
  private Long totalInCents;
  // standard getters and setters
}
```

### Defining a Mapper

In the example above, the difficult part is to convert the BigDecimal total amount of dollars into a Long totalInCents.

We can achieve this by creating our Mapper as an abstract class:

Below, we've implemented our fully customized mapping method for a single object conversion.

On the other hand, we left the method to map Collection to a List abstract, so MapStruct will implement it for us.

```java
import org.mapstruct.Mapper;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Mapper
public abstract class TransactionMapper {

  public TransactionDTO toTransactionDTO(Transaction transaction) {
    TransactionDTO transactionDTO = new TransactionDTO();
    transactionDTO.setUuid(transaction.getUuid());
    transactionDTO.setTotalInCents(transaction.getTotal().multiply(new BigDecimal("100")).longValue());
    return transactionDTO;
  }

  public abstract List<TransactionDTO> toTransactionDTO(Collection<Transaction> transactions);
}
```

### Generated Result

Since we have already implemented the method to map a single `Transaction` into a `TransactionDTO`,
we expect `MapStruct` to use it in the second method.

The following will be generated:

```java
@Generated
class TransactionMapperImpl extends TransactionMapper {

  @Override
  public List<TransactionDTO> toTransactionDTO(Collection<Transaction> transactions) {
    if (transactions == null) {
      return null;
    }
    List<TransactionDTO> list = new ArrayList<>();
    for (Transaction transaction : transactions) {
      list.add(toTransactionDTO(transaction));
    }
    return list;
  }
}
```

## Before-Mapping and After-Mapping Annotations

Another way to customize `@Mapping` capabilities is to use `@BeforeMapping` and `@AfterMapping` annotations/decorators

These annotations are used to mark methods that are invoked right before and after the mapping logic.

They are quite useful in scenarios where we might want this behavior to be applied to all mapped super-types.

The example below maps the sub-types of `Car`: `ElectricCar` and `DieselCar` to `CarDTO`.

While mapping, we would like to map the notion of types to the `FuelType` enum field in the DTO.

Then after the mapping is done, we'd like to change the name of the DTO to uppercase.

### Basic Model

```java
public class Car {
  private int id;
  private String name;
}

public class DieselCar extends Car {}

public class ElectricCar extends Car {}

public class CarDTO {
  private int id;
  private String name;
  private FuelType fuelType;
}

public enum FuelType {
  ELECTRIC,
  DIESEL
}
```

### Defining the Mapper

Defining the abstract mapper class that maps `Car` to `CarDTO`:

Note: `@MappingTarget` annotation/decorator is a parameter annotation that populates
the target mapping DTO right before the mapping logic is executed in case of `@BeforeMapping`
and right after in case of `@AfterMapping` annotated method.

- [Read more on `@MappingTarget`](https://mapstruct.org/documentation/stable/reference/html/#updating-bean-instances)
  - In some cases you need mappings which do NOT create a new instance of the target type but instead update an existing instance of that type
  - This sort of mapping can be realized by adding a parameter for the target object and marking this parameter with the `@MappingTarget` annotation/decorator

```java
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class CarsMapper {
  @BeforeMapping
  protected void enrichDTOWithFuelType(Car car, @MappingTarget CarDTO carDto) {
    if (car instanceof ElectricCar) {
      carDto.setFuelType(FuelType.ELECTRIC);
    }
    if (car instanceof DieselCar) {
      carDto.setFuelType(FuelType.DIESEL);
    }
  }

  @AfterMapping
  protected void convertNameToUpperCase(@MappingTarget CarDTO carDto) {
    carDto.setName(carDto.getName().toUpperCase());
  }

  public abstract CarDTO toCarDto(Car car);
}
```

### Result

The `CarsMapper` defined above generates the following implementation:

Note: Notice how the annotated methods invocations (`enrichDTOWithFuelType` with `@BeforeMapping` and `convertNameToUpperCase` with `@AfterMapping`)
surround the mapping logic in the implementation.

```java
@Generated
public class CarsMapperImpl extends CarsMapper {

  @Override
  public CarDTO toCarDto(Car car) {
    if (car == null) {
      return null;
    }
    CarDTO carDTO = new CarDTO();
    enrichDTOWithFuelType(car, carDTO);
    carDTO.setId(car.getId());
    carDTO.setName(car.getName());
    convertNameToUpperCase(carDTO);
    return carDTO;
  }
}
```

### Support for Lombok

To enable Lombok support, we need to add the Lombok dependency in the `<annotationProcessorPaths>`

Since Lombok version 1.18.16, we also have to add the dependency on `lombok-mapstruct-binding`

Now we have the mapstruct-processor as well as Lombok in the Maven compiler plugin:

- https://mvnrepository.com/artifact/org.projectlombok/lombok

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.11.0</version>
  <configuration>
    <annotationProcessorPaths>
      <path>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>1.5.5.Final</version>
      </path>
      <path>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.30</version>
      </path>
      <path>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok-mapstruct-binding</artifactId>
        <version>0.2.0</version>
      </path>
    </annotationProcessorPaths>
  </configuration>
</plugin>
```

Let's define the source entity using Lombok annotations:

```java
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
  private int id;
  private String name;
}

@Getter
@Setter
public class CarDTO {
  private int id;
  private String name;
}
```

```java
import org.mapstruct.Mapper;
// import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
  // CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  CarDTO carToCarDTO(Car car);
}
```

## Support for defaultExpression

Starting with version 1.3.0, we can use the `defaultExpression` attribute of the `@Mapping` annotation
to specify an expression that determines the value of the destination field if the source field is `null`. .

This is in addition to the existing `defaultValue` attribute functionality.

The source entity:

```java
public class Person {
  private int id;
  private String name;
}
```

The destination data transfer object:

```java
public class PersonDTO {
  private int id;
  private String name;
}
```

If the `id` field of the source entity is `null`, we want to generate a random id
and assign it to the destination keeping other property values as-is:

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.UUID;

@Mapper
public interface PersonMapper {
  PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

  @Mapping(target = "id", source = "person.id", defaultExpression = "java(java.util.UUID.randomUUID().toString())")
  PersonDTO personToPersonDTO(Person person);
}
```

Test case to verify the expression execution:

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPersonMapping {

  @Test
  public void givenPersonEntitytoPersonWithExpression_whenMaps_thenCorrect() {
    Person entity = new Person();
    entity.setName("Tom");
    PersonDTO personDto = PersonMapper.INSTANCE.personToPersonDTO(entity);
    assertNull(entity.getId());
    assertNotNull(personDto.getId());
    assertEquals(personDto.getName(), entity.getName());
  }
}
```

## Test Case Code

```java
// tutorials/mapstruct/src/test/java/com/baeldung/mapper/EmployeeMapperUnitTest.java

package com.example.mapper;

import com.example.dto.DivisionDTO;
import com.example.dto.EmployeeDTO;
import com.example.entity.Division;
import com.example.entity.Employee;
import org.junit.Test;
import org.mapstruct.factory.Mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EmployeeMapperUnitTest {

  EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

  private static final String DATE_FORMAT = "dd-MM-yyyy HH:mm:ss";

  @Test
  public void givenEmployeeDTOwithDiffNametoEmployee_whenMaps_thenCorrect() {
    EmployeeDTO dto = new EmployeeDTO();
    dto.setEmployeeId(1);
    dto.setEmployeeName("John");

    Employee entity = mapper.employeeDTOtoEmployee(dto);

    assertEquals(dto.getEmployeeId(), entity.getId());
    assertEquals(dto.getEmployeeName(), entity.getName());
  }

  @Test
  public void givenEmployeewithDiffNametoEmployeeDTO_whenMaps_thenCorrect() {
    Employee entity = new Employee();
    entity.setId(1);
    entity.setName("John");

    EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);

    assertEquals(dto.getEmployeeId(), entity.getId());
    assertEquals(dto.getEmployeeName(), entity.getName());
  }

  @Test
  public void givenEmpDTONestedMappingToEmp_whenMaps_thenCorrect() {
    EmployeeDTO dto = new EmployeeDTO();
    dto.setDivision(new DivisionDTO(1, "Division1"));

    Employee entity = mapper.employeeDTOtoEmployee(dto);

    assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
    assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
  }

  @Test
  public void givenEmployeeWithNestedMappingToEmployeeDTO_whenMaps_thenCorrect() {
    Employee entity = new Employee();
    entity.setDivision(new Division(1, "Division1"));

    EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);

    assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
    assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
  }

  @Test
  public void givenEmployeeListToEmployeeDTOList_whenMaps_thenCorrect() {
    List<Employee> employeeList = new ArrayList<>();
    Employee emp = new Employee();
    emp.setId(1);
    emp.setName("EmpName");
    emp.setDivision(new Division(1, "Division1"));
    employeeList.add(emp);

    List<EmployeeDTO> employeeDtoList = mapper.convertEmployeeListToEmployeeDTOList(employeeList);
    EmployeeDTO employeeDTO = employeeDtoList.get(0);
    assertEquals(employeeDTO.getEmployeeId(), emp.getId());
    assertEquals(employeeDTO.getEmployeeName(), emp.getName());
    assertEquals(employeeDTO.getDivision().getId(), emp.getDivision().getId());
    assertEquals(employeeDTO.getDivision().getName(), emp.getDivision().getName());
  }

  @Test
  public void givenEmployeeDTOListToEmployeeList_whenMaps_thenCorrect() {
    List<EmployeeDTO> employeeDTOList = new ArrayList<>();
    EmployeeDTO empDTO = new EmployeeDTO();
    empDTO.setEmployeeId(1);
    empDTO.setEmployeeName("EmpName");
    empDTO.setDivision(new DivisionDTO(1, "Division1"));
    employeeDTOList.add(empDTO);

    List<Employee> employeeList = mapper.convertEmployeeDTOListToEmployeeList(employeeDTOList);
    Employee employee = employeeList.get(0);
    assertEquals(employee.getId(), empDTO.getEmployeeId());
    assertEquals(employee.getName(), empDTO.getEmployeeName());
    assertEquals(employee.getDivision().getId(), empDTO.getDivision().getId());
    assertEquals(employee.getDivision().getName(), empDTO.getDivision().getName());
  }

  @Test
  public void givenEmpStartDtMappingToEmpDTO_whenMaps_thenCorrect() throws ParseException {
    Employee entity = new Employee();
    entity.setStartDt(new Date());

    EmployeeDTO dto = mapper.employeeToEmployeeDTO(entity);
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
    assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
  }

  @Test
  public void givenEmpDTOStartDtMappingToEmp_whenMaps_thenCorrect() throws ParseException {
    EmployeeDTO dto = new EmployeeDTO();
    dto.setEmployeeStartDt("01-04-2016 01:00:00");

    Employee entity = mapper.employeeDTOtoEmployee(dto);
    SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
    assertEquals(format.parse(dto.getEmployeeStartDt()).toString(), entity.getStartDt().toString());
  }
}
```

# Custom Mapper with MapStruct - Baeldung

> The MapStruct library is used for mapping between Java bean types
> By using a custom mapper with MapStruct, we can customize the default mapping methods.

- [Custom Mapper with MapStruct - Baeldung](https://www.baeldung.com/mapstruct-custom-mapper)

## Maven Dependencies

Add the `mapstruct `library into our Maven pom.xml:

```xml
<dependency>
  <groupId>org.mapstruct</groupId>
  <artifactId>mapstruct</artifactId>
  <version>1.6.0</version>
</dependency>
```

To see the auto-generated methods inside the project's target folder, we have to add the `annotationProcessorPaths` to the `maven-compiler-plugin` plugin:

```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.5.1</version>
  <configuration>
    <source>1.8</source>
    <target>1.8</target>
    <annotationProcessorPaths>
      <path>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.6.0</version>
      </path>
    </annotationProcessorPaths>
  </configuration>
</plugin>
```

## Custom Mapper

Custom mappers are used to solve specific conversion requirements

1. Define a method to do the conversion.
2. Notify MapStruct about the method.
3. MapStruct will call the method to do the conversion from source to target.

E.g. An app that calculates the user's body mass index (BMI) report.

- To calculate BMI, we have to collect the user's body values.
- To convert imperial units to metric units, we can use the custom mapper methods.

There are two ways of using a custom mapper with MapStruct.

1. We can either call the custom method by typing it inside the `@Mapping` annotation's `qualifiedByName` property,
2. We can create an annotation for it.

Before we start, we have to define a DTO class to hold imperial values and a DTO class to hold metric values:

```java
public class UserBodyImperialValuesDTO {
  private int inch;
  private int pound;
  // constructor, getters, and setters
}
```

```java
public class UserBodyValues {
  private double kilogram;
  private double centimeter;
  // constructor, getters, and setters
}
```

### Custom Mapper With Method

To start using custom mappers, create an interface with the `@Mapper` annotation.

Then our custom method with the return type we want, and the argument we need to convert.

We have to use the `@Named` annotation with the value parameter to inform MapStruct about the custom mapper method.

Finally, we'll define the mapper interface method with the @Mapping annotation. Within this annotation, we'll tell MapStruct about the source type, target type, and the method it'll use:

```java
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface UserBodyValuesMapper {
  UserBodyValuesMapper INSTANCE = Mappers.getMapper(UserBodyValuesMapper.class);

  @Mapping(source = "inch", target = "centimeter", qualifiedByName = "inchToCentimeter")
  public UserBodyValues userBodyValuesMapper(UserBodyImperialValuesDTO dto);

  @Named("inchToCentimeter")
  public static double inchToCentimeter(int inch) {
    return inch * 2.54;
  }
}
```

```java
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class UserBodyValuesMapperTest {
  @Test
  public void testUserBodyValuesMapper() {
    UserBodyImperialValuesDTO dto = new UserBodyImperialValuesDTO();
    dto.setInch(10);
    UserBodyValues obj = UserBodyValuesMapper.INSTANCE.userBodyValuesMapper(dto);
    assertNotNull(obj);
    assertEquals(25.4, obj.getCentimeter());
  }
}
```

## Custom Mapper With an Annotation

To use a custom mapper with an annotation, define an annotation instead of using the `@Named` annotation

Inform MapStruct about the newly created annotation by specifying the `@Mapping` annotation's `qualifiedByName` parameter.

```java
import org.mapstruct.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.CLASS)
public @interface PoundToKilogramMapper {}
```

Add the `@PoundToKilogramMapper` annotation to our `poundToKilogram` method

Define the mapper interface method with the `@Mapping` annotation.

Within the mapping annotation, we'll tell MapStruct about the source type, the target type, and the annotation class that it'll use using the `qualifedByName` parameter

```java
import com.baeldung.dto.UserBodyImperialValuesDTO;
import com.baeldung.entity.UserBodyValues;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserBodyValuesMapper {

  UserBodyValuesMapper INSTANCE = Mappers.getMapper(UserBodyValuesMapper.class);

  @Mapping(source = "pound", target = "kilogram", qualifiedBy = PoundToKilogramMapper.class)
  @Mapping(source = "inch", target = "centimeter", qualifiedByName = "inchToCentimeter") // <-- HERE
  public UserBodyValues userBodyValuesMapper(UserBodyImperialValuesDTO dto);

  @Named("inchToCentimeter")
  public static double inchToCentimeter(int inch) {
    return inch * 2.54;
  }

  @PoundToKilogramMapper // <-- HERE
  public static double poundToKilogram(int pound) {
    return pound * 0.4535;
  }
}
```

```java
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class UserBodyValuesMapperTest {
  @Test
  public void testUserBodyValuesMapper() {
    UserBodyImperialValuesDTO dto = new UserBodyImperialValuesDTO();
    dto.setPound(100);
    UserBodyValues obj = UserBodyValuesMapper.INSTANCE.userBodyValuesMapper(dto);
    assertNotNull(obj);
    assertEquals(45.35, obj.getKilogram());
  }
}
```

# Ignoring Unmapped Properties with MapStruct - Baeldung

> In Java applications, we may wish to copy values from one type of Java bean to another
> To avoid long, error-prone code, we can use a bean mapper such as `MapStruct`
> While mapping identical fields with identical field names is very straightforward, we often encounter mismatched beans.
> Here we will look at how MapStruct handles partial mapping.

- [Ignoring Unmapped Properties with MapStruct - Baeldung](https://www.baeldung.com/mapstruct-ignore-unmapped-properties)

## Mapping

`MapStruct` is a Java annotation processor.

Therefore, all we need to do is to define the mapper interface and to declare mapping methods.

MapStruct will generate an implementation of this interface during compilation.

Let's start with two classes with the same field names:

```java
public class CarDTO {
  private int id;
  private String name;
}

public class Car {
  private int id;
  private String name;
}
```

Create a mapper interface:

```java
@Mapper
public interface CarMapper {
  CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

  CarDTO carToCarDTO(Car car);
}
```

Test our mapper

```java
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarMapperTest {

  @Test
  public void givenCarEntitytoCar_whenMaps_thenCorrect() {
    Car entity = new Car();
    entity.setId(1);
    entity.setName("Toyota");
    CarDTO carDto = CarMapper.INSTANCE.carToCarDTO(entity);
    assertThat(carDto.getId()).isEqualTo(entity.getId());
    assertThat(carDto.getName()).isEqualTo(entity.getName());
  }
}
```

## Unmapped Properties

As `MapStruct` operates at compile time, it can be faster than a dynamic mapping framework.
It can also generate error reports if mappings are incomplete (i.e. if not all target properties are mapped)

```java
Warning:(X,X) java: Unmapped target property: "propertyName".
```

We may prefer to handle things differently if the fields are missing on purpose.

```java
public class DocumentDTO {
  private int id;
  private String title;
  private String text;
  private List<String> comments;
  private String author;
}

public class Document {
  private int id;
  private String title;
  private String text;
  private Date modificationTime;
}
```

We have unique fields in both classes that are not supposed to be filled during mapping:

- Comments in DocumentDTO
- Author in DocumentDTO
- ModificationTime in Document

If we define a mapper interface, it will result in warning messages during the build:

```java
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapper {
  DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

  DocumentDTO documentToDocumentDTO(Document entity);

  Document documentDTOToDocument(DocumentDTO dto);
}
```

As we do NOT want to map these fields, we can exclude them from mapping in a few ways.

## Ignoring Specific Fields

To skip several properties in a particular mapping method, we can use the `ignore` property in the `@Mapping` annotation:

Here, we've provided the `field` name as the `target` and set `ignore` to `true` to show that it's not required for mapping.

However, this technique is NOT convenient for some cases i.e. when using big models with a large number of fields.

```java
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DocumentMapperMappingIgnore {
  DocumentMapperMappingIgnore INSTANCE = Mappers.getMapper(DocumentMapperMappingIgnore.class);

  @Mapping(target = "comments", ignore = true)
  @Mapping(target = "author", ignore = true)
  DocumentDTO documentToDocumentDTO(Document entity);

  @Mapping(target = "modificationTime", ignore = true)
  Document documentDTOToDocument(DocumentDTO dto);
}
```

## Unmapped Target Policy

To make things clearer and the code more readable, we can specify the `unmappedTargetPolicy`

To do this, we use the MapStruct` unmappedTargetPolicy` to provide our desired behavior when there is NO source field for the mapping:

- ERROR: Any unmapped target property will fail the build – this can help us avoid accidentally unmapped fields
- WARN: (default) warning messages during the build
- IGNORE: No output or errors

In order to ignore unmapped properties and get NO output warnings, we should assign the `IGNORE` value to the `unmappedTargetPolicy`

There are several ways to do this

### Set a Policy on Each Mapper

We can set the `unmappedTargetPolicy` to the `@Mapper` annotation causing **all its methods to IGNORE unmapped properties**

```java
import org.mapstruct.Mapper;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DocumentMapperUnmappedPolicy {
  // mapper methods
}
```

### Use a Shared MapperConfig

We can ignore unmapped properties in several mappers by setting the `unmappedTargetPolicy` via `@MapperConfig` to share a setting across several mappers.

Note: The shared config becomes very useful when there are multiple settings to standardize across several mappers.

First we create an annotated interface:

```java
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(unmappedTargetPolicy = ReportingPolicy.IGNORE) // <-- HERE
public interface IgnoreUnmappedMapperConfig {}
```

Then we apply that shared configuration to a mapper:

```java
import org.mapstruct.Mapper;

@Mapper(config = IgnoreUnmappedMapperConfig.class)
public interface DocumentMapperWithConfig { // <-- HERE
  // mapper methods
}
```

### Configuration Options

Finally, we can configure the MapStruct code generator's annotation processor options.

When using Maven, we can pass processor options using the `compilerArgs` parameter of the processor plug-in:

In the example below, we're ignoring the unmapped properties in the whole project.

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>${maven-compiler-plugin.version}</version>
      <configuration>
        <source>${maven.compiler.source}</source>
        <target>${maven.compiler.target}</target>
        <annotationProcessorPaths>
          <path>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>${org.mapstruct.version}</version>
          </path>
        </annotationProcessorPaths>
        <compilerArgs>
          <compilerArg>
            -Amapstruct.unmappedTargetPolicy=IGNORE
          </compilerArg>
        </compilerArgs>
      </configuration>
    </plugin>
  </plugins>
</build>
```

## The Order of Precedence

We might easily add more fields to a bean or its mapped counterpart and get a partial mapping without even noticing it.

So, it's probably a good idea to add a global setting through Maven configuration to make the build fail in case of partial mappings.

In order to allow unmapped properties in some of our mappers and override the global behavior,
we can combine the techniques, keeping in mind the order of precedence (from highest to lowest):

1. Ignoring specific fields at the mapper method-level
2. The policy on the mapper
3. The shared MapperConfig
4. The global configuration

# Using Multiple Source Objects with MapStruct - Baeldung

[Using Multiple Source Objects with MapStruct - Baeldung](https://www.baeldung.com/mapstruct-multiple-source-objects)

## Single Source Object

The most common use case for MapStruct is to map one object to another.

Example: We have a Customer class and a corresponding CustomerDTO

```java
class Customer {
  private String firstName;
  private String lastName;
  // getters and setters
}

class CustomerDto {
  private String forename;
  private String surname;
  // getters and setters
}
```

We can now define a mapper that maps a Customer object to a CustomerDto object:

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomerDtoMapper {

  @Mapping(source = "firstName", target = "forename")
  @Mapping(source = "lastName", target = "surname")
  CustomerDto from(Customer customer);
}
```

## Multiple Source Objects

Sometimes we want the target object having properties from multiple source objects.

Example: Shopping application.

We need to construct a delivery address to ship our goods:

```java
class DeliveryInfo {
  private String forename;
  private String surname;
  private String street;
  private String postalcode;
  private String county;
  // getters and setters
}
```

Each customer can have multiple addresses (home address, work address)

```java
class Address {
  private String street;
  private String postalcode;
  private String county;
  // getters and setters
}
```

We now need a mapper which creates the delivery address out of a customer and one of its addresses.

MapStruct supports this by having multiple source objects:

Note: When we have more than one parameter, we can use the `dot-notation` within the `@Mapping` annotation.

- E.g. To address the property `firstName` of the parameter named `customer` we simply write `"customer.firstName"`

Note: We are NOT limited to two source objects (can use as many as we want)

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface DeliveryInfoMapper {
  @Mapping(source = "customer.firstName", target = "forename")
  @Mapping(source = "customer.lastName", target = "surname")
  @Mapping(source = "address.street", target = "street")
  @Mapping(source = "address.postalcode", target = "postalcode")
  @Mapping(source = "address.county", target = "county")
  DeliveryInfo from(Customer customer, Address address);
}
```

Simple test to verify behaviour of mapper

```java
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DeliveryInfoMapperTest {

  @Test
  public void shouldMapCustomerAndAddressToDeliveryInfo() {
    // given a customer
    Customer customer = new Customer().setFirstName("Max")
      .setLastName("Powers");

    // and some address
    Address homeAddress = new Address().setStreet("123 Some Street")
      .setCounty("Nevada")
      .setPostalcode("89123");

    // when calling DeliveryInfoMapper::from
    DeliveryInfoMapper DeliveryInfoMapper = DeliveryInfoMapper.INSTANCE;
    DeliveryInfo deliveryInfo = DeliveryInfoMapper.from(customer, homeAddress);

    // then a new DeliveryInfo is created, based on the given customer and his home address
    assertEquals(deliveryInfo.getForename(), customer.getFirstName());
    assertEquals(deliveryInfo.getSurname(), customer.getLastName());
    assertEquals(deliveryInfo.getStreet(), homeAddress.getStreet());
    assertEquals(deliveryInfo.getCounty(), homeAddress.getCounty());
    assertEquals(deliveryInfo.getPostalcode(), homeAddress.getPostalcode());
  }
}
```

## Update Existing Objects with `@MappingTarget`

Up until now, we used mappers that create new instances of the target class.

With multiple source objects, we can now also provide an instance to be updated.

For example, let’s assume that we want to update the customer-related properties of a delivery address.
All we need is to have one of the parameters be the same type as returned by the method and annotate it with `@MappingTarget`:

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
interface DeliveryInfoMapper {
  @Mapping(source = "address.postalcode", target = "postalcode")
  @Mapping(source = "address.county", target = "county")
  DeliveryInfo updateAddress(@MappingTarget DeliveryInfo deliveryInfo, Address address);
}
```

Test

```java
import org.junit.Test;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public class DeliveryInfoMapperTest {

  private final DeliveryInfoMapper deliveryInfoMapper = Mappers.getMapper(DeliveryInfoMapper.class);

  @Test
  public void shouldUpdateDeliveryInfoWithNewAddress() {
    // given a delivery address
    DeliveryInfo deliveryInfo = new DeliveryInfo().setForename("Max")
      .setSurname("Powers")
      .setStreet("123 Some Street")
      .setCounty("Nevada")
      .setPostalcode("89123");

    // and some new address
    Address newAddress = new Address().setStreet("456 Some other street")
      .setCounty("Arizona")
      .setPostalcode("12345");

    // when calling DeliveryInfoMapper::updateAddress
    DeliveryInfo updatedDeliveryInfo = deliveryInfoMapper.updateAddress(deliveryInfo, newAddress);

    // then the *existing* delivery address is updated
    assertSame(deliveryInfo, updatedDeliveryInfo);
    assertEquals(deliveryInfo.getStreet(), newAddress.getStreet());
    assertEquals(deliveryInfo.getCounty(), newAddress.getCounty());
    assertEquals(deliveryInfo.getPostalcode(), newAddress.getPostalcode());
  }
}
```
