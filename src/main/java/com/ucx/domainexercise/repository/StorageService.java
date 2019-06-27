package com.ucx.domainexercise.repository;

public interface StorageService<T, U> {
//    LineItem buy(Product product);
//    Invoice generateInvoice(List<LineItem> list, Costumer costumer);

    T find(U id);
    void update(T t);
    void remove(T t);
    T save(T t);
}
