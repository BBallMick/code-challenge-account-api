package com.mhb.accountapi.domain.shared.model.id;

import java.util.Objects;

public abstract class AbstactId<T> {

    private T value;

    public AbstactId(T value) {
        this.value = value;
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null!");
        }
    }

    public T getValue() {
        return value;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstactId<?> abstactId = (AbstactId<?>) o;
        return Objects.equals(value, abstactId.value);
    }

}
