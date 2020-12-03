package com.morais.wagner.tdd.frete.view;

import com.morais.wagner.tdd.frete.model.ShoppingCart;
import com.morais.wagner.tdd.frete.utils.CalcUtils;

import java.math.BigDecimal;

public class ShoppingService {

    public BigDecimal calcToral(ShoppingCart cart) {
        CalcUtils calcUtils = new CalcUtils();
        return calcUtils.getTotalFromCart(cart);
    }

}
