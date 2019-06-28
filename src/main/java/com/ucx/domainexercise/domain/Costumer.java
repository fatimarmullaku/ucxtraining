package com.ucx.domainexercise.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Costumer extends BaseModel<Integer>{
    private String name;


    @Override
    public String toString() {
        return String.format("%d, %s", 1, this.getName());
    }
}
