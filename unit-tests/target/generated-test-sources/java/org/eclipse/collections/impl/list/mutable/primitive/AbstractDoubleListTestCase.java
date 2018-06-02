/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.mutable.primitive;

import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.DoubleIntPair;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableDoubleCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.stack.mutable.primitive.DoubleArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableDoubleList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractDoubleListTestCase extends AbstractMutableDoubleCollectionTestCase
{
    @Override
    protected abstract MutableDoubleList classUnderTest();

    @Override
    protected abstract MutableDoubleList newWith(double... elements);

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
        MutableDoubleList list = this.classUnderTest();
        Assert.assertEquals(1.0, list.get(0), 0.0);
        Assert.assertEquals(2.0, list.get(1), 0.0);
        Assert.assertEquals(3.0, list.get(2), 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_greater_than_size()
    {
        this.classUnderTest().get(3);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get_throws_index_negative()
    {
        this.classUnderTest().get(-1);
    }

    @Test
    public void getFirst()
    {
        MutableDoubleList singleItemList = this.newWith(1.0);
        Assert.assertEquals(1.0, singleItemList.getFirst(), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().getFirst(), 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws()
    {
        this.newWith().getFirst();
    }

    @Test
    public void getLast()
    {
        MutableDoubleList singleItemList = this.newWith(1.0);
        Assert.assertEquals(1.0, singleItemList.getLast(), 0.0);
        Assert.assertEquals(3.0, this.classUnderTest().getLast(), 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws()
    {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct()
    {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf()
    {
        MutableDoubleList arrayList = this.newWith(1.0, 2.0, 1.0);
        Assert.assertEquals(0L, arrayList.indexOf(1.0));
        Assert.assertEquals(1L, arrayList.indexOf(2.0));
        Assert.assertEquals(-1L, arrayList.indexOf(9.0));
    }

    @Test
    public void lastIndexOf()
    {
        MutableDoubleList arrayList = this.newWith(1.0, 2.0, 1.0);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1.0));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2.0));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9.0));
    }

    @Test
    public void addAtIndex()
    {
        MutableDoubleList emptyList = this.newWith();
        emptyList.addAtIndex(0, 1.0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0), emptyList);
        MutableDoubleList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, 4.0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0), arrayList);
        arrayList.addAtIndex(2, 5.0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 5.0, 3.0, 4.0), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        this.newWith().addAtIndex(1, 0.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.classUnderTest().addAtIndex(-1, 4.0);
    }

    @Override
    @Test
    public void addAllArray()
    {
        super.addAllArray();
        MutableDoubleList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(4.0, 5.0, 6.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), list);
        Assert.assertTrue(list.addAllAtIndex(4, 5.0, 6.0));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 6.0), list);
    }

    @Override
    @Test
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableDoubleList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(DoubleArrayList.newListWith(4.0, 5.0, 6.0)));
        Assert.assertTrue(list.addAll(DoubleArrayStack.newStackWith(8.0, 7.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0), list);
        Assert.assertTrue(list.addAllAtIndex(4, DoubleArrayList.newListWith(5.0, 6.0)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 5.0, 6.0, 7.0, 8.0), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, 5.0, 6.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, 5.0, 6.0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, DoubleArrayList.newListWith(1.0, 2.0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, DoubleArrayList.newListWith(1.0, 2.0));
    }

    @Test
    public void removeAtIndex()
    {
        MutableDoubleList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 3.0), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtIndex_throws_index_greater_than_size()
    {
        this.newWith().removeAtIndex(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeAtIndex_throws_index_negative()
    {
        this.classUnderTest().removeAtIndex(-1);
    }

    @Test
    public void set()
    {
        MutableDoubleList list = this.classUnderTest();
        list.set(1, 4.0);
        Assert.assertEquals(this.newMutableCollectionWith(1.0, 4.0, 3.0), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList()
    {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void doubleIterator()
    {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void toArray()
    {
        super.toArray();
        Assert.assertArrayEquals(new double[]{1.0, 2.0, 4.0, 3.0}, this.newWith(1.0, 2.0, 4.0, 3.0).toArray(), 0.0);
    }

    @Test
    public void reverseThis()
    {
        Assert.assertEquals(new DoubleArrayList(), this.newWith().reverseThis());
        MutableDoubleList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0), this.newWith(3.0).reverseThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0), this.newWith(1.0, 3.0).reverseThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0), this.newWith(7.0, 9.0, 1.0, 3.0).reverseThis());
        MutableDoubleList sameList = this.newWith(3.0, 1.0, 9.0, 7.0);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0, 8.0), this.newWith(8.0, 7.0, 9.0, 1.0, 3.0).reverseThis());

        MutableDoubleList list1 = DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, DoubleArrayList.newListWith(1.0, 2.0, 3.0));
        Assert.assertEquals(list1.reverseThis(), DoubleArrayList.newListWith(3.0, 2.0, 1.0));
    }

    @Test
    public void sortThis()
    {
        Assert.assertEquals(new DoubleArrayList(), this.newWith().sortThis());
        MutableDoubleList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0), this.newWith(3.0).sortThis());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 3.0), this.newWith(3.0, 1.0).sortThis());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 3.0, 7.0, 9.0), this.newWith(3.0, 1.0, 9.0, 7.0).sortThis());
        MutableDoubleList sameList = this.newWith(3.0, 1.0, 9.0, 7.0);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 3.0, 7.0, 8.0, 9.0), this.newWith(8.0, 1.0, 7.0, 3.0, 9.0).sortThis());
        MutableDoubleList list = this.newWith();
        list.add(2.0);
        list.add(1.0);
        list.sortThis();
        Assert.assertEquals(1.0, list.get(0), 0.0);
    }

    @Test
    public void binarySearch()
    {
        MutableDoubleList list = this.newWith(2.0, 3.0, 5.0, 6.0, 9.0);
        Assert.assertEquals(-1, list.binarySearch(1.0));
        Assert.assertEquals(0, list.binarySearch(2.0));
        Assert.assertEquals(1, list.binarySearch(3.0));
        Assert.assertEquals(-3, list.binarySearch(4.0));
        Assert.assertEquals(2, list.binarySearch(5.0));
        Assert.assertEquals(3, list.binarySearch(6.0));
        Assert.assertEquals(-5, list.binarySearch(7.0));
        Assert.assertEquals(-5, list.binarySearch(8.0));
        Assert.assertEquals(4, list.binarySearch(9.0));
        Assert.assertEquals(-6, list.binarySearch(10.0));
    }

    @Test
    public void toReversed()
    {
        Assert.assertEquals(new DoubleArrayList(), this.newWith().toReversed());
        MutableDoubleList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0), this.newWith(7.0, 9.0, 1.0, 3.0).toReversed());
        MutableDoubleList evenList = this.newWith(3.0, 1.0, 9.0, 7.0);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0, 8.0), this.newWith(8.0, 7.0, 9.0, 1.0, 3.0).toReversed());
        MutableDoubleList oddList = this.newWith(3.0, 1.0, 9.0, 7.0, 8.0);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex()
    {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((double each, int index) -> sum[0] += each + index);

        Assert.assertEquals(9.0, sum[0], 0.0);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        MutableList<DoubleIntPair> pairs = this.newWith(3.0, 1.0, 9.0, 7.0)
                .collectWithIndex(PrimitiveTuples::pair);
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
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0, 4.0);
        MutableDoubleList list2 = this.newWith(4.0, 3.0, 2.0, 1.0);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.classUnderTest().toString());
    }

    @Test
    public void distinct()
    {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 2.0, 3.0, 3.0, 3.0, 4.0, 4.0, 4.0, 4.0).distinct();
        MutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0, 4.0);
        Assert.assertEquals(list1, list2);
    }

    @Override
    @Test
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("1.0, 2.0, 3.0", this.classUnderTest().makeString());
        Assert.assertEquals("1.0/2.0/3.0", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList()
    {
        super.toList();
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable()
    {
        ImmutableDoubleList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), immutable);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        DoubleArrayList arrayList = DoubleArrayList.newListWith(1.0, 2.0, 3.0);
        MutableDouble result = arrayList.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }

    @Test
    public void injectIntoWithIndex()
    {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0);
        MutableDouble result = list1.injectIntoWithIndex(new MutableDouble(0.0),
            (MutableDouble object, double value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableDouble(14.0), result);
    }

    @Test
    public void zipDouble()
    {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0);
        MutableList<DoubleDoublePair> zipSame = list1.zipDouble(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, 1.0),
                    PrimitiveTuples.pair(2.0, 2.0),
                    PrimitiveTuples.pair(3.0, 3.0)),
                zipSame);
        MutableList<DoubleDoublePair> zipSameLazy = list1.zipDouble(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, 1.0),
                    PrimitiveTuples.pair(2.0, 2.0),
                    PrimitiveTuples.pair(3.0, 3.0)),
                zipSameLazy);
        MutableList<DoubleDoublePair> zipLess = list1.zipDouble(list2);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, 1.0),
                    PrimitiveTuples.pair(2.0, 2.0)),
                zipLess);
        MutableList<DoubleDoublePair> zipLessLazy = list1.zipDouble(list2.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, 1.0),
                    PrimitiveTuples.pair(2.0, 2.0)),
                zipLess);
        MutableList<DoubleDoublePair> zipMore = list2.zipDouble(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, 1.0),
                    PrimitiveTuples.pair(2.0, 2.0)),
                zipMore);
        MutableList<DoubleDoublePair> zipMoreLazy = list2.zipDouble(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, 1.0),
                    PrimitiveTuples.pair(2.0, 2.0)),
                zipMoreLazy);
        MutableList<DoubleDoublePair> zipEmpty = list1.zipDouble(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip()
    {
        MutableDoubleList list1 = this.newWith(1.0, 2.0, 3.0);
        MutableDoubleList list2 = this.newWith(1.0, 2.0);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<DoubleObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, "1"),
                    PrimitiveTuples.pair(2.0, "2"),
                    PrimitiveTuples.pair(3.0, "3")),
                zipSame);
        MutableList<DoubleObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, "1"),
                    PrimitiveTuples.pair(2.0, "2"),
                    PrimitiveTuples.pair(3.0, "3")),
                zipSameLazy);
        MutableList<DoubleObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, "1"),
                    PrimitiveTuples.pair(2.0, "2")),
                zipLess);
        MutableList<DoubleObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, "1"),
                    PrimitiveTuples.pair(2.0, "2")),
                zipLessLazy);
        MutableList<DoubleObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, "1"),
                    PrimitiveTuples.pair(2.0, "2")),
                zipMore);
        MutableList<DoubleObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0, "1"),
                    PrimitiveTuples.pair(2.0, "2")),
                zipMoreLazy);
        MutableList<DoubleObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }
}
