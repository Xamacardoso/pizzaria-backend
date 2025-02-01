package dev.xamanicolas.pizzaria_backend.services;

import dev.xamanicolas.pizzaria_backend.dto.CustomerDTO;
import dev.xamanicolas.pizzaria_backend.entities.Customer;
import dev.xamanicolas.pizzaria_backend.mappers.CustomerMapper;
import dev.xamanicolas.pizzaria_backend.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = customers.stream().map(CustomerMapper::toDTO).toList();
        return customerDTOs;
    }
}
