package dev.xamanicolas.pizzaria_backend.controllers;

import dev.xamanicolas.pizzaria_backend.dto.PizzaDTO;
import dev.xamanicolas.pizzaria_backend.services.PizzaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/pizzas")
public class PizzaController {

    private PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public List<PizzaDTO> findAll(){
        return pizzaService.findAll();
    }


}
