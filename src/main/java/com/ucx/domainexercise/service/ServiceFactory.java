package com.ucx.domainexercise.service;

import com.ucx.domainexercise.domain.Costumer;

public class ServiceFactory {
    public static final CostumerService getCostumerService(){
        return new CostumerServiceImpl();
    }

    public static final InvoiceService getInvoiceService(){
        return new InvoiceServiceImpl();
    }

    public static final LineItemService getLineItemService(){
        return new LineItemServiceImpl();
    }

    public static final ProductService getProductService(){
        return new ProductServiceImpl();
    }

    public static final PurchaseService getPurchaseService(Costumer costumer) {
        return new PurchaseServiceImpl(costumer);
    }
}
