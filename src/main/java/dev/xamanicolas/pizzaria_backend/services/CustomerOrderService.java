package dev.xamanicolas.pizzaria_backend.services;

import dev.xamanicolas.pizzaria_backend.dto.CustomerOrderRequestDTO;
import dev.xamanicolas.pizzaria_backend.dto.CustomerOrderResponseDTO;
import dev.xamanicolas.pizzaria_backend.entities.Customer;
import dev.xamanicolas.pizzaria_backend.entities.CustomerOrder;
import dev.xamanicolas.pizzaria_backend.entities.PizzaOrder;
import dev.xamanicolas.pizzaria_backend.mappers.CustomerOrderRequestMapper;
import dev.xamanicolas.pizzaria_backend.mappers.CustomerOrderResponseMapper;
import dev.xamanicolas.pizzaria_backend.mappers.PizzaOrderMapper;
import dev.xamanicolas.pizzaria_backend.repositories.CustomerOrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;
    private final CustomerOrderResponseMapper customerOrderResponseMapper;
    private final CustomerService customerService;
    private final PizzaOrderMapper pizzaOrderMapper;

    public CustomerOrderService(CustomerOrderRepository orderRepository,
                                CustomerOrderResponseMapper responseMapper,
                                CustomerOrderRequestMapper requestMapper,
                                CustomerService customerService,
                                PizzaOrderMapper pizzaOrderMapper) {
        this.customerOrderRepository = orderRepository;
        this.customerOrderResponseMapper = responseMapper;
        this.customerService = customerService;
        this.pizzaOrderMapper = pizzaOrderMapper;
    }

    @Transactional(readOnly = true)
    public List<CustomerOrderResponseDTO> findAll(){
        return customerOrderRepository.findAll()
                .stream()
                .map(customerOrderResponseMapper::toDto)
                .toList();
    }

    @Transactional
    public CustomerOrderResponseDTO insert(CustomerOrderRequestDTO dto) {
        Customer customer = customerService.findById(dto.customerId());
        CustomerOrder customerOrder = new CustomerOrder(customer);

        List<PizzaOrder> pizzaOrders = dto.orders().stream()
                .map(pizzaOrderMapper::toEntity)
                .toList();

        for (PizzaOrder pizzaOrder : pizzaOrders) {
            pizzaOrder.setOrder(customerOrder);
        }

        customerOrder.setOrders(pizzaOrders);
        customerOrder.calculateTotal();
        CustomerOrderResponseDTO responseDTO = this.customerOrderResponseMapper.toDto(this.customerOrderRepository.save(customerOrder));
        return responseDTO;
    }
}
