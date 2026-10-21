# spring-boot-enum-request-body-sample

[![Java CI with Gradle](https://github.com/hendisantika/spring-boot-enum-request-body-sample/actions/workflows/gradle.yml/badge.svg)](https://github.com/hendisantika/spring-boot-enum-request-body-sample/actions/workflows/gradle.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.16-6DB33F?logo=springboot)
![Gradle](https://img.shields.io/badge/Gradle-9.8.2-02303A?logo=gradle)

Sample project showing different ways to map client values to Java `enum` types in Spring Boot — in a JSON
request body, in query parameters, and in a JPA column.

## Tech Stack

| Component    | Version                         |
|--------------|---------------------------------|
| Java (JDK)   | 25                              |
| Spring Boot  | 3.5.16                          |
| Gradle       | 9.8.2 (wrapper)                 |
| Database     | H2 (in-memory)                  |
| Others       | Spring Web, Spring Data JPA, Validation, Lombok |

## Prerequisites

- JDK 25 (e.g. [Temurin 25](https://adoptium.net/))
- No Gradle installation needed — use the bundled `./gradlew` wrapper

## Build & Run

```shell
# Build and run tests
./gradlew build

# Run the application (http://localhost:8080)
./gradlew bootRun
```

H2 console: http://localhost:8080/h2-console (JDBC URL `jdbc:h2:mem:customers`, user `yu71`, password `53cret`).

## Goals

- I want to receive the client's request value directly as an Enum type.

## Requirements

- I want to map the Key value to Enum

not the Enum value defined on the server (= GOOD_GID)

but the Enum Text value (= goodGid)

and map it to the Enum value.

> Enum.class

``` java
public enum DemoEnum1 {

GOOD_GID("goodGid"),
HELLO_WORLD("helloWorld");

private String text;

}
```

- In this case, if you receive the value "goodGid", map it to DemoEnum1.GOOD_GID in the code.

## KeyPoint

``` java
@Slf4j
@Getter
public enum DemoEnum1 {

GOOD_GID("goodGid"),
HELLO_WORLD("helloWorld");

private String text;

DemoEnum1(String text) {
this.text = text;
}

@JsonCreator
public static DemoEnum1 from(String s) {
return Arrays.stream(values())
.filter(i -> i.getText().equals(s))
.findFirst()
.orElseGet(() -> {
log.warn("Invalid Enum Value : {}", s);
return null;
});
}
}
```

- To meet the above requirements, you can use `@JsonCreator`.

- The server `Deserializes` the client's request value.

At this time, if you declare @JsonCreator,

Enum conversion is possible with the logic I defined during deserialization.

- If the client sends a value called "goodGid",

it is mapped to GOOD_GID and returned through the logic defined in from().

## API Endpoints

| Method | Endpoint             | Enum technique                                                                  |
|--------|----------------------|---------------------------------------------------------------------------------|
| POST   | `/api/enum/1`        | `DemoEnum1` — `@JsonCreator` matching by text (`goodGid`) or name (`GOOD_GID`) |
| POST   | `/api/enum/2`        | `DemoEnum2` — `@JsonCreator` using `valueOf()` (name only)                      |
| POST   | `/api/enum/3`        | `DemoEnum3` — default Jackson mapping (name only)                               |
| POST   | `/api/enum/4`        | `List<DemoEnum4>` — `@JsonCreator` applied to each list element                 |
| GET    | `/api/enum?level=`   | `Level` query param, case-insensitive via `EnumMappingConfig`                   |
| GET    | `/api/v1/customers`  | `Status` query param + JPA `AttributeConverter` storing the enum as an integer  |

### Examples

```shell
# Map the text value "goodGid" to DemoEnum1.GOOD_GID
curl -X POST http://localhost:8080/api/enum/1 \
  -H 'Content-Type: application/json' \
  -d '{"id": "1", "demoEnum": "goodGid"}'

# A list of enums
curl -X POST http://localhost:8080/api/enum/4 \
  -H 'Content-Type: application/json' \
  -d '{"id": "4", "demoEnum": ["goodGid", "helloWorld"]}'

# Lenient query-param conversion: "low", "Low" and "LOW" all map to Level.LOW
curl 'http://localhost:8080/api/enum?level=low'

# Filter customers by status
curl 'http://localhost:8080/api/v1/customers?status=ACTIVATED'
```

## CI & Dependency Updates

- **GitHub Actions** (`.github/workflows/gradle.yml`) builds and tests the project on JDK 25 for every push and
  pull request to `main`, and submits the dependency graph for Dependabot alerts.
- **Dependabot** (`.github/dependabot.yml`) checks Gradle dependencies and GitHub Actions daily. Minor and patch
  updates are grouped into a few PRs, and Spring Boot major upgrades are ignored because they need a manual migration.

References:

1. https://dev.to/noelopez/spring-rest-working-with-enums-ma
2. https://www.baeldung.com/spring-boot-enum-mapping
