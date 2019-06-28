package com.ucx.domainexercise.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LineItem extends BaseModel<Integer> {
    private Invoice invoice;
    private Product product;
    private Integer quantity;

    @Override
    public String toString() {
        return String.format("Invoice: %s, Product: %s, Quantity: %d", getInvoice(), getProduct(), getQuantity());
    }
}
