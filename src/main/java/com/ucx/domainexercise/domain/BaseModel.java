package com.ucx.domainexercise.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseModel<T> {
    private T ID;
    private RecordStatus recordStatus;
}
