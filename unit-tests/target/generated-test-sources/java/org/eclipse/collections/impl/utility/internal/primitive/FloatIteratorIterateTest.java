/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.utility.internal.primitive;

import java.util.NoSuchElementException;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class FloatIteratorIterateTest
{
    private final FloatIterable iterable = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);

    @Test
    public void select_target()
    {
        Verify.assertSize(2, FloatIteratorIterate.select(this.iterable.floatIterator(), FloatPredicates.greaterThan(1.0f), new FloatArrayList(2)));
        Verify.assertSize(2, FloatIteratorIterate.select(this.iterable.floatIterator(), FloatPredicates.greaterThan(1.0f), new FloatArrayList(3)));
        Verify.assertEmpty(FloatIteratorIterate.select(this.iterable.floatIterator(), FloatPredicates.lessThan(0.0f), new FloatArrayList(3)));
    }

    @Test
    public void reject_target()
    {
        Verify.assertSize(1, FloatIteratorIterate.reject(this.iterable.floatIterator(), FloatPredicates.greaterThan(1.0f), new FloatArrayList(1)));
        Verify.assertEmpty(FloatIteratorIterate.reject(this.iterable.floatIterator(), FloatPredicates.greaterThan(0.0f), new FloatArrayList(0)));
    }

    @Test
    public void collect_target()
    {
        Verify.assertIterableSize(3, FloatIteratorIterate.collect(this.iterable.floatIterator(), String::valueOf, FastList.<String>newList()));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6.0, FloatIteratorIterate.sum(this.iterable.floatIterator()), 0.0);
        Assert.assertEquals(0.0, FloatIteratorIterate.sum(new FloatArrayList().floatIterator()), 0.0);
    }

    @Test
    public void sumConsistentRounding()
    {
        FloatIterable iterable =
            FloatArrayList.newListWith(
                Interval.oneTo(100_000)
                        .toList()
                        .shuffleThis()
                        .collectFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()))
                        .toArray());

        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(
                1.082323233761663,
                iterable.sum(),
                1.0e-15);
    }

    @Test
    public void min()
    {
        Assert.assertEquals(1.0f, FloatIteratorIterate.min(this.iterable.floatIterator()), 0.0);
        Verify.assertThrows(NoSuchElementException.class, () -> FloatIteratorIterate.min(new FloatArrayList().floatIterator()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(1.0f, FloatIteratorIterate.min(this.iterable.floatIterator()), 0.0);
        Verify.assertThrows(NoSuchElementException.class, () -> FloatIteratorIterate.max(new FloatArrayList().floatIterator()));
    }
}
