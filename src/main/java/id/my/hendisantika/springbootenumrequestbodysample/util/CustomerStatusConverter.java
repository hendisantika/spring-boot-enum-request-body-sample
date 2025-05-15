package id.my.hendisantika.springbootenumrequestbodysample.util;

import id.my.hendisantika.springbootenumrequestbodysample.entity.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/05/25
 * Time: 12.57
 * To change this template use File | Settings | File Templates.
 */

@Converter
public class CustomerStatusConverter implements AttributeConverter<Status, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status status) {
        return status.getStatusId();
    }

    @Override
    public Status convertToEntityAttribute(Integer
                                                   statusId) {
        return Arrays.stream(Status.values())
                .filter(s -> s.getStatusId() == statusId)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
