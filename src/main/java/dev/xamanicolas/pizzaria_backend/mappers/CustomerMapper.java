package dev.xamanicolas.pizzaria_backend.mappers;

import dev.xamanicolas.pizzaria_backend.dto.CustomerDTO;
import dev.xamanicolas.pizzaria_backend.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerDTO toDTO(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getCustomerName(),
                customer.getCpf(),
                customer.getEmail(),
                customer.getPhone(),
                customer.getHouseNumber(),
                customer.getStreet(),
                customer.getZip()
        );
    }

    public Customer toEntity(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.id(),
                customerDTO.customerName(),
                customerDTO.cpf(),
                customerDTO.email(),
                customerDTO.phone(),
                customerDTO.houseNumber(),
                customerDTO.street(),
                customerDTO.zip()
        );
    }
}
