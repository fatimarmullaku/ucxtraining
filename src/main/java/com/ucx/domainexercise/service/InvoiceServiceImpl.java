package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.domainexercise.entity.Invoice;
import com.ucx.domainexercise.entity.LineItem;
import com.ucx.shop.storage.DuplicateFoundException;
import com.ucx.shop.storage.RecordStatus;
import com.ucx.shop.storage.RepositoryFactory;
import com.ucx.shop.storage.StorageService;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class is an implementation of the InvoiceService Interface.
 */
public class InvoiceServiceImpl implements InvoiceService {

    private StorageService<Invoice, Integer> storageService = RepositoryFactory.getStorageService();

    /** This method returns an instance of InvoiceService.
     * @return
     */
    public static InvoiceService getInstance(){
        return new InvoiceServiceImpl();
    }

    /**
     * This method creates an Invoice with a given LineItem list and a Costumer.
     * @param lineItemList
     * @param costumer
     * @return
     * @throws DuplicateFoundException
     */
    @Override
    public Invoice create(List<LineItem> lineItemList, Costumer costumer) throws DuplicateFoundException {
        if (lineItemList == null || lineItemList.isEmpty()) {
            throw new IllegalArgumentException("Cannot print Invoice, list is missing");
        }
        if (costumer == null) {
            throw new IllegalArgumentException("Cannot print Invoice, Costumer is missing");
        }

        BigDecimal total = lineItemList
                .stream()
                .map(e -> e.getProduct().getUnitPrice().multiply(BigDecimal.valueOf(e.getQuantity())))
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        Invoice invoice = Invoice.builder()
                .id(1)
                .recordStatus(RecordStatus.ACTIVE)
                .invoiceNumber((int) (Math.random() * 100 + 1))
                .costumer(costumer)
                .list(lineItemList)
                .build();

        invoice.setTotal(total);

        return storageService.save(invoice);
    }

    /**
     * This method prints an Invoice with a given Invoice id.
     * @param id
     * @return
     */
    @Override
    public Invoice print(Integer id) {
        return storageService.find(id);
    }
}
