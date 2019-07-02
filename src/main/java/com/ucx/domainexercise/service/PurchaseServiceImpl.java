package com.ucx.domainexercise.service;

import com.ucx.domainexercise.Application;
import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.domain.Invoice;
import com.ucx.domainexercise.domain.LineItem;
import com.ucx.domainexercise.domain.Product;
import com.ucx.domainexercise.repository.DuplicateFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PurchaseServiceImpl implements PurchaseService {

    private final static Logger LOGGER = Logger.getLogger(Application.class.getName());
    private static LineItemService lineItemService = ServiceFactory.getLineItemService();
    private static InvoiceService invoiceService = ServiceFactory.getInvoiceService();
    private List<LineItem> lineItemList;
    private Costumer costumer;

    public PurchaseServiceImpl(Costumer costumer) {
        this.costumer = costumer;
        lineItemList = new ArrayList<>();
    }

    @Override
    public void addToCart(Product product, Integer quantity) throws DuplicateFoundException {
        lineItemList.add(lineItemService.create(product, quantity));
    }

    public Invoice buy() throws DuplicateFoundException{
        Invoice generatedInvoice = invoiceService.generateInvoice(lineItemList, costumer);
        Invoice printedInvoice = invoiceService.printInvoice(generatedInvoice.getId());
        LOGGER.log(Level.INFO, printedInvoice.toString());
        return printedInvoice;
    }
}
