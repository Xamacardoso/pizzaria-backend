package dev.xamanicolas.pizzaria_backend.dto;

public record CustomerDTO(Long id, String customerName, String cpf, String email, String phone, String houseNumber, String street, String zip){

}