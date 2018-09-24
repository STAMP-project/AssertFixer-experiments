package org.vea.tutorial.controllers.values;

import org.immutables.value.Value;

@Value.Immutable
@ValueStyle
public interface User {
    String getName();

    static ImmutableUser.Builder builder() {
        return ImmutableUser.builder();
    }
}
