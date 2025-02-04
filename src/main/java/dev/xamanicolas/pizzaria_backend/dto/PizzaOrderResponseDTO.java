package dev.xamanicolas.pizzaria_backend.dto;

public record PizzaOrderResponseDTO(
        Long id,
        Long pizzaId,
        Long customerOrderId,
        Long quantity
) {

}