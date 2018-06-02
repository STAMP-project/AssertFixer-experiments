/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortSet}.
 * This file was automatically generated from template file unmodifiablePrimitiveSetTest.stg.
 */
public class UnmodifiableShortSetTest extends AbstractShortSetTestCase
{
    @Override
    protected final UnmodifiableShortSet classUnderTest()
    {
        return new UnmodifiableShortSet(ShortHashSet.newSetWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected UnmodifiableShortSet newWith(short... elements)
    {
        return new UnmodifiableShortSet(ShortHashSet.newSetWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        this.classUnderTest().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.newWith().add((short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.classUnderTest().remove((short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(ShortPredicates.equal((short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll()
    {
        this.classUnderTest().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable()
    {
        this.classUnderTest().removeAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll()
    {
        this.classUnderTest().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable()
    {
        this.classUnderTest().retainAll(this.newMutableCollectionWith());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.newWith().with((short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.newWith().withAll(this.newMutableCollectionWith((short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5).without((short) 9);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.newWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5).withoutAll(this.newMutableCollectionWith((short) 8, (short) 9));
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableShortSet set = this.newWith((short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1);
        Assert.assertFalse(set.contains((short) 29));
        Assert.assertFalse(set.contains((short) 49));

        short[] numbers = {(short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1};
        for (short number : numbers)
        {
            Assert.assertTrue(set.contains(number));
        }

        Assert.assertFalse(set.contains((short) -1));
        Assert.assertFalse(set.contains((short) 29));
        Assert.assertFalse(set.contains((short) 49));

        UnmodifiableShortSet set1 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(set1.contains((short) 0));
        Assert.assertTrue(set1.contains((short) 1));
        Assert.assertTrue(set1.contains((short) 2));
        Assert.assertFalse(set1.contains((short) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void shortIterator_throws_non_empty_collection()
    {
        UnmodifiableShortSet set = this.newWith((short) 1, (short) 2, (short) 3);
        ShortIterator iterator = set.shortIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }
        iterator.next();
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        UnmodifiableShortSet set = this.classUnderTest();
        super.asUnmodifiable();
        Assert.assertSame(set, set.asUnmodifiable());
        Assert.assertEquals(set, set.asUnmodifiable());
    }

    @Override
    public void shortIterator_with_remove()
    {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void shortIterator_throws_for_remove_before_next()
    {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void shortIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable
    }
}
