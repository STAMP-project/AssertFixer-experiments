/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.bag.immutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.api.set.primitive.ImmutableDoubleSet;

/**
 * JUnit test for {@link ImmutableDoubleBag}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractImmutableDoubleBagTestCase extends AbstractImmutableDoubleCollectionTestCase
{
    @Override
    protected abstract ImmutableDoubleBag classUnderTest();

    @Override
    protected ImmutableDoubleBag newWith(double... elements)
    {
        return DoubleBags.immutable.of(elements);
    }

    @Override
    protected MutableDoubleBag newMutableCollectionWith(double... elements)
    {
        return DoubleHashBag.newBagWith(elements);
    }

    @Override
    protected ImmutableBag<Double> newObjectCollectionWith(Double... elements)
    {
        return HashBag.newBagWith(elements).toImmutable();
    }

    @Test
    public void sizeDistinct()
    {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith(1.0).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0.0, 1.0, 2.0).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0).sizeDistinct());
    }

    @Test
    public void selectByOccurrences()
    {
        ImmutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        ImmutableDoubleBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(DoubleHashBag.newBagWith(3.0, 3.0, 3.0), filtered);
    }

    @Test
    public void selectDuplicates()
    {
        ImmutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
        Assert.assertEquals(DoubleHashBag.newBagWith(2.0, 2.0, 3.0, 3.0, 3.0), bag.selectDuplicates());
    }

    @Test
    public void selectUnique()
    {
       ImmutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0, 3.0, 4.0, 5.0, 5.0, 6.0);
       ImmutableDoubleSet expected = DoubleSets.immutable.with(1.0, 4.0, 6.0);
       ImmutableDoubleSet actual = bag.selectUnique();
       Assert.assertEquals(expected, actual);
    }

    protected ImmutableDoubleBag newWithOccurrences(DoubleIntPair... elementsWithOccurrences)
    {
        MutableDoubleBag bag = DoubleBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            DoubleIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.toImmutable();
    }

    @Test
    public void topOccurrences()
    {
        ImmutableDoubleBag bag = this.newWithOccurrences(
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
        ImmutableList<DoubleIntPair> top5 = bag.topOccurrences(5);
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
        ImmutableDoubleBag bag = this.newWithOccurrences(
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
        ImmutableList<DoubleIntPair> bottom5 = bag.bottomOccurrences(5);
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
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith(1.0, 1.0, 2.0).forEachWithOccurrences(
            (double argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1.022.01".equals(string)
                || "2.011.02".equals(string));
    }

    @Test
    @Override
    public void doubleIterator()
    {
        ImmutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
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
        ImmutableDoubleBag bag = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0);
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
        ImmutableDoubleBag bag1 = this.newWith(0.0, 1.0, 1.0, 2.0, 2.0, 2.0);
        ImmutableDoubleBag bag2 = this.newWith(0.0, 2.0, 1.0, 2.0, 1.0, 2.0);
        ImmutableDoubleBag bag3 = this.newWith(0.0, 1.0, 2.0, 2.0, 2.0);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
        Assert.assertNotEquals(this.newWith(), DoubleArrayList.newListWith());
        Assert.assertNotEquals(this.newWith(1.0), DoubleArrayList.newListWith(1.0));
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
        ImmutableDoubleBag expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @Test
    public void toStringOfItemToCount()
    {
        ImmutableDoubleBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100.0 + "=3}", this.newWith(100.0, 100.0, 100.0).toStringOfItemToCount());
        String actual = this.newWith(100.0, 101.0, 101.0).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100.0 + "=1, " + 101.0 + "=2}").equals(actual) || ("{" + 101.0 + "=2, " + 100.0 + "=1}").equals(actual));
    }
}
