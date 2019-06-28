package com.ucx.domainexercise.repository;

public class RepositoryFactory {

    public static final <T, U>StorageService getStorageService(){
        return new StorageServiceImpl<>();
    }
}
