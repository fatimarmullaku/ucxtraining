package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.domain.Invoice;
import com.ucx.domainexercise.domain.LineItem;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.RepositoryFactory;
import com.ucx.domainexercise.repository.StorageService;
import com.ucx.domainexercise.repository.StorageServiceImpl;

import java.util.List;

public class InvoiceServiceImpl implements InvoiceService {

    private StorageService<Invoice, Integer> storageService = RepositoryFactory.getStorageService();

    @Override
    public Invoice generateInvoice(List<LineItem> lineItemList, Costumer costumer) throws DuplicateFoundException {
        if(lineItemList == null || lineItemList.isEmpty()){
            throw new IllegalArgumentException("Cannot print Invoice, list is missing");
        }
        if(costumer == null){
            throw new IllegalArgumentException("Cannot print Invoice, Costumer is missing");
        }
        Invoice invoice = new Invoice(1, costumer, lineItemList);
        invoice.setID(1);
        return storageService.save(invoice);
    }

    @Override
    public Invoice printInvoice(Integer id) {
        return storageService.find(id);
    }
}
