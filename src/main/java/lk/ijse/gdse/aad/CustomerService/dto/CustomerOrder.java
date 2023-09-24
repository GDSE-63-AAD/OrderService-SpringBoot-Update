package lk.ijse.gdse.aad.CustomerService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerOrder implements Serializable {
    private String orderId;
    private double orderValue;
    private String customerCode;
    private String customerName;
    private String customerAddress;
    private String customerEmail;

    public CustomerOrder(String customerCode, String customerName, String customerAddress, String customerEmail) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }

    public CustomerOrder(String orderId, String customerCode, String customerName, String customerAddress, String customerEmail) {
        this.orderId = orderId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerEmail = customerEmail;
    }

    public CustomerOrder(String orderId, double orderValue) {
        this.orderId = orderId;
        this.orderValue = orderValue;
    }
}
