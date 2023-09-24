package lk.ijse.gdse.aad.CustomerService.api;

import lk.ijse.gdse.aad.CustomerService.dto.CustomerOrder;
import lk.ijse.gdse.aad.CustomerService.dto.OrderDTO;
import lk.ijse.gdse.aad.CustomerService.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/order")
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    @Value("${customer-service-endpoint}")
    private String customerDataEndpoint;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json",produces = "application/json")
    OrderDTO saveCustomer(@RequestBody OrderDTO customerDto){
        //If have errors
        return orderService.saveOrder(customerDto);
    }

    @GetMapping(value = "{code}",produces = MediaType.APPLICATION_JSON_VALUE)
    OrderDTO getSelectedCustomer(@PathVariable String code){
        return orderService.getSelectedOrder(code);
    }

    @DeleteMapping(value =  "{code}")
    void deleteCustomer ( @PathVariable String code){
        orderService.deleteOrder(code);
    }

    @PatchMapping(value = "{code}")
    void updateCustomer(@PathVariable String code, @RequestBody OrderDTO customer){
        //chk errors
        customer.setCustomerId(code);
        orderService.updateOrder(customer);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerOrder getFullProfile(@RequestParam String customerId){
        //Method -1 - with RestTemplate(legacy)
//        RestTemplate restTemplate = new RestTemplate();
//        CustomerOrder initialCustomer = restTemplate.getForObject(customerDataEndpoint + customerId, CustomerOrder.class);
//        return orderService.getFullProfileData(initialCustomer);

        //Method -2 - with WebClient(modern)
        WebClient webClient = WebClient.create(customerDataEndpoint + "/" + customerId);
        Mono<CustomerOrder> responseCustomer  = webClient.get()
                .retrieve() // fetch the data
                .bodyToMono(CustomerOrder.class);
                 return orderService.getFullProfileData(responseCustomer.block());




    }

}
