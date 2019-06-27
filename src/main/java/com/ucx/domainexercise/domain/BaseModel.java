package com.ucx.domainexercise.domain;

public abstract class BaseModel<T> {

    private T ID;

    public T getID() {
        return ID;
    }

    public void setID(T ID) {
        this.ID = ID;
    }

    public BaseModel(T ID) {
        this.ID = ID;
    }
}
