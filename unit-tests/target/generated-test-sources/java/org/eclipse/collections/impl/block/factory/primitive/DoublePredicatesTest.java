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
 * Provides a set of common tests of predicates for double values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class DoublePredicatesTest
{
    @Test
    public void testEqual()
    {
        Assert.assertTrue(DoublePredicates.equal(5.0).accept(5.0));
        Assert.assertFalse(DoublePredicates.equal(5.0).accept(6.0));
    }

    @Test
    public void testLessThan()
    {
        Assert.assertTrue(DoublePredicates.lessThan(5.0).accept(4.0));
        Assert.assertFalse(DoublePredicates.lessThan(5.0).accept(6.0));
    }

    @Test
    public void testGreaterThan()
    {
        Assert.assertTrue(DoublePredicates.greaterThan(5.0).accept(6.0));
        Assert.assertFalse(DoublePredicates.greaterThan(5.0).accept(4.0));
    }

    @Test
    public void alwaysTrue()
    {
        Assert.assertTrue(DoublePredicates.alwaysTrue().accept(5.0));
    }

    @Test
    public void alwaysFalse()
    {
        Assert.assertFalse(DoublePredicates.alwaysFalse().accept(5.0));
    }

    @Test
    public void equalWithDelta()
    {
        Assert.assertFalse(DoublePredicates.not(DoublePredicates.equal(5.0, Double.valueOf("1e-15"))).accept(5.0));
        Assert.assertFalse(DoublePredicates.not(DoublePredicates.equal(5.0, 2.0)).accept(6.0));
        Assert.assertTrue(DoublePredicates.not(DoublePredicates.equal(5.0, Double.valueOf("1e-15"))).accept(6.0));
        Assert.assertTrue(DoublePredicates.not(DoublePredicates.equal(5.0, 1.0)).accept(7.0));
    }

    @Test
    public void testAnd()
    {
        Assert.assertTrue(DoublePredicates.and(DoublePredicates.greaterThan(5.0), DoublePredicates.lessThan(7.0)).accept(6.0));
        Assert.assertFalse(DoublePredicates.and(DoublePredicates.greaterThan(5.0), DoublePredicates.lessThan(7.0)).accept(8.0));
        Assert.assertFalse(DoublePredicates.and(DoublePredicates.greaterThan(5.0), DoublePredicates.lessThan(7.0)).accept(4.0));
    }

    @Test
    public void testOr()
    {
        Assert.assertFalse(DoublePredicates.or(DoublePredicates.lessThan(5.0), DoublePredicates.greaterThan(7.0)).accept(6.0));
        Assert.assertTrue(DoublePredicates.or(DoublePredicates.lessThan(5.0), DoublePredicates.greaterThan(7.0)).accept(4.0));
        Assert.assertTrue(DoublePredicates.or(DoublePredicates.lessThan(5.0), DoublePredicates.greaterThan(7.0)).accept(8.0));
    }

    @Test
    public void testNot()
    {
        Assert.assertFalse(DoublePredicates.not(DoublePredicates.equal(5.0)).accept(5.0));
        Assert.assertTrue(DoublePredicates.not(DoublePredicates.equal(5.0)).accept(6.0));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoublePredicates.class);
    }
}
