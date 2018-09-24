package org.vea.tutorial.controllers.values;


import org.immutables.value.Value;

@Value.Immutable
@ValueStyle
public interface Person {
    Father getFather();
    String getName();
    static ImmutablePerson.Builder builder(){
        return ImmutablePerson.builder();
    }
}
