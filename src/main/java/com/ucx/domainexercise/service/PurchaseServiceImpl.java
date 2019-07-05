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

/**
 * This class is an implementation of the PurchaseService Interface.
 */
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

    /**
     * This method returns a PurchaseServiceImpl with a given Costumer.
     * @param costumer
     * @return
     */
    public static final PurchaseServiceImpl of(Costumer costumer) {
        return new PurchaseServiceImpl(costumer);
    }

    /**
     * This method adds to cart a LineItem with a given Product and its quantity.
     * @param product
     * @param quantity
     * @throws DuplicateFoundException
     */
    @Override
    public void addToCart(Product product, Integer quantity) throws DuplicateFoundException {
        lineItemList.add(lineItemService.create(product, quantity));
    }

    /**
     * This method processes the buy and returns the generated Invoice.
     * @return
     * @throws DuplicateFoundException
     */
    public Invoice buy() throws DuplicateFoundException{
        Invoice generatedInvoice = invoiceService.create(lineItemList, costumer);
        Invoice printedInvoice = invoiceService.print(generatedInvoice.getId());
        LOGGER.log(Level.INFO, printedInvoice.toString());
        return printedInvoice;
    }
}
