package com.ucx.domainexercise.domain;

public class Product extends BaseModel<String> {
    private final String name;
    private final double unitPrice;
    private final boolean inStock;

    public Product(String id, String name, double unitPrice, boolean inStock) {
        super(id);
        this.name = name;
        this.unitPrice = unitPrice;
        this.inStock = inStock;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public boolean isInStock() {
        return inStock;
    }
}
