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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortIterableIterate}.
 * This file was automatically generated from template file primitiveIterableIterateTest.stg.
 */
public class ShortIterableIterateTest
{
    private final ShortIterable iterable = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        ShortIterableIterate.forEach(this.iterable, (short each) -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void select_target()
    {
        Verify.assertSize(2, ShortIterableIterate.select(this.iterable, ShortPredicates.greaterThan((short) 1), new ShortArrayList(2)));
        Verify.assertSize(1, ShortIterableIterate.select(this.iterable, ShortPredicates.greaterThan((short) 2), new ShortArrayList(1)));
        Verify.assertEmpty(ShortIterableIterate.select(this.iterable, ShortPredicates.lessThan((short) 0), new ShortArrayList(3)));
    }

    @Test
    public void reject_target()
    {
        Verify.assertSize(1, ShortIterableIterate.reject(this.iterable, ShortPredicates.greaterThan((short) 1), new ShortArrayList(1)));
        Verify.assertEmpty(ShortIterableIterate.reject(this.iterable, ShortPredicates.greaterThan((short) 0), new ShortArrayList(0)));
    }

    @Test
    public void collect_target()
    {
        Verify.assertIterableSize(3, ShortIterableIterate.collect(this.iterable, String::valueOf, FastList.<String>newList()));
    }
}
