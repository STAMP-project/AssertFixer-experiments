/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntSet}.
 * This file was automatically generated from template file unmodifiablePrimitiveSetTest.stg.
 */
public class UnmodifiableIntSetTest extends AbstractIntSetTestCase
{
    @Override
    protected final UnmodifiableIntSet classUnderTest()
    {
        return new UnmodifiableIntSet(IntHashSet.newSetWith(1, 2, 3));
    }

    @Override
    protected UnmodifiableIntSet newWith(int... elements)
    {
        return new UnmodifiableIntSet(IntHashSet.newSetWith(elements));
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
        UnmodifiableIntSet set = this.newWith(14, 2, 30, 31, 32, 35, 0, 1);
        Assert.assertFalse(set.contains(29));
        Assert.assertFalse(set.contains(49));

        int[] numbers = {14, 2, 30, 31, 32, 35, 0, 1};
        for (int number : numbers)
        {
            Assert.assertTrue(set.contains(number));
        }

        Assert.assertFalse(set.contains(-1));
        Assert.assertFalse(set.contains(29));
        Assert.assertFalse(set.contains(49));

        UnmodifiableIntSet set1 = this.newWith(0, 1, 1, 2, 2, 2);
        Assert.assertTrue(set1.contains(0));
        Assert.assertTrue(set1.contains(1));
        Assert.assertTrue(set1.contains(2));
        Assert.assertFalse(set1.contains(3));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void intIterator_throws_non_empty_collection()
    {
        UnmodifiableIntSet set = this.newWith(1, 2, 3);
        IntIterator iterator = set.intIterator();
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
        UnmodifiableIntSet set = this.classUnderTest();
        super.asUnmodifiable();
        Assert.assertSame(set, set.asUnmodifiable());
        Assert.assertEquals(set, set.asUnmodifiable());
    }

    @Override
    public void intIterator_with_remove()
    {
        MutableIntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void intIterator_throws_for_remove_before_next()
    {
        MutableIntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void intIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable
    }
}
