/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.immutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.set.mutable.primitive.AbstractImmutableIntHashSetTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntEmptySet}.
 * This file was automatically generated from template file immutablePrimitiveEmptySetTest.stg.
 */
public class ImmutableIntEmptySetTest extends AbstractImmutableIntHashSetTestCase
{
    @Override
    protected final ImmutableIntSet classUnderTest()
    {
        return IntSets.immutable.empty();
    }

    @Override
    protected ImmutableIntSet newWith(int... elements)
    {
        return IntSets.immutable.with(elements);
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
    public void toBag()
    {
        Assert.assertEquals(IntBags.immutable.empty(), this.classUnderTest().toBag());
    }
}
