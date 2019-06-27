package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.LineItem;
import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.repository.StorageService;
import com.ucx.domainexercise.repository.StorageServiceImpl;

public class LineItemServiceImpl implements LineItemService{

    private StorageService<LineItem, Integer> storageService = new StorageServiceImpl<>();

    @Override
    public LineItem create(Product product) {
        if(product == null){
            throw new RuntimeException("Cannot create LineItem, Product is missing");
        }
        return storageService.save(new LineItem(1, null, product, 5));
    }

}
