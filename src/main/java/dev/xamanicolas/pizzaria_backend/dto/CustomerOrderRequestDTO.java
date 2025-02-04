package dev.xamanicolas.pizzaria_backend.dto;

import java.util.List;

public record CustomerOrderRequestDTO(
        Long customerId,
        List<PizzaOrderDTO> orders
) {
}
