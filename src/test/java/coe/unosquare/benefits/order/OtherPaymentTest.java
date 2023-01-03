package coe.unosquare.benefits.order;

import coe.unosquare.benefits.product.Product;
import coe.unosquare.benefits.util.ProductGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static coe.unosquare.benefits.util.PayOrderSimulator.payOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Contains the unit test related to the others types of payments like Amex
 */
public class OtherPaymentTest {
    @Test
    void orderWithAmexCard100Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(100.00);
        assertEquals(0.0, payOrder(products, "Amex"));
    }

    @Test
    void orderWithMercadoPago90Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(90.00);
        assertEquals(0.0, payOrder(products, "MercadoPago"));
    }

    @Test
    void orderWithOxxoPay1000Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(1000.00);
        assertEquals(0.0, payOrder(products, "OxxoPay"));
    }

    @Test
    void orderWithPrepaidCard10Test() {
        Map<Product, Integer> products = ProductGenerator.generateProducts(10.00);
        assertEquals(0.0, payOrder(products, "PrepaidCard"));
    }
}
