package com.shopping.cart;

import com.shopping.cart.config.ProductConfig;
import com.shopping.cart.controller.CartController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ShoppingCartApplicationTests {

    @Autowired
    CartController controller;

    @Autowired
    ProductConfig productConfig;

    @Test
    void getProdutcs() {
        assertEquals(6,productConfig.getProducts().size());
    }

}
