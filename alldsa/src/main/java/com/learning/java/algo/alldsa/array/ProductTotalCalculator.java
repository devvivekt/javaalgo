package com.learning.java.algo.alldsa.array;

import java.util.HashMap;
import java.util.Map;

public class ProductTotalCalculator {

    public static void main(String[] args) {
        String[] arr = {
                "product1\t2\t200.5",
                "product2\t3\t100.5",
                "product3\t1\t60.5",
                "product1\t4\t150.5",
                "product2\t5\t60.5",
                "product3\t10\t100.5",
                "product1\t10\t-100.5",
        };
        Map<String, Double> productPrice = calculateProductTotals(arr);
        productPrice
                .forEach((k,v) -> System.out.println("key->"+k+ "value->"+v));
    }

    public static Map<String, Double> calculateProductTotals(String[] arr){
        Map<String, Double> productPrice = new HashMap<>();
        for(String str : arr){
            String[] parts = str.split("\t");
            if(parts.length == 3){
                String product = parts[0];
                Integer qty = Integer.parseInt(parts[1]);
                Double price = Double.parseDouble(parts[2]);
                if(price > 0) {
                    double total = qty * price;
                    productPrice.put(product, productPrice.getOrDefault(product,0.0)+total);
                }
            }
        }
        return productPrice;
    }
}
