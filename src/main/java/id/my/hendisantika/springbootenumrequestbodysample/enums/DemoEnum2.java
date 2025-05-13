package id.my.hendisantika.springbootenumrequestbodysample.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

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
public enum DemoEnum2 {

    GOOD_GID("goodGid"),
    HELLO_WORLD("helloWorld");

    private final String text;

    DemoEnum2(String text) {
        this.text = text;
    }

    @JsonCreator
    public static DemoEnum2 from(String s) {
        return valueOf(s);
    }
}
