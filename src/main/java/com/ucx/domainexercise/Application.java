package com.ucx.domainexercise;

import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.NotFoundException;
import com.ucx.domainexercise.repository.StorageService;
import com.ucx.domainexercise.repository.StorageServiceImpl;
import com.ucx.domainexercise.service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Application {

    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());
    private static CostumerService costumerService = ServiceFactory.getCostumerService();
    private static ProductService productService = ServiceFactory.getProductService();

    public static void main(String[] args) {

        Costumer costumer = new Costumer("Filani");
        costumer.setID(1);
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
        productList.add(new Product("Produkti 1", 8D, true));
        productList.add(new Product("Produkti 2", 5D, true));
        productList.add(new Product("Produkti 3", 7D, true));
        productList.add(new Product("Produkti 4", 2D, true));

        List<Product> sortedList = productService.sortBy(productList, Comparator.comparing(e -> e.getUnitPrice()), Order.ASC);
        LOGGER.log(Level.INFO, sortedList.toString());
    }
}
