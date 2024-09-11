package com.pizzeria.pizzeria.persistance.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.pizzeria.pizzeria.persistance.entity.PizzaOrder;

public interface PizzaOrderRepository extends ListCrudRepository<PizzaOrder, Integer> {

}
