package dev.xamanicolas.pizzaria_backend.dto;

public record PizzaOrderRequestDTO(
        Long pizzaId,
        Long quantity
) {

}