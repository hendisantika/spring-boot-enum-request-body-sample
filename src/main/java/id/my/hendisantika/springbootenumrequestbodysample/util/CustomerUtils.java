package id.my.hendisantika.springbootenumrequestbodysample.util;

import id.my.hendisantika.springbootenumrequestbodysample.dto.response.CustomerResponse;
import id.my.hendisantika.springbootenumrequestbodysample.entity.Customer;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/05/25
 * Time: 13.34
 * To change this template use File | Settings | File Templates.
 */
public class CustomerUtils {
    public static CustomerResponse convertToCustomerResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getDateOfBirth(),
                customer.getStatus().name()
        );
    }
}
