package com.ucx.domainexercise.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product extends BaseModel<String> {
    private String name;
    private Double unitPrice;
    private Boolean inStock;

    @Override
    public String toString() {
        return String.format("%s, %f, in stock: %b", getName(), getUnitPrice(), getInStock());
    }
}
