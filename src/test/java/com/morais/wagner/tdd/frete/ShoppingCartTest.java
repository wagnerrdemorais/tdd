package com.morais.wagner.tdd.frete;

import com.morais.wagner.tdd.frete.model.CartProduct;
import com.morais.wagner.tdd.frete.model.Product;
import com.morais.wagner.tdd.frete.model.ShoppingCart;
import com.morais.wagner.tdd.frete.model.User;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

    @Test
    public void ifCartValueIsEmptyValueShouldBeZero() {
        List<CartProduct> pList = new ArrayList<>();
        User mockUser = TestUtils.buildMockUser();
        ShoppingCart sc = new ShoppingCart(mockUser, pList);
        assertEquals(0, sc.getTotalValue().compareTo(BigDecimal.ZERO));
    }

    @Test
    public void whenMoreProductsAreAddedCartShouldHaveCorrectItemCount() {
        ShoppingCart sc = TestUtils.buildMockShoppingCart(0);
        assertEquals(0, sc.getTotalValue().compareTo(BigDecimal.ZERO));
    }

    @Test
    public void whenAddAlreadyAddedProductCartShouldReturnCorrectQuantity() {
        ShoppingCart sc = TestUtils.buildMockShoppingCart(1);
        assertEquals(1, sc.getProductCount());
        assertEquals(10, sc.getItemCount());

        TestUtils.changeAddedProductsQuantity(5, sc);
        assertEquals(1, sc.getProductCount());
        assertEquals(5, sc.getItemCount());
    }

    @Test
    public void whenAddAlreadyAddedProductCartShouldReturnCorrectValue() {
        ShoppingCart sc = TestUtils.buildMockShoppingCart(1);
        assertEquals(new BigDecimal(10), sc.getTotalValue());

        TestUtils.changeAddedProductsQuantity(5, sc);
        assertEquals(new BigDecimal(5), sc.getTotalValue());
    }

    @Test
    public void whenProductIsRemovedCartShouldReturnCorrectQuantity() {
        ShoppingCart sc = TestUtils.buildMockShoppingCart(5);
        assertEquals(5, sc.getProductCount());
        assertEquals(50, sc.getItemCount());

        TestUtils.changeAddedProductsQuantity(0, sc);
        assertEquals(0, sc.getProductCount());
        assertEquals(0, sc.getItemCount());
    }

    @Test
    public void whenProductIsRemovedCartShouldReturnCorrectValue() {
        ShoppingCart sc = TestUtils.buildMockShoppingCart(5);
        assertEquals(new BigDecimal(150), sc.getTotalValue());

        sc.removeProduct(sc.getProducts().get(0).getProduct());
        assertEquals(new BigDecimal(110), sc.getTotalValue());
    }

    @Test
    public void whenMultipleProductsAreAddedAtSameTimeCartShouldHaveCorrectQuantity() {
        ShoppingCart sc = TestUtils.buildMockShoppingCart(1);
        assertEquals(1, sc.getProductCount());
        assertEquals(10, sc.getItemCount());

        List<CartProduct> pList = new ArrayList<>();
        pList.add(TestUtils.buildMockCartProduct(new BigDecimal(2), new BigDecimal(1)));
        pList.add(TestUtils.buildMockCartProduct(new BigDecimal(3), new BigDecimal(1)));
        pList.add(TestUtils.buildMockCartProduct(new BigDecimal(4), new BigDecimal(1)));

        sc.addProducts(pList);
        assertEquals(4, sc.getProductCount());
        assertEquals(13, sc.getItemCount());
    }

    @Test
    public void whenMultipleProductsAreAddedAtSameTimeCartShouldHaveCorrectValue() {
        ShoppingCart sc = TestUtils.buildMockShoppingCart(1);
        assertEquals(new BigDecimal(10), sc.getTotalValue());

        List<CartProduct> pList = new ArrayList<>();
        pList.add(TestUtils.buildMockCartProduct(new BigDecimal(2), new BigDecimal(1)));
        pList.add(TestUtils.buildMockCartProduct(new BigDecimal(3), new BigDecimal(1)));
        pList.add(TestUtils.buildMockCartProduct(new BigDecimal(4), new BigDecimal(1)));

        sc.addProducts(pList);
        assertEquals(new BigDecimal(19), sc.getTotalValue());
    }

    @Test
    public void whenItemQuantityIsSetToZeroItemShouldBeRemoved() {
        ShoppingCart sc = TestUtils.buildMockShoppingCart(5);
        assertEquals(5, sc.getProductCount());
        assertEquals(50, sc.getItemCount());

        sc.changeProductQuantity(sc.getProducts().get(0).getProduct(), BigDecimal.ZERO);

        assertEquals(40, sc.getItemCount());
    }

}
