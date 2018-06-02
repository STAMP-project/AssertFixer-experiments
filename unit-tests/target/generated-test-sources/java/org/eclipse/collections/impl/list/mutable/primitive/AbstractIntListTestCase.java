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

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.IntObjectPair;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.stack.mutable.primitive.IntArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableIntList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractIntListTestCase extends AbstractMutableIntCollectionTestCase
{
    @Override
    protected abstract MutableIntList classUnderTest();

    @Override
    protected abstract MutableIntList newWith(int... elements);

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
        MutableIntList list = this.classUnderTest();
        Assert.assertEquals(1L, list.get(0));
        Assert.assertEquals(2L, list.get(1));
        Assert.assertEquals(3L, list.get(2));
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
        MutableIntList singleItemList = this.newWith(1);
        Assert.assertEquals(1L, singleItemList.getFirst());
        Assert.assertEquals(1L, this.classUnderTest().getFirst());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst_emptyList_throws()
    {
        this.newWith().getFirst();
    }

    @Test
    public void getLast()
    {
        MutableIntList singleItemList = this.newWith(1);
        Assert.assertEquals(1L, singleItemList.getLast());
        Assert.assertEquals(3L, this.classUnderTest().getLast());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast_emptyList_throws()
    {
        this.newWith().getLast();
    }

    @Test
    public void dotProduct()
    {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2, 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf()
    {
        MutableIntList arrayList = this.newWith(1, 2, 1);
        Assert.assertEquals(0L, arrayList.indexOf(1));
        Assert.assertEquals(1L, arrayList.indexOf(2));
        Assert.assertEquals(-1L, arrayList.indexOf(9));
    }

    @Test
    public void lastIndexOf()
    {
        MutableIntList arrayList = this.newWith(1, 2, 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9));
    }

    @Test
    public void addAtIndex()
    {
        MutableIntList emptyList = this.newWith();
        emptyList.addAtIndex(0, 1);
        Assert.assertEquals(this.newMutableCollectionWith(1), emptyList);
        MutableIntList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, 4);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4), arrayList);
        arrayList.addAtIndex(2, 5);
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 5, 3, 4), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        this.newWith().addAtIndex(1, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.classUnderTest().addAtIndex(-1, 4);
    }

    @Override
    @Test
    public void addAllArray()
    {
        super.addAllArray();
        MutableIntList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(4, 5, 6));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6), list);
        Assert.assertTrue(list.addAllAtIndex(4, 5, 6));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6, 5, 6), list);
    }

    @Override
    @Test
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableIntList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(IntArrayList.newListWith(4, 5, 6)));
        Assert.assertTrue(list.addAll(IntArrayStack.newStackWith(8, 7)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6, 7, 8), list);
        Assert.assertTrue(list.addAllAtIndex(4, IntArrayList.newListWith(5, 6)));
        Assert.assertEquals(this.newMutableCollectionWith(1, 2, 3, 4, 5, 6, 5, 6, 7, 8), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, 5, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, 5, 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, IntArrayList.newListWith(1, 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, IntArrayList.newListWith(1, 2));
    }

    @Test
    public void removeAtIndex()
    {
        MutableIntList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith(1, 3), list);
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
        MutableIntList list = this.classUnderTest();
        list.set(1, 4);
        Assert.assertEquals(this.newMutableCollectionWith(1, 4, 3), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList()
    {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void intIterator()
    {
        IntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Override
    @Test
    public void toArray()
    {
        super.toArray();
        Assert.assertArrayEquals(new int[]{1, 2, 4, 3}, this.newWith(1, 2, 4, 3).toArray());
    }

    @Test
    public void reverseThis()
    {
        Assert.assertEquals(new IntArrayList(), this.newWith().reverseThis());
        MutableIntList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(IntArrayList.newListWith(3), this.newWith(3).reverseThis());
        Assert.assertEquals(IntArrayList.newListWith(3, 1), this.newWith(1, 3).reverseThis());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7), this.newWith(7, 9, 1, 3).reverseThis());
        MutableIntList sameList = this.newWith(3, 1, 9, 7);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7, 8), this.newWith(8, 7, 9, 1, 3).reverseThis());

        MutableIntList list1 = IntArrayList.newListWith(1, 2, 3, 4);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, IntArrayList.newListWith(1, 2, 3));
        Assert.assertEquals(list1.reverseThis(), IntArrayList.newListWith(3, 2, 1));
    }

    @Test
    public void sortThis()
    {
        Assert.assertEquals(new IntArrayList(), this.newWith().sortThis());
        MutableIntList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(IntArrayList.newListWith(3), this.newWith(3).sortThis());
        Assert.assertEquals(IntArrayList.newListWith(1, 3), this.newWith(3, 1).sortThis());
        Assert.assertEquals(IntArrayList.newListWith(1, 3, 7, 9), this.newWith(3, 1, 9, 7).sortThis());
        MutableIntList sameList = this.newWith(3, 1, 9, 7);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(IntArrayList.newListWith(1, 3, 7, 8, 9), this.newWith(8, 1, 7, 3, 9).sortThis());
        MutableIntList list = this.newWith();
        list.add(2);
        list.add(1);
        list.sortThis();
        Assert.assertEquals(1, list.get(0));
    }

    @Test
    public void binarySearch()
    {
        MutableIntList list = this.newWith(2, 3, 5, 6, 9);
        Assert.assertEquals(-1, list.binarySearch(1));
        Assert.assertEquals(0, list.binarySearch(2));
        Assert.assertEquals(1, list.binarySearch(3));
        Assert.assertEquals(-3, list.binarySearch(4));
        Assert.assertEquals(2, list.binarySearch(5));
        Assert.assertEquals(3, list.binarySearch(6));
        Assert.assertEquals(-5, list.binarySearch(7));
        Assert.assertEquals(-5, list.binarySearch(8));
        Assert.assertEquals(4, list.binarySearch(9));
        Assert.assertEquals(-6, list.binarySearch(10));
    }

    @Test
    public void toReversed()
    {
        Assert.assertEquals(new IntArrayList(), this.newWith().toReversed());
        MutableIntList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7), this.newWith(7, 9, 1, 3).toReversed());
        MutableIntList evenList = this.newWith(3, 1, 9, 7);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(IntArrayList.newListWith(3, 1, 9, 7, 8), this.newWith(8, 7, 9, 1, 3).toReversed());
        MutableIntList oddList = this.newWith(3, 1, 9, 7, 8);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((int each, int index) -> sum[0] += each + index);

        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        MutableList<IntIntPair> pairs = this.newWith(3, 1, 9, 7)
                .collectWithIndex(PrimitiveTuples::pair);
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
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        MutableIntList list1 = this.newWith(1, 2, 3, 4);
        MutableIntList list2 = this.newWith(4, 3, 2, 1);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[1, 2, 3]", this.classUnderTest().toString());
    }

    @Test
    public void distinct()
    {
        MutableIntList list1 = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4).distinct();
        MutableIntList list2 = this.newWith(1, 2, 3, 4);
        Assert.assertEquals(list1, list2);
    }

    @Override
    @Test
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("1, 2, 3", this.classUnderTest().makeString());
        Assert.assertEquals("1/2/3", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("1, 2, 3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("1/2/3", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList()
    {
        super.toList();
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable()
    {
        ImmutableIntList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), immutable);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        IntArrayList arrayList = IntArrayList.newListWith(1, 2, 3);
        MutableInteger result = arrayList.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }

    @Test
    public void injectIntoWithIndex()
    {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2, 3);
        MutableInteger result = list1.injectIntoWithIndex(new MutableInteger(0),
            (MutableInteger object, int value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableInteger(14), result);
    }

    @Test
    public void zipInt()
    {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2);
        MutableList<IntIntPair> zipSame = list1.zipInt(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, 1),
                    PrimitiveTuples.pair(2, 2),
                    PrimitiveTuples.pair(3, 3)),
                zipSame);
        MutableList<IntIntPair> zipSameLazy = list1.zipInt(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, 1),
                    PrimitiveTuples.pair(2, 2),
                    PrimitiveTuples.pair(3, 3)),
                zipSameLazy);
        MutableList<IntIntPair> zipLess = list1.zipInt(list2);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, 1),
                    PrimitiveTuples.pair(2, 2)),
                zipLess);
        MutableList<IntIntPair> zipLessLazy = list1.zipInt(list2.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, 1),
                    PrimitiveTuples.pair(2, 2)),
                zipLess);
        MutableList<IntIntPair> zipMore = list2.zipInt(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, 1),
                    PrimitiveTuples.pair(2, 2)),
                zipMore);
        MutableList<IntIntPair> zipMoreLazy = list2.zipInt(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, 1),
                    PrimitiveTuples.pair(2, 2)),
                zipMoreLazy);
        MutableList<IntIntPair> zipEmpty = list1.zipInt(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip()
    {
        MutableIntList list1 = this.newWith(1, 2, 3);
        MutableIntList list2 = this.newWith(1, 2);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<IntObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, "1"),
                    PrimitiveTuples.pair(2, "2"),
                    PrimitiveTuples.pair(3, "3")),
                zipSame);
        MutableList<IntObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, "1"),
                    PrimitiveTuples.pair(2, "2"),
                    PrimitiveTuples.pair(3, "3")),
                zipSameLazy);
        MutableList<IntObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, "1"),
                    PrimitiveTuples.pair(2, "2")),
                zipLess);
        MutableList<IntObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, "1"),
                    PrimitiveTuples.pair(2, "2")),
                zipLessLazy);
        MutableList<IntObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, "1"),
                    PrimitiveTuples.pair(2, "2")),
                zipMore);
        MutableList<IntObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1, "1"),
                    PrimitiveTuples.pair(2, "2")),
                zipMoreLazy);
        MutableList<IntObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }
}
