package com.ucx.domainexercise.domain;

public class Costumer extends BaseModel<Integer> {
    private String name;

    public Costumer(Integer id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d, %s", this.getID(), this.getName());
    }
}
