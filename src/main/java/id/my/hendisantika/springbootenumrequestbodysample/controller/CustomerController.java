package id.my.hendisantika.springbootenumrequestbodysample.controller;

import id.my.hendisantika.springbootenumrequestbodysample.dto.response.CustomerResponse;
import id.my.hendisantika.springbootenumrequestbodysample.entity.Status;
import id.my.hendisantika.springbootenumrequestbodysample.repository.CustomerRepository;
import id.my.hendisantika.springbootenumrequestbodysample.util.CustomerUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/05/25
 * Time: 13.09
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerRepository customerRepository;

    @GetMapping
    public List<CustomerResponse> findCustomers(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "status", required = false)
            Status status) {
        return customerRepository
                .findCustomerByStatusAndName(status, name)
                .stream()
                .map(CustomerUtils::convertToCustomerResponse)
                .collect(Collectors.toList());
    }
}
