package com.shopping.cart.service;

import com.shopping.cart.config.ProductConfig;
import com.shopping.cart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CartService {
    @Autowired
    ProductConfig productConfig;
    public static List<Product> listProductSelected = new ArrayList<>();

     public void addItems(Product product) {
        listProductSelected.add(product);
    }

    public Double totalPrice() {
        Map<String,List<Product>> map= listProductSelected.stream().
                collect(Collectors.groupingBy(Product::getProductId));
        final Map<String,Double> total = new HashMap<>();
        total.put("total",0.0);
        map.entrySet().forEach(obj->{
            if ("B".equals(obj.getKey())) {
                final double price = total.get("total") + map.get("B").size() *  productConfig.getProducts().get("B");
                final double totalPrice  = price - (productConfig.getProducts().get("B")/2) * map.get("A").size();
                total.put("total", totalPrice);
            }else {
                final double price = total.get("total") + obj.getValue().size() * productConfig.getProducts().get(obj.getKey());
                total.put("total", price);
            }
        });

        return total.get("total");
    }
}
