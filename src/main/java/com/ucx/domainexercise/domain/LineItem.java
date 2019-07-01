package com.ucx.domainexercise.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItem extends BaseModel<Integer> {
    private Invoice invoice;
    private Product product;
    private Integer quantity;

    @Builder
    public LineItem(Integer id, RecordStatus recordStatus, Invoice invoice, Product product, Integer quantity) {
        super(id, recordStatus);
        this.invoice = invoice;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("Invoice: %s, Product: %s, Quantity: %d", getInvoice(), getProduct(), getQuantity());
    }
}
