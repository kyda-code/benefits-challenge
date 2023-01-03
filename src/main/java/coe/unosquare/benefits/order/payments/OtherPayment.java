package coe.unosquare.benefits.order.payments;

import coe.unosquare.benefits.order.Order;
import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * This class handle all the payments related with other types of payments
 */
public class OtherPayment extends Order {

    public OtherPayment(final Map<Product, Integer> productsMap){
        super(productsMap);
    }

    @Override
    public Double pay(String paymentType) {
        return calculateTotal(0.0);
    }
}
