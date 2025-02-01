package dev.xamanicolas.pizzaria_backend.mappers;

import dev.xamanicolas.pizzaria_backend.dto.CustomerDTO;
import dev.xamanicolas.pizzaria_backend.entities.Customer;

public class CustomerMapper {

    public static CustomerDTO toDTO(Customer customer) {
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

    public static Customer toEntity(CustomerDTO customerDTO) {
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
