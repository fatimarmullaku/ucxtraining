package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.RepositoryFactory;
import com.ucx.domainexercise.repository.StorageService;
import com.ucx.domainexercise.repository.StorageServiceImpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    StorageService<Product, String> storageService = RepositoryFactory.getStorageService();

    @Override
    public Product addProduct(Product product) throws DuplicateFoundException {
        return storageService.save(product);
    }

    @Override
    public List<Product> sortBy(List<Product> productList, Comparator<Product> comparator, Order order) {
        List<Product> sortedList = new ArrayList<>();

        switch (order) {
            case ASC:
                sortedList = productList.stream()
                        .sorted(comparator)
                        .collect(Collectors.toList());
                break;
            case DESC:
                sortedList = productList.stream()
                        .sorted(comparator.reversed())
                        .collect(Collectors.toList());
                break;
        }
        return sortedList;
    }
}
