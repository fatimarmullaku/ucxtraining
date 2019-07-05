package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.shop.storage.DuplicateFoundException;
import com.ucx.shop.storage.NotFoundException;

/**
 * This interface exposes Costumer related functionalities.
 */
public interface CostumerService {
    Costumer create(Costumer costumer) throws DuplicateFoundException;
    Costumer update(Costumer costumer) throws NotFoundException;
    void remove(Costumer costumer) throws NotFoundException;
    Costumer find(Integer id) throws NotFoundException;
}
