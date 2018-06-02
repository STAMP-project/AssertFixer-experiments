/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.api.tuple.primitive.IntObjectPair;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableIntCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableIntList}.
 * This file was automatically generated from template file abstractImmutablePrimitiveListTestCase.stg.
 */
public abstract class AbstractImmutableIntListTestCase extends AbstractImmutableIntCollectionTestCase
{
    @Override
    protected abstract ImmutableIntList classUnderTest();

    @Override
    protected ImmutableIntList newWith(int... elements)
    {
        return IntLists.immutable.of(elements);
    }

    @Override
    protected MutableIntList newMutableCollectionWith(int... elements)
    {
        return IntArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Integer> newObjectCollectionWith(Integer... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test
    public void get()
    {
        ImmutableIntList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++)
        {
            Assert.assertEquals(i + 1, list.get(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_greater_than_size()
    {
        this.classUnderTest().get(this.classUnderTest().size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_negative()
    {
        this.classUnderTest().get(-1);
    }

    @Test
    public void getFirst()
    {
        Assert.assertEquals(1L, this.classUnderTest().getFirst());
    }

    @Test
    public void getLast()
    {
        ImmutableIntList list = this.classUnderTest();
        Assert.assertEquals(list.size(), list.getLast());
    }

    @Test
    public void indexOf()
    {
        ImmutableIntList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++)
        {
            Assert.assertEquals(i, list.indexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.indexOf(list.size() + 1));

        ImmutableIntList arrayList = this.newWith(1, 2, 1);
        Assert.assertEquals(0L, arrayList.indexOf(1));
        Assert.assertEquals(1L, arrayList.indexOf(2));
        Assert.assertEquals(-1L, arrayList.indexOf(9));
    }

    @Test
    public void lastIndexOf()
    {
        ImmutableIntList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++)
        {
            Assert.assertEquals(i, list.lastIndexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.lastIndexOf(list.size() + 1));

        ImmutableIntList arrayList = this.newWith(1, 2, 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9));
    }

    @Override
    @Test
    public void intIterator()
    {
        IntIterator iterator = this.classUnderTest().intIterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            Assert.assertEquals(i + 1, iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList()
    {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void toArray()
    {
        super.toArray();
        ImmutableIntList list = this.classUnderTest();
        int[] array = list.toArray();
        Assert.assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++)
        {
            Assert.assertEquals(list.get(i), array[i]);
        }
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableIntList iterable = this.newWith(1, 2, 3);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }

    @Test
    public void injectIntoWithIndex()
    {
        ImmutableIntList list1 = this.newWith(1, 2, 3);
        ImmutableIntList list2 = this.newWith(1, 2, 3);
        MutableInteger result = list1.injectIntoWithIndex(new MutableInteger(0),
            (MutableInteger object, int value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableInteger(14), result);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        ImmutableList<IntIntPair> pairs = this.newWith(3, 1, 9, 7)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(IntIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                IntLists.mutable.with(3, 1, 9, 7),
                pairs.collectInt(IntIntPair::getOne, IntLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<IntIntPair> pairs = this.newWith(3, 1, 9, 7)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(IntIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                IntLists.mutable.with(3, 1, 9, 7),
                pairs.collectInt(IntIntPair::getOne, IntLists.mutable.empty()));

        MutableSet<IntIntPair> set = this.newWith(3, 1, 9, 7)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(IntIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                IntSets.mutable.with(3, 1, 9, 7),
                pairs.collectInt(IntIntPair::getOne, IntSets.mutable.empty()));
    }

    @Test
    public void distinct()
    {
        ImmutableIntList list1 = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).distinct();
        ImmutableIntList list2 = this.newWith(1, 2, 3, 4);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void toReversed()
    {
        Assert.assertEquals(ImmutableIntArrayList.newListWith(3, 1, 9, 7), this.newWith(7, 9, 1, 3).toReversed());
        ImmutableIntList list1 = this.newWith(3, 1, 9, 7);
        Assert.assertNotSame(list1, list1.toReversed());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7, 8), this.newWith(8, 7, 9, 1, 3).toReversed());
        ImmutableIntList list2 = this.newWith(3, 1, 9, 7, 8);
        Assert.assertNotSame(list2, list2.toReversed());
    }

    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((int each, int index) -> sum[0] += each + index);

        Assert.assertEquals(9L, sum[0]);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        ImmutableIntList list1 = this.newWith(1, 2, 3, 4);
        ImmutableIntList list2 = this.newWith(4, 3, 2, 1);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString()
    {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (int each = 0; each < size; each++)
        {
            expectedString.append(each + 1);
            expectedString.append(each == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString()
    {
        super.makeString();
        ImmutableIntList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder("");
        StringBuilder expectedString1 = new StringBuilder("");
        int size = list.size();
        for (int each = 0; each < size; each++)
        {
            expectedString.append(each + 1);
            expectedString1.append(each + 1);
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        Assert.assertEquals(expectedString.toString(), list.makeString());
        Assert.assertEquals(expectedString1.toString(), list.makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString()
    {
        super.appendString();
        StringBuilder expectedString = new StringBuilder("");
        StringBuilder expectedString1 = new StringBuilder("");
        int size = this.classUnderTest().size();
        for (int each = 0; each < size; each++)
        {
            expectedString.append(each + 1);
            expectedString1.append(each + 1);
            expectedString.append(each == size - 1 ? "" : ", ");
            expectedString1.append(each == size - 1 ? "" : "/");
        }
        ImmutableIntList list = this.classUnderTest();
        StringBuilder appendable2 = new StringBuilder();
        list.appendString(appendable2);
        Assert.assertEquals(expectedString.toString(), appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        list.appendString(appendable3, "/");
        Assert.assertEquals(expectedString1.toString(), appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList()
    {
        super.toList();
        ImmutableIntList immutableList = this.classUnderTest();
        MutableIntList list = immutableList.toList();
        Verify.assertEqualsAndHashCode(immutableList, list);
        Assert.assertNotSame(immutableList, list);
    }

    @Test
    public void zipInt()
    {
        ImmutableIntList list1 = this.newWith(1, 2, 3);
        ImmutableIntList list2 = this.newWith(1);
        ImmutableList<IntIntPair> zipSame = list1.zipInt(list1);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, 1),
                    PrimitiveTuples.pair(2, 2),
                    PrimitiveTuples.pair(3, 3)),
                zipSame);
        ImmutableList<IntIntPair> zipSameLazy = list1.zipInt(list1.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, 1),
                    PrimitiveTuples.pair(2, 2),
                    PrimitiveTuples.pair(3, 3)),
                zipSameLazy);
        ImmutableList<IntIntPair> zipLess = list1.zipInt(list2);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, 1)),
                zipLess);
        ImmutableList<IntIntPair> zipLessLazy = list1.zipInt(list2.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, 1)),
                zipLessLazy);
        ImmutableList<IntIntPair> zipMore = list2.zipInt(list1);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, 1)),
                zipMore);
        ImmutableList<IntIntPair> zipMoreLazy = list2.zipInt(list1.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, 1)),
                zipMoreLazy);
        ImmutableList<IntIntPair> zipEmpty1 = list1.zipInt(this.newWith());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<IntIntPair> zipEmpty2 = this.newWith().zipInt(list1);
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void zip()
    {
        ImmutableIntList list1 = this.newWith(1, 2, 3);
        ImmutableIntList list2 = this.newWith(1);
        ImmutableList<String> list3 = Lists.immutable.with("1", "2", "3");
        ImmutableList<String> list4 = Lists.immutable.with("1");
        ImmutableList<IntObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, "1"),
                    PrimitiveTuples.pair(2, "2"),
                    PrimitiveTuples.pair(3, "3")),
                zipSame);
        ImmutableList<IntObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, "1"),
                    PrimitiveTuples.pair(2, "2"),
                    PrimitiveTuples.pair(3, "3")),
                zipSameLazy);
        ImmutableList<IntObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, "1")),
                zipLess);
        ImmutableList<IntObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, "1")),
                zipLessLazy);
        ImmutableList<IntObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, "1")),
                zipMore);
        ImmutableList<IntObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1, "1")),
                zipMoreLazy);
        ImmutableList<IntObjectPair<String>> zipEmpty1 = list1.zip(Lists.immutable.empty());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<IntObjectPair<String>> zipEmpty2 = this.newWith().zip(Lists.immutable.with("1", "2"));
        Assert.assertTrue(zipEmpty2.isEmpty());
    }
}
