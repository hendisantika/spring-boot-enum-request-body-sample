package id.my.hendisantika.springbootenumrequestbodysample.entity;

/**
 * Created by IntelliJ IDEA.
 * Project : enum-request-body-sample
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 15/05/25
 * Time: 12.54
 * To change this template use File | Settings | File Templates.
 */
public enum Status {
    ACTIVATED(1), DEACTIVATED(2), SUSPENDED(3);

    int statusId;

    Status(int statusId) {
        this.statusId = statusId;
    }

    public int getStatusId() {
        return statusId;
    }
}
