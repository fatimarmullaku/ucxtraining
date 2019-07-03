package com.ucx.domainexercise.service;

import com.ucx.domainexercise.entity.Costumer;
import com.ucx.domainexercise.entity.Invoice;
import com.ucx.domainexercise.entity.LineItem;
import com.ucx.domainexercise.type.RecordStatus;
import com.ucx.domainexercise.repository.DuplicateFoundException;
import com.ucx.domainexercise.repository.RepositoryFactory;
import com.ucx.domainexercise.repository.StorageService;

import java.math.BigDecimal;
import java.util.List;

public class InvoiceServiceImpl implements InvoiceService {

    private StorageService<Invoice, Integer> storageService = RepositoryFactory.getStorageService();

    public static InvoiceService getInstance(){
        return new InvoiceServiceImpl();
    }

    @Override
    public Invoice createInvoice(List<LineItem> lineItemList, Costumer costumer) throws DuplicateFoundException {
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

    @Override
    public Invoice printInvoice(Integer id) {
        return storageService.find(id);
    }
}
