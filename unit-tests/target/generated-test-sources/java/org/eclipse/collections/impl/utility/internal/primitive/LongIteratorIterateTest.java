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
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class LongIteratorIterateTest
{
    private final LongIterable iterable = LongArrayList.newListWith(1L, 2L, 3L);

    @Test
    public void select_target()
    {
        Verify.assertSize(2, LongIteratorIterate.select(this.iterable.longIterator(), LongPredicates.greaterThan(1L), new LongArrayList(2)));
        Verify.assertSize(2, LongIteratorIterate.select(this.iterable.longIterator(), LongPredicates.greaterThan(1L), new LongArrayList(3)));
        Verify.assertEmpty(LongIteratorIterate.select(this.iterable.longIterator(), LongPredicates.lessThan(0L), new LongArrayList(3)));
    }

    @Test
    public void reject_target()
    {
        Verify.assertSize(1, LongIteratorIterate.reject(this.iterable.longIterator(), LongPredicates.greaterThan(1L), new LongArrayList(1)));
        Verify.assertEmpty(LongIteratorIterate.reject(this.iterable.longIterator(), LongPredicates.greaterThan(0L), new LongArrayList(0)));
    }

    @Test
    public void collect_target()
    {
        Verify.assertIterableSize(3, LongIteratorIterate.collect(this.iterable.longIterator(), String::valueOf, FastList.<String>newList()));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6L, LongIteratorIterate.sum(this.iterable.longIterator()));
        Assert.assertEquals(0L, LongIteratorIterate.sum(new LongArrayList().longIterator()));
    }

    @Test
    public void min()
    {
        Assert.assertEquals(1L, LongIteratorIterate.min(this.iterable.longIterator()));
        Verify.assertThrows(NoSuchElementException.class, () -> LongIteratorIterate.min(new LongArrayList().longIterator()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(1L, LongIteratorIterate.min(this.iterable.longIterator()));
        Verify.assertThrows(NoSuchElementException.class, () -> LongIteratorIterate.max(new LongArrayList().longIterator()));
    }
}
