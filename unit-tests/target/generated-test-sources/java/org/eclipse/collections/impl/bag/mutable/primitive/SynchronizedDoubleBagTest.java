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

import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedDoubleBag}.
 * This file was automatically generated from template file synchronizedPrimitiveBagTest.stg.
 */
public class SynchronizedDoubleBagTest extends AbstractMutableDoubleBagTestCase
{
    @Override
    protected SynchronizedDoubleBag classUnderTest()
    {
        return new SynchronizedDoubleBag(DoubleHashBag.newBagWith(1.0, 2.0, 3.0));
    }

    @Override
    protected SynchronizedDoubleBag newWith(double... elements)
    {
        return new SynchronizedDoubleBag(DoubleHashBag.newBagWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedDoubleBag bag = this.classUnderTest();
        MutableDoubleBag bagWithLockObject = new SynchronizedDoubleBag(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), new Object());
        Assert.assertEquals(bag, bagWithLockObject);
        Assert.assertSame(bagWithLockObject, bagWithLockObject.asSynchronized());
        Assert.assertSame(bag, bag.asSynchronized());
        Assert.assertEquals(bag, bag.asSynchronized());
    }
}
