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

import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedLongSet}.
 * This file was automatically generated from template file synchronizedPrimitiveSetTest.stg.
 */
public class SynchronizedLongSetTest extends AbstractLongSetTestCase
{
    @Override
    protected SynchronizedLongSet classUnderTest()
    {
        return new SynchronizedLongSet(LongHashSet.newSetWith(1L, 2L, 3L));
    }

    @Override
    protected SynchronizedLongSet newWith(long... elements)
    {
        return new SynchronizedLongSet(LongHashSet.newSetWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedLongSet set = this.classUnderTest();
        MutableLongSet setWithLockObject = new SynchronizedLongSet(LongHashSet.newSetWith(1L, 2L, 3L), new Object());
        Assert.assertEquals(set, setWithLockObject);
        Assert.assertSame(setWithLockObject, setWithLockObject.asSynchronized());
        Assert.assertSame(set, set.asSynchronized());
        Assert.assertEquals(set, set.asSynchronized());
    }
}
