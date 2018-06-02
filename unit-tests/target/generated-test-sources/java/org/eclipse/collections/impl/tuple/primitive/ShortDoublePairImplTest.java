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
 * JUnit test for {@link ShortDoublePairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class ShortDoublePairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((short) 1, 2.0), PrimitiveTuples.pair((short) 1, 2.0));
        Assert.assertNotEquals(PrimitiveTuples.pair((short) 8, 2.0), PrimitiveTuples.pair((short) 1, 2.0));
        Assert.assertEquals(Tuples.pair((short) 1, 2.0).hashCode(), PrimitiveTuples.pair((short) 1, 2.0).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertEquals((short) 1, PrimitiveTuples.pair((short) 1, 2.0).getOne(), (short) 0);
        Assert.assertEquals((short) 12, PrimitiveTuples.pair((short) 12, 2.0).getOne(), (short) 0);
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals(2.0, PrimitiveTuples.pair((short) 1, 2.0).getTwo(), (short) 0);
        Assert.assertEquals(0.0, PrimitiveTuples.pair((short) 1, 0.0).getTwo(), (short) 0);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("1:2.0", PrimitiveTuples.pair((short) 1, 2.0).toString());
        Assert.assertEquals("2:8.0", PrimitiveTuples.pair((short) 2, 8.0).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair((short) 2, 2.0).compareTo(PrimitiveTuples.pair((short) 1, 2.0)));
        Assert.assertEquals(0, PrimitiveTuples.pair((short) 1, 2.0).compareTo(PrimitiveTuples.pair((short) 1, 2.0)));
        Assert.assertEquals(-1, PrimitiveTuples.pair((short) 1, 2.0).compareTo(PrimitiveTuples.pair((short) 1, 3.0)));
    }
}
