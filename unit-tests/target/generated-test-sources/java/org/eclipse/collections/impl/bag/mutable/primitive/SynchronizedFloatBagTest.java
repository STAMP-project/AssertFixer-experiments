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

import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedFloatBag}.
 * This file was automatically generated from template file synchronizedPrimitiveBagTest.stg.
 */
public class SynchronizedFloatBagTest extends AbstractMutableFloatBagTestCase
{
    @Override
    protected SynchronizedFloatBag classUnderTest()
    {
        return new SynchronizedFloatBag(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected SynchronizedFloatBag newWith(float... elements)
    {
        return new SynchronizedFloatBag(FloatHashBag.newBagWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedFloatBag bag = this.classUnderTest();
        MutableFloatBag bagWithLockObject = new SynchronizedFloatBag(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), new Object());
        Assert.assertEquals(bag, bagWithLockObject);
        Assert.assertSame(bagWithLockObject, bagWithLockObject.asSynchronized());
        Assert.assertSame(bag, bag.asSynchronized());
        Assert.assertEquals(bag, bag.asSynchronized());
    }
}
