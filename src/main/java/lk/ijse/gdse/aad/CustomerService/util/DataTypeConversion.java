package lk.ijse.gdse.aad.CustomerService.util;
import lk.ijse.gdse.aad.CustomerService.dto.OrderDTO;
import lk.ijse.gdse.aad.CustomerService.entity.Order;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DataTypeConversion {

    private final ModelMapper modelMapper;

    DataTypeConversion(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

   public OrderDTO getCustomerDTO(Order customer){
        return modelMapper.map(customer, OrderDTO.class);
    }
    public Order getCustomerEntity(OrderDTO customerDTO){
        return modelMapper.map(customerDTO, Order.class);
    }
}
