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

import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.FloatIntPair;
import org.eclipse.collections.api.tuple.primitive.FloatObjectPair;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.stack.mutable.primitive.FloatArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableFloatList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractFloatListTestCase extends AbstractMutableFloatCollectionTestCase
{
    @Override
    protected abstract MutableFloatList classUnderTest();

    @Override
    protected abstract MutableFloatList newWith(float... elements);

    @Override
    protected MutableFloatList newMutableCollectionWith(float... elements)
    {
        return FloatArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Float> newObjectCollectionWith(Float... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test
    public void get()
    {
        MutableFloatList list = this.classUnderTest();
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
        MutableFloatList singleItemList = this.newWith(1.0f);
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
        MutableFloatList singleItemList = this.newWith(1.0f);
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
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf()
    {
        MutableFloatList arrayList = this.newWith(1.0f, 2.0f, 1.0f);
        Assert.assertEquals(0L, arrayList.indexOf(1.0f));
        Assert.assertEquals(1L, arrayList.indexOf(2.0f));
        Assert.assertEquals(-1L, arrayList.indexOf(9.0f));
    }

    @Test
    public void lastIndexOf()
    {
        MutableFloatList arrayList = this.newWith(1.0f, 2.0f, 1.0f);
        Assert.assertEquals(2L, arrayList.lastIndexOf(1.0f));
        Assert.assertEquals(1L, arrayList.lastIndexOf(2.0f));
        Assert.assertEquals(-1L, arrayList.lastIndexOf(9.0f));
    }

    @Test
    public void addAtIndex()
    {
        MutableFloatList emptyList = this.newWith();
        emptyList.addAtIndex(0, 1.0f);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f), emptyList);
        MutableFloatList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, 4.0f);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f), arrayList);
        arrayList.addAtIndex(2, 5.0f);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 5.0f, 3.0f, 4.0f), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        this.newWith().addAtIndex(1, 0.0f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.classUnderTest().addAtIndex(-1, 4.0f);
    }

    @Override
    @Test
    public void addAllArray()
    {
        super.addAllArray();
        MutableFloatList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(4.0f, 5.0f, 6.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f), list);
        Assert.assertTrue(list.addAllAtIndex(4, 5.0f, 6.0f));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 5.0f, 6.0f), list);
    }

    @Override
    @Test
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableFloatList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(FloatArrayList.newListWith(4.0f, 5.0f, 6.0f)));
        Assert.assertTrue(list.addAll(FloatArrayStack.newStackWith(8.0f, 7.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 7.0f, 8.0f), list);
        Assert.assertTrue(list.addAllAtIndex(4, FloatArrayList.newListWith(5.0f, 6.0f)));
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f, 5.0f, 6.0f, 7.0f, 8.0f), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, 5.0f, 6.0f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, 5.0f, 6.0f);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, FloatArrayList.newListWith(1.0f, 2.0f));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, FloatArrayList.newListWith(1.0f, 2.0f));
    }

    @Test
    public void removeAtIndex()
    {
        MutableFloatList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 3.0f), list);
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
        MutableFloatList list = this.classUnderTest();
        list.set(1, 4.0f);
        Assert.assertEquals(this.newMutableCollectionWith(1.0f, 4.0f, 3.0f), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList()
    {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void floatIterator()
    {
        FloatIterator iterator = this.classUnderTest().floatIterator();
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
        Assert.assertArrayEquals(new float[]{1.0f, 2.0f, 4.0f, 3.0f}, this.newWith(1.0f, 2.0f, 4.0f, 3.0f).toArray(), 0.0f);
    }

    @Test
    public void reverseThis()
    {
        Assert.assertEquals(new FloatArrayList(), this.newWith().reverseThis());
        MutableFloatList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f), this.newWith(3.0f).reverseThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f), this.newWith(1.0f, 3.0f).reverseThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f), this.newWith(7.0f, 9.0f, 1.0f, 3.0f).reverseThis());
        MutableFloatList sameList = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f, 8.0f), this.newWith(8.0f, 7.0f, 9.0f, 1.0f, 3.0f).reverseThis());

        MutableFloatList list1 = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, FloatArrayList.newListWith(1.0f, 2.0f, 3.0f));
        Assert.assertEquals(list1.reverseThis(), FloatArrayList.newListWith(3.0f, 2.0f, 1.0f));
    }

    @Test
    public void sortThis()
    {
        Assert.assertEquals(new FloatArrayList(), this.newWith().sortThis());
        MutableFloatList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f), this.newWith(3.0f).sortThis());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 3.0f), this.newWith(3.0f, 1.0f).sortThis());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 3.0f, 7.0f, 9.0f), this.newWith(3.0f, 1.0f, 9.0f, 7.0f).sortThis());
        MutableFloatList sameList = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 3.0f, 7.0f, 8.0f, 9.0f), this.newWith(8.0f, 1.0f, 7.0f, 3.0f, 9.0f).sortThis());
        MutableFloatList list = this.newWith();
        list.add(2.0f);
        list.add(1.0f);
        list.sortThis();
        Assert.assertEquals(1.0f, list.get(0), 0.0);
    }

    @Test
    public void binarySearch()
    {
        MutableFloatList list = this.newWith(2.0f, 3.0f, 5.0f, 6.0f, 9.0f);
        Assert.assertEquals(-1, list.binarySearch(1.0f));
        Assert.assertEquals(0, list.binarySearch(2.0f));
        Assert.assertEquals(1, list.binarySearch(3.0f));
        Assert.assertEquals(-3, list.binarySearch(4.0f));
        Assert.assertEquals(2, list.binarySearch(5.0f));
        Assert.assertEquals(3, list.binarySearch(6.0f));
        Assert.assertEquals(-5, list.binarySearch(7.0f));
        Assert.assertEquals(-5, list.binarySearch(8.0f));
        Assert.assertEquals(4, list.binarySearch(9.0f));
        Assert.assertEquals(-6, list.binarySearch(10.0f));
    }

    @Test
    public void toReversed()
    {
        Assert.assertEquals(new FloatArrayList(), this.newWith().toReversed());
        MutableFloatList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f), this.newWith(7.0f, 9.0f, 1.0f, 3.0f).toReversed());
        MutableFloatList evenList = this.newWith(3.0f, 1.0f, 9.0f, 7.0f);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(FloatArrayList.newListWith(3.0f, 1.0f, 9.0f, 7.0f, 8.0f), this.newWith(8.0f, 7.0f, 9.0f, 1.0f, 3.0f).toReversed());
        MutableFloatList oddList = this.newWith(3.0f, 1.0f, 9.0f, 7.0f, 8.0f);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex()
    {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((float each, int index) -> sum[0] += each + index);

        Assert.assertEquals(9.0, sum[0], 0.0);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        MutableList<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                FloatLists.mutable.with(3.0f, 1.0f, 9.0f, 7.0f),
                pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));

        MutableSet<FloatIntPair> set = this.newWith(3.0f, 1.0f, 9.0f, 7.0f)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(FloatIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                FloatSets.mutable.with(3.0f, 1.0f, 9.0f, 7.0f),
                pairs.collectFloat(FloatIntPair::getOne, FloatSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<FloatIntPair> pairs = this.newWith(3.0f, 1.0f, 9.0f, 7.0f)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(FloatIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                FloatLists.mutable.with(3.0f, 1.0f, 9.0f, 7.0f),
                pairs.collectFloat(FloatIntPair::getOne, FloatLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f);
        MutableFloatList list2 = this.newWith(4.0f, 3.0f, 2.0f, 1.0f);
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
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 3.0f, 4.0f, 4.0f, 4.0f, 4.0f).distinct();
        MutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f, 4.0f);
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
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable()
    {
        ImmutableFloatList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f), immutable);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        FloatArrayList arrayList = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = arrayList.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }

    @Test
    public void injectIntoWithIndex()
    {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = list1.injectIntoWithIndex(new MutableFloat(0.0f),
            (MutableFloat object, float value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableFloat(14.0f), result);
    }

    @Test
    public void zipFloat()
    {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f);
        MutableList<FloatFloatPair> zipSame = list1.zipFloat(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, 1.0f),
                    PrimitiveTuples.pair(2.0f, 2.0f),
                    PrimitiveTuples.pair(3.0f, 3.0f)),
                zipSame);
        MutableList<FloatFloatPair> zipSameLazy = list1.zipFloat(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, 1.0f),
                    PrimitiveTuples.pair(2.0f, 2.0f),
                    PrimitiveTuples.pair(3.0f, 3.0f)),
                zipSameLazy);
        MutableList<FloatFloatPair> zipLess = list1.zipFloat(list2);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, 1.0f),
                    PrimitiveTuples.pair(2.0f, 2.0f)),
                zipLess);
        MutableList<FloatFloatPair> zipLessLazy = list1.zipFloat(list2.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, 1.0f),
                    PrimitiveTuples.pair(2.0f, 2.0f)),
                zipLess);
        MutableList<FloatFloatPair> zipMore = list2.zipFloat(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, 1.0f),
                    PrimitiveTuples.pair(2.0f, 2.0f)),
                zipMore);
        MutableList<FloatFloatPair> zipMoreLazy = list2.zipFloat(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, 1.0f),
                    PrimitiveTuples.pair(2.0f, 2.0f)),
                zipMoreLazy);
        MutableList<FloatFloatPair> zipEmpty = list1.zipFloat(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip()
    {
        MutableFloatList list1 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloatList list2 = this.newWith(1.0f, 2.0f);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<FloatObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, "1"),
                    PrimitiveTuples.pair(2.0f, "2"),
                    PrimitiveTuples.pair(3.0f, "3")),
                zipSame);
        MutableList<FloatObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, "1"),
                    PrimitiveTuples.pair(2.0f, "2"),
                    PrimitiveTuples.pair(3.0f, "3")),
                zipSameLazy);
        MutableList<FloatObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, "1"),
                    PrimitiveTuples.pair(2.0f, "2")),
                zipLess);
        MutableList<FloatObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, "1"),
                    PrimitiveTuples.pair(2.0f, "2")),
                zipLessLazy);
        MutableList<FloatObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, "1"),
                    PrimitiveTuples.pair(2.0f, "2")),
                zipMore);
        MutableList<FloatObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair(1.0f, "1"),
                    PrimitiveTuples.pair(2.0f, "2")),
                zipMoreLazy);
        MutableList<FloatObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }
}
