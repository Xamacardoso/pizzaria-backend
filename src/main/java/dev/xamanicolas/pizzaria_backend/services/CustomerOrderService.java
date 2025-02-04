package dev.xamanicolas.pizzaria_backend.services;

import dev.xamanicolas.pizzaria_backend.dto.CustomerOrderResponseDTO;
import dev.xamanicolas.pizzaria_backend.mappers.CustomerOrderResponseMapper;
import dev.xamanicolas.pizzaria_backend.repositories.CustomerOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderResponseMapper customerOrderResponseMapper;

    public CustomerOrderService(CustomerOrderRepository orderRepository, CustomerOrderResponseMapper responseMapper) {
        this.customerOrderRepository = orderRepository;
        this.customerOrderResponseMapper = responseMapper;
    }

    @Transactional
    public List<CustomerOrderResponseDTO> findAll(){
        return customerOrderRepository.findAll()
                .stream()
                .map(customerOrderResponseMapper::toDto)
                .toList();
    }
}
