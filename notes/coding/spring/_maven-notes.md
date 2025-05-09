# Table of Contents

- [Table of Contents](#table-of-contents)
- [Maven Links](#maven-links)
- [Jars](#jars)
- [Maven Commands](#maven-commands)
- [Maven Dependency Conflict Resolution](#maven-dependency-conflict-resolution)

# Maven Links

- [Maven - Guide Index](https://maven.apache.org/guides/index.html)
- [Maven - User Index](https://maven.apache.org/users/index.html)
- [Maven - `Pom` Reference](https://maven.apache.org/pom.html)
- [Maven - `Settings` Reference](https://maven.apache.org/settings.html)
- [Maven - `Plugins` Reference](https://maven.apache.org/plugins/index.html)
- [Maven - Glossary](https://maven.apache.org/glossary.html)
- [GitHub CLI - Maven](https://docs.github.com/en/actions/use-cases-and-examples/building-and-testing/building-and-testing-java-with-maven)
- [Maven Repository - Apache](https://mvnrepository.com/)
- [Maven Central Repository - Sonatype](https://central.sonatype.com/)

# Jars

Maven will priorities LOCALLY built jars over REMOTE (even if they have the same pom.xml version numbers)

This means you can

1. Clone and locally edit a dependency
2. Run `mvn clean install` on that dependency
3. In your project IntelliJ run `Reload all Maven Projects` and `Sync all Maven Projects` to import your local edits

# Maven Commands

[Maven CLI Options Reference](https://maven.apache.org/ref/3-LATEST/maven-embedder/cli.html)

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

| Command                                   | Description                                                                                      |
| ----------------------------------------- | ------------------------------------------------------------------------------------------------ |
| `mvn clean`                               | Cleans the project by deleting the target directory                                              |
| `mvn compile`                             | Compiles the source code of the project                                                          |
| `mvn test`                                | Runs the tests using a suitable unit testing framework                                           |
| `mvn package`                             | Packages the compiled code into a distributable format (e.g., JAR, WAR)                          |
| `mvn install`                             | Installs the package into the local repository for use as a dependency in other projects locally |
| `mvn deploy`                              | Deploys the built package to a remote repository                                                 |
| `mvn validate`                            | Validates the project is correct and all necessary information is available                      |
| `mvn site`                                | Generates a site based on the information in the POM                                             |
| `mvn clean install`                       | Cleans the project and installs the package into the local repository                            |
| `mvn clean package`                       | Cleans the project and packages the code                                                         |
| `mvn dependency:resolve`                  | Resolves all project dependencies                                                                |
| `mvn dependency:tree`                     | Displays the dependency tree for the project                                                     |
| `mvn dependency:analyze`                  | Analyzes the dependencies of the project                                                         |
| `mvn dependency:purge-local-repository`   | Purges local repository of all unreferenced snapshots                                            |
| `mvn dependency:copy-dependencies`        | Copies project dependencies to a specified location                                              |
| `mvn dependency:go-offline`               | Resolves project dependencies and plugins to be used in offline mode                             |
| `mvn dependency:analyze-dep-mgt`          | Analyzes the dependency management                                                               |
| `mvn dependency:analyze-duplicate`        | Analyzes duplicate classes                                                                       |
| `mvn dependency:analyze-only`             | Analyzes dependencies without making changes                                                     |
| `mvn dependency:analyze-report`           | Generates a report on the dependencies                                                           |
| `mvn dependency:analyze-transitive`       | Analyzes transitive dependencies                                                                 |
| `mvn dependency:analyze-versions`         | Analyzes dependency versions                                                                     |
| `mvn dependency:build-classpath`          | Builds a classpath from the project dependencies                                                 |
| `mvn dependency:collect`                  | Collects the dependencies                                                                        |
| `mvn dependency:copy`                     | Copies a specific dependency to a specified location                                             |
| `mvn dependency:get`                      | Downloads a specific artifact from a repository                                                  |
| `mvn dependency:list`                     | Lists all dependencies used by the project                                                       |
| `mvn dependency:resolve-plugins`          | Resolves plugins and their dependencies                                                          |
| `mvn dependency:sources`                  | Retrieves source jars for project dependencies                                                   |
| `mvn dependency:unpack`                   | Unpacks project dependencies                                                                     |
| `mvn dependency:unpack-dependencies`      | Unpacks project dependencies to a specified location                                             |
| `mvn dependency:version`                  | Displays the version of the dependency plugin                                                    |
| `mvn help:describe`                       | Describes the attributes of a plugin                                                             |
| `mvn help:effective-pom`                  | Displays the effective POM for the project                                                       |
| `mvn help:effective-settings`             | Displays the effective settings for the project                                                  |
| `mvn help:system`                         | Displays system properties                                                                       |
| `mvn help:active-profiles`                | Displays active profiles for the project                                                         |
| `mvn help:all-profiles`                   | Displays all profiles for the project                                                            |
| `mvn help:describe`                       | Describes the attributes of a plugin                                                             |
| `mvn help:effective-pom`                  | Displays the effective POM for the project                                                       |
| `mvn help:effective-settings`             | Displays the effective settings for the project                                                  |
| `mvn help:system`                         | Displays system properties                                                                       |
| `mvn help:active-profiles`                | Displays active profiles for the project                                                         |
| `mvn help:all-profiles`                   | Displays all profiles for the project                                                            |
| `mvn versions:display-dependency-updates` | Displays dependency updates                                                                      |
| `mvn versions:display-plugin-updates`     | Displays plugin updates                                                                          |
| `mvn versions:use-latest-versions`        | Uses the latest versions of dependencies                                                         |
| `mvn versions:use-next-releases`          | Uses the next releases of dependencies                                                           |
| `mvn versions:use-next-snapshots`         | Uses the next snapshots of dependencies                                                          |
| `mvn versions:update-properties`          | Updates properties to the latest versions                                                        |

# Maven Dependency Conflict Resolution

Maven resolves version conflicts using the "nearest-wins" strategy.

When multiple versions of the same dependency exist in a project's dependency tree, Maven prioritizes the version that's "nearest" to your project in the dependency hierarchy.

- **Dependency Distance**: The closer a dependency is to your project in the dependency graph, the higher its priority. Distance is measured by how many levels deep the dependency is
- **Direct Dependencies Take Precedence**: Dependencies directly declared in your project's POM file (at distance 1) always win over transitive dependencies (at distance 2 or greater)
- **First Declaration Wins**: If two dependencies are at the same distance from your project, the one that's declared **FIRST** in the POM file wins

Example:

- If your project directly depends on:
  - Library A, which depends on Library C version 1.0
  - Library B, which depends on Library C version 2.0
  - Maven will use Library C version 1.0 if Library A is declared BEFORE Library B in your POM file, or version 2.0 if Library B is declared first
