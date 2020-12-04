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
        User mockUser = buildMockUser();
        ShoppingCart sc = new ShoppingCart(mockUser, pList);
        assertEquals(0, sc.getTotalValue().compareTo(BigDecimal.ZERO));
    }

    @Test
    public void whenMoreProductsAreAddedCartShouldHaveCorrectItemCount() {
        ShoppingCart sc = buildMockShoppingCart(0);
        assertEquals(0, sc.getTotalValue().compareTo(BigDecimal.ZERO));
    }

    @Test
    public void whenAddAlreadyAddedProductCartShouldReturnCorrectQuantity() {
        ShoppingCart sc = buildMockShoppingCart(1);
        assertEquals(1, sc.getProductCount());
        assertEquals(10, sc.getItemCount());

        changeAddedProductsQuantity(5, sc);
        assertEquals(1, sc.getProductCount());
        assertEquals(5, sc.getItemCount());
    }

    @Test
    public void whenAddAlreadyAddedProductCartShouldReturnCorrectValue() {
        ShoppingCart sc = buildMockShoppingCart(1);
        assertEquals(new BigDecimal(10), sc.getTotalValue());

        changeAddedProductsQuantity(5, sc);
        assertEquals(new BigDecimal(5), sc.getTotalValue());
    }

    @Test
    public void whenProductIsRemovedCartShouldReturnCorrectQuantity() {
        ShoppingCart sc = buildMockShoppingCart(5);
        assertEquals(5, sc.getProductCount());
        assertEquals(50, sc.getItemCount());

        changeAddedProductsQuantity(0, sc);
        assertEquals(0, sc.getProductCount());
        assertEquals(0, sc.getItemCount());
    }

    @Test
    public void whenProductIsRemovedCartShouldReturnCorrectValue() {
        ShoppingCart sc = buildMockShoppingCart(5);
        assertEquals(new BigDecimal(150), sc.getTotalValue());

        sc.removeProduct(sc.getProducts().get(0).getProduct());
        assertEquals(new BigDecimal(140), sc.getTotalValue());
    }

    @Test
    public void whenMultipleProductsAreAddedAtSameTimeCartShouldHaveCorrectQuantity() {
        ShoppingCart sc = buildMockShoppingCart(1);
        assertEquals(1, sc.getProductCount());
        assertEquals(10, sc.getItemCount());

        List<CartProduct> pList = new ArrayList<>();
        pList.add(buildMockCartProduct(new BigDecimal(2), new BigDecimal(1)));
        pList.add(buildMockCartProduct(new BigDecimal(3), new BigDecimal(1)));
        pList.add(buildMockCartProduct(new BigDecimal(4), new BigDecimal(1)));

        sc.addProducts(pList);
        assertEquals(4, sc.getProductCount());
        assertEquals(13, sc.getItemCount());
    }

    @Test
    public void whenMultipleProductsAreAddedAtSameTimeCartShouldHaveCorrectValue() {
        ShoppingCart sc = buildMockShoppingCart(1);
        assertEquals(new BigDecimal(10), sc.getTotalValue());

        List<CartProduct> pList = new ArrayList<>();
        pList.add(buildMockCartProduct(new BigDecimal(2), new BigDecimal(1)));
        pList.add(buildMockCartProduct(new BigDecimal(3), new BigDecimal(1)));
        pList.add(buildMockCartProduct(new BigDecimal(4), new BigDecimal(1)));

        sc.addProducts(pList);
        assertEquals(new BigDecimal(19), sc.getTotalValue());
    }

    @Test
    public void whenItemQuantityIsSetToZeroItemShouldBeRemoved() {
        ShoppingCart sc = buildMockShoppingCart(5);
        assertEquals(5, sc.getProductCount());
        assertEquals(50, sc.getItemCount());

        sc.changeProductQuantity(sc.getProducts().get(0).getProduct(), BigDecimal.ZERO);

        assertEquals(40, sc.getItemCount());
    }


    public User buildMockUser() {
        return new User("usuario", "123456");
    }

    public CartProduct buildMockCartProduct(BigDecimal price, BigDecimal qtd) {
        String name = "ProductNameIsPrice: " + price;
        Product product = new Product(name, price);
        return new CartProduct(product, qtd);
    }

    public List<CartProduct> buildMockCartProductList(int listSize) {
        List<CartProduct> pList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            pList.add(buildMockCartProduct(new BigDecimal(i + 1), BigDecimal.TEN));
        }
        return pList;
    }

    public ShoppingCart buildMockShoppingCart(int qtdProducts) {
        return new ShoppingCart(buildMockUser(), buildMockCartProductList(qtdProducts));
    }

    public void changeAddedProductsQuantity(int qtd, ShoppingCart sc) {
        for (CartProduct p : sc.getProducts()) {
            sc.addProduct(p.getProduct(), new BigDecimal(qtd));
        }
    }

}
