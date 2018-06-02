/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.tuple.primitive;

import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongLongPairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class LongLongPairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1L, 2L), PrimitiveTuples.pair(1L, 2L));
        Assert.assertNotEquals(PrimitiveTuples.pair(8L, 2L), PrimitiveTuples.pair(1L, 2L));
        Assert.assertEquals(Tuples.pair(1L, 2L).hashCode(), PrimitiveTuples.pair(1L, 2L).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertEquals(1L, PrimitiveTuples.pair(1L, 2L).getOne(), 0L);
        Assert.assertEquals(12L, PrimitiveTuples.pair(12L, 2L).getOne(), 0L);
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals(2L, PrimitiveTuples.pair(1L, 2L).getTwo(), 0L);
        Assert.assertEquals(0L, PrimitiveTuples.pair(1L, 0L).getTwo(), 0L);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("1:2", PrimitiveTuples.pair(1L, 2L).toString());
        Assert.assertEquals("2:8", PrimitiveTuples.pair(2L, 8L).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair(2L, 2L).compareTo(PrimitiveTuples.pair(1L, 2L)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1L, 2L).compareTo(PrimitiveTuples.pair(1L, 2L)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(1L, 2L).compareTo(PrimitiveTuples.pair(1L, 3L)));
    }
}
