package id.my.hendisantika.springbootenumrequestbodysample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 13/05/25
 * Time: 16.22
 * To change this template use File | Settings | File Templates.
 */
@ExtendWith(SpringExtension.class) // When using Junit5
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // [1]
class DemoControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate; // [2]

    @Autowired
    private ObjectMapper objectMapper;

}