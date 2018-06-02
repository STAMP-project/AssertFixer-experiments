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

import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;
import org.eclipse.collections.impl.collection.immutable.primitive.AbstractImmutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ImmutableDoubleList}.
 * This file was automatically generated from template file abstractImmutablePrimitiveListTestCase.stg.
 */
public abstract class AbstractImmutableDoubleListTestCase extends AbstractImmutableDoubleCollectionTestCase
{
    @Override
    protected abstract ImmutableDoubleList classUnderTest();

    @Override
    protected ImmutableDoubleList newWith(double... elements)
    {
        return DoubleLists.immutable.of(elements);
    }

    @Override
    protected MutableDoubleList newMutableCollectionWith(double... elements)
    {
        return DoubleArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Double> newObjectCollectionWith(Double... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test
    public void get()
    {
        ImmutableDoubleList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++)
        {
            Assert.assertEquals(i + 1, list.get(i), 0.0);
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
        Assert.assertEquals(1.0, this.classUnderTest().getFirst(), 0.0);
    }

    @Test
    public void getLast()
    {
        ImmutableDoubleList list = this.classUnderTest();
        Assert.assertEquals(list.size(), list.getLast(), 0.0);
    }

    @Test
    public void indexOf()
    {
        ImmutableDoubleList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++)
        {
            Assert.assertEquals(i, list.indexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.indexOf(list.size() + 1), 0.0);

        ImmutableDoubleList arrayList = this.newWith(1.0, 2.0, 1.0);
        Assert.assertEquals(0L, arrayList.indexOf(1.0));
        Assert.assertEquals(1L, arrayList.indexOf(2.0));
        Assert.assertEquals(-1L, arrayList.indexOf(9.0));
    }

    @Test
    public void lastIndexOf()
    {
        ImmutableDoubleList list = this.classUnderTest();
        for (int i = 0; i < list.size(); i++)
        {
            Assert.assertEquals(i, list.lastIndexOf(i + 1));
        }
        Assert.assertEquals(-1L, list.lastIndexOf(list.size() + 1), 0.0);

        ImmutableDoubleList arrayList = this.newWith(1.0, 2.0, 1.0);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1.0));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2.0));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9.0));
    }

    @Override
    @Test
    public void doubleIterator()
    {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
        for (int i = 0; iterator.hasNext(); i++)
        {
            Assert.assertEquals(i + 1, iterator.next(), 0.0);
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
        ImmutableDoubleList list = this.classUnderTest();
        double[] array = list.toArray();
        Assert.assertEquals(list.size(), array.length);
        for (int i = 0; i < list.size(); i++)
        {
            Assert.assertEquals(list.get(i), array[i], 0.0);
        }
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableDoubleList iterable = this.newWith(1.0, 2.0, 3.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }

    @Test
    public void injectIntoWithIndex()
    {
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        ImmutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0);
        MutableDouble result = list1.injectIntoWithIndex(new MutableDouble(0.0),
            (MutableDouble object, double value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableDouble(14.0), result);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        ImmutableList<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(DoubleIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                DoubleLists.mutable.with(3.0, 1.0, 9.0, 7.0),
                pairs.collectDouble(DoubleIntPair::getOne, DoubleLists.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(DoubleIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                DoubleLists.mutable.with(3.0, 1.0, 9.0, 7.0),
                pairs.collectDouble(DoubleIntPair::getOne, DoubleLists.mutable.empty()));

        MutableSet<DoubleIntPair> set = this.newWith(3.0, 1.0, 9.0, 7.0)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(DoubleIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                DoubleSets.mutable.with(3.0, 1.0, 9.0, 7.0),
                pairs.collectDouble(DoubleIntPair::getOne, DoubleSets.mutable.empty()));
    }

    @Test
    public void distinct()
    {
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0).distinct();
        ImmutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0, 4.0);
        Assert.assertEquals(list1, list2);
    }

    @Test
    public void toReversed()
    {
        Assert.assertEquals(ImmutableDoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0), this.newWith(7.0, 9.0, 1.0, 3.0).toReversed());
        ImmutableDoubleList list1 = this.newWith(3.0, 1.0, 9.0, 7.0);
        Assert.assertNotSame(list1, list1.toReversed());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0, 8.0), this.newWith(8.0, 7.0, 9.0, 1.0, 3.0).toReversed());
        ImmutableDoubleList list2 = this.newWith(3.0, 1.0, 9.0, 7.0, 8.0);
        Assert.assertNotSame(list2, list2.toReversed());
    }

    @Test
    public void forEachWithIndex()
    {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((double each, int index) -> sum[0] += each + index);

        Assert.assertEquals(9.0, sum[0], 0.0);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0, 4.0);
        ImmutableDoubleList list2 = this.newWith(4.0, 3.0, 2.0, 1.0);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString()
    {
        super.testToString();
        StringBuilder expectedString = new StringBuilder("[");
        int size = this.classUnderTest().size();
        for (double each = 0; each < size; each++)
        {
            expectedString.append((double) (each + 1.0));
            expectedString.append((int) each == size - 1 ? "" : ", ");
        }
        expectedString.append(']');
        Assert.assertEquals(expectedString.toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString()
    {
        super.makeString();
        ImmutableDoubleList list = this.classUnderTest();
        StringBuilder expectedString = new StringBuilder("");
        StringBuilder expectedString1 = new StringBuilder("");
        int size = list.size();
        for (double each = 0; each < size; each++)
        {
            expectedString.append((double) (each + 1.0));
            expectedString1.append((double) (each + 1.0));
            expectedString.append((int) each == size - 1 ? "" : ", ");
            expectedString1.append((int) each == size - 1 ? "" : "/");
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
        for (double each = 0; each < size; each++)
        {
            expectedString.append((double) (each + 1.0));
            expectedString1.append((double) (each + 1.0));
            expectedString.append((int) each == size - 1 ? "" : ", ");
            expectedString1.append((int) each == size - 1 ? "" : "/");
        }
        ImmutableDoubleList list = this.classUnderTest();
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
        ImmutableDoubleList immutableList = this.classUnderTest();
        MutableDoubleList list = immutableList.toList();
        Verify.assertEqualsAndHashCode(immutableList, list);
        Assert.assertNotSame(immutableList, list);
    }

    @Test
    public void zipDouble()
    {
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        ImmutableDoubleList list2 = this.newWith(1.0);
        ImmutableList<DoubleDoublePair> zipSame = list1.zipDouble(list1);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, 1.0),
                    PrimitiveTuples.pair(2.0, 2.0),
                    PrimitiveTuples.pair(3.0, 3.0)),
                zipSame);
        ImmutableList<DoubleDoublePair> zipSameLazy = list1.zipDouble(list1.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, 1.0),
                    PrimitiveTuples.pair(2.0, 2.0),
                    PrimitiveTuples.pair(3.0, 3.0)),
                zipSameLazy);
        ImmutableList<DoubleDoublePair> zipLess = list1.zipDouble(list2);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, 1.0)),
                zipLess);
        ImmutableList<DoubleDoublePair> zipLessLazy = list1.zipDouble(list2.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, 1.0)),
                zipLessLazy);
        ImmutableList<DoubleDoublePair> zipMore = list2.zipDouble(list1);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, 1.0)),
                zipMore);
        ImmutableList<DoubleDoublePair> zipMoreLazy = list2.zipDouble(list1.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, 1.0)),
                zipMoreLazy);
        ImmutableList<DoubleDoublePair> zipEmpty1 = list1.zipDouble(this.newWith());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<DoubleDoublePair> zipEmpty2 = this.newWith().zipDouble(list1);
        Assert.assertTrue(zipEmpty2.isEmpty());
    }

    @Test
    public void zip()
    {
        ImmutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        ImmutableDoubleList list2 = this.newWith(1.0);
        ImmutableList<String> list3 = Lists.immutable.with("1", "2", "3");
        ImmutableList<String> list4 = Lists.immutable.with("1");
        ImmutableList<DoubleObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, "1"),
                    PrimitiveTuples.pair(2.0, "2"),
                    PrimitiveTuples.pair(3.0, "3")),
                zipSame);
        ImmutableList<DoubleObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, "1"),
                    PrimitiveTuples.pair(2.0, "2"),
                    PrimitiveTuples.pair(3.0, "3")),
                zipSameLazy);
        ImmutableList<DoubleObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, "1")),
                zipLess);
        ImmutableList<DoubleObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, "1")),
                zipLessLazy);
        ImmutableList<DoubleObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, "1")),
                zipMore);
        ImmutableList<DoubleObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.immutable.with(
                    PrimitiveTuples.pair(1.0, "1")),
                zipMoreLazy);
        ImmutableList<DoubleObjectPair<String>> zipEmpty1 = list1.zip(Lists.immutable.empty());
        Assert.assertTrue(zipEmpty1.isEmpty());
        ImmutableList<DoubleObjectPair<String>> zipEmpty2 = this.newWith().zip(Lists.immutable.with("1", "2"));
        Assert.assertTrue(zipEmpty2.isEmpty());
    }
}
