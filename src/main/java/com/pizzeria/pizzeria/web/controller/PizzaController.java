package com.pizzeria.pizzeria.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pizzeria.pizzeria.persistance.entity.Pizza;
import com.pizzeria.pizzeria.service.PizzaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
public class PizzaController {

    private PizzaService pizzaService;


    public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }
    
    @GetMapping("/pizzas")
    public ResponseEntity<List<Pizza>> getAll() {
        return ResponseEntity.ok(pizzaService.getAll());
    }
    
    @GetMapping("/pizzas/{id}")
    public ResponseEntity<Optional<Pizza>> getMethodName(@PathVariable Integer id) {
        return ResponseEntity.ok(pizzaService.get(id));
    }

    @PostMapping("/pizzas")
    public ResponseEntity<Pizza> save(@RequestBody Pizza entity) {
       
        return ResponseEntity.ok(pizzaService.save(entity));
    }
    @PutMapping("pizzas/{id}")
    public ResponseEntity<Optional<Pizza>> update(@PathVariable Integer id, @RequestBody Pizza entity) {
        if(entity.getPizzaId() != null && pizzaService.exist(id)){
            pizzaService.save(entity);
            return ResponseEntity.ok(pizzaService.get(id));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/pizzas/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        if(pizzaService.exist(id)){
            pizzaService.detete(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().build();
    }
    
}
