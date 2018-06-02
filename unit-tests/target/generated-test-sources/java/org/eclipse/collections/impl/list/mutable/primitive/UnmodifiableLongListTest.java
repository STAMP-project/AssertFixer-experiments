/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongList}.
 * This file was automatically generated from template file unmodifiablePrimitiveListTest.stg.
 */
public class UnmodifiableLongListTest extends AbstractLongListTestCase
{
    private final UnmodifiableLongList list = this.classUnderTest();

    @Override
    protected final UnmodifiableLongList classUnderTest()
    {
        return new UnmodifiableLongList(LongArrayList.newListWith(1L, 2L, 3L));
    }

    @Override
    protected UnmodifiableLongList newWith(long... elements)
    {
        return new UnmodifiableLongList(LongArrayList.newListWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex()
    {
        new UnmodifiableLongList(new LongArrayList()).addAtIndex(0, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        new UnmodifiableLongList(new LongArrayList()).addAtIndex(1, 0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.list.addAtIndex(-1, 4L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, 5L, 6L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, 5L, 6L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, LongArrayList.newListWith(1L, 2L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, LongArrayList.newListWith(1L, 2L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAtIndex()
    {
        this.list.removeAtIndex(1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAtIndex_throws_index_greater_than_size()
    {
        new UnmodifiableLongList(new LongArrayList()).removeAtIndex(1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAtIndex_throws_index_negative()
    {
        this.list.removeAtIndex(-1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void set()
    {
        this.list.set(1, 4L);
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
    @Test(expected = UnsupportedOperationException.class)
    public void reverseThis()
    {
        new UnmodifiableLongList(new LongArrayList()).reverseThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortThis()
    {
        new UnmodifiableLongList(new LongArrayList()).sortThis();
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableLongList collection = this.newWith(14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L);
        Assert.assertFalse(collection.contains(29L));
        Assert.assertFalse(collection.contains(49L));

        long[] numbers = {14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L};
        for (long number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains(-1L));
        Assert.assertFalse(collection.contains(29L));
        Assert.assertFalse(collection.contains(49L));

        UnmodifiableLongList collection1 = this.newWith(0L, 1L, 1L, 2L, 2L, 2L);
        Assert.assertTrue(collection1.contains(0L));
        Assert.assertTrue(collection1.contains(1L));
        Assert.assertTrue(collection1.contains(2L));
        Assert.assertFalse(collection1.contains(3L));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void longIterator_throws_non_empty_collection()
    {
        UnmodifiableLongList collection = this.newWith(1L, 2L, 3L);
        LongIterator iterator = collection.longIterator();
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
        super.asUnmodifiable();
        Assert.assertSame(this.list, this.list.asUnmodifiable());
        Assert.assertEquals(this.list, this.list.asUnmodifiable());
    }

    @Override
    @Test
    public void longIterator_with_remove()
    {
        UnmodifiableLongList unmodifiableLongList = this.classUnderTest();
        MutableLongIterator iterator = unmodifiableLongList.longIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void longIterator_throws_for_remove_before_next()
    {
        UnmodifiableLongList unmodifiableLongList = this.classUnderTest();
        MutableLongIterator iterator = unmodifiableLongList.longIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void longIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
