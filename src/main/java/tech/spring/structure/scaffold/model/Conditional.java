package tech.spring.structure.scaffold.model;

import tech.spring.structure.scaffold.ScaffoldProperty.ScaffoldConditional;

public class Conditional {

    private final ConditionalType type;

    private final String path;

    private final String value;

    public Conditional(ScaffoldConditional conditional) {
        this.type = conditional.type();
        this.path = conditional.path();
        this.value = conditional.value();
    }

    public ConditionalType getType() {
        return type;
    }

    public String getPath() {
        return path;
    }

    public String getValue() {
        return value;
    }

}
