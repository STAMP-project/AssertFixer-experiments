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

import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedFloatSet}.
 * This file was automatically generated from template file synchronizedPrimitiveSetTest.stg.
 */
public class SynchronizedFloatSetTest extends AbstractFloatSetTestCase
{
    @Override
    protected SynchronizedFloatSet classUnderTest()
    {
        return new SynchronizedFloatSet(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected SynchronizedFloatSet newWith(float... elements)
    {
        return new SynchronizedFloatSet(FloatHashSet.newSetWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedFloatSet set = this.classUnderTest();
        MutableFloatSet setWithLockObject = new SynchronizedFloatSet(FloatHashSet.newSetWith(1.0f, 2.0f, 3.0f), new Object());
        Assert.assertEquals(set, setWithLockObject);
        Assert.assertSame(setWithLockObject, setWithLockObject.asSynchronized());
        Assert.assertSame(set, set.asSynchronized());
        Assert.assertEquals(set, set.asSynchronized());
    }
}
