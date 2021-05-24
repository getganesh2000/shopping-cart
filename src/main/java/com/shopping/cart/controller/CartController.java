package com.shopping.cart.controller;



import com.shopping.cart.config.ProductConfig;
import com.shopping.cart.model.Product;
import com.shopping.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping-cart")
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/add-item")
    public void addItems(@RequestBody Product product) {
        cartService.addItems(product);

    }
    @GetMapping("/get-total-price")
    public double getTotalPrice() {
        return cartService.totalPrice();
    }

}
