package id.my.hendisantika.springbootenumrequestbodysample.config;

import id.my.hendisantika.springbootenumrequestbodysample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/05/25
 * Time: 12.59
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private CustomerRepository customerRepository;


}
