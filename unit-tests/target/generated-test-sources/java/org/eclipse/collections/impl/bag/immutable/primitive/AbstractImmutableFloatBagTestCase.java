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
import org.eclipse.collections.api.bag.primitive.ImmutableFloatBag;
import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableFloatCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.api.set.primitive.ImmutableFloatSet;

/**
 * JUnit test for {@link ImmutableFloatBag}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractImmutableFloatBagTestCase extends AbstractImmutableFloatCollectionTestCase
{
    @Override
    protected abstract ImmutableFloatBag classUnderTest();

    @Override
    protected ImmutableFloatBag newWith(float... elements)
    {
        return FloatBags.immutable.of(elements);
    }

    @Override
    protected MutableFloatBag newMutableCollectionWith(float... elements)
    {
        return FloatHashBag.newBagWith(elements);
    }

    @Override
    protected ImmutableBag<Float> newObjectCollectionWith(Float... elements)
    {
        return HashBag.newBagWith(elements).toImmutable();
    }

    @Test
    public void sizeDistinct()
    {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith(1.0f).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0.0f, 1.0f, 2.0f).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f).sizeDistinct());
    }

    @Test
    public void selectByOccurrences()
    {
        ImmutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        ImmutableFloatBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(FloatHashBag.newBagWith(3.0f, 3.0f, 3.0f), filtered);
    }

    @Test
    public void selectDuplicates()
    {
        ImmutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(FloatHashBag.newBagWith(2.0f, 2.0f, 3.0f, 3.0f, 3.0f), bag.selectDuplicates());
    }

    @Test
    public void selectUnique()
    {
       ImmutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f, 3.0f, 4.0f, 5.0f, 5.0f, 6.0f);
       ImmutableFloatSet expected = FloatSets.immutable.with(1.0f, 4.0f, 6.0f);
       ImmutableFloatSet actual = bag.selectUnique();
       Assert.assertEquals(expected, actual);
    }

    protected ImmutableFloatBag newWithOccurrences(FloatIntPair... elementsWithOccurrences)
    {
        MutableFloatBag bag = FloatBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            FloatIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.toImmutable();
    }

    @Test
    public void topOccurrences()
    {
        ImmutableFloatBag bag = this.newWithOccurrences(
                PrimitiveTuples.pair(1.0f, 1),
                PrimitiveTuples.pair(2.0f, 2),
                PrimitiveTuples.pair(3.0f, 3),
                PrimitiveTuples.pair(4.0f, 4),
                PrimitiveTuples.pair(5.0f, 5),
                PrimitiveTuples.pair(6.0f, 6),
                PrimitiveTuples.pair(7.0f, 7),
                PrimitiveTuples.pair(8.0f, 8),
                PrimitiveTuples.pair(9.0f, 9),
                PrimitiveTuples.pair(10.0f, 10));
        ImmutableList<FloatIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1.0f).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).topOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).topOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0f, 1.0f, 2.0f, 3.0f).topOccurrences(2));
        Verify.assertSize(2, this.newWith(1.0f, 1.0f, 2.0f, 2.0f, 3.0f).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences()
    {
        ImmutableFloatBag bag = this.newWithOccurrences(
                PrimitiveTuples.pair(1.0f, 1),
                PrimitiveTuples.pair(2.0f, 2),
                PrimitiveTuples.pair(3.0f, 3),
                PrimitiveTuples.pair(4.0f, 4),
                PrimitiveTuples.pair(5.0f, 5),
                PrimitiveTuples.pair(6.0f, 6),
                PrimitiveTuples.pair(7.0f, 7),
                PrimitiveTuples.pair(8.0f, 8),
                PrimitiveTuples.pair(9.0f, 9),
                PrimitiveTuples.pair(10.0f, 10));
        ImmutableList<FloatIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1.0f).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith(1.0f, 2.0f, 3.0f).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith(1.0f, 1.0f, 2.0f, 3.0f).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0f, 1.0f, 2.0f, 2.0f, 3.0f).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1.0f, 1.0f, 2.0f, 2.0f, 3.0f, 3.0f).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith(1.0f, 1.0f, 2.0f).forEachWithOccurrences(
            (float argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1.022.01".equals(string)
                || "2.011.02".equals(string));
    }

    @Test
    @Override
    public void floatIterator()
    {
        ImmutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        FloatArrayList list = FloatArrayList.newListWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        FloatIterator iterator = bag.floatIterator();
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
        this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).forEach((float each) -> sum[0] += each);

        Assert.assertEquals(14L, sum[0], 0.0f);
    }

    @Test
    @Override
    public void count()
    {
        super.count();
        ImmutableFloatBag bag = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f);
        Assert.assertEquals(5L, bag.count(FloatPredicates.greaterThan(1.0f)));
        Assert.assertEquals(1L, bag.count(FloatPredicates.lessThan(2.0f)));
        Assert.assertEquals(0L, bag.count(FloatPredicates.greaterThan(4.0f)));
    }

    @Test
    @Override
    public void sum()
    {
        super.sum();
        Assert.assertEquals(14.0, this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).sum(), 0.0);
    }

    @Test
    @Override
    public void testEquals()
    {
        super.testEquals();
        ImmutableFloatBag bag1 = this.newWith(0.0f, 1.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        ImmutableFloatBag bag2 = this.newWith(0.0f, 2.0f, 1.0f, 2.0f, 1.0f, 2.0f);
        ImmutableFloatBag bag3 = this.newWith(0.0f, 1.0f, 2.0f, 2.0f, 2.0f);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
        Assert.assertNotEquals(this.newWith(), FloatArrayList.newListWith());
        Assert.assertNotEquals(this.newWith(1.0f), FloatArrayList.newListWith(1.0f));
    }

    @Test
    @Override
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[1.0, 1.0, 1.0]", this.newWith(1.0f, 1.0f, 1.0f).toString());
    }

    @Test
    @Override
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("1.0, 1.0, 1.0", this.newWith(1.0f, 1.0f, 1.0f).makeString());
    }

    @Test
    @Override
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1.0f, 1.0f, 1.0f).appendString(appendable1);
        Assert.assertEquals("1.0, 1.0, 1.0", appendable1.toString());
    }

    @Test
    @Override
    public void toList()
    {
        super.toList();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 1.0f, 1.0f), this.newWith(1.0f, 1.0f, 1.0f).toList());
    }

    @Test
    @Override
    public void toSortedList()
    {
        super.toSortedList();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f), this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f).toSortedList());
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        ImmutableFloatBag expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @Test
    public void toStringOfItemToCount()
    {
        ImmutableFloatBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100.0f + "=3}", this.newWith(100.0f, 100.0f, 100.0f).toStringOfItemToCount());
        String actual = this.newWith(100.0f, 101.0f, 101.0f).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100.0f + "=1, " + 101.0f + "=2}").equals(actual) || ("{" + 101.0f + "=2, " + 100.0f + "=1}").equals(actual));
    }
}
