package com.ucx.domainexercise.domain;

import java.util.List;

public class Invoice extends BaseModel<Integer> {

    private final Integer invoiceNumber;
    private final Costumer costumer;
    private final List<LineItem> list;

    public Invoice(Integer id, int invoiceNumber, Costumer costumer, List<LineItem> list) {
        super(id);
        this.invoiceNumber = invoiceNumber;
        this.costumer = costumer;
        this.list = list;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public List<LineItem> getList() {
        return list;
    }

    @Override
    public String toString() {
        return String.format("Invoice number: %d, Costumer: %s, LineItem list: %s", getInvoiceNumber(), getCostumer(), getList());
    }
}
