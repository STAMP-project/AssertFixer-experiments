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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableShortCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableShortSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableShortHashSetTestCase extends AbstractImmutableShortCollectionTestCase
{
    @Override
    protected abstract ImmutableShortSet classUnderTest();

    @Override
    protected abstract ImmutableShortSet newWith(short... elements);

    @Override
    protected MutableShortSet newMutableCollectionWith(short... elements)
    {
        return ShortHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Short> newObjectCollectionWith(Short... elements)
    {
        return UnifiedSet.newSetWith(elements);
    }

    protected static ShortArrayList generateCollisions()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortHashSet set = new ShortHashSet();
        for (short i = (short) 32; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) == set.spreadAndMask((short) 32))
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
        Verify.assertSize(5, this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty()
    {
        super.isEmpty();
        Assert.assertFalse(this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze()
    {
        ImmutableShortSet immutableShortSet = this.classUnderTest();
        Assert.assertSame(immutableShortSet, immutableShortSet.freeze());
    }

    @Test
    public void toImmutable()
    {
        ImmutableShortSet immutableShortSet = this.classUnderTest();
        Assert.assertSame(immutableShortSet, immutableShortSet.toImmutable());
    }

    @Override
    @Test
    public void shortIterator()
    {
        MutableSet<Short> expected = UnifiedSet.newSetWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        MutableSet<Short> actual = UnifiedSet.newSet();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        ShortIterator iterator = set.shortIterator();
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
    public void shortIterator_throws()
    {
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        ShortIterator iterator = set.shortIterator();
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
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        set.forEach((short each) -> sum[0] += each);

        Assert.assertEquals(32L + AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableShortHashSetTestCase.generateCollisions().get(1), sum[0]);
    }

    @Override
    @Test
    public void count()
    {
        super.count();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(ShortPredicates.greaterThan((short) 0)));
        Assert.assertEquals(3L, set.count(ShortPredicates.lessThan((short) 32)));
        Assert.assertEquals(1L, set.count(ShortPredicates.greaterThan((short) 32)));
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(ShortPredicates.lessThan((short) 32)));
        Verify.assertSize(4, set.select(ShortPredicates.greaterThan((short) 0)));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(ShortPredicates.greaterThan((short) 0)));
        Verify.assertSize(2, set.reject(ShortPredicates.lessThan((short) 32)));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        super.detectIfNone();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals((short) 0, set.detectIfNone(ShortPredicates.lessThan((short) 1), (short) 9));
        Assert.assertEquals(AbstractImmutableShortHashSetTestCase.generateCollisions().get(1), set.detectIfNone(ShortPredicates.greaterThan(AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst()), (short) 9));
        Assert.assertEquals((short) 9, set.detectIfNone(ShortPredicates.greaterThan(AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)), (short) 9));
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith((short) -1, (short) 0, (short) 30, (short) (AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst() - 1), (short) (AbstractImmutableShortHashSetTestCase.generateCollisions().get(1) - 1)),
            set.collect(byteParameter -> (short) (byteParameter - 1)));
    }

    @Override
    @Test
    public void toSortedArray()
    {
        super.toSortedArray();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new short[]{(short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1)}, set.toSortedArray());
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        ImmutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        ImmutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        ImmutableShortSet set3 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1);
        ImmutableShortSet set4 = this.newWith((short) 32, (short) 32, (short) 31, (short) 1, (short) 1);
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
        ImmutableShortSet set1 = this.newWith((short) 1, (short) 31, (short) 32);
        ImmutableShortSet set2 = this.newWith((short) 32, (short) 31, (short) 1);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31), this.newWith((short) 0, (short) 1, (short) 31).toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31, (short) 32), this.newWith((short) 0, (short) 1, (short) 31, (short) 32).toBag());
    }

    @Override
    @Test
    public void asLazy()
    {
        super.asLazy();
        ImmutableShortSet set = this.newWith((short) 0, (short) 1, (short) 31, AbstractImmutableShortHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableShortHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, set.asLazy());
    }
}
