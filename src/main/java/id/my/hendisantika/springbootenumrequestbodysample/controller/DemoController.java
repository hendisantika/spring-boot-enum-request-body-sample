package id.my.hendisantika.springbootenumrequestbodysample.controller;

import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo1Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo2Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo3Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo4Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.response.DemoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 13/05/25
 * Time: 07.34
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
public class DemoController {
    @PostMapping("/api/enum/1")
    public DemoResponse demo1(@RequestBody Demo1Request demoRequest) {
        System.out.println();
        return DemoResponse.builder()
                .id(demoRequest.getId())
                .demo1Enum(demoRequest.getDemoEnum()) // Call the constructor again (= DemoEnum1.from() is called)
                .build();
    }

    @PostMapping("/api/enum/2")
    public DemoResponse demo2(@RequestBody Demo2Request demoRequest) {
        System.out.println();
        return DemoResponse.builder()
                .id(demoRequest.getId())
                .demo2Enum(demoRequest.getDemoEnum())
                .build();
    }

    @PostMapping("/api/enum/3")
    public DemoResponse demo3(@RequestBody Demo3Request demoRequest) {
        System.out.println();
        return DemoResponse.builder()
                .id(demoRequest.getId())
                .demo3Enum(demoRequest.getDemoEnum())
                .build();
    }

    @PostMapping("/api/enum/4")
    public DemoResponse demo4(@RequestBody Demo4Request demoRequest) { // Requests are received in the format of List<DemoEnum4>.
        System.out.println();
        return DemoResponse.builder()
                .id(demoRequest.getId())
                .demo4Enum(demoRequest.getDemoEnum()) // Call the constructor again (= DemoEnum1.from() is called)
                .build();
    }
}
