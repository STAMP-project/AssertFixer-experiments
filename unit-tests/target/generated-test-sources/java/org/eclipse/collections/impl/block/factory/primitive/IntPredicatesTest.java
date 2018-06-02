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
 * Provides a set of common tests of predicates for int values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class IntPredicatesTest
{
    @Test
    public void testEqual()
    {
        Assert.assertTrue(IntPredicates.equal(5).accept(5));
        Assert.assertFalse(IntPredicates.equal(5).accept(6));
    }

    @Test
    public void testLessThan()
    {
        Assert.assertTrue(IntPredicates.lessThan(5).accept(4));
        Assert.assertFalse(IntPredicates.lessThan(5).accept(6));
    }

    @Test
    public void testGreaterThan()
    {
        Assert.assertTrue(IntPredicates.greaterThan(5).accept(6));
        Assert.assertFalse(IntPredicates.greaterThan(5).accept(4));
    }

    @Test
    public void alwaysTrue()
    {
        Assert.assertTrue(IntPredicates.alwaysTrue().accept(5));
    }

    @Test
    public void alwaysFalse()
    {
        Assert.assertFalse(IntPredicates.alwaysFalse().accept(5));
    }

    @Test
    public void testIsOdd()
    {
        Assert.assertTrue(IntPredicates.isOdd().accept(5));
        Assert.assertFalse(IntPredicates.isOdd().accept(6));
    }

    @Test
    public void testIsEven()
    {
        Assert.assertTrue(IntPredicates.isEven().accept(6));
        Assert.assertFalse(IntPredicates.isEven().accept(5));
    }

    @Test
    public void testAnd()
    {
        Assert.assertTrue(IntPredicates.and(IntPredicates.greaterThan(5), IntPredicates.lessThan(7)).accept(6));
        Assert.assertFalse(IntPredicates.and(IntPredicates.greaterThan(5), IntPredicates.lessThan(7)).accept(8));
        Assert.assertFalse(IntPredicates.and(IntPredicates.greaterThan(5), IntPredicates.lessThan(7)).accept(4));
    }

    @Test
    public void testOr()
    {
        Assert.assertFalse(IntPredicates.or(IntPredicates.lessThan(5), IntPredicates.greaterThan(7)).accept(6));
        Assert.assertTrue(IntPredicates.or(IntPredicates.lessThan(5), IntPredicates.greaterThan(7)).accept(4));
        Assert.assertTrue(IntPredicates.or(IntPredicates.lessThan(5), IntPredicates.greaterThan(7)).accept(8));
    }

    @Test
    public void testNot()
    {
        Assert.assertFalse(IntPredicates.not(IntPredicates.equal(5)).accept(5));
        Assert.assertTrue(IntPredicates.not(IntPredicates.equal(5)).accept(6));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(IntPredicates.class);
    }
}
