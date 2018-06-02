/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.bag.primitive.MutableByteBag;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteBag}.
 * This file was automatically generated from template file unmodifiablePrimitiveBagTest.stg.
 */
public class UnmodifiableByteBagTest extends AbstractMutableByteBagTestCase
{
    private final UnmodifiableByteBag bag = this.classUnderTest();

    @Override
    protected final UnmodifiableByteBag classUnderTest()
    {
        return new UnmodifiableByteBag(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3));
    }

    @Override
    protected UnmodifiableByteBag newWith(byte... elements)
    {
        return new UnmodifiableByteBag(ByteHashBag.newBagWith(elements));
    }

    @Override
    protected MutableByteBag newWithOccurrences(ByteIntPair... elementsWithOccurrences)
    {
        MutableByteBag bag = ByteBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            ByteIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.asUnmodifiable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences()
    {
        this.bag.addOccurrences((byte) 1, 3);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences_throws()
    {
        this.newWith().addOccurrences((byte) 1, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences()
    {
        this.bag.removeOccurrences((byte) 1, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences_throws()
    {
        this.newWith().removeOccurrences((byte) 1, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        this.bag.clear();
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
    @Test
    public void contains()
    {
        UnmodifiableByteBag collection = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
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

        UnmodifiableByteBag collection1 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Assert.assertTrue(collection1.contains((byte) 0));
        Assert.assertTrue(collection1.contains((byte) 1));
        Assert.assertTrue(collection1.contains((byte) 2));
        Assert.assertFalse(collection1.contains((byte) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void byteIterator_throws_non_empty_collection()
    {
        UnmodifiableByteBag collection = this.newWith((byte) 1, (byte) 2, (byte) 3);
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
        Assert.assertSame(this.bag, this.bag.asUnmodifiable());
        Assert.assertEquals(this.bag, this.bag.asUnmodifiable());
    }

    @Override
    @Test
    public void byteIterator_with_remove()
    {
        UnmodifiableByteBag unmodifiableByteBag = this.classUnderTest();
        MutableByteIterator iterator = unmodifiableByteBag.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void byteIterator_throws_for_remove_before_next()
    {
        UnmodifiableByteBag unmodifiableByteBag = this.classUnderTest();
        MutableByteIterator iterator = unmodifiableByteBag.byteIterator();
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
