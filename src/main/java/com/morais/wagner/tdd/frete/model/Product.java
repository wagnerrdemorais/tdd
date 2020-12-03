package com.morais.wagner.tdd.frete.model;

import java.math.BigDecimal;

public class Product {

    private String description;
    private BigDecimal price;
    private BigDecimal quantity;

    public Product(String description, BigDecimal price, BigDecimal quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
