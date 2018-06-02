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

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableDoubleSet}.
 * This file was automatically generated from template file abstractPrimitiveSetTestCase.stg.
 */
public abstract class AbstractDoubleSetTestCase extends AbstractMutableDoubleCollectionTestCase
{
    protected static DoubleArrayList generateCollisions1()
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

    private static DoubleArrayList generateNonCollisions()
    {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleHashSet set = new DoubleHashSet();
        for (double i = 32.0; collisions.size() <= 10; i++)
        {
            if (set.spreadAndMask(i) != set.spreadAndMask(32.0))
            {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Override
    protected abstract MutableDoubleSet classUnderTest();

    @Override
    protected abstract MutableDoubleSet newWith(double... elements);

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

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(5, this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void isEmpty()
    {
        super.isEmpty();
        Assert.assertFalse(this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)).isEmpty());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)).notEmpty());
    }

    @Override
    @Test
    public void clear()
    {
        super.clear();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        set.clear();
        Verify.assertSize(0, set);
        Assert.assertFalse(set.contains(0.0));
        Assert.assertFalse(set.contains(31.0));
        Assert.assertFalse(set.contains(1.0));
        Assert.assertFalse(set.contains(AbstractDoubleSetTestCase.generateCollisions1().getFirst()));
        Assert.assertFalse(set.contains(AbstractDoubleSetTestCase.generateCollisions1().get(1)));
    }

    @Override
    @Test
    public void add()
    {
        super.add();
        MutableDoubleSet set = this.newWith();
        Assert.assertTrue(set.add(14.0));
        Assert.assertFalse(set.add(14.0));
        Assert.assertTrue(set.add(2.0));
        Assert.assertFalse(set.add(2.0));
        Assert.assertTrue(set.add(35.0));
        Assert.assertFalse(set.add(35.0));
        Assert.assertTrue(set.add(31.0));
        Assert.assertFalse(set.add(31.0));
        Assert.assertTrue(set.add(32.0));
        Assert.assertFalse(set.add(32.0));
        Assert.assertTrue(set.add(0.0));
        Assert.assertFalse(set.add(0.0));
        Assert.assertTrue(set.add(1.0));
        Assert.assertFalse(set.add(1.0));
    }

