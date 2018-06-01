package io.github.caiwan.spreadsheet;

import lombok.Getter;
import lombok.Setter;

public class Cell<T> {

    @Getter
    @Setter
    T value;

    public Cell(T value) {
        super();
        this.value = value;
    }

    public Cell() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String stringValue() {
        return value.toString();
    }

    public Integer integerValue() {
        if (null == value) {
            return null;
        }
        return Integer.parseInt(value.toString());
    }

    public Long longValue() {
        if (null == value) {
            return null;
        }
        return Long.parseLong(value.toString());
    }

}
