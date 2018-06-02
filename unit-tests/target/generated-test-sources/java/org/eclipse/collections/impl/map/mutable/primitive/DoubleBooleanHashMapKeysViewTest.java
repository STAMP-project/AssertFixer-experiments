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

import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleBooleanHashMap#keysView}.
 * This file was automatically generated from template file primitiveBooleanHashMapKeysViewTest.stg.
 */
public class DoubleBooleanHashMapKeysViewTest
{
    private final LazyDoubleIterable iterable = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false, 31.0, true,
            generateCollisions1().getFirst(), false).withKeyValue(generateCollisions1().get(1), true).keysView();

    private static DoubleArrayList generateCollisions1()
    {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleBooleanHashMap hashMap = new DoubleBooleanHashMap();
        for (double i = 32.0; collisions.size() <= 10; i++)
        {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask(32.0))
            {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void size()
    {
        Verify.assertSize(0, new DoubleBooleanHashMap().keysView());
        Verify.assertSize(5, this.iterable);
    }

    @Test
    public void empty()
    {
        Assert.assertTrue(new DoubleBooleanHashMap().keysView().isEmpty());
        Assert.assertFalse(new DoubleBooleanHashMap().keysView().notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false).keysView().isEmpty());
        Assert.assertTrue(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false).keysView().notEmpty());
        Assert.assertFalse(DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, true).keysView().isEmpty());
        Assert.assertTrue(DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, true).keysView().notEmpty());
        Assert.assertFalse(DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, true).keysView().isEmpty());
        Assert.assertTrue(DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, true).keysView().notEmpty());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.iterable.contains(0.0));
        Assert.assertTrue(this.iterable.contains(1.0));
        Assert.assertFalse(this.iterable.contains(2.0));
        Assert.assertTrue(this.iterable.contains(31.0));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().getFirst()));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().get(1)));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.iterable.containsAll(0.0, 1.0));
        Assert.assertFalse(this.iterable.containsAll(1.0, 5.0));
        Assert.assertFalse(this.iterable.containsAll(2.0, 5.0));
        Assert.assertFalse(this.iterable.containsAll(31.0, 2.0));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.iterable.containsAll(DoubleHashSet.newSetWith(0.0, 1.0)));
        Assert.assertFalse(this.iterable.containsAll(DoubleHashSet.newSetWith(1.0, 5.0)));
        Assert.assertFalse(this.iterable.containsAll(DoubleHashSet.newSetWith(2.0, 5.0)));
        Assert.assertFalse(this.iterable.containsAll(DoubleHashSet.newSetWith(31.0, 2.0)));
    }

    @Test
    public void toArray()
    {
        Assert.assertTrue(Arrays.equals(new double[]{0.0, 1.0}, DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false).keysView().toArray())
                || Arrays.equals(new double[]{0.0, 1.0}, DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false).keysView().toArray()));
        Assert.assertArrayEquals(new double[]{}, new DoubleBooleanHashMap().keysView().toArray(), 0.0);
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new double[]{0.0, 1.0, 31.0, generateCollisions1().getFirst(), generateCollisions1().get(1)}, this.iterable.toSortedArray(), 0.0);
        Assert.assertArrayEquals(new double[]{}, new DoubleBooleanHashMap().keysView().toSortedArray(), 0.0);
    }

    @Test
    public void doubleIterator()
    {
        MutableDoubleSet expected = DoubleHashSet.newSetWith(0.0, 1.0, 31.0, generateCollisions1().getFirst(), generateCollisions1().get(1));
        MutableDoubleSet actual = DoubleHashSet.newSetWith();
        DoubleIterator iterator = this.iterable.doubleIterator();
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
        DoubleIterator iterator = this.iterable.doubleIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Test
    public void forEach()
    {
        double[] sum = new double[1];
        this.iterable.forEach(each -> sum[0] += each);
        Assert.assertEquals(32L + generateCollisions1().getFirst() + generateCollisions1().get(1), sum[0], 0.0);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(4L, this.iterable.count(DoublePredicates.greaterThan(0.0)));
        Assert.assertEquals(3L, this.iterable.count(DoublePredicates.lessThan(32.0)));
        Assert.assertEquals(1L, this.iterable.count(DoublePredicates.greaterThan(32.0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.iterable.anySatisfy(DoublePredicates.equal(0.0)));
        Assert.assertTrue(this.iterable.anySatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(this.iterable.anySatisfy(DoublePredicates.greaterThan(31.0)));
        Assert.assertFalse(this.iterable.anySatisfy(DoublePredicates.equal(2.0)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.iterable.allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.iterable.allSatisfy(DoublePredicates.lessThan(1.0)));
        Assert.assertFalse(this.iterable.allSatisfy(DoublePredicates.lessThan(generateCollisions1().getFirst())));
        Assert.assertTrue(this.iterable.allSatisfy(DoublePredicates.not(DoublePredicates.equal(2.0))));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.iterable.noneSatisfy(DoublePredicates.equal(0.0)));
        Assert.assertFalse(this.iterable.noneSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(this.iterable.noneSatisfy(DoublePredicates.greaterThan(31.0)));
        Assert.assertTrue(this.iterable.noneSatisfy(DoublePredicates.equal(2.0)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(3, this.iterable.select(DoublePredicates.lessThan(32.0)));
        Verify.assertSize(4, this.iterable.select(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.iterable.reject(DoublePredicates.greaterThan(0.0)));
        Verify.assertSize(2, this.iterable.reject(DoublePredicates.lessThan(32.0)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(0.0, this.iterable.detectIfNone(DoublePredicates.lessThan(1.0), 9.0), 0.0);
        Assert.assertEquals(1.0, this.iterable.detectIfNone(DoublePredicates.equal(1.0), 9.0), 0.0);
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.detectIfNone(DoublePredicates.greaterThan(generateCollisions1().getFirst()), 9.0), 0.0);
        Assert.assertEquals(9.0, this.iterable.detectIfNone(DoublePredicates.greaterThan(generateCollisions1().get(1)), 9.0), 0.0);
    }

    @Test
    public void collect()
    {
        Assert.assertEquals(
            UnifiedSet.newSetWith(-1.0, 0.0, 30.0, generateCollisions1().getFirst() - 1, generateCollisions1().get(1) - 1),
            this.iterable.collect((double parameter) -> parameter - 1).toSet());
    }

    @Test
    public void max()
    {
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList()
    {
        new DoubleBooleanHashMap().keysView().max();
    }

    @Test
    public void min()
    {
        Assert.assertEquals(0.0, this.iterable.min(), 0.0);
        Assert.assertEquals(31.0, DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, false).keysView().min(), 0.0);
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5.0, new DoubleBooleanHashMap().keysView().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleBooleanHashMap().keysView().minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, this.iterable.minIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5.0, new DoubleBooleanHashMap().keysView().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleBooleanHashMap().keysView().maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.maxIfEmpty(5.0), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList()
    {
        new DoubleBooleanHashMap().keysView().min();
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(94.0, DoubleBooleanHashMap.newWithKeysValues(30.0, true, 31.0, false, 32.0, true).withKeysValues(0.0, true, 1.0, false).keysView().sum(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void average_throws_emptyList()
    {
        new DoubleBooleanHashMap().keysView().average();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(31.0, DoubleBooleanHashMap.newWithKeysValues(30.0, true, 31.0, false, 32.0, true).keysView().average(), 0.0);
    }

    @Test
    public void median()
    {
        Assert.assertEquals(31.0, DoubleBooleanHashMap.newWithKeysValues(30.0, true, 31.0, false, 32.0, true).keysView().median(), 0.0);
        Assert.assertEquals(30.5, DoubleBooleanHashMap.newWithKeysValues(30.0, true, 31.0, false, 32.0, true).withKeyValue(1.0, true).keysView().median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void median_throws_emptyList()
    {
        new DoubleBooleanHashMap().keysView().median();
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[]", new DoubleBooleanHashMap().keysView().toString());
        Assert.assertEquals("[0.0]", DoubleBooleanHashMap.newWithKeysValues(0.0, true).keysView().toString());
        Assert.assertEquals("[1.0]", DoubleBooleanHashMap.newWithKeysValues(1.0, false).keysView().toString());
        Assert.assertEquals("[5.0]", DoubleBooleanHashMap.newWithKeysValues(5.0, false).keysView().toString());

        LazyDoubleIterable iterable1 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false).keysView();
        Assert.assertTrue(
                iterable1.toString(),
                iterable1.toString().equals("[0.0, 1.0]")
                        || iterable1.toString().equals("[1.0, 0.0]"));

        LazyDoubleIterable iterable2 = DoubleBooleanHashMap.newWithKeysValues(1.0, false, 32.0, true).keysView();
        Assert.assertTrue(
                iterable2.toString(),
                iterable2.toString().equals("[1.0, 32.0]")
                        || iterable2.toString().equals("[32.0, 1.0]"));

        LazyDoubleIterable iterable3 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 32.0, true).keysView();
        Assert.assertTrue(
                iterable3.toString(),
                iterable3.toString().equals("[0.0, 32.0]")
                        || iterable3.toString().equals("[32.0, 0.0]"));

        LazyDoubleIterable iterable4 = DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, false).keysView();
        Assert.assertTrue(
                iterable4.toString(),
                iterable4.toString().equals("[32.0, 33.0]")
                        || iterable4.toString().equals("[33.0, 32.0]"));
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", new DoubleBooleanHashMap().keysView().makeString());
        Assert.assertEquals("31.0", new DoubleBooleanHashMap().withKeyValue(31.0, true).keysView().makeString());
        Assert.assertEquals("32.0", new DoubleBooleanHashMap().withKeyValue(32.0, false).keysView().makeString());

        LazyDoubleIterable iterable0 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false).keysView();
        Assert.assertTrue(
                iterable0.makeString(),
                "0.0, 1.0".equals(iterable0.makeString())
                        || "1.0, 0.0".equals(iterable0.makeString()));

        LazyDoubleIterable iterable1 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false).keysView();
        Assert.assertTrue(
                iterable1.makeString(),
                "0.0, 31.0".equals(iterable1.makeString())
                        || "31.0, 0.0".equals(iterable1.makeString()));

        LazyDoubleIterable iterable2 = DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, true).keysView();
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                "[31.0/32.0]".equals(iterable2.makeString("[", "/", "]"))
                        || "[32.0/31.0]".equals(iterable2.makeString("[", "/", "]")));

        LazyDoubleIterable iterable3 = DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, true).keysView();
        Assert.assertTrue(
                iterable3.makeString("/"),
                "32.0/33.0".equals(iterable3.makeString("/"))
                        || "33.0/32.0".equals(iterable3.makeString("/")));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        new DoubleBooleanHashMap().keysView().appendString(appendable);
        Assert.assertEquals("", appendable.toString());

        StringBuilder appendable0 = new StringBuilder();
        new DoubleBooleanHashMap().withKeyValue(31.0, true).keysView().appendString(appendable0);
        Assert.assertEquals("31.0", appendable0.toString());

        StringBuilder appendable1 = new StringBuilder();
        new DoubleBooleanHashMap().withKeyValue(32.0, true).keysView().appendString(appendable1);
        Assert.assertEquals("32.0", appendable1.toString());

        StringBuilder appendable2 = new StringBuilder();
        LazyDoubleIterable set1 = DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false).keysView();
        set1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "0.0, 31.0".equals(appendable2.toString())
                || "31.0, 0.0".equals(appendable2.toString()));

        StringBuilder appendable3 = new StringBuilder();
        LazyDoubleIterable set2 = DoubleBooleanHashMap.newWithKeysValues(31.0, true, 32.0, true).keysView();
        set2.appendString(appendable3, "/");
        Assert.assertTrue(appendable3.toString(), "31.0/32.0".equals(appendable3.toString())
                || "32.0/31.0".equals(appendable3.toString()));

        StringBuilder appendable4 = new StringBuilder();
        LazyDoubleIterable set4 = DoubleBooleanHashMap.newWithKeysValues(32.0, true, 33.0, true).keysView();
        set4.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[32.0/33.0]".equals(appendable4.toString())
                || "[33.0/32.0]".equals(appendable4.toString()));
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), DoubleBooleanHashMap.newWithKeysValues(0.0, true).keysView().toList());
        Assert.assertEquals(DoubleArrayList.newListWith(31.0), DoubleBooleanHashMap.newWithKeysValues(31.0, true).keysView().toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0, 1.0, 31.0), DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false, 31.0, true).keysView().toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(DoubleHashSet.newSetWith(0.0, 1.0, 31.0), DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false, 31.0, true).keysView().toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0, 1.0, 31.0), DoubleBooleanHashMap.newWithKeysValues(0.0, true, 1.0, false, 31.0, true).keysView().toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, this.iterable.asLazy());
    }
}
