package id.my.hendisantika.springbootenumrequestbodysample.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 13/05/25
 * Time: 07.28
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Getter
@NoArgsConstructor
public enum DemoEnum4 {

    GOOD_GID("goodGid"),
    HELLO_WORLD("helloWorld");

    private String text;

    DemoEnum4(String text) {
        this.text = text;
    }

    @JsonCreator
    public static DemoEnum4 from(String s) {
        return Arrays.stream(values())
                .filter(i -> i.name().equals(s) || i.getText().equals(s)) // [1]
                .findFirst()
                .orElseGet(() -> {
                    log.warn("Invalid Enum Value : {}", s);
                    return null;
                });
    }
}

/*
Resolved [org.springframework.http.converter.HttpMessageNotReadableException:
JSON parse error: Cannot construct instance of `java.util.ArrayList` (although at least one Creator exists):
no String-argument constructor/factory method to deserialize from String value ('goodGid'); nested exception is com.fasterxml.jackson.databind.exc.MismatchedInputException:
Cannot construct instance of `java.util.ArrayList` (although at least one Creator exists): no String-argument constructor/factory method to deserialize from String value ('goodGid')
 at [Source: (PushbackInputStream); line: 3, column: 15] (through reference chain: dev.be.requestbody_enum_type.dto.request.Demo4Request["demoEnum"]->java.util.ArrayList[0])]


 JSON parse error: Cannot deserialize value of type `java.util.ArrayList<dev.be.requestbody_enum_type.enums.DemoEnum4>` from String value (token `JsonToken.VALUE_STRING`);
 nested exception is com.fasterxml.jackson.databind.exc.MismatchedInputException:
 Cannot deserialize value of type `java.util.ArrayList<dev.be.requestbody_enum_type.enums.DemoEnum4>` from String value (token `JsonToken.VALUE_STRING`)
 at [Source: (PushbackInputStream); line: 1, column: 22] (through reference chain: dev.be.requestbody_enum_type.dto.request.Demo4Request["demoEnum"])]
 */