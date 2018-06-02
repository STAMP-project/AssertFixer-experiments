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

import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortList}.
 * This file was automatically generated from template file unmodifiablePrimitiveListTest.stg.
 */
public class UnmodifiableShortListTest extends AbstractShortListTestCase
{
    private final UnmodifiableShortList list = this.classUnderTest();

    @Override
    protected final UnmodifiableShortList classUnderTest()
    {
        return new UnmodifiableShortList(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected UnmodifiableShortList newWith(short... elements)
    {
        return new UnmodifiableShortList(ShortArrayList.newListWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex()
    {
        new UnmodifiableShortList(new ShortArrayList()).addAtIndex(0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        new UnmodifiableShortList(new ShortArrayList()).addAtIndex(1, (short) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.list.addAtIndex(-1, (short) 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, (short) 5, (short) 6);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, (short) 5, (short) 6);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, ShortArrayList.newListWith((short) 1, (short) 2));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, ShortArrayList.newListWith((short) 1, (short) 2));
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
        new UnmodifiableShortList(new ShortArrayList()).removeAtIndex(1);
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
        this.list.set(1, (short) 4);
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
    @Test(expected = UnsupportedOperationException.class)
    public void reverseThis()
    {
        new UnmodifiableShortList(new ShortArrayList()).reverseThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortThis()
    {
        new UnmodifiableShortList(new ShortArrayList()).sortThis();
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableShortList collection = this.newWith((short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1);
        Assert.assertFalse(collection.contains((short) 29));
        Assert.assertFalse(collection.contains((short) 49));

        short[] numbers = {(short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1};
        for (short number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains((short) -1));
        Assert.assertFalse(collection.contains((short) 29));
        Assert.assertFalse(collection.contains((short) 49));

        UnmodifiableShortList collection1 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(collection1.contains((short) 0));
        Assert.assertTrue(collection1.contains((short) 1));
        Assert.assertTrue(collection1.contains((short) 2));
        Assert.assertFalse(collection1.contains((short) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void shortIterator_throws_non_empty_collection()
    {
        UnmodifiableShortList collection = this.newWith((short) 1, (short) 2, (short) 3);
        ShortIterator iterator = collection.shortIterator();
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
    public void shortIterator_with_remove()
    {
        UnmodifiableShortList unmodifiableShortList = this.classUnderTest();
        MutableShortIterator iterator = unmodifiableShortList.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void shortIterator_throws_for_remove_before_next()
    {
        UnmodifiableShortList unmodifiableShortList = this.classUnderTest();
        MutableShortIterator iterator = unmodifiableShortList.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void shortIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
