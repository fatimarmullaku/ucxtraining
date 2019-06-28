package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.LineItem;
import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.repository.DuplicateFoundException;

public interface LineItemService {
    LineItem create(Product product, Integer quantity) throws DuplicateFoundException;
}
