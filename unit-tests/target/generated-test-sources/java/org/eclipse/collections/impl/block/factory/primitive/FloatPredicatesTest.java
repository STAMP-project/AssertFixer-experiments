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
 * Provides a set of common tests of predicates for float values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class FloatPredicatesTest
{
    @Test
    public void testEqual()
    {
        Assert.assertTrue(FloatPredicates.equal(5.0f).accept(5.0f));
        Assert.assertFalse(FloatPredicates.equal(5.0f).accept(6.0f));
    }

    @Test
    public void testLessThan()
    {
        Assert.assertTrue(FloatPredicates.lessThan(5.0f).accept(4.0f));
        Assert.assertFalse(FloatPredicates.lessThan(5.0f).accept(6.0f));
    }

    @Test
    public void testGreaterThan()
    {
        Assert.assertTrue(FloatPredicates.greaterThan(5.0f).accept(6.0f));
        Assert.assertFalse(FloatPredicates.greaterThan(5.0f).accept(4.0f));
    }

    @Test
    public void alwaysTrue()
    {
        Assert.assertTrue(FloatPredicates.alwaysTrue().accept(5.0f));
    }

    @Test
    public void alwaysFalse()
    {
        Assert.assertFalse(FloatPredicates.alwaysFalse().accept(5.0f));
    }

    @Test
    public void equalWithDelta()
    {
        Assert.assertFalse(FloatPredicates.not(FloatPredicates.equal(5.0f, Float.valueOf("1e-15"))).accept(5.0f));
        Assert.assertFalse(FloatPredicates.not(FloatPredicates.equal(5.0f, 2.0f)).accept(6.0f));
        Assert.assertTrue(FloatPredicates.not(FloatPredicates.equal(5.0f, Float.valueOf("1e-15"))).accept(6.0f));
        Assert.assertTrue(FloatPredicates.not(FloatPredicates.equal(5.0f, 1.0f)).accept(7.0f));
    }

    @Test
    public void testAnd()
    {
        Assert.assertTrue(FloatPredicates.and(FloatPredicates.greaterThan(5.0f), FloatPredicates.lessThan(7.0f)).accept(6.0f));
        Assert.assertFalse(FloatPredicates.and(FloatPredicates.greaterThan(5.0f), FloatPredicates.lessThan(7.0f)).accept(8.0f));
        Assert.assertFalse(FloatPredicates.and(FloatPredicates.greaterThan(5.0f), FloatPredicates.lessThan(7.0f)).accept(4.0f));
    }

    @Test
    public void testOr()
    {
        Assert.assertFalse(FloatPredicates.or(FloatPredicates.lessThan(5.0f), FloatPredicates.greaterThan(7.0f)).accept(6.0f));
        Assert.assertTrue(FloatPredicates.or(FloatPredicates.lessThan(5.0f), FloatPredicates.greaterThan(7.0f)).accept(4.0f));
        Assert.assertTrue(FloatPredicates.or(FloatPredicates.lessThan(5.0f), FloatPredicates.greaterThan(7.0f)).accept(8.0f));
    }

    @Test
    public void testNot()
    {
        Assert.assertFalse(FloatPredicates.not(FloatPredicates.equal(5.0f)).accept(5.0f));
        Assert.assertTrue(FloatPredicates.not(FloatPredicates.equal(5.0f)).accept(6.0f));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(FloatPredicates.class);
    }
}
