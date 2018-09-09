package com.github.astora.common;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RequirementsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldThrowNullPointerExceptionWhenNullArgumentProvidedWithNoErrorMessage() {
        expectedException.expect(NullPointerException.class);

        Requirements.requireNonNull(null);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNullArgumentProvidedWithErrorMessage() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("null exception");

        Requirements.requireNonNull(null, "null exception");
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNullArgumentProvidedWithErrorMessageAndOneArgument() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("null exception 1");

        Requirements.requireNonNull(null, "null exception {}", 1);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNullArgumentProvidedWithErrorMessageAndTwoArguments() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("null exception 1 2");

        Requirements.requireNonNull(null, "null exception {} {}", 1, 2);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNullArgumentProvidedWithErrorMessageAndThreeArguments() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("null exception 1 2 3");

        Requirements.requireNonNull(null, "null exception {} {} {}", 1, 2, 3);
    }

    @Test
    public void shouldThrowNullPointerExceptionWhenNullArgumentProvidedWithErrorMessageAndFourArguments() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("null exception 1 2 3 4");

        Requirements.requireNonNull(null, "null exception {} {} {} {}", 1, 2, 3, 4);
    }
}
