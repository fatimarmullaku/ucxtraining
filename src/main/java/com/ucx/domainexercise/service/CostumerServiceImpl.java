package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.shop.storage.DuplicateFoundException;
import com.ucx.shop.storage.NotFoundException;
import com.ucx.shop.storage.RepositoryFactory;
import com.ucx.shop.storage.StorageService;

/**
 * This class is an implementation of the CostumerService Interface.
 */
public class CostumerServiceImpl implements CostumerService {

    private StorageService<Costumer, Integer> storageService = RepositoryFactory.getStorageService();

    /**
     * This method returns an instance of CostumerServiceImpl.
     * @return
     */
    public static CostumerService getInstance(){
        return new CostumerServiceImpl();
    }

    /**
     * This method creates a given Costumer.
     * @param costumer
     * @return
     * @throws DuplicateFoundException
     */
    @Override
    public Costumer create(Costumer costumer) throws DuplicateFoundException {
        return storageService.save(costumer);
    }

    /**
     * This method updates a given Costumer.
     * @param costumer
     * @return
     * @throws NotFoundException
     */
    @Override
    public Costumer update(Costumer costumer) throws NotFoundException {
        return storageService.update(costumer);
    }

    /**
     * This method removes a given Costumer.
     * @param costumer
     * @throws NotFoundException
     */
    @Override
    public void remove(Costumer costumer) throws NotFoundException {
        storageService.remove(costumer);
    }

    /**
     * This method retrieves a Costumer with a given id.
     * @param id
     * @return
     * @throws NotFoundException
     */
    @Override
    public Costumer find(Integer id) throws NotFoundException {
        return storageService.find(id);
    }
}
