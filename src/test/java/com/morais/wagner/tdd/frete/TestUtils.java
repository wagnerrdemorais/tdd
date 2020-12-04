package com.morais.wagner.tdd.frete;

import com.morais.wagner.tdd.frete.model.CartProduct;
import com.morais.wagner.tdd.frete.model.Product;
import com.morais.wagner.tdd.frete.model.ShoppingCart;
import com.morais.wagner.tdd.frete.model.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    public static User buildMockUser() {
        return new User("usuario", "123456");
    }

    public static CartProduct buildMockCartProduct(BigDecimal price, BigDecimal qtd) {
        String name = "ProductNameIsPrice: " + price;
        Product product = new Product(name, price);
        return new CartProduct(product, qtd);
    }

    public static List<CartProduct> buildMockCartProductList(int listSize) {
        List<CartProduct> pList = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            pList.add(buildMockCartProduct(new BigDecimal(i + 1), BigDecimal.TEN));
        }
        return pList;
    }

    public static ShoppingCart buildMockShoppingCart(int qtdProducts) {
        return new ShoppingCart(buildMockUser(), buildMockCartProductList(qtdProducts));
    }

    public static void changeAddedProductsQuantity(int qtd, ShoppingCart sc) {
        for (CartProduct p : sc.getProducts()) {
            sc.addProduct(p.getProduct(), new BigDecimal(qtd));
        }
    }
}
