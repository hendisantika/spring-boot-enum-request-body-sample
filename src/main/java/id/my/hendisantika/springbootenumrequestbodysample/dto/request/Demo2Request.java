package id.my.hendisantika.springbootenumrequestbodysample.dto.request;

import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 13/05/25
 * Time: 07.31
 * To change this template use File | Settings | File Templates.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo2Request {
    private String id;
    private DemoEnum2 demoEnum;
}
