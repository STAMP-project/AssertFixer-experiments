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
 * Provides a set of common tests of predicates for long values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class LongPredicatesTest
{
    @Test
    public void testEqual()
    {
        Assert.assertTrue(LongPredicates.equal(5L).accept(5L));
        Assert.assertFalse(LongPredicates.equal(5L).accept(6L));
    }

    @Test
    public void testLessThan()
    {
        Assert.assertTrue(LongPredicates.lessThan(5L).accept(4L));
        Assert.assertFalse(LongPredicates.lessThan(5L).accept(6L));
    }

    @Test
    public void testGreaterThan()
    {
        Assert.assertTrue(LongPredicates.greaterThan(5L).accept(6L));
        Assert.assertFalse(LongPredicates.greaterThan(5L).accept(4L));
    }

    @Test
    public void alwaysTrue()
    {
        Assert.assertTrue(LongPredicates.alwaysTrue().accept(5L));
    }

    @Test
    public void alwaysFalse()
    {
        Assert.assertFalse(LongPredicates.alwaysFalse().accept(5L));
    }

    @Test
    public void testIsOdd()
    {
        Assert.assertTrue(LongPredicates.isOdd().accept(5L));
        Assert.assertFalse(LongPredicates.isOdd().accept(6L));
    }

    @Test
    public void testIsEven()
    {
        Assert.assertTrue(LongPredicates.isEven().accept(6L));
        Assert.assertFalse(LongPredicates.isEven().accept(5L));
    }

    @Test
    public void testAnd()
    {
        Assert.assertTrue(LongPredicates.and(LongPredicates.greaterThan(5L), LongPredicates.lessThan(7L)).accept(6L));
        Assert.assertFalse(LongPredicates.and(LongPredicates.greaterThan(5L), LongPredicates.lessThan(7L)).accept(8L));
        Assert.assertFalse(LongPredicates.and(LongPredicates.greaterThan(5L), LongPredicates.lessThan(7L)).accept(4L));
    }

    @Test
    public void testOr()
    {
        Assert.assertFalse(LongPredicates.or(LongPredicates.lessThan(5L), LongPredicates.greaterThan(7L)).accept(6L));
        Assert.assertTrue(LongPredicates.or(LongPredicates.lessThan(5L), LongPredicates.greaterThan(7L)).accept(4L));
        Assert.assertTrue(LongPredicates.or(LongPredicates.lessThan(5L), LongPredicates.greaterThan(7L)).accept(8L));
    }

    @Test
    public void testNot()
    {
        Assert.assertFalse(LongPredicates.not(LongPredicates.equal(5L)).accept(5L));
        Assert.assertTrue(LongPredicates.not(LongPredicates.equal(5L)).accept(6L));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongPredicates.class);
    }
}
