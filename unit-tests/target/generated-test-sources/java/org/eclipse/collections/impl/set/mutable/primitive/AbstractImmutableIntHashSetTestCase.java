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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableIntCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableIntHashSetTestCase extends AbstractImmutableIntCollectionTestCase
{
    @Override
    protected abstract ImmutableIntSet classUnderTest();

    @Override
    protected abstract ImmutableIntSet newWith(int... elements);

    @Override
    protected MutableIntSet newMutableCollectionWith(int... elements)
    {
        return IntHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Integer> newObjectCollectionWith(Integer... elements)
    {
        return UnifiedSet.newSetWith(elements);
    }

    protected static IntArrayList generateCollisions()
    {
        IntArrayList collisions = new IntArrayList();
        IntHashSet set = new IntHashSet();
        for (int i = 32; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) == set.spreadAndMask(32))
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
        Verify.assertSize(5, this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty()
    {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze()
    {
        ImmutableIntSet immutableIntSet = this.classUnderTest();
        Assert.assertSame(immutableIntSet, immutableIntSet.freeze());
    }

    @Test
    public void toImmutable()
    {
        ImmutableIntSet immutableIntSet = this.classUnderTest();
        Assert.assertSame(immutableIntSet, immutableIntSet.toImmutable());
    }

    @Override
    @Test
    public void intIterator()
    {
        MutableSet<Integer> expected = UnifiedSet.newSetWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        MutableSet<Integer> actual = UnifiedSet.newSet();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        IntIterator iterator = set.intIterator();
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
    public void intIterator_throws()
    {
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        IntIterator iterator = set.intIterator();
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
        long[] sum = new long[1];
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        set.forEach((int each) -> sum[0] += each);

        Assert.assertEquals(32L + AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableIntHashSetTestCase.generateCollisions().get(1), sum[0]);
    }

    @Override
    @Test
    public void count()
    {
        super.count();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(IntPredicates.greaterThan(0)));
        Assert.assertEquals(3L, set.count(IntPredicates.lessThan(32)));
        Assert.assertEquals(1L, set.count(IntPredicates.greaterThan(32)));
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(IntPredicates.lessThan(32)));
        Verify.assertSize(4, set.select(IntPredicates.greaterThan(0)));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(IntPredicates.greaterThan(0)));
        Verify.assertSize(2, set.reject(IntPredicates.lessThan(32)));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        super.detectIfNone();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(0, set.detectIfNone(IntPredicates.lessThan(1), 9));
        Assert.assertEquals(AbstractImmutableIntHashSetTestCase.generateCollisions().get(1), set.detectIfNone(IntPredicates.greaterThan(AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst()), 9));
        Assert.assertEquals(9, set.detectIfNone(IntPredicates.greaterThan(AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)), 9));
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1, 0, 30, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst() - 1, AbstractImmutableIntHashSetTestCase.generateCollisions().get(1) - 1),
            set.collect(byteParameter -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray()
    {
        super.toSortedArray();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new int[]{0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1)}, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        ImmutableIntSet set1 = this.newWith(1, 31, 32);
        ImmutableIntSet set2 = this.newWith(32, 31, 1);
        ImmutableIntSet set3 = this.newWith(32, 32, 31, 1);
        ImmutableIntSet set4 = this.newWith(32, 32, 31, 1, 1);
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
        ImmutableIntSet set1 = this.newWith(1, 31, 32);
        ImmutableIntSet set2 = this.newWith(32, 31, 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), this.classUnderTest().toBag());
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 31), this.newWith(0, 1, 31).toBag());
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 31, 32), this.newWith(0, 1, 31, 32).toBag());
    }

    @Override
    @Test
    public void asLazy()
    {
        super.asLazy();
        ImmutableIntSet set = this.newWith(0, 1, 31, AbstractImmutableIntHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableIntHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, set.asLazy());
    }
}
