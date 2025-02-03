package dev.xamanicolas.pizzaria_backend.dto;

import java.math.BigDecimal;
import java.util.List;

public record CustomerOrderDTO(
        Long id,
        String customerName,
        List<PizzaOrderDTO> items,
        BigDecimal total
) {

}