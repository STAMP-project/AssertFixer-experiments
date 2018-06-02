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
 * JUnit test for {@link BooleanDoublePairImpl}.
 *
 * This file was automatically generated from template file booleanPrimitivePairImplTest.stg.
 */
public class BooleanDoublePairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, 1.0), PrimitiveTuples.pair(true, 1.0));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, 1.0), PrimitiveTuples.pair(true, 1.0));
        Assert.assertEquals(Tuples.pair(true, 1.0).hashCode(), PrimitiveTuples.pair(true, 1.0).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertTrue(PrimitiveTuples.pair(true, 1.0).getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, 5.0).getOne());
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals(1.0, PrimitiveTuples.pair(true, 1.0).getTwo(), 0.0);
        Assert.assertEquals(2.0, PrimitiveTuples.pair(true, 2.0).getTwo(), 0.0);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("true:1.0", PrimitiveTuples.pair(true, 1.0).toString());
        Assert.assertEquals("false:2.0", PrimitiveTuples.pair(false, 2.0).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, 1.0).compareTo(PrimitiveTuples.pair(false, 2.0)));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, 1.0).compareTo(PrimitiveTuples.pair(true, 1.0)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(true, 1.0).compareTo(PrimitiveTuples.pair(true, 2.0)));
    }
}
