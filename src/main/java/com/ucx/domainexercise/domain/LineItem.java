package com.ucx.domainexercise.domain;

public class LineItem extends BaseModel<Integer> {
    private final Invoice invoice;
    private final Product product;
    private final int quantity;

    public LineItem(Integer id, Invoice invoice, Product product, int quantity) {
        super(id);
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Invoice: %s, Product: %s, Quantity: %d", getInvoice(), getProduct(), getQuantity());
    }
}
