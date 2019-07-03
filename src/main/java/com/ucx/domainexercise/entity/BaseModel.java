package com.ucx.domainexercise.entity;

import com.ucx.domainexercise.type.RecordStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class BaseModel<T> {
    private T id;
    private RecordStatus recordStatus;
}
