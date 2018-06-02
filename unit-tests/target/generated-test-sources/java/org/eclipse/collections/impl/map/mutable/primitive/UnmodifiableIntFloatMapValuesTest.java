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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableFloatCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedFloatCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableFloatCollection;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntFloatMap#values()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapValuesTest.stg.
 */
public class UnmodifiableIntFloatMapValuesTest extends AbstractMutableFloatCollectionTestCase
{
    @Override
    protected MutableFloatCollection classUnderTest()
    {
        return IntFloatHashMap.newWithKeysValues(1, 1.0f, 2, 2.0f, 3, 3.0f).values().asUnmodifiable();
    }

    @Override
    protected MutableFloatCollection newWith(float... elements)
    {
        IntFloatHashMap map = new IntFloatHashMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(i, elements[i]);
        }
        return map.asUnmodifiable().values();
    }

    @Override
    protected MutableFloatCollection newMutableCollectionWith(float... elements)
    {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Float> newObjectCollectionWith(Float... elements)
    {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void floatIterator()
    {
        MutableFloatCollection bag = this.newWith(0.0f, 1.0f, 2.0f, 3.0f);
        FloatArrayList list = FloatArrayList.newListWith(0.0f, 1.0f, 2.0f, 3.0f);
        FloatIterator iterator = bag.floatIterator();
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
    public void floatIterator_with_remove()
    {
        MutableFloatCollection floatIterable = this.classUnderTest();
        MutableFloatIterator iterator = floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_remove_before_next()
    {
        MutableFloatCollection floatIterable = this.classUnderTest();
        MutableFloatIterator iterator = floatIterable.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void floatIterator_throws_for_consecutive_remove()
    {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllIterable()
    {
        this.classUnderTest().addAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add(0.0f);
    }

    @Override
    @Test
    public void testEquals_NaN()
    {
        //Testing equals() is not applicable for MutableFloatCollection.
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll(0.0f, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.classUnderTest().withoutAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.classUnderTest().remove(0.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeIf()
    {
        this.classUnderTest().removeIf(FloatPredicates.equal(0.0f));
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        MutableFloatCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableFloatCollection.class, collection.asUnmodifiable());
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
        this.newWith().removeAll(new FloatArrayList());
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
        this.newWith().retainAll(new FloatArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        MutableFloatCollection emptyCollection = this.newWith();
        emptyCollection.clear();
    }

    @Override
    @Test
    public void contains()
    {
        MutableFloatCollection collection = this.newWith(14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f);
        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));

        float[] numbers = {14.0f, 2.0f, 30.0f, 31.0f, 32.0f, 35.0f, 0.0f, 1.0f};
        for (float number : numbers)
        {
            Assert.assertTrue(collection.contains(number));
        }

        Assert.assertFalse(collection.contains(29.0f));
        Assert.assertFalse(collection.contains(49.0f));
    }

    @Override
    @Test
    public void reject()
    {
        FloatIterable iterable = this.classUnderTest();
        Verify.assertSize(0, iterable.reject(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(1, iterable.reject(FloatPredicates.lessThan(3.0f)));
    }

    @Override
    @Test
    public void select()
    {
        FloatIterable iterable = this.classUnderTest();
        Verify.assertSize(3, iterable.select(FloatPredicates.lessThan(4.0f)));
        Verify.assertSize(2, iterable.select(FloatPredicates.lessThan(3.0f)));
    }

    @Override
    @Test
    public void collect()
    {
        super.collect();

        FloatToObjectFunction<Float> function = (float parameter) -> parameter - 1;
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 2.0f).toBag(), this.newWith(1.0f, 2.0f, 3.0f).collect(function).toBag());
        FloatIterable iterable = this.newWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(this.newObjectCollectionWith(0.0f, 1.0f, 2.0f).toBag(), iterable.collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(2.0f), this.newWith(3.0f).collect(function));
    }

    @Override
    @Test
    public void makeString()
    {
        Assert.assertEquals("1.0", this.newWith(1.0f).makeString("/"));
        Assert.assertEquals("31.0", this.newWith(31.0f).makeString());
        Assert.assertEquals("32.0", this.newWith(32.0f).makeString());
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));

        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        Assert.assertTrue(
                iterable1.makeString(),
                iterable1.makeString().equals("0.0, 31.0")
                        || iterable1.makeString().equals("31.0, 0.0"));

        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                iterable2.makeString("[", "/", "]").equals("[31.0/32.0]")
                        || iterable2.makeString("[", "/", "]").equals("[32.0/31.0]"));

        FloatIterable iterable3 = this.newWith(32.0f, 33.0f);
        Assert.assertTrue(
                iterable3.makeString("/"),
                iterable3.makeString("/").equals("32.0/33.0")
                        || iterable3.makeString("/").equals("33.0/32.0"));

        FloatIterable iterable4 = this.newWith(1.0f, 2.0f);
        Assert.assertTrue("1.0, 2.0".equals(iterable4.makeString())
                || "2.0, 1.0".equals(iterable4.makeString()));
        Assert.assertTrue("1.0/2.0".equals(iterable4.makeString("/"))
                || "2.0/1.0".equals(iterable4.makeString("/")));
        Assert.assertTrue("[1.0/2.0]".equals(iterable4.makeString("[", "/", "]"))
                || "[2.0/1.0]".equals(iterable4.makeString("[", "/", "]")));

        FloatIterable iterable5 = this.newWith(0.0f, 1.0f);
        Assert.assertTrue(
                iterable5.makeString(),
                iterable5.makeString().equals("0.0, 1.0")
                        || iterable5.makeString().equals("1.0, 0.0"));
        Assert.assertTrue(
                iterable5.makeString("[", "/", "]"),
                iterable5.makeString("[", "/", "]").equals("[0.0/1.0]")
                        || iterable5.makeString("[", "/", "]").equals("[1.0/0.0]"));
        Assert.assertTrue(
                iterable5.makeString("/"),
                iterable5.makeString("/").equals("0.0/1.0")
                        || iterable5.makeString("/").equals("1.0/0.0"));
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
        this.newWith(1.0f).appendString(appendable1);
        Assert.assertEquals("1.0", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();

        FloatIterable iterable = this.newWith(1.0f, 2.0f);
        iterable.appendString(appendable2);
        Assert.assertTrue("1.0, 2.0".equals(appendable2.toString())
                || "2.0, 1.0".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("1.0/2.0".equals(appendable3.toString())
                || "2.0/1.0".equals(appendable3.toString()));

        StringBuilder appendable5 = new StringBuilder();
        this.newWith(31.0f).appendString(appendable5);
        Assert.assertEquals("31.0", appendable5.toString());

        StringBuilder appendable6 = new StringBuilder();
        this.newWith(32.0f).appendString(appendable6);
        Assert.assertEquals("32.0", appendable6.toString());

        StringBuilder appendable7 = new StringBuilder();
        FloatIterable iterable1 = this.newWith(0.0f, 31.0f);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "0.0, 31.0".equals(appendable7.toString())
                || "31.0, 0.0".equals(appendable7.toString()));

        StringBuilder appendable8 = new StringBuilder();
        FloatIterable iterable2 = this.newWith(31.0f, 32.0f);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "31.0/32.0".equals(appendable8.toString())
                || "32.0/31.0".equals(appendable8.toString()));

        StringBuilder appendable9 = new StringBuilder();
        FloatIterable iterable4 = this.newWith(32.0f, 33.0f);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[32.0/33.0]".equals(appendable9.toString())
                || "[33.0/32.0]".equals(appendable9.toString()));

        StringBuilder appendable10 = new StringBuilder();
        FloatIterable iterable5 = this.newWith(0.0f, 1.0f);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "0.0, 1.0".equals(appendable10.toString())
                || "1.0, 0.0".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "0.0/1.0".equals(appendable11.toString())
                || "1.0/0.0".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[0.0/1.0]".equals(appendable12.toString())
                || "[1.0/0.0]".equals(appendable12.toString()));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        MutableFloatCollection collection = this.classUnderTest().asSynchronized();
        Verify.assertInstanceOf(SynchronizedFloatCollection.class, collection);
    }

    @Override
    @Test
    public void testEquals()
    {
        //Testing equals() is not applicable for MutableFloatCollection.
    }

    @Override
    public void testToString()
    {
        //Testing toString() is not applicable for MutableFloatCollection.
    }

    @Override
    public void testHashCode()
    {
        //Testing hashCode() is not applicable for MutableFloatCollection.
    }

    @Override
    public void newCollection()
    {
        //Testing newCollection() is not applicable for MutableFloatCollection.
    }

    @Override
    @Test
    public void chunk()
    {
        FloatIterable iterable = this.classUnderTest();
        Assert.assertEquals(
                Lists.mutable.with(
                        FloatBags.mutable.with(1.0f),
                        FloatBags.mutable.with(2.0f),
                        FloatBags.mutable.with(3.0f)).toSet(),
                iterable.chunk(1).toSet());

        MutableSet<FloatIterable> chunked = iterable.chunk(2).toSet();
        Assert.assertTrue(
                Lists.mutable.with(
                        FloatBags.mutable.with(1.0f, 2.0f),
                        FloatBags.mutable.with(3.0f)).toSet().equals(chunked)
                || Lists.mutable.with(
                        FloatBags.mutable.with(2.0f, 3.0f),
                        FloatBags.mutable.with(1.0f)).toSet().equals(chunked)
                || Lists.mutable.with(
                        FloatBags.mutable.with(1.0f, 3.0f),
                        FloatBags.mutable.with(2.0f)).toSet().equals(chunked));

        Assert.assertEquals(
                Lists.mutable.with(
                        FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(FloatBags.mutable.with(1.0f, 2.0f, 3.0f)).toSet(),
                iterable.chunk(4).toSet());

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
    }
}
