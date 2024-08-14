# Table of Contents

- [Table of Contents](#table-of-contents)
- [CI/CD](#cicd)
  - [Continuous Integration (CI)](#continuous-integration-ci)
  - [Continuous Delivery (CD)](#continuous-delivery-cd)
  - [Continuous Deployment](#continuous-deployment)
  - [Continuous Testing](#continuous-testing)
    - [Integration Testing](#integration-testing)
    - [Unit Testing](#unit-testing)
    - [Functional Testing](#functional-testing)
    - [Regression Testing](#regression-testing)
    - [Non-Functional Testing](#non-functional-testing)

# CI/CD

> CI/CD automates much or all of the manual human intervention traditionally needed to get code from a commit into production. With a CI/CD pipeline development teams can make changes to code that are then automatically tested and pushed out for delivery and deployment.

The aim is that progress should move forward and, if possible, never to go back to fix problems again. Problems should be identified and fixed when and where they were introduced. For this to occur, developers need fast feedback loops which is achieved through automated tests that will validate if the code works as intended before moving onto the next stage.

As applications grow larger, CI/CD can decrease development complexity and help scale applications safely.

- Resources
  - https://about.gitlab.com/topics/ci-cd/
  - https://thenewstack.io/a-primer-continuous-integration-and-continuous-delivery-ci-cd/
  - https://www.redhat.com/en/topics/devops/what-is-ci-cd
  - https://www.atlassian.com/continuous-delivery/principles/continuous-integration-vs-delivery-vs-deployment

## Continuous Integration (CI)

> Continuous Integration = The practice of integrating all code changes into the main branch early and often, automatically testing and building each change when you commit.
>
> By merging changes frequently, the risk of the possibility of code conflicts, bugs and security issues can be identified much earlier making it easier to diagnose.

## Continuous Delivery (CD)

> Continuous Delivery is the practice that automates the infrastructure provisioning and application release process.
>
> Once code has been tested and built in CI, CD ensures its releasable and able to deploy to any environment at any time. This can include provisioning infrastructure to deploying the application to the testing or production environment automatically. The purpose is to ensure that minimal effort is required to deploy new code.

## Continuous Deployment

> Continuous Deployment is the practice that every change that passes all production pipeline criteria is released to the customers.
>
> This is done automatically without human intervention. This allows code to be delivered frequently to get feedback from business teams or customers.

Common deployment approaches are:

- Blue-Green deployment
- Canary deployment

![](https://i.sstatic.net/4aN7d.png)

## Continuous Testing

Continuous testing is a practice where tests are automatically run during the CI/CD process in order to ensure that the application is still working as expected.

- Unit Testing = Verifies/Checks that individual units of code work as expected.
- Integration Testing = Verifies how different modules or services within an application work together
- Regression Testing = Performed after a bug is fixed to ensure that specific bug wont occur again

### Integration Testing

Integration testing is the second stage of the software testing process, following Unit Testing

Integration testing involves verifying that each individual software component can work together.

Ensuring that integrated components function correctly together helps identify incompatibilities and also may help identify introduced issues when/if requirements change.

### Unit Testing

Unit testing is a testing descrete behaviours of your program as individual units. The tests need to verify the standard, boundary and incorrect cases of input and also check any assumptions made by the code. With Test Driven Development (TDD), you create these unit tests before the code is written where all the tests are failing then code is written and refactored until the test passes. It is important that each test case is also tested independantly to verify a lack of dependancies within the code.

Once all unit tests in a program are passing, teams can then evaluate larger components of the program by means of Integration Testing

### Functional Testing

Functional testing is the process of checking that the functional requirements and specifications are satisfied by the application. Simulates system usage by providing appropriate test input and expecting correct output.

This includes

- Unit Testing
- Integration Testing
- Regression Testing
- Smoke Testing

### Regression Testing

Regression testing refers to a testing technique that runs functional and non-functional tests to ensure that the functionality of existing features works as intended. Carried out to ensure that changes such as new features or bug fixes do not affect existing functionality/behaviour.

### Non-Functional Testing

Non-functional testing is performed to assess the application in properties that are not critical to functionality but can contribute to end user experience. Factors such as performance and reliability underload are of key concern.

This includes

- Performance Testing
- Load Testing
- Soak Testing
