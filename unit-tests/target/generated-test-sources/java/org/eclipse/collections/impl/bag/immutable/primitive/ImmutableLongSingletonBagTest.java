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

import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;

/**
 * JUnit test for {@link ImmutableLongSingletonBag}.
 * This file was automatically generated from template file immutablePrimitiveSingletonBagTest.stg.
 */
public class ImmutableLongSingletonBagTest extends AbstractImmutableLongBagTestCase
{
    @Override
    protected final ImmutableLongBag classUnderTest()
    {
        return LongBags.immutable.of(1L);
    }

    @Override
    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((long argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("11", string);
    }

    @Override
    @Test
    public void selectByOccurrences()
    {
        ImmutableLongSingletonBag bag = new ImmutableLongSingletonBag(1L);
        ImmutableLongBag filtered1 = bag.selectByOccurrences(i -> i > 0);
        Assert.assertEquals(LongHashBag.newBagWith(1L), filtered1);
        ImmutableLongBag filtered2 = bag.selectByOccurrences(i -> i > 1);
        Assert.assertEquals(LongBags.immutable.empty(), filtered2);
    }

    @Override
    @Test
    public void selectDuplicates()
    {
        ImmutableLongSingletonBag bag = new ImmutableLongSingletonBag(1L);
        Assert.assertEquals(LongHashBag.newBagWith(), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableLongBag bag = this.classUnderTest();
        ImmutableLongSet expected = LongSets.immutable.with(1L);
        ImmutableLongSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableLongSingletonBag iterable = new ImmutableLongSingletonBag(1L);
        MutableLong result = iterable.injectInto(new MutableLong(1L), MutableLong::add);
        Assert.assertEquals(new MutableLong(2L), result);
    }
}
