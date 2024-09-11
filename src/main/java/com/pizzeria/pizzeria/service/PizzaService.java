package com.pizzeria.pizzeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzeria.pizzeria.persistance.entity.Pizza;
import com.pizzeria.pizzeria.persistance.repository.PizzaRepository;

@Service
public class PizzaService {

    private PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository){
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAll(){
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> get(Integer pizzaId){
        return pizzaRepository.findById(pizzaId);
    }

    public Pizza save(Pizza pizza){
        return pizzaRepository.save(pizza);
    }

    public void detete(Integer pizzaId){
        pizzaRepository.deleteById(pizzaId); 
    }
    public Boolean exist(Integer id){
        return pizzaRepository.existsById(id);
    }

    public List<Pizza> getAvailable() {
        return this.pizzaRepository.findAllByAvailableTrueOrderByPrice();
    }

    public Pizza getByName(String name) {
        return this.pizzaRepository.findAllByAvailableTrueAndNameIgnoreCase(name);
    }

}
