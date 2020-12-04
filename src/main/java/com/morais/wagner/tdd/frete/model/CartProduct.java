package com.morais.wagner.tdd.frete.model;

import java.math.BigDecimal;

public class CartProduct {
    private final Product product;
    private BigDecimal quantity;

    public CartProduct(Product product, BigDecimal quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}
