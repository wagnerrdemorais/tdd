package com.morais.wagner.tdd.frete.utils;

import com.morais.wagner.tdd.frete.model.Product;
import com.morais.wagner.tdd.frete.model.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public class CalcUtils {

    public BigDecimal getTotalFromCart(ShoppingCart shoppingCart) {
        List<Product> products = shoppingCart.getProducts();
        BigDecimal sum = BigDecimal.ZERO.stripTrailingZeros();
        if (products != null && !products.isEmpty()) {
            for (Product p : products) {
                sum.add(p.getPrice().multiply(p.getQuantity()));
            }
        }
        return sum;
    }

}
