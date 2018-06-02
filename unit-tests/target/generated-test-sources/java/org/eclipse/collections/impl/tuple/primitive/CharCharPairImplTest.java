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
 * JUnit test for {@link CharCharPairImpl}.
 *
 * This file was automatically generated from template file primitivePrimitivePairImplTest.stg.
 */
public class CharCharPairImplTest
{
    @Test
    public void testEqualsAndHashCode()
    {
        Verify.assertEqualsAndHashCode(PrimitiveTuples.pair((char) 1, (char) 2), PrimitiveTuples.pair((char) 1, (char) 2));
        Assert.assertNotEquals(PrimitiveTuples.pair((char) 8, (char) 2), PrimitiveTuples.pair((char) 1, (char) 2));
        Assert.assertEquals(Tuples.pair((char) 1, (char) 2).hashCode(), PrimitiveTuples.pair((char) 1, (char) 2).hashCode());
    }

    @Test
    public void getOne()
    {
        Assert.assertEquals((char) 1, PrimitiveTuples.pair((char) 1, (char) 2).getOne(), (char) 0);
        Assert.assertEquals((char) 12, PrimitiveTuples.pair((char) 12, (char) 2).getOne(), (char) 0);
    }

    @Test
    public void getTwo()
    {
        Assert.assertEquals((char) 2, PrimitiveTuples.pair((char) 1, (char) 2).getTwo(), (char) 0);
        Assert.assertEquals((char) 0, PrimitiveTuples.pair((char) 1, (char) 0).getTwo(), (char) 0);
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("\u0001:\u0002", PrimitiveTuples.pair((char) 1, (char) 2).toString());
        Assert.assertEquals("\u0002:\u0008", PrimitiveTuples.pair((char) 2, (char) 8).toString());
    }

    @Test
    public void compareTo()
    {
        Assert.assertEquals(1, PrimitiveTuples.pair((char) 2, (char) 2).compareTo(PrimitiveTuples.pair((char) 1, (char) 2)));
        Assert.assertEquals(0, PrimitiveTuples.pair((char) 1, (char) 2).compareTo(PrimitiveTuples.pair((char) 1, (char) 2)));
        Assert.assertEquals(-1, PrimitiveTuples.pair((char) 1, (char) 2).compareTo(PrimitiveTuples.pair((char) 1, (char) 3)));
    }
}
