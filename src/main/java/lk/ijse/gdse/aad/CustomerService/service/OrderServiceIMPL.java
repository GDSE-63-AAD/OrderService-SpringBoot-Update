package lk.ijse.gdse.aad.CustomerService.service;

import lk.ijse.gdse.aad.CustomerService.dto.CustomerOrder;
import lk.ijse.gdse.aad.CustomerService.dto.OrderDTO;
import lk.ijse.gdse.aad.CustomerService.entity.Order;
import lk.ijse.gdse.aad.CustomerService.exception.InvalidException;
import lk.ijse.gdse.aad.CustomerService.exception.NotFoundException;
import lk.ijse.gdse.aad.CustomerService.persistance.OrderDAO;
import lk.ijse.gdse.aad.CustomerService.util.DataTypeConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private DataTypeConversion dataTypeConversion;
    @Autowired
    private OrderDAO orderDAO;


    @Override
    public OrderDTO saveCustomer(OrderDTO customer) {
        customer.setOrderId(UUID.randomUUID().toString());
        return dataTypeConversion.getCustomerDTO(orderDAO
                .save(dataTypeConversion.getCustomerEntity(customer)));
    }

    @Override
    public OrderDTO getSelectedCustomer(String code) {
        if(!orderDAO.existsById(code)) throw new InvalidException("Order not found");
        return dataTypeConversion.getCustomerDTO((orderDAO.getOrderByOrderId(code)));
    }

    @Override
    public void updateCustomer(OrderDTO order) {
        Optional<Order> tmpOrder = orderDAO.findById(order.getOrderId());
        if (!tmpOrder.isPresent()) throw new RuntimeException("Order Not found");
        tmpOrder.get().setOrderValue(order.getOrderValue());
        tmpOrder.get().setOrderDate(order.getOrderDate());
    }

    @Override
    public void deleteCustomer(String code) {
        if(!orderDAO.existsById(code)) throw new NotFoundException("Invalid Order");
         orderDAO.deleteByOrderId(code);
    }
    public CustomerOrder getMultipleData(@RequestBody CustomerOrder){

    }
}
