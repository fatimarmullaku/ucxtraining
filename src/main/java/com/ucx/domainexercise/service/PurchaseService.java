package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Invoice;
import com.ucx.domainexercise.entity.Product;
import com.ucx.shop.storage.DuplicateFoundException;

public interface PurchaseService {
    void addToCart(Product product, Integer quantity) throws DuplicateFoundException;
    Invoice buy() throws DuplicateFoundException;
}
