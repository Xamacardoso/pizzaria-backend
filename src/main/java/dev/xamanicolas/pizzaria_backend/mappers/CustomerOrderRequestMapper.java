package dev.xamanicolas.pizzaria_backend.mappers;
import dev.xamanicolas.pizzaria_backend.dto.CustomerOrderRequestDTO;
import dev.xamanicolas.pizzaria_backend.entities.Customer;
import dev.xamanicolas.pizzaria_backend.entities.CustomerOrder;
import dev.xamanicolas.pizzaria_backend.entities.PizzaOrder;
import dev.xamanicolas.pizzaria_backend.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerOrderRequestMapper {

    private final CustomerRepository customerRepository;
    private final PizzaOrderMapper pizzaOrderMapper;
    
    public CustomerOrderRequestMapper(CustomerRepository customerRepository, PizzaOrderMapper pizzaOrderMapper) {
        this.customerRepository = customerRepository;
        this.pizzaOrderMapper = pizzaOrderMapper;
    }

    public CustomerOrder toEntity(CustomerOrderRequestDTO dto){
        Customer customer = customerRepository.findById(dto.customerId())
                .orElseThrow(() -> new RuntimeException("Customer not found!"));

        List<PizzaOrder> orders = dto.orders().stream().map(pizzaOrderMapper::toEntity).toList();

        return new CustomerOrder(customer, orders);
    }
}
