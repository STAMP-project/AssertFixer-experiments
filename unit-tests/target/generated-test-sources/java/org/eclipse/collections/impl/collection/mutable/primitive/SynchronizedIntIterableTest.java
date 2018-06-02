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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.primitive.SynchronizedIntIterable;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedIntIterable}s
 * This file was automatically generated from template file synchronizedPrimitiveIterableTest.stg.
 */
public class SynchronizedIntIterableTest extends AbstractIntIterableTestCase
{
    @Override
    protected IntIterable classUnderTest()
    {
        return SynchronizedIntIterable.of(IntArrayList.newListWith(1, 2, 3));
    }

    @Override
    protected IntIterable newWith(int... elements)
    {
        return SynchronizedIntIterable.of(IntArrayList.newListWith(elements));
    }

    @Override
    protected IntIterable newMutableCollectionWith(int... elements)
    {
        return IntArrayList.newListWith(elements);
    }

    @Override
    protected RichIterable<Integer> newObjectCollectionWith(Integer... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_iterable_throws()
    {
        SynchronizedIntIterable iterable = SynchronizedIntIterable.of(null);
    }

    @Override
    @Test
    public void intIterator()
    {
        IntIterable iterable = this.newWith(0, 1, 2, 3);
        IntArrayList list = IntArrayList.newListWith(0, 1, 2, 3);
        IntIterator iterator = iterable.intIterator();
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
