package id.my.hendisantika.springbootenumrequestbodysample.config;

import id.my.hendisantika.springbootenumrequestbodysample.entity.Customer;
import id.my.hendisantika.springbootenumrequestbodysample.entity.Status;
import id.my.hendisantika.springbootenumrequestbodysample.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.stream.IntStream;

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

    @Override
    public void run(String... args) {
        IntStream.rangeClosed(1, 9)
                .forEach(this::createRandomCustomer);
    }

    public void createRandomCustomer(int id) {
        Customer customer = new Customer();
        customer.setId((long) id);
        customer.setName("name " + id + " surname " + id);
        customer.setEmail("organisation" + id + "@email.com");
        customer.setDateOfBirth(LocalDate.of(1980 + 2 * id, id % 12, (3 * id) % 28));
        customer.setStatus(switch (id % 3) {
            case 0 -> Status.ACTIVATED;
            case 1 -> Status.DEACTIVATED;
            case 2 -> Status.SUSPENDED;
            default -> throw new IllegalStateException("Unexpected value: " + id % 3);
        });

        customerRepository.save(customer);
    }
}
