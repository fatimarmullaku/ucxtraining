package com.ucx.domainexercise;

import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.domain.RecordStatus;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.NotFoundException;
import com.ucx.domainexercise.service.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Application {

    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());
    private static CostumerService costumerService = ServiceFactory.getCostumerService();
    private static ProductService productService = ServiceFactory.getProductService();

    public static void main(String[] args) {

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
        } catch (Exception e){
            LOGGER.severe(e.getMessage());
        }

        if (createdCostumer != null) {
            createdCostumer.setName("Filani2");
            try {
                costumerService.update(createdCostumer);
                LOGGER.log(Level.INFO, createdCostumer.toString());
            } catch (NotFoundException e) {
                LOGGER.severe(e.getMessage());
            } catch (Exception e){
                LOGGER.severe(e.getMessage());
            }
        }

        try{
            costumerService.remove(createdCostumer);
        } catch (NotFoundException ex){
            LOGGER.severe(ex.getMessage());
        } catch (Exception e){
            LOGGER.severe(e.getMessage());
        }

        List<Product> productList = new ArrayList<>();
        productList.add(Product.builder()
                        .id(1)
                        .recordStatus(RecordStatus.ACTIVE)
                        .name("Produkti 1")
                        .unitPrice(8D)
                        .inStock(true)
                        .build());
        productList.add(Product.builder()
                .id(2)
                .recordStatus(RecordStatus.ACTIVE)
                .name("Produkti 2")
                .unitPrice(5D)
                .inStock(true)
                .build());
        productList.add(Product.builder()
                .id(3)
                .recordStatus(RecordStatus.ACTIVE)
                .name("Produkti 3")
                .unitPrice(7D)
                .inStock(true)
                .build());
        productList.add(Product.builder()
                .id(4)
                .recordStatus(RecordStatus.ACTIVE)
                .name("Produkti 4")
                .unitPrice(2D)
                .inStock(true)
                .build());

        List<Product> sortedList = productService.sortBy(productList, Comparator.comparing(e -> e.getUnitPrice()), SortOrder.ASC);
        LOGGER.log(Level.INFO, sortedList.toString());

        Costumer c = Costumer.builder()
                    .id(1)
                    .name("Filani")
                    .recordStatus(RecordStatus.ACTIVE)
                    .build();
    }
}
