package coe.unosquare.benefits.order.payments;

import coe.unosquare.benefits.order.Order;
import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * This class handle all the payments with Mastercard using a HashMap
 */
public class MastercardPayment extends Order {

    public MastercardPayment(Map<Product, Integer> productsMap) {
        super(productsMap);
    }

    @Override
    public Double pay(String paymentType) {
        double discount = 0.0;
        if (paymentType.equalsIgnoreCase("Mastercard")) {
            if (getProducts().entrySet()
                    .stream()
                    .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                    .sum() >= 100) {
                discount = 0.17;
            } else if (getProducts().entrySet().stream()
                    .mapToDouble(product -> product.getKey().getPrice() * product.getValue())
                    .sum() >= 75) {
                discount = 0.12;
            } else {
                discount = 0.08;
            }
        }
        return calculateTotal(discount);
    }

}
