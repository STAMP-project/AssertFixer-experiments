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
 * JUnit test for {@link BooleanLongPairImpl}.
 *
 * This file was automatically generated from template file booleanPrimitivePairImplTest.stg.
 */
public class BooleanLongPairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, 1L), PrimitiveTuples.pair(true, 1L));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, 1L), PrimitiveTuples.pair(true, 1L));
        Assert.assertEquals(Tuples.pair(true, 1L).hashCode(), PrimitiveTuples.pair(true, 1L).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertTrue(PrimitiveTuples.pair(true, 1L).getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, 5L).getOne());
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals(1L, PrimitiveTuples.pair(true, 1L).getTwo(), 0L);
        Assert.assertEquals(2L, PrimitiveTuples.pair(true, 2L).getTwo(), 0L);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("true:1", PrimitiveTuples.pair(true, 1L).toString());
        Assert.assertEquals("false:2", PrimitiveTuples.pair(false, 2L).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, 1L).compareTo(PrimitiveTuples.pair(false, 2L)));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, 1L).compareTo(PrimitiveTuples.pair(true, 1L)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(true, 1L).compareTo(PrimitiveTuples.pair(true, 2L)));
    }
}
