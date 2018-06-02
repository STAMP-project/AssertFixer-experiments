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

import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableFloatList}.
 * This file was automatically generated from template file unmodifiablePrimitiveListTest.stg.
 */
public class UnmodifiableFloatListTest extends AbstractFloatListTestCase
{
    private final UnmodifiableFloatList list = this.classUnderTest();

    @Override
    protected final UnmodifiableFloatList classUnderTest()
    {
        return new UnmodifiableFloatList(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected UnmodifiableFloatList newWith(float... elements)
    {
        return new UnmodifiableFloatList(FloatArrayList.newListWith(elements));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex()
    {
        new UnmodifiableFloatList(new FloatArrayList()).addAtIndex(0, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        new UnmodifiableFloatList(new FloatArrayList()).addAtIndex(1, 0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.list.addAtIndex(-1, 4.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, 5.0f, 6.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, 5.0f, 6.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.list.addAllAtIndex(-1, FloatArrayList.newListWith(1.0f, 2.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.list.addAllAtIndex(5, FloatArrayList.newListWith(1.0f, 2.0f));
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
        new UnmodifiableFloatList(new FloatArrayList()).removeAtIndex(1);
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
        this.list.set(1, 4.0f);
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
        this.newWith().add(1.0f);
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
        this.classUnderTest().remove(1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(FloatPredicates.equal(1.0f));
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
        this.newWith().with(1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.newWith().withAll(this.newMutableCollectionWith(1.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f).without(9.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.newWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f).withoutAll(this.newMutableCollectionWith(8.0f, 9.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void reverseThis()
    {
        new UnmodifiableFloatList(new FloatArrayList()).reverseThis();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void sortThis()
    {
        new UnmodifiableFloatList(new FloatArrayList()).sortThis();
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableFloatList collection = this.newWith(14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));

        float[] numbers = {14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f};
        for (float number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains(-1.0f));
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));

        UnmodifiableFloatList collection1 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertTrue(collection1.contains(0.0f));
        Assert.assertTrue(collection1.contains(1.0f));
        Assert.assertTrue(collection1.contains(2.0f));
        Assert.assertFalse(collection1.contains(3.0f));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void floatIterator_throws_non_empty_collection()
    {
        UnmodifiableFloatList collection = this.newWith(1.0f, 2.0f, 3.0f);
        FloatIterator iterator = collection.floatIterator();
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
    public void floatIterator_with_remove()
    {
        UnmodifiableFloatList unmodifiableFloatList = this.classUnderTest();
        MutableFloatIterator iterator = unmodifiableFloatList.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_remove_before_next()
    {
        UnmodifiableFloatList unmodifiableFloatList = this.classUnderTest();
        MutableFloatIterator iterator = unmodifiableFloatList.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
