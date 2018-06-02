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
 * JUnit test for {@link CharBytePairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class CharBytePairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((char) 1, (byte) 2), PrimitiveTuples.pair((char) 1, (byte) 2));
        Assert.assertNotEquals(PrimitiveTuples.pair((char) 8, (byte) 2), PrimitiveTuples.pair((char) 1, (byte) 2));
        Assert.assertEquals(Tuples.pair((char) 1, (byte) 2).hashCode(), PrimitiveTuples.pair((char) 1, (byte) 2).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertEquals((char) 1, PrimitiveTuples.pair((char) 1, (byte) 2).getOne(), (char) 0);
        Assert.assertEquals((char) 12, PrimitiveTuples.pair((char) 12, (byte) 2).getOne(), (char) 0);
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals((byte) 2, PrimitiveTuples.pair((char) 1, (byte) 2).getTwo(), (char) 0);
        Assert.assertEquals((byte) 0, PrimitiveTuples.pair((char) 1, (byte) 0).getTwo(), (char) 0);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("\u0001:2", PrimitiveTuples.pair((char) 1, (byte) 2).toString());
        Assert.assertEquals("\u0002:8", PrimitiveTuples.pair((char) 2, (byte) 8).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair((char) 2, (byte) 2).compareTo(PrimitiveTuples.pair((char) 1, (byte) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair((char) 1, (byte) 2).compareTo(PrimitiveTuples.pair((char) 1, (byte) 2)));
        Assert.assertEquals(-1, PrimitiveTuples.pair((char) 1, (byte) 2).compareTo(PrimitiveTuples.pair((char) 1, (byte) 3)));
    }
}
