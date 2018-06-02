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

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntBag}.
 * This file was automatically generated from template file unmodifiablePrimitiveBagTest.stg.
 */
public class UnmodifiableIntBagTest extends AbstractMutableIntBagTestCase
{
    private final UnmodifiableIntBag bag = this.classUnderTest();

    @Override
    protected final UnmodifiableIntBag classUnderTest()
    {
        return new UnmodifiableIntBag(IntHashBag.newBagWith(1, 2, 3));
    }

    @Override
    protected UnmodifiableIntBag newWith(int... elements)
    {
        return new UnmodifiableIntBag(IntHashBag.newBagWith(elements));
    }

    @Override
    protected MutableIntBag newWithOccurrences(IntIntPair... elementsWithOccurrences)
    {
        MutableIntBag bag = IntBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            IntIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.asUnmodifiable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences()
    {
        this.bag.addOccurrences(1, 3);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences_throws()
    {
        this.newWith().addOccurrences(1, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences()
    {
        this.bag.removeOccurrences(1, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences_throws()
    {
        this.newWith().removeOccurrences(1, -1);
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
        this.newWith().add(1);
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
        this.classUnderTest().remove(1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(IntPredicates.equal(1));
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
        this.newWith().with(1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.newWith().withAll(this.newMutableCollectionWith(1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.newWith(1, 2, 3, 4, 5).without(9);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.newWith(1, 2, 3, 4, 5).withoutAll(this.newMutableCollectionWith(8, 9));
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableIntBag collection = this.newWith(14, 2, 30, 31, 32, 35, 0, 1);
        Assert.assertFalse(collection.contains(29));
        Assert.assertFalse(collection.contains(49));

        int[] numbers = {14, 2, 30, 31, 32, 35, 0, 1};
        for (int number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains(-1));
        Assert.assertFalse(collection.contains(29));
        Assert.assertFalse(collection.contains(49));

        UnmodifiableIntBag collection1 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertTrue(collection1.contains(0));
        Assert.assertTrue(collection1.contains(1));
        Assert.assertTrue(collection1.contains(2));
        Assert.assertFalse(collection1.contains(3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void intIterator_throws_non_empty_collection()
    {
        UnmodifiableIntBag collection = this.newWith(1, 2, 3);
        IntIterator iterator = collection.intIterator();
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
    public void intIterator_with_remove()
    {
        UnmodifiableIntBag unmodifiableIntBag = this.classUnderTest();
        MutableIntIterator iterator = unmodifiableIntBag.intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void intIterator_throws_for_remove_before_next()
    {
        UnmodifiableIntBag unmodifiableIntBag = this.classUnderTest();
        MutableIntIterator iterator = unmodifiableIntBag.intIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void intIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
