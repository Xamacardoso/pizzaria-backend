package dev.xamanicolas.pizzaria_backend.mappers;

import dev.xamanicolas.pizzaria_backend.dto.PizzaOrderRequestDTO;
import dev.xamanicolas.pizzaria_backend.dto.PizzaOrderResponseDTO;
import dev.xamanicolas.pizzaria_backend.entities.CustomerOrder;
import dev.xamanicolas.pizzaria_backend.entities.Pizza;
import dev.xamanicolas.pizzaria_backend.entities.PizzaOrder;
import dev.xamanicolas.pizzaria_backend.repositories.CustomerOrderRepository;
import dev.xamanicolas.pizzaria_backend.repositories.PizzaRepository;
import org.springframework.stereotype.Component;

@Component
public class PizzaOrderMapper {

    private CustomerOrderRepository customerOrderRepository;
    private PizzaRepository pizzaRepository;

    public PizzaOrderMapper(CustomerOrderRepository customerOrderRepository, PizzaRepository pizzaRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public PizzaOrderResponseDTO toDTO(PizzaOrder pizzaOrder) {
        return new PizzaOrderResponseDTO(
                pizzaOrder.getId(),
                pizzaOrder.getPizza().getId(),
                pizzaOrder.getOrder().getId(),
                pizzaOrder.getQuantity()
                );
    }

    public PizzaOrder toEntity(PizzaOrderResponseDTO dto) {
        CustomerOrder customerOrder = customerOrderRepository.findById(dto.customerOrderId())
                .orElseThrow(() -> new RuntimeException("Order not found!"));

        Pizza pizza = pizzaRepository.findById(dto.pizzaId())
                .orElseThrow(() -> new RuntimeException("Pizza not found!"));

        return new PizzaOrder(
            customerOrder,
            pizza,
            dto.quantity()
        );
    }

    public PizzaOrder toEntity(PizzaOrderRequestDTO dto) {
        Pizza pizza = pizzaRepository.findById(dto.pizzaId())
                .orElseThrow(() -> new RuntimeException("Pizza not found!"));

        return new PizzaOrder(pizza, dto.quantity());
    }

}
