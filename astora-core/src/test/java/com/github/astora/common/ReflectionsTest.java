package com.github.astora.common;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReflectionsTest {

    @Test
    public void shouldGenerateMethodDescriptorWithName() throws Exception {
        assertEquals("listIterator(I)Ljava/util/ListIterator;",
                     Reflections.generateMethodDescriptorWithName(List.class.getMethod("listIterator", int.class)));
        assertEquals("add(ILjava/lang/Object;)V", Reflections.generateMethodDescriptorWithName(
                List.class.getMethod("add", int.class, Object.class)));
    }
}
