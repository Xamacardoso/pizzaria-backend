package dev.xamanicolas.pizzaria_backend.dto;

import java.math.BigDecimal;

public record PizzaOrderDTO(
        Long id,
        Long pizzaId,
        Long customerOrderId,
        BigDecimal pizzaPrice,
        Long quantity,
        BigDecimal subTotal
) {

}