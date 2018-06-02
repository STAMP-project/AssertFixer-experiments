/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link DoubleIterable}s
 * This file was automatically generated from template file abstractPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractDoubleIterableTestCase
{
    protected abstract DoubleIterable classUnderTest();

    protected abstract DoubleIterable newWith(double... elements);

    protected abstract DoubleIterable newMutableCollectionWith(double... elements);

    protected abstract RichIterable<Double> newObjectCollectionWith(Double... elements);

    @Test
    public void newCollectionWith()
    {
        DoubleIterable iterable = this.newWith(1.0, 2.0, 3.0);
        Verify.assertSize(3, iterable);
        Verify.assertSize(4, this.newWith(0.0, 1.0, 31.0, 32.0));
        Assert.assertTrue(iterable.containsAll(1.0, 2.0, 3.0));

        DoubleIterable iterable1 = this.newWith();
        Verify.assertEmpty(iterable1);
        Assert.assertFalse(iterable1.containsAll(1.0, 2.0, 3.0));

        DoubleIterable iterable2 = this.newWith(1.0);
        Verify.assertSize(1, iterable2);
        Assert.assertFalse(iterable2.containsAll(1.0, 2.0, 3.0));
    }

    @Test
    public void newCollection()
    {
        Assert.assertEquals(this.newMutableCollectionWith(), this.newWith());
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0));
        Assert.assertEquals(this.newMutableCollectionWith(0.0, 1.0, 31.0, 32.0), this.newWith(0.0, 1.0, 31.0, 32.0));
    }

    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.newWith());
        Verify.assertNotEmpty(this.classUnderTest());
        Verify.assertNotEmpty(this.newWith(0.0, 1.0, 31.0, 32.0));
        Verify.assertNotEmpty(this.newWith(0.0, 1.0, 2.0));
        Verify.assertNotEmpty(this.newWith(0.0, 31.0));
        Verify.assertNotEmpty(this.newWith(31.0, 32.0));
        Verify.assertNotEmpty(this.newWith(32.0, 33.0));
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.newWith().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWith(0.0, 1.0, 31.0, 32.0).notEmpty());
        Assert.assertTrue(this.newWith(0.0, 1.0, 2.0).notEmpty());
        Assert.assertTrue(this.newWith(0.0, 31.0).notEmpty());
        Assert.assertTrue(this.newWith(31.0, 32.0).notEmpty());
        Assert.assertTrue(this.newWith(32.0, 33.0).notEmpty());
    }

    @Test
    public void tap()
    {
        MutableDoubleList tapResult = DoubleLists.mutable.empty();
        DoubleIterable collection = this.newWith(14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void contains()
    {
        DoubleIterable iterable = this.newWith(14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertFalse(iterable.contains(29.0));
        Assert.assertFalse(iterable.contains(49.0));

        double[] numbers = {14.0, 2.0, 30.0, 31.0, 32.0, 35.0, 0.0, 1.0};
        for (double number : numbers)
        {
            Assert.assertTrue(iterable.contains(number));
        }

        Assert.assertFalse(iterable.contains(-1.0));
        Assert.assertFalse(iterable.contains(29.0));
        Assert.assertFalse(iterable.contains(49.0));

        DoubleIterable iterable1 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertTrue(iterable1.contains(0.0));
        Assert.assertTrue(iterable1.contains(1.0));
        Assert.assertTrue(iterable1.contains(2.0));
        Assert.assertFalse(iterable1.contains(3.0));

        DoubleIterable iterable2 = this.classUnderTest();
        for (double each = 1; each <= iterable2.size(); each++)
        {
            Assert.assertTrue(iterable2.contains(each));
        }
        Assert.assertFalse(iterable2.contains(iterable2.size() + 1));
    }

@Test
public void contains_NaN()
{
    DoubleIterable primitiveIterable = this.newWith(Double.NaN);
    Set<Double> hashSet = new HashSet<>();
    Assert.assertTrue(hashSet.add(Double.NaN));
    Assert.assertTrue(hashSet.contains(Double.NaN));
    Assert.assertTrue(primitiveIterable.contains(Double.NaN));
}

    @Test
    public void contains_NEGATIVE_INFINITY()
    {
        DoubleIterable primitiveIterable = this.newWith(Double.NEGATIVE_INFINITY);
        Set<Double> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Double.NEGATIVE_INFINITY));
        Assert.assertTrue(hashSet.contains(Double.NEGATIVE_INFINITY));
        Assert.assertTrue(primitiveIterable.contains(Double.NEGATIVE_INFINITY));
    }

    @Test
    public void contains_POSITIVE_INFINITY()
    {
        DoubleIterable primitiveIterable = this.newWith(Double.POSITIVE_INFINITY);
        Set<Double> hashSet = new HashSet<>();
        Assert.assertTrue(hashSet.add(Double.POSITIVE_INFINITY));
        Assert.assertTrue(hashSet.contains(Double.POSITIVE_INFINITY));
        Assert.assertTrue(primitiveIterable.contains(Double.POSITIVE_INFINITY));
    }

    @Test
    public void contains_zero()
    {
        DoubleIterable iterable = this.newWith(0.0);
        Set<Double> hashSet = new HashSet<>();
        hashSet.add(0.0);

        Assert.assertTrue(hashSet.contains(0.0));
        Assert.assertFalse(hashSet.contains(-0.0));
        Assert.assertTrue(iterable.contains(0.0));
        Assert.assertFalse(iterable.contains(-0.0));
    }

    @Test
    public void testEquals_NaN()
    {
        DoubleIterable iterable1 = this.newWith(Double.NaN);
        Set<Double> hashSet1 = new HashSet<>();
        hashSet1.add(Double.NaN);
        DoubleIterable iterable2 = this.newWith(Double.NaN);
        Set<Double> hashSet2 = new HashSet<>();
        hashSet2.add(Double.NaN);
        DoubleIterable iterable3 = this.newWith(Double.POSITIVE_INFINITY);
        Set<Double> hashSet3 = new HashSet<>();
        hashSet3.add(Double.POSITIVE_INFINITY);
        DoubleIterable iterable4 = this.newWith(Double.POSITIVE_INFINITY);
        Set<Double> hashSet4 = new HashSet<>();
        hashSet4.add(Double.POSITIVE_INFINITY);
        DoubleIterable iterable5 = this.newWith(Double.NEGATIVE_INFINITY);
        Set<Double> hashSet5 = new HashSet<>();
        hashSet5.add(Double.NEGATIVE_INFINITY);
        DoubleIterable iterable6 = this.newWith(Double.NEGATIVE_INFINITY);
        Set<Double> hashSet6 = new HashSet<>();
        hashSet6.add(Double.NEGATIVE_INFINITY);

        Assert.assertEquals(hashSet1, hashSet2);
        Assert.assertEquals(iterable1, iterable2);
        Assert.assertEquals(hashSet3, hashSet4);
        Assert.assertEquals(iterable3, iterable4);
        Assert.assertEquals(hashSet5, hashSet6);
        Assert.assertEquals(iterable5, iterable6);

        Assert.assertNotEquals(hashSet1, hashSet3);
        Assert.assertNotEquals(iterable1, iterable3);
        Assert.assertNotEquals(hashSet3, hashSet5);
        Assert.assertNotEquals(iterable3, iterable5);
        Assert.assertNotEquals(hashSet5, hashSet1);
        Assert.assertNotEquals(iterable5, iterable1);
    }

    @Test
    public void contains_different_NaNs()
    {
        long nan1 = 0x7ff0000000000001L;
        DoubleIterable primitiveIterable = this.newWith(Double.longBitsToDouble(nan1));
        Set<Double> hashSet = new HashSet<>();
        hashSet.add(Double.longBitsToDouble(nan1));
        long nan2 = 0xfff0000000000001L;
        Assert.assertEquals(hashSet.contains(Double.longBitsToDouble(nan2)), primitiveIterable.contains(Double.longBitsToDouble(nan2)));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(this.classUnderTest().toArray()));
        Assert.assertFalse(this.classUnderTest().containsAll(this.classUnderTest().size() + 1));

        DoubleIterable iterable = this.newWith(1.0, 2.0, 3.0);
        Assert.assertTrue(iterable.containsAll(1.0));
        Assert.assertTrue(iterable.containsAll(1.0, 2.0, 3.0));
        Assert.assertFalse(iterable.containsAll(1.0, 2.0, 3.0, 4.0));
        Assert.assertFalse(iterable.containsAll(1.0, 2.0, 4.0));
        Assert.assertFalse(iterable.containsAll(4.0, 5.0, 6.0));

        DoubleIterable iterable1 = this.newWith(14.0, 2.0, 30.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertTrue(iterable1.containsAll(14.0));
        Assert.assertTrue(iterable1.containsAll(35.0));
        Assert.assertFalse(iterable1.containsAll(-1.0));
        Assert.assertTrue(iterable1.containsAll(14.0, 1.0, 30.0));
        Assert.assertTrue(iterable1.containsAll(14.0, 1.0, 32.0));
        Assert.assertTrue(iterable1.containsAll(14.0, 1.0, 35.0));
        Assert.assertFalse(iterable1.containsAll(0.0, 2.0, 35.0, -1.0));
        Assert.assertFalse(iterable1.containsAll(31.0, -1.0));

        DoubleIterable iterable2 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertTrue(iterable2.containsAll(0.0));
        Assert.assertTrue(iterable2.containsAll(0.0, 0.0, 0.0));
        Assert.assertTrue(iterable2.containsAll(0.0, 1.0, 1.0));
        Assert.assertTrue(iterable2.containsAll(0.0, 1.0, 2.0));
        Assert.assertFalse(iterable2.containsAll(0.0, 1.0, 2.0, 3.0, 4.0));
        Assert.assertFalse(iterable2.containsAll(3.0, 4.0));
    }

    @Test
    public void containsAllIterable()
    {
        DoubleIterable source = this.classUnderTest();
        Assert.assertTrue(source.containsAll(this.classUnderTest()));
        Assert.assertFalse(source.containsAll(DoubleArrayList.newListWith(source.size() + 1)));

        DoubleIterable iterable = this.newWith(1.0, 2.0, 3.0);
        Assert.assertTrue(this.newWith().containsAll(new DoubleArrayList()));
        Assert.assertFalse(this.newWith().containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Assert.assertFalse(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0)));
        Assert.assertFalse(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 4.0)));
        Assert.assertFalse(iterable.containsAll(DoubleArrayList.newListWith(4.0, 5.0, 6.0)));

        DoubleIterable iterable1 = this.newWith(14.0, 2.0, 30.0, 32.0, 35.0, 0.0, 1.0);
        Assert.assertTrue(iterable1.containsAll(DoubleHashSet.newSetWith(14.0)));
        Assert.assertTrue(iterable1.containsAll(DoubleHashSet.newSetWith(35.0)));
        Assert.assertFalse(iterable1.containsAll(DoubleHashSet.newSetWith(-1.0)));
        Assert.assertTrue(iterable1.containsAll(DoubleHashSet.newSetWith(14.0, 1.0, 30.0)));
        Assert.assertTrue(iterable1.containsAll(DoubleHashSet.newSetWith(14.0, 1.0, 32.0)));
        Assert.assertTrue(iterable1.containsAll(DoubleHashSet.newSetWith(14.0, 1.0, 35.0)));
        Assert.assertFalse(iterable1.containsAll(DoubleHashSet.newSetWith(0.0, 2.0, 35.0, -1.0)));
        Assert.assertFalse(iterable1.containsAll(DoubleHashSet.newSetWith(31.0, -1.0)));

        DoubleIterable iterable2 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        Assert.assertTrue(iterable2.containsAll(DoubleArrayList.newListWith(0.0)));
        Assert.assertTrue(iterable2.containsAll(DoubleArrayList.newListWith(0.0, 0.0, 0.0)));
        Assert.assertTrue(iterable2.containsAll(DoubleArrayList.newListWith(0.0, 1.0, 1.0)));
        Assert.assertTrue(iterable2.containsAll(DoubleArrayList.newListWith(0.0, 1.0, 2.0)));
        Assert.assertFalse(iterable2.containsAll(DoubleArrayList.newListWith(0.0, 1.0, 2.0, 3.0, 4.0)));
        Assert.assertFalse(iterable2.containsAll(DoubleArrayList.newListWith(3.0, 4.0)));
    }

    @Test
    public abstract void doubleIterator();

    @Test(expected = NoSuchElementException.class)
    public void doubleIterator_throws()
    {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void doubleIterator_throws_non_empty_collection()
    {
        DoubleIterable iterable = this.newWith(1.0, 2.0, 3.0);
        DoubleIterator iterator = iterable.doubleIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }
        iterator.next();
    }

    @Test
    public void forEach()
    {
        double[] sum = new double[1];
        this.classUnderTest().forEach(each -> sum[0] += each);

        int size = this.classUnderTest().size();
        long sum1 = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum1, sum[0], 0.0);
    }

    @Test
    public void size()
    {
        Verify.assertSize(0, this.newWith());
        Verify.assertSize(1, this.newWith(3.0));
        Verify.assertSize(3, this.newWith(1.0, 2.0, 3.0));
    }

    @Test
    public void count()
    {
        DoubleIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 3 ? 3 : size, iterable.count(DoublePredicates.lessThan(4.0)));
        Assert.assertEquals(2L, this.newWith(1.0, 0.0, 2.0).count(DoublePredicates.greaterThan(0.0)));

        Assert.assertEquals(1, this.newWith(1.0).count(DoublePredicates.alwaysTrue()));
        Assert.assertEquals(0, this.newWith(1.0).count(DoublePredicates.alwaysFalse()));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith(1.0, -1.0, 2.0).anySatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.newWith(1.0, -1.0, 2.0).anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWith(-1.0, -1.0, -2.0, 31.0, 32.0).anySatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(this.newWith(2.0, -1.0, -2.0, 31.0, 32.0).anySatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.newWith(1.0, -1.0, 31.0, 32.0).anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWith(32.0).anySatisfy(DoublePredicates.greaterThan(0.0)));
        DoubleIterable iterable = this.newWith(0.0, 1.0, 2.0);
        Assert.assertTrue(iterable.anySatisfy(value -> Double.compare(value, 3.0) < 0));
        Assert.assertFalse(iterable.anySatisfy(DoublePredicates.greaterThan(3.0)));

        DoubleIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size > 3, iterable1.anySatisfy(DoublePredicates.greaterThan(3.0)));
        Assert.assertEquals(size != 0, iterable1.anySatisfy(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.newWith(1.0, 0.0, 2.0).allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(this.newWith(1.0, 2.0, 3.0).allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.newWith(1.0, 0.0, 31.0, 32.0).allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.newWith(1.0, 0.0, 31.0, 32.0).allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(this.newWith(1.0, 2.0, 31.0, 32.0).allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.newWith(32.0).allSatisfy(DoublePredicates.equal(33.0)));
        Assert.assertFalse(this.newWith(-32.0).allSatisfy(DoublePredicates.equal(33.0)));
        DoubleIterable iterable = this.newWith(0.0, 1.0, 2.0);
        Assert.assertFalse(iterable.allSatisfy(value -> Double.compare(3.0, value) < 0));
        Assert.assertTrue(iterable.allSatisfy(DoublePredicates.lessThan(3.0)));

        DoubleIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size == 0, iterable1.allSatisfy(DoublePredicates.greaterThan(3.0)));
        Assert.assertEquals(size < 3, iterable1.allSatisfy(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.newWith(1.0, 0.0, 2.0).noneSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.newWith(1.0, 0.0, 2.0).noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.newWith(1.0, 2.0, 3.0).noneSatisfy(DoublePredicates.greaterThan(3.0)));
        Assert.assertFalse(this.newWith(1.0, 0.0, 31.0, 32.0).noneSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.newWith(1.0, 0.0, 31.0, 32.0).noneSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(this.newWith(1.0, 2.0, 31.0, 32.0).noneSatisfy(DoublePredicates.lessThan(0.0)));
        Assert.assertFalse(this.newWith(32.0).noneSatisfy(DoublePredicates.greaterThan(0.0)));
        DoubleIterable iterable = this.newWith(0.0, 1.0, 2.0);
        Assert.assertFalse(iterable.noneSatisfy(value -> Double.compare(1.0, value) < 0));
        Assert.assertTrue(iterable.noneSatisfy(DoublePredicates.greaterThan(3.0)));

        DoubleIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size <= 3, iterable1.noneSatisfy(DoublePredicates.greaterThan(3.0)));
        Assert.assertEquals(size == 0, iterable1.noneSatisfy(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void collect()
    {
        DoubleToObjectFunction<Double> function = parameter -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 2.0), this.newWith(1.0, 2.0, 3.0).collect(function));
        DoubleIterable iterable = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0), iterable.collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2.0), this.newWith(3.0).collect(function));
    }

    @Test
    public void collectWithTarget()
    {
        DoubleToObjectFunction<Double> function = parameter -> parameter - 1;
        Assert.assertEquals(Bags.mutable.with(0.0, 1.0, 2.0), this.newWith(1.0, 2.0, 3.0).collect(function, Bags.mutable.empty()));
        DoubleIterable iterable = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(Sets.mutable.with(0.0, 1.0, 2.0), iterable.collect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().collect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2.0), this.newWith(3.0).collect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectWithTarget()
    {
        DoubleToObjectFunction<List<Double>> function = parameter -> Lists.mutable.with(parameter - 1);
        Assert.assertEquals(Bags.mutable.with(0.0, 1.0, 2.0), this.newWith(1.0, 2.0, 3.0).flatCollect(function, Bags.mutable.empty()));
        DoubleIterable iterable = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(Sets.mutable.with(0.0, 1.0, 2.0), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2.0), this.newWith(3.0).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectIterableWithTarget()
    {
        DoubleToObjectFunction<Iterable<Double>> function = parameter -> Lists.mutable.with(parameter - 1).asLazy();
        Assert.assertEquals(Bags.mutable.with(0.0, 1.0, 2.0), this.newWith(1.0, 2.0, 3.0).flatCollect(function, Bags.mutable.empty()));
        DoubleIterable iterable = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(Sets.mutable.with(0.0, 1.0, 2.0), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with(2.0), this.newWith(3.0).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToLists()
    {
        DoubleIterable iterable = this.newWith(1.0, 2.0);
        Assert.assertEquals(
                BooleanLists.mutable.with(true, true),
                iterable.collectBoolean(each -> true, BooleanLists.mutable.empty()));
        Assert.assertEquals(
                ByteLists.mutable.with((byte) 1, (byte) 1),
                iterable.collectByte(each -> (byte) 1, ByteLists.mutable.empty()));
        Assert.assertEquals(
                CharLists.mutable.with('a', 'a'),
                iterable.collectChar(each -> 'a', CharLists.mutable.empty()));
        Assert.assertEquals(
                ShortLists.mutable.with((short) 1, (short) 1),
                iterable.collectShort(each -> (short) 1, ShortLists.mutable.empty()));
        Assert.assertEquals(
                IntLists.mutable.with(1, 1),
                iterable.collectInt(each -> 1, IntLists.mutable.empty()));
        Assert.assertEquals(
                FloatLists.mutable.with(1.0f, 1.0f),
                iterable.collectFloat(each -> 1.0f, FloatLists.mutable.empty()));
        Assert.assertEquals(
                LongLists.mutable.with(1L, 1L),
                iterable.collectLong(each -> 1L, LongLists.mutable.empty()));
        Assert.assertEquals(
                DoubleLists.mutable.with(1.0d, 1.0d),
                iterable.collectDouble(each -> 1.0d, DoubleLists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToSets()
    {
        DoubleIterable iterable = this.newWith(1.0, 2.0);
        Assert.assertEquals(
                BooleanSets.mutable.with(false),
                iterable.collectBoolean(each -> false, BooleanSets.mutable.empty()));
        Assert.assertEquals(
                ByteSets.mutable.with((byte) 2),
                iterable.collectByte(each -> (byte) 2, ByteSets.mutable.empty()));
        Assert.assertEquals(
                CharSets.mutable.with('b'),
                iterable.collectChar(each -> 'b', CharSets.mutable.empty()));
        Assert.assertEquals(
                ShortSets.mutable.with((short) 2),
                iterable.collectShort(each -> (short) 2, ShortSets.mutable.empty()));
        Assert.assertEquals(
                IntSets.mutable.with(2),
                iterable.collectInt(each -> 2, IntSets.mutable.empty()));
        Assert.assertEquals(
                FloatSets.mutable.with(2.0f),
                iterable.collectFloat(each -> 2.0f, FloatSets.mutable.empty()));
        Assert.assertEquals(
                LongSets.mutable.with(2L),
                iterable.collectLong(each -> 2L, LongSets.mutable.empty()));
        Assert.assertEquals(
                DoubleSets.mutable.with(2.0d),
                iterable.collectDouble(each -> 2.0d, DoubleSets.mutable.empty()));
    }

    @Test
    public void select()
    {
        DoubleIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(DoublePredicates.lessThan(3.0)));
        DoubleIterable iterable1 = this.newWith(0.0, 1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(this.newMutableCollectionWith(0.0, 1.0), iterable1.select(DoublePredicates.lessThan(2.0)));
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 2.0, 3.0, 3.0, 3.0), iterable1.select(DoublePredicates.greaterThan(1.0)));

        DoubleIterable iterable2 = this.newWith(0.0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.select(DoublePredicates.alwaysTrue()));
        Verify.assertSize(0, iterable2.select(DoublePredicates.alwaysFalse()));
    }

    @Test
    public void selectWithTarget()
    {
        DoubleIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(DoublePredicates.lessThan(4.0), DoubleSets.mutable.empty()));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(DoublePredicates.lessThan(3.0), DoubleSets.mutable.empty()));
        DoubleIterable iterable1 = this.newWith(0.0, 1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(DoubleSets.mutable.with(0.0, 1.0), iterable1.select(DoublePredicates.lessThan(2.0), DoubleSets.mutable.empty()));
        Assert.assertEquals(DoubleSets.mutable.with(2.0, 3.0), iterable1.select(DoublePredicates.greaterThan(1.0), DoubleSets.mutable.empty()));
    }

    @Test
    public void reject()
    {
        DoubleIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(DoublePredicates.lessThan(3.0)));
        DoubleIterable iterable1 = this.newWith(0.0, 1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(this.newMutableCollectionWith(2.0, 2.0, 3.0, 3.0, 3.0), iterable1.reject(DoublePredicates.lessThan(2.0)));
        Assert.assertEquals(this.newMutableCollectionWith(0.0, 1.0), iterable1.reject(DoublePredicates.greaterThan(1.0)));

        DoubleIterable iterable2 = this.newWith(0.0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.reject(DoublePredicates.alwaysFalse()));
        Verify.assertSize(0, iterable2.reject(DoublePredicates.alwaysTrue()));
    }

    @Test
    public void rejectWithTarget()
    {
        DoubleIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(DoublePredicates.lessThan(4.0), DoubleSets.mutable.empty()));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(DoublePredicates.lessThan(3.0), DoubleSets.mutable.empty()));
        DoubleIterable iterable1 = this.newWith(0.0, 1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(DoubleSets.mutable.with(2.0, 3.0), iterable1.reject(DoublePredicates.lessThan(2.0), DoubleSets.mutable.empty()));
        Assert.assertEquals(DoubleSets.mutable.with(0.0, 1.0), iterable1.reject(DoublePredicates.greaterThan(1.0), DoubleSets.mutable.empty()));
    }

    @Test
    public void detectIfNone()
    {
        DoubleIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4.0 : 0.0, iterable.detectIfNone(DoublePredicates.equal(4.0), 0.0), 0.0);
        Assert.assertEquals(size >= 2 ? 2.0 : 0.0, iterable.detectIfNone(DoublePredicates.equal(2.0), 0.0), 0.0);
        Assert.assertEquals(size > 0 ? 1.0 : 0.0, iterable.detectIfNone(DoublePredicates.lessThan(2.0), 0.0), 0.0);
        Assert.assertEquals(size > 3 ? 4.0 : 0.0, iterable.detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);

        DoubleIterable iterable1 = this.newWith(0.0, 1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(0.0, iterable1.detectIfNone(DoublePredicates.lessThan(1.0), 4.0), 0.0);
        Assert.assertEquals(3.0, iterable1.detectIfNone(DoublePredicates.greaterThan(2.0), 4.0), 0.0);
        Assert.assertEquals(4.0, iterable1.detectIfNone(DoublePredicates.greaterThan(4.0), 4.0), 0.0);
    }

    @Test
    public void max()
    {
        Assert.assertEquals(9.0, this.newWith(-1.0, -2.0, 9.0).max(), 0.0);
        Assert.assertEquals(-1.0, this.newWith(-1.0, -2.0, -9.0).max(), 0.0);
        Assert.assertEquals(32.0, this.newWith(1.0, 0.0, 9.0, 30.0, 31.0, 32.0).max(), 0.0);
        Assert.assertEquals(32.0, this.newWith(-1.0, 0.0, 9.0, 30.0, 31.0, 32.0).max(), 0.0);
        Assert.assertEquals(31.0, this.newWith(31.0, 0.0, 30.0).max(), 0.0);
        Assert.assertEquals(39.0, this.newWith(32.0, 39.0, 35.0).max(), 0.0);
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().max(), 0.0);
        Assert.assertEquals(32.5, this.newWith(-1.5, 31.8, 32.5).max(), 0.0);
        Assert.assertEquals(-1.5, this.newWith(-1.5, -31.8, -32.5).max(), 0.0);
        Assert.assertEquals(Double.POSITIVE_INFINITY, this.newWith(-1.5, 31.8, 32.5, Double.POSITIVE_INFINITY).max(), 0.0);
        Assert.assertEquals(Double.NaN, this.newWith(-1.5, 31.8, 32.5, Double.NaN, 31.5f).max(), 0.0);
        Assert.assertEquals(32.5, this.newWith(-1.5, 31.8, 32.5, Double.NEGATIVE_INFINITY, 31.5f).max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyCollection()
    {
        this.newWith().max();
    }

    @Test
    public void min()
    {
        Assert.assertEquals(-2.0, this.newWith(-1.0, -2.0, 9.0).min(), 0.0);
        Assert.assertEquals(0.0, this.newWith(1.0, 0.0, 9.0, 30.0, 31.0, 32.0).min(), 0.0);
        Assert.assertEquals(-1.0, this.newWith(-1.0, 0.0, 9.0, 30.0, 31.0, 32.0).min(), 0.0);
        Assert.assertEquals(31.0, this.newWith(31.0, 32.0, 33.0).min(), 0.0);
        Assert.assertEquals(32.0, this.newWith(32.0, 39.0, 35.0).min(), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().min(), 0.0);
        Assert.assertEquals(-1.5, this.newWith(-1.5, 31.5, 32.5).min(), 0.0);
        Assert.assertEquals(1.5, this.newWith(1.5, 31.0, 30.0, Double.POSITIVE_INFINITY).min(), 0.0);
        Assert.assertEquals(31.5, this.newWith(31.5, 32.5, Double.NaN).min(), 0.0);
        Assert.assertEquals(Double.NEGATIVE_INFINITY, this.newWith(-1.5, 31.5, 32.5, Double.NEGATIVE_INFINITY, 31.5f).min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyCollection()
    {
        this.newWith().min();
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5.0, this.newWith().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, this.newWith().minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, this.newWith(1.0, 0.0, 9.0, 7.0).minIfEmpty(5.0), 0.0);
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? 5.0 : 1.0, this.classUnderTest().minIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5.0, this.newWith().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, this.newWith().maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(9.0, this.newWith(1.0, 0.0, 9.0, 7.0).maxIfEmpty(5.0), 0.0);
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? 5.0 : size, this.classUnderTest().maxIfEmpty(5.0), 0.0);
    }

    @Test
    public void sum()
    {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().sum(), 0.0);
        Assert.assertEquals(10.0, this.newWith(0.0, 1.0, 2.0, 3.0, 4.0).sum(), 0.0);
        Assert.assertEquals(93.0, this.newWith(30.0, 31.0, 32.0).sum(), 0.0);
    }

    @Test
    public void summaryStatistics()
    {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().summaryStatistics().getSum(), 0.0);
        Assert.assertEquals(10.0, this.newWith(0.0, 1.0, 2.0, 3.0, 4.0).summaryStatistics().getSum(), 0.0);
        Assert.assertEquals(93.0, this.newWith(30.0, 31.0, 32.0).summaryStatistics().getSum(), 0.0);
    }

    @Test
    public void sumConsistentRounding()
    {
        DoubleIterable iterable = this.newWith(
                Interval.oneTo(100_000)
                        .toList()
                        .shuffleThis()
                        .collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()))
                        .toArray());

        Assert.assertEquals(
                1.082323233711138,
                iterable.sum(),
                1.0e-15);
    }

    @Test
    public void average()
    {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().average(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0, 2.0, 3.0, 4.0).average(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0, 2.0, 3.0, 4.0).average(), 0.0);
        Assert.assertEquals(31.0, this.newWith(30.0, 30.0, 31.0, 31.0, 32.0, 32.0).average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        this.newWith().average();
    }

    /**
     * @since 9.0
     */
    @Test
    public void averageIfEmpty()
    {
        Assert.assertEquals(2.5, this.newWith().averageIfEmpty(2.5), 0.0);
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0, 2.0, 3.0, 4.0).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0, 2.0, 3.0, 4.0).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith(30.0, 30.0, 31.0, 31.0, 32.0, 32.0).averageIfEmpty(0.0), 0.0);
    }

    @Test
    public void median()
    {
        Assert.assertEquals(1.0, this.newWith(1.0).median(), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0, 2.0, 3.0, 4.0).median(), 0.0);
        Assert.assertEquals(3.0, this.newWith(1.0, 2.0, 3.0, 4.0, 5.0).median(), 0.0);
        Assert.assertEquals(31.0, this.newWith(30.0, 30.0, 31.0, 31.0, 32.0).median(), 0.0);
        Assert.assertEquals(30.5, this.newWith(1.0, 30.0, 30.0, 31.0, 31.0, 32.0).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        this.newWith().median();
    }

    /**
     * @since 9.0
     */
    @Test
    public void medianIfEmpty()
    {
        Assert.assertEquals(2.5, this.newWith().medianIfEmpty(2.5), 0.0);
        Assert.assertEquals(1.0, this.newWith(1.0).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith(1.0, 2.0, 3.0, 4.0).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(3.0, this.newWith(1.0, 2.0, 3.0, 4.0, 5.0).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith(30.0, 30.0, 31.0, 31.0, 32.0).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(30.5, this.newWith(1.0, 30.0, 30.0, 31.0, 31.0, 32.0).medianIfEmpty(0.0), 0.0);
    }

    @Test
    public void toArray()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().toArray().length);
        DoubleIterable iterable = this.newWith(1.0, 2.0);
        Assert.assertTrue(Arrays.equals(new double[]{1.0, 2.0}, iterable.toArray())
                || Arrays.equals(new double[]{2.0, 1.0}, iterable.toArray()));
        Assert.assertTrue(Arrays.equals(new double[]{0.0, 1.0}, this.newWith(0.0, 1.0).toArray())
                || Arrays.equals(new double[]{1.0, 0.0}, this.newWith(0.0, 1.0).toArray()));
        Assert.assertTrue(Arrays.equals(new double[]{1.0, 31.0}, this.newWith(1.0, 31.0).toArray())
                || Arrays.equals(new double[]{31.0, 1.0}, this.newWith(1.0, 31.0).toArray()));
        Assert.assertTrue(Arrays.equals(new double[]{31.0, 35.0}, this.newWith(31.0, 35.0).toArray())
                || Arrays.equals(new double[]{35.0, 31.0}, this.newWith(31.0, 35.0).toArray()));
        Assert.assertArrayEquals(new double[]{}, this.newWith().toArray(), 0.0);
        Assert.assertArrayEquals(new double[]{32.0}, this.newWith(32.0).toArray(), 0.0);
    }

    @Test
    public void toSortedArray()
    {
        DoubleIterable iterable = this.classUnderTest();
        int size = iterable.size();
        double[] array = new double[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = i + 1;
        }

        Assert.assertArrayEquals(array, iterable.toSortedArray(), 0.0);
        Assert.assertArrayEquals(new double[]{1.0, 3.0, 7.0, 9.0},
                this.newWith(3.0, 1.0, 9.0, 7.0).toSortedArray(), 0.0);
    }

    @Test
    public void testEquals()
    {
        DoubleIterable iterable1 = this.newWith(1.0, 2.0, 3.0, 4.0);
        DoubleIterable iterable2 = this.newWith(1.0, 2.0, 3.0, 4.0);
        DoubleIterable iterable3 = this.newWith(5.0, 6.0, 7.0, 8.0);
        DoubleIterable iterable4 = this.newWith(5.0, 6.0, 7.0);
        DoubleIterable iterable5 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        DoubleIterable iterable6 = this.newWith(1.0, 31.0, 32.0);
        DoubleIterable iterable7 = this.newWith(35.0, 31.0, 1.0);
        DoubleIterable iterable8 = this.newWith(32.0, 31.0, 1.0, 50.0);
        DoubleIterable iterable9 = this.newWith(0.0, 1.0, 2.0);
        DoubleIterable iterable10 = this.newWith(0.0, 1.0, 3.0);
        DoubleIterable iterable11 = this.newWith(3.0, 1.0, 2.0);
        DoubleIterable iterable12 = this.newWith(3.0);

        Verify.assertEqualsAndHashCode(iterable1, iterable2);
        Verify.assertPostSerializedEqualsAndHashCode(iterable1);
        Verify.assertPostSerializedEqualsAndHashCode(iterable12);
        Verify.assertPostSerializedEqualsAndHashCode(iterable5);
        Verify.assertPostSerializedEqualsAndHashCode(iterable6);
        Assert.assertNotEquals(iterable12, iterable11);
        Assert.assertNotEquals(iterable1, iterable3);
        Assert.assertNotEquals(iterable1, iterable4);
        Assert.assertNotEquals(iterable6, iterable7);
        Assert.assertNotEquals(iterable6, iterable8);
        Assert.assertNotEquals(iterable9, iterable10);
        Assert.assertNotEquals(iterable9, iterable11);
        Assert.assertNotEquals(this.newWith(), this.newWith(100.0));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(this.newObjectCollectionWith(1.0, 2.0, 3.0).hashCode(), this.newWith(1.0, 2.0, 3.0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(0.0, 1.0, 31.0).hashCode(), this.newWith(0.0, 1.0, 31.0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(32.0).hashCode(), this.newWith(32.0).hashCode());
        Assert.assertNotEquals(this.newObjectCollectionWith(32.0).hashCode(), this.newWith(0.0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(31.0, 32.0, 50.0).hashCode(), this.newWith(31.0, 32.0, 50.0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith(32.0, 50.0, 60.0).hashCode(), this.newWith(32.0, 50.0, 60.0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith().hashCode(), this.newWith().hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[]", this.newWith().toString());
        Assert.assertEquals("[1.0]", this.newWith(1.0).toString());
        Assert.assertEquals("[31.0]", this.newWith(31.0).toString());
        Assert.assertEquals("[32.0]", this.newWith(32.0).toString());

        DoubleIterable iterable = this.newWith(1.0, 2.0);
        Assert.assertTrue("[1.0, 2.0]".equals(iterable.toString())
                || "[2.0, 1.0]".equals(iterable.toString()));

        DoubleIterable iterable1 = this.newWith(0.0, 31.0);
        Assert.assertTrue(
                iterable1.toString(),
                iterable1.toString().equals("[0.0, 31.0]")
                        || iterable1.toString().equals("[31.0, 0.0]"));

        DoubleIterable iterable2 = this.newWith(31.0, 32.0);
        Assert.assertTrue(
                iterable2.toString(),
                iterable2.toString().equals("[31.0, 32.0]")
                        || iterable2.toString().equals("[32.0, 31.0]"));

        DoubleIterable iterable3 = this.newWith(32.0, 33.0);
        Assert.assertTrue(
                iterable3.toString(),
                iterable3.toString().equals("[32.0, 33.0]")
                        || iterable3.toString().equals("[33.0, 32.0]"));

        DoubleIterable iterable4 = this.newWith(0.0, 1.0);
        Assert.assertTrue(
                iterable4.toString(),
                iterable4.toString().equals("[0.0, 1.0]")
                        || iterable4.toString().equals("[1.0, 0.0]"));
    }

    @Test
    public void makeString()
    {
        DoubleIterable iterable = this.classUnderTest();
        Assert.assertEquals("1.0", this.newWith(1.0).makeString("/"));
        Assert.assertEquals("31.0", this.newWith(31.0).makeString());
        Assert.assertEquals("32.0", this.newWith(32.0).makeString());
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));

        DoubleIterable iterable1 = this.newWith(0.0, 31.0);
        Assert.assertTrue(
                iterable1.makeString(),
                iterable1.makeString().equals("0.0, 31.0")
                        || iterable1.makeString().equals("31.0, 0.0"));

        DoubleIterable iterable2 = this.newWith(31.0, 32.0);
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                iterable2.makeString("[", "/", "]").equals("[31.0/32.0]")
                        || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));

        DoubleIterable iterable3 = this.newWith(32.0, 33.0);
        Assert.assertTrue(
                iterable3.makeString("/"),
                iterable3.makeString("/").equals("32.0/33.0")
                        || iterable3.makeString("/").equals("33.0/32.0"));

        DoubleIterable iterable4 = this.newWith(1.0, 2.0);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString())
                || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/"))
                || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]"))
                || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));

        DoubleIterable iterable5 = this.newWith(0.0, 1.0);
        Assert.assertTrue(
                iterable5.makeString(),
                iterable5.makeString().equals("0.0, 1.0")
                        || iterable5.makeString().equals("1.0, 0.0"));
        Assert.assertTrue(
                iterable5.makeString("[", "/", "]"),
                iterable5.makeString("[", "/", "]").equals("[0.0/1.0]")
                        || iterable5.makeString("[", "/", "]").equals("[1.0/0.0]"));
        Assert.assertTrue(
                iterable5.makeString("/"),
                iterable5.makeString("/").equals("0.0/1.0")
                        || iterable5.makeString("/").equals("1.0/0.0"));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", ", ", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1.0).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();

        DoubleIterable iterable = this.newWith(1.0, 2.0);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString())
                || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString())
                || "2.0/1.0".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());

        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31.0).appendString(appendable5);
        Assert.assertEquals("31.0", appendable5.toString());

        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32.0).appendString(appendable6);
        Assert.assertEquals("32.0", appendable6.toString());

        StringBuilder appendable7 = new StringBuilder();
        DoubleIterable iterable1 = this.newWith(0.0, 31.0);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString())
                || "31.0, 0.0".equals(appendable7.toString()));

        StringBuilder appendable8 = new StringBuilder();
        DoubleIterable iterable2 = this.newWith(31.0, 32.0);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString())
                || "32.0/31.0".equals(appendable8.toString()));

        StringBuilder appendable9 = new StringBuilder();
        DoubleIterable iterable4 = this.newWith(32.0, 33.0);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString())
                || "[33.0/32.0]".equals(appendable9.toString()));

        StringBuilder appendable10 = new StringBuilder();
        DoubleIterable iterable5 = this.newWith(0.0, 1.0);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0.0, 1.0".equals(appendable10.toString())
                || "1.0, 0.0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0.0/1.0".equals(appendable11.toString())
                || "1.0/0.0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0.0/1.0]".equals(appendable12.toString())
                || "[1.0/0.0]".equals(appendable12.toString()));
    }

    @Test
    public void toList()
    {
        DoubleIterable iterable = this.newWith(31.0, 32.0);
        Assert.assertTrue(DoubleArrayList.newListWith(31.0, 32.0).equals(iterable.toList())
                || DoubleArrayList.newListWith(32.0, 31.0).equals(iterable.toList()));
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), this.newWith(0.0).toList());
        Assert.assertEquals(DoubleArrayList.newListWith(31.0), this.newWith(31.0).toList());
        Assert.assertEquals(DoubleArrayList.newListWith(32.0), this.newWith(32.0).toList());
        Assert.assertEquals(new DoubleArrayList(), this.newWith().toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(), this.newWith().toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), this.newWith(1.0).toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 1.0, 31.0), this.newWith(0.0, 31.0, 1.0).toSortedList());
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 1.0, 31.0, 32.0), this.newWith(0.0, 31.0, 32.0, 1.0).toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(DoubleHashSet.newSetWith(), this.newWith().toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0), this.newWith(1.0).toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0).toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0), this.newWith(0.0, 1.0, 31.0).toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0, 32.0), this.newWith(0.0, 1.0, 31.0, 32.0).toSet());
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0).toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(new DoubleHashBag(), this.newWith().toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0), this.newWith(1.0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), this.newWith(1.0, 2.0, 3.0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0), this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0).toBag());
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0, 32.0), this.newWith(0.0, 1.0, 31.0, 32.0).toBag());
    }

    @Test
    public void asLazy()
    {
        DoubleIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toBag(), iterable.asLazy().toBag());
        Verify.assertInstanceOf(LazyDoubleIterable.class, iterable.asLazy());

        DoubleIterable iterable1 = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(iterable1.toBag(), iterable1.asLazy().toBag());
        Verify.assertInstanceOf(LazyDoubleIterable.class, iterable1.asLazy());

        DoubleIterable iterable2 = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(iterable2.toBag(), iterable2.asLazy().toBag());
        Verify.assertInstanceOf(LazyDoubleIterable.class, iterable2.asLazy());

        DoubleIterable iterable3 = this.newWith();
        Assert.assertEquals(iterable3.toBag(), iterable3.asLazy().toBag());
        Verify.assertInstanceOf(LazyDoubleIterable.class, iterable3.asLazy());

        DoubleIterable iterable4 = this.newWith(1.0);
        Assert.assertEquals(iterable4.toBag(), iterable4.asLazy().toBag());
        Verify.assertInstanceOf(LazyDoubleIterable.class, iterable4.asLazy());
    }

    @Test
    public void injectInto()
    {
        DoubleIterable iterable1 = this.newWith(0.0, 2.0, 31.0);
        Double sum1 = iterable1.injectInto(Double.valueOf(0.0), (Double result, double value) -> Double.valueOf((double) (result + value + 1)));
        Assert.assertEquals(Double.valueOf(36.0), sum1);

        DoubleIterable iterable2 = this.newWith(1.0, 2.0, 31.0);
        Double sum2 = iterable2.injectInto(Double.valueOf(0.0), (Double result, double value) -> Double.valueOf((double) (result + value + 1)));
        Assert.assertEquals(Double.valueOf(37.0), sum2);

        DoubleIterable iterable3 = this.newWith(0.0, 1.0, 2.0, 31.0);
        Double sum3 = iterable3.injectInto(Double.valueOf(0.0), (Double result, double value) -> Double.valueOf((double) (result + value + 1)));
        Assert.assertEquals(Double.valueOf(38.0), sum3);
    }

    @Test
    public void chunk()
    {
        DoubleIterable iterable = this.newWith(0.0, 1.0, 2.0, 3.0, 4.0, 5.0);
        Assert.assertEquals(
                Lists.mutable.with(
                        this.newMutableCollectionWith(0.0),
                        this.newMutableCollectionWith(1.0),
                        this.newMutableCollectionWith(2.0),
                        this.newMutableCollectionWith(3.0),
                        this.newMutableCollectionWith(4.0),
                        this.newMutableCollectionWith(5.0)).toSet(),
                iterable.chunk(1).toSet());
        Assert.assertEquals(
                Lists.mutable.with(
                        this.newMutableCollectionWith(0.0, 1.0),
                        this.newMutableCollectionWith(2.0, 3.0),
                        this.newMutableCollectionWith(4.0, 5.0)).toSet(),
                iterable.chunk(2).toSet());
        Assert.assertEquals(
                Lists.mutable.with(
                        this.newMutableCollectionWith(0.0, 1.0, 2.0),
                        this.newMutableCollectionWith(3.0, 4.0, 5.0)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(
                        this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0),
                        this.newMutableCollectionWith(4.0, 5.0)).toSet(),
                iterable.chunk(4).toSet());
        Assert.assertEquals(
                Lists.mutable.with(this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0, 4.0, 5.0)).toSet(),
                iterable.chunk(6).toSet());
        Assert.assertEquals(
                Lists.mutable.with(this.newMutableCollectionWith(0.0, 1.0, 2.0, 3.0, 4.0, 5.0)).toSet(),
                iterable.chunk(7).toSet());
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith(0.0)), this.newWith(0.0).chunk(1));
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newMutableCollectionWith().chunk(-1));
    }
}
