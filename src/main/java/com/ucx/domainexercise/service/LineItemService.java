package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.LineItem;
import com.ucx.domainexercise.domain.Product;

public interface LineItemService {
    LineItem create(Product product);
}
