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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableIntCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedIntCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableIntCollection;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteIntMap#values()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapValuesTest.stg.
 */
public class UnmodifiableByteIntMapValuesTest extends AbstractMutableIntCollectionTestCase
{
    @Override
    protected MutableIntCollection classUnderTest()
    {
        return ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3).values().asUnmodifiable();
    }

    @Override
    protected MutableIntCollection newWith(int... elements)
    {
        ByteIntHashMap map = new ByteIntHashMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put((byte) i, elements[i]);
        }
        return map.asUnmodifiable().values();
    }

    @Override
    protected MutableIntCollection newMutableCollectionWith(int... elements)
    {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Integer> newObjectCollectionWith(Integer... elements)
    {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void intIterator()
    {
        MutableIntCollection bag = this.newWith(0, 1, 2, 3);
        IntArrayList list = IntArrayList.newListWith(0, 1, 2, 3);
        IntIterator iterator = bag.intIterator();
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
    @Test
    public void intIterator_with_remove()
    {
        MutableIntCollection intIterable = this.classUnderTest();
        MutableIntIterator iterator = intIterable.intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void intIterator_throws_for_remove_before_next()
    {
        MutableIntCollection intIterable = this.classUnderTest();
        MutableIntIterator iterator = intIterable.intIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void intIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll(0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.classUnderTest().withoutAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.classUnderTest().remove(0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(IntPredicates.equal(0));
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        MutableIntCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableIntCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll()
    {
        this.newWith().removeAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeAll_iterable()
    {
        this.newWith().removeAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll()
    {
        this.newWith().retainAll();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void retainAll_iterable()
    {
        this.newWith().retainAll(new IntArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        MutableIntCollection emptyCollection = this.newWith();
        emptyCollection.clear();
    }

    @Override
    @Test
    public void contains()
    {
        MutableIntCollection collection = this.newWith(14, 2, 30, 31, 32, 35, 0, 1);
        Assert.assertFalse(collection.contains(29));
        Assert.assertFalse(collection.contains(49));

        int[] numbers = {14, 2, 30, 31, 32, 35, 0, 1};
        for (int number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains(29));
        Assert.assertFalse(collection.contains(49));
    }

    @Override
    @Test
    public void reject()
    {
        IntIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(IntPredicates.lessThan(4)));
        Verify.assertSize(1, iterable.reject(IntPredicates.lessThan(3)));
    }

    @Override
    @Test
    public void select()
    {
        IntIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(IntPredicates.lessThan(4)));
        Verify.assertSize(2, iterable.select(IntPredicates.lessThan(3)));
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();

        IntToObjectFunction<Integer> function = (int parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0, 1, 2).toBag(), this.newWith(1, 2, 3).collect(function).toBag());
        IntIterable iterable = this.newWith(1, 2, 3);
        Assert.assertEquals(this.newObjectCollectionWith(0, 1, 2).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2), this.newWith(3).collect(function));
    }

    @Override
    @Test
    public void makeString()
    {
        Assert.assertEquals("1", this.newWith(1).makeString("/"));
        Assert.assertEquals("31", this.newWith(31).makeString());
        Assert.assertEquals("32", this.newWith(32).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));

        IntIterable iterable1 = this.newWith(0, 31);
        Assert.assertTrue(
                iterable1.makeString(),
                iterable1.makeString().equals("0, 31")
                        || iterable1.makeString().equals("31, 0"));

        IntIterable iterable2 = this.newWith(31, 32);
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                iterable2.makeString("[", "/", "]").equals("[31/32]")
                        || iterable2.makeString("[", "/", "]").equals("[32/31]"));

        IntIterable iterable3 = this.newWith(32, 33);
        Assert.assertTrue(
                iterable3.makeString("/"),
                iterable3.makeString("/").equals("32/33")
                        || iterable3.makeString("/").equals("33/32"));

        IntIterable iterable4 = this.newWith(1, 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString())
                || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/"))
                || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]"))
                || "[2/1]".equals(iterable4.makeString("[", "/", "]")));

        IntIterable iterable5 = this.newWith(0, 1);
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
        this.newWith(1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();

        IntIterable iterable = this.newWith(1, 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString())
                || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString())
                || "2/1".equals(appendable3.toString()));

        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());

        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());

        StringBuilder appendable7 = new StringBuilder();
        IntIterable iterable1 = this.newWith(0, 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString())
                || "31, 0".equals(appendable7.toString()));

        StringBuilder appendable8 = new StringBuilder();
        IntIterable iterable2 = this.newWith(31, 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString())
                || "32/31".equals(appendable8.toString()));

        StringBuilder appendable9 = new StringBuilder();
        IntIterable iterable4 = this.newWith(32, 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString())
                || "[33/32]".equals(appendable9.toString()));

        StringBuilder appendable10 = new StringBuilder();
        IntIterable iterable5 = this.newWith(0, 1);
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
    public void asSynchronized()
    {
        MutableIntCollection collection = this.classUnderTest().asSynchronized();
        Verify.assertInstanceOf(SynchronizedIntCollection.class, collection);
    }

    @Override
    @Test
    public void testEquals()
    {
        //Testing equals() is not applicable for MutableIntCollection.
    }

    @Override
    public void testToString()
    {
        //Testing toString() is not applicable for MutableIntCollection.
    }

    @Override
    public void testHashCode()
    {
        //Testing hashCode() is not applicable for MutableIntCollection.
    }

    @Override
    public void newCollection()
    {
        //Testing newCollection() is not applicable for MutableIntCollection.
    }

    @Override
    @Test
    public void chunk()
    {
        IntIterable iterable = this.classUnderTest();
        Assert.assertEquals(
                Lists.mutable.with(
                        IntBags.mutable.with(1),
                        IntBags.mutable.with(2),
                        IntBags.mutable.with(3)).toSet(),
                iterable.chunk(1).toSet());

        MutableSet<IntIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(
                Lists.mutable.with(
                        IntBags.mutable.with(1, 2),
                        IntBags.mutable.with(3)).toSet().equals(chunked)
                || Lists.mutable.with(
                        IntBags.mutable.with(2, 3),
                        IntBags.mutable.with(1)).toSet().equals(chunked)
                || Lists.mutable.with(
                        IntBags.mutable.with(1, 3),
                        IntBags.mutable.with(2)).toSet().equals(chunked));

        Assert.assertEquals(
                Lists.mutable.with(
                        IntBags.mutable.with(1, 2, 3)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(IntBags.mutable.with(1, 2, 3)).toSet(),
                iterable.chunk(4).toSet());

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }
}
