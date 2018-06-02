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
import org.eclipse.collections.api.bag.primitive.ImmutableIntBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.api.set.primitive.MutableIntSet;

/**
 * JUnit test for {@link MutableIntBag}.
 * This file was automatically generated from template file abstractMutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractMutableIntBagTestCase extends AbstractMutableIntCollectionTestCase
{
    @Override
    protected abstract MutableIntBag classUnderTest();

    @Override
    protected abstract MutableIntBag newWith(int... elements);

    @Override
    protected MutableIntBag newMutableCollectionWith(int... elements)
    {
        return IntHashBag.newBagWith(elements);
    }

    @Override
    protected MutableBag<Integer> newObjectCollectionWith(Integer... elements)
    {
        return HashBag.newBagWith(elements);
    }

    @Test
    public void sizeDistinct()
    {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0, 1, 2).sizeDistinct());
        Assert.assertEquals(3L, this.newWith(0, 1, 1, 2, 2, 2).sizeDistinct());
    }

    @Test
    public void selectByOccurrences()
    {
        MutableIntBag bag = this.newWith(100, 100, 100, 50, 50);
        MutableIntBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100), filtered);
    }

    @Test
    public void selectDuplicates()
    {
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(IntHashBag.newBagWith(2, 2, 3, 3, 3), bag.selectDuplicates());
    }

    @Test
    public void selectUnique()
    {
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3, 3, 4, 5, 5, 6);
        MutableIntSet expected = IntSets.mutable.with(1, 4, 6);
        MutableIntSet actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    protected MutableIntBag newWithOccurrences(IntIntPair... elementsWithOccurrences)
    {
        MutableIntBag bag = this.newWith();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            IntIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    @Test
    public void topOccurrences()
    {
        MutableIntBag bag = this.newWithOccurrences(
                PrimitiveTuples.pair(1, 1),
                PrimitiveTuples.pair(2, 2),
                PrimitiveTuples.pair(3, 3),
                PrimitiveTuples.pair(4, 4),
                PrimitiveTuples.pair(5, 5),
                PrimitiveTuples.pair(6, 6),
                PrimitiveTuples.pair(7, 7),
                PrimitiveTuples.pair(8, 8),
                PrimitiveTuples.pair(9, 9),
                PrimitiveTuples.pair(10, 10));
        MutableList<IntIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith(1, 2, 3).topOccurrences(5));
        Verify.assertSize(3, this.newWith(1, 2, 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1, 2, 3).topOccurrences(2));
        Verify.assertSize(3, this.newWith(1, 1, 2, 3).topOccurrences(2));
        Verify.assertSize(2, this.newWith(1, 1, 2, 2, 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith(1, 1, 2, 2, 3, 3).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences()
    {
        MutableIntBag bag = this.newWithOccurrences(
                PrimitiveTuples.pair(1, 1),
                PrimitiveTuples.pair(2, 2),
                PrimitiveTuples.pair(3, 3),
                PrimitiveTuples.pair(4, 4),
                PrimitiveTuples.pair(5, 5),
                PrimitiveTuples.pair(6, 6),
                PrimitiveTuples.pair(7, 7),
                PrimitiveTuples.pair(8, 8),
                PrimitiveTuples.pair(9, 9),
                PrimitiveTuples.pair(10, 10));
        MutableList<IntIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith(1).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1, 2, 3).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(1, 2, 3).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith(1, 2, 3).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith(1, 1, 2, 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1, 1, 2, 2, 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(1, 1, 2, 2, 3, 3).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void addOccurrences()
    {
        MutableIntBag bag = this.newWith();
        bag.addOccurrences(100, 3);
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100), bag);
        bag.addOccurrences(100, 2);
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100, 100, 100), bag);
        bag.addOccurrences(100, 0);
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100, 100, 100), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws()
    {
        this.newWith().addOccurrences(100, -1);
    }

    @Test
    public void removeOccurrences()
    {
        MutableIntBag bag = this.newWith();
        Assert.assertFalse(bag.removeOccurrences(100, 2));
        bag.addOccurrences(100, 5);
        Assert.assertTrue(bag.removeOccurrences(100, 2));
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100), bag);
        Assert.assertFalse(bag.removeOccurrences(100, 0));
        Assert.assertEquals(IntHashBag.newBagWith(100, 100, 100), bag);
        Assert.assertTrue(bag.removeOccurrences(100, 5));
        Assert.assertEquals(new IntHashBag(), bag);
        Assert.assertFalse(bag.removeOccurrences(100, 5));
        Assert.assertEquals(new IntHashBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws()
    {
        this.newWith().removeOccurrences(100, -1);
    }

    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith(1, 1, 2).forEachWithOccurrences((int argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1221".equals(string)
                || "2112".equals(string));
    }

    @Test
    @Override
    public void add()
    {
        super.add();
        MutableIntBag bag = this.newWith();
        Assert.assertTrue(bag.add(100));
        Assert.assertEquals(IntHashBag.newBagWith(100), bag);
        Assert.assertTrue(bag.add(100));
        Assert.assertEquals(IntHashBag.newBagWith(100, 100), bag);
    }

    @Test
    @Override
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableIntBag bag = this.newWith();
        Assert.assertTrue(bag.addAll(IntArrayList.newListWith(1, 2, 2, 3, 3, 3)));
        Assert.assertFalse(bag.addAll(new IntArrayList()));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 2, 3, 3, 3), bag);
        Assert.assertTrue(bag.addAll(IntHashBag.newBagWith(4, 4, 4, 4)));
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4), bag);
    }

    @Test
    @Override
    public void remove()
    {
        super.remove();
        MutableIntBag bag = this.newWith();
        Assert.assertFalse(bag.remove(100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new IntHashBag(), bag);
        Assert.assertTrue(bag.add(100));
        Verify.assertSize(1, bag);
        Assert.assertTrue(bag.add(100));
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.remove(100));
        Verify.assertSize(1, bag);
        Assert.assertEquals(IntHashBag.newBagWith(100), bag);
        Assert.assertTrue(bag.remove(100));
        Verify.assertSize(0, bag);
        Assert.assertEquals(new IntHashBag(), bag);
    }

    @Test
    @Override
    public void intIterator()
    {
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        IntArrayList list = IntArrayList.newListWith(1, 2, 2, 3, 3, 3);
        IntIterator iterator = bag.intIterator();
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
    public void intIterator_with_remove()
    {
        super.intIterator_with_remove();

        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        MutableIntIterator iterator = bag.intIterator();
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
        long[] sum = new long[1];
        this.newWith(1, 2, 2, 3, 3, 3).forEach((int each) -> sum[0] += each);

        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count()
    {
        super.count();
        MutableIntBag bag = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(5L, bag.count(IntPredicates.greaterThan(1)));
        Assert.assertEquals(1L, bag.count(IntPredicates.lessThan(2)));
        Assert.assertEquals(0L, bag.count(IntPredicates.greaterThan(4)));
    }

    @Test
    @Override
    public void sum()
    {
        super.sum();
        Assert.assertEquals(14L, this.newWith(1, 2, 2, 3, 3, 3).sum());
    }

    @Test
    @Override
    public void testEquals()
    {
        super.testEquals();
        MutableIntBag bag1 = this.newWith(0, 1, 1, 2, 2, 2);
        MutableIntBag bag2 = this.newWith(0, 2, 1, 2, 1, 2);
        MutableIntBag bag3 = this.newWith(0, 1, 2, 2, 2);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
    }

    @Test
    @Override
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[1, 1, 1]", this.newWith(1, 1, 1).toString());
    }

    @Test
    @Override
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("1, 1, 1", this.newWith(1, 1, 1).makeString());
    }

    @Test
    @Override
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1, 1, 1).appendString(appendable1);
        Assert.assertEquals("1, 1, 1", appendable1.toString());
    }

    @Test
    @Override
    public void toList()
    {
        super.toList();
        Assert.assertEquals(IntArrayList.newListWith(1, 1, 1), this.newWith(1, 1, 1).toList());
    }

    @Test
    @Override
    public void toSortedList()
    {
        super.toSortedList();
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 2, 3, 3, 3), this.newWith(1, 2, 2, 3, 3, 3).toSortedList());
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Assert.assertNotSame(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableIntBag.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toStringOfItemToCount()
    {
        MutableIntBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + 100 + "=3}", this.newWith(100, 100, 100).toStringOfItemToCount());
        String actual = this.newWith(100, 101, 101).toStringOfItemToCount();
        Assert.assertTrue(("{" + 100 + "=1, " + 101 + "=2}").equals(actual) || ("{" + 101 + "=2, " + 100 + "=1}").equals(actual));
    }
}
