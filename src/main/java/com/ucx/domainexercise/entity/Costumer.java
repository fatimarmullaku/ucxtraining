package com.ucx.domainexercise.entity;

import com.ucx.domainexercise.type.RecordStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Costumer extends BaseModel<Integer>{
    private String name;

    @Builder
    public Costumer(Integer id, String name, RecordStatus recordStatus) {
        super(id, recordStatus);
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%d, %s", 1, this.getName());
    }
}
