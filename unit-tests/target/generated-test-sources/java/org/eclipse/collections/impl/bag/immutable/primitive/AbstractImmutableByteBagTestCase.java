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
import org.eclipse.collections.api.bag.primitive.ImmutableByteBag;
import org.eclipse.collections.api.bag.primitive.MutableByteBag;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableByteCollectionTestCase;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.api.set.primitive.ImmutableByteSet;

/**
 * JUnit test for {@link ImmutableByteBag}.
 * This file was automatically generated from template file abstractImmutablePrimitiveBagTestCase.stg.
 */
public abstract class AbstractImmutableByteBagTestCase extends AbstractImmutableByteCollectionTestCase
{
    @Override
    protected abstract ImmutableByteBag classUnderTest();

    @Override
    protected ImmutableByteBag newWith(byte... elements)
    {
        return ByteBags.immutable.of(elements);
    }

    @Override
    protected MutableByteBag newMutableCollectionWith(byte... elements)
    {
        return ByteHashBag.newBagWith(elements);
    }

    @Override
    protected ImmutableBag<Byte> newObjectCollectionWith(Byte... elements)
    {
        return HashBag.newBagWith(elements).toImmutable();
    }

    @Test
    public void sizeDistinct()
    {
        Assert.assertEquals(0L, this.newWith().sizeDistinct());
        Assert.assertEquals(1L, this.newWith((byte) 1).sizeDistinct());
        Assert.assertEquals(3L, this.newWith((byte) 0, (byte) 1, (byte) 2).sizeDistinct());
        Assert.assertEquals(3L, this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2).sizeDistinct());
    }

    @Test
    public void selectByOccurrences()
    {
        ImmutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        ImmutableByteBag filtered = bag.selectByOccurrences(i -> i > 2);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 3, (byte) 3, (byte) 3), filtered);
    }

    @Test
    public void selectDuplicates()
    {
        ImmutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), bag.selectDuplicates());
    }

    @Test
    public void selectUnique()
    {
       ImmutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3, (byte) 3, (byte) 4, (byte) 5, (byte) 5, (byte) 6);
       ImmutableByteSet expected = ByteSets.immutable.with((byte) 1, (byte) 4, (byte) 6);
       ImmutableByteSet actual = bag.selectUnique();
       Assert.assertEquals(expected, actual);
    }

    protected ImmutableByteBag newWithOccurrences(ByteIntPair... elementsWithOccurrences)
    {
        MutableByteBag bag = ByteBags.mutable.empty();
        for (int i = 0; i < elementsWithOccurrences.length; i++)
        {
            ByteIntPair itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.toImmutable();
    }

    @Test
    public void topOccurrences()
    {
        ImmutableByteBag bag = this.newWithOccurrences(
                PrimitiveTuples.pair((byte) 1, 1),
                PrimitiveTuples.pair((byte) 2, 2),
                PrimitiveTuples.pair((byte) 3, 3),
                PrimitiveTuples.pair((byte) 4, 4),
                PrimitiveTuples.pair((byte) 5, 5),
                PrimitiveTuples.pair((byte) 6, 6),
                PrimitiveTuples.pair((byte) 7, 7),
                PrimitiveTuples.pair((byte) 8, 8),
                PrimitiveTuples.pair((byte) 9, 9),
                PrimitiveTuples.pair((byte) 10, 10));
        ImmutableList<ByteIntPair> top5 = bag.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith((byte) 1).topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).topOccurrences(5));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).topOccurrences(2));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 3).topOccurrences(2));
        Verify.assertSize(2, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3).topOccurrences(1));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3).topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences()
    {
        ImmutableByteBag bag = this.newWithOccurrences(
                PrimitiveTuples.pair((byte) 1, 1),
                PrimitiveTuples.pair((byte) 2, 2),
                PrimitiveTuples.pair((byte) 3, 3),
                PrimitiveTuples.pair((byte) 4, 4),
                PrimitiveTuples.pair((byte) 5, 5),
                PrimitiveTuples.pair((byte) 6, 6),
                PrimitiveTuples.pair((byte) 7, 7),
                PrimitiveTuples.pair((byte) 8, 8),
                PrimitiveTuples.pair((byte) 9, 9),
                PrimitiveTuples.pair((byte) 10, 10));
        ImmutableList<ByteIntPair> bottom5 = bag.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith((byte) 1).bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).bottomOccurrences(5));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).bottomOccurrences(1));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 2, (byte) 3).bottomOccurrences(2));
        Verify.assertSize(2, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3).bottomOccurrences(2));
        Verify.assertSize(3, this.newWith((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3).bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void forEachWithOccurrences()
    {
        StringBuilder stringBuilder = new StringBuilder();
        this.newWith((byte) 1, (byte) 1, (byte) 2).forEachWithOccurrences(
            (byte argument1, int argument2) -> stringBuilder.append(argument1).append(argument2));
        String string = stringBuilder.toString();
        Assert.assertTrue("1221".equals(string)
                || "2112".equals(string));
    }

    @Test
    @Override
    public void byteIterator()
    {
        ImmutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        ByteArrayList list = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        ByteIterator iterator = bag.byteIterator();
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
        long[] sum = new long[1];
        this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).forEach((byte each) -> sum[0] += each);

        Assert.assertEquals(14L, sum[0]);
    }

    @Test
    @Override
    public void count()
    {
        super.count();
        ImmutableByteBag bag = this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3);
        Assert.assertEquals(5L, bag.count(BytePredicates.greaterThan((byte) 1)));
        Assert.assertEquals(1L, bag.count(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(0L, bag.count(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    @Override
    public void sum()
    {
        super.sum();
        Assert.assertEquals(14L, this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).sum());
    }

    @Test
    @Override
    public void testEquals()
    {
        super.testEquals();
        ImmutableByteBag bag1 = this.newWith((byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        ImmutableByteBag bag2 = this.newWith((byte) 0, (byte) 2, (byte) 1, (byte) 2, (byte) 1, (byte) 2);
        ImmutableByteBag bag3 = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 2, (byte) 2);
        Verify.assertEqualsAndHashCode(bag1, bag2);
        Assert.assertNotEquals(bag1, bag3);
        Assert.assertNotEquals(bag2, bag3);
        Assert.assertNotEquals(this.newWith(), ByteArrayList.newListWith());
        Assert.assertNotEquals(this.newWith((byte) 1), ByteArrayList.newListWith((byte) 1));
    }

    @Test
    @Override
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[1, 1, 1]", this.newWith((byte) 1, (byte) 1, (byte) 1).toString());
    }

    @Test
    @Override
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("1, 1, 1", this.newWith((byte) 1, (byte) 1, (byte) 1).makeString());
    }

    @Test
    @Override
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable1 = new StringBuilder();
        this.newWith((byte) 1, (byte) 1, (byte) 1).appendString(appendable1);
        Assert.assertEquals("1, 1, 1", appendable1.toString());
    }

    @Test
    @Override
    public void toList()
    {
        super.toList();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 1, (byte) 1), this.newWith((byte) 1, (byte) 1, (byte) 1).toList());
    }

    @Test
    @Override
    public void toSortedList()
    {
        super.toSortedList();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3), this.newWith((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 3).toSortedList());
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        ImmutableByteBag expected = this.classUnderTest();
        Assert.assertSame(expected, expected.toImmutable());
    }

    @Test
    public void toStringOfItemToCount()
    {
        ImmutableByteBag empty = this.newWith();
        Assert.assertEquals("{}", empty.toStringOfItemToCount());
        Assert.assertEquals("{" + (byte) 100 + "=3}", this.newWith((byte) 100, (byte) 100, (byte) 100).toStringOfItemToCount());
        String actual = this.newWith((byte) 100, (byte) 101, (byte) 101).toStringOfItemToCount();
        Assert.assertTrue(("{" + (byte) 100 + "=1, " + (byte) 101 + "=2}").equals(actual) || ("{" + (byte) 101 + "=2, " + (byte) 100 + "=1}").equals(actual));
    }
}
