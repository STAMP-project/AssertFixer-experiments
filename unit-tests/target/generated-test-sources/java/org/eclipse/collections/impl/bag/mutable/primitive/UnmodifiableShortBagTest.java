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

import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortBag}.
 * This file was automatically generated from template file unmodifiablePrimitiveBagTest.stg.
 */
public class UnmodifiableShortBagTest extends AbstractMutableShortBagTestCase
{
    private final UnmodifiableShortBag bag = this.classUnderTest();

    @Override
    protected final UnmodifiableShortBag classUnderTest()
    {
        return new UnmodifiableShortBag(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3));
    }

    @Override
    protected UnmodifiableShortBag newWith(short... elements)
    {
        return new UnmodifiableShortBag(ShortHashBag.newBagWith(elements));
    }

    @Override
    protected MutableShortBag newWithOccurrences(ShortIntPair... elementsWithOccurrences)
    {
        MutableShortBag bag = ShortBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            ShortIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.asUnmodifiable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences()
    {
        this.bag.addOccurrences((short) 1, 3);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences_throws()
    {
        this.newWith().addOccurrences((short) 1, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences()
    {
        this.bag.removeOccurrences((short) 1, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences_throws()
    {
        this.newWith().removeOccurrences((short) 1, -1);
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
        UnmodifiableShortBag collection = this.newWith((short) 14, (short) 2, (short) 30, (short) 31, (short) 32, (short) 35, (short) 0, (short) 1);
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

        UnmodifiableShortBag collection1 = this.newWith((short) 0, (short) 1, (short) 1, (short) 2, (short) 2, (short) 2);
        Assert.assertTrue(collection1.contains((short) 0));
        Assert.assertTrue(collection1.contains((short) 1));
        Assert.assertTrue(collection1.contains((short) 2));
        Assert.assertFalse(collection1.contains((short) 3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void shortIterator_throws_non_empty_collection()
    {
        UnmodifiableShortBag collection = this.newWith((short) 1, (short) 2, (short) 3);
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
        Assert.assertSame(this.bag, this.bag.asUnmodifiable());
        Assert.assertEquals(this.bag, this.bag.asUnmodifiable());
    }

    @Override
    @Test
    public void shortIterator_with_remove()
    {
        UnmodifiableShortBag unmodifiableShortBag = this.classUnderTest();
        MutableShortIterator iterator = unmodifiableShortBag.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void shortIterator_throws_for_remove_before_next()
    {
        UnmodifiableShortBag unmodifiableShortBag = this.classUnderTest();
        MutableShortIterator iterator = unmodifiableShortBag.shortIterator();
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
