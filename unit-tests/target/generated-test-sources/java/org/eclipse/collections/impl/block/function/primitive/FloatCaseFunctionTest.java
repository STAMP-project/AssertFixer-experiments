/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.function.primitive;

import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseFunctionTest.stg.
 */
public class FloatCaseFunctionTest
{
    @Test
    public void noopCase()
    {
        FloatCaseFunction<Float> function = new FloatCaseFunction<Float>();
        Assert.assertNull(function.valueOf(0.0f));
    }

    @Test
    public void basicCase()
    {
        FloatCaseFunction<Float> function = new FloatCaseFunction<Float>();
        function.addCase(ignored -> true, Float::valueOf);
        Assert.assertEquals(Float.valueOf(0.0f), function.valueOf(0.0f));
    }

    @Test
    public void defaultValue()
    {
        FloatCaseFunction<String> function = new FloatCaseFunction<String>(i -> "Yow!")
                .addCase(i -> Float.compare(i, 0) == 0, i -> "Patience, grasshopper");

        Assert.assertEquals("Yow!", function.valueOf(1.0f));

        function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertEquals("Patience, grasshopper", function.valueOf(0.0f));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf(1.0f));

        Verify.assertContains("FloatCaseFunction", function.toString());
    }

    @Test
    public void fizzBuzz()
    {
        String fizzBuzz = IntInterval.oneTo(20)
                .collectFloat(i -> (float) i, FloatLists.mutable.empty())
                .collect(new FloatCaseFunction<String>(e -> "")
                        .addCase(e -> Float.compare(e % 15, 0) == 0, e -> "FizzBuzz")
                        .addCase(e -> Float.compare(e % 3, 0) == 0, e -> "Fizz")
                        .addCase(e -> Float.compare(e % 5, 0) == 0, e -> "Buzz"))
                .makeString(":");
        Assert.assertEquals(
                "::Fizz::Buzz:Fizz:::Fizz:Buzz::Fizz:::FizzBuzz:::Fizz::Buzz",
                fizzBuzz);
    }
}
