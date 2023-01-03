/*
 *  Order
 *  1.0
 *  11/8/22, 8:28 PM
 *  Copyright (c) 2022 Unosquare
 *  Any illegal reproduction of this content will result in immediate legal action.
 */

package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;
import java.util.Map;

/**
 * The type Order.
 */
public class Order {
    /** Store the final list of products and quantity for each product. **/
    private final Map<Product, Integer> products;

    /**
     * Instantiates a new Order.
     *
     * @param productsMap the list of products added to the order
     */
    public Order(final Map<Product, Integer> productsMap) {
        products = productsMap;
    }

    /**
     * Pay double.
     *
     * @param paymentType the payment type
     * @return the double
     */
    public Double pay(final String paymentType) {
        Double discount;
        if (paymentType.equals("Visa")) {
            if (products.values()
                    .stream()
                    .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= 10) {
                discount = 0.15;
            } else if (products.values()
                    .stream()
                    .reduce(0, (totalProductCount, quantity) -> totalProductCount += quantity) >= 7) {
                discount = 0.10;
            } else {
                discount = 0.05;
            }
        } else if (paymentType.equals("Mastercard")) {
            if (products.entrySet()
                    .stream()
                    .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                    .sum() >= 100) {
                discount = 0.17;
            } else if (products.entrySet().stream()
                    .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                    .sum() >= 75) {
                discount = 0.12;
            } else {
                discount = 0.08;
            }
        } else {
            discount = 0.0;
        }
        double subtotal = products.entrySet()
                            .stream()
                            .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                            .sum();
        return subtotal - subtotal * discount;
    }

    /**
     * Print details of the order
     */
    public void print() {
         products.forEach((product, quantity) ->
                 System.out.println("Product:{" + product.getName() + ","
                         + product.getPrice() + ","
                         + product.getType()
                         + "},Quantity:" + quantity
                         + ",Total:" + product.getPrice() * quantity));
    }

    /**
     * Return all the products related with the order
     * @return
     */
    public Map<Product, Integer> getProducts() {
        return products;
    }

    /**
     * Calculate the total of the order using stream
     * @param discount
     * @return
     */
    public double calculateTotal(double discount) {
        double subtotal = getProducts().entrySet()
                .stream()
                .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                .sum();
        return subtotal - subtotal * discount;
    }
}
