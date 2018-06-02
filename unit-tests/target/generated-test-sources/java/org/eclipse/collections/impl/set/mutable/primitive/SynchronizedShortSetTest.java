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

import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortSet}.
 * This file was automatically generated from template file synchronizedPrimitiveSetTest.stg.
 */
public class SynchronizedShortSetTest extends AbstractShortSetTestCase
{
    @Override
    protected SynchronizedShortSet classUnderTest()
    {
        return new SynchronizedShortSet(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected SynchronizedShortSet newWith(short... elements)
    {
        return new SynchronizedShortSet(ShortHashSet.newSetWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedShortSet set = this.classUnderTest();
        MutableShortSet setWithLockObject = new SynchronizedShortSet(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3), new Object());
        Assert.assertEquals(set, setWithLockObject);
        Assert.assertSame(setWithLockObject, setWithLockObject.asSynchronized());
        Assert.assertSame(set, set.asSynchronized());
        Assert.assertEquals(set, set.asSynchronized());
    }
}
