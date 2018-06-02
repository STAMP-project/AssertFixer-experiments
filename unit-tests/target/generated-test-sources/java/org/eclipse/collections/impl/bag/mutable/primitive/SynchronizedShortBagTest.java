/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.mutable.primitive;

import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortBag}.
 * This file was automatically generated from template file synchronizedPrimitiveBagTest.stg.
 */
public class SynchronizedShortBagTest extends AbstractMutableShortBagTestCase
{
    @Override
    protected SynchronizedShortBag classUnderTest()
    {
        return new SynchronizedShortBag(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected SynchronizedShortBag newWith(short... elements)
    {
        return new SynchronizedShortBag(ShortHashBag.newBagWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedShortBag bag = this.classUnderTest();
        MutableShortBag bagWithLockObject = new SynchronizedShortBag(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), new Object());
        Assert.assertEquals(bag, bagWithLockObject);
        Assert.assertSame(bagWithLockObject, bagWithLockObject.asSynchronized());
        Assert.assertSame(bag, bag.asSynchronized());
        Assert.assertEquals(bag, bag.asSynchronized());
    }
}
