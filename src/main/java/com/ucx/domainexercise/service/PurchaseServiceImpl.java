package com.ucx.domainexercise.service;

import com.ucx.domainexercise.Application;
import com.ucx.domainexercise.entity.Costumer;
import com.ucx.domainexercise.entity.Invoice;
import com.ucx.domainexercise.entity.LineItem;
import com.ucx.domainexercise.entity.Product;
import com.ucx.shop.storage.DuplicateFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseServiceImpl implements PurchaseService {

    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());
    private static LineItemService lineItemService = LineItemServiceImpl.getInstance();
    private static InvoiceService invoiceService = InvoiceServiceImpl.getInstance();
    private List<LineItem> lineItemList;
    private Costumer costumer;

    private PurchaseServiceImpl(Costumer costumer) {
        this.costumer = costumer;
        lineItemList = new ArrayList<>();
    }

    public static final PurchaseServiceImpl of(Costumer costumer) {
        return new PurchaseServiceImpl(costumer);
    }

    @Override
    public void addToCart(Product product, Integer quantity) throws DuplicateFoundException {
        lineItemList.add(lineItemService.create(product, quantity));
    }

    public Invoice buy() throws DuplicateFoundException{
        Invoice generatedInvoice = invoiceService.createInvoice(lineItemList, costumer);
        Invoice printedInvoice = invoiceService.printInvoice(generatedInvoice.getId());
        LOGGER.log(Level.INFO, printedInvoice.toString());
        return printedInvoice;
    }
}
