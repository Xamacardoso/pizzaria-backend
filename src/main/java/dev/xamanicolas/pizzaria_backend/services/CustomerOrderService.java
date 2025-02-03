package dev.xamanicolas.pizzaria_backend.services;

import dev.xamanicolas.pizzaria_backend.repositories.CustomerOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderService {

    private CustomerOrderRepository customerOrderRepository;

    public CustomerOrderService(CustomerOrderRepository customerOrderRepository) {
        this.customerOrderRepository = customerOrderRepository;
    }

    // TODO: Create findAll() method and Order DTO
}
