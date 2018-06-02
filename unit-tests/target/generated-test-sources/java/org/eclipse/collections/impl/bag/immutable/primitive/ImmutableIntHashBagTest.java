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
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;

/**
 * JUnit test for {@link ImmutableIntHashBag}.
 * This file was automatically generated from template file immutablePrimitiveHashBagTest.stg.
 */
public class ImmutableIntHashBagTest extends AbstractImmutableIntBagTestCase
{
    @Override
    protected final ImmutableIntBag classUnderTest()
    {
        return IntBags.immutable.of(1, 2, 3);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableIntHashBag iterable = ImmutableIntHashBag.newBagWith(1, 2, 3);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableIntBag bag = this.classUnderTest();
        ImmutableIntSet expected = IntSets.immutable.with(1, 2, 3);
        ImmutableIntSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }
}
