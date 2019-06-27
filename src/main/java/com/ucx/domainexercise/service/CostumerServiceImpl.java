package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.StorageService;
import com.ucx.domainexercise.repository.StorageServiceImpl;

public class CostumerServiceImpl implements CostumerService {

    private StorageService<Costumer, Integer> storageService = new StorageServiceImpl<>();

    @Override
    public Costumer create(Costumer costumer) throws DuplicateFoundException {
        if (costumer == null) {
            throw new IllegalArgumentException("Invalid costumer");
        }
        return storageService.save(costumer);
    }
}
