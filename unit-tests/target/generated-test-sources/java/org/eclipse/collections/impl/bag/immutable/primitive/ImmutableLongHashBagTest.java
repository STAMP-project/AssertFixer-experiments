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
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;

/**
 * JUnit test for {@link ImmutableLongHashBag}.
 * This file was automatically generated from template file immutablePrimitiveHashBagTest.stg.
 */
public class ImmutableLongHashBagTest extends AbstractImmutableLongBagTestCase
{
    @Override
    protected final ImmutableLongBag classUnderTest()
    {
        return LongBags.immutable.of(1L, 2L, 3L);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableLongHashBag iterable = ImmutableLongHashBag.newBagWith(1L, 2L, 3L);
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableLongBag bag = this.classUnderTest();
        ImmutableLongSet expected = LongSets.immutable.with(1L, 2L, 3L);
        ImmutableLongSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }
}
