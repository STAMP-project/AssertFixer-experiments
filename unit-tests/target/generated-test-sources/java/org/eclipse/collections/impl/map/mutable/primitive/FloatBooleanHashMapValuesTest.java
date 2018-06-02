/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.collection.mutable.primitive.AbstractMutableBooleanCollectionTestCase;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedBooleanCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableBooleanCollection;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatBooleanHashMap#values()}.
 * This file was automatically generated from template file primitiveBooleanHashMapValuesTest.stg.
 */
public class FloatBooleanHashMapValuesTest extends AbstractMutableBooleanCollectionTestCase
{
    @Override
    protected MutableBooleanCollection classUnderTest()
    {
        return FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false, 3.0f, true).values();
    }

    @Override
    protected MutableBooleanCollection newWith(boolean... elements)
    {
        FloatBooleanHashMap map = new FloatBooleanHashMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(i, elements[i]);
        }
        return map.values();
    }

    @Override
    protected MutableBooleanCollection newMutableCollectionWith(boolean... elements)
    {
        return this.newWith(elements);
    }

    @Override
    protected MutableBag<Object> newObjectCollectionWith(Object... elements)
    {
        return HashBag.newBagWith(elements);
    }

    @Override
    @Test
    public void booleanIterator()
    {
        MutableBooleanCollection collection = this.newWith(true, false, false, true, true, true);
        BooleanArrayList list = BooleanArrayList.newListWith(true, false, false, true, true, true);
        BooleanIterator iterator = collection.booleanIterator();
        for (int i = 0; i < 6; i++)
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
        this.classUnderTest().addAll(new BooleanArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.classUnderTest().add(false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addAllArray()
    {
        this.classUnderTest().addAll(true, false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void with()
    {
        this.classUnderTest().with(true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void without()
    {
        this.classUnderTest().without(false);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withAll()
    {
        this.classUnderTest().withAll(new BooleanArrayList());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAll()
    {
        this.classUnderTest().withoutAll(new BooleanArrayList());
    }

    @Override
    @Test
    public void remove()
    {
        FloatBooleanHashMap map = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false, 3.0f, true);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.remove(false));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));
    }

    @Override
    @Test
    public void containsAllArray()
    {
        MutableBooleanCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.containsAll());
        Assert.assertFalse(emptyCollection.containsAll(true));
        Assert.assertFalse(emptyCollection.containsAll(false));

        MutableBooleanCollection classUnderTest = this.classUnderTest();
        Assert.assertTrue(classUnderTest.containsAll());
        Assert.assertTrue(classUnderTest.containsAll(true));
        Assert.assertTrue(classUnderTest.containsAll(false));
        Assert.assertTrue(classUnderTest.containsAll(false, true));
    }

    @Override
    @Test
    public void asSynchronized()
    {
        MutableBooleanCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(SynchronizedBooleanCollection.class, collection.asSynchronized());
        Assert.assertTrue(collection.asSynchronized().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        MutableBooleanCollection collection = this.classUnderTest();
        Verify.assertInstanceOf(UnmodifiableBooleanCollection.class, collection.asUnmodifiable());
        Assert.assertTrue(collection.asUnmodifiable().containsAll(this.classUnderTest()));
    }

    @Override
    @Test
    public void containsAllIterable()
    {
        MutableBooleanCollection emptyCollection = this.newWith();
        Assert.assertTrue(emptyCollection.containsAll(new BooleanArrayList()));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(emptyCollection.containsAll(BooleanArrayList.newListWith(false)));

        MutableBooleanCollection classUnderTest = this.classUnderTest();
        Assert.assertTrue(classUnderTest.containsAll(new BooleanArrayList()));
        Assert.assertTrue(classUnderTest.containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(classUnderTest.containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(classUnderTest.containsAll(BooleanArrayList.newListWith(false, true)));
    }

    @Override
    @Test
    public void removeAll()
    {
        Assert.assertFalse(this.newWith().removeAll());
        Assert.assertFalse(this.newWith().removeAll(true));

        FloatBooleanHashMap map = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.removeAll(false));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));

        Assert.assertTrue(collection.removeAll(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertFalse(map.contains(true));

        FloatBooleanHashMap map1 = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false);
        MutableBooleanCollection collection1 = map1.values();
        Assert.assertTrue(collection1.removeAll(false, true));
        Assert.assertFalse(collection1.contains(false));
        Assert.assertFalse(collection1.contains(true));
        Assert.assertFalse(map1.contains(false));
        Assert.assertFalse(map1.contains(true));
    }

    @Override
    @Test
    public void removeAll_iterable()
    {
        Assert.assertFalse(this.newWith().removeAll(new BooleanArrayList()));
        Assert.assertFalse(this.newWith().removeAll(BooleanArrayList.newListWith(true)));

        FloatBooleanHashMap map = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.removeAll(BooleanArrayList.newListWith(false)));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));

        Assert.assertTrue(collection.removeAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertFalse(map.contains(true));

        FloatBooleanHashMap map1 = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false);
        MutableBooleanCollection collection1 = map1.values();
        Assert.assertTrue(collection1.removeAll(BooleanArrayList.newListWith(false, true)));
        Assert.assertFalse(collection1.contains(false));
        Assert.assertFalse(collection1.contains(true));
        Assert.assertFalse(map1.contains(false));
        Assert.assertFalse(map1.contains(true));
    }

    @Override
    @Test
    public void retainAll()
    {
        Assert.assertFalse(this.newWith().retainAll());
        Assert.assertFalse(this.newWith().retainAll(true));

        FloatBooleanHashMap map = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.retainAll(true));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));

        Assert.assertTrue(collection.retainAll(false));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertFalse(map.contains(true));

        FloatBooleanHashMap map1 = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false);
        MutableBooleanCollection collection1 = map1.values();
        Assert.assertTrue(collection1.retainAll());
        Assert.assertFalse(collection1.contains(false));
        Assert.assertFalse(collection1.contains(true));
        Assert.assertFalse(map1.contains(false));
        Assert.assertFalse(map1.contains(true));

        FloatBooleanHashMap sentinelMap = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 0.0f, false);
        MutableBooleanCollection collection2 = sentinelMap.values();
        Assert.assertTrue(collection2.retainAll(false));
        Assert.assertTrue(collection2.contains(false));
        Assert.assertFalse(collection2.contains(true));
        Assert.assertTrue(sentinelMap.contains(false));
        Assert.assertFalse(sentinelMap.contains(true));
        Assert.assertTrue(collection2.retainAll(true));
        Assert.assertFalse(collection2.contains(false));
        Assert.assertFalse(collection2.contains(true));
        Assert.assertFalse(sentinelMap.contains(false));
        Assert.assertFalse(sentinelMap.contains(true));
    }

    @Override
    @Test
    public void retainAll_iterable()
    {
        Assert.assertFalse(this.newWith().retainAll(new BooleanArrayList()));
        Assert.assertFalse(this.newWith().retainAll(BooleanArrayList.newListWith(true)));

        FloatBooleanHashMap map = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false);
        MutableBooleanCollection collection = map.values();
        Assert.assertTrue(collection.retainAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(collection.contains(false));
        Assert.assertTrue(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertTrue(map.contains(true));

        Assert.assertTrue(collection.retainAll(BooleanArrayList.newListWith(false)));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(map.contains(false));
        Assert.assertFalse(map.contains(true));

        FloatBooleanHashMap map1 = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false);
        MutableBooleanCollection collection1 = map1.values();
        Assert.assertTrue(collection1.retainAll(new BooleanArrayList()));
        Assert.assertFalse(collection1.contains(false));
        Assert.assertFalse(collection1.contains(true));
        Assert.assertFalse(map1.contains(false));
        Assert.assertFalse(map1.contains(true));

        FloatBooleanHashMap sentinelMap = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 0.0f, false);
        MutableBooleanCollection collection2 = sentinelMap.values();
        Assert.assertTrue(collection2.retainAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(collection2.contains(false));
        Assert.assertFalse(collection2.contains(true));
        Assert.assertTrue(sentinelMap.contains(false));
        Assert.assertFalse(sentinelMap.contains(true));
        Assert.assertTrue(collection2.retainAll(BooleanArrayList.newListWith(true)));
        Assert.assertFalse(collection2.contains(false));
        Assert.assertFalse(collection2.contains(true));
        Assert.assertFalse(sentinelMap.contains(false));
        Assert.assertFalse(sentinelMap.contains(true));
    }

    @Override
    @Test
    public void clear()
    {
        MutableBooleanCollection emptyCollection = this.newWith();
        emptyCollection.clear();
        Verify.assertSize(0, emptyCollection);

        FloatBooleanHashMap map = FloatBooleanHashMap.newWithKeysValues(1.0f, true, 2.0f, false, 3.0f, true);
        MutableBooleanCollection collection = map.values();
        collection.clear();
        Verify.assertEmpty(collection);
        Verify.assertEmpty(map);
        Verify.assertSize(0, collection);
        Assert.assertFalse(collection.contains(true));
        Assert.assertFalse(collection.contains(false));
        Assert.assertFalse(map.contains(true));
        Assert.assertFalse(map.contains(false));
    }

    @Override
    @Test
    public void contains()
    {
        BooleanIterable emptyCollection = this.newWith();
        Assert.assertFalse(emptyCollection.contains(true));
        Assert.assertFalse(emptyCollection.contains(false));
        BooleanIterable booleanIterable = this.classUnderTest();
        int size = booleanIterable.size();
        Assert.assertTrue(booleanIterable.contains(true));
        Assert.assertTrue(booleanIterable.contains(false));
        Assert.assertFalse(this.newWith(true, true, true).contains(false));
        Assert.assertFalse(this.newWith(false, false, false).contains(true));
    }

    @Override
    @Test
    public void reject()
    {
        BooleanIterable iterable = this.classUnderTest();
        Verify.assertSize(1, iterable.reject(BooleanPredicates.isTrue()));
        Verify.assertSize(2, iterable.reject(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void select()
    {
        BooleanIterable iterable = this.classUnderTest();
        Verify.assertSize(1, iterable.select(BooleanPredicates.isFalse()));
        Verify.assertSize(2, iterable.select(BooleanPredicates.isTrue()));
    }

    @Override
    @Test
    public void collect()
    {
        BooleanToObjectFunction<Integer> function = (boolean parameter) -> parameter ? 1 : 0;
        Assert.assertEquals(this.newObjectCollectionWith(1, 0, 1).toBag(), this.newWith(true, false, true).collect(function).toBag());
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
    }

    @Override
    @Test
    public void appendString()
    {
        //does not call super.appendString() because of iterator.toString() test.

        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", "/", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith(true).appendString(appendable1);
        Assert.assertEquals("true", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();
        BooleanIterable iterable = this.newWith(true, false);
        iterable.appendString(appendable2);
        Assert.assertTrue("true, false".equals(appendable2.toString())
                || "false, true".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("true/false".equals(appendable3.toString())
                || "false/true".equals(appendable3.toString()));

        FloatBooleanHashMap map = new FloatBooleanHashMap();
        map.put(1.0f, true);
        map.put(2.0f, false);

        StringBuilder stringBuilder = new StringBuilder();
        map.values().appendString(stringBuilder, "[", ", ", "]");
        Assert.assertEquals("[true, false]", stringBuilder.toString());
    }

    @Override
    @Test
    public void chunk()
    {
        BooleanIterable iterable1 = this.newWith(true);
        Verify.assertIterablesEqual(
                Lists.mutable.with(BooleanBags.mutable.with(true)).toSet(),
                iterable1.chunk(1).toSet());

        BooleanIterable iterable2 = this.newWith(false);
        Verify.assertIterablesEqual(
                Lists.mutable.with(BooleanBags.mutable.with(false)).toSet(),
                iterable2.chunk(1).toSet());

        BooleanIterable iterable3 = this.newWith(false, true);
        Verify.assertIterablesEqual(
                Lists.mutable.with(BooleanBags.mutable.with(false), BooleanBags.mutable.with(true)).toSet(),
                iterable3.chunk(1).toSet());

        Verify.assertIterablesEqual(
                Lists.mutable.with(BooleanBags.mutable.with(false, true)),
                iterable3.chunk(2));
        Verify.assertIterablesEqual(
                Lists.mutable.with(BooleanBags.mutable.with(false, true)),
                iterable3.chunk(3));

        Verify.assertThrows(IllegalArgumentException.class, () -> this.classUnderTest().chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.classUnderTest().chunk(-1));
    }

    @Override
    @Test
    public void testEquals()
    {
        //Testing equals() is not applicable for MutableBooleanCollection.
    }

    @Override
    public void testToString()
    {
        //Testing toString() is not applicable for MutableBooleanCollection.
    }

    @Override
    public void testHashCode()
    {
        //Testing hashCode() is not applicable for MutableBooleanCollection.
    }

    @Override
    public void newCollection()
    {
        //Testing newCollection() is not applicable for MutableBooleanCollection.
    }
}
