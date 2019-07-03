package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.domainexercise.repository.*;

public class CostumerServiceImpl implements CostumerService {

    private StorageService<Costumer, Integer> storageService = RepositoryFactory.getStorageService();

    public static CostumerService getInstance(){
        return new CostumerServiceImpl();
    }

    @Override
    public Costumer create(Costumer costumer) throws DuplicateFoundException {
        return storageService.save(costumer);
    }

    @Override
    public Costumer update(Costumer costumer) throws NotFoundException {
        return storageService.update(costumer);
    }

    @Override
    public void remove(Costumer costumer) throws NotFoundException {
        storageService.remove(costumer);
    }
}
