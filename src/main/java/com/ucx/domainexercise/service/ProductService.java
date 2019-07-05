package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Product;
import com.ucx.domainexercise.type.SortOrder;
import com.ucx.shop.storage.DuplicateFoundException;

import java.util.Comparator;
import java.util.List;

/**
 * This Interface defines operations regarding Product.
 */
public interface ProductService {
    Product create(Product product) throws DuplicateFoundException;
    List<Product> sortBy(List<Product> productList, Comparator<Product> comparator, SortOrder sortOrder);
}
