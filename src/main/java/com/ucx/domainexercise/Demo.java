package com.ucx.domainexercise;

import com.ucx.domainexercise.entity.*;
import com.ucx.domainexercise.service.*;
import com.ucx.domainexercise.type.SortOrder;
import com.ucx.shop.storage.DuplicateFoundException;
import com.ucx.shop.storage.NotFoundException;
import com.ucx.shop.storage.RecordStatus;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Demo {

    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());
    private static CostumerService costumerService = CostumerServiceImpl.getInstance();
    private static ProductService productService = ProductServiceImpl.getInstance();
    private static PurchaseService purchaseService;

    public static void start(){

        /* ---------------------Create Costumer------------------------------ */
        Costumer costumer = Costumer.builder()
                .id(1)
                .recordStatus(RecordStatus.ACTIVE)
                .name("Filani")
                .build();
        Costumer createdCostumer = null;
        try {
            createdCostumer = costumerService.create(costumer);
            LOGGER.log(Level.INFO, createdCostumer.toString());
        } catch (DuplicateFoundException e) {
            LOGGER.severe(e.getMessage());
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }
        /* ---------------------End Create Costumer------------------------------ */

        /* ---------------------Update Costumer------------------------------ */
        if (createdCostumer != null) {
            createdCostumer.setName("Filani2");
            try {
                costumerService.update(createdCostumer);
                LOGGER.log(Level.INFO, createdCostumer.toString());
            } catch (NotFoundException e) {
                LOGGER.severe(e.getMessage());
            } catch (Exception e) {
                LOGGER.severe(e.getMessage());
            }
        }
        /* ---------------------End Update Costumer------------------------------ */

        /* ---------------------Create Product List------------------------------ */
        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder()
                .id(1)
                .recordStatus(RecordStatus.ACTIVE)
                .name("Produkti 1")
                .unitPrice(BigDecimal.valueOf(8))
                .inStock(true)
                .build());
        productList.add(Product.builder()
                .id(2)
                .recordStatus(RecordStatus.ACTIVE)
                .name("Produkti 2")
                .unitPrice(BigDecimal.valueOf(5))
                .inStock(true)
                .build());
        productList.add(Product.builder()
                .id(3)
                .recordStatus(RecordStatus.ACTIVE)
                .name("Produkti 3")
                .unitPrice(BigDecimal.valueOf(7))
                .inStock(true)
                .build());
        productList.add(Product.builder()
                .id(4)
                .recordStatus(RecordStatus.ACTIVE)
                .name("Produkti 4")
                .unitPrice(BigDecimal.valueOf(2))
                .inStock(true)
                .build());
        /* ---------------------End Product List------------------------------ */

        /* ---------------------Buy Product------------------------------ */
        try {
            purchaseService = PurchaseServiceImpl.of(costumer);
            purchaseService.addToCart(productList.get(0), 2);
            purchaseService.addToCart(productList.get(1), 3);
            purchaseService.buy();
        } catch (DuplicateFoundException e) {
            LOGGER.severe(e.getMessage());
        }
        /* ---------------------End Buy Product------------------------------ */

        /* ---------------------Sort Products with a given field------------------------------ */
        List<Product> sortedList = productService.sortBy(productList, Comparator.comparing(e -> e.getUnitPrice()), SortOrder.ASC);
        LOGGER.log(Level.INFO, sortedList.toString());
        /* ---------------------End Sort Products with a given field------------------------------ */

        Costumer c = Costumer.builder()
                .id(1)
                .name("Filani")
                .recordStatus(RecordStatus.ACTIVE)
                .build();

        /* ---------------------Remove Costumer------------------------------ */
        try {
            costumerService.remove(c);
        } catch (NotFoundException ex) {
            LOGGER.severe(ex.getMessage());
        } catch (Exception e) {
            LOGGER.severe(e.getMessage());
        }
        /* ---------------------End Remove Costumer------------------------------ */
    }
}
