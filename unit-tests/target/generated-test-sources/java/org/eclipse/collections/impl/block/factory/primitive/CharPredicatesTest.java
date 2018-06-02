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
 * Provides a set of common tests of predicates for char values.
 * This file was automatically generated from template file primitivePredicatesTest.stg.
 */
public final class CharPredicatesTest
{
    @Test
    public void testEqual()
    {
        Assert.assertTrue(CharPredicates.equal((char) 5).accept((char) 5));
        Assert.assertFalse(CharPredicates.equal((char) 5).accept((char) 6));
    }

    @Test
    public void testLessThan()
    {
        Assert.assertTrue(CharPredicates.lessThan((char) 5).accept((char) 4));
        Assert.assertFalse(CharPredicates.lessThan((char) 5).accept((char) 6));
    }

    @Test
    public void testGreaterThan()
    {
        Assert.assertTrue(CharPredicates.greaterThan((char) 5).accept((char) 6));
        Assert.assertFalse(CharPredicates.greaterThan((char) 5).accept((char) 4));
    }

    @Test
    public void alwaysTrue()
    {
        Assert.assertTrue(CharPredicates.alwaysTrue().accept((char) 5));
    }

    @Test
    public void alwaysFalse()
    {
        Assert.assertFalse(CharPredicates.alwaysFalse().accept((char) 5));
    }

    @Test
    public void testIsUpperCase()
    {
        Assert.assertTrue(CharPredicates.isUpperCase().accept('A'));
        Assert.assertFalse(CharPredicates.isUpperCase().accept('a'));
    }

    @Test
    public void testIsLowerCase()
    {
        Assert.assertTrue(CharPredicates.isLowerCase().accept('a'));
        Assert.assertFalse(CharPredicates.isLowerCase().accept('A'));
    }

    @Test
    public void testIsDigit()
    {
        Assert.assertTrue(CharPredicates.isDigit().accept('5'));
        Assert.assertFalse(CharPredicates.isDigit().accept('a'));
    }

    @Test
    public void testIsDigitOrDot()
    {
        Assert.assertTrue(CharPredicates.isDigitOrDot().accept('5'));
        Assert.assertTrue(CharPredicates.isDigitOrDot().accept('.'));
        Assert.assertFalse(CharPredicates.isDigitOrDot().accept('a'));
    }

    @Test
    public void testIsLetter()
    {
        Assert.assertTrue(CharPredicates.isLetter().accept('a'));
        Assert.assertTrue(CharPredicates.isLetter().accept('A'));
        Assert.assertFalse(CharPredicates.isLetter().accept('5'));
    }

    @Test
    public void testIsLetterOrDigit()
    {
        Assert.assertTrue(CharPredicates.isLetterOrDigit().accept('a'));
        Assert.assertTrue(CharPredicates.isLetterOrDigit().accept('A'));
        Assert.assertTrue(CharPredicates.isLetterOrDigit().accept('5'));
        Assert.assertFalse(CharPredicates.isLetterOrDigit().accept('.'));
        Assert.assertFalse(CharPredicates.isLetterOrDigit().accept('#'));
    }

    @Test
    public void testisWhitespace()
    {
        Assert.assertTrue(CharPredicates.isWhitespace().accept(' '));
        Assert.assertTrue(CharPredicates.isWhitespace().accept('\n'));
        Assert.assertFalse(CharPredicates.isWhitespace().accept('A'));
        Assert.assertFalse(CharPredicates.isWhitespace().accept('5'));
        Assert.assertFalse(CharPredicates.isWhitespace().accept('.'));
        Assert.assertFalse(CharPredicates.isWhitespace().accept('#'));
    }

    @Test
    public void testIsUndefined()
    {
        Assert.assertTrue(CharPredicates.isUndefined().accept((char) 888));
        Assert.assertFalse(CharPredicates.isUndefined().accept('a'));
    }

    @Test
    public void testAnd()
    {
        Assert.assertTrue(CharPredicates.and(CharPredicates.greaterThan((char) 5), CharPredicates.lessThan((char) 7)).accept((char) 6));
        Assert.assertFalse(CharPredicates.and(CharPredicates.greaterThan((char) 5), CharPredicates.lessThan((char) 7)).accept((char) 8));
        Assert.assertFalse(CharPredicates.and(CharPredicates.greaterThan((char) 5), CharPredicates.lessThan((char) 7)).accept((char) 4));
    }

    @Test
    public void testOr()
    {
        Assert.assertFalse(CharPredicates.or(CharPredicates.lessThan((char) 5), CharPredicates.greaterThan((char) 7)).accept((char) 6));
        Assert.assertTrue(CharPredicates.or(CharPredicates.lessThan((char) 5), CharPredicates.greaterThan((char) 7)).accept((char) 4));
        Assert.assertTrue(CharPredicates.or(CharPredicates.lessThan((char) 5), CharPredicates.greaterThan((char) 7)).accept((char) 8));
    }

    @Test
    public void testNot()
    {
        Assert.assertFalse(CharPredicates.not(CharPredicates.equal((char) 5)).accept((char) 5));
        Assert.assertTrue(CharPredicates.not(CharPredicates.equal((char) 5)).accept((char) 6));
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharPredicates.class);
    }
}
