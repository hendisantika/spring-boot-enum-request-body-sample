package id.my.hendisantika.springbootenumrequestbodysample.repository;

import id.my.hendisantika.springbootenumrequestbodysample.entity.Customer;
import id.my.hendisantika.springbootenumrequestbodysample.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/05/25
 * Time: 13.00
 * To change this template use File | Settings | File Templates.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("""
            SELECT c FROM Customer c 
            WHERE (c.status = :status or :status is null) 
              and (c.name like :name or :name is null) """)
    List<Customer> findCustomerByStatusAndName(
            @Param("status") Status status,
            @Param("name") String name);
}
