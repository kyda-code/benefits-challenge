package coe.unosquare.benefits.order.maker;

import coe.unosquare.benefits.order.Order;
import coe.unosquare.benefits.order.payments.MastercardPayment;
import coe.unosquare.benefits.order.payments.OtherPayment;
import coe.unosquare.benefits.order.payments.VisaPayment;
import coe.unosquare.benefits.product.Product;

import java.util.Map;

/**
 * Generate a new order depending on the type of payments
 */
public class OrderMaker {

    public static Order constructOrder(String type, Map<Product, Integer> products) {
        switch(type) {
            case "Visa": return new VisaPayment(products);
            case "Mastercard": return new MastercardPayment(products);
            default: return new OtherPayment(products);
        }
    }
}
