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

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;

/**
 * JUnit test for {@link MutableDoubleBag}.
 * This file was automatically generated from template file abstractMutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractMutableDoubleBagTestCase extends AbstractMutableDoubleCollectionTestCase
{
    @Override
    protected abstract MutableDoubleBag classUnderTest();

    @Override
    protected abstract MutableDoubleBag newWith(double... elements);

    @Override
    protected MutableDoubleBag newMutableCollectionWith(double... elements)
    {
        return DoubleHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Double> newObjectCollectionWith(Double... elements)
    {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct()
    {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0.0, 1.0, 2.0).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0).sizeDistinct());
    }

    @Test
    public void selectByOccurrences()
    {
        MutableDoubleBag bag = this.newWith(100.0, 100.0, 100.0, 50.0, 50.0);
        MutableDoubleBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0, 100.0, 100.0), filtered);
    }

    @Test
    public void selectDuplicates()
    {
        MutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(DoubleHashBag.newBagWith(2.0, 2.0, 3.0, 3.0, 3.0), bag.selectDuplicates());
    }

    @Test
    public void selectUnique()
    {
        MutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0, 4.0, 5.0, 5.0, 6.0);
        MutableDoubleSet expected = DoubleSets.mutable.with(1.0, 4.0, 6.0);
        MutableDoubleSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected MutableDoubleBag newWithOccurrences(DoubleIntPair... elementsWithOccurrences)
    {
        MutableDoubleBag bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            DoubleIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void topOccurrences()
    {
        MutableDoubleBag bag = this.newWithOccurrences(
                PrimitiveTuples.pair(1.0, 1),
                PrimitiveTuples.pair(2.0, 2),
                PrimitiveTuples.pair(3.0, 3),
                PrimitiveTuples.pair(4.0, 4),
                PrimitiveTuples.pair(5.0, 5),
                PrimitiveTuples.pair(6.0, 6),
                PrimitiveTuples.pair(7.0, 7),
                PrimitiveTuples.pair(8.0, 8),
                PrimitiveTuples.pair(9.0, 9),
                PrimitiveTuples.pair(10.0, 10));
        MutableList<DoubleIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1.0).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0, 2.0, 3.0).topOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0, 2.0, 3.0).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0, 2.0, 3.0).topOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0, 1.0, 2.0, 3.0).topOccurrences(2));
        Verify.assertSize(2, this.newWith(1.0, 1.0, 2.0, 2.0, 3.0).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0, 1.0, 2.0, 2.0, 3.0, 3.0).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences()
    {
        MutableDoubleBag bag = this.newWithOccurrences(
                PrimitiveTuples.pair(1.0, 1),
                PrimitiveTuples.pair(2.0, 2),
                PrimitiveTuples.pair(3.0, 3),
                PrimitiveTuples.pair(4.0, 4),
                PrimitiveTuples.pair(5.0, 5),
                PrimitiveTuples.pair(6.0, 6),
                PrimitiveTuples.pair(7.0, 7),
                PrimitiveTuples.pair(8.0, 8),
                PrimitiveTuples.pair(9.0, 9),
                PrimitiveTuples.pair(10.0, 10));
        MutableList<DoubleIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1.0).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0, 2.0, 3.0).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0, 2.0, 3.0).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0, 2.0, 3.0).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith(1.0, 1.0, 2.0, 3.0).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0, 1.0, 2.0, 2.0, 3.0).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0, 1.0, 2.0, 2.0, 3.0, 3.0).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void addOccurrences()
    {
        MutableDoubleBag bag = this.newWith();
        bag.addOccurrences(100.0, 3);
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0, 100.0, 100.0), bag);
        bag.addOccurrences(100.0, 2);
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0, 100.0, 100.0, 100.0, 100.0), bag);
        bag.addOccurrences(100.0, 0);
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0, 100.0, 100.0, 100.0, 100.0), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws()
    {
        this.newWith().addOccurrences(100.0, -1);
    }

    @Test
    public void removeOccurrences()
    {
        MutableDoubleBag bag = this.newWith();
        Assert.assertFalse(bag.removeOccurrences(100.0, 2));
        bag.addOccurrences(100.0, 5);
        Assert.assertTrue(bag.removeOccurrences(100.0, 2));
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0, 100.0, 100.0), bag);
        Assert.assertFalse(bag.removeOccurrences(100.0, 0));
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0, 100.0, 100.0), bag);
        Assert.assertTrue(bag.removeOccurrences(100.0, 5));
        Assert.assertEquals(new DoubleHashBag(), bag);
        Assert.assertFalse(bag.removeOccurrences(100.0, 5));
        Assert.assertEquals(new DoubleHashBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws()
    {
        this.newWith().removeOccurrences(100.0, -1);
    }

    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith(1.0, 1.0, 2.0).forEachWithOccurrences((double argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1.022.01".equals(string)
                || "2.011.02".equals(string));
    }

    @Test
    @Override
    public void add()
    {
        super.add();
        MutableDoubleBag bag = this.newWith();
        Assert.assertTrue(bag.add(100.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0), bag);
        Assert.assertTrue(bag.add(100.0));
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0, 100.0), bag);
    }

    @Test
    @Override
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableDoubleBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(DoubleArrayList.newListWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0)));
        Assert.assertFalse(bag.addAll(new DoubleArrayList()));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0), bag);
        Assert.assertTrue(bag.addAll(DoubleHashBag.newBagWith(4.0, 4.0, 4.0, 4.0)));
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0), bag);
    }

    @Test
    @Override
    public void remove()
    {
        super.remove();
        MutableDoubleBag bag = this.newWith();
        Assert.assertFalse(bag.remove(100.0));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new DoubleHashBag(), bag);
        Assert.assertTrue(bag.add(100.0));
        Verify.assertSize(1, bag);
        Assert.assertTrue(bag.add(100.0));
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.remove(100.0));
        Verify.assertSize(1, bag);
        Assert.assertEquals(DoubleHashBag.newBagWith(100.0), bag);
        Assert.assertTrue(bag.remove(100.0));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new DoubleHashBag(), bag);
    }

    @Test
    @Override
    public void doubleIterator()
    {
        MutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        DoubleArrayList list = DoubleArrayList.newListWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        DoubleIterator iterator = bag.doubleIterator();
        for (int i = 0; i < 6; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());

        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void doubleIterator_with_remove()
    {
        super.doubleIterator_with_remove();

        MutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        MutableDoubleIterator iterator = bag.doubleIterator();
        for (int i = 0; i < 6; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
            iterator.remove();
        }

        Verify.assertEmpty(bag);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    @Override
    public void forEach()
    {
        super.forEach();
        double[] sum = new double[1];
        this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0).forEach((double each) -> sum[0] += each);

        Assert.assertEquals(14L, sum[0], 0.0);
    }

    @Test
    @Override
    public void count()
    {
        super.count();
        MutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(5L, bag.count(DoublePredicates.greaterThan(1.0)));
        Assert.assertEquals(1L, bag.count(DoublePredicates.lessThan(2.0)));
        Assert.assertEquals(0L, bag.count(DoublePredicates.greaterThan(4.0)));
    }

    @Test
    @Override
    public void sum()
    {
        super.sum();
        Assert.assertEquals(14.0, this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0).sum(), 0.0);
    }

    @Test
    @Override
    public void testEquals()
    {
        super.testEquals();
        MutableDoubleBag bag1 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        MutableDoubleBag bag2 = this.newWith(0.0, 2.0, 1.0, 2.0, 1.0, 2.0);
        MutableDoubleBag bag3 = this.newWith(0.0, 1.0, 2.0, 2.0, 2.0);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
    }

    @Test
    @Override
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[1.0, 1.0, 1.0]", this.newWith(1.0, 1.0, 1.0).toString());
    }

    @Test
    @Override
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("1.0, 1.0, 1.0", this.newWith(1.0, 1.0, 1.0).makeString());
    }

    @Test
    @Override
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1.0, 1.0, 1.0).appendString(appendable1);
        Assert.assertEquals("1.0, 1.0, 1.0", appendable1.toString());
    }

    @Test
    @Override
    public void toList()
    {
        super.toList();
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 1.0, 1.0), this.newWith(1.0, 1.0, 1.0).toList());
    }

    @Test
    @Override
    public void toSortedList()
    {
        super.toSortedList();
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0), this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0).toSortedList());
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableDoubleBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toStringOfItemToCount()
    {
        MutableDoubleBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100.0 + "=3}", this.newWith(100.0, 100.0, 100.0).toStringOfItemToCount());
        String actual = this.newWith(100.0, 101.0, 101.0).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100.0 + "=1, " + 101.0 + "=2}").equals(actual) || ("{" + 101.0 + "=2, " + 100.0 + "=1}").equals(actual));
    }
}
