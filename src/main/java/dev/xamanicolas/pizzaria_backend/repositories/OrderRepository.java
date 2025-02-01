package dev.xamanicolas.pizzaria_backend.repositories;

import dev.xamanicolas.pizzaria_backend.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
