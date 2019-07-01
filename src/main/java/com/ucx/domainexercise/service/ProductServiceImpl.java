package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.RepositoryFactory;
import com.ucx.domainexercise.repository.StorageService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    StorageService<Product, String> storageService = RepositoryFactory.getStorageService();

    @Override
    public Product addProduct(Product product) throws DuplicateFoundException {
        return storageService.save(product);
    }

    @Override
    public List<Product> sortBy(List<Product> productList, Comparator<Product> comparator, SortOrder sortOrder) {
        Comparator<Product> productComparator = (sortOrder == SortOrder.ASC) ? comparator : comparator.reversed();
        return productList.stream()
                .sorted(productComparator)
                .collect(Collectors.toList());
    }
}
