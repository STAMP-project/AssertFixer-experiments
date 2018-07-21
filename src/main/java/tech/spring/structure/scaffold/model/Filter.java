package tech.spring.structure.scaffold.model;

import tech.spring.structure.scaffold.ScaffoldProperty.JoinSelectFilter;

public class Filter {

    private final String property;

    private final String value;

    public Filter(JoinSelectFilter joinSelectFilter) {
        this.property = joinSelectFilter.property();
        this.value = joinSelectFilter.value();
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }

}