package id.my.hendisantika.springbootenumrequestbodysample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo1Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.response.DemoResponse;
import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum1;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
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

    /**
     * === SUCCESS Test Code ===
     */
    @Test
    public void SUCCESS_Call_POST_Controller_with_Request_Body() throws Exception {
        Demo1Request requestBody = Demo1Request.builder()
                .id("1")
                .demoEnum(DemoEnum1.GOOD_GID)
                .build();

        HttpEntity<Demo1Request> request = new HttpEntity<>(requestBody, getHttpHeaders());

        ResponseEntity<DemoResponse> result = testRestTemplate.postForEntity("/api/enum/1",
                request,
                DemoResponse.class);
        Assertions.assertThat(result.getBody().getId()).isEqualTo("1");
        Assertions.assertThat(result.getBody().getDemo1Enum()).isEqualTo(DemoEnum1.GOOD_GID);
    }

}