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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableByteCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedByteCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableByteCollection;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteByteHashMap#values()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapValuesTest.stg.
 */
public class ByteByteHashMapValuesTest extends AbstractMutableByteCollectionTestCase
{
    @Override
    protected MutableByteCollection classUnderTest()
    {
        return ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3).values();
    }

    @Override
    protected MutableByteCollection newWith(byte... elements)
    {
        ByteByteHashMap map = new ByteByteHashMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put((byte) i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableByteCollection newMutableCollectionWith(byte... elements)
    {
        return this.newWith(elements);
    }

    @Override
    protected Bag<Byte> newObjectCollectionWith(Byte... elements)
    {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void byteIterator()
    {
        MutableByteCollection bag = this.newWith((byte) 0, (byte) 1, (byte) 2, (byte) 3);
        ByteArrayList list = ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3);
        ByteIterator iterator = bag.byteIterator();
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
        this.classUnderTest().addAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll((byte) 0, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without((byte) 0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new ByteArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.classUnderTest().withoutAll(new ByteArrayList());
    }

    @Override
    @Test
    public void remove()
    {
        ByteByteHashMap map = ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertTrue(collection.remove((byte) 3));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertTrue(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertTrue(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
    }

    @Override
    @Test
    public void removeIf()
    {
        ByteByteHashMap map = ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertTrue(collection.removeIf(BytePredicates.equal((byte) 3)));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertTrue(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertTrue(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertFalse(collection.removeIf(BytePredicates.equal((byte) 3)));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        MutableByteCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedByteCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        MutableByteCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableByteCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void removeAll()
    {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll((byte) 1));

        ByteByteHashMap map = ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());

        Assert.assertTrue(collection.removeAll((byte) 1, (byte) 5));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));

        Assert.assertTrue(collection.removeAll((byte) 3, (byte) 2));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void removeAll_iterable()
    {
        Assert.assertFalse(this.newWith().removeAll(new ByteArrayList()));
        Assert.assertFalse(this.newWith().removeAll(ByteArrayList.newListWith((byte) 1)));

        ByteByteHashMap map = ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertFalse(collection.removeAll());

        Assert.assertTrue(collection.removeAll(ByteArrayList.newListWith((byte) 1, (byte) 5)));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));

        Assert.assertTrue(collection.removeAll(ByteArrayList.newListWith((byte) 3, (byte) 2)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll()
    {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll((byte) 1));

        ByteByteHashMap map = ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertFalse(collection.retainAll((byte) 0, (byte) 1, (byte) 2, (byte) 3));

        Assert.assertTrue(collection.retainAll((byte) 0, (byte) 2, (byte) 3, (byte) 5));
        Assert.assertTrue(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertTrue(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));

        Assert.assertTrue(collection.retainAll((byte) 2, (byte) 3, (byte) 5));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));

        Assert.assertTrue(collection.retainAll((byte) 3, (byte) 5));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));

        Assert.assertTrue(collection.retainAll((byte) 0, (byte) 0, (byte) 1));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void retainAll_iterable()
    {
        Assert.assertFalse(this.newWith().retainAll(new ByteArrayList()));
        Assert.assertFalse(this.newWith().retainAll(ByteArrayList.newListWith((byte) 1)));

        ByteByteHashMap map = ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        MutableByteCollection collection = map.values();
        Assert.assertFalse(collection.retainAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2, (byte) 3)));

        Assert.assertTrue(collection.retainAll(ByteArrayList.newListWith((byte) 0, (byte) 2, (byte) 3, (byte) 5)));
        Assert.assertTrue(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertTrue(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));

        Assert.assertTrue(collection.retainAll(ByteArrayList.newListWith((byte) 2, (byte) 3, (byte) 5)));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertTrue(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertTrue(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));

        Assert.assertTrue(collection.retainAll(ByteArrayList.newListWith((byte) 3, (byte) 5)));
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertTrue(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertTrue(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));

        Assert.assertTrue(collection.retainAll(ByteArrayList.newListWith((byte) 0, (byte) 0, (byte) 1)));
        Assert.assertTrue(collection.isEmpty());
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));
        Assert.assertFalse(collection.contains((byte) 5));
        Assert.assertFalse(map.contains((byte) 0));
        Assert.assertFalse(map.contains((byte) 1));
        Assert.assertFalse(map.contains((byte) 2));
        Assert.assertFalse(map.contains((byte) 3));
        Assert.assertFalse(map.contains((byte) 5));
        Assert.assertTrue(map.isEmpty());
    }

    @Override
    @Test
    public void clear()
    {
        MutableByteCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);

        ByteByteHashMap map = ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        MutableByteCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains((byte) 0));
        Assert.assertFalse(collection.contains((byte) 1));
        Assert.assertFalse(collection.contains((byte) 2));
        Assert.assertFalse(collection.contains((byte) 3));

        MutableByteCollection collection1 = this.newWith((byte) 0, (byte) 1, (byte) 31, (byte) 32);
        collection1.clear();
        Verify.assertEmpty(collection1);
        Verify.assertSize(0, collection1);
        Assert.assertFalse(collection1.contains((byte) 0));
        Assert.assertFalse(collection1.contains((byte) 1));
        Assert.assertFalse(collection1.contains((byte) 31));
        Assert.assertFalse(collection1.contains((byte) 32));

        MutableByteCollection collection2 = this.newWith((byte) 0, (byte) 1, (byte) 2);
        collection2.clear();
        Verify.assertSize(0, collection2);
    }

    @Override
    @Test
    public void contains()
    {
        MutableByteCollection collection = this.newWith((byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1);
        Assert.assertFalse(collection.contains((byte) 29));
        Assert.assertFalse(collection.contains((byte) 49));

        byte[] numbers = {(byte) 14, (byte) 2, (byte) 30, (byte) 31, (byte) 32, (byte) 35, (byte) 0, (byte) 1};
        for (byte number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
            Assert.assertTrue(collection.remove(number));
            Assert.assertFalse(collection.contains(number));
        }

        Assert.assertFalse(collection.contains((byte) 29));
        Assert.assertFalse(collection.contains((byte) 49));
    }

    @Override
    @Test
    public void reject()
    {
        ByteIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(1, iterable.reject(BytePredicates.lessThan((byte) 3)));
    }

    @Override
    @Test
    public void select()
    {
        ByteIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(BytePredicates.lessThan((byte) 4)));
        Verify.assertSize(2, iterable.select(BytePredicates.lessThan((byte) 3)));
    }

    @Override
    @Test
    public void collect()
    {
        ByteToObjectFunction<Byte> function = (byte parameter) -> (byte) (parameter - 1);
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 2).toBag(), this.newWith((byte) 1, (byte) 2, (byte) 3).collect(function).toBag());
        ByteIterable iterable = this.newWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(this.newObjectCollectionWith((byte) 0, (byte) 1, (byte) 2).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith((byte) 2), this.newWith((byte) 3).collect(function));
    }

    @Override
    @Test
    public void makeString()
    {
        Assert.assertEquals("1", this.newWith((byte) 1).makeString("/"));
        Assert.assertEquals("31", this.newWith((byte) 31).makeString());
        Assert.assertEquals("32", this.newWith((byte) 32).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));

        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        Assert.assertTrue(
                iterable1.makeString(),
                iterable1.makeString().equals("0, 31")
                        || iterable1.makeString().equals("31, 0"));

        ByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                iterable2.makeString("[", "/", "]").equals("[31/32]")
                        || iterable2.makeString("[", "/", "]").equals("[32/31]"));

        ByteIterable iterable3 = this.newWith((byte) 32, (byte) 33);
        Assert.assertTrue(
                iterable3.makeString("/"),
                iterable3.makeString("/").equals("32/33")
                        || iterable3.makeString("/").equals("33/32"));

        ByteIterable iterable4 = this.newWith((byte) 1, (byte) 2);
        Assert.assertTrue("1, 2".equals(iterable4.makeString())
                || "2, 1".equals(iterable4.makeString()));
        Assert.assertTrue("1/2".equals(iterable4.makeString("/"))
                || "2/1".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1/2]".equals(iterable4.makeString("[", "/", "]"))
                || "[2/1]".equals(iterable4.makeString("[", "/", "]")));

        ByteIterable iterable5 = this.newWith((byte) 0, (byte) 1);
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
        this.newWith((byte) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();

        ByteIterable iterable = this.newWith((byte) 1, (byte) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("1, 2".equals(appendable2.toString())
                || "2, 1".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1/2".equals(appendable3.toString())
                || "2/1".equals(appendable3.toString()));

        StringBuilder appendable5 = new StringBuilder();
        this.newWith((byte) 31).appendString(appendable5);
        Assert.assertEquals("31", appendable5.toString());

        StringBuilder appendable6 = new StringBuilder();
        this.newWith((byte) 32).appendString(appendable6);
        Assert.assertEquals("32", appendable6.toString());

        StringBuilder appendable7 = new StringBuilder();
        ByteIterable iterable1 = this.newWith((byte) 0, (byte) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0, 31".equals(appendable7.toString())
                || "31, 0".equals(appendable7.toString()));

        StringBuilder appendable8 = new StringBuilder();
        ByteIterable iterable2 = this.newWith((byte) 31, (byte) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31/32".equals(appendable8.toString())
                || "32/31".equals(appendable8.toString()));

        StringBuilder appendable9 = new StringBuilder();
        ByteIterable iterable4 = this.newWith((byte) 32, (byte) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32/33]".equals(appendable9.toString())
                || "[33/32]".equals(appendable9.toString()));

        StringBuilder appendable10 = new StringBuilder();
        ByteIterable iterable5 = this.newWith((byte) 0, (byte) 1);
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
        //Testing equals() is not applicable for MutableByteCollection.
    }

    @Override
    public void testToString()
    {
        //Testing toString() is not applicable for MutableByteCollection.
    }

    @Override
    public void testHashCode()
    {
        //Testing hashCode() is not applicable for MutableByteCollection.
    }

    @Override
    public void newCollection()
    {
        //Testing newCollection() is not applicable for MutableByteCollection.
    }

    @Override
    @Test
    public void chunk()
    {
        ByteIterable iterable = this.classUnderTest();
        Assert.assertEquals(
                Lists.mutable.with(
                        ByteBags.mutable.with((byte) 1),
                        ByteBags.mutable.with((byte) 2),
                        ByteBags.mutable.with((byte) 3)).toSet(),
                iterable.chunk(1).toSet());

        MutableSet<ByteIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(
                Lists.mutable.with(
                        ByteBags.mutable.with((byte) 1, (byte) 2),
                        ByteBags.mutable.with((byte) 3)).toSet().equals(chunked)
                || Lists.mutable.with(
                        ByteBags.mutable.with((byte) 2, (byte) 3),
                        ByteBags.mutable.with((byte) 1)).toSet().equals(chunked)
                || Lists.mutable.with(
                        ByteBags.mutable.with((byte) 1, (byte) 3),
                        ByteBags.mutable.with((byte) 2)).toSet().equals(chunked));

        Assert.assertEquals(
                Lists.mutable.with(
                        ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3)).toSet(),
                iterable.chunk(4).toSet());

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }
}
