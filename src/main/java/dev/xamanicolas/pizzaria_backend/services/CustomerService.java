package dev.xamanicolas.pizzaria_backend.services;

import dev.xamanicolas.pizzaria_backend.dto.CustomerDTO;
import dev.xamanicolas.pizzaria_backend.entities.Customer;
import dev.xamanicolas.pizzaria_backend.mappers.CustomerMapper;
import dev.xamanicolas.pizzaria_backend.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;

    }

    @Transactional(readOnly = true)
    public List<CustomerDTO> findAll(){
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOs = customers.stream().map(customerMapper::toDTO).toList();
        return customerDTOs;
    }

    @Transactional
    public CustomerDTO insert(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.toDTO(customer);
    }
}
