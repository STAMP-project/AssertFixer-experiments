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

import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;

/**
 * JUnit test for {@link ImmutableDoubleSingletonBag}.
 * This file was automatically generated from template file immutablePrimitiveSingletonBagTest.stg.
 */
public class ImmutableDoubleSingletonBagTest extends AbstractImmutableDoubleBagTestCase
{
    @Override
    protected final ImmutableDoubleBag classUnderTest()
    {
        return DoubleBags.immutable.of(1.0);
    }

    @Override
    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.classUnderTest().forEachWithOccurrences((double argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertEquals("1.01", string);
    }

    @Override
    @Test
    public void selectByOccurrences()
    {
        ImmutableDoubleSingletonBag bag = new ImmutableDoubleSingletonBag(1.0);
        ImmutableDoubleBag filtered1 = bag.selectByOccurrences(i -> i > 0);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), filtered1);
        ImmutableDoubleBag filtered2 = bag.selectByOccurrences(i -> i > 1);
        Assert.assertEquals(DoubleBags.immutable.empty(), filtered2);
    }

    @Override
    @Test
    public void selectDuplicates()
    {
        ImmutableDoubleSingletonBag bag = new ImmutableDoubleSingletonBag(1.0);
        Assert.assertEquals(DoubleHashBag.newBagWith(), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableDoubleBag bag = this.classUnderTest();
        ImmutableDoubleSet expected = DoubleSets.immutable.with(1.0);
        ImmutableDoubleSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableDoubleSingletonBag iterable = new ImmutableDoubleSingletonBag(1.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(1.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(2.0), result);
    }
}
