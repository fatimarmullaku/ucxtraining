package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.repository.DuplicateFoundException;

public interface CostumerService {
    Costumer create(Costumer costumer) throws DuplicateFoundException;

}
