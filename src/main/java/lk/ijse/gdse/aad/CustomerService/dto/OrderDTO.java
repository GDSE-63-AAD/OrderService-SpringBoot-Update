package lk.ijse.gdse.aad.CustomerService.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements Serializable {
    private String orderId;
    private String customerId;
    private String orderDate;
    private double orderValue;

    public OrderDTO(String customerId, String orderDate, double orderValue) {
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.orderValue = orderValue;
    }
}

