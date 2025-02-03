package dev.xamanicolas.pizzaria_backend.mappers;

import dev.xamanicolas.pizzaria_backend.dto.PizzaDTO;
import dev.xamanicolas.pizzaria_backend.entities.Pizza;
import org.springframework.stereotype.Component;

@Component
public class PizzaMapper {
    public PizzaDTO toDTO(Pizza pizza){
        return new PizzaDTO(
                pizza.getId(),
                pizza.getFlavor(),
                pizza.getSize(),
                pizza.getPrice()
                );
    }

    public Pizza toEntity(PizzaDTO pizzaDTO){
        return new Pizza(
                pizzaDTO.id(),
                pizzaDTO.flavor(),
                pizzaDTO.size(),
                pizzaDTO.price()
        );
    }
}
