/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedDoubleSet}.
 * This file was automatically generated from template file synchronizedPrimitiveSetTest.stg.
 */
public class SynchronizedDoubleSetTest extends AbstractDoubleSetTestCase
{
    @Override
    protected SynchronizedDoubleSet classUnderTest()
    {
        return new SynchronizedDoubleSet(DoubleHashSet.newSetWith(1.0, 2.0, 3.0));
    }

    @Override
    protected SynchronizedDoubleSet newWith(double... elements)
    {
        return new SynchronizedDoubleSet(DoubleHashSet.newSetWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedDoubleSet set = this.classUnderTest();
        MutableDoubleSet setWithLockObject = new SynchronizedDoubleSet(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), new Object());
        Assert.assertEquals(set, setWithLockObject);
        Assert.assertSame(setWithLockObject, setWithLockObject.asSynchronized());
        Assert.assertSame(set, set.asSynchronized());
        Assert.assertEquals(set, set.asSynchronized());
    }
}
