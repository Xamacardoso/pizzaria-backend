package dev.xamanicolas.pizzaria_backend.repositories;

import dev.xamanicolas.pizzaria_backend.entities.PizzaOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Long> {
}
