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

import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleSet}.
 * This file was automatically generated from template file unmodifiablePrimitiveSetTest.stg.
 */
public class UnmodifiableDoubleSetTest extends AbstractDoubleSetTestCase
{
    @Override
    protected final UnmodifiableDoubleSet classUnderTest()
    {
        return new UnmodifiableDoubleSet(DoubleHashSet.newSetWith(1.0, 2.0, 3.0));
    }

    @Override
    protected UnmodifiableDoubleSet newWith(double... elements)
    {
        return new UnmodifiableDoubleSet(DoubleHashSet.newSetWith(elements));
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
        this.newWith().add(1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_NaN()
    {
        this.newWith(Double.NaN).add(Double.NaN);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_POSITIVE_INFINITY()
    {
        this.newWith(Double.POSITIVE_INFINITY).add(Double.POSITIVE_INFINITY);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add_NEGATIVE_INFINITY()
    {
        this.newWith(Double.NEGATIVE_INFINITY).add(Double.NEGATIVE_INFINITY);
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
        UnmodifiableDoubleSet set = this.newWith(14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertFalse(set.contains(29.0));
        Assert.assertFalse(set.contains(49.0));

        double[] numbers = {14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0};
        for (double number : numbers)
        {
            Assert.assertTrue(set.contains(number));
        }

        Assert.assertFalse(set.contains(-1.0));
        Assert.assertFalse(set.contains(29.0));
        Assert.assertFalse(set.contains(49.0));

        UnmodifiableDoubleSet set1 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertTrue(set1.contains(0.0));
        Assert.assertTrue(set1.contains(1.0));
        Assert.assertTrue(set1.contains(2.0));
        Assert.assertFalse(set1.contains(3.0));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void doubleIterator_throws_non_empty_collection()
    {
        UnmodifiableDoubleSet set = this.newWith(1.0, 2.0, 3.0);
        DoubleIterator iterator = set.doubleIterator();
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
        UnmodifiableDoubleSet set = this.classUnderTest();
        super.asUnmodifiable();
        Assert.assertSame(set, set.asUnmodifiable());
        Assert.assertEquals(set, set.asUnmodifiable());
    }

    @Override
    public void doubleIterator_with_remove()
    {
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void doubleIterator_throws_for_remove_before_next()
    {
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    public void doubleIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable
    }
}
