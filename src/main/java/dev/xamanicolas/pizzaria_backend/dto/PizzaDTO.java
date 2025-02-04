package dev.xamanicolas.pizzaria_backend.dto;

import dev.xamanicolas.pizzaria_backend.entities.enums.PizzaSize;

import java.math.BigDecimal;

public record PizzaDTO (
        Long id,
        String flavor,
        PizzaSize size,
        BigDecimal price
) {

}
