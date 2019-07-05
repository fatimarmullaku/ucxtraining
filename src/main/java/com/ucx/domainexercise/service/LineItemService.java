package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.LineItem;
import com.ucx.domainexercise.entity.Product;
import com.ucx.shop.storage.DuplicateFoundException;

/**
 * This Interface defines operations regarding LineItem.
 */
public interface LineItemService {
    LineItem create(Product product, Integer quantity) throws DuplicateFoundException;
}
