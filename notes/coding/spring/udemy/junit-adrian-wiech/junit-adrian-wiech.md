# Table of Contents

- [Table of Contents](#table-of-contents)
- [JUnit 5 - Adrian Wiech](#junit-5---adrian-wiech)
  - [Unit Tests](#unit-tests)
  - [Best Practices](#best-practices)
  - [Test Exceptions](#test-exceptions)
  - [Test Multiple Assertions](#test-multiple-assertions)
  - [Test Null Values](#test-null-values)
  - [Test Array Equality](#test-array-equality)
  - [`@BeforeEach`, `@AfterEach`](#beforeeach-aftereach)
  - [`@BeforeAll`, `@AfterAll`](#beforeall-afterall)
  - [Parameterized Tests - `@ValueSource` (Single Value)](#parameterized-tests---valuesource-single-value)
  - [Parameterized Tests - `@CsvSource` (Multiple Values)](#parameterized-tests---csvsource-multiple-values)
  - [Parameterized Tests - `@CsvFileSource` (Load Values from CSV file)](#parameterized-tests---csvfilesource-load-values-from-csv-file)
  - [`@RepeatedTest` - Repeated Tests](#repeatedtest---repeated-tests)
  - [Test Performance](#test-performance)
  - [Assumptions](#assumptions)
  - [`@Nested`](#nested)
  - [`@DisplayName`](#displayname)
  - [`@Disabled`](#disabled)
  - [`@DisabledOnOs()`](#disabledonos)
- [Mockito - Adrian Wiech](#mockito---adrian-wiech)

# JUnit 5 - Adrian Wiech

Note: Junit5 uses `import static org.junit.jupiter.api.Assertions.*;`

```java
class UnitConverter {
  double asCelsius(double tempFarenheit) {
    return ((tempFarenheit - 32) * 5.0) / 9.0;
  }
}
```

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class UnitConverterTest {
  private UnitConverter unitConverter;

  @BeforeAll
  void setup() {
    this.unitConverter = new UnitConverter();
  }

  @Test
  void shouldReturnCorrectTempAsCelsius() {
    assertEquals(5.0, unitConverter.fahrenheitToCelsius(41.0));
  }
}
```

## Unit Tests

- Unit Tests = Tests at the lowest level
- Test SINGLE UNITs of software
  - In Java, this means "methods" (also known as "method under test")

## Best Practices

- The "TEST package" MUST BE THE SAME as the "SOURCE package"
- Test CLASS NAME = `new String(classNameUnderTest + "Test")`
- Test METHOD NAME = in the `shouldXWhenY` form
- Test METHOD needs `@Test` annotation
- Test METHOD BODY = `given, when, then` or `arrange, act, assert`
  - `given` = Initial conditions/input values
  - `when` = Where we invoke the method under test and store result in a variable
  - `then` = Provide assertion
- Grab instance variable by using `classNameUnderTest.method()`

## Test Exceptions

> Use `Executable` type and with a lambda expression `() -> ...`

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {
  @Test
  void should_ThrowArithmeticException_When_HeightZero() {
    // given
    double weight = 50.0;
    double height = 0.00;
    // when
    Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
    // then
    assertThrows(ArithmeticException.class, executable);
  }
}
```

## Test Multiple Assertions

> Use `assertAll(() -> ..., () -> ...)`

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {
  @Test
  void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
    // given
    List<Coder> coders = new ArrayList<>();
    coders.add(new Coder(1.80, 60.0));
    coders.add(new Coder(1.82, 98.0));
    coders.add(new Coder(1.82, 64.7));
    // when
    Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
    // then
    assertAll(
      () -> assertEquals(1.82, coderWorstBMI.getHeight()),
      () -> assertEquals(98.0, coderWorstBMI.getWeight()));
  }
}
```

## Test Null Values

> `assertNull()`

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {
  @Test
  void should_ReturnNullWithWorstBMICoder_When_CoderListEmpty() {
    // given
    List<Coder> coders = new ArrayList<>();
    // when
    Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
    // then
    assertNull(coderWorstBMI);
  }
}
```

## Test Array Equality

> `assertArrayEquals()`

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {
  @Test
  void should_ReturnCorrrectBMIScoreArray_When_CoderListNotEmpty() {
    // given
    List<Coder> coders = new ArrayList<>();
    coders.add(new Coder(1.80, 60.0));
    coders.add(new Coder(1.82, 98.0));
    coders.add(new Coder(1.82, 64.7));
    double[] expected = { 18.52, 29.59, 19.53 };
    // when
    double[] bmiScores = BMICalculator.getBMIScores(coders);
    // then
    assertArrayEquals(expected, bmiScores);
  }
}
```

## `@BeforeEach`, `@AfterEach`

```java
@BeforeEach
void setup() {
  //...
}

@AfterEach
void teardown() {
  //...
}
```

Note: Need to use `assertAll(() -> assertEquals(expected.getter1(), actual.getter1()), () -> assertEquals(expected.getter2(), actual.getter2())` to compare 2 objects

```java
package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class DietPlannerTest {

  private DietPlanner dietPlanner;

  @BeforeEach
  void setup() {
    this.dietPlanner = new DietPlanner(20, 30, 50);
  }

  @AfterEach
  void teardown() {
    System.out.println("A unit test was finished.");
  }

  @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
  void should_ReturnCorrectDietPlan_When_CorrectCoder() {
    // given
    Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
    DietPlan expected = new DietPlan(2202, 110, 73, 275);
    // when
    DietPlan actual = dietPlanner.calculateDiet(coder);
    // then
    assertAll(() -> assertEquals(expected.getCalories(), actual.getCalories()),
      () -> assertEquals(expected.getProtein(), actual.getProtein()),
      () -> assertEquals(expected.getFat(), actual.getFat()),
      () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate()));
  }
}
```

## `@BeforeAll`, `@AfterAll`

> Methods annotated with `@BeforeAll`/`@AfterAll` MUST BE STATIC
> Used for operations to be run exactly once before all unit tests are performed
> Usually for operations too expensive to be run before each unit tests (e.g. data collections or starting servers)

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

  @BeforeAll
  static void beforeAll() {
    System.out.println("Before all unit tests");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("After all unit tests");
  }
}
```

## Parameterized Tests - `@ValueSource` (Single Value)

> Replace `@Test` annotation with `@ParameterizedTest` annotation
> `@ValueSource(booleans|bytes|chars|classes|doubles|floats|ints|longs|shorts|strings = { ... })`
> Need to parameters to the method CONSTRUCTOR so that values in `@ValueSource` will be automatically injected into the parameter/variable

[@ValueSource - JavaDocs](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/ValueSource.html)

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

  @ParameterizedTest
  @ValueSource(doubles = { 89.0, 95.0, 11.0 })
  void should_return_true_when_dietRecommended(Double coderWeight) {
    // given
    double weight = coderWeight;
    double height = 1.72;
    // when
    boolean recommended = BMICalculator.isDietRecommended(weight, height, isCoder);
    // then
    assertTrue(recommended);
  }
}
```

## Parameterized Tests - `@CsvSource` (Multiple Values)

Csv = Comma separated values

`@CsvSource(value)`

- MUST specify `value` keyword argument or skip keyword altogether
- CANNOT use any other name

`@CsvSource(value = {"v1.1, v1.2", "v2.1, v2.2"})`

- Each string contains a group of values (separated by commas)

[@CsvSource - JavaDocs](https://junit.org/junit5/docs/current/api/org.junit.jupiter.params/org/junit/jupiter/params/provider/CsvSource.html)

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

  @ParameterizedTest(name = "weight={0}, height={1}") // Note: The numbers refer to the parameter values below (passed into the test case)
  @CsvSource(value = { "89.0, 1.72", "95.0, 1.75", "110.0, 1.78" })
  void should_return_true_when_dietRecommended(Double coderWeight, Double coderHeight) {
    // given
    double weight = coderWeight;
    double height = coderHeight;
    // when
    boolean recommended = BMICalculator.isDietRecommended(weight, height, isCoder);
    // then
    assertTrue(recommended);
  }
}
```

## Parameterized Tests - `@CsvFileSource` (Load Values from CSV file)

```csv
<!-- diet-recommended-input-data.csv -->
weight,height
82.0,1.68
85.0,1.69
89.0,1.72
95.0,1.75
110.0,1.78
120.0,1.89
125.5,1.92
```

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

  @ParameterizedTest(name = "weight={0}, height={1}") // Note: The numbers refer to the parameter values below (passed into the test case)
  @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1) // Ignore the header line in the csv file
  void should_return_true_when_dietRecommended(Double coderWeight, Double coderHeight) {
    // given
    double weight = coderWeight;
    double height = coderHeight;
    // when
    boolean recommended = BMICalculator.isDietRecommended(weight, height, isCoder);
    // then
    assertTrue(recommended);
  }
}
```

## `@RepeatedTest` - Repeated Tests

> Replace `@Test` with `@RepeatedTest(numTimesToRepeat)`
> Useful for when tests deal with random data generation, changes state, uses multiple threads

```java
package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeEach
    void setup() {
        this.dietPlanner = new DietPlanner(20, 30, 50);
    }

    @AfterEach
    void afterEach() {
        System.out.println("A unit test was finished.");
    }

    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        // given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);
        // when
        DietPlan actual = dietPlanner.calculateDiet(coder);
        // then
        assertAll(() -> assertEquals(expected.getCalories(), actual.getCalories()),
            () -> assertEquals(expected.getProtein(), actual.getProtein()),
            () -> assertEquals(expected.getFat(), actual.getFat()),
            () -> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate()));
    }
}
```

## Test Performance

> `assertTimeout(Duration, Executable)`
> Assert that execution of the supplied executable completes before the given timeout is exceeded

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

  @Test
  void should_ReturnCoderWithWorstBMIIn1Ms_When_CoderList_Has10000Elements() {
    // given
    List<Coder> coders = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      coders.add(new Coder(1.0 + i, 10.0 + i));
    }
    // when
    Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);
    // then
    assertTimeout(Duration.ofMillis(500), executable);
  }
}
```

## Assumptions

> Skip tests in certain environments with `assumeTrue()`
> If `assumeTrue(boolean)` is TRUE, then the ENTIRE test is SKIPPED
> Use the following import `import static org.junit.jupiter.api.Assumptions.assumeTrue;`

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

  private String environment = "prod";

  @Test
  void should_ReturnCoderWithWorstBMIIn1Ms_When_CoderList_Has10000Elements() {
    // given
    assumeTrue(this.environment.equals("prod"));
    List<Coder> coders = new ArrayList<>();
    for (int i = 0; i < 10000; i++) {
      coders.add(new Coder(1.0 + i, 10.0 + i));
    }
    // when
    Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);
    // then
    assertTimeout(Duration.ofMillis(500), executable);
  }
}
```

## `@Nested`

Note: Refer to outer class instance variable with `OuterClass.this.variableName`

Note: Each Nested Class can have `@BeforeEach`, `@AfterEach`, `@BeforeAll`, `@AfterAll` methods

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

  private String environment = "prod";

  @BeforeAll
  static void beforeAll() {
    System.out.println("Before all unit tests");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("After all unit tests");
  }

  @Nested
  class IsDietRecommendedTest {
    @ParameterizedTest(name = "weight={0}, height={1}")
    @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
    void should_ReturnTrue_When_DietRecommended(Double coderWeight, Double coderHeight) {
      // given
      double weight = coderWeight;
      double height = coderHeight;
      // when
      boolean recommended = BMICalculator.isDietRecommended(weight, height);
      // then
      assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_When_DietNotRecommended() {
      // given
      double weight = 50.0;
      double height = 1.92;
      // when
      boolean recommended = BMICalculator.isDietRecommended(weight, height);
      // then
      assertFalse(recommended);
    }

    @Test
    void should_ThrowArithmeticException_When_HeightZero() {
      // given
      double weight = 50.0;
      double height = 0.00;
      // when
      Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
      // then
      assertThrows(ArithmeticException.class, executable);
    }
  }

  @Nested
  class FindCoderWithWorstBMITests {
    @Test
    void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
      // given
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.80, 60.0));
      coders.add(new Coder(1.82, 98.0));
      coders.add(new Coder(1.82, 64.7));
      // when
      Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
      // then
      assertAll(
        () -> assertEquals(1.82, coderWorstBMI.getHeight()),
        () -> assertEquals(98.0, coderWorstBMI.getWeight()));
    }

    @Test
    void should_ReturnCoderWithWorstBMIIn1Ms_When_CoderList_Has10000Elements() {
      // given
      assumeTrue(BMICalculatorTest.this.environment.equals("prod")); // <-- HERE, refer to outer class
      List<Coder> coders = new ArrayList<>();
      for (int i = 0; i < 10000; i++) {
        coders.add(new Coder(1.0 + i, 10.0 + i));
      }
      // when
      Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);
      // then
      assertTimeout(Duration.ofMillis(500), executable);
    }

    @Test
    void should_ReturnNullWithWorstBMICoder_When_CoderListEmpty() {
      // given
      List<Coder> coders = new ArrayList<>();
      // when
      Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
      // then
      assertNull(coderWorstBMI);
    }
  }

  @Nested
  class GetBMIScoresTests {
    @Test
    void shoyuld_ReturnCorrrectBMIScoreArray_When_CoderListNotEmpty() {
      // given
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.80, 60.0));
      coders.add(new Coder(1.82, 98.0));
      coders.add(new Coder(1.82, 64.7));
      double[] expected = { 18.52, 29.59, 19.53 };
      // when
      double[] bmiScores = BMICalculator.getBMIScores(coders);
      // then
      assertArrayEquals(expected, bmiScores);
    }
  }
}
```

## `@DisplayName`

> Gives custom name for test

```java
package com.healthycoderapp;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BMICalculatorTest {

  private String environment = "prod";

  @BeforeAll
  static void beforeAll() {
    System.out.println("Before all unit tests");
  }

  @AfterAll
  static void afterAll() {
    System.out.println("After all unit tests");
  }

  @Nested
  class IsDietRecommendedTest {
    @ParameterizedTest(name = "weight={0}, height={1}")
    @CsvFileSource(resources = "/diet-recommended-input-data.csv", numLinesToSkip = 1)
    void should_ReturnTrue_When_DietRecommended(Double coderWeight, Double coderHeight) {
      // given
      double weight = coderWeight;
      double height = coderHeight;
      // when
      boolean recommended = BMICalculator.isDietRecommended(weight, height);
      // then
      assertTrue(recommended);
    }

    @Test
    void should_ReturnFalse_When_DietNotRecommended() {
      // given
      double weight = 50.0;
      double height = 1.92;
      // when
      boolean recommended = BMICalculator.isDietRecommended(weight, height);
      // then
      assertFalse(recommended);
    }

    @Test
    void should_ThrowArithmeticException_When_HeightZero() {
      // given
      double weight = 50.0;
      double height = 0.00;
      // when
      Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
      // then
      assertThrows(ArithmeticException.class, executable);
    }
  }

  @Nested
  @DisplayName("sample inner class display name")
  class FindCoderWithWorstBMITests {
    @Test
    @DisplayName("sample method display name")
    @DisabledOnOs(OS.LINUX)
    void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty() {
      // given
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.80, 60.0));
      coders.add(new Coder(1.82, 98.0));
      coders.add(new Coder(1.82, 64.7));
      // when
      Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
      // then
      assertAll(
        () -> assertEquals(1.82, coderWorstBMI.getHeight()),
        () -> assertEquals(98.0, coderWorstBMI.getWeight()));
    }

    @Test
    void should_ReturnCoderWithWorstBMIIn1Ms_When_CoderList_Has10000Elements() {
      // given
      assumeTrue(BMICalculatorTest.this.environment.equals("prod"));
      List<Coder> coders = new ArrayList<>();
      for (int i = 0; i < 10000; i++) {
        coders.add(new Coder(1.0 + i, 10.0 + i));
      }
      // when
      Executable executable = () -> BMICalculator.findCoderWithWorstBMI(coders);
      // then
      assertTimeout(Duration.ofMillis(500), executable);
    }

    @Test
    void should_ReturnNullWithWorstBMICoder_When_CoderListEmpty() {
      // given
      List<Coder> coders = new ArrayList<>();
      // when
      Coder coderWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);
      // then
      assertNull(coderWorstBMI);
    }
  }

  @Nested
  class GetBMIScoresTests {
    @Test
    void shoyuld_ReturnCorrrectBMIScoreArray_When_CoderListNotEmpty() {
      // given
      List<Coder> coders = new ArrayList<>();
      coders.add(new Coder(1.80, 60.0));
      coders.add(new Coder(1.82, 98.0));
      coders.add(new Coder(1.82, 64.7));
      double[] expected = { 18.52, 29.59, 19.53 };
      // when
      double[] bmiScores = BMICalculator.getBMIScores(coders);
      // then
      assertArrayEquals(expected, bmiScores);
    }
  }
}
```

## `@Disabled`

> Ignores a test

## `@DisabledOnOs()`

> Ignores a test on certain operating system

# Mockito - Adrian Wiech

Unit tests are written for single software parts
Typically one unit test in Java verifies one class method
