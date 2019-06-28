package com.ucx.domainexercise.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Invoice extends BaseModel<Integer> {
    private Integer invoiceNumber;
    private Costumer costumer;
    private List<LineItem> list;

    @Override
    public String toString() {
        return String.format("Invoice number: %d, Costumer: %s, LineItem list: %s", getInvoiceNumber(), getCostumer(), getList());
    }
}
