/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.primitive.SynchronizedDoubleIterable;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedDoubleIterable}s
 * This file was automatically generated from template file synchronizedPrimitiveIterableTest.stg.
 */
public class SynchronizedDoubleIterableTest extends AbstractDoubleIterableTestCase
{
    @Override
    protected DoubleIterable classUnderTest()
    {
        return SynchronizedDoubleIterable.of(DoubleArrayList.newListWith(1.0, 2.0, 3.0));
    }

    @Override
    protected DoubleIterable newWith(double... elements)
    {
        return SynchronizedDoubleIterable.of(DoubleArrayList.newListWith(elements));
    }

    @Override
    protected DoubleIterable newMutableCollectionWith(double... elements)
    {
        return DoubleArrayList.newListWith(elements);
    }

    @Override
    protected RichIterable<Double> newObjectCollectionWith(Double... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_iterable_throws()
    {
        SynchronizedDoubleIterable iterable = SynchronizedDoubleIterable.of(null);
    }

    @Override
    @Test
    public void doubleIterator()
    {
        DoubleIterable iterable = this.newWith(0.0, 1.0, 2.0, 3.0);
        DoubleArrayList list = DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0);
        DoubleIterator iterator = iterable.doubleIterator();
        for (int i = 0; i < 4; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());

        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void testEquals()
    {
        //Testing equals() is not applicable.
    }

    @Override
    @Test
    public void testEquals_NaN()
    {
        //Testing equals() is not applicable.
    }

    @Override
    public void testHashCode()
    {
        //Testing hashCode() is not applicable.
    }

    @Override
    public void newCollection()
    {
        //Testing newCollection() is not applicable.
    }
}
