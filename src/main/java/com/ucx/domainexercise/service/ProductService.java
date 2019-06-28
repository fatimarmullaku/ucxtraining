package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.repository.DuplicateFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public interface ProductService {
    Product addProduct(Product product) throws DuplicateFoundException;
    List<Product> sortBy(List<Product> productList, Comparator<Product> comparator, Order order);
}
