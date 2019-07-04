package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.shop.storage.DuplicateFoundException;
import com.ucx.shop.storage.NotFoundException;

public interface CostumerService {
    Costumer create(Costumer costumer) throws DuplicateFoundException;
    Costumer update(Costumer costumer) throws NotFoundException;
    void remove(Costumer costumer) throws NotFoundException;
}
