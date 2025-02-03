package dev.xamanicolas.pizzaria_backend.mappers;

import dev.xamanicolas.pizzaria_backend.dto.PizzaOrderDTO;
import dev.xamanicolas.pizzaria_backend.entities.CustomerOrder;
import dev.xamanicolas.pizzaria_backend.entities.Pizza;
import dev.xamanicolas.pizzaria_backend.entities.PizzaOrder;
import dev.xamanicolas.pizzaria_backend.repositories.CustomerOrderRepository;
import dev.xamanicolas.pizzaria_backend.repositories.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PizzaOrderMapper {

    private CustomerOrderRepository customerOrderRepository;
    private PizzaRepository pizzaRepository;

    public PizzaOrderMapper(CustomerOrderRepository customerOrderRepository, PizzaRepository pizzaRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public PizzaOrderDTO toDTO(PizzaOrder pizzaOrder) {
        return new PizzaOrderDTO(
                pizzaOrder.getId(),
                pizzaOrder.getPizza().getId(),
                pizzaOrder.getOrder().getId(),
                pizzaOrder.getPizza().getPrice(),
                pizzaOrder.getQuantity(),
                pizzaOrder.subTotal()
                );
    }

    public PizzaOrder toEntity(PizzaOrderDTO dto) {
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

}
