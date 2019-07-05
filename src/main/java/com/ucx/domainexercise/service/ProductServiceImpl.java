package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Product;
import com.ucx.domainexercise.type.SortOrder;
import com.ucx.shop.storage.DuplicateFoundException;
import com.ucx.shop.storage.RepositoryFactory;
import com.ucx.shop.storage.StorageService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class is an implementation of the ProductService Interface.
 */
public class ProductServiceImpl implements ProductService {

    StorageService<Product, String> storageService = RepositoryFactory.getStorageService();

    /**
     * This method returns an instance of ProductService.
     * @return ProductService
     */
    public static ProductService getInstance(){
        return new ProductServiceImpl();
    }


    /**
     * This method saves a given Product.
     * @param product
     * @return Product
     * @throws DuplicateFoundException
     */
    @Override
    public Product create(Product product) throws DuplicateFoundException {
        return storageService.save(product);
    }

    /**
     * This method sorts a given Product list with a given comparator and sort order.
     * @param productList
     * @param comparator
     * @param sortOrder
     * @return
     */
    @Override
    public List<Product> sortBy(List<Product> productList, Comparator<Product> comparator, SortOrder sortOrder) {
        if (productList == null ||
                productList.isEmpty() ||
                    comparator == null ||
                        sortOrder == null) {
            throw new IllegalArgumentException("Invalid argument found: " + String.format("%s %s %s", productList, comparator, sortOrder));
        }
        Comparator<Product> productComparator = (sortOrder == SortOrder.ASC) ? comparator : comparator.reversed();
        return productList.stream()
                .sorted(productComparator)
                .collect(Collectors.toList());
    }


}
