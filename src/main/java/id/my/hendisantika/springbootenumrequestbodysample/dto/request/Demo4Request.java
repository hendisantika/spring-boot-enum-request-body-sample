package id.my.hendisantika.springbootenumrequestbodysample.dto.request;

import id.my.hendisantika.springbootenumrequestbodysample.enums.DemoEnum4;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
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
 * Time: 07.32
 * To change this template use File | Settings | File Templates.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo4Request {
    private String id;
    private List<DemoEnum4> demoEnum;
}
