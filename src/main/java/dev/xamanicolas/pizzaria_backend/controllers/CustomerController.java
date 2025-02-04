package dev.xamanicolas.pizzaria_backend.controllers;

import dev.xamanicolas.pizzaria_backend.dto.CustomerDTO;
import dev.xamanicolas.pizzaria_backend.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerDTO> findAll(){
        return customerService.findAll();
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> insert(@RequestBody CustomerDTO customerDTO){
        CustomerDTO newCustomer = customerService.insert(customerDTO);
        return ResponseEntity.created(URI.create("/customers/" + newCustomer.id())).body(newCustomer);
    }
}
