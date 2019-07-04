package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.LineItem;
import com.ucx.domainexercise.entity.Product;
import com.ucx.shop.storage.DuplicateFoundException;

public interface LineItemService {
    LineItem create(Product product, Integer quantity) throws DuplicateFoundException;
}
