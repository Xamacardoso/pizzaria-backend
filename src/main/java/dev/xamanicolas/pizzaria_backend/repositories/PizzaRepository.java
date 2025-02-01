package dev.xamanicolas.pizzaria_backend.repositories;

import dev.xamanicolas.pizzaria_backend.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
