package dev.xamanicolas.pizzaria_backend.mappers;

import dev.xamanicolas.pizzaria_backend.dto.CustomerOrderResponseDTO;
import dev.xamanicolas.pizzaria_backend.entities.CustomerOrder;
import dev.xamanicolas.pizzaria_backend.repositories.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerOrderResponseMapper {

    private final PizzaOrderMapper pizzaOrderMapper;

    public CustomerOrderResponseMapper(PizzaOrderMapper pizzaOrderMapper){
        this.pizzaOrderMapper = pizzaOrderMapper;
    }

    public CustomerOrderResponseDTO toDto(CustomerOrder customerOrder) {
        return new CustomerOrderResponseDTO(
            customerOrder.getId(),
            customerOrder.getCustomer().getCustomerName(),
            customerOrder.getOrders().stream().map(pizzaOrderMapper::toDTO).toList(),
            customerOrder.getTotal()
        );
    }
}
