# Table of Contents

- [Table of Contents](#table-of-contents)
- [Gemini Output V1](#gemini-output-v1)
  - [1. Introduction to MapStruct](#1-introduction-to-mapstruct)
  - [2. Setup and Configuration](#2-setup-and-configuration)
    - [Maven Configuration](#maven-configuration)
  - [3. Basic Mapping](#3-basic-mapping)
    - [Source and Target Classes](#source-and-target-classes)
    - [Mapper Interface](#mapper-interface)
    - [Generated Implementation](#generated-implementation)
  - [4. Advanced: Multiple Source Parameters](#4-advanced-multiple-source-parameters)
    - [Source Classes](#source-classes)
    - [Target Class](#target-class)
    - [Mapper Interface](#mapper-interface-1)
    - [Generated Implementation](#generated-implementation-1)
  - [5. Advanced: Custom Mapping Functions (`@QualifiedByName`)](#5-advanced-custom-mapping-functions-qualifiedbyname)
    - [Scenario](#scenario)
    - [Source and Target](#source-and-target)
    - [Custom Mapper Logic](#custom-mapper-logic)
    - [Mapper Interface](#mapper-interface-2)
    - [Generated Implementation](#generated-implementation-2)
    - [Custom Logic with Multiple Source Parameters: `@QualifiedByName` vs `expression`](#custom-logic-with-multiple-source-parameters-qualifiedbyname-vs-expression)
      - [Approach 1: Using `expression` (Direct but fragile)](#approach-1-using-expression-direct-but-fragile)
      - [Approach 2: Using Custom Methods (`source = "."`)](#approach-2-using-custom-methods-source--)
  - [6. Advanced: Handling Collections](#6-advanced-handling-collections)
    - [Source and Target](#source-and-target-1)
    - [Mapper Interface](#mapper-interface-3)
    - [Generated Implementation](#generated-implementation-3)
    - [Map to Map Mapping](#map-to-map-mapping)
  - [7. Advanced: Enum Mapping](#7-advanced-enum-mapping)
    - [Source and Target Enums](#source-and-target-enums)
    - [Mapper Interface](#mapper-interface-4)
    - [Generated Implementation](#generated-implementation-4)
  - [8. Advanced: Nested Object Mapping](#8-advanced-nested-object-mapping)
    - [Source and Target](#source-and-target-2)
    - [Mapper Interface](#mapper-interface-5)
  - [9. Advanced: Updating Existing Instances (`@MappingTarget`)](#9-advanced-updating-existing-instances-mappingtarget)
    - [Mapper Interface](#mapper-interface-6)
    - [Generated Implementation](#generated-implementation-5)
  - [10. Advanced: Dependency Injection Integration](#10-advanced-dependency-injection-integration)
    - [Spring Integration](#spring-integration)
    - [Generated Implementation](#generated-implementation-6)
  - [11. Advanced: Expressions, Default Values, and Constants](#11-advanced-expressions-default-values-and-constants)
    - [Default Values](#default-values)
    - [Constants](#constants)
    - [Java Expressions](#java-expressions)
  - [12. Advanced: Lifecycle Hooks (`@BeforeMapping`, `@AfterMapping`)](#12-advanced-lifecycle-hooks-beforemapping-aftermapping)
  - [13. Advanced: Exception Handling](#13-advanced-exception-handling)
  - [14. Best Practices](#14-best-practices)
- [Gemini Output V2](#gemini-output-v2)
  - [1. Basic Object Mapping](#1-basic-object-mapping)
    - [Source Class](#source-class)
    - [Target Class](#target-class-1)
    - [Mapper Interface](#mapper-interface-7)
    - [Generated Implementation](#generated-implementation-7)
  - [2. Different Field Names](#2-different-field-names)
    - [Source Class](#source-class-1)
    - [Target Class](#target-class-2)
    - [Mapper Interface](#mapper-interface-8)
    - [Generated Implementation](#generated-implementation-8)
  - [3. Multiple Source Objects](#3-multiple-source-objects)
    - [Source Classes](#source-classes-1)
    - [Target Class](#target-class-3)
    - [Mapper Interface](#mapper-interface-9)
    - [Generated Implementation](#generated-implementation-9)
  - [4. Updating Existing Instances](#4-updating-existing-instances)
    - [Source Class](#source-class-2)
    - [Target Class](#target-class-4)
    - [Mapper Interface](#mapper-interface-10)
    - [Generated Implementation](#generated-implementation-10)
  - [5. Type Conversions](#5-type-conversions)
    - [Source Class](#source-class-3)
    - [Target Class](#target-class-5)
    - [Mapper Interface](#mapper-interface-11)
    - [Generated Implementation](#generated-implementation-11)
  - [6. Date and String Formatting](#6-date-and-string-formatting)
    - [Source Class](#source-class-4)
    - [Target Class](#target-class-6)
    - [Mapper Interface](#mapper-interface-12)
    - [Generated Implementation](#generated-implementation-12)
  - [7. Mapping Collections](#7-mapping-collections)
    - [Source Class](#source-class-5)
    - [Target Class](#target-class-7)
    - [Mapper Interface](#mapper-interface-13)
    - [Generated Implementation](#generated-implementation-13)
  - [8. Nested Bean Mappings](#8-nested-bean-mappings)
    - [Source Class](#source-class-6)
    - [Target Class](#target-class-8)
    - [Mapper Interface](#mapper-interface-14)
    - [Generated Implementation](#generated-implementation-14)
  - [9. Default Values and Constants](#9-default-values-and-constants)
    - [Source Class](#source-class-7)
    - [Target Class](#target-class-9)
    - [Mapper Interface](#mapper-interface-15)
    - [Generated Implementation](#generated-implementation-15)
  - [10. Java Expressions](#10-java-expressions)
    - [Source Class](#source-class-8)
    - [Target Class](#target-class-10)
    - [Mapper Interface](#mapper-interface-16)
    - [Generated Implementation](#generated-implementation-16)
    - [Enums from Package Dependencies in Expressions](#enums-from-package-dependencies-in-expressions)
  - [11. Mapping Enums](#11-mapping-enums)
    - [Source Class](#source-class-9)
    - [Target Class](#target-class-11)
    - [Mapper Interface](#mapper-interface-17)
    - [Generated Implementation](#generated-implementation-17)
  - [12. Custom Mapping Methods](#12-custom-mapping-methods)
    - [Mapper Interface](#mapper-interface-18)
    - [Generated Implementation](#generated-implementation-18)
  - [13. Using Other Mappers](#13-using-other-mappers)
    - [Specialized Mapper Hand Code](#specialized-mapper-hand-code)
    - [Mapper Interface](#mapper-interface-19)
    - [Generated Implementation](#generated-implementation-19)
  - [14. Before and After Mapping Callbacks](#14-before-and-after-mapping-callbacks)
    - [Mapper Abstract Class](#mapper-abstract-class)
    - [Generated Implementation](#generated-implementation-20)
  - [15. Object Factories](#15-object-factories)
    - [Factory Class](#factory-class)
    - [Mapper Interface](#mapper-interface-20)
    - [Generated Implementation](#generated-implementation-21)
  - [16. Conditional Mappings](#16-conditional-mappings)
    - [Mapper Interface](#mapper-interface-21)
    - [Generated Implementation](#generated-implementation-22)
  - [17. Exception Handling](#17-exception-handling)
    - [Source Class](#source-class-10)
    - [Target Class](#target-class-12)
    - [Mapper Interface](#mapper-interface-22)
    - [Generated Implementation](#generated-implementation-23)

# Gemini Output V1

## 1. Introduction to MapStruct

MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention-over-configuration approach.

Unlike reflection-based mapping frameworks (like Dozer or ModelMapper), MapStruct generates standard, readable, and highly performant Java code at compile time.

**Key Benefits:**

- **Performance:** Uses plain method invocations instead of reflection.
- **Compile-time Type Safety:** Errors in mappings are caught during compilation, not at runtime.
- **Readability:** The generated code is easy to read and debug.
- **No Runtime Dependencies:** The core annotations are only needed at compile time (unless using specific runtime features).

## 2. Setup and Configuration

To use MapStruct, you need to add the dependency and configure the annotation processor in your build tool.

### Maven Configuration

Add the following to your `pom.xml`:

```xml
<properties>
    <org.mapstruct.version>1.5.5.Final</org.mapstruct.version>
</properties>

<dependencies>
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>${org.mapstruct.version}</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.11.0</version>
            <configuration>
                <source>17</source>
                <target>17</target>
                <annotationProcessorPaths>
                    <path>
                        <groupId>org.mapstruct</groupId>
                        <artifactId>mapstruct-processor</artifactId>
                        <version>${org.mapstruct.version}</version>
                    </path>
                    <!-- If using Lombok, add lombok-mapstruct-binding -->
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
    </plugins>
</build>
```

## 3. Basic Mapping

MapStruct maps properties with the same name automatically. You only need to specify `@Mapping` when source and target property names differ.

### Source and Target Classes

```java
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    // getters and setters
}

public class UserDto {
    private Long id;
    private String givenName; // Differs from firstName
    private String surname;   // Differs from lastName
    private String email;
    // getters and setters
}
```

### Mapper Interface

```java
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "firstName", target = "givenName")
    @Mapping(source = "lastName", target = "surname")
    UserDto userToUserDto(User user);
}
```

### Generated Implementation

MapStruct generates a class named `UserMapperImpl` at compile time:

```java
public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto userToUserDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setGivenName(user.getFirstName());
        userDto.setSurname(user.getLastName());
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());

        return userDto;
    }
}
```

## 4. Advanced: Multiple Source Parameters

MapStruct allows you to map properties from multiple source objects into a single target object.

### Source Classes

```java
public class Address {
    private String street;
    private String city;
    private String zipCode;
    // getters and setters
}

public class Customer {
    private String firstName;
    private String lastName;
    // getters and setters
}
```

### Target Class

```java
public class DeliveryAddressDto {
    private String customerName;
    private String street;
    private String city;
    private String zipCode;
    // getters and setters
}
```

### Mapper Interface

When using multiple sources, you must prefix the source property with the parameter name.

```java
@Mapper
public interface DeliveryAddressMapper {

    @Mapping(source = "customer.firstName", target = "customerName")
    @Mapping(source = "address.street", target = "street")
    @Mapping(source = "address.city", target = "city")
    @Mapping(source = "address.zipCode", target = "zipCode")
    DeliveryAddressDto toDeliveryAddressDto(Customer customer, Address address);
}
```

### Generated Implementation

```java
public class DeliveryAddressMapperImpl implements DeliveryAddressMapper {
    @Override
    public DeliveryAddressDto toDeliveryAddressDto(Customer customer, Address address) {
        if (customer == null && address == null) {
            return null;
        }

        DeliveryAddressDto deliveryAddressDto = new DeliveryAddressDto();

        if (customer != null) {
            deliveryAddressDto.setCustomerName(customer.getFirstName());
        }
        if (address != null) {
            deliveryAddressDto.setStreet(address.getStreet());
            deliveryAddressDto.setCity(address.getCity());
            deliveryAddressDto.setZipCode(address.getZipCode());
        }

        return deliveryAddressDto;
    }
}
```

## 5. Advanced: Custom Mapping Functions (`@QualifiedByName`)

Sometimes, standard type conversions are not enough. You might need custom logic to map a specific field. MapStruct provides `@Named` and `@QualifiedByName` for this purpose.

### Scenario

You have a `String` representing a comma-separated list of roles, and you want to map it to a `List<String>`.

### Source and Target

```java
public class Employee {
    private String name;
    private String roles; // e.g., "ADMIN,USER,MANAGER"
    // getters and setters
}

public class EmployeeDto {
    private String name;
    private List<String> roleList;
    // getters and setters
}
```

### Custom Mapper Logic

Create a class or interface with the custom logic and annotate the method with `@Named`.

```java
import org.mapstruct.Named;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringToListMapper {

    @Named("commaSeparatedStringToList")
    public List<String> stringToList(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return Arrays.stream(str.split(","))
                     .map(String::trim)
                     .collect(Collectors.toList());
    }
}
```

### Mapper Interface

Use the `uses` attribute in `@Mapper` to include the custom mapper, and `@Mapping(qualifiedByName = ...)` to apply it.

```java
@Mapper(uses = StringToListMapper.class)
public interface EmployeeMapper {

    @Mapping(source = "roles", target = "roleList", qualifiedByName = "commaSeparatedStringToList")
    EmployeeDto toDto(Employee employee);
}
```

### Generated Implementation

```java
public class EmployeeMapperImpl implements EmployeeMapper {

    private final StringToListMapper stringToListMapper = new StringToListMapper();

    @Override
    public EmployeeDto toDto(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setName(employee.getName());
        employeeDto.setRoleList(stringToListMapper.stringToList(employee.getRoles()));

        return employeeDto;
    }
}
```

### Custom Logic with Multiple Source Parameters: `@QualifiedByName` vs `expression`

When a target property depends on multiple source objects or fields, you need to use Java `expression`

#### Approach 1: Using `expression` (Direct but fragile)

You can directly pass multiple sources to a custom mapping method natively using an inline `expression`

```java
@Mapper
public interface OrderMapper {
  // Calling a custom method via expression
  @Mapping(target = "description", expression = "java(mapDescription(customer.getName(), location.getAddress()))")
  OrderDto toDto(Customer customer, Location location);

  default String mapDescription(String name, String address) {
    if (customer == null || address == null) {
      return null;
    }
    return customer.getName() + " - " + address.getCity();
  }
}
```

**Pros:** Explicit control over which method is called and what variables are passed.
**Cons:** String-based code (`"java(...)"`), meaning errors are not caught until compilation. It breaks IDE refactoring and auto-complete tools for those arguments.

#### Approach 2: Using Custom Methods (`source = "."`)

Because an `@Mapping(source = "...", qualifiedByName = "...")` expects a **single** source field, it cannot easily pass multiple distinct source objects to a qualifier method purely by name mapping without trickery.

Instead, you can define a `default` method that takes the multiple source parameters and let MapStruct call it automatically. Or even explicitly pass `source = "."` to provide the current whole arguments to your custom logic (often used alongside `@QualifiedByName` if you have multiple matching methods).

```java
@Mapper
public interface OrderMapper {
    // Using source = "." passes the source context to a compatible custom method
    @Mapping(target = "description", source = ".", qualifiedByName = "combineToDesc")
    OrderDto toDto(Customer customer, Address address);

    @Named("combineToDesc")
    default String combineToDescription(Customer customer, Address address) {
        if (customer == null || address == null) return null;
        return customer.getName() + " - " + address.getCity();
    }
}
```

**Pros:** Type-safe, refactoring-friendly, clean interface. Standard MapStruct resolution capabilities.
**Cons:** Requires passing the whole source (`source = "."`) to cleanly wire up custom logic with multiple distinct sources, which can feel a little non-intuitive compared to standard single-property mappings.

**Summary:** Prefer custom methods with `source = "."` and `@QualifiedByName` for type safety and refactoring resilience. Use `expression` only when you need quick, uncomplicated concatenations or inline logic that does not warrant a separate method.

## 6. Advanced: Handling Collections

MapStruct handles collections (Lists, Sets, Maps) automatically. If it knows how to map the element type, it will generate a loop to map the collection.

### Source and Target

```java
public class Car {
    private String make;
    private String model;
    // getters and setters
}

public class CarDto {
    private String manufacturer;
    private String modelName;
    // getters and setters
}
```

### Mapper Interface

You define the mapping for the single element, and MapStruct uses it for the collection.

```java
@Mapper
public interface CarMapper {

    @Mapping(source = "make", target = "manufacturer")
    @Mapping(source = "model", target = "modelName")
    CarDto carToCarDto(Car car);

    // MapStruct automatically implements this using carToCarDto
    List<CarDto> carsToCarDtos(List<Car> cars);

    Set<CarDto> carsToCarDtoSet(Set<Car> cars);
}
```

### Generated Implementation

```java
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDto carToCarDto(Car car) {
        // ... standard mapping ...
    }

    @Override
    public List<CarDto> carsToCarDtos(List<Car> cars) {
        if (cars == null) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>(cars.size());
        for (Car car : cars) {
            list.add(carToCarDto(car));
        }

        return list;
    }
}
```

### Map to Map Mapping

MapStruct can also map `Map<K1, V1>` to `Map<K2, V2>`.

```java
@Mapper
public interface MapMapper {

    @MapMapping(keyTargetType = String.class, valueTargetType = CarDto.class)
    Map<String, CarDto> longCarMapToStringCarDtoMap(Map<Long, Car> map);
}
```

## 7. Advanced: Enum Mapping

Mapping between enums is straightforward. MapStruct maps enums by their exact name by default. If names differ, you use `@ValueMapping`.

### Source and Target Enums

```java
public enum OrderStatus {
    INITIATED,
    PROCESSING,
    DISPATCHED,
    DELIVERED,
    CANCELED
}

public enum ExternalOrderStatus {
    NEW,
    IN_PROGRESS,
    SHIPPED,
    COMPLETED,
    ABORTED,
    UNKNOWN
}
```

### Mapper Interface

```java
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;
import org.mapstruct.MappingConstants;

@Mapper
public interface OrderStatusMapper {

    @ValueMappings({
        @ValueMapping(source = "INITIATED", target = "NEW"),
        @ValueMapping(source = "PROCESSING", target = "IN_PROGRESS"),
        @ValueMapping(source = "DISPATCHED", target = "SHIPPED"),
        @ValueMapping(source = "DELIVERED", target = "COMPLETED"),
        @ValueMapping(source = "CANCELED", target = "ABORTED"),
        // Handle any unmapped source values
        @ValueMapping(source = MappingConstants.ANY_REMAINING, target = "UNKNOWN")
    })
    ExternalOrderStatus toExternal(OrderStatus status);
}
```

### Generated Implementation

```java
public class OrderStatusMapperImpl implements OrderStatusMapper {

    @Override
    public ExternalOrderStatus toExternal(OrderStatus status) {
        if (status == null) {
            return null;
        }

        ExternalOrderStatus externalOrderStatus;

        switch (status) {
            case INITIATED: externalOrderStatus = ExternalOrderStatus.NEW; break;
            case PROCESSING: externalOrderStatus = ExternalOrderStatus.IN_PROGRESS; break;
            case DISPATCHED: externalOrderStatus = ExternalOrderStatus.SHIPPED; break;
            case DELIVERED: externalOrderStatus = ExternalOrderStatus.COMPLETED; break;
            case CANCELED: externalOrderStatus = ExternalOrderStatus.ABORTED; break;
            default: externalOrderStatus = ExternalOrderStatus.UNKNOWN;
        }

        return externalOrderStatus;
    }
}
```

## 8. Advanced: Nested Object Mapping

MapStruct can map nested properties using dot notation.

### Source and Target

```java
public class Order {
    private Customer customer;
    // ...
}

public class Customer {
    private Record record;
    // ...
}

public class Record {
    private String ssn;
    // ...
}

public class OrderDto {
    private String customerSocialSecurityNumber;
    // ...
}
```

### Mapper Interface

```java
@Mapper
public interface OrderMapper {

    @Mapping(source = "customer.record.ssn", target = "customerSocialSecurityNumber")
    OrderDto toDto(Order order);
}
```

MapStruct will automatically generate null-safe checks for `customer` and `record` before accessing `ssn`.

## 9. Advanced: Updating Existing Instances (`@MappingTarget`)

Sometimes you don't want to create a new object, but update an existing one (e.g., updating an JPA entity from a DTO).

### Mapper Interface

Use the `@MappingTarget` annotation on the target parameter.

```java
@Mapper
public interface ProductMapper {

    @Mapping(target = "id", ignore = true) // Don't update the ID
    void updateProductFromDto(ProductDto dto, @MappingTarget Product entity);
}
```

### Generated Implementation

```java
public class ProductMapperImpl implements ProductMapper {

    @Override
    public void updateProductFromDto(ProductDto dto, Product entity) {
        if (dto == null) {
            return;
        }

        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        // id is ignored
    }
}
```

## 10. Advanced: Dependency Injection Integration

MapStruct integrates seamlessly with DI frameworks like Spring or CDI.

### Spring Integration

Set `componentModel = "spring"` in the `@Mapper` annotation.

```java
@Mapper(componentModel = "spring")
public interface UserServiceMapper {
    UserDto toDto(User user);
}
```

### Generated Implementation

MapStruct annotates the generated class with `@Component`.

```java
import org.springframework.stereotype.Component;

@Component
public class UserServiceMapperImpl implements UserServiceMapper {
    // ... implementation ...
}
```

You can now inject the mapper directly:

```java
@Service
public class UserService {
    private final UserServiceMapper mapper;

    public UserService(UserServiceMapper mapper) {
        this.mapper = mapper;
    }
}
```

## 11. Advanced: Expressions, Default Values, and Constants

### Default Values

If a source property is null, you can provide a default value.

```java
@Mapping(source = "description", target = "description", defaultValue = "No description provided")
```

### Constants

You can set a target property to a constant value, regardless of the source.

```java
@Mapping(target = "status", constant = "ACTIVE")
```

### Java Expressions

You can embed raw Java code. Use this sparingly as it breaks compile-time safety.

```java
@Mapping(target = "creationDate", expression = "java(new java.util.Date())")
@Mapping(target = "uuid", expression = "java(java.util.UUID.randomUUID().toString())")
```

## 12. Advanced: Lifecycle Hooks (`@BeforeMapping`, `@AfterMapping`)

You can execute custom logic before or after the mapping process.

```java
@Mapper
public abstract class VehicleMapper {

    @BeforeMapping
    protected void enrichDtoWithTimestamp(Vehicle vehicle, @MappingTarget VehicleDto dto) {
        dto.setMappingTime(System.currentTimeMillis());
    }

    @AfterMapping
    protected void convertNameToUpperCase(@MappingTarget VehicleDto dto) {
        if (dto.getName() != null) {
            dto.setName(dto.getName().toUpperCase());
        }
    }

    public abstract VehicleDto toDto(Vehicle vehicle);
}
```

MapStruct will insert calls to these methods at the beginning and end of the generated `toDto` implementation.

## 13. Advanced: Exception Handling

If your custom mapping methods throw checked exceptions, MapStruct can handle them.

```java
public class JsonMapper {
    public String toJson(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}

@Mapper(uses = JsonMapper.class)
public interface DocumentMapper {

    // The generated method will declare the exception
    DocumentDto toDto(Document document) throws JsonProcessingException;
}
```

## 14. Best Practices

1.  **Use `componentModel = "spring"` globally:** If using Spring, configure this in your `pom.xml` compiler plugin arguments so you don't have to add it to every `@Mapper`.
2.  **Keep Mappers Cohesive:** Create separate mappers for different domains (e.g., `UserMapper`, `OrderMapper`) rather than one giant `GlobalMapper`.
3.  **Prefer `@QualifiedByName` over Expressions:** Java expressions in `@Mapping` are hard to refactor and test. Custom methods are type-safe and testable.
4.  **Use `unmappedTargetPolicy = ReportingPolicy.ERROR`:** This forces you to explicitly map or ignore every target property, preventing bugs where new fields are added to a DTO but forgotten in the mapper.

```java
@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface StrictMapper { ... }
```

# Gemini Output V2

## 1. Basic Object Mapping

MapStruct will automatically map fields with the identical name and compatible types from the source to the target.

### Source Class

```java
package com.example.source;

public class User {
    private String name;
    private int age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

### Target Class

```java
package com.example.target;

public class UserDto {
    private String name;
    private int age;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDto toDto(User source);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User source) {
        if ( source == null ) {
            return null;
        }

        UserDto userDto = new UserDto();
        userDto.setName( source.getName() );
        userDto.setAge( source.getAge() );

        return userDto;
    }
}
```

## 2. Different Field Names

When mapping source to target objects where field names do not match, we use the `@Mapping` annotation to specify the target and source fields explicitly.

### Source Class

```java
package com.example.source;

public class Employee {
    private String empName;
    private Long empId;

    public String getEmpName() { return empName; }
    public void setEmpName(String empName) { this.empName = empName; }
    public Long getEmpId() { return empId; }
    public void setEmpId(Long empId) { this.empId = empId; }
}
```

### Target Class

```java
package com.example.target;

public class EmployeeDto {
    private String name;
    private Long id;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.Employee;
import com.example.target.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EmployeeMapper {
    @Mapping(target = "name", source = "empName")
    @Mapping(target = "id", source = "empId")
    EmployeeDto toDto(Employee employee);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.Employee;
import com.example.target.EmployeeDto;

public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto employeeDto = new EmployeeDto();

        employeeDto.setName( employee.getEmpName() );
        employeeDto.setId( employee.getEmpId() );

        return employeeDto;
    }
}
```

## 3. Multiple Source Objects

MapStruct allows mapping properties from multiple source objects into a single target object.

### Source Classes

```java
package com.example.source;

public class Customer {
    private String firstName;
    private String lastName;
    // ... getters and setters ...
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
}

public class Address {
    private String street;
    private String city;
    // ... getters and setters ...
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
```

### Target Class

```java
package com.example.target;

public class DeliveryAddress {
    private String givenName;
    private String surname;
    private String street;
    private String city;
    // ... getters and setters ...
    public String getGivenName() { return givenName; }
    public void setGivenName(String givenName) { this.givenName = givenName; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.Customer;
import com.example.source.Address;
import com.example.target.DeliveryAddress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DeliveryMapper {
    @Mapping(target = "givenName", source = "customer.firstName")
    @Mapping(target = "surname", source = "customer.lastName")
    // Note: MapStruct automatically finds matching property names for Address
    DeliveryAddress toDeliveryAddress(Customer customer, Address address);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.Address;
import com.example.source.Customer;
import com.example.target.DeliveryAddress;

public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public DeliveryAddress toDeliveryAddress(Customer customer, Address address) {
        if ( customer == null && address == null ) {
            return null;
        }

        DeliveryAddress deliveryAddress = new DeliveryAddress();

        if ( customer != null ) {
            deliveryAddress.setGivenName( customer.getFirstName() );
            deliveryAddress.setSurname( customer.getLastName() );
        }
        if ( address != null ) {
            deliveryAddress.setStreet( address.getStreet() );
            deliveryAddress.setCity( address.getCity() );
        }

        return deliveryAddress;
    }
}
```

## 4. Updating Existing Instances

Often, instead of creating a new Target bean, an existing instance needs to be updated with mapped properties using `@MappingTarget`.

### Source Class

```java
package com.example.source;

public class CarUpdate {
    private Integer limit;
    private String state;
    // getters/setters
    public Integer getLimit() { return limit; }
    public void setLimit(Integer limit) { this.limit = limit; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
}
```

### Target Class

```java
package com.example.target;

public class Car {
    private Integer speedLimit;
    private String registrationState;
    // getters/setters
    public Integer getSpeedLimit() { return speedLimit; }
    public void setSpeedLimit(Integer speedLimit) { this.speedLimit = speedLimit; }
    public String getRegistrationState() { return registrationState; }
    public void setRegistrationState(String registrationState) { this.registrationState = registrationState; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.CarUpdate;
import com.example.target.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface CarMapper {
    @Mapping(target = "speedLimit", source = "limit")
    @Mapping(target = "registrationState", source = "state")
    void updateCarFromDto(CarUpdate update, @MappingTarget Car car);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.CarUpdate;
import com.example.target.Car;

public class CarMapperImpl implements CarMapper {

    @Override
    public void updateCarFromDto(CarUpdate update, Car car) {
        if ( update == null ) {
            return;
        }

        if ( update.getLimit() != null ) {
            car.setSpeedLimit( update.getLimit() );
        }
        if ( update.getState() != null ) {
            car.setRegistrationState( update.getState() );
        }
    }
}
```

## 5. Type Conversions

MapStruct automatically provides type conversions for many primitive/wrapper types out of the box, for instance mapping a String representing a numerical value to an Integer.

### Source Class

```java
package com.example.source;

public class ProductDto {
    private String price;
    private Long id;
    // getters/setters
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
}
```

### Target Class

```java
package com.example.target;

public class Product {
    private double price;
    private String id;
    // getters/setters
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.ProductDto;
import com.example.target.Product;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {
    Product toEntity(ProductDto dto);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.ProductDto;
import com.example.target.Product;

public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        if ( dto.getPrice() != null ) {
            product.setPrice( Double.parseDouble( dto.getPrice() ) );
        }
        if ( dto.getId() != null ) {
            product.setId( String.valueOf( dto.getId() ) );
        }

        return product;
    }
}
```

## 6. Date and String Formatting

Implicit type formatting parameters can be strictly defined using properties like `dateFormat`.

### Source Class

```java
package com.example.source;

import java.time.LocalDate;

public class Event {
    private LocalDate eventDate;

    public LocalDate getEventDate() { return eventDate; }
    public void setEventDate(LocalDate eventDate) { this.eventDate = eventDate; }
}
```

### Target Class

```java
package com.example.target;

public class EventDto {
    private String dateOfEvent;

    public String getDateOfEvent() { return dateOfEvent; }
    public void setDateOfEvent(String dateOfEvent) { this.dateOfEvent = dateOfEvent; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.Event;
import com.example.target.EventDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EventMapper {
    @Mapping(target = "dateOfEvent", source = "eventDate", dateFormat = "dd-MM-yyyy")
    EventDto toDto(Event event);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.Event;
import com.example.target.EventDto;
import java.time.format.DateTimeFormatter;

public class EventMapperImpl implements EventMapper {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );

    @Override
    public EventDto toDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto eventDto = new EventDto();

        if ( event.getEventDate() != null ) {
            eventDto.setDateOfEvent( dateTimeFormatter.format( event.getEventDate() ) );
        }

        return eventDto;
    }
}
```

## 7. Mapping Collections

MapStruct handles Lists, Maps, and Sets out of the box. Mappings assigned for the element type will automatically be applied to collection parameters.

### Source Class

```java
package com.example.source;

import java.util.List;

public class Library {
    private List<User> subscribers;

    public List<User> getSubscribers() { return subscribers; }
    public void setSubscribers(List<User> subscribers) { this.subscribers = subscribers; }
}
```

### Target Class

```java
package com.example.target;

import java.util.Set;

public class LibraryDto {
    private Set<UserDto> subscribers;

    public Set<UserDto> getSubscribers() { return subscribers; }
    public void setSubscribers(Set<UserDto> subscribers) { this.subscribers = subscribers; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.Library;
import com.example.target.LibraryDto;
import com.example.source.User;
import com.example.target.UserDto;
import org.mapstruct.Mapper;
import java.util.Set;
import java.util.List;

@Mapper(uses = UserMapper.class) // References previously defined UserMapper
public interface LibraryMapper {
    LibraryDto toLibraryDto(Library library);

    Set<UserDto> mapUsers(List<User> users);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.Library;
import com.example.source.User;
import com.example.target.LibraryDto;
import com.example.target.UserDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.mapstruct.factory.Mappers;

public class LibraryMapperImpl implements LibraryMapper {

    private final UserMapper userMapper = Mappers.getMapper( UserMapper.class );

    @Override
    public LibraryDto toLibraryDto(Library library) {
        if ( library == null ) {
            return null;
        }

        LibraryDto libraryDto = new LibraryDto();

        libraryDto.setSubscribers( mapUsers( library.getSubscribers() ) );

        return libraryDto;
    }

    @Override
    public Set<UserDto> mapUsers(List<User> users) {
        if ( users == null ) {
            return null;
        }

        Set<UserDto> set = new LinkedHashSet<UserDto>( Math.max( (int) ( users.size() / .75f ) + 1, 16 ) );
        for ( User user : users ) {
            set.add( userMapper.toDto( user ) );
        }

        return set;
    }
}
```

## 8. Nested Bean Mappings

Dot notation allows deep drill-downs to extract or write details in nested class structures.

### Source Class

```java
package com.example.source;

public class Order {
    private Customer customer;

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}

// Assume Customer has address and Address has city (from earlier)
```

### Target Class

```java
package com.example.target;

public class OrderLocationDto {
    private String orderCity;

    public String getOrderCity() { return orderCity; }
    public void setOrderCity(String orderCity) { this.orderCity = orderCity; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.Order;
import com.example.target.OrderLocationDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrderMapper {
    @Mapping(target = "orderCity", source = "customer.address.city")
    OrderLocationDto toDto(Order order);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.Address;
import com.example.source.Customer;
import com.example.source.Order;
import com.example.target.OrderLocationDto;

public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderLocationDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderLocationDto orderLocationDto = new OrderLocationDto();

        orderLocationDto.setOrderCity( orderCustomerAddressCity( order ) );

        return orderLocationDto;
    }

    private String orderCustomerAddressCity(Order order) {
        if ( order == null ) {
            return null;
        }
        Customer customer = order.getCustomer();
        if ( customer == null ) {
            return null;
        }
        Address address = customer.getAddress();
        if ( address == null ) {
            return null;
        }
        return address.getCity();
    }
}
```

## 9. Default Values and Constants

Constants map direct fixed values, while default values are used when the source parameter evaluates to `null`.

### Source Class

```java
package com.example.source;

public class Config {
    private String theme;

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }
}
```

### Target Class

```java
package com.example.target;

public class OutputConfig {
    private String theme;
    private int version;

    public String getTheme() { return theme; }
    public void setTheme(String theme) { this.theme = theme; }
    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.Config;
import com.example.target.OutputConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ConfigMapper {
    @Mapping(target = "theme", source = "theme", defaultValue = "DARK_MODE")
    @Mapping(target = "version", constant = "1")
    OutputConfig toOutput(Config config);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.Config;
import com.example.target.OutputConfig;

public class ConfigMapperImpl implements ConfigMapper {

    @Override
    public OutputConfig toOutput(Config config) {
        if ( config == null ) {
            return null;
        }

        OutputConfig outputConfig = new OutputConfig();

        if ( config.getTheme() != null ) {
            outputConfig.setTheme( config.getTheme() );
        }
        else {
            outputConfig.setTheme( "DARK_MODE" );
        }

        outputConfig.setVersion( 1 );

        return outputConfig;
    }
}
```

## 10. Java Expressions

For complex mappings, custom pure-Java snippets can be included via `expression`. Use this sparingly as it mixes generated code with raw literals avoiding compiler safety checks.

### Source Class

```java
package com.example.source;
import java.util.UUID;

public class Document {
    private String title;
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
}
```

### Target Class

```java
package com.example.target;

public class TargetDocument {
    private String title;
    private String id;
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.Document;
import com.example.target.TargetDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(imports = java.util.UUID.class)
public interface DocumentMapper {
    @Mapping(target = "id", expression = "java(UUID.randomUUID().toString())")
    TargetDocument toTarget(Document document);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.Document;
import com.example.target.TargetDocument;
import java.util.UUID;

public class DocumentMapperImpl implements DocumentMapper {

    @Override
    public TargetDocument toTarget(Document document) {
        if ( document == null ) {
            return null;
        }

        TargetDocument targetDocument = new TargetDocument();

        targetDocument.setTitle( document.getTitle() );

        targetDocument.setId( UUID.randomUUID().toString() );

        return targetDocument;
    }
}
```

### Enums from Package Dependencies in Expressions

When using Java `expression`s to assign Enum values that come from external package dependencies, you must use the **fully qualified class name** of the Enum. Because expressions are raw Java strings, MapStruct does not analyze them to automatically add standard imports for resolving those specific types.

Alternatively, you can manually declare the Enum import using the `imports` attribute on the `@Mapper` annotation so that its standard name is available inside the `expression`.

```java
// Option 1: Using Fully Qualified Class Name in the expression
@Mapper
public interface DocumentMapper {
    @Mapping(target = "status", expression = "java(com.external.dependency.DocumentStatus.ACTIVE)")
    TargetDocument toTarget(Document document);
}

// Option 2: Using @Mapper(imports = ...)
@Mapper(imports = { com.external.dependency.DocumentStatus.class })
public interface DocumentMapperWithImport {
    @Mapping(target = "status", expression = "java(DocumentStatus.ACTIVE)")
    TargetDocument toTargetWithImport(Document document);
}
```

## 11. Mapping Enums

MapStruct can map between Enum values, even matching different enum constants if defined.

### Source Class

```java
package com.example.source;

public enum OrderType {
    RETAIL, B2B, EXTRA, STANDARD
}
```

### Target Class

```java
package com.example.target;

public enum ExternalOrderType {
    RETAIL, COMMERCIAL, NORMAL
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.OrderType;
import com.example.target.ExternalOrderType;
import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

@Mapper
public interface EnumMapper {

    @ValueMappings({
        @ValueMapping(source = "B2B", target = "COMMERCIAL"),
        @ValueMapping(source = "STANDARD", target = "NORMAL"),
        @ValueMapping(source = "EXTRA", target = "NORMAL")
    })
    ExternalOrderType mapEnum(OrderType orderType);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.OrderType;
import com.example.target.ExternalOrderType;

public class EnumMapperImpl implements EnumMapper {

    @Override
    public ExternalOrderType mapEnum(OrderType orderType) {
        if ( orderType == null ) {
            return null;
        }

        ExternalOrderType externalOrderType;

        switch ( orderType ) {
            case B2B: externalOrderType = ExternalOrderType.COMMERCIAL;
            break;
            case STANDARD: externalOrderType = ExternalOrderType.NORMAL;
            break;
            case EXTRA: externalOrderType = ExternalOrderType.NORMAL;
            break;
            case RETAIL: externalOrderType = ExternalOrderType.RETAIL;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + orderType );
        }

        return externalOrderType;
    }
}
```

## 12. Custom Mapping Methods

When a mapping is too complex to annotate, generic Java mapping code can be embedded using `default` interface methods or abstract classes.

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CustomUserMapper {
    @Mapping(target = "name", source = "name")
    UserDto toDto(User user);

    default String customNameModifier(String name) {
        return name != null ? name.toUpperCase() : null;
    }
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;

public class CustomUserMapperImpl implements CustomUserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        // Internally leverages custom method for strings if matched or called
        userDto.setName( user.getName() );

        return userDto;
    }
}
```

## 13. Using Other Mappers

Often a mapper needs standard converters or other specialized mappers. These can be wired seamlessly via the `uses` parameter.

### Specialized Mapper Hand Code

```java
package com.example.mapper;

public class StringUtils {
    public String capitalize(String in) {
        if(in == null) return null;
        return in.toUpperCase();
    }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;
import org.mapstruct.Mapper;

@Mapper(uses = StringUtils.class)
public interface UpperCaseMapper {
    UserDto toUpperDto(User user);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;

public class UpperCaseMapperImpl implements UpperCaseMapper {

    private final StringUtils stringUtils = new StringUtils();

    @Override
    public UserDto toUpperDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setName( stringUtils.capitalize( user.getName() ) );
        userDto.setAge( user.getAge() );

        return userDto;
    }
}
```

## 14. Before and After Mapping Callbacks

Callouts exist that allow logic to execute immediately prior to or after standard MapStruct generated logic maps a bean. Let's create an Abstract class to achieve this.

### Mapper Abstract Class

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.BeforeMapping;
import org.mapstruct.AfterMapping;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class LifecycleMapper {

    @BeforeMapping
    protected void validate(User user) {
        if (user.getAge() < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

    @AfterMapping
    protected void setCalculatedFields(User user, @MappingTarget UserDto target) {
        target.setName(target.getName() + " - Validated");
    }

    public abstract UserDto map(User user);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;

public class LifecycleMapperImpl extends LifecycleMapper {

    @Override
    public UserDto map(User user) {
        if ( user == null ) {
            return null;
        }

        validate( user );

        UserDto userDto = new UserDto();

        userDto.setName( user.getName() );
        userDto.setAge( user.getAge() );

        setCalculatedFields( user, userDto );

        return userDto;
    }
}
```

## 15. Object Factories

By default, MapStruct calls the no-arg constructor to create instances. If you want a specialized pattern or DI construct, you can direct creation using `@ObjectFactory`.

### Factory Class

```java
package com.example.factory;

import com.example.target.UserDto;
import org.mapstruct.ObjectFactory;

public class DtoFactory {
    @ObjectFactory
    public UserDto createUserDto() {
        UserDto dto = new UserDto();
        dto.setName("Factory Default");
        return dto;
    }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;
import com.example.factory.DtoFactory;
import org.mapstruct.Mapper;

@Mapper(uses = DtoFactory.class)
public interface FactoryAwareMapper {
    UserDto map(User user);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.factory.DtoFactory;
import com.example.source.User;
import com.example.target.UserDto;

public class FactoryAwareMapperImpl implements FactoryAwareMapper {

    private final DtoFactory dtoFactory = new DtoFactory();

    @Override
    public UserDto map(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = dtoFactory.createUserDto();

        if ( user.getName() != null ) {
            userDto.setName( user.getName() );
        }
        userDto.setAge( user.getAge() );

        return userDto;
    }
}
```

## 16. Conditional Mappings

Conditional mappings evaluate boolean context to determine if a field should be mapped. It is typically marked via custom `@Condition` methods.

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Condition;

@Mapper
public interface ConditionalMapper {

    @Condition
    default boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    UserDto toDto(User user);
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.User;
import com.example.target.UserDto;

public class ConditionalMapperImpl implements ConditionalMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( isNotEmpty( user.getName() ) ) {
            userDto.setName( user.getName() );
        }
        userDto.setAge( user.getAge() );

        return userDto;
    }
}
```

## 17. Exception Handling

MapStruct supports mappings that throw exceptions. If a custom mapping method or a referenced mapper method throws a checked exception, the generated implementation will declare that exception on the mapping method and propagate it upwards.

### Source Class

```java
package com.example.source;

public class FileRecord {
    private String dataSize;

    public String getDataSize() { return dataSize; }
    public void setDataSize(String dataSize) { this.dataSize = dataSize; }
}
```

### Target Class

```java
package com.example.target;

public class ParsedRecord {
    private Long size;

    public Long getSize() { return size; }
    public void setSize(Long size) { this.size = size; }
}
```

### Mapper Interface

```java
package com.example.mapper;

import com.example.source.FileRecord;
import com.example.target.ParsedRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.zip.DataFormatException;

@Mapper
public interface RecordMapper {

    @Mapping(target = "size", source = "dataSize")
    ParsedRecord toRecord(FileRecord fileRecord) throws DataFormatException;

    default Long parseSize(String sizeStr) throws DataFormatException {
        if (sizeStr == null) {
            return null;
        }
        try {
            return Long.parseLong(sizeStr);
        } catch (NumberFormatException e) {
            throw new DataFormatException("Invalid size format: " + sizeStr);
        }
    }
}
```

### Generated Implementation

```java
package com.example.mapper;

import com.example.source.FileRecord;
import com.example.target.ParsedRecord;
import java.util.zip.DataFormatException;

public class RecordMapperImpl implements RecordMapper {

    @Override
    public ParsedRecord toRecord(FileRecord fileRecord) throws DataFormatException {
        if ( fileRecord == null ) {
            return null;
        }

        ParsedRecord parsedRecord = new ParsedRecord();

        parsedRecord.setSize( parseSize( fileRecord.getDataSize() ) );

        return parsedRecord;
    }
}
```
