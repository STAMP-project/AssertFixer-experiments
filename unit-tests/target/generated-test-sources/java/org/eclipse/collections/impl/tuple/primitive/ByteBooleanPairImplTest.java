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
 * JUnit test for {@link ByteBooleanPairImpl}.
 *
 * This file was automatically generated from template file primitiveBooleanPairImplTest.stg.
 */
public class ByteBooleanPairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((byte) 1, true), PrimitiveTuples.pair((byte) 1, true));
        Assert.assertNotEquals(PrimitiveTuples.pair((byte) 1, false), PrimitiveTuples.pair((byte) 1, true));
        Assert.assertEquals(Tuples.pair((byte) 1, true).hashCode(), PrimitiveTuples.pair((byte) 1, true).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertEquals((byte) 1, PrimitiveTuples.pair((byte) 1, true).getOne(), (byte) 0);
        Assert.assertEquals((byte) 3, PrimitiveTuples.pair((byte) 3, true).getOne(), (byte) 0);
    }

    @Test
    public void getTwo()
    {
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, true).getTwo());
        Assert.assertFalse(PrimitiveTuples.pair((byte) 1, false).getTwo());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("1:true", PrimitiveTuples.pair((byte) 1, true).toString());
        Assert.assertEquals("2:false", PrimitiveTuples.pair((byte) 2, false).toString());
        Assert.assertNotEquals("2, false", PrimitiveTuples.pair((byte) 2, false).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(-1, PrimitiveTuples.pair((byte) 1, true).compareTo(PrimitiveTuples.pair((byte) 2, false)));
        Assert.assertEquals(0, PrimitiveTuples.pair((byte) 1, true).compareTo(PrimitiveTuples.pair((byte) 1, true)));
        Assert.assertEquals(1, PrimitiveTuples.pair((byte) 1, true).compareTo(PrimitiveTuples.pair((byte) 1, false)));
    }
}
