package com.ucx.domainexercise.repository;

public interface StorageService<T, U> {
//    LineItem buy(Product product);
//    Invoice createInvoice(List<LineItem> list, Costumer costumer);

    T find(U id);
    T update(T t) throws NotFoundException;
    void remove(T t) throws NotFoundException;
    T save(T t) throws DuplicateFoundException;
}
