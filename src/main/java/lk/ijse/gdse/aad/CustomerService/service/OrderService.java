package lk.ijse.gdse.aad.CustomerService.service;

import lk.ijse.gdse.aad.CustomerService.dto.OrderDTO;

public interface OrderService {
    OrderDTO saveCustomer(OrderDTO order);
    OrderDTO getSelectedCustomer(String code);
//    CustomerDTO getSelectedOrder(String code, String orderId);
    void updateCustomer(OrderDTO order);
    void deleteCustomer(String code);
}
