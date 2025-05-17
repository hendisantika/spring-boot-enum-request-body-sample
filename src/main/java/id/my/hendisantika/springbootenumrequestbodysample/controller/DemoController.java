package id.my.hendisantika.springbootenumrequestbodysample.controller;

import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo1Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo2Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo3Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.request.Demo4Request;
import id.my.hendisantika.springbootenumrequestbodysample.dto.response.DemoResponse;
import id.my.hendisantika.springbootenumrequestbodysample.entity.Level;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {
    @PostMapping("/api/enum/1")
    public DemoResponse demo1(@RequestBody Demo1Request demoRequest) {
        log.info("API Enum 1");
        return DemoResponse.builder()
                .id(demoRequest.getId())
                .demo1Enum(demoRequest.getDemoEnum()) // Call the constructor again (= DemoEnum1.from() is called)
                .build();
    }

    @PostMapping("/api/enum/2")
    public DemoResponse demo2(@RequestBody Demo2Request demoRequest) {
        log.info("API Enum 2");
        return DemoResponse.builder()
                .id(demoRequest.getId())
                .demo2Enum(demoRequest.getDemoEnum())
                .build();
    }

    @PostMapping("/api/enum/3")
    public DemoResponse demo3(@RequestBody Demo3Request demoRequest) {
        log.info("API Enum 3");
        return DemoResponse.builder()
                .id(demoRequest.getId())
                .demo3Enum(demoRequest.getDemoEnum())
                .build();
    }

    @PostMapping("/api/enum/4")
    public DemoResponse demo4(@RequestBody Demo4Request demoRequest) { // Requests are received in the format of List<DemoEnum4>.
        log.info("API Enum 3");
        return DemoResponse.builder()
                .id(demoRequest.getId())
                .demo4Enum(demoRequest.getDemoEnum()) // Call the constructor again (= DemoEnum1.from() is called)
                .build();
    }

    @GetMapping("/api/enum")
    public String getByLevel(@RequestParam(name = "level", required = false) Level level) {
        log.info("API Enum Level");
        return level.name();
    }

}
