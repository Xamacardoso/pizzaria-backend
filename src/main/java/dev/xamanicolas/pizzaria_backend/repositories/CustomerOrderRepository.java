package dev.xamanicolas.pizzaria_backend.repositories;

import dev.xamanicolas.pizzaria_backend.entities.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
