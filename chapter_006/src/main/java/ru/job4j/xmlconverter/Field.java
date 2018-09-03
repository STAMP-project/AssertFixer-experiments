package ru.job4j.xmlconverter;

import javax.xml.bind.annotation.XmlElement;

public class Field {
    Integer field;

    public Field(int field) {
        this.field = field;
    }
    @XmlElement
    public Integer getField() {
        return field;
    }

    public void setField(Integer value) {
        this.field = value;
    }
}
