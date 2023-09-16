package lk.ijse.gdse.aad.CustomerService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerOrder implements Serializable {
    private String customerId;
    private String orderId;
    private double orderValue;
    private String custmerName;
}
