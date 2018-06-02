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

import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharList}.
 * This file was automatically generated from template file unmodifiablePrimitiveListTest.stg.
 */
public class UnmodifiableCharListTest extends AbstractCharListTestCase
{
    private final UnmodifiableCharList list = this.classUnderTest();

    @Override
    protected final UnmodifiableCharList classUnderTest()
    {
        return new UnmodifiableCharList(CharArrayList.newListWith((char) 1, (char) 2, (char) 3));
    }

    @Override
    protected UnmodifiableCharList newWith(char... elements)
    {
        return new UnmodifiableCharList(CharArrayList.newListWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex()
    {
        new UnmodifiableCharList(new CharArrayList()).addAtIndex(0, (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        new UnmodifiableCharList(new CharArrayList()).addAtIndex(1, (char) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.list.addAtIndex(-1, (char) 4);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, (char) 5, (char) 6);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, (char) 5, (char) 6);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, CharArrayList.newListWith((char) 1, (char) 2));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, CharArrayList.newListWith((char) 1, (char) 2));
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
        new UnmodifiableCharList(new CharArrayList()).removeAtIndex(1);
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
        this.list.set(1, (char) 4);
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
        this.newWith().add((char) 1);
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
        this.classUnderTest().remove((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(CharPredicates.equal((char) 1));
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
        this.newWith().with((char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.newWith().withAll(this.newMutableCollectionWith((char) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).without((char) 9);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).withoutAll(this.newMutableCollectionWith((char) 8, (char) 9));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseThis()
    {
        new UnmodifiableCharList(new CharArrayList()).reverseThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortThis()
    {
        new UnmodifiableCharList(new CharArrayList()).sortThis();
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableCharList collection = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));

        char[] numbers = {(char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1};
        for (char number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains((char) -1));
        Assert.assertFalse(collection.contains((char) 29));
        Assert.assertFalse(collection.contains((char) 49));

        UnmodifiableCharList collection1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(collection1.contains((char) 0));
        Assert.assertTrue(collection1.contains((char) 1));
        Assert.assertTrue(collection1.contains((char) 2));
        Assert.assertFalse(collection1.contains((char) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws_non_empty_collection()
    {
        UnmodifiableCharList collection = this.newWith((char) 1, (char) 2, (char) 3);
        CharIterator iterator = collection.charIterator();
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
    public void charIterator_with_remove()
    {
        UnmodifiableCharList unmodifiableCharList = this.classUnderTest();
        MutableCharIterator iterator = unmodifiableCharList.charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void charIterator_throws_for_remove_before_next()
    {
        UnmodifiableCharList unmodifiableCharList = this.classUnderTest();
        MutableCharIterator iterator = unmodifiableCharList.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void charIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
