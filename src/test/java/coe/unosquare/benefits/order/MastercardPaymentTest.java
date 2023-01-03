package coe.unosquare.benefits.order;
import coe.unosquare.benefits.product.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains the unit test related to the mastercard payment and discounts
 */
class MastercardPaymentTest {
    @Test
    void orderWithMastercard100MoreTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(120.00);
        assertEquals(0.17, payOrder(products, "Mastercard"));
    }

    @Test
    void orderWithMastercardExact100Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(100.00);
        assertEquals(0.17, payOrder(products, "Mastercard"));
    }

    @Test
    void orderWithMastercardExact75Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(75.00);
        assertEquals(0.12, payOrder(products, "Mastercard"));
    }

    @Test
    void orderWithMastercard75LessTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(60.00);
        assertEquals(0.08, payOrder(products, "Mastercard"));
    }
}
