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

import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.CharIntPair;
import org.eclipse.collections.api.tuple.primitive.CharObjectPair;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableCharCollectionTestCase;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.stack.mutable.primitive.CharArrayStack;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableCharList}.
 * This file was automatically generated from template file abstractPrimitiveListTestCase.stg.
 */
public abstract class AbstractCharListTestCase extends AbstractMutableCharCollectionTestCase
{
    @Override
    protected abstract MutableCharList classUnderTest();

    @Override
    protected abstract MutableCharList newWith(char... elements);

    @Override
    protected MutableCharList newMutableCollectionWith(char... elements)
    {
        return CharArrayList.newListWith(elements);
    }

    @Override
    protected MutableList<Character> newObjectCollectionWith(Character... elements)
    {
        return FastList.newListWith(elements);
    }

    @Test
    public void get()
    {
        MutableCharList list = this.classUnderTest();
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
        MutableCharList singleItemList = this.newWith((char) 1);
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
        MutableCharList singleItemList = this.newWith((char) 1);
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
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void indexOf()
    {
        MutableCharList arrayList = this.newWith((char) 1, (char) 2, (char) 1);
        Assert.assertEquals(0L, arrayList.indexOf((char) 1));
        Assert.assertEquals(1L, arrayList.indexOf((char) 2));
        Assert.assertEquals(-1L, arrayList.indexOf((char) 9));
    }

    @Test
    public void lastIndexOf()
    {
        MutableCharList arrayList = this.newWith((char) 1, (char) 2, (char) 1);
        Assert.assertEquals(2L, arrayList.lastIndexOf((char) 1));
        Assert.assertEquals(1L, arrayList.lastIndexOf((char) 2));
        Assert.assertEquals(-1L, arrayList.lastIndexOf((char) 9));
    }

    @Test
    public void addAtIndex()
    {
        MutableCharList emptyList = this.newWith();
        emptyList.addAtIndex(0, (char) 1);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1), emptyList);
        MutableCharList arrayList = this.classUnderTest();
        arrayList.addAtIndex(3, (char) 4);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4), arrayList);
        arrayList.addAtIndex(2, (char) 5);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 5, (char) 3, (char) 4), arrayList);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_greater_than_size()
    {
        this.newWith().addAtIndex(1, (char) 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAtIndex_throws_index_negative()
    {
        this.classUnderTest().addAtIndex(-1, (char) 4);
    }

    @Override
    @Test
    public void addAllArray()
    {
        super.addAllArray();
        MutableCharList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll((char) 4, (char) 5, (char) 6));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6), list);
        Assert.assertTrue(list.addAllAtIndex(4, (char) 5, (char) 6));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 5, (char) 6), list);
    }

    @Override
    @Test
    public void addAllIterable()
    {
        super.addAllIterable();
        MutableCharList list = this.classUnderTest();
        Assert.assertFalse(list.addAllAtIndex(1));
        Assert.assertTrue(list.addAll(CharArrayList.newListWith((char) 4, (char) 5, (char) 6)));
        Assert.assertTrue(list.addAll(CharArrayStack.newStackWith((char) 8, (char) 7)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 7, (char) 8), list);
        Assert.assertTrue(list.addAllAtIndex(4, CharArrayList.newListWith((char) 5, (char) 6)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5, (char) 6, (char) 5, (char) 6, (char) 7, (char) 8), list);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, (char) 5, (char) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAll_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, (char) 5, (char) 6);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_negative()
    {
        this.classUnderTest().addAllAtIndex(-1, CharArrayList.newListWith((char) 1, (char) 2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addAllIterable_throws_index_greater_than_size()
    {
        this.classUnderTest().addAllAtIndex(5, CharArrayList.newListWith((char) 1, (char) 2));
    }

    @Test
    public void removeAtIndex()
    {
        MutableCharList list = this.classUnderTest();
        list.removeAtIndex(1);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 3), list);
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
        MutableCharList list = this.classUnderTest();
        list.set(1, (char) 4);
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 4, (char) 3), list);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void subList()
    {
        this.classUnderTest().subList(0, 1);
    }

    @Override
    @Test
    public void charIterator()
    {
        CharIterator iterator = this.classUnderTest().charIterator();
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
        Assert.assertArrayEquals(new char[]{(char) 1, (char) 2, (char) 4, (char) 3}, this.newWith((char) 1, (char) 2, (char) 4, (char) 3).toArray());
    }

    @Test
    public void reverseThis()
    {
        Assert.assertEquals(new CharArrayList(), this.newWith().reverseThis());
        MutableCharList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.reverseThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3), this.newWith((char) 3).reverseThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1), this.newWith((char) 1, (char) 3).reverseThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7), this.newWith((char) 7, (char) 9, (char) 1, (char) 3).reverseThis());
        MutableCharList sameList = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        Assert.assertSame(sameList, sameList.reverseThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7, (char) 8), this.newWith((char) 8, (char) 7, (char) 9, (char) 1, (char) 3).reverseThis());

        MutableCharList list1 = CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4);
        list1.removeAtIndex(3);
        Assert.assertEquals(list1, CharArrayList.newListWith((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(list1.reverseThis(), CharArrayList.newListWith((char) 3, (char) 2, (char) 1));
    }

    @Test
    public void sortThis()
    {
        Assert.assertEquals(new CharArrayList(), this.newWith().sortThis());
        MutableCharList emptyList = this.newWith();
        Assert.assertSame(emptyList, emptyList.sortThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 3), this.newWith((char) 3).sortThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 3), this.newWith((char) 3, (char) 1).sortThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 3, (char) 7, (char) 9), this.newWith((char) 3, (char) 1, (char) 9, (char) 7).sortThis());
        MutableCharList sameList = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        Assert.assertSame(sameList, sameList.sortThis());
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 3, (char) 7, (char) 8, (char) 9), this.newWith((char) 8, (char) 1, (char) 7, (char) 3, (char) 9).sortThis());
        MutableCharList list = this.newWith();
        list.add((char) 2);
        list.add((char) 1);
        list.sortThis();
        Assert.assertEquals((char) 1, list.get(0));
    }

    @Test
    public void binarySearch()
    {
        MutableCharList list = this.newWith((char) 2, (char) 3, (char) 5, (char) 6, (char) 9);
        Assert.assertEquals(-1, list.binarySearch((char) 1));
        Assert.assertEquals(0, list.binarySearch((char) 2));
        Assert.assertEquals(1, list.binarySearch((char) 3));
        Assert.assertEquals(-3, list.binarySearch((char) 4));
        Assert.assertEquals(2, list.binarySearch((char) 5));
        Assert.assertEquals(3, list.binarySearch((char) 6));
        Assert.assertEquals(-5, list.binarySearch((char) 7));
        Assert.assertEquals(-5, list.binarySearch((char) 8));
        Assert.assertEquals(4, list.binarySearch((char) 9));
        Assert.assertEquals(-6, list.binarySearch((char) 10));
    }

    @Test
    public void toReversed()
    {
        Assert.assertEquals(new CharArrayList(), this.newWith().toReversed());
        MutableCharList emptyList = this.newWith();
        Assert.assertNotSame(emptyList, emptyList.toReversed());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7), this.newWith((char) 7, (char) 9, (char) 1, (char) 3).toReversed());
        MutableCharList evenList = this.newWith((char) 3, (char) 1, (char) 9, (char) 7);
        Assert.assertNotSame(evenList, evenList.toReversed());
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7, (char) 8), this.newWith((char) 8, (char) 7, (char) 9, (char) 1, (char) 3).toReversed());
        MutableCharList oddList = this.newWith((char) 3, (char) 1, (char) 9, (char) 7, (char) 8);
        Assert.assertNotSame(oddList, oddList.toReversed());
    }

    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((char each, int index) -> sum[0] += each + index);

        Assert.assertEquals(9L, sum[0]);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex()
    {
        MutableList<CharIntPair> pairs = this.newWith((char) 3, (char) 1, (char) 9, (char) 7)
                .collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(CharIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                CharLists.mutable.with((char) 3, (char) 1, (char) 9, (char) 7),
                pairs.collectChar(CharIntPair::getOne, CharLists.mutable.empty()));

        MutableSet<CharIntPair> set = this.newWith((char) 3, (char) 1, (char) 9, (char) 7)
                .collectWithIndex(PrimitiveTuples::pair, Sets.mutable.empty());
        Assert.assertEquals(
                IntSets.mutable.with(0, 1, 2, 3),
                pairs.collectInt(CharIntPair::getTwo, IntSets.mutable.empty()));
        Assert.assertEquals(
                CharSets.mutable.with((char) 3, (char) 1, (char) 9, (char) 7),
                pairs.collectChar(CharIntPair::getOne, CharSets.mutable.empty()));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget()
    {
        MutableList<CharIntPair> pairs = this.newWith((char) 3, (char) 1, (char) 9, (char) 7)
                .collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(
                IntLists.mutable.with(0, 1, 2, 3),
                pairs.collectInt(CharIntPair::getTwo, IntLists.mutable.empty()));
        Assert.assertEquals(
                CharLists.mutable.with((char) 3, (char) 1, (char) 9, (char) 7),
                pairs.collectChar(CharIntPair::getOne, CharLists.mutable.empty()));
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4);
        MutableCharList list2 = this.newWith((char) 4, (char) 3, (char) 2, (char) 1);
        Assert.assertNotEquals(list1, list2);
    }

    @Override
    @Test
    public void testToString()
    {
        super.testToString();
        Assert.assertEquals("[\u0001, \u0002, \u0003]", this.classUnderTest().toString());
    }

    @Test
    public void distinct()
    {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3, (char) 4, (char) 4, (char) 4, (char) 4).distinct();
        MutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4);
        Assert.assertEquals(list1, list2);
    }

    @Override
    @Test
    public void makeString()
    {
        super.makeString();
        Assert.assertEquals("\u0001, \u0002, \u0003", this.classUnderTest().makeString());
        Assert.assertEquals("\u0001/\u0002/\u0003", this.classUnderTest().makeString("/"));
        Assert.assertEquals(this.classUnderTest().toString(), this.classUnderTest().makeString("[", ", ", "]"));
    }

    @Override
    @Test
    public void appendString()
    {
        super.appendString();
        StringBuilder appendable2 = new StringBuilder();
        this.classUnderTest().appendString(appendable2);
        Assert.assertEquals("\u0001, \u0002, \u0003", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.classUnderTest().appendString(appendable3, "/");
        Assert.assertEquals("\u0001/\u0002/\u0003", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        this.classUnderTest().appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(this.classUnderTest().toString(), appendable4.toString());
    }

    @Override
    @Test
    public void toList()
    {
        super.toList();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toList());
    }

    @Test
    public void toImmutable()
    {
        ImmutableCharList immutable = this.classUnderTest().toImmutable();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), immutable);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        CharArrayList arrayList = CharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = arrayList.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }

    @Test
    public void injectIntoWithIndex()
    {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = list1.injectIntoWithIndex(new MutableCharacter((char) 0),
            (MutableCharacter object, char value, int index) -> object.add((char) (value * list2.get(index))));
        Assert.assertEquals(new MutableCharacter((char) 14), result);
    }

    @Test
    public void zipChar()
    {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2);
        MutableList<CharCharPair> zipSame = list1.zipChar(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, (char) 1),
                    PrimitiveTuples.pair((char) 2, (char) 2),
                    PrimitiveTuples.pair((char) 3, (char) 3)),
                zipSame);
        MutableList<CharCharPair> zipSameLazy = list1.zipChar(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, (char) 1),
                    PrimitiveTuples.pair((char) 2, (char) 2),
                    PrimitiveTuples.pair((char) 3, (char) 3)),
                zipSameLazy);
        MutableList<CharCharPair> zipLess = list1.zipChar(list2);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, (char) 1),
                    PrimitiveTuples.pair((char) 2, (char) 2)),
                zipLess);
        MutableList<CharCharPair> zipLessLazy = list1.zipChar(list2.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, (char) 1),
                    PrimitiveTuples.pair((char) 2, (char) 2)),
                zipLess);
        MutableList<CharCharPair> zipMore = list2.zipChar(list1);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, (char) 1),
                    PrimitiveTuples.pair((char) 2, (char) 2)),
                zipMore);
        MutableList<CharCharPair> zipMoreLazy = list2.zipChar(list1.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, (char) 1),
                    PrimitiveTuples.pair((char) 2, (char) 2)),
                zipMoreLazy);
        MutableList<CharCharPair> zipEmpty = list1.zipChar(this.newWith());
        Assert.assertTrue(zipEmpty.isEmpty());
    }

    @Test
    public void zip()
    {
        MutableCharList list1 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharList list2 = this.newWith((char) 1, (char) 2);
        MutableList<String> list3 = Lists.mutable.with("1", "2", "3");
        MutableList<String> list4 = Lists.mutable.with("1", "2");
        MutableList<CharObjectPair<String>> zipSame = list1.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, "1"),
                    PrimitiveTuples.pair((char) 2, "2"),
                    PrimitiveTuples.pair((char) 3, "3")),
                zipSame);
        MutableList<CharObjectPair<String>> zipSameLazy = list1.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, "1"),
                    PrimitiveTuples.pair((char) 2, "2"),
                    PrimitiveTuples.pair((char) 3, "3")),
                zipSameLazy);
        MutableList<CharObjectPair<String>> zipLess = list1.zip(list4);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, "1"),
                    PrimitiveTuples.pair((char) 2, "2")),
                zipLess);
        MutableList<CharObjectPair<String>> zipLessLazy = list1.zip(list4.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, "1"),
                    PrimitiveTuples.pair((char) 2, "2")),
                zipLessLazy);
        MutableList<CharObjectPair<String>> zipMore = list2.zip(list3);
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, "1"),
                    PrimitiveTuples.pair((char) 2, "2")),
                zipMore);
        MutableList<CharObjectPair<String>> zipMoreLazy = list2.zip(list3.asLazy());
        Assert.assertEquals(
                Lists.mutable.with(
                    PrimitiveTuples.pair((char) 1, "1"),
                    PrimitiveTuples.pair((char) 2, "2")),
                zipMoreLazy);
        MutableList<CharObjectPair<String>> zipEmpty = list1.zip(Lists.mutable.empty());
        Assert.assertTrue(zipEmpty.isEmpty());
    }
}
