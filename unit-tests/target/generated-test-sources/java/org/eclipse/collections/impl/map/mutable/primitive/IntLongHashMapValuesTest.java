/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableLongCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedLongCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableLongCollection;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntLongHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class IntLongHashMapValuesTest extends AbstractMutableLongCollectionTestCase
{
    @Override
    protected MutableLongCollection classUnderTest()
    {
        return IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L).values();
    }

    @Override
    protected MutableLongCollection newWith(long... elements)
    {
        IntLongHashMap map = new IntLongHashMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableLongCollection newMutableCollectionWith(long... elements)
    {
        return this.newWith(elements);
    }

    @Override
    protected Bag<Long> newObjectCollectionWith(Long... elements)
    {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void longIterator()
    {
        MutableLongCollection bag = this.newWith(0L, 1L, 2L, 3L);
        LongArrayList list = LongArrayList.newListWith(0L, 1L, 2L, 3L);
        LongIterator iterator = bag.longIterator();
        for (int i = 0; i < 4; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            Assert.assertTrue(list.remove(iterator.next()));
        }
        Verify.assertEmpty(list);
        Assert.assertFalse(iterator.hasNext());

        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll(0L, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without(0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new LongArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.classUnderTest().withoutAll(new LongArrayList());
    }

    @Override
    @Test
    public void remove()
    {
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertTrue(collection.remove(3L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertTrue(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertTrue(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
    }

    @Override
    @Test
    public void removeIf()
    {
        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(LongPredicates.equal(3L)));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertTrue(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertTrue(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertFalse(collection.removeIf(LongPredicates.equal(3L)));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        MutableLongCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedLongCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        MutableLongCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableLongCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void removeAll()
    {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(1L));

        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());

        Assert.assertTrue(collection.removeAll(1L, 5L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));

        Assert.assertTrue(collection.removeAll(3L, 2L));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void removeAll_iterable()
    {
        Assert.assertFalse(this.newWith().removeAll(new LongArrayList()));
        Assert.assertFalse(this.newWith().removeAll(LongArrayList.newListWith(1L)));

        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());

        Assert.assertTrue(collection.removeAll(LongArrayList.newListWith(1L, 5L)));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));

        Assert.assertTrue(collection.removeAll(LongArrayList.newListWith(3L, 2L)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll()
    {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll(1L));

        IntLongHashMap map = IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(0L, 1L, 2L, 3L));

        Assert.assertTrue(collection.retainAll(0L, 2L, 3L, 5L));
        Assert.assertTrue(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertTrue(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));

        Assert.assertTrue(collection.retainAll(2L, 3L, 5L));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));

        Assert.assertTrue(collection.retainAll(3L, 5L));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));

        Assert.assertTrue(collection.retainAll(0L, 0L, 1L));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable()
    {
        Assert.assertFalse(this.newWith().retainAll(new LongArrayList()));
        Assert.assertFalse(this.newWith().retainAll(LongArrayList.newListWith(1L)));

        IntLongHashMap map = IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        MutableLongCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(LongArrayList.newListWith(0L, 1L, 2L, 3L)));

        Assert.assertTrue(collection.retainAll(LongArrayList.newListWith(0L, 2L, 3L, 5L)));
        Assert.assertTrue(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertTrue(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));

        Assert.assertTrue(collection.retainAll(LongArrayList.newListWith(2L, 3L, 5L)));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertTrue(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertTrue(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));

        Assert.assertTrue(collection.retainAll(LongArrayList.newListWith(3L, 5L)));
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertTrue(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertTrue(map.contains(3L));
        Assert.assertFalse(map.contains(5L));

        Assert.assertTrue(collection.retainAll(LongArrayList.newListWith(0L, 0L, 1L)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));
        Assert.assertFalse(collection.contains(5L));
        Assert.assertFalse(map.contains(0L));
        Assert.assertFalse(map.contains(1L));
        Assert.assertFalse(map.contains(2L));
        Assert.assertFalse(map.contains(3L));
        Assert.assertFalse(map.contains(5L));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear()
    {
        MutableLongCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);

        IntLongHashMap map = IntLongHashMap.newWithKeysValues(1, 1L, 2, 2L, 3, 3L);
        MutableLongCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(0L));
        Assert.assertFalse(collection.contains(1L));
        Assert.assertFalse(collection.contains(2L));
        Assert.assertFalse(collection.contains(3L));

        MutableLongCollection collection1 = this.newWith(0L, 1L, 31L, 32L);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains(0L));
        Assert.assertFalse(collection1.contains(1L));
        Assert.assertFalse(collection1.contains(31L));
        Assert.assertFalse(collection1.contains(32L));

        MutableLongCollection collection2 = this.newWith(0L, 1L, 2L);
        collection2.clear();
        Verify.assertSize(0, collection2);
    }

    @Override
    @Test
    public void contains()
    {
        MutableLongCollection collection = this.newWith(14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L);
        Assert.assertFalse(collection.contains(29L));
        Assert.assertFalse(collection.contains(49L));

        long[] numbers = {14L, 2L, 30L, 31L, 32L, 35L, 0L, 1L};
        for (long number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }

        Assert.assertFalse(collection.contains(29L));
        Assert.assertFalse(collection.contains(49L));
    }

    @Override
    @Test
    public void reject()
    {
        LongIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(LongPredicates.lessThan(4L)));
        Verify.assertSize(1, iterable.reject(LongPredicates.lessThan(3L)));
    }

    @Override
    @Test
    public void select()
    {
        LongIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(LongPredicates.lessThan(4L)));
        Verify.assertSize(2, iterable.select(LongPredicates.lessThan(3L)));
    }

    @Override
    @Test
    public void collect()
    {
        LongToObjectFunction<Long> function = (long parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 2L).toBag(), this.newWith(1L, 2L, 3L).collect(function).toBag());
        LongIterable iterable = this.newWith(1L, 2L, 3L);
        Assert.assertEquals(this.newObjectCollectionWith(0L, 1L, 2L).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2L), this.newWith(3L).collect(function));
    }

    @Override
    @Test
    public void makeString()
    {
        Assert.assertEquals("1", this.newWith(1L).makeString("/"));
        Assert.assertEquals("31", this.newWith(31L).makeString());
        Assert.assertEquals("32", this.newWith(32L).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));

        LongIterable iterable1 = this.newWith(0L, 31L);
        Assert.assertTrue(
                iterable1.makeString(),
                iterable1.makeString().equals("0, 31")
                        || iterable1.makeString().equals("31, 0"));

        LongIterable iterable2 = this.newWith(31L, 32L);
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                iterable2.makeString("[", "/", "]").equals("[31/32]")
                        || iterable2.makeString("[", "/", "]").equals("[32/31]"));

        LongIterable iterable3 = this.newWith(32L, 33L);
        Assert.assertTrue(
                iterable3.makeString("/"),
                iterable3.makeString("/").equals("32/33")
                        || iterable3.makeString("/").equals("33/32"));

        LongIterable iterable4 = this.newWith(1L, 2L);
        Assert.assertTrue("1, 2".equals(iterable4.makeString())
                || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/"))
                || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]"))
                || "[2/1]".equals(iterable4.makeString("[", "/", "]")));

        LongIterable iterable5 = this.newWith(0L, 1L);
        Assert.assertTrue(
                iterable5.makeString(),
                iterable5.makeString().equals("0, 1")
                        || iterable5.makeString().equals("1, 0"));
        Assert.assertTrue(
                iterable5.makeString("[", "/", "]"),
                iterable5.makeString("[", "/", "]").equals("[0/1]")
                        || iterable5.makeString("[", "/", "]").equals("[1/0]"));
        Assert.assertTrue(
                iterable5.makeString("/"),
                iterable5.makeString("/").equals("0/1")
                        || iterable5.makeString("/").equals("1/0"));
    }

    @Override
    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", ", ", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(1L).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();

        LongIterable iterable = this.newWith(1L, 2L);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString())
                || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString())
                || "2/1".equals(appendable3.toString()));

        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31L).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());

        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32L).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());

        StringBuilder appendable7 = new StringBuilder();
        LongIterable iterable1 = this.newWith(0L, 31L);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString())
                || "31, 0".equals(appendable7.toString()));

        StringBuilder appendable8 = new StringBuilder();
        LongIterable iterable2 = this.newWith(31L, 32L);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString())
                || "32/31".equals(appendable8.toString()));

        StringBuilder appendable9 = new StringBuilder();
        LongIterable iterable4 = this.newWith(32L, 33L);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString())
                || "[33/32]".equals(appendable9.toString()));

        StringBuilder appendable10 = new StringBuilder();
        LongIterable iterable5 = this.newWith(0L, 1L);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0, 1".equals(appendable10.toString())
                || "1, 0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0/1".equals(appendable11.toString())
                || "1/0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0/1]".equals(appendable12.toString())
                || "[1/0]".equals(appendable12.toString()));
    }

    @Override
    @Test
    public void testEquals()
    {
        //Testing equals() is not applicable for MutableLongCollection.
    }

    @Override
    public void testToString()
    {
        //Testing toString() is not applicable for MutableLongCollection.
    }

    @Override
    public void testHashCode()
    {
        //Testing hashCode() is not applicable for MutableLongCollection.
    }

    @Override
    public void newCollection()
    {
        //Testing newCollection() is not applicable for MutableLongCollection.
    }

    @Override
    @Test
    public void chunk()
    {
        LongIterable iterable = this.classUnderTest();
        Assert.assertEquals(
                Lists.mutable.with(
                        LongBags.mutable.with(1L),
                        LongBags.mutable.with(2L),
                        LongBags.mutable.with(3L)).toSet(),
                iterable.chunk(1).toSet());

        MutableSet<LongIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(
                Lists.mutable.with(
                        LongBags.mutable.with(1L, 2L),
                        LongBags.mutable.with(3L)).toSet().equals(chunked)
                || Lists.mutable.with(
                        LongBags.mutable.with(2L, 3L),
                        LongBags.mutable.with(1L)).toSet().equals(chunked)
                || Lists.mutable.with(
                        LongBags.mutable.with(1L, 3L),
                        LongBags.mutable.with(2L)).toSet().equals(chunked));

        Assert.assertEquals(
                Lists.mutable.with(
                        LongBags.mutable.with(1L, 2L, 3L)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(LongBags.mutable.with(1L, 2L, 3L)).toSet(),
                iterable.chunk(4).toSet());

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }
}
