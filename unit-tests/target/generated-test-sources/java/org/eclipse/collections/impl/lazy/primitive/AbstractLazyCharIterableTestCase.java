/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.lazy.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link LazyCharIterable}.
 * This file was automatically generated from template file abstractLazyPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractLazyCharIterableTestCase
{
    protected abstract LazyCharIterable classUnderTest();

    protected abstract LazyCharIterable getEmptyIterable();

    protected abstract LazyCharIterable newWith(char element1, char element2);

    @Test
    public void charIterator()
    {
        long sum = 0L;
        for (CharIterator iterator = this.classUnderTest().charIterator(); iterator.hasNext(); )
        {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws()
    {
        CharIterator iterator = this.classUnderTest().charIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEach(each -> sum[0] += each);
        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void size()
    {
        Verify.assertSize(3, this.classUnderTest());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.getEmptyIterable());
        Verify.assertNotEmpty(this.classUnderTest());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyIterable().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
    }

    @Test
    public void count()
    {
        Assert.assertEquals(1L, this.classUnderTest().count(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(0L, this.classUnderTest().count(CharPredicates.lessThan((char) 0)));
        Assert.assertEquals(2L, this.newWith((char) 0, (char) 1).count(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(2L, this.newWith((char) 32, (char) 33).count(CharPredicates.lessThan((char) 34)));
        Assert.assertEquals(0L, this.newWith((char) 32, (char) 33).count(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.classUnderTest().anySatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(this.classUnderTest().anySatisfy(CharPredicates.greaterThan((char) 4)));
        Assert.assertTrue(this.newWith((char) 0, (char) 1).anySatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(this.newWith((char) 0, (char) 1).anySatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 32, (char) 33).anySatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertTrue(this.newWith((char) 32, (char) 33).anySatisfy(CharPredicates.lessThan((char) 33)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(this.classUnderTest().allSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertTrue(this.classUnderTest().allSatisfy(CharPredicates.lessThan((char) 4)));
        Assert.assertTrue(this.newWith((char) 0, (char) 1).allSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(this.newWith((char) 0, (char) 1).allSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertFalse(this.newWith((char) 0, (char) 1).allSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 32, (char) 33).allSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertFalse(this.newWith((char) 32, (char) 33).allSatisfy(CharPredicates.lessThan((char) 33)));
        Assert.assertTrue(this.newWith((char) 32, (char) 33).allSatisfy(CharPredicates.lessThan((char) 34)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(this.classUnderTest().noneSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(CharPredicates.greaterThan((char) 4)));
        Assert.assertFalse(this.newWith((char) 0, (char) 1).noneSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertTrue(this.newWith((char) 0, (char) 1).noneSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertTrue(this.newWith((char) 32, (char) 33).noneSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 32, (char) 33).noneSatisfy(CharPredicates.lessThan((char) 33)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(2, this.classUnderTest().select(CharPredicates.greaterThan((char) 1)));
        Verify.assertEmpty(this.classUnderTest().select(CharPredicates.lessThan((char) 0)));
        Verify.assertSize(2, this.newWith((char) 0, (char) 1).select(CharPredicates.lessThan((char) 2)));
        Verify.assertEmpty(this.newWith((char) 32, (char) 33).select(CharPredicates.lessThan((char) 2)));
        Verify.assertSize(2, this.newWith((char) 32, (char) 33).select(CharPredicates.lessThan((char) 34)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.classUnderTest().reject(CharPredicates.greaterThan((char) 1)));
        Verify.assertEmpty(this.classUnderTest().reject(CharPredicates.greaterThan((char) 0)));
        Verify.assertEmpty(this.newWith((char) 0, (char) 1).reject(CharPredicates.lessThan((char) 2)));
        Verify.assertEmpty(this.newWith((char) 32, (char) 33).reject(CharPredicates.lessThan((char) 34)));
        Verify.assertSize(2, this.newWith((char) 32, (char) 33).reject(CharPredicates.lessThan((char) 2)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1L, this.classUnderTest().detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals(0L, this.classUnderTest().detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));
        Assert.assertEquals(0L, this.newWith((char) 0, (char) 1).detectIfNone(CharPredicates.lessThan((char) 2), (char) 1));
        Assert.assertEquals(33L, this.newWith((char) 32, (char) 33).detectIfNone(CharPredicates.equal((char) 33), (char) 1));
        Assert.assertEquals(32L, this.newWith((char) 0, (char) 1).detectIfNone(CharPredicates.equal((char) 33), (char) 32));
        Assert.assertEquals(32L, this.newWith((char) 34, (char) 35).detectIfNone(CharPredicates.equal((char) 33), (char) 32));
    }

    @Test
    public void collect()
    {
        Verify.assertIterableSize(3, this.classUnderTest().collect(String::valueOf));
    }

    @Test
    public void tap()
    {
        StringBuilder tapStringBuilder = new StringBuilder();
        StringBuilder eachStringBuilder = new StringBuilder();
        LazyCharIterable lazy = this.classUnderTest().tap(tapStringBuilder::append);
        Assert.assertEquals(lazy.makeString(""), tapStringBuilder.toString());
        lazy.tap(eachStringBuilder::append).forEach(eachStringBuilder::append);
        Assert.assertEquals(CharAdapter.adapt(eachStringBuilder.toString()).toBag(), CharAdapter.adapt(tapStringBuilder.toString()).toBag());
    }

    @Test
    public void flatCollect()
    {
        Verify.assertIterableSize(3, this.classUnderTest().flatCollect(Lists.mutable::with));
    }

    @Test
    public void lazyCollectPrimitives()
    {
        Assert.assertEquals(BooleanLists.immutable.of(false, true, false), this.classUnderTest().collectBoolean(e -> e % 2 == 0).toList());
        Assert.assertEquals(CharLists.immutable.of((char) 2, (char) 3, (char) 4), this.classUnderTest().asLazy().collectChar(e -> (char) (e + 1)).toList());
        Assert.assertEquals(ByteLists.immutable.of((byte) 2, (byte) 3, (byte) 4), this.classUnderTest().asLazy().collectByte(e -> (byte) (e + 1)).toList());
        Assert.assertEquals(ShortLists.immutable.of((short) 2, (short) 3, (short) 4), this.classUnderTest().asLazy().collectShort(e -> (short) (e + 1)).toList());
        Assert.assertEquals(IntLists.immutable.of(2, 3, 4), this.classUnderTest().asLazy().collectInt(e -> (int) (e + 1)).toList());
        Assert.assertEquals(FloatLists.immutable.of(2.0f, 3.0f, 4.0f), this.classUnderTest().asLazy().collectFloat(e -> (float) (e + 1)).toList());
        Assert.assertEquals(LongLists.immutable.of(2L, 3L, 4L), this.classUnderTest().asLazy().collectLong(e -> (long) (e + 1)).toList());
        Assert.assertEquals(DoubleLists.immutable.of(2.0, 3.0, 4.0), this.classUnderTest().asLazy().collectDouble(e -> (double) (e + 1)).toList());
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6L, this.classUnderTest().sum());
        Assert.assertEquals(1L, this.newWith((char) 0, (char) 1).sum());
        Assert.assertEquals(33L, this.newWith((char) 0, (char) 33).sum());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyIterable()
    {
        this.getEmptyIterable().max();
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyIterable()
    {
        this.getEmptyIterable().min();
    }

    @Test
    public void max()
    {
        Assert.assertEquals((char) 3, this.classUnderTest().max());
        Assert.assertEquals((char) 33, this.newWith((char) 33, (char) 0).max());
        Assert.assertEquals((char) 100, this.newWith((char) 100, (char) 1).max());
        Assert.assertEquals((char) 2, this.newWith((char) 1, (char) 2).max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals((char) 1, this.classUnderTest().min());
        Assert.assertEquals((char) 0, this.newWith((char) 33, (char) 0).min());
        Assert.assertEquals((char) 1, this.newWith((char) 100, (char) 1).min());
        Assert.assertEquals((char) 1, this.newWith((char) 2, (char) 1).min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((char) 5, this.getEmptyIterable().minIfEmpty((char) 5));
        Assert.assertEquals((char) 1, this.classUnderTest().minIfEmpty((char) 0));
        Assert.assertEquals(
                (char) 0,
                this.classUnderTest().select(CharPredicates.lessThan((char) 0)).minIfEmpty((char) 0));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((char) 5, this.getEmptyIterable().maxIfEmpty((char) 5));
        Assert.assertEquals((char) 3, this.classUnderTest().maxIfEmpty((char) 0));
        Assert.assertEquals(
                (char) 0,
                this.classUnderTest().select(CharPredicates.lessThan((char) 0)).maxIfEmpty((char) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new LazyCharIterableAdapter(new CharArrayList()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new LazyCharIterableAdapter(new CharArrayList()).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(2.0d, this.classUnderTest().average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        this.getEmptyIterable().average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(2.0d, this.classUnderTest().median(), 0.0);
        Assert.assertEquals(16.0d, this.newWith((char) 1, (char) 31).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        this.getEmptyIterable().median();
    }

    @Test
    public void toArray()
    {
        Assert.assertTrue(Arrays.equals(new char[]{(char) 0, (char) 1}, this.newWith((char) 0, (char) 1).toArray())
                || Arrays.equals(new char[]{(char) 1, (char) 0}, this.newWith((char) 0, (char) 1).toArray()));
        Assert.assertTrue(Arrays.equals(new char[]{(char) 1, (char) 31}, this.newWith((char) 1, (char) 31).toArray())
                || Arrays.equals(new char[]{(char) 31, (char) 1}, this.newWith((char) 1, (char) 31).toArray()));
        Assert.assertTrue(Arrays.equals(new char[]{(char) 31, (char) 35}, this.newWith((char) 31, (char) 35).toArray())
                || Arrays.equals(new char[]{(char) 35, (char) 31}, this.newWith((char) 31, (char) 35).toArray()));
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.classUnderTest().contains((char) 1));
        Assert.assertTrue(this.classUnderTest().contains((char) 2));
        Assert.assertTrue(this.classUnderTest().contains((char) 3));
        Assert.assertFalse(this.classUnderTest().contains((char) 4));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.classUnderTest().containsAll((char) 1));
        Assert.assertTrue(this.classUnderTest().containsAll((char) 2));
        Assert.assertTrue(this.classUnderTest().containsAll((char) 1, (char) 2));
        Assert.assertTrue(this.classUnderTest().containsAll((char) 1, (char) 2, (char) 3));
        Assert.assertFalse(this.classUnderTest().containsAll((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertFalse(this.classUnderTest().containsAll((char) 4, (char) 5, (char) 6));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 2)));
        Assert.assertTrue(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 1, (char) 2)));
        Assert.assertTrue(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Assert.assertFalse(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4)));
        Assert.assertFalse(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 4, (char) 5, (char) 6)));
    }

    @Test
    public void testToString()
    {
        LazyCharIterable iterable = this.newWith((char) 1, (char) 2);
        Assert.assertTrue("[\u0001, \u0002]".equals(iterable.toString())
                || "[\u0002, \u0001]".equals(iterable.toString()));

        LazyCharIterable iterable1 = this.newWith((char) 0, (char) 31);
        Assert.assertTrue(
                iterable1.toString(),
                iterable1.toString().equals("[\u0000, \u001f]")
                        || iterable1.toString().equals("[\u001f, \u0000]"));

        LazyCharIterable iterable2 = this.newWith((char) 31, (char) 32);
        Assert.assertTrue(
                iterable2.toString(),
                iterable2.toString().equals("[\u001f, \u0020]")
                        || iterable2.toString().equals("[\u0020, \u001f]"));

        LazyCharIterable iterable3 = this.newWith((char) 32, (char) 33);
        Assert.assertTrue(
                iterable3.toString(),
                iterable3.toString().equals("[\u0020, \u0021]")
                        || iterable3.toString().equals("[\u0021, \u0020]"));

        LazyCharIterable iterable4 = this.newWith((char) 0, (char) 1);
        Assert.assertTrue(
                iterable4.toString(),
                iterable4.toString().equals("[\u0000, \u0001]")
                        || iterable4.toString().equals("[\u0001, \u0000]"));
    }

    @Test
    public void makeString()
    {
        LazyCharIterable iterable1 = this.newWith((char) 0, (char) 31);
        Assert.assertTrue(
                iterable1.makeString(),
                iterable1.makeString().equals("\u0000, \u001f")
                        || iterable1.makeString().equals("\u001f, \u0000"));

        LazyCharIterable iterable2 = this.newWith((char) 31, (char) 32);
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                iterable2.makeString("[", "/", "]").equals("[\u001f/\u0020]")
                        || iterable2.makeString("[", "/", "]").equals("[\u0020/\u001f]"));

        LazyCharIterable iterable3 = this.newWith((char) 32, (char) 33);
        Assert.assertTrue(
                iterable3.makeString("/"),
                iterable3.makeString("/").equals("\u0020/\u0021")
                        || iterable3.makeString("/").equals("\u0021/\u0020"));

        LazyCharIterable iterable4 = this.newWith((char) 1, (char) 2);
        Assert.assertTrue("\u0001, \u0002".equals(iterable4.makeString())
                || "\u0002, \u0001".equals(iterable4.makeString()));
        Assert.assertTrue("\u0001/\u0002".equals(iterable4.makeString("/"))
                || "\u0002/\u0001".equals(iterable4.makeString("/")));
        Assert.assertTrue("[\u0001/\u0002]".equals(iterable4.makeString("[", "/", "]"))
                || "[\u0002/\u0001]".equals(iterable4.makeString("[", "/", "]")));

        LazyCharIterable iterable5 = this.newWith((char) 0, (char) 1);
        Assert.assertTrue(
                iterable5.makeString(),
                iterable5.makeString().equals("\u0000, \u0001")
                        || iterable5.makeString().equals("\u0001, \u0000"));
        Assert.assertTrue(
                iterable5.makeString("[", "/", "]"),
                iterable5.makeString("[", "/", "]").equals("[\u0000/\u0001]")
                        || iterable5.makeString("[", "/", "]").equals("[\u0001/\u0000]"));
        Assert.assertTrue(
                iterable5.makeString("/"),
                iterable5.makeString("/").equals("\u0000/\u0001")
                        || iterable5.makeString("/").equals("\u0001/\u0000"));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable2 = new StringBuilder();
        LazyCharIterable iterable = this.newWith((char) 1, (char) 2);
        iterable.appendString(appendable2);
        Assert.assertTrue("\u0001, \u0002".equals(appendable2.toString())
                || "\u0002, \u0001".equals(appendable2.toString()));
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertTrue("\u0001/\u0002".equals(appendable3.toString())
                || "\u0002/\u0001".equals(appendable3.toString()));
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());

        StringBuilder appendable7 = new StringBuilder();
        LazyCharIterable iterable1 = this.newWith((char) 0, (char) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "\u0000, \u001f".equals(appendable7.toString())
                || "\u001f, \u0000".equals(appendable7.toString()));

        StringBuilder appendable8 = new StringBuilder();
        LazyCharIterable iterable2 = this.newWith((char) 31, (char) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "\u001f/\u0020".equals(appendable8.toString())
                || "\u0020/\u001f".equals(appendable8.toString()));

        StringBuilder appendable9 = new StringBuilder();
        LazyCharIterable iterable4 = this.newWith((char) 32, (char) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[\u0020/\u0021]".equals(appendable9.toString())
                || "[\u0021/\u0020]".equals(appendable9.toString()));

        StringBuilder appendable10 = new StringBuilder();
        LazyCharIterable iterable5 = this.newWith((char) 0, (char) 1);
        iterable5.appendString(appendable10);
        Assert.assertTrue(appendable10.toString(), "\u0000, \u0001".equals(appendable10.toString())
                || "\u0001, \u0000".equals(appendable10.toString()));
        StringBuilder appendable11 = new StringBuilder();
        iterable5.appendString(appendable11, "/");
        Assert.assertTrue(appendable11.toString(), "\u0000/\u0001".equals(appendable11.toString())
                || "\u0001/\u0000".equals(appendable11.toString()));
        StringBuilder appendable12 = new StringBuilder();
        iterable5.appendString(appendable12, "[", "/", "]");
        Assert.assertTrue(appendable12.toString(), "[\u0000/\u0001]".equals(appendable12.toString())
                || "[\u0001/\u0000]".equals(appendable12.toString()));
    }

    @Test
    public void toList()
    {
        LazyCharIterable iterable = this.newWith((char) 31, (char) 32);
        Assert.assertTrue(CharArrayList.newListWith((char) 31, (char) 32).equals(iterable.toList())
                || CharArrayList.newListWith((char) 32, (char) 31).equals(iterable.toList()));
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new char[]{1, 2, 3}, this.classUnderTest().toSortedArray());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), this.classUnderTest().toBag());
    }

    @Test
    public void asLazy()
    {
        LazyCharIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }
}
