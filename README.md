# spring-boot-enum-request-body-sample

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

References:

1. https://dev.to/noelopez/spring-rest-working-with-enums-ma
2. https://www.baeldung.com/spring-boot-enum-mapping