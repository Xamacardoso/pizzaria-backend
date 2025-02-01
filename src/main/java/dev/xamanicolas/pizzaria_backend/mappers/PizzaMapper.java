package dev.xamanicolas.pizzaria_backend.mappers;

import dev.xamanicolas.pizzaria_backend.dto.PizzaDTO;
import dev.xamanicolas.pizzaria_backend.entities.Pizza;

public class PizzaMapper {
    public static PizzaDTO toDTO(Pizza pizza){
        return new PizzaDTO(
                pizza.getId(),
                pizza.getFlavor(),
                pizza.getSize(),
                pizza.getPrice()
                );
    }

    public static Pizza toEntity(PizzaDTO pizzaDTO){
        return new Pizza(
                pizzaDTO.id(),
                pizzaDTO.flavor(),
                pizzaDTO.size(),
                pizzaDTO.price()
        );
    }
}
