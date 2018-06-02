/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.mutable.primitive;

import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedIntList}.
 * This file was automatically generated from template file synchronizedPrimitiveListTest.stg.
 */
public class SynchronizedIntListTest extends AbstractIntListTestCase
{
    @Override
    protected SynchronizedIntList classUnderTest()
    {
        return new SynchronizedIntList(IntArrayList.newListWith(1, 2, 3));
    }

    @Override
    protected SynchronizedIntList newWith(int... elements)
    {
        return new SynchronizedIntList(IntArrayList.newListWith(elements));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedIntList list = this.classUnderTest();
        MutableIntList listWithLockObject = new SynchronizedIntList(IntArrayList.newListWith(1, 2, 3), new Object());
        Assert.assertEquals(list, listWithLockObject);
        Assert.assertSame(listWithLockObject, listWithLockObject.asSynchronized());
        Assert.assertSame(list, list.asSynchronized());
        Assert.assertEquals(list, list.asSynchronized());
    }
}
