package dev.xamanicolas.pizzaria_backend.services;

import dev.xamanicolas.pizzaria_backend.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // TODO: Create findAll() method and Order DTO
}
