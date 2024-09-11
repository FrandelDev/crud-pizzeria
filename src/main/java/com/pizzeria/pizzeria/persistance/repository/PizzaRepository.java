package com.pizzeria.pizzeria.persistance.repository;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

import com.pizzeria.pizzeria.persistance.entity.Pizza;

public interface PizzaRepository extends ListCrudRepository<Pizza, Integer> {
    List<Pizza> findAllByAvailableTrueOrderByPrice();
    Pizza findAllByAvailableTrueAndNameIgnoreCase(String name);
}
