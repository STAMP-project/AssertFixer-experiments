/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.block.factory.primitive;

import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Provides a set of common tests of predicates for byte values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class BytePredicatesTest
{
    @Test
    public void testEqual()
    {
        Assert.assertTrue(BytePredicates.equal((byte) 5).accept((byte) 5));
        Assert.assertFalse(BytePredicates.equal((byte) 5).accept((byte) 6));
    }

    @Test
    public void testLessThan()
    {
        Assert.assertTrue(BytePredicates.lessThan((byte) 5).accept((byte) 4));
        Assert.assertFalse(BytePredicates.lessThan((byte) 5).accept((byte) 6));
    }

    @Test
    public void testGreaterThan()
    {
        Assert.assertTrue(BytePredicates.greaterThan((byte) 5).accept((byte) 6));
        Assert.assertFalse(BytePredicates.greaterThan((byte) 5).accept((byte) 4));
    }

    @Test
    public void alwaysTrue()
    {
        Assert.assertTrue(BytePredicates.alwaysTrue().accept((byte) 5));
    }

    @Test
    public void alwaysFalse()
    {
        Assert.assertFalse(BytePredicates.alwaysFalse().accept((byte) 5));
    }

    @Test
    public void testIsOdd()
    {
        Assert.assertTrue(BytePredicates.isOdd().accept((byte) 5));
        Assert.assertFalse(BytePredicates.isOdd().accept((byte) 6));
    }

    @Test
    public void testIsEven()
    {
        Assert.assertTrue(BytePredicates.isEven().accept((byte) 6));
        Assert.assertFalse(BytePredicates.isEven().accept((byte) 5));
    }

    @Test
    public void testAnd()
    {
        Assert.assertTrue(BytePredicates.and(BytePredicates.greaterThan((byte) 5), BytePredicates.lessThan((byte) 7)).accept((byte) 6));
        Assert.assertFalse(BytePredicates.and(BytePredicates.greaterThan((byte) 5), BytePredicates.lessThan((byte) 7)).accept((byte) 8));
        Assert.assertFalse(BytePredicates.and(BytePredicates.greaterThan((byte) 5), BytePredicates.lessThan((byte) 7)).accept((byte) 4));
    }

    @Test
    public void testOr()
    {
        Assert.assertFalse(BytePredicates.or(BytePredicates.lessThan((byte) 5), BytePredicates.greaterThan((byte) 7)).accept((byte) 6));
        Assert.assertTrue(BytePredicates.or(BytePredicates.lessThan((byte) 5), BytePredicates.greaterThan((byte) 7)).accept((byte) 4));
        Assert.assertTrue(BytePredicates.or(BytePredicates.lessThan((byte) 5), BytePredicates.greaterThan((byte) 7)).accept((byte) 8));
    }

    @Test
    public void testNot()
    {
        Assert.assertFalse(BytePredicates.not(BytePredicates.equal((byte) 5)).accept((byte) 5));
        Assert.assertTrue(BytePredicates.not(BytePredicates.equal((byte) 5)).accept((byte) 6));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(BytePredicates.class);
    }
}
