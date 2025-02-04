package dev.xamanicolas.pizzaria_backend.controllers;

import dev.xamanicolas.pizzaria_backend.dto.CustomerOrderRequestDTO;
import dev.xamanicolas.pizzaria_backend.dto.CustomerOrderResponseDTO;
import dev.xamanicolas.pizzaria_backend.services.CustomerOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PostMapping(value = "/create")
    public ResponseEntity<CustomerOrderResponseDTO> insert(@RequestBody CustomerOrderRequestDTO dto){
        CustomerOrderResponseDTO newOrder = customerOrderService.insert(dto);
        return ResponseEntity
                .created(URI.create("/orders" + newOrder.id()))
                .body(newOrder);
    }
}
