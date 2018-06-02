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

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortBooleanHashMap#keysView}.
 * This file was automatically generated from template file primitiveBooleanHashMapKeysViewTest.stg.
 */
public class ShortBooleanHashMapKeysViewTest
{
    private final LazyShortIterable iterable = ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false, (short) 31, true,
            generateCollisions1().getFirst(), false).withKeyValue(generateCollisions1().get(1), true).keysView();

    private static ShortArrayList generateCollisions1()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short i = (short) 32; collisions.size() <= 10; i++)
        {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask((short) 32))
            {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void size()
    {
        Verify.assertSize(0, new ShortBooleanHashMap().keysView());
        Verify.assertSize(5, this.iterable);
    }

    @Test
    public void empty()
    {
        Assert.assertTrue(new ShortBooleanHashMap().keysView().isEmpty());
        Assert.assertFalse(new ShortBooleanHashMap().keysView().notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false).keysView().isEmpty());
        Assert.assertTrue(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false).keysView().notEmpty());
        Assert.assertFalse(ShortBooleanHashMap.newWithKeysValues((short) 31, true, (short) 32, true).keysView().isEmpty());
        Assert.assertTrue(ShortBooleanHashMap.newWithKeysValues((short) 31, true, (short) 32, true).keysView().notEmpty());
        Assert.assertFalse(ShortBooleanHashMap.newWithKeysValues((short) 32, true, (short) 33, true).keysView().isEmpty());
        Assert.assertTrue(ShortBooleanHashMap.newWithKeysValues((short) 32, true, (short) 33, true).keysView().notEmpty());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.iterable.contains((short) 0));
        Assert.assertTrue(this.iterable.contains((short) 1));
        Assert.assertFalse(this.iterable.contains((short) 2));
        Assert.assertTrue(this.iterable.contains((short) 31));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().getFirst()));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().get(1)));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.iterable.containsAll((short) 0, (short) 1));
        Assert.assertFalse(this.iterable.containsAll((short) 1, (short) 5));
        Assert.assertFalse(this.iterable.containsAll((short) 2, (short) 5));
        Assert.assertFalse(this.iterable.containsAll((short) 31, (short) 2));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.iterable.containsAll(ShortHashSet.newSetWith((short) 0, (short) 1)));
        Assert.assertFalse(this.iterable.containsAll(ShortHashSet.newSetWith((short) 1, (short) 5)));
        Assert.assertFalse(this.iterable.containsAll(ShortHashSet.newSetWith((short) 2, (short) 5)));
        Assert.assertFalse(this.iterable.containsAll(ShortHashSet.newSetWith((short) 31, (short) 2)));
    }

    @Test
    public void toArray()
    {
        Assert.assertTrue(Arrays.equals(new short[]{(short) 0, (short) 1}, ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false).keysView().toArray())
                || Arrays.equals(new short[]{(short) 0, (short) 1}, ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false).keysView().toArray()));
        Assert.assertArrayEquals(new short[]{}, new ShortBooleanHashMap().keysView().toArray());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new short[]{(short) 0, (short) 1, (short) 31, generateCollisions1().getFirst(), generateCollisions1().get(1)}, this.iterable.toSortedArray());
        Assert.assertArrayEquals(new short[]{}, new ShortBooleanHashMap().keysView().toSortedArray());
    }

    @Test
    public void shortIterator()
    {
        MutableShortSet expected = ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31, generateCollisions1().getFirst(), generateCollisions1().get(1));
        MutableShortSet actual = ShortHashSet.newSetWith();
        ShortIterator iterator = this.iterable.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws()
    {
        ShortIterator iterator = this.iterable.shortIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Test
    public void forEach()
    {
        short[] sum = new short[1];
        this.iterable.forEach(each -> sum[0] += each);
        Assert.assertEquals(32L + generateCollisions1().getFirst() + generateCollisions1().get(1), sum[0]);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(4L, this.iterable.count(ShortPredicates.greaterThan((short) 0)));
        Assert.assertEquals(3L, this.iterable.count(ShortPredicates.lessThan((short) 32)));
        Assert.assertEquals(1L, this.iterable.count(ShortPredicates.greaterThan((short) 32)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.iterable.anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.iterable.anySatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertTrue(this.iterable.anySatisfy(ShortPredicates.greaterThan((short) 31)));
        Assert.assertFalse(this.iterable.anySatisfy(ShortPredicates.equal((short) 2)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.iterable.allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.iterable.allSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertFalse(this.iterable.allSatisfy(ShortPredicates.lessThan(generateCollisions1().getFirst())));
        Assert.assertTrue(this.iterable.allSatisfy(ShortPredicates.not(ShortPredicates.equal((short) 2))));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.iterable.noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(ShortPredicates.greaterThan((short) 31)));
        Assert.assertTrue(this.iterable.noneSatisfy(ShortPredicates.equal((short) 2)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(3, this.iterable.select(ShortPredicates.lessThan((short) 32)));
        Verify.assertSize(4, this.iterable.select(ShortPredicates.greaterThan((short) 0)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.iterable.reject(ShortPredicates.greaterThan((short) 0)));
        Verify.assertSize(2, this.iterable.reject(ShortPredicates.lessThan((short) 32)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals((short) 0, this.iterable.detectIfNone(ShortPredicates.lessThan((short) 1), (short) 9));
        Assert.assertEquals((short) 1, this.iterable.detectIfNone(ShortPredicates.equal((short) 1), (short) 9));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.detectIfNone(ShortPredicates.greaterThan(generateCollisions1().getFirst()), (short) 9));
        Assert.assertEquals((short) 9, this.iterable.detectIfNone(ShortPredicates.greaterThan(generateCollisions1().get(1)), (short) 9));
    }

    @Test
    public void collect()
    {
        Assert.assertEquals(
            UnifiedSet.newSetWith((short) -1, (short) 0, (short) 30, (short) (generateCollisions1().getFirst() - 1), (short) (generateCollisions1().get(1) - 1)),
            this.iterable.collect((short parameter) -> (short) (parameter - 1)).toSet());
    }

    @Test
    public void max()
    {
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList()
    {
        new ShortBooleanHashMap().keysView().max();
    }

    @Test
    public void min()
    {
        Assert.assertEquals((short) 0, this.iterable.min());
        Assert.assertEquals((short) 31, ShortBooleanHashMap.newWithKeysValues((short) 31, true, (short) 32, false).keysView().min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((short) 5, new ShortBooleanHashMap().keysView().minIfEmpty((short) 5));
        Assert.assertEquals((short) 0, new ShortBooleanHashMap().keysView().minIfEmpty((short) 0));
        Assert.assertEquals((short) 0, this.iterable.minIfEmpty((short) 5));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((short) 5, new ShortBooleanHashMap().keysView().maxIfEmpty((short) 5));
        Assert.assertEquals((short) 0, new ShortBooleanHashMap().keysView().maxIfEmpty((short) 0));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.maxIfEmpty((short) 5));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList()
    {
        new ShortBooleanHashMap().keysView().min();
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(94L, ShortBooleanHashMap.newWithKeysValues((short) 30, true, (short) 31, false, (short) 32, true).withKeysValues((short) 0, true, (short) 1, false).keysView().sum());
    }

    @Test(expected = ArithmeticException.class)
    public void average_throws_emptyList()
    {
        new ShortBooleanHashMap().keysView().average();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(31.0, ShortBooleanHashMap.newWithKeysValues((short) 30, true, (short) 31, false, (short) 32, true).keysView().average(), 0.0);
    }

    @Test
    public void median()
    {
        Assert.assertEquals(31.0, ShortBooleanHashMap.newWithKeysValues((short) 30, true, (short) 31, false, (short) 32, true).keysView().median(), 0.0);
        Assert.assertEquals(30.5, ShortBooleanHashMap.newWithKeysValues((short) 30, true, (short) 31, false, (short) 32, true).withKeyValue((short) 1, true).keysView().median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void median_throws_emptyList()
    {
        new ShortBooleanHashMap().keysView().median();
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[]", new ShortBooleanHashMap().keysView().toString());
        Assert.assertEquals("[0]", ShortBooleanHashMap.newWithKeysValues((short) 0, true).keysView().toString());
        Assert.assertEquals("[1]", ShortBooleanHashMap.newWithKeysValues((short) 1, false).keysView().toString());
        Assert.assertEquals("[5]", ShortBooleanHashMap.newWithKeysValues((short) 5, false).keysView().toString());

        LazyShortIterable iterable1 = ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false).keysView();
        Assert.assertTrue(
                iterable1.toString(),
                iterable1.toString().equals("[0, 1]")
                        || iterable1.toString().equals("[1, 0]"));

        LazyShortIterable iterable2 = ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 32, true).keysView();
        Assert.assertTrue(
                iterable2.toString(),
                iterable2.toString().equals("[1, 32]")
                        || iterable2.toString().equals("[32, 1]"));

        LazyShortIterable iterable3 = ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 32, true).keysView();
        Assert.assertTrue(
                iterable3.toString(),
                iterable3.toString().equals("[0, 32]")
                        || iterable3.toString().equals("[32, 0]"));

        LazyShortIterable iterable4 = ShortBooleanHashMap.newWithKeysValues((short) 32, true, (short) 33, false).keysView();
        Assert.assertTrue(
                iterable4.toString(),
                iterable4.toString().equals("[32, 33]")
                        || iterable4.toString().equals("[33, 32]"));
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", new ShortBooleanHashMap().keysView().makeString());
        Assert.assertEquals("31", new ShortBooleanHashMap().withKeyValue((short) 31, true).keysView().makeString());
        Assert.assertEquals("32", new ShortBooleanHashMap().withKeyValue((short) 32, false).keysView().makeString());

        LazyShortIterable iterable0 = ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false).keysView();
        Assert.assertTrue(
                iterable0.makeString(),
                "0, 1".equals(iterable0.makeString())
                        || "1, 0".equals(iterable0.makeString()));

        LazyShortIterable iterable1 = ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false).keysView();
        Assert.assertTrue(
                iterable1.makeString(),
                "0, 31".equals(iterable1.makeString())
                        || "31, 0".equals(iterable1.makeString()));

        LazyShortIterable iterable2 = ShortBooleanHashMap.newWithKeysValues((short) 31, true, (short) 32, true).keysView();
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                "[31/32]".equals(iterable2.makeString("[", "/", "]"))
                        || "[32/31]".equals(iterable2.makeString("[", "/", "]")));

        LazyShortIterable iterable3 = ShortBooleanHashMap.newWithKeysValues((short) 32, true, (short) 33, true).keysView();
        Assert.assertTrue(
                iterable3.makeString("/"),
                "32/33".equals(iterable3.makeString("/"))
                        || "33/32".equals(iterable3.makeString("/")));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        new ShortBooleanHashMap().keysView().appendString(appendable);
        Assert.assertEquals("", appendable.toString());

        StringBuilder appendable0 = new StringBuilder();
        new ShortBooleanHashMap().withKeyValue((short) 31, true).keysView().appendString(appendable0);
        Assert.assertEquals("31", appendable0.toString());

        StringBuilder appendable1 = new StringBuilder();
        new ShortBooleanHashMap().withKeyValue((short) 32, true).keysView().appendString(appendable1);
        Assert.assertEquals("32", appendable1.toString());

        StringBuilder appendable2 = new StringBuilder();
        LazyShortIterable set1 = ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false).keysView();
        set1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "0, 31".equals(appendable2.toString())
                || "31, 0".equals(appendable2.toString()));

        StringBuilder appendable3 = new StringBuilder();
        LazyShortIterable set2 = ShortBooleanHashMap.newWithKeysValues((short) 31, true, (short) 32, true).keysView();
        set2.appendString(appendable3, "/");
        Assert.assertTrue(appendable3.toString(), "31/32".equals(appendable3.toString())
                || "32/31".equals(appendable3.toString()));

        StringBuilder appendable4 = new StringBuilder();
        LazyShortIterable set4 = ShortBooleanHashMap.newWithKeysValues((short) 32, true, (short) 33, true).keysView();
        set4.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[32/33]".equals(appendable4.toString())
                || "[33/32]".equals(appendable4.toString()));
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), ShortBooleanHashMap.newWithKeysValues((short) 0, true).keysView().toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 31), ShortBooleanHashMap.newWithKeysValues((short) 31, true).keysView().toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 1, (short) 31), ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false, (short) 31, true).keysView().toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 31), ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false, (short) 31, true).keysView().toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 31), ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 1, false, (short) 31, true).keysView().toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, this.iterable.asLazy());
    }
}
