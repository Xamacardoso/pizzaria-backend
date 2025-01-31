package dev.xamanicolas.pizzaria_backend.repositories;

import dev.xamanicolas.pizzaria_backend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
