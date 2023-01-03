package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;

/**
 * Contains the unit test related to the visa payment and discounts
 */
public class VisaPaymentTest {

    @Test
    void orderWithVisa10MoreTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(15);
        assertEquals(0.15, payOrder(products, "Visa"));
    }

    @Test
    void orderWithVisaExact10Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(10);
        assertEquals(0.15, payOrder(products, "Visa"));
    }

    @Test
    void orderWithVisaExact7Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(7);
        assertEquals(0.10, payOrder(products, "Visa"));
    }

    @Test
    void orderWithVisa7LessTest() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(5);
        assertEquals(0.05, payOrder(products, "Visa"));
    }
}
