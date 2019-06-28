package com.ucx.domainexercise.service;

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
}
