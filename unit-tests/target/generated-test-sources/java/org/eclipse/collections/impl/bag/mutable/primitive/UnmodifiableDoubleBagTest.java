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

import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleBag}.
 * This file was automatically generated from template file unmodifiablePrimitiveBagTest.stg.
 */
public class UnmodifiableDoubleBagTest extends AbstractMutableDoubleBagTestCase
{
    private final UnmodifiableDoubleBag bag = this.classUnderTest();

    @Override
    protected final UnmodifiableDoubleBag classUnderTest()
    {
        return new UnmodifiableDoubleBag(DoubleHashBag.newBagWith(1.0, 2.0, 3.0));
    }

    @Override
    protected UnmodifiableDoubleBag newWith(double... elements)
    {
        return new UnmodifiableDoubleBag(DoubleHashBag.newBagWith(elements));
    }

    @Override
    protected MutableDoubleBag newWithOccurrences(DoubleIntPair... elementsWithOccurrences)
    {
        MutableDoubleBag bag = DoubleBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            DoubleIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.asUnmodifiable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences()
    {
        this.bag.addOccurrences(1.0, 3);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences_throws()
    {
        this.newWith().addOccurrences(1.0, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences()
    {
        this.bag.removeOccurrences(1.0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences_throws()
    {
        this.newWith().removeOccurrences(1.0, -1);
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
        this.newWith().add(1.0);
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
        this.classUnderTest().remove(1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(DoublePredicates.equal(1.0));
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
        this.newWith().with(1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.newWith().withAll(this.newMutableCollectionWith(1.0));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.newWith(1.0, 2.0, 3.0, 4.0, 5.0).without(9.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.newWith(1.0, 2.0, 3.0, 4.0, 5.0).withoutAll(this.newMutableCollectionWith(8.0, 9.0));
    }

    @Override
    @Test
    public void contains()
    {
        UnmodifiableDoubleBag collection = this.newWith(14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertFalse(collection.contains(29.0));
        Assert.assertFalse(collection.contains(49.0));

        double[] numbers = {14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0};
        for (double number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains(-1.0));
        Assert.assertFalse(collection.contains(29.0));
        Assert.assertFalse(collection.contains(49.0));

        UnmodifiableDoubleBag collection1 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertTrue(collection1.contains(0.0));
        Assert.assertTrue(collection1.contains(1.0));
        Assert.assertTrue(collection1.contains(2.0));
        Assert.assertFalse(collection1.contains(3.0));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void doubleIterator_throws_non_empty_collection()
    {
        UnmodifiableDoubleBag collection = this.newWith(1.0, 2.0, 3.0);
        DoubleIterator iterator = collection.doubleIterator();
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
    public void doubleIterator_with_remove()
    {
        UnmodifiableDoubleBag unmodifiableDoubleBag = this.classUnderTest();
        MutableDoubleIterator iterator = unmodifiableDoubleBag.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void doubleIterator_throws_for_remove_before_next()
    {
        UnmodifiableDoubleBag unmodifiableDoubleBag = this.classUnderTest();
        MutableDoubleIterator iterator = unmodifiableDoubleBag.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void doubleIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
