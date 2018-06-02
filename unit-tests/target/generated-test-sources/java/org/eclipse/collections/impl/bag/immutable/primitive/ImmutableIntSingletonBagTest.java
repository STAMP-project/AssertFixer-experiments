/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.immutable.primitive;

import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;

/**
 * JUnit test for {@link ImmutableIntSingletonBag}.
 * This file was automatically generated from template file immutablePrimitiveSingletonBagTest.stg.
 */
public class ImmutableIntSingletonBagTest extends AbstractImmutableIntBagTestCase
{
    @Override
    protected final ImmutableIntBag classUnderTest()
    {
        return IntBags.immutable.of(1);
    }

    @Override
    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((int argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("11", string);
    }

    @Override
    @Test
    public void selectByOccurrences()
    {
        ImmutableIntSingletonBag bag = new ImmutableIntSingletonBag(1);
        ImmutableIntBag filtered1 = bag.selectByOccurrences(i -> i > 0);
        Assert.assertEquals(IntHashBag.newBagWith(1), filtered1);
        ImmutableIntBag filtered2 = bag.selectByOccurrences(i -> i > 1);
        Assert.assertEquals(IntBags.immutable.empty(), filtered2);
    }

    @Override
    @Test
    public void selectDuplicates()
    {
        ImmutableIntSingletonBag bag = new ImmutableIntSingletonBag(1);
        Assert.assertEquals(IntHashBag.newBagWith(), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableIntBag bag = this.classUnderTest();
        ImmutableIntSet expected = IntSets.immutable.with(1);
        ImmutableIntSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableIntSingletonBag iterable = new ImmutableIntSingletonBag(1);
        MutableInteger result = iterable.injectInto(new MutableInteger(1), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(2), result);
    }
}
