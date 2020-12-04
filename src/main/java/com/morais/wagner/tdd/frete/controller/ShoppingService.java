package com.morais.wagner.tdd.frete.controller;

import com.morais.wagner.tdd.frete.model.ShoppingCart;

import java.math.BigDecimal;

public class ShoppingService {
    IShippingService shippingService;

    public ShoppingService(IShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public BigDecimal getValueWithShippingFee(ShoppingCart shoppingCart) {
        BigDecimal totalValue = shoppingCart.getTotalValue();
        if (totalValue.compareTo(new BigDecimal(100)) < 0) {
            return totalValue;
        } else {
            String postalCode = shoppingCart.getUser().getPostalCode();
            BigDecimal fee = shippingService.checkLocationDeliveryFee(postalCode);
            return totalValue.add(fee);
        }
    }
}
