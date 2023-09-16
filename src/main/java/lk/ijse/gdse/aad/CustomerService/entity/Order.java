package lk.ijse.gdse.aad.CustomerService.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order implements SuperEntity {
    @Id
    private String orderId;
    private String customerId;
    private String orderDate;
    private double orderValue;

}
