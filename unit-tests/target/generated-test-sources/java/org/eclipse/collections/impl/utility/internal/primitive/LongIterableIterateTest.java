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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongIterableIterate}.
 * This file was automatically generated from template file primitiveIterableIterateTest.stg.
 */
public class LongIterableIterateTest
{
    private final LongIterable iterable = LongArrayList.newListWith(1L, 2L, 3L);

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        LongIterableIterate.forEach(this.iterable, (long each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void select_target()
    {
        Verify.assertSize(2, LongIterableIterate.select(this.iterable, LongPredicates.greaterThan(1L), new LongArrayList(2)));
        Verify.assertSize(1, LongIterableIterate.select(this.iterable, LongPredicates.greaterThan(2L), new LongArrayList(1)));
        Verify.assertEmpty(LongIterableIterate.select(this.iterable, LongPredicates.lessThan(0L), new LongArrayList(3)));
    }

    @Test
    public void reject_target()
    {
        Verify.assertSize(1, LongIterableIterate.reject(this.iterable, LongPredicates.greaterThan(1L), new LongArrayList(1)));
        Verify.assertEmpty(LongIterableIterate.reject(this.iterable, LongPredicates.greaterThan(0L), new LongArrayList(0)));
    }

    @Test
    public void collect_target()
    {
        Verify.assertIterableSize(3, LongIterableIterate.collect(this.iterable, String::valueOf, FastList.<String>newList()));
    }
}
