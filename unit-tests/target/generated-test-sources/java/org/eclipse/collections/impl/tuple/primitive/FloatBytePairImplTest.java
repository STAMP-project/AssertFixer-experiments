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
 * JUnit test for {@link FloatBytePairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class FloatBytePairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(1.0f, (byte) 2), PrimitiveTuples.pair(1.0f, (byte) 2));
        Assert.assertNotEquals(PrimitiveTuples.pair(8.0f, (byte) 2), PrimitiveTuples.pair(1.0f, (byte) 2));
        Assert.assertEquals(Tuples.pair(1.0f, (byte) 2).hashCode(), PrimitiveTuples.pair(1.0f, (byte) 2).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertEquals(1.0f, PrimitiveTuples.pair(1.0f, (byte) 2).getOne(), 0.0f);
        Assert.assertEquals(12.0f, PrimitiveTuples.pair(12.0f, (byte) 2).getOne(), 0.0f);
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals((byte) 2, PrimitiveTuples.pair(1.0f, (byte) 2).getTwo(), 0.0f);
        Assert.assertEquals((byte) 0, PrimitiveTuples.pair(1.0f, (byte) 0).getTwo(), 0.0f);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("1.0:2", PrimitiveTuples.pair(1.0f, (byte) 2).toString());
        Assert.assertEquals("2.0:8", PrimitiveTuples.pair(2.0f, (byte) 8).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair(2.0f, (byte) 2).compareTo(PrimitiveTuples.pair(1.0f, (byte) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair(1.0f, (byte) 2).compareTo(PrimitiveTuples.pair(1.0f, (byte) 2)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(1.0f, (byte) 2).compareTo(PrimitiveTuples.pair(1.0f, (byte) 3)));
    }
}
