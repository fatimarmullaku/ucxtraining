package com.ucx.domainexercise.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product extends BaseModel<Integer> {
    private String name;
    private BigDecimal unitPrice;
    private Boolean inStock;

    @Builder
    public Product(Integer id, RecordStatus recordStatus, String name, BigDecimal unitPrice, Boolean inStock) {
        super(id, recordStatus);
        this.name = name;
        this.unitPrice = unitPrice;
        this.inStock = inStock;
    }

    @Override
    public String toString() {
        return String.format("%s, %f, in stock: %b", getName(), getUnitPrice(), getInStock());
    }
}
