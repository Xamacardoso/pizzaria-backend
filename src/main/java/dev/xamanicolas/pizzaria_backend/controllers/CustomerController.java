package dev.xamanicolas.pizzaria_backend.controllers;

import dev.xamanicolas.pizzaria_backend.dto.CustomerDTO;
import dev.xamanicolas.pizzaria_backend.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> findAll(){
        return customerService.findAll();
    }
}
