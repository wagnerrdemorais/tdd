package com.morais.wagner.tdd.frete.model;

import com.morais.wagner.tdd.frete.exceptions.ProductAlreadyAddedException;

import java.util.List;

public class ShoppingCart {
    private User user;
    private List<Product> products;

    public ShoppingCart(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private void addProduct(Product product) throws ProductAlreadyAddedException {
        if (this.getProducts().contains(product)) {
            throw new ProductAlreadyAddedException();
        } else {
            this.getProducts().add(product);
        }
    }

    public void addProducts(List<Product> products) throws ProductAlreadyAddedException {
        for (Product p : products) {
            this.addProduct(p);
        }
    }

}
