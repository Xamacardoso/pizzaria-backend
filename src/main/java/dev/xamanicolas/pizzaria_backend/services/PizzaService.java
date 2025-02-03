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
    private final PizzaMapper pizzaMapper;

    public PizzaService(PizzaRepository pizzaRepository, PizzaMapper pizzaMapper) {
        this.pizzaRepository = pizzaRepository;
        this.pizzaMapper = pizzaMapper;
    }

    @Transactional(readOnly = true)
    public List<PizzaDTO> findAll(){
        List<Pizza> pizzas = pizzaRepository.findAll();
        List<PizzaDTO> pizzaDTOs = pizzas.stream().map(pizzaMapper::toDTO).toList();
        return pizzaDTOs;
    }
}
