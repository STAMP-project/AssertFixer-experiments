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
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntIteratorIterate}.
 * This file was automatically generated from template file primitiveIteratorIterateTest.stg.
 */
public class IntIteratorIterateTest
{
    private final IntIterable iterable = IntArrayList.newListWith(1, 2, 3);

    @Test
    public void select_target()
    {
        Verify.assertSize(2, IntIteratorIterate.select(this.iterable.intIterator(), IntPredicates.greaterThan(1), new IntArrayList(2)));
        Verify.assertSize(2, IntIteratorIterate.select(this.iterable.intIterator(), IntPredicates.greaterThan(1), new IntArrayList(3)));
        Verify.assertEmpty(IntIteratorIterate.select(this.iterable.intIterator(), IntPredicates.lessThan(0), new IntArrayList(3)));
    }

    @Test
    public void reject_target()
    {
        Verify.assertSize(1, IntIteratorIterate.reject(this.iterable.intIterator(), IntPredicates.greaterThan(1), new IntArrayList(1)));
        Verify.assertEmpty(IntIteratorIterate.reject(this.iterable.intIterator(), IntPredicates.greaterThan(0), new IntArrayList(0)));
    }

    @Test
    public void collect_target()
    {
        Verify.assertIterableSize(3, IntIteratorIterate.collect(this.iterable.intIterator(), String::valueOf, FastList.<String>newList()));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6L, IntIteratorIterate.sum(this.iterable.intIterator()));
        Assert.assertEquals(0L, IntIteratorIterate.sum(new IntArrayList().intIterator()));
    }

    @Test
    public void min()
    {
        Assert.assertEquals(1, IntIteratorIterate.min(this.iterable.intIterator()));
        Verify.assertThrows(NoSuchElementException.class, () -> IntIteratorIterate.min(new IntArrayList().intIterator()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(1, IntIteratorIterate.min(this.iterable.intIterator()));
        Verify.assertThrows(NoSuchElementException.class, () -> IntIteratorIterate.max(new IntArrayList().intIterator()));
    }
}
