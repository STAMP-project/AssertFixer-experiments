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

import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongSet}.
 * This file was automatically generated from template file unmodifiablePrimitiveSetTest.stg.
 */
public class UnmodifiableLongSetTest extends AbstractLongSetTestCase
{
    @Override
    protected final UnmodifiableLongSet classUnderTest()
    {
        return new UnmodifiableLongSet(LongHashSet.newSetWith(1L, 2L, 3L));
    }

    @Override
    protected UnmodifiableLongSet newWith(long... elements)
    {
        return new UnmodifiableLongSet(LongHashSet.newSetWith(elements));
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
        this.newWith().add(1L);
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
        this.classUnderTest().remove(1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(LongPredicates.equal(1L));
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
        this.newWith().with(1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.newWith().withAll(this.newMutableCollectionWith(1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.newWith(1L, 2L, 3L, 4L, 5L).without(9L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.newWith(1L, 2L, 3L, 4L, 5L).withoutAll(this.newMutableCollectionWith(8L, 9L));
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableLongSet set = this.newWith(14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L);
        Assert.assertFalse(set.contains(29L));
        Assert.assertFalse(set.contains(49L));

        long[] numbers = {14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L};
        for (long number : numbers)
        {
            Assert.assertTrue(set.contains(number));
        }

        Assert.assertFalse(set.contains(-1L));
        Assert.assertFalse(set.contains(29L));
        Assert.assertFalse(set.contains(49L));

        UnmodifiableLongSet set1 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertTrue(set1.contains(0L));
        Assert.assertTrue(set1.contains(1L));
        Assert.assertTrue(set1.contains(2L));
        Assert.assertFalse(set1.contains(3L));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void longIterator_throws_non_empty_collection()
    {
        UnmodifiableLongSet set = this.newWith(1L, 2L, 3L);
        LongIterator iterator = set.longIterator();
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
        UnmodifiableLongSet set = this.classUnderTest();
        super.asUnmodifiable();
        Assert.assertSame(set, set.asUnmodifiable());
        Assert.assertEquals(set, set.asUnmodifiable());
    }

    @Override
    public void longIterator_with_remove()
    {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void longIterator_throws_for_remove_before_next()
    {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void longIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable
    }
}
