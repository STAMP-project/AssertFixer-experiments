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

import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableFloatCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableFloatSet}.
 * This file was automatically generated from template file abstractImmutablePrimitiveSetTestCase.stg.
 */
public abstract class AbstractImmutableFloatHashSetTestCase extends AbstractImmutableFloatCollectionTestCase
{
    @Override
    protected abstract ImmutableFloatSet classUnderTest();

    @Override
    protected abstract ImmutableFloatSet newWith(float... elements);

    @Override
    protected MutableFloatSet newMutableCollectionWith(float... elements)
    {
        return FloatHashSet.newSetWith(elements);
    }

    @Override
    protected MutableSet<Float> newObjectCollectionWith(Float... elements)
    {
        return UnifiedSet.newSetWith(elements);
    }

    protected static FloatArrayList generateCollisions()
    {
        FloatArrayList collisions = new FloatArrayList();
        FloatHashSet set = new FloatHashSet();
        for (float i = 32.0f; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) == set.spreadAndMask(32.0f))
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
        Verify.assertSize(5, this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)));
    }

    @Override
    @Test
    public void isEmpty()
    {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)).notEmpty());
    }

    @Test
    public void freeze()
    {
        ImmutableFloatSet immutableFloatSet = this.classUnderTest();
        Assert.assertSame(immutableFloatSet, immutableFloatSet.freeze());
    }

    @Test
    public void toImmutable()
    {
        ImmutableFloatSet immutableFloatSet = this.classUnderTest();
        Assert.assertSame(immutableFloatSet, immutableFloatSet.toImmutable());
    }

    @Override
    @Test
    public void floatIterator()
    {
        MutableSet<Float> expected = UnifiedSet.newSetWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        MutableSet<Float> actual = UnifiedSet.newSet();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        FloatIterator iterator = set.floatIterator();
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
    public void floatIterator_throws()
    {
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        FloatIterator iterator = set.floatIterator();
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
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        set.forEach((float each) -> sum[0] += each);

        Assert.assertEquals(32L + AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst() + AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1), sum[0], 0.0f);
    }

    @Override
    @Test
    public void count()
    {
        super.count();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(4L, set.count(FloatPredicates.greaterThan(0.0f)));
        Assert.assertEquals(3L, set.count(FloatPredicates.lessThan(32.0f)));
        Assert.assertEquals(1L, set.count(FloatPredicates.greaterThan(32.0f)));
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(3, set.select(FloatPredicates.lessThan(32.0f)));
        Verify.assertSize(4, set.select(FloatPredicates.greaterThan(0.0f)));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Verify.assertSize(1, set.reject(FloatPredicates.greaterThan(0.0f)));
        Verify.assertSize(2, set.reject(FloatPredicates.lessThan(32.0f)));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        super.detectIfNone();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0f, set.detectIfNone(FloatPredicates.lessThan(1.0f), 9.0f), 0.0f);
        Assert.assertEquals(AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1), set.detectIfNone(FloatPredicates.greaterThan(AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst()), 9.0f), 0.0f);
        Assert.assertEquals(9.0f, set.detectIfNone(FloatPredicates.greaterThan(AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)), 9.0f), 0.0f);
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(UnifiedSet.newSetWith(-1.0f, 0.0f, 30.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst() - 1, AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1) - 1),
            set.collect(byteParameter -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray()
    {
        super.toSortedArray();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertArrayEquals(new float[]{0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1)}, set.toSortedArray(), 0.0f);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        ImmutableFloatSet set1 = this.newWith(1.0f, 31.0f, 32.0f);
        ImmutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f);
        ImmutableFloatSet set3 = this.newWith(32.0f, 32.0f, 31.0f, 1.0f);
        ImmutableFloatSet set4 = this.newWith(32.0f, 32.0f, 31.0f, 1.0f, 1.0f);
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
        ImmutableFloatSet set1 = this.newWith(1.0f, 31.0f, 32.0f);
        ImmutableFloatSet set2 = this.newWith(32.0f, 31.0f, 1.0f);
        Assert.assertEquals(set1.hashCode(), set2.hashCode());
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 31.0f), this.newWith(0.0f, 1.0f, 31.0f).toBag());
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 31.0f, 32.0f), this.newWith(0.0f, 1.0f, 31.0f, 32.0f).toBag());
    }

    @Override
    @Test
    public void asLazy()
    {
        super.asLazy();
        ImmutableFloatSet set = this.newWith(0.0f, 1.0f, 31.0f, AbstractImmutableFloatHashSetTestCase.generateCollisions().getFirst(), AbstractImmutableFloatHashSetTestCase.generateCollisions().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyFloatIterable.class, set.asLazy());
    }
}
