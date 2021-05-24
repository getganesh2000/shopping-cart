package com.shopping.cart.config;

import com.shopping.cart.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class ProductConfig {

    private Map<String,Double> productsPrice;
    @Value("${product.list}")
    private String listOfProducts;
    @Value("${product.prices}")
    private String listOfPrices;
    Logger logger = LoggerFactory.getLogger(ProductConfig.class);

    @Bean
    public Map<String,Double> getProducts() {
        String[] products = listOfProducts.split(",");
        String[] prices = listOfPrices.split(",");
        Map<String,Double> map = new HashMap<>();
        if (products.length > 0) {
            for (int i = 0; i < products.length; i++) {
                map.put(products[i],i<= prices.length?Double.parseDouble(prices[i]):0);
            }
        }
        return map;
    }

}
