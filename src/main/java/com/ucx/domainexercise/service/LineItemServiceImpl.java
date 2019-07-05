package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.LineItem;
import com.ucx.domainexercise.entity.Product;
import com.ucx.shop.storage.DuplicateFoundException;
import com.ucx.shop.storage.RecordStatus;
import com.ucx.shop.storage.RepositoryFactory;
import com.ucx.shop.storage.StorageService;

/**
 * This class is an implementation of the LineItemService Interface.
 */
public class LineItemServiceImpl implements LineItemService{

    private StorageService<LineItem, Integer> storageService = RepositoryFactory.getStorageService();

    /**
     * This method returns an instance of the LineItemService.
     * @return
     */
    public static LineItemService getInstance(){
        return new LineItemServiceImpl();
    }

    /**
     * This method creates a LineItem with a given Product and quantity of Products.
     * @param product
     * @param quantity
     * @return LineItem
     * @throws DuplicateFoundException
     */
    @Override
    public LineItem create(Product product, Integer quantity) throws DuplicateFoundException {
        if(product == null){
            throw new IllegalArgumentException("Cannot create LineItem, Product is missing");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be less than 1");
        }

        return storageService.save(LineItem.builder()
                                    .id((int)(Math.random() * 100 + 1))
                                    .recordStatus(RecordStatus.ACTIVE)
                                    .product(product)
                                    .quantity(quantity)
                                    .invoice(null)
                                    .build());
    }

}
