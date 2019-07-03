package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.domainexercise.entity.Invoice;
import com.ucx.domainexercise.entity.Product;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.type.RecordStatus;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class PurchaseServiceImplTestSuite {

    private PurchaseService purchaseService;

    @Test
    public void testBuy() {
        purchaseService = PurchaseServiceImpl.of(new Costumer(1, "Filani", RecordStatus.ACTIVE));
        Product product = new Product(1, RecordStatus.ACTIVE, "Produkti 1", BigDecimal.valueOf(2.5), true);
        try {
            purchaseService.addToCart(product, 2);
            Invoice invoice = purchaseService.buy();
            assertNotNull(invoice);
            assertEquals("Filani", invoice.getCostumer().getName());
            assertEquals(BigDecimal.valueOf(5.0), invoice.getTotal());
        } catch (DuplicateFoundException e) {
            e.printStackTrace();
        }
    }
}