@Test
public void add_NaN()
{
    MutableDoubleSet set = this.newWith(Double.NaN);
    Set<Double> hashSet = new HashSet<>();
    Assert.assertTrue(hashSet.add(Double.NaN));

    Assert.assertFalse(hashSet.add(Double.NaN));
    Assert.assertFalse(set.add(Double.NaN));
    Verify.assertSize(hashSet.size(), set);
}

    @Test
    public void add_POSITIVE_INFINITY()
    {
        MutableDoubleSet set = this.newWith(Double.POSITIVE_INFINITY);
        Set<Double> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Double.POSITIVE_INFINITY));

        Assert.assertFalse(hashSet.add(Double.POSITIVE_INFINITY));
        Assert.assertFalse(set.add(Double.POSITIVE_INFINITY));
        Verify.assertSize(hashSet.size(), set);
    }

    @Test
    public void add_NEGATIVE_INFINITY()
    {
        MutableDoubleSet set = this.newWith(Double.NEGATIVE_INFINITY);
        Set<Double> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Double.NEGATIVE_INFINITY));

        Assert.assertFalse(hashSet.add(Double.NEGATIVE_INFINITY));
        Assert.assertFalse(set.add(Double.NEGATIVE_INFINITY));
        Verify.assertSize(hashSet.size(), set);
    }

    @Override
    @Test
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.addAll(new DoubleArrayList()));
        Assert.assertFalse(set.addAll(DoubleArrayList.newListWith(31.0, AbstractDoubleSetTestCase.generateCollisions1().get(0), AbstractDoubleSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);

        Assert.assertTrue(set.addAll(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 30.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 30.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1), AbstractDoubleSetTestCase.generateCollisions1().get(4)), set);

        Assert.assertTrue(set.addAll(DoubleHashSet.newSetWith(5.0)));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 5.0, 30.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1), AbstractDoubleSetTestCase.generateCollisions1().get(4)), set);

        Assert.assertTrue(set.addAll(DoubleHashSet.newSetWith(AbstractDoubleSetTestCase.generateCollisions1().get(5))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 5.0, 30.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1), AbstractDoubleSetTestCase.generateCollisions1().get(4), AbstractDoubleSetTestCase.generateCollisions1().get(5)), set);

        DoubleHashSet set1 = new DoubleHashSet();
        Assert.assertTrue(set1.addAll(2.0, 35.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(2.0, 35.0), set1);
    }

    @Test
    public void testOfAllFactory()
    {
        Assert.assertEquals(
            DoubleHashSet.newSetWith(0.0, 1.0, 2.0, 5.0, 30.0, 31.0),
            DoubleSets.mutable.ofAll(DoubleHashBag.newBagWith(0.0, 1.0, 2.0, 5.0, 30.0, 31.0, 0.0, 1.0, 2.0, 5.0, 30.0, 31.0)));
    }

    @Override
    @Test
    public void remove()
    {
        super.remove();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(this.newWith().remove(15.0));
        Assert.assertFalse(set.remove(15.0));
        Assert.assertTrue(set.remove(0.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertFalse(set.remove(AbstractDoubleSetTestCase.generateNonCollisions().getFirst()));
        Assert.assertFalse(set.remove(AbstractDoubleSetTestCase.generateCollisions1().get(3)));
        Assert.assertTrue(set.remove(AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst()), set);
        Assert.assertTrue(set.remove(AbstractDoubleSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 31.0), set);
        Assert.assertTrue(set.remove(31.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), set);
        Assert.assertTrue(set.remove(1.0));
        Assert.assertEquals(DoubleHashSet.newSetWith(), set);
    }

    @Override
    @Test
    public void removeAll()
    {
        super.removeAll();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll());
        Assert.assertFalse(set.removeAll(15.0, AbstractDoubleSetTestCase.generateCollisions1().get(2), AbstractDoubleSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(3)));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(new DoubleHashSet(), set);
        Assert.assertFalse(set.removeAll(1.0));
        Assert.assertEquals(new DoubleHashSet(), set);
    }

    @Override
    @Test
    public void removeAll_iterable()
    {
        super.removeAll_iterable();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.removeAll(new DoubleArrayList()));
        Assert.assertFalse(set.removeAll(DoubleArrayList.newListWith(15.0, AbstractDoubleSetTestCase.generateCollisions1().get(2), AbstractDoubleSetTestCase.generateCollisions1().get(3))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(DoubleHashSet.newSetWith(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(4))));
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.removeAll(DoubleHashSet.newSetWith(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(new DoubleHashSet(), set);
        Assert.assertFalse(set.removeAll(DoubleHashSet.newSetWith(1.0)));
        Assert.assertEquals(new DoubleHashSet(), set);
    }

    @Override
    @Test
    public void retainAll()
    {
        super.retainAll();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(4), AbstractDoubleSetTestCase.generateCollisions1().get(1)));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst()));
        Assert.assertEquals(new DoubleHashSet(), set);
        Assert.assertFalse(set.retainAll(1.0));
        Assert.assertEquals(new DoubleHashSet(), set);
    }

    @Override
    @Test
    public void retainAll_iterable()
    {
        super.retainAll_iterable();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertFalse(set.retainAll(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(DoubleHashSet.newSetWith(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(4), AbstractDoubleSetTestCase.generateCollisions1().get(1))));
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().get(1)), set);
        Assert.assertTrue(set.retainAll(DoubleHashSet.newSetWith(1.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst())));
        Assert.assertEquals(new DoubleHashSet(), set);
        Assert.assertFalse(set.retainAll(DoubleHashSet.newSetWith(1.0)));
        Assert.assertEquals(new DoubleHashSet(), set);
    }

    @Override
    @Test
    public void doubleIterator()
    {
        MutableSet<Double> expected = UnifiedSet.newSetWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        MutableSet<Double> actual = UnifiedSet.newSet();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
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
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        DoubleIterator iterator = set.doubleIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        MutableDoubleSet set = this.newWith(0.0, 2.0, 31.0);
        Double sum = set.injectInto(Double.valueOf(0.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(33.0), sum);
    }

    @Override
    @Test
    public void forEach()
    {
        super.forEach();
        double[] sum = new double[1];
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        set.forEach((double each) -> sum[0] += each);

        Assert.assertEquals(32L + AbstractDoubleSetTestCase.generateCollisions1().getFirst() + AbstractDoubleSetTestCase.generateCollisions1().get(1), sum[0], 0.0);
    }

    @Override
    @Test
    public void count()
    {
        super.count();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(4L, set.count(DoublePredicates.greaterThan(0.0)));
        Assert.assertEquals(3L, set.count(DoublePredicates.lessThan(32.0)));
        Assert.assertEquals(1L, set.count(DoublePredicates.greaterThan(32.0)));
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(3, set.select(DoublePredicates.lessThan(32.0)));
        Verify.assertSize(4, set.select(DoublePredicates.greaterThan(0.0)));
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Verify.assertSize(1, set.reject(DoublePredicates.greaterThan(0.0)));
        Verify.assertSize(2, set.reject(DoublePredicates.lessThan(32.0)));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        super.detectIfNone();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(0.0, set.detectIfNone(DoublePredicates.lessThan(1.0), 9.0), 0.0);
        Assert.assertEquals(AbstractDoubleSetTestCase.generateCollisions1().get(1), set.detectIfNone(DoublePredicates.greaterThan(AbstractDoubleSetTestCase.generateCollisions1().getFirst()), 9.0), 0.0);
        Assert.assertEquals(9.0, set.detectIfNone(DoublePredicates.greaterThan(AbstractDoubleSetTestCase.generateCollisions1().get(1)), 9.0), 0.0);
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(
            UnifiedSet.newSetWith(-1.0, 0.0, 30.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst() - 1, AbstractDoubleSetTestCase.generateCollisions1().get(1) - 1),
            set.collect((double byteParameter) -> byteParameter - 1));
    }

    @Override
    @Test
    public void toSortedArray()
    {
        super.toSortedArray();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertArrayEquals(new double[]{0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1)}, set.toSortedArray(), 0.0);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        MutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        MutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
        MutableDoubleSet set3 = this.newWith(32.0, 32.0, 31.0, 1.0);
        MutableDoubleSet set4 = this.newWith(32.0, 32.0, 31.0, 1.0, 1.0);
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
        super.testEquals();
        MutableDoubleSet set1 = this.newWith(1.0, 31.0, 32.0);
        MutableDoubleSet set2 = this.newWith(32.0, 31.0, 1.0);
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
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Assert.assertEquals(set.toSet(), set.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, set.asLazy());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(SynchronizedDoubleSet.class, set.asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleSet(set), set.asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        super.asUnmodifiable();
        MutableDoubleSet set = this.newWith(0.0, 1.0, 31.0, AbstractDoubleSetTestCase.generateCollisions1().getFirst(), AbstractDoubleSetTestCase.generateCollisions1().get(1));
        Verify.assertInstanceOf(UnmodifiableDoubleSet.class, set.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleSet(set), set.asUnmodifiable());
    }
}
