/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableDoubleHashSetTestCase extends AbstractImmutableDoubleCollectionTestCase
{
    @Override
    protected abstract ImmutableDoubleSet classUnderTest();

    @Override
    protected abstract ImmutableDoubleSet newWith(double... elements);

    @Override
    protected MutableDoubleSet newMutableCollectionWith(double... elements)
    {
        return DoubleHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Double> newObjectCollectionWith(Double... elements)
    {
        return UnifiedSet.newSetWith(elements);
    }

    protected static DoubleArrayList generateCollisions()
    {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleHashSet set = new DoubleHashSet();
        for (double i = 32.0; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) == set.spreadAndMask(32.0))
            {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(5, this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty()
    {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze()
    {
        ImmutableDoubleSet immutableDoubleSet = this.classUnderTest();
        Assert.assertSame(immutableDoubleSet, immutableDoubleSet.freeze());
    }

    @Test
    public void toImmutable()
    {
        ImmutableDoubleSet immutableDoubleSet = this.classUnderTest();
        Assert.assertSame(immutableDoubleSet, immutableDoubleSet.toImmutable());
    }

    @Override
    @Test
    public void doubleIterator()
    {
        MutableSet<Double> expected = UnifiedSet.newSetWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        MutableSet<Double> actual = UnifiedSet.newSet();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        DoubleIterator iterator = set.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void doubleIterator_throws()
    {
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        DoubleIterator iterator = set.doubleIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Override
    @Test
    public void forEach()
    {
        super.forEach();
        double[] sum = new double[1];
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        set.forEach((double each) -> sum[0] += each);

        Assert.assertEquals(32L + AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1), sum[0], 0.0);
    }

    @Override
    @Test
    public void count()
    {
        super.count();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(DoublePredicates.greaterThan(0.0)));
        Assert.assertEquals(3L, set.count(DoublePredicates.lessThan(32.0)));
        Assert.assertEquals(1L, set.count(DoublePredicates.greaterThan(32.0)));
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(DoublePredicates.lessThan(32.0)));
        Verify.assertSize(4, set.select(DoublePredicates.greaterThan(0.0)));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(DoublePredicates.greaterThan(0.0)));
        Verify.assertSize(2, set.reject(DoublePredicates.lessThan(32.0)));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        super.detectIfNone();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, set.detectIfNone(DoublePredicates.lessThan(1.0), 9.0), 0.0);
        Assert.assertEquals(AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1), set.detectIfNone(DoublePredicates.greaterThan(AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst()), 9.0), 0.0);
        Assert.assertEquals(9.0, set.detectIfNone(DoublePredicates.greaterThan(AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)), 9.0), 0.0);
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1.0, 0.0, 30.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst() - 1, AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1) - 1),
            set.collect(byteParameter -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray()
    {
        super.toSortedArray();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new double[]{0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1)}, set.toSortedArray(), 0.0);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        ImmutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        ImmutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        ImmutableDoubleSet set3 = this.newWith(32.0, 32.0, 31.0, 1.0);
        ImmutableDoubleSet set4 = this.newWith(32.0, 32.0, 31.0, 1.0, 1.0);
        Verify.assertEqualsAndHashCode(set1, set2);
        Verify.assertEqualsAndHashCode(set1, set3);
        Verify.assertEqualsAndHashCode(set1, set4);
        Verify.assertEqualsAndHashCode(set2, set3);
        Verify.assertEqualsAndHashCode(set2, set4);
    }

    @Override
    @Test
    public void testHashCode()
    {
        super.testHashCode();
        ImmutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        ImmutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), this.classUnderTest().toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0), this.newWith(0.0, 1.0, 31.0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0, 32.0), this.newWith(0.0, 1.0, 31.0, 32.0).toBag());
    }

    @Override
    @Test
    public void asLazy()
    {
        super.asLazy();
        ImmutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractImmutableDoubleHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableDoubleHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, set.asLazy());
    }
}
