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

import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteList}.
 * This file was automatically generated from template file unmodifiablePrimitiveListTest.stg.
 */
public class UnmodifiableByteListTest extends AbstractByteListTestCase
{
    private final UnmodifiableByteList list = this.classUnderTest();

    @Override
    protected final UnmodifiableByteList classUnderTest()
    {
        return new UnmodifiableByteList(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected UnmodifiableByteList newWith(byte... elements)
    {
        return new UnmodifiableByteList(ByteArrayList.newListWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex()
    {
        new UnmodifiableByteList(new ByteArrayList()).addAtIndex(0, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        new UnmodifiableByteList(new ByteArrayList()).addAtIndex(1, (byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.list.addAtIndex(-1, (byte) 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, (byte) 5, (byte) 6);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, (byte) 5, (byte) 6);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, ByteArrayList.newListWith((byte) 1, (byte) 2));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, ByteArrayList.newListWith((byte) 1, (byte) 2));
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
        new UnmodifiableByteList(new ByteArrayList()).removeAtIndex(1);
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
        this.list.set(1, (byte) 4);
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
        this.newWith().add((byte) 1);
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
        this.classUnderTest().remove((byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(BytePredicates.equal((byte) 1));
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
        this.newWith().with((byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.newWith().withAll(this.newMutableCollectionWith((byte) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).without((byte) 9);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.newWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5).withoutAll(this.newMutableCollectionWith((byte) 8, (byte) 9));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseThis()
    {
        new UnmodifiableByteList(new ByteArrayList()).reverseThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortThis()
    {
        new UnmodifiableByteList(new ByteArrayList()).sortThis();
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableByteList collection = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
        Assert.assertFalse(collection.contains((byte) 29));
        Assert.assertFalse(collection.contains((byte) 49));

        byte[] numbers = {(byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1};
        for (byte number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains((byte) -1));
        Assert.assertFalse(collection.contains((byte) 29));
        Assert.assertFalse(collection.contains((byte) 49));

        UnmodifiableByteList collection1 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertTrue(collection1.contains((byte) 0));
        Assert.assertTrue(collection1.contains((byte) 1));
        Assert.assertTrue(collection1.contains((byte) 2));
        Assert.assertFalse(collection1.contains((byte) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void byteIterator_throws_non_empty_collection()
    {
        UnmodifiableByteList collection = this.newWith((byte) 1, (byte) 2, (byte) 3);
        ByteIterator iterator = collection.byteIterator();
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
    public void byteIterator_with_remove()
    {
        UnmodifiableByteList unmodifiableByteList = this.classUnderTest();
        MutableByteIterator iterator = unmodifiableByteList.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void byteIterator_throws_for_remove_before_next()
    {
        UnmodifiableByteList unmodifiableByteList = this.classUnderTest();
        MutableByteIterator iterator = unmodifiableByteList.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void byteIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
