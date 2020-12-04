package com.morais.wagner.tdd.frete.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private UUID id;
    private String description;
    private BigDecimal price;

    public Product(String description, BigDecimal price) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public UUID getId() {
        return this.id;
    }


}
