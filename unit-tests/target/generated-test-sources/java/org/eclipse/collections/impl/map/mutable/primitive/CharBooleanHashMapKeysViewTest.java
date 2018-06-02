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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharBooleanHashMap#keysView}.
 * This file was automatically generated from template file primitiveBooleanHashMapKeysViewTest.stg.
 */
public class CharBooleanHashMapKeysViewTest
{
    private final LazyCharIterable iterable = CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false, (char) 31, true,
            generateCollisions1().getFirst(), false).withKeyValue(generateCollisions1().get(1), true).keysView();

    private static CharArrayList generateCollisions1()
    {
        CharArrayList collisions = new CharArrayList();
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char i = (char) 32; collisions.size() <= 10; i++)
        {
            if (hashMap.spreadAndMask(i) == hashMap.spreadAndMask((char) 32))
            {
                collisions.add(i);
            }
        }
        return collisions;
    }

    @Test
    public void size()
    {
        Verify.assertSize(0, new CharBooleanHashMap().keysView());
        Verify.assertSize(5, this.iterable);
    }

    @Test
    public void empty()
    {
        Assert.assertTrue(new CharBooleanHashMap().keysView().isEmpty());
        Assert.assertFalse(new CharBooleanHashMap().keysView().notEmpty());
        Assert.assertFalse(this.iterable.isEmpty());
        Assert.assertTrue(this.iterable.notEmpty());
        Assert.assertFalse(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false).keysView().isEmpty());
        Assert.assertTrue(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false).keysView().notEmpty());
        Assert.assertFalse(CharBooleanHashMap.newWithKeysValues((char) 31, true, (char) 32, true).keysView().isEmpty());
        Assert.assertTrue(CharBooleanHashMap.newWithKeysValues((char) 31, true, (char) 32, true).keysView().notEmpty());
        Assert.assertFalse(CharBooleanHashMap.newWithKeysValues((char) 32, true, (char) 33, true).keysView().isEmpty());
        Assert.assertTrue(CharBooleanHashMap.newWithKeysValues((char) 32, true, (char) 33, true).keysView().notEmpty());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.iterable.contains((char) 0));
        Assert.assertTrue(this.iterable.contains((char) 1));
        Assert.assertFalse(this.iterable.contains((char) 2));
        Assert.assertTrue(this.iterable.contains((char) 31));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().getFirst()));
        Assert.assertTrue(this.iterable.contains(generateCollisions1().get(1)));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.iterable.containsAll((char) 0, (char) 1));
        Assert.assertFalse(this.iterable.containsAll((char) 1, (char) 5));
        Assert.assertFalse(this.iterable.containsAll((char) 2, (char) 5));
        Assert.assertFalse(this.iterable.containsAll((char) 31, (char) 2));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.iterable.containsAll(CharHashSet.newSetWith((char) 0, (char) 1)));
        Assert.assertFalse(this.iterable.containsAll(CharHashSet.newSetWith((char) 1, (char) 5)));
        Assert.assertFalse(this.iterable.containsAll(CharHashSet.newSetWith((char) 2, (char) 5)));
        Assert.assertFalse(this.iterable.containsAll(CharHashSet.newSetWith((char) 31, (char) 2)));
    }

    @Test
    public void toArray()
    {
        Assert.assertTrue(Arrays.equals(new char[]{(char) 0, (char) 1}, CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false).keysView().toArray())
                || Arrays.equals(new char[]{(char) 0, (char) 1}, CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false).keysView().toArray()));
        Assert.assertArrayEquals(new char[]{}, new CharBooleanHashMap().keysView().toArray());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new char[]{(char) 0, (char) 1, (char) 31, generateCollisions1().getFirst(), generateCollisions1().get(1)}, this.iterable.toSortedArray());
        Assert.assertArrayEquals(new char[]{}, new CharBooleanHashMap().keysView().toSortedArray());
    }

    @Test
    public void charIterator()
    {
        MutableCharSet expected = CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, generateCollisions1().getFirst(), generateCollisions1().get(1));
        MutableCharSet actual = CharHashSet.newSetWith();
        CharIterator iterator = this.iterable.charIterator();
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
        CharIterator iterator = this.iterable.charIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Test
    public void forEach()
    {
        char[] sum = new char[1];
        this.iterable.forEach(each -> sum[0] += each);
        Assert.assertEquals(32L + generateCollisions1().getFirst() + generateCollisions1().get(1), sum[0]);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(4L, this.iterable.count(CharPredicates.greaterThan((char) 0)));
        Assert.assertEquals(3L, this.iterable.count(CharPredicates.lessThan((char) 32)));
        Assert.assertEquals(1L, this.iterable.count(CharPredicates.greaterThan((char) 32)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.iterable.anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.iterable.anySatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertTrue(this.iterable.anySatisfy(CharPredicates.greaterThan((char) 31)));
        Assert.assertFalse(this.iterable.anySatisfy(CharPredicates.equal((char) 2)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.iterable.allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.iterable.allSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertFalse(this.iterable.allSatisfy(CharPredicates.lessThan(generateCollisions1().getFirst())));
        Assert.assertTrue(this.iterable.allSatisfy(CharPredicates.not(CharPredicates.equal((char) 2))));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.iterable.noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(CharPredicates.greaterThan((char) 31)));
        Assert.assertTrue(this.iterable.noneSatisfy(CharPredicates.equal((char) 2)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(3, this.iterable.select(CharPredicates.lessThan((char) 32)));
        Verify.assertSize(4, this.iterable.select(CharPredicates.greaterThan((char) 0)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.iterable.reject(CharPredicates.greaterThan((char) 0)));
        Verify.assertSize(2, this.iterable.reject(CharPredicates.lessThan((char) 32)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals((char) 0, this.iterable.detectIfNone(CharPredicates.lessThan((char) 1), (char) 9));
        Assert.assertEquals((char) 1, this.iterable.detectIfNone(CharPredicates.equal((char) 1), (char) 9));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.detectIfNone(CharPredicates.greaterThan(generateCollisions1().getFirst()), (char) 9));
        Assert.assertEquals((char) 9, this.iterable.detectIfNone(CharPredicates.greaterThan(generateCollisions1().get(1)), (char) 9));
    }

    @Test
    public void collect()
    {
        Assert.assertEquals(
            UnifiedSet.newSetWith((char) -1, (char) 0, (char) 30, (char) (generateCollisions1().getFirst() - 1), (char) (generateCollisions1().get(1) - 1)),
            this.iterable.collect((char parameter) -> (char) (parameter - 1)).toSet());
    }

    @Test
    public void max()
    {
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList()
    {
        new CharBooleanHashMap().keysView().max();
    }

    @Test
    public void min()
    {
        Assert.assertEquals((char) 0, this.iterable.min());
        Assert.assertEquals((char) 31, CharBooleanHashMap.newWithKeysValues((char) 31, true, (char) 32, false).keysView().min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((char) 5, new CharBooleanHashMap().keysView().minIfEmpty((char) 5));
        Assert.assertEquals((char) 0, new CharBooleanHashMap().keysView().minIfEmpty((char) 0));
        Assert.assertEquals((char) 0, this.iterable.minIfEmpty((char) 5));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((char) 5, new CharBooleanHashMap().keysView().maxIfEmpty((char) 5));
        Assert.assertEquals((char) 0, new CharBooleanHashMap().keysView().maxIfEmpty((char) 0));
        Assert.assertEquals(generateCollisions1().get(1), this.iterable.maxIfEmpty((char) 5));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList()
    {
        new CharBooleanHashMap().keysView().min();
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(94L, CharBooleanHashMap.newWithKeysValues((char) 30, true, (char) 31, false, (char) 32, true).withKeysValues((char) 0, true, (char) 1, false).keysView().sum());
    }

    @Test(expected = ArithmeticException.class)
    public void average_throws_emptyList()
    {
        new CharBooleanHashMap().keysView().average();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(31.0, CharBooleanHashMap.newWithKeysValues((char) 30, true, (char) 31, false, (char) 32, true).keysView().average(), 0.0);
    }

    @Test
    public void median()
    {
        Assert.assertEquals(31.0, CharBooleanHashMap.newWithKeysValues((char) 30, true, (char) 31, false, (char) 32, true).keysView().median(), 0.0);
        Assert.assertEquals(30.5, CharBooleanHashMap.newWithKeysValues((char) 30, true, (char) 31, false, (char) 32, true).withKeyValue((char) 1, true).keysView().median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void median_throws_emptyList()
    {
        new CharBooleanHashMap().keysView().median();
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[]", new CharBooleanHashMap().keysView().toString());
        Assert.assertEquals("[\u0000]", CharBooleanHashMap.newWithKeysValues((char) 0, true).keysView().toString());
        Assert.assertEquals("[\u0001]", CharBooleanHashMap.newWithKeysValues((char) 1, false).keysView().toString());
        Assert.assertEquals("[\u0005]", CharBooleanHashMap.newWithKeysValues((char) 5, false).keysView().toString());

        LazyCharIterable iterable1 = CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false).keysView();
        Assert.assertTrue(
                iterable1.toString(),
                iterable1.toString().equals("[\u0000, \u0001]")
                        || iterable1.toString().equals("[\u0001, \u0000]"));

        LazyCharIterable iterable2 = CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 32, true).keysView();
        Assert.assertTrue(
                iterable2.toString(),
                iterable2.toString().equals("[\u0001, \u0020]")
                        || iterable2.toString().equals("[\u0020, \u0001]"));

        LazyCharIterable iterable3 = CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 32, true).keysView();
        Assert.assertTrue(
                iterable3.toString(),
                iterable3.toString().equals("[\u0000, \u0020]")
                        || iterable3.toString().equals("[\u0020, \u0000]"));

        LazyCharIterable iterable4 = CharBooleanHashMap.newWithKeysValues((char) 32, true, (char) 33, false).keysView();
        Assert.assertTrue(
                iterable4.toString(),
                iterable4.toString().equals("[\u0020, \u0021]")
                        || iterable4.toString().equals("[\u0021, \u0020]"));
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", new CharBooleanHashMap().keysView().makeString());
        Assert.assertEquals("\u001f", new CharBooleanHashMap().withKeyValue((char) 31, true).keysView().makeString());
        Assert.assertEquals("\u0020", new CharBooleanHashMap().withKeyValue((char) 32, false).keysView().makeString());

        LazyCharIterable iterable0 = CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false).keysView();
        Assert.assertTrue(
                iterable0.makeString(),
                "\u0000, \u0001".equals(iterable0.makeString())
                        || "\u0001, \u0000".equals(iterable0.makeString()));

        LazyCharIterable iterable1 = CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false).keysView();
        Assert.assertTrue(
                iterable1.makeString(),
                "\u0000, \u001f".equals(iterable1.makeString())
                        || "\u001f, \u0000".equals(iterable1.makeString()));

        LazyCharIterable iterable2 = CharBooleanHashMap.newWithKeysValues((char) 31, true, (char) 32, true).keysView();
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                "[\u001f/\u0020]".equals(iterable2.makeString("[", "/", "]"))
                        || "[\u0020/\u001f]".equals(iterable2.makeString("[", "/", "]")));

        LazyCharIterable iterable3 = CharBooleanHashMap.newWithKeysValues((char) 32, true, (char) 33, true).keysView();
        Assert.assertTrue(
                iterable3.makeString("/"),
                "\u0020/\u0021".equals(iterable3.makeString("/"))
                        || "\u0021/\u0020".equals(iterable3.makeString("/")));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        new CharBooleanHashMap().keysView().appendString(appendable);
        Assert.assertEquals("", appendable.toString());

        StringBuilder appendable0 = new StringBuilder();
        new CharBooleanHashMap().withKeyValue((char) 31, true).keysView().appendString(appendable0);
        Assert.assertEquals("\u001f", appendable0.toString());

        StringBuilder appendable1 = new StringBuilder();
        new CharBooleanHashMap().withKeyValue((char) 32, true).keysView().appendString(appendable1);
        Assert.assertEquals("\u0020", appendable1.toString());

        StringBuilder appendable2 = new StringBuilder();
        LazyCharIterable set1 = CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false).keysView();
        set1.appendString(appendable2);
        Assert.assertTrue(appendable2.toString(), "\u0000, \u001f".equals(appendable2.toString())
                || "\u001f, \u0000".equals(appendable2.toString()));

        StringBuilder appendable3 = new StringBuilder();
        LazyCharIterable set2 = CharBooleanHashMap.newWithKeysValues((char) 31, true, (char) 32, true).keysView();
        set2.appendString(appendable3, "/");
        Assert.assertTrue(appendable3.toString(), "\u001f/\u0020".equals(appendable3.toString())
                || "\u0020/\u001f".equals(appendable3.toString()));

        StringBuilder appendable4 = new StringBuilder();
        LazyCharIterable set4 = CharBooleanHashMap.newWithKeysValues((char) 32, true, (char) 33, true).keysView();
        set4.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(appendable4.toString(), "[\u0020/\u0021]".equals(appendable4.toString())
                || "[\u0021/\u0020]".equals(appendable4.toString()));
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 0), CharBooleanHashMap.newWithKeysValues((char) 0, true).keysView().toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 31), CharBooleanHashMap.newWithKeysValues((char) 31, true).keysView().toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 1, (char) 31), CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false, (char) 31, true).keysView().toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31), CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false, (char) 31, true).keysView().toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 31), CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 1, false, (char) 31, true).keysView().toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, this.iterable.asLazy());
    }
}
