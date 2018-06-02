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
 * JUnit test for {@link LongBooleanPairImpl}.
 *
 * This file was automatically generated from template file primitiveBooleanPairImplTest.stg.
 */
public class LongBooleanPairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1L, true), PrimitiveTuples.pair(1L, true));
        Assert.assertNotEquals(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(1L, true));
        Assert.assertEquals(Tuples.pair(1L, true).hashCode(), PrimitiveTuples.pair(1L, true).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertEquals(1L, PrimitiveTuples.pair(1L, true).getOne(), 0L);
        Assert.assertEquals(3L, PrimitiveTuples.pair(3L, true).getOne(), 0L);
    }

    @Test
    public void getTwo()
    {
        Assert.assertTrue(PrimitiveTuples.pair(1L, true).getTwo());
        Assert.assertFalse(PrimitiveTuples.pair(1L, false).getTwo());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("1:true", PrimitiveTuples.pair(1L, true).toString());
        Assert.assertEquals("2:false", PrimitiveTuples.pair(2L, false).toString());
        Assert.assertNotEquals("2, false", PrimitiveTuples.pair(2L, false).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(-1, PrimitiveTuples.pair(1L, true).compareTo(PrimitiveTuples.pair(2L, false)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1L, true).compareTo(PrimitiveTuples.pair(1L, true)));
        Assert.assertEquals(1, PrimitiveTuples.pair(1L, true).compareTo(PrimitiveTuples.pair(1L, false)));
    }
}
