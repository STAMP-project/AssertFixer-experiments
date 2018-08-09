package org.powerflows.dmn.domain.model;

@FunctionalInterface
public interface ElementBuilder<T> {
    T add();
}
