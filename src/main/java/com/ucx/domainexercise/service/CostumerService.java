package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.NotFoundException;

public interface CostumerService {
    Costumer create(Costumer costumer) throws DuplicateFoundException;
    Costumer update(Costumer costumer) throws NotFoundException;
    void remove(Costumer costumer) throws NotFoundException;
}
