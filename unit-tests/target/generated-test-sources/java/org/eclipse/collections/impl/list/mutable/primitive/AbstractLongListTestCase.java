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

import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableLongCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.stack.mutable.primitive.LongArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableLongList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractLongListTestCase extends AbstractMutableLongCollectionTestCase
{
    @Override
    protected abstract MutableLongList classUnderTest();

    @Override
    protected abstract MutableLongList newWith(long... elements);

    @Override
    protected MutableLongList newMutableCollectionWith(long... elements)
    {
        return LongArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Long> newObjectCollectionWith(Long... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test
    public void get()
    {
        MutableLongList list = this.classUnderTest();
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
        MutableLongList singleItemList = this.newWith(1L);
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
        MutableLongList singleItemList = this.newWith(1L);
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
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L, 3L);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf()
    {
        MutableLongList arrayList = this.newWith(1L, 2L, 1L);
        Assert.assertEquals(0L, arrayList.indexOf(1L));
        Assert.assertEquals(1L, arrayList.indexOf(2L));
        Assert.assertEquals(-1L, arrayList.indexOf(9L));
    }

    @Test
    public void lastIndexOf()
    {
        MutableLongList arrayList = this.newWith(1L, 2L, 1L);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1L));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2L));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9L));
    }

    @Test
    public void addAtIndex()
    {
        MutableLongList emptyList = this.newWith();
        emptyList.addAtIndex(0, 1L);
        Assert.assertEquals(this.newMutableCollectionWith(1L), emptyList);
        MutableLongList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, 4L);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L), arrayList);
        arrayList.addAtIndex(2, 5L);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 5L, 3L, 4L), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        this.newWith().addAtIndex(1, 0L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.classUnderTest().addAtIndex(-1, 4L);
    }

    @Override
    @Test
    public void addAllArray()
    {
        super.addAllArray();
        MutableLongList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(4L, 5L, 6L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L), list);
        Assert.assertTrue(list.addAllAtIndex(4, 5L, 6L));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L, 5L, 6L), list);
    }

    @Override
    @Test
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableLongList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(LongArrayList.newListWith(4L, 5L, 6L)));
        Assert.assertTrue(list.addAll(LongArrayStack.newStackWith(8L, 7L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L), list);
        Assert.assertTrue(list.addAllAtIndex(4, LongArrayList.newListWith(5L, 6L)));
        Assert.assertEquals(this.newMutableCollectionWith(1L, 2L, 3L, 4L, 5L, 6L, 5L, 6L, 7L, 8L), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, 5L, 6L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, 5L, 6L);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, LongArrayList.newListWith(1L, 2L));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, LongArrayList.newListWith(1L, 2L));
    }

    @Test
    public void removeAtIndex()
    {
        MutableLongList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 3L), list);
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
        MutableLongList list = this.classUnderTest();
        list.set(1, 4L);
        Assert.assertEquals(this.newMutableCollectionWith(1L, 4L, 3L), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList()
    {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void longIterator()
    {
        LongIterator iterator = this.classUnderTest().longIterator();
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
        Assert.assertArrayEquals(new long[]{1L, 2L, 4L, 3L}, this.newWith(1L, 2L, 4L, 3L).toArray());
    }

    @Test
    public void reverseThis()
    {
        Assert.assertEquals(new LongArrayList(), this.newWith().reverseThis());
        MutableLongList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(LongArrayList.newListWith(3L), this.newWith(3L).reverseThis());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L), this.newWith(1L, 3L).reverseThis());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L), this.newWith(7L, 9L, 1L, 3L).reverseThis());
        MutableLongList sameList = this.newWith(3L, 1L, 9L, 7L);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L, 8L), this.newWith(8L, 7L, 9L, 1L, 3L).reverseThis());

        MutableLongList list1 = LongArrayList.newListWith(1L, 2L, 3L, 4L);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, LongArrayList.newListWith(1L, 2L, 3L));
        Assert.assertEquals(list1.reverseThis(), LongArrayList.newListWith(3L, 2L, 1L));
    }

    @Test
    public void sortThis()
    {
        Assert.assertEquals(new LongArrayList(), this.newWith().sortThis());
        MutableLongList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(LongArrayList.newListWith(3L), this.newWith(3L).sortThis());
        Assert.assertEquals(LongArrayList.newListWith(1L, 3L), this.newWith(3L, 1L).sortThis());
        Assert.assertEquals(LongArrayList.newListWith(1L, 3L, 7L, 9L), this.newWith(3L, 1L, 9L, 7L).sortThis());
        MutableLongList sameList = this.newWith(3L, 1L, 9L, 7L);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(LongArrayList.newListWith(1L, 3L, 7L, 8L, 9L), this.newWith(8L, 1L, 7L, 3L, 9L).sortThis());
        MutableLongList list = this.newWith();
        list.add(2L);
        list.add(1L);
        list.sortThis();
        Assert.assertEquals(1L, list.get(0));
    }

    @Test
    public void binarySearch()
    {
        MutableLongList list = this.newWith(2L, 3L, 5L, 6L, 9L);
        Assert.assertEquals(-1, list.binarySearch(1L));
        Assert.assertEquals(0, list.binarySearch(2L));
        Assert.assertEquals(1, list.binarySearch(3L));
        Assert.assertEquals(-3, list.binarySearch(4L));
        Assert.assertEquals(2, list.binarySearch(5L));
        Assert.assertEquals(3, list.binarySearch(6L));
        Assert.assertEquals(-5, list.binarySearch(7L));
        Assert.assertEquals(-5, list.binarySearch(8L));
        Assert.assertEquals(4, list.binarySearch(9L));
        Assert.assertEquals(-6, list.binarySearch(10L));
    }

    @Test
    public void toReversed()
    {
        Assert.assertEquals(new LongArrayList(), this.newWith().toReversed());
        MutableLongList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L), this.newWith(7L, 9L, 1L, 3L).toReversed());
        MutableLongList evenList = this.newWith(3L, 1L, 9L, 7L);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(LongArrayList.newListWith(3L, 1L, 9L, 7L, 8L), this.newWith(8L, 7L, 9L, 1L, 3L).toReversed());
        MutableLongList oddList = this.newWith(3L, 1L, 9L, 7L, 8L);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((long each, int index) -> sum[0] += each + index);

        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        MutableList<LongIntPair> pairs = this.newWith(3L, 1L, 9L, 7L)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(LongIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                LongLists.mutable.with(3L, 1L, 9L, 7L),
                pairs.collectLong(LongIntPair::getOne, LongLists.mutable.empty()));

        MutableSet<LongIntPair> set = this.newWith(3L, 1L, 9L, 7L)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(LongIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                LongSets.mutable.with(3L, 1L, 9L, 7L),
                pairs.collectLong(LongIntPair::getOne, LongSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<LongIntPair> pairs = this.newWith(3L, 1L, 9L, 7L)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(LongIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                LongLists.mutable.with(3L, 1L, 9L, 7L),
                pairs.collectLong(LongIntPair::getOne, LongLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        MutableLongList list1 = this.newWith(1L, 2L, 3L, 4L);
        MutableLongList list2 = this.newWith(4L, 3L, 2L, 1L);
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
        MutableLongList list1 = this.newWith(1L, 2L, 2L, 3L, 3L, 3L, 4L, 4L, 4L, 4L).distinct();
        MutableLongList list2 = this.newWith(1L, 2L, 3L, 4L);
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
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable()
    {
        ImmutableLongList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), immutable);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        LongArrayList arrayList = LongArrayList.newListWith(1L, 2L, 3L);
        MutableLong result = arrayList.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(6L), result);
    }

    @Test
    public void injectIntoWithIndex()
    {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L, 3L);
        MutableLong result = list1.injectIntoWithIndex(new MutableLong(0L),
            (MutableLong object, long value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableLong(14L), result);
    }

    @Test
    public void zipLong()
    {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L);
        MutableList<LongLongPair> zipSame = list1.zipLong(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, 1L),
                    PrimitiveTuples.pair(2L, 2L),
                    PrimitiveTuples.pair(3L, 3L)),
                zipSame);
        MutableList<LongLongPair> zipSameLazy = list1.zipLong(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, 1L),
                    PrimitiveTuples.pair(2L, 2L),
                    PrimitiveTuples.pair(3L, 3L)),
                zipSameLazy);
        MutableList<LongLongPair> zipLess = list1.zipLong(list2);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, 1L),
                    PrimitiveTuples.pair(2L, 2L)),
                zipLess);
        MutableList<LongLongPair> zipLessLazy = list1.zipLong(list2.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, 1L),
                    PrimitiveTuples.pair(2L, 2L)),
                zipLess);
        MutableList<LongLongPair> zipMore = list2.zipLong(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, 1L),
                    PrimitiveTuples.pair(2L, 2L)),
                zipMore);
        MutableList<LongLongPair> zipMoreLazy = list2.zipLong(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, 1L),
                    PrimitiveTuples.pair(2L, 2L)),
                zipMoreLazy);
        MutableList<LongLongPair> zipEmpty = list1.zipLong(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip()
    {
        MutableLongList list1 = this.newWith(1L, 2L, 3L);
        MutableLongList list2 = this.newWith(1L, 2L);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<LongObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, "1"),
                    PrimitiveTuples.pair(2L, "2"),
                    PrimitiveTuples.pair(3L, "3")),
                zipSame);
        MutableList<LongObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, "1"),
                    PrimitiveTuples.pair(2L, "2"),
                    PrimitiveTuples.pair(3L, "3")),
                zipSameLazy);
        MutableList<LongObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, "1"),
                    PrimitiveTuples.pair(2L, "2")),
                zipLess);
        MutableList<LongObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, "1"),
                    PrimitiveTuples.pair(2L, "2")),
                zipLessLazy);
        MutableList<LongObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, "1"),
                    PrimitiveTuples.pair(2L, "2")),
                zipMore);
        MutableList<LongObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1L, "1"),
                    PrimitiveTuples.pair(2L, "2")),
                zipMoreLazy);
        MutableList<LongObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }
}
