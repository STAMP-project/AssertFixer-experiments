package com.github.astora.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessagesTest {

    @Test
    public void shouldSubstituteArguments() {
        assertEquals("This is a text with arguments b and c",
                     Formats.format("This is a {} with arguments {} and {}", "text", "b", "c"));
    }

    @Test
    public void shouldSubstituteLessArguments() {
        assertEquals("This is a text with arguments b and {}",
                     Formats.format("This is a {} with arguments {} and {}", "text", "b"));
    }

    @Test
    public void shouldSubstituteMoreArguments() {
        assertEquals("This is a text with arguments b and c",
                     Formats.format("This is a {} with arguments {} and {}", "text", "b", "c", "ddd"));
    }

    @Test
    public void shouldSubstituteDoubleEscapedArguments() {
        assertEquals("This is a \\text", Formats.format("This is a \\\\{}", "text"));
    }

    @Test
    public void shouldSubstituteWithNoArguments() {
        assertEquals("This is a plain text", Formats.format("This is a plain text"));
    }

    @Test
    public void shouldNotSubstituteEscapedArguments() {
        assertEquals("This is a {} with arguments {\\} and {}",
                     Formats.format("This is a \\{} with arguments {\\} and \\{}", "text", "b", "c"));
    }
}
