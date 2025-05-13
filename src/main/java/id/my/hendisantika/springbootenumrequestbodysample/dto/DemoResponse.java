package id.my.hendisantika.springbootenumrequestbodysample.dto;

import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum1;
import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum2;
import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum3;
import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum4;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 13/05/25
 * Time: 07.29
 * To change this template use File | Settings | File Templates.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoResponse {
    private String id;
    private DemoEnum1 demo1Enum; // Declaration of @JsonCreator in DemoEnum1 O + existence of detailed conditions
    private DemoEnum2 demo2Enum; // Declare @JsonCreator in DemoEnum2 O
    private DemoEnum3 demo3Enum; // No @JsonCreator declaration in DemoEnum3
    private List<DemoEnum4> demo4Enum; // Declaration of @JsonCreator in DemoEnum1 O + existence of detailed conditions
}
