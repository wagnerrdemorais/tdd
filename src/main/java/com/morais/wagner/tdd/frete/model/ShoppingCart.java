package com.morais.wagner.tdd.frete.model;

import java.math.BigDecimal;
import java.util.*;

public class ShoppingCart {
    private final User user;
    private final Map<UUID, CartProduct> productMap = new HashMap<>();

    public ShoppingCart(User user, List<CartProduct> products) {
        this.user = user;
        addProducts(products);
    }

    private void changeProduct(Product product, BigDecimal newQtd) {
        UUID id = product.getId();
        if (newQtd.compareTo(BigDecimal.ZERO) > 0) {
            CartProduct cartProduct = productMap.get(id);
            if (cartProduct == null) {
                cartProduct = new CartProduct(product, newQtd);
            }
            cartProduct.setQuantity(newQtd);
            this.productMap.put(id, cartProduct);
        } else if (newQtd.compareTo(BigDecimal.ZERO) <= 0) {
            this.productMap.remove(id);
        }
    }

    public void addProduct(Product product, BigDecimal qtd) {
        changeProduct(product, qtd);
    }

    public void addProducts(List<CartProduct> products) {
        for (CartProduct p : products) {
            addProduct(p.getProduct(), p.getQuantity());
        }
    }

    public void removeProduct(Product product) {
        productMap.remove(product.getId());
    }

    private void removeProducts(List<CartProduct> products) {
        if (products == null || products.isEmpty()) {
            return;
        }

        for (CartProduct p : products) {
            removeProduct(p.getProduct());
        }
    }

    public List<CartProduct> getProducts() {
        if (!haveProducts())
            return null;

        Collection<CartProduct> products = productMap.values();
        return new ArrayList<CartProduct>(products);
    }

    public BigDecimal getTotalValue() {
        BigDecimal sum = BigDecimal.ZERO;
        if (!haveProducts())
            return sum;

        for (CartProduct p : getProducts()) {
            BigDecimal price = p.getProduct().getPrice();
            sum = p.getQuantity().multiply(price).add(sum);
        }

        return sum;
    }

    public User getUser() {
        return user;
    }

    public int getItemCount() {
        int qtd = 0;
        if (!haveProducts())
            return qtd;

        List<CartProduct> products = getProducts();

        for (CartProduct p : products) {
            qtd += p.getQuantity().intValue();
        }

        return qtd;
    }

    public int getProductCount() {
        return productMap != null ? productMap.size() : 0;
    }

    private boolean haveProducts() {
        return this.productMap != null && !this.productMap.isEmpty();
    }

    public void changeProductQuantity(Product p, BigDecimal qtd) {
        changeProduct(p, qtd);
    }
}
