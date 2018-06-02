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

import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableFloatBag}.
 * This file was automatically generated from template file unmodifiablePrimitiveBagTest.stg.
 */
public class UnmodifiableFloatBagTest extends AbstractMutableFloatBagTestCase
{
    private final UnmodifiableFloatBag bag = this.classUnderTest();

    @Override
    protected final UnmodifiableFloatBag classUnderTest()
    {
        return new UnmodifiableFloatBag(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f));
    }

    @Override
    protected UnmodifiableFloatBag newWith(float... elements)
    {
        return new UnmodifiableFloatBag(FloatHashBag.newBagWith(elements));
    }

    @Override
    protected MutableFloatBag newWithOccurrences(FloatIntPair... elementsWithOccurrences)
    {
        MutableFloatBag bag = FloatBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            FloatIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.asUnmodifiable();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences()
    {
        this.bag.addOccurrences(1.0f, 3);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addOccurrences_throws()
    {
        this.newWith().addOccurrences(1.0f, -1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences()
    {
        this.bag.removeOccurrences(1.0f, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeOccurrences_throws()
    {
        this.newWith().removeOccurrences(1.0f, -1);
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
    @Test
    public void contains()
    {
        UnmodifiableFloatBag collection = this.newWith(14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f);
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

        UnmodifiableFloatBag collection1 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Assert.assertTrue(collection1.contains(0.0f));
        Assert.assertTrue(collection1.contains(1.0f));
        Assert.assertTrue(collection1.contains(2.0f));
        Assert.assertFalse(collection1.contains(3.0f));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void floatIterator_throws_non_empty_collection()
    {
        UnmodifiableFloatBag collection = this.newWith(1.0f, 2.0f, 3.0f);
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
        Assert.assertSame(this.bag, this.bag.asUnmodifiable());
        Assert.assertEquals(this.bag, this.bag.asUnmodifiable());
    }

    @Override
    @Test
    public void floatIterator_with_remove()
    {
        UnmodifiableFloatBag unmodifiableFloatBag = this.classUnderTest();
        MutableFloatIterator iterator = unmodifiableFloatBag.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_remove_before_next()
    {
        UnmodifiableFloatBag unmodifiableFloatBag = this.classUnderTest();
        MutableFloatIterator iterator = unmodifiableFloatBag.floatIterator();
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
