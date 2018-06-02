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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableLongSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableLongCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableLongSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableLongHashSetTestCase extends AbstractImmutableLongCollectionTestCase
{
    @Override
    protected abstract ImmutableLongSet classUnderTest();

    @Override
    protected abstract ImmutableLongSet newWith(long... elements);

    @Override
    protected MutableLongSet newMutableCollectionWith(long... elements)
    {
        return LongHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Long> newObjectCollectionWith(Long... elements)
    {
        return UnifiedSet.newSetWith(elements);
    }

    protected static LongArrayList generateCollisions()
    {
        LongArrayList collisions = new LongArrayList();
        LongHashSet set = new LongHashSet();
        for (long i = 32L; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) == set.spreadAndMask(32L))
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
        Verify.assertSize(5, this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty()
    {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze()
    {
        ImmutableLongSet immutableLongSet = this.classUnderTest();
        Assert.assertSame(immutableLongSet, immutableLongSet.freeze());
    }

    @Test
    public void toImmutable()
    {
        ImmutableLongSet immutableLongSet = this.classUnderTest();
        Assert.assertSame(immutableLongSet, immutableLongSet.toImmutable());
    }

    @Override
    @Test
    public void longIterator()
    {
        MutableSet<Long> expected = UnifiedSet.newSetWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        MutableSet<Long> actual = UnifiedSet.newSet();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        LongIterator iterator = set.longIterator();
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
    public void longIterator_throws()
    {
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        LongIterator iterator = set.longIterator();
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
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        set.forEach((long each) -> sum[0] += each);

        Assert.assertEquals(32L + AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableLongHashSetTestCase.generateCollisions().get(1), sum[0]);
    }

    @Override
    @Test
    public void count()
    {
        super.count();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(LongPredicates.greaterThan(0L)));
        Assert.assertEquals(3L, set.count(LongPredicates.lessThan(32L)));
        Assert.assertEquals(1L, set.count(LongPredicates.greaterThan(32L)));
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(LongPredicates.lessThan(32L)));
        Verify.assertSize(4, set.select(LongPredicates.greaterThan(0L)));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(LongPredicates.greaterThan(0L)));
        Verify.assertSize(2, set.reject(LongPredicates.lessThan(32L)));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        super.detectIfNone();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, set.detectIfNone(LongPredicates.lessThan(1L), 9L));
        Assert.assertEquals(AbstractImmutableLongHashSetTestCase.generateCollisions().get(1), set.detectIfNone(LongPredicates.greaterThan(AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst()), 9L));
        Assert.assertEquals(9L, set.detectIfNone(LongPredicates.greaterThan(AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)), 9L));
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1L, 0L, 30L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst() - 1, AbstractImmutableLongHashSetTestCase.generateCollisions().get(1) - 1),
            set.collect(byteParameter -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray()
    {
        super.toSortedArray();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new long[]{0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1)}, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        ImmutableLongSet set1 = this.newWith(1L, 31L, 32L);
        ImmutableLongSet set2 = this.newWith(32L, 31L, 1L);
        ImmutableLongSet set3 = this.newWith(32L, 32L, 31L, 1L);
        ImmutableLongSet set4 = this.newWith(32L, 32L, 31L, 1L, 1L);
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
        ImmutableLongSet set1 = this.newWith(1L, 31L, 32L);
        ImmutableLongSet set2 = this.newWith(32L, 31L, 1L);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), this.classUnderTest().toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 31L), this.newWith(0L, 1L, 31L).toBag());
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 31L, 32L), this.newWith(0L, 1L, 31L, 32L).toBag());
    }

    @Override
    @Test
    public void asLazy()
    {
        super.asLazy();
        ImmutableLongSet set = this.newWith(0L, 1L, 31L, AbstractImmutableLongHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableLongHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, set.asLazy());
    }
}
