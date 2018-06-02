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

import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedCharSet}.
 * This file was automatically generated from template file synchronizedPrimitiveSetTest.stg.
 */
public class SynchronizedCharSetTest extends AbstractCharSetTestCase
{
    @Override
    protected SynchronizedCharSet classUnderTest()
    {
        return new SynchronizedCharSet(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected SynchronizedCharSet newWith(char... elements)
    {
        return new SynchronizedCharSet(CharHashSet.newSetWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedCharSet set = this.classUnderTest();
        MutableCharSet setWithLockObject = new SynchronizedCharSet(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), new Object());
        Assert.assertEquals(set, setWithLockObject);
        Assert.assertSame(setWithLockObject, setWithLockObject.asSynchronized());
        Assert.assertSame(set, set.asSynchronized());
        Assert.assertEquals(set, set.asSynchronized());
    }
}
