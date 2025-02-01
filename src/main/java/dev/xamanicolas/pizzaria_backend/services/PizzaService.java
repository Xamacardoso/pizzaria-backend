package dev.xamanicolas.pizzaria_backend.services;

import dev.xamanicolas.pizzaria_backend.dto.PizzaDTO;
import dev.xamanicolas.pizzaria_backend.entities.Pizza;
import dev.xamanicolas.pizzaria_backend.mappers.PizzaMapper;
import dev.xamanicolas.pizzaria_backend.repositories.PizzaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @Transactional(readOnly = true)
    public List<PizzaDTO> findAll(){
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaDTO> pizzaDTOs = pizzas.stream().map(PizzaMapper::toDTO).toList();
        return pizzaDTOs;
    }
}
