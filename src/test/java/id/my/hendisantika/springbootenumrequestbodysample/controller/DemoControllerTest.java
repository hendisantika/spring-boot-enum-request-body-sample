package id.my.hendisantika.springbootenumrequestbodysample.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo1Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.response.DemoResponse;
import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum1;
import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum4;
import net.minidev.json.JSONObject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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

    @Test
    public void SUCCESS_Call_POST_Controller_with_JSONObject() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("demoEnum", "goodGid");

        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString(), getHttpHeaders());

        ResponseEntity<DemoResponse> result = testRestTemplate.postForEntity("/api/enum/1",
                request,
                DemoResponse.class);

        Assertions.assertThat(result.getBody().getId()).isEqualTo(jsonObject.get("id"));
        Assertions.assertThat(result.getBody().getDemo1Enum()).isEqualTo(DemoEnum1.GOOD_GID);
    }

    @Test
    public void SUCCESS_Call_POST_Controller_with_JSONObject_List_Enum() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", "1");
        jsonObject.put("demoEnum", new ArrayList<String>() {{
            add("goodGid");
            add("helloWorld");
        }});
        try {
            objectMapper.writeValueAsString(jsonObject);
        } catch (Exception e) {
            /*
           Parsing a JSONObject containing a List with ObjectMapper results in an error.

            com.fasterxml.jackson.databind.exc.InvalidDefinitionException:
            No serializer found for class org.json.JSONObject and no properties discovered to create BeanSerializer
            (to avoid exception, disable SerializationFeature.FAIL_ON_EMPTY_BEANS)
             */
            System.out.println(e);
        }
        /**
         * Our goal is to pass a JSON-structured String to Jackson.
         * Therefore, as a way to create a JSON-structured String,
         * we can safely use Map and ObjectMapper.
         */
        Map<String, Object> map = new HashMap<>();
        map.put("id", "1");
        map.put("demoEnum", new ArrayList<String>() {{
            add("goodGid");
            add("helloWorld");
        }});

        String asString = objectMapper.writeValueAsString(map);

        HttpEntity<String> request = new HttpEntity<>(asString, getHttpHeaders());

        ResponseEntity<DemoResponse> result = testRestTemplate.postForEntity("/api/enum/4",
                request,
                DemoResponse.class);

        Assertions.assertThat(result.getBody().getId()).isEqualTo(jsonObject.get("id"));
        Assertions.assertThat(result.getBody().getDemo4Enum().get(0).name()).isEqualTo(DemoEnum4.GOOD_GID.name());
        Assertions.assertThat(result.getBody().getDemo4Enum().get(1).name()).isEqualTo(DemoEnum4.HELLO_WORLD.name());
    }

    /**
     * === FAIL Test code ===
     */
    @Test
    public void FAIL_Call_POST_Controller_with_JSONObject_1() throws Exception {
        /**
         * ## Information
         * API : /api/enum/2
         *
         * Resolved [org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error:
         * Cannot construct instance of `dev.be.requestbody_enum_type.enums.DemoEnum2`,
         * problem: No enum constant dev.be.requestbody_enum_type.enums.DemoEnum2.goodGid2; nested exception is com.fasterxml.jackson.databind.exc.ValueInstantiationException:
         * at [Source: (PushbackInputStream); line: 1, column: 22] (through reference chain: dev.be.requestbody_enum_type.dto.request.Demo2Request["demoEnum"])]
         *
         * ## Comment
         * In the DemoEnum2.from() method, 'Cannot construct' occurs because the Enum corresponding to the input "s" value cannot be found.
         */

        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("id", "1");
        personJsonObject.put("demoEnum", "goodGid2");

        HttpEntity<String> request = new HttpEntity<>(personJsonObject.toString(), getHttpHeaders());

        ResponseEntity<DemoResponse> result = testRestTemplate.postForEntity("/api/enum/2",
                request,
                DemoResponse.class);
        Assertions.assertThat(result.getStatusCode()).isNotEqualTo(HttpStatus.OK);
    }
}