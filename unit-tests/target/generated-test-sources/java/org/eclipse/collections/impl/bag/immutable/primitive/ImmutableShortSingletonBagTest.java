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

import org.eclipse.collections.api.bag.primitive.ImmutableShortBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;

/**
 * JUnit test for {@link ImmutableShortSingletonBag}.
 * This file was automatically generated from template file immutablePrimitiveSingletonBagTest.stg.
 */
public class ImmutableShortSingletonBagTest extends AbstractImmutableShortBagTestCase
{
    @Override
    protected final ImmutableShortBag classUnderTest()
    {
        return ShortBags.immutable.of((short) 1);
    }

    @Override
    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((short argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("11", string);
    }

    @Override
    @Test
    public void selectByOccurrences()
    {
        ImmutableShortSingletonBag bag = new ImmutableShortSingletonBag((short) 1);
        ImmutableShortBag filtered1 = bag.selectByOccurrences(i -> i > 0);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), filtered1);
        ImmutableShortBag filtered2 = bag.selectByOccurrences(i -> i > 1);
        Assert.assertEquals(ShortBags.immutable.empty(), filtered2);
    }

    @Override
    @Test
    public void selectDuplicates()
    {
        ImmutableShortSingletonBag bag = new ImmutableShortSingletonBag((short) 1);
        Assert.assertEquals(ShortHashBag.newBagWith(), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableShortBag bag = this.classUnderTest();
        ImmutableShortSet expected = ShortSets.immutable.with((short) 1);
        ImmutableShortSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableShortSingletonBag iterable = new ImmutableShortSingletonBag((short) 1);
        MutableShort result = iterable.injectInto(new MutableShort((short) 1), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 2), result);
    }
}
