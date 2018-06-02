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
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;

/**
 * JUnit test for {@link ImmutableShortHashBag}.
 * This file was automatically generated from template file immutablePrimitiveHashBagTest.stg.
 */
public class ImmutableShortHashBagTest extends AbstractImmutableShortBagTestCase
{
    @Override
    protected final ImmutableShortBag classUnderTest()
    {
        return ShortBags.immutable.of((short) 1, (short) 2, (short) 3);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableShortHashBag iterable = ImmutableShortHashBag.newBagWith((short) 1, (short) 2, (short) 3);
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }

    @Override
    @Test
    public void selectUnique()
    {
        super.selectUnique();

        ImmutableShortBag bag = this.classUnderTest();
        ImmutableShortSet expected = ShortSets.immutable.with((short) 1, (short) 2, (short) 3);
        ImmutableShortSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }
}
