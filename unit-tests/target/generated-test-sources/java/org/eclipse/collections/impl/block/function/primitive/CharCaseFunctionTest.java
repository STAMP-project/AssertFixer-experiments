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

import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file primitiveCaseFunctionTest.stg.
 */
public class CharCaseFunctionTest
{
    @Test
    public void noopCase()
    {
        CharCaseFunction<Character> function = new CharCaseFunction<Character>();
        Assert.assertNull(function.valueOf((char) 0));
    }

    @Test
    public void basicCase()
    {
        CharCaseFunction<Character> function = new CharCaseFunction<Character>();
        function.addCase(ignored -> true, Character::valueOf);
        Assert.assertEquals(Character.valueOf((char) 0), function.valueOf((char) 0));
    }

    @Test
    public void defaultValue()
    {
        CharCaseFunction<String> function = new CharCaseFunction<String>(i -> "Yow!")
                .addCase(i -> i == 0, i -> "Patience, grasshopper");

        Assert.assertEquals("Yow!", function.valueOf((char) 1));

        function.setDefault(i -> "Patience, young grasshopper");
        Assert.assertEquals("Patience, grasshopper", function.valueOf((char) 0));
        Assert.assertEquals("Patience, young grasshopper", function.valueOf((char) 1));

        Verify.assertContains("CharCaseFunction", function.toString());
    }

    @Test
    public void fizzBuzz()
    {
        String fizzBuzz = IntInterval.oneTo(20)
                .collectChar(i -> (char) i, CharLists.mutable.empty())
                .collect(new CharCaseFunction<String>(e -> "")
                        .addCase(e -> e % 15 == 0, e -> "FizzBuzz")
                        .addCase(e -> e % 3 == 0, e -> "Fizz")
                        .addCase(e -> e % 5 == 0, e -> "Buzz"))
                .makeString(":");
        Assert.assertEquals(
                "::Fizz::Buzz:Fizz:::Fizz:Buzz::Fizz:::FizzBuzz:::Fizz::Buzz",
                fizzBuzz);
    }
}
