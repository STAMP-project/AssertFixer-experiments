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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntIterableIterate}.
 * This file was automatically generated from template file primitiveIterableIterateTest.stg.
 */
public class IntIterableIterateTest
{
    private final IntIterable iterable = IntArrayList.newListWith(1, 2, 3);

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        IntIterableIterate.forEach(this.iterable, (int each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void select_target()
    {
        Verify.assertSize(2, IntIterableIterate.select(this.iterable, IntPredicates.greaterThan(1), new IntArrayList(2)));
        Verify.assertSize(1, IntIterableIterate.select(this.iterable, IntPredicates.greaterThan(2), new IntArrayList(1)));
        Verify.assertEmpty(IntIterableIterate.select(this.iterable, IntPredicates.lessThan(0), new IntArrayList(3)));
    }

    @Test
    public void reject_target()
    {
        Verify.assertSize(1, IntIterableIterate.reject(this.iterable, IntPredicates.greaterThan(1), new IntArrayList(1)));
        Verify.assertEmpty(IntIterableIterate.reject(this.iterable, IntPredicates.greaterThan(0), new IntArrayList(0)));
    }

    @Test
    public void collect_target()
    {
        Verify.assertIterableSize(3, IntIterableIterate.collect(this.iterable, String::valueOf, FastList.<String>newList()));
    }
}
