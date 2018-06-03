package org.srcdeps.test.gradle.impl;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author <a href="https://github.com/ppalaga">Peter Palaga</a>
 */
public class HelloGreeterTest {
    @Test
    public void greet() {
        Assert.assertEquals("Hello world!", new HelloGreeter().greet("world"));
    }
}
