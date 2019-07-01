package com.ucx.domainexercise.domain;

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
