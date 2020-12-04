package com.morais.wagner.tdd.frete;

import com.morais.wagner.tdd.frete.controller.IShippingService;
import com.morais.wagner.tdd.frete.controller.ShoppingService;
import com.morais.wagner.tdd.frete.model.ShoppingCart;
import com.morais.wagner.tdd.frete.model.User;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShoppingServiceTest {

    @Test
    public void whenPriceIsLessThanOneHundredReturnPriceWithoutFee() {
        User user = mock(User.class);
        when(user.getPostalCode()).thenReturn("123456");

        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        when(shoppingCart.getTotalValue()).thenReturn(new BigDecimal(99));
        when(shoppingCart.getUser()).thenReturn(user);

        IShippingService shippingService = mock(IShippingService.class);
        ShoppingService shoppingService = new ShoppingService(shippingService);
        BigDecimal valueWithShippingFee = shoppingService.getValueWithShippingFee(shoppingCart);

        assertEquals(0, valueWithShippingFee.compareTo(new BigDecimal(99)));
    }

    @Test
    public void whenPriceIsOneHundredOrMoreReturnPriceWithFee() {
        User user = mock(User.class);
        when(user.getPostalCode()).thenReturn("123456");

        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        when(shoppingCart.getTotalValue()).thenReturn(new BigDecimal(100));
        when(shoppingCart.getUser()).thenReturn(user);

        IShippingService shippingService = mock(IShippingService.class);
        when(shippingService
                .checkLocationDeliveryFee(shoppingCart.getUser().getPostalCode())).thenReturn(new BigDecimal(25));

        ShoppingService shoppingService = new ShoppingService(shippingService);
        BigDecimal valueWithShippingFee = shoppingService.getValueWithShippingFee(shoppingCart);

        assertEquals(0, valueWithShippingFee.compareTo(new BigDecimal(125)));
    }

}
