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
