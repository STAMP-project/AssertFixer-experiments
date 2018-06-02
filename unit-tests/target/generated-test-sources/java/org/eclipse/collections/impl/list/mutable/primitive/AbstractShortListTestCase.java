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

import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableShortList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.ShortIntPair;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableShortCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.stack.mutable.primitive.ShortArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableShortList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractShortListTestCase extends AbstractMutableShortCollectionTestCase
{
    @Override
    protected abstract MutableShortList classUnderTest();

    @Override
    protected abstract MutableShortList newWith(short... elements);

    @Override
    protected MutableShortList newMutableCollectionWith(short... elements)
    {
        return ShortArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Short> newObjectCollectionWith(Short... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test
    public void get()
    {
        MutableShortList list = this.classUnderTest();
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
        MutableShortList singleItemList = this.newWith((short) 1);
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
        MutableShortList singleItemList = this.newWith((short) 1);
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
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf()
    {
        MutableShortList arrayList = this.newWith((short) 1, (short) 2, (short) 1);
        Assert.assertEquals(0L, arrayList.indexOf((short) 1));
        Assert.assertEquals(1L, arrayList.indexOf((short) 2));
        Assert.assertEquals(-1L, arrayList.indexOf((short) 9));
    }

    @Test
    public void lastIndexOf()
    {
        MutableShortList arrayList = this.newWith((short) 1, (short) 2, (short) 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf((short) 1));
        Assert.assertEquals(1L, arrayList.lastIndexOf((short) 2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf((short) 9));
    }

    @Test
    public void addAtIndex()
    {
        MutableShortList emptyList = this.newWith();
        emptyList.addAtIndex(0, (short) 1);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1), emptyList);
        MutableShortList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, (short) 4);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4), arrayList);
        arrayList.addAtIndex(2, (short) 5);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 5, (short) 3, (short) 4), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        this.newWith().addAtIndex(1, (short) 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.classUnderTest().addAtIndex(-1, (short) 4);
    }

    @Override
    @Test
    public void addAllArray()
    {
        super.addAllArray();
        MutableShortList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll((short) 4, (short) 5, (short) 6));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6), list);
        Assert.assertTrue(list.addAllAtIndex(4, (short) 5, (short) 6));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 5, (short) 6), list);
    }

    @Override
    @Test
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableShortList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(ShortArrayList.newListWith((short) 4, (short) 5, (short) 6)));
        Assert.assertTrue(list.addAll(ShortArrayStack.newStackWith((short) 8, (short) 7)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 7, (short) 8), list);
        Assert.assertTrue(list.addAllAtIndex(4, ShortArrayList.newListWith((short) 5, (short) 6)));
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5, (short) 6, (short) 5, (short) 6, (short) 7, (short) 8), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, (short) 5, (short) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, (short) 5, (short) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, ShortArrayList.newListWith((short) 1, (short) 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, ShortArrayList.newListWith((short) 1, (short) 2));
    }

    @Test
    public void removeAtIndex()
    {
        MutableShortList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 3), list);
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
        MutableShortList list = this.classUnderTest();
        list.set(1, (short) 4);
        Assert.assertEquals(this.newMutableCollectionWith((short) 1, (short) 4, (short) 3), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList()
    {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void shortIterator()
    {
        ShortIterator iterator = this.classUnderTest().shortIterator();
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
        Assert.assertArrayEquals(new short[]{(short) 1, (short) 2, (short) 4, (short) 3}, this.newWith((short) 1, (short) 2, (short) 4, (short) 3).toArray());
    }

    @Test
    public void reverseThis()
    {
        Assert.assertEquals(new ShortArrayList(), this.newWith().reverseThis());
        MutableShortList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3), this.newWith((short) 3).reverseThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1), this.newWith((short) 1, (short) 3).reverseThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7), this.newWith((short) 7, (short) 9, (short) 1, (short) 3).reverseThis());
        MutableShortList sameList = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7, (short) 8), this.newWith((short) 8, (short) 7, (short) 9, (short) 1, (short) 3).reverseThis());

        MutableShortList list1 = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, ShortArrayList.newListWith((short) 1, (short) 2, (short) 3));
        Assert.assertEquals(list1.reverseThis(), ShortArrayList.newListWith((short) 3, (short) 2, (short) 1));
    }

    @Test
    public void sortThis()
    {
        Assert.assertEquals(new ShortArrayList(), this.newWith().sortThis());
        MutableShortList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3), this.newWith((short) 3).sortThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 3), this.newWith((short) 3, (short) 1).sortThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 3, (short) 7, (short) 9), this.newWith((short) 3, (short) 1, (short) 9, (short) 7).sortThis());
        MutableShortList sameList = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 3, (short) 7, (short) 8, (short) 9), this.newWith((short) 8, (short) 1, (short) 7, (short) 3, (short) 9).sortThis());
        MutableShortList list = this.newWith();
        list.add((short) 2);
        list.add((short) 1);
        list.sortThis();
        Assert.assertEquals((short) 1, list.get(0));
    }

    @Test
    public void binarySearch()
    {
        MutableShortList list = this.newWith((short) 2, (short) 3, (short) 5, (short) 6, (short) 9);
        Assert.assertEquals(-1, list.binarySearch((short) 1));
        Assert.assertEquals(0, list.binarySearch((short) 2));
        Assert.assertEquals(1, list.binarySearch((short) 3));
        Assert.assertEquals(-3, list.binarySearch((short) 4));
        Assert.assertEquals(2, list.binarySearch((short) 5));
        Assert.assertEquals(3, list.binarySearch((short) 6));
        Assert.assertEquals(-5, list.binarySearch((short) 7));
        Assert.assertEquals(-5, list.binarySearch((short) 8));
        Assert.assertEquals(4, list.binarySearch((short) 9));
        Assert.assertEquals(-6, list.binarySearch((short) 10));
    }

    @Test
    public void toReversed()
    {
        Assert.assertEquals(new ShortArrayList(), this.newWith().toReversed());
        MutableShortList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7), this.newWith((short) 7, (short) 9, (short) 1, (short) 3).toReversed());
        MutableShortList evenList = this.newWith((short) 3, (short) 1, (short) 9, (short) 7);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 1, (short) 9, (short) 7, (short) 8), this.newWith((short) 8, (short) 7, (short) 9, (short) 1, (short) 3).toReversed());
        MutableShortList oddList = this.newWith((short) 3, (short) 1, (short) 9, (short) 7, (short) 8);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((short each, int index) -> sum[0] += each + index);

        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        MutableList<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                ShortLists.mutable.with((short) 3, (short) 1, (short) 9, (short) 7),
                pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));

        MutableSet<ShortIntPair> set = this.newWith((short) 3, (short) 1, (short) 9, (short) 7)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(ShortIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                ShortSets.mutable.with((short) 3, (short) 1, (short) 9, (short) 7),
                pairs.collectShort(ShortIntPair::getOne, ShortSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<ShortIntPair> pairs = this.newWith((short) 3, (short) 1, (short) 9, (short) 7)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(ShortIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                ShortLists.mutable.with((short) 3, (short) 1, (short) 9, (short) 7),
                pairs.collectShort(ShortIntPair::getOne, ShortLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4);
        MutableShortList list2 = this.newWith((short) 4, (short) 3, (short) 2, (short) 1);
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
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 3, (short) 4, (short) 4, (short) 4, (short) 4).distinct();
        MutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3, (short) 4);
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
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable()
    {
        ImmutableShortList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), immutable);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ShortArrayList arrayList = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        MutableShort result = arrayList.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }

    @Test
    public void injectIntoWithIndex()
    {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShort result = list1.injectIntoWithIndex(new MutableShort((short) 0),
            (MutableShort object, short value, int index) -> object.add((short) (value * list2.get(index))));
        Assert.assertEquals(new MutableShort((short) 14), result);
    }

    @Test
    public void zipShort()
    {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2);
        MutableList<ShortShortPair> zipSame = list1.zipShort(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, (short) 1),
                    PrimitiveTuples.pair((short) 2, (short) 2),
                    PrimitiveTuples.pair((short) 3, (short) 3)),
                zipSame);
        MutableList<ShortShortPair> zipSameLazy = list1.zipShort(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, (short) 1),
                    PrimitiveTuples.pair((short) 2, (short) 2),
                    PrimitiveTuples.pair((short) 3, (short) 3)),
                zipSameLazy);
        MutableList<ShortShortPair> zipLess = list1.zipShort(list2);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, (short) 1),
                    PrimitiveTuples.pair((short) 2, (short) 2)),
                zipLess);
        MutableList<ShortShortPair> zipLessLazy = list1.zipShort(list2.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, (short) 1),
                    PrimitiveTuples.pair((short) 2, (short) 2)),
                zipLess);
        MutableList<ShortShortPair> zipMore = list2.zipShort(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, (short) 1),
                    PrimitiveTuples.pair((short) 2, (short) 2)),
                zipMore);
        MutableList<ShortShortPair> zipMoreLazy = list2.zipShort(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, (short) 1),
                    PrimitiveTuples.pair((short) 2, (short) 2)),
                zipMoreLazy);
        MutableList<ShortShortPair> zipEmpty = list1.zipShort(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip()
    {
        MutableShortList list1 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShortList list2 = this.newWith((short) 1, (short) 2);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<ShortObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, "1"),
                    PrimitiveTuples.pair((short) 2, "2"),
                    PrimitiveTuples.pair((short) 3, "3")),
                zipSame);
        MutableList<ShortObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, "1"),
                    PrimitiveTuples.pair((short) 2, "2"),
                    PrimitiveTuples.pair((short) 3, "3")),
                zipSameLazy);
        MutableList<ShortObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, "1"),
                    PrimitiveTuples.pair((short) 2, "2")),
                zipLess);
        MutableList<ShortObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, "1"),
                    PrimitiveTuples.pair((short) 2, "2")),
                zipLessLazy);
        MutableList<ShortObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, "1"),
                    PrimitiveTuples.pair((short) 2, "2")),
                zipMore);
        MutableList<ShortObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((short) 1, "1"),
                    PrimitiveTuples.pair((short) 2, "2")),
                zipMoreLazy);
        MutableList<ShortObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }
}
