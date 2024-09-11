package com.pizzeria.pizzeria.persistance.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * PizzaOrder Entity
 */
@Getter
@Setter
 @Entity
 @Table(name = "pizza_order")
public class PizzaOrder {

    @Column(name = "id_order", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "id_customer", nullable = false, length = 15)
    private String customerId;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime date;

    @Column(columnDefinition = "DECIMAL(6,2)", nullable=false)
    private Double total;

    @Column(columnDefinition = "CHAR(1)", nullable = false)
    private Character method;

    @Column(name = "additional_notes", length = 200)
    private String  additionalNotes;

    @OneToOne
    @JoinColumn(name="id_customer", referencedColumnName="id_customer",insertable = false,updatable = false)
    private Customer customer;

    @OneToMany(mappedBy = "pizzaOrder")
    private List<OrderItem> orderItems;
}