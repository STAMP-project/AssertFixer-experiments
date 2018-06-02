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
 * JUnit test for {@link BooleanFloatPairImpl}.
 *
 * This file was automatically generated from template file booleanPrimitivePairImplTest.stg.
 */
public class BooleanFloatPairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair(true, 1.0f), PrimitiveTuples.pair(true, 1.0f));
        Assert.assertNotEquals(PrimitiveTuples.pair(false, 1.0f), PrimitiveTuples.pair(true, 1.0f));
        Assert.assertEquals(Tuples.pair(true, 1.0f).hashCode(), PrimitiveTuples.pair(true, 1.0f).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertTrue(PrimitiveTuples.pair(true, 1.0f).getOne());
        Assert.assertFalse(PrimitiveTuples.pair(false, 5.0f).getOne());
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals(1.0f, PrimitiveTuples.pair(true, 1.0f).getTwo(), 0.0f);
        Assert.assertEquals(2.0f, PrimitiveTuples.pair(true, 2.0f).getTwo(), 0.0f);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("true:1.0", PrimitiveTuples.pair(true, 1.0f).toString());
        Assert.assertEquals("false:2.0", PrimitiveTuples.pair(false, 2.0f).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair(true, 1.0f).compareTo(PrimitiveTuples.pair(false, 2.0f)));
        Assert.assertEquals(0, PrimitiveTuples.pair(true, 1.0f).compareTo(PrimitiveTuples.pair(true, 1.0f)));
        Assert.assertEquals(-1, PrimitiveTuples.pair(true, 1.0f).compareTo(PrimitiveTuples.pair(true, 2.0f)));
    }
}
