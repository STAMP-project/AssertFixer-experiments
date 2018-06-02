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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.primitive.SynchronizedShortIterable;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedShortIterable}s
 * This file was automatically generated from template file synchronizedPrimitiveIterableTest.stg.
 */
public class SynchronizedShortIterableTest extends AbstractShortIterableTestCase
{
    @Override
    protected ShortIterable classUnderTest()
    {
        return SynchronizedShortIterable.of(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected ShortIterable newWith(short... elements)
    {
        return SynchronizedShortIterable.of(ShortArrayList.newListWith(elements));
    }

    @Override
    protected ShortIterable newMutableCollectionWith(short... elements)
    {
        return ShortArrayList.newListWith(elements);
    }

    @Override
    protected RichIterable<Short> newObjectCollectionWith(Short... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_iterable_throws()
    {
        SynchronizedShortIterable iterable = SynchronizedShortIterable.of(null);
    }

    @Override
    @Test
    public void shortIterator()
    {
        ShortIterable iterable = this.newWith((short) 0, (short) 1, (short) 2, (short) 3);
        ShortArrayList list = ShortArrayList.newListWith((short) 0, (short) 1, (short) 2, (short) 3);
        ShortIterator iterator = iterable.shortIterator();
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
