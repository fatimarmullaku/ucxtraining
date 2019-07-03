package com.ucx.domainexercise.entity;

import com.ucx.domainexercise.type.RecordStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Invoice extends BaseModel<Integer> {
    private Integer invoiceNumber;
    private Costumer costumer;
    private List<LineItem> list;
    private BigDecimal total;

    @Builder
    public Invoice(Integer id, RecordStatus recordStatus, Integer invoiceNumber, Costumer costumer, List<LineItem> list) {
        super(id, recordStatus);
        this.invoiceNumber = invoiceNumber;
        this.costumer = costumer;
        this.list = list;
    }

    @Override
    public String toString() {
        return String.format("Invoice number: %d, Costumer: %s, LineItem list: %s, Total: %f", getInvoiceNumber(), getCostumer(), getList(), getTotal());
    }
}
