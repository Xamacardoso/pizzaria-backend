package dev.xamanicolas.pizzaria_backend.controllers;

import dev.xamanicolas.pizzaria_backend.dto.CustomerOrderResponseDTO;
import dev.xamanicolas.pizzaria_backend.services.CustomerOrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class CustomerOrderController {

    private final CustomerOrderService customerOrderService;

    public CustomerOrderController(CustomerOrderService customerOrderService){
        this.customerOrderService = customerOrderService;
    }

    @GetMapping
    public List<CustomerOrderResponseDTO> findAll(){
        return customerOrderService.findAll();
    }
}
