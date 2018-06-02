/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.immutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.api.set.primitive.ImmutableByteSet;

/**
 * JUnit test for {@link ImmutableByteEmptyBag}.
 * This file was automatically generated from template file immutablePrimitiveEmptyBagTest.stg.
 */
public class ImmutableByteEmptyBagTest extends AbstractImmutableByteBagTestCase
{
    @Override
    protected final ImmutableByteBag classUnderTest()
    {
        return ByteBags.immutable.of();
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void average()
    {
        this.classUnderTest().average();
    }

    @Override
    @Test
    public void averageIfEmpty()
    {
        Assert.assertEquals(1.2, this.classUnderTest().averageIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median()
    {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void medianIfEmpty()
    {
        Assert.assertEquals(1.2, this.classUnderTest().medianIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max()
    {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min()
    {
        this.classUnderTest().min();
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.newWith());
    }

    @Override
    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((byte argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("", string);
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableByteBag bag = this.classUnderTest();
        ImmutableByteSet expected = ByteSets.immutable.empty();
        ImmutableByteSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void occurrencesOf()
    {
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf((byte) 1));
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf((byte) 2));
        Assert.assertEquals(0, this.classUnderTest().occurrencesOf((byte) 3));
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableByteEmptyBag iterable = new ImmutableByteEmptyBag();
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 0), result);
    }
}
