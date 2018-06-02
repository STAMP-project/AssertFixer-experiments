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

import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseFunctionTest.stg.
 */
public class LongCaseFunctionTest
{
    @Test
    public void noopCase()
    {
        LongCaseFunction<Long> function = new LongCaseFunction<Long>();
        Assert.assertNull(function.valueOf(0L));
    }

    @Test
    public void basicCase()
    {
        LongCaseFunction<Long> function = new LongCaseFunction<Long>();
        function.addCase(ignored -> true, Long::valueOf);
        Assert.assertEquals(Long.valueOf(0L), function.valueOf(0L));
    }

    @Test
    public void defaultValue()
    {
        LongCaseFunction<String> function = new LongCaseFunction<String>(i -> "Yow!")
                .addCase(i -> i == 0, i -> "Patience, grasshopper");

        Assert.assertEquals("Yow!", function.valueOf(1L));

        function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertEquals("Patience, grasshopper", function.valueOf(0L));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf(1L));

        Verify.assertContains("LongCaseFunction", function.toString());
    }

    @Test
    public void fizzBuzz()
    {
        String fizzBuzz = IntInterval.oneTo(20)
                .collectLong(i -> (long) i, LongLists.mutable.empty())
                .collect(new LongCaseFunction<String>(e -> "")
                        .addCase(e -> e % 15 == 0, e -> "FizzBuzz")
                        .addCase(e -> e % 3 == 0, e -> "Fizz")
                        .addCase(e -> e % 5 == 0, e -> "Buzz"))
                .makeString(":");
        Assert.assertEquals(
                "::Fizz::Buzz:Fizz:::Fizz:Buzz::Fizz:::FizzBuzz:::Fizz::Buzz",
                fizzBuzz);
    }
}
