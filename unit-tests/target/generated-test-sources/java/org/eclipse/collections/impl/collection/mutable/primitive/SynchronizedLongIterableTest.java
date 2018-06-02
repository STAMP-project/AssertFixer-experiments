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

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.primitive.SynchronizedLongIterable;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedLongIterable}s
 * This file was automatically generated from template file synchronizedPrimitiveIterableTest.stg.
 */
public class SynchronizedLongIterableTest extends AbstractLongIterableTestCase
{
    @Override
    protected LongIterable classUnderTest()
    {
        return SynchronizedLongIterable.of(LongArrayList.newListWith(1L, 2L, 3L));
    }

    @Override
    protected LongIterable newWith(long... elements)
    {
        return SynchronizedLongIterable.of(LongArrayList.newListWith(elements));
    }

    @Override
    protected LongIterable newMutableCollectionWith(long... elements)
    {
        return LongArrayList.newListWith(elements);
    }

    @Override
    protected RichIterable<Long> newObjectCollectionWith(Long... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_iterable_throws()
    {
        SynchronizedLongIterable iterable = SynchronizedLongIterable.of(null);
    }

    @Override
    @Test
    public void longIterator()
    {
        LongIterable iterable = this.newWith(0L, 1L, 2L, 3L);
        LongArrayList list = LongArrayList.newListWith(0L, 1L, 2L, 3L);
        LongIterator iterator = iterable.longIterator();
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
