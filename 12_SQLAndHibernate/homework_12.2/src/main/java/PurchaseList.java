import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "purchaselist")
@Getter
@Setter
public class PurchaseList {
    @EmbeddedId
    private PurchaseListKey id;
    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;
    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    private int price;
    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
