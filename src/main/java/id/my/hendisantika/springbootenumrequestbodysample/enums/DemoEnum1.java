package id.my.hendisantika.springbootenumrequestbodysample.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
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
 * Time: 07.26
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Getter
public enum DemoEnum1 {

    GOOD_GID("goodGid"),
    HELLO_WORLD("helloWorld");

    private final String text;

    DemoEnum1(String text) {
        this.text = text;
    }

    @JsonCreator
    public static DemoEnum1 from(String s) {
        /**
         * [1] : The reason why 2 conditions are needed (= i.name().equals(s) || i.getText().equals(s))
         * - Request -> from() call -> Controller -> Builder calls .demoEnum() -> from() call
         *
         * - The first time from() is called, it searches for a value in DemoEnum1 with the value contained in the Request.
         * - At this time, it searches for an Enum with Enum.getText().
         * - And the second time from() is called, it searches for a value with the Enum that has already been found.
         * - In this case, it must be compared with Enum.name().
         * - If it is compared with i.getText(), the correct value cannot be found.
         */
        return Arrays.stream(values())
                .filter(i -> i.name().equals(s) || i.getText().equals(s)) // [1]
                .findFirst()
                .orElseGet(() -> {
                    log.warn("Invalid Enum Value : {}", s);
                    return null;
                });
    }
}
