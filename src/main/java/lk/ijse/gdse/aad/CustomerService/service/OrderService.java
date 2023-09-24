package lk.ijse.gdse.aad.CustomerService.service;

import lk.ijse.gdse.aad.CustomerService.dto.CustomerOrder;
import lk.ijse.gdse.aad.CustomerService.dto.OrderDTO;

public interface OrderService {
    OrderDTO saveOrder(OrderDTO order);
    OrderDTO getSelectedOrder(String code);
    void updateOrder(OrderDTO order);
    void deleteOrder(String code);
    CustomerOrder getFullProfileData(CustomerOrder customercode);
}
