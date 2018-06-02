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

import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseFunctionTest.stg.
 */
public class DoubleCaseFunctionTest
{
    @Test
    public void noopCase()
    {
        DoubleCaseFunction<Double> function = new DoubleCaseFunction<Double>();
        Assert.assertNull(function.valueOf(0.0));
    }

    @Test
    public void basicCase()
    {
        DoubleCaseFunction<Double> function = new DoubleCaseFunction<Double>();
        function.addCase(ignored -> true, Double::valueOf);
        Assert.assertEquals(Double.valueOf(0.0), function.valueOf(0.0));
    }

    @Test
    public void defaultValue()
    {
        DoubleCaseFunction<String> function = new DoubleCaseFunction<String>(i -> "Yow!")
                .addCase(i -> Double.compare(i, 0) == 0, i -> "Patience, grasshopper");

        Assert.assertEquals("Yow!", function.valueOf(1.0));

        function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertEquals("Patience, grasshopper", function.valueOf(0.0));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf(1.0));

        Verify.assertContains("DoubleCaseFunction", function.toString());
    }

    @Test
    public void fizzBuzz()
    {
        String fizzBuzz = IntInterval.oneTo(20)
                .collectDouble(i -> (double) i, DoubleLists.mutable.empty())
                .collect(new DoubleCaseFunction<String>(e -> "")
                        .addCase(e -> Double.compare(e % 15, 0) == 0, e -> "FizzBuzz")
                        .addCase(e -> Double.compare(e % 3, 0) == 0, e -> "Fizz")
                        .addCase(e -> Double.compare(e % 5, 0) == 0, e -> "Buzz"))
                .makeString(":");
        Assert.assertEquals(
                "::Fizz::Buzz:Fizz:::Fizz:Buzz::Fizz:::FizzBuzz:::Fizz::Buzz",
                fizzBuzz);
    }
}
