package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.LineItem;
import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.domain.RecordStatus;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.RepositoryFactory;
import com.ucx.domainexercise.repository.StorageService;
import com.ucx.domainexercise.repository.StorageServiceImpl;

public class LineItemServiceImpl implements LineItemService{

    private StorageService<LineItem, Integer> storageService = RepositoryFactory.getStorageService();

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
