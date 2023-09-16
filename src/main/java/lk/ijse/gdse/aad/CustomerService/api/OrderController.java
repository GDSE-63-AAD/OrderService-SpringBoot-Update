package lk.ijse.gdse.aad.CustomerService.api;

import lk.ijse.gdse.aad.CustomerService.dto.OrderDTO;
import lk.ijse.gdse.aad.CustomerService.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin("*")
public class OrderController {

    private final OrderService customerService;

    public OrderController(OrderService customerService){
        this.customerService = customerService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    OrderDTO saveCustomer(@RequestBody OrderDTO customerDto){
        //If have errors
        return customerService.saveCustomer(customerDto);
    }

    @GetMapping(value = "{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDTO getSelectedCustomer(@PathVariable String code){
        return customerService.getSelectedCustomer(code);
    }

    @DeleteMapping(value =  "{code}")
    void deleteCustomer ( @PathVariable String code){
        customerService.deleteCustomer(code);
    }

    @PatchMapping(value = "{code}")
    void updateCustomer(@PathVariable String code, @RequestBody OrderDTO customer){
        //chk errors
        customer.setCustomerId(code);
        customerService.updateCustomer(customer);
    }

}
