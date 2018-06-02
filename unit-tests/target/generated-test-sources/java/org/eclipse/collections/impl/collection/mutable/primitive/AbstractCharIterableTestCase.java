/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.collection.mutable.primitive;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.BooleanSets;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.ByteSets;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.CharSets;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.FloatSets;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.LongSets;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link CharIterable}s
 * This file was automatically generated from template file abstractPrimitiveIterableTestCase.stg.
 */
public abstract class AbstractCharIterableTestCase
{
    protected abstract CharIterable classUnderTest();

    protected abstract CharIterable newWith(char... elements);

    protected abstract CharIterable newMutableCollectionWith(char... elements);

    protected abstract RichIterable<Character> newObjectCollectionWith(Character... elements);

    @Test
    public void newCollectionWith()
    {
        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 3);
        Verify.assertSize(3, iterable);
        Verify.assertSize(4, this.newWith((char) 0, (char) 1, (char) 31, (char) 32));
        Assert.assertTrue(iterable.containsAll((char) 1, (char) 2, (char) 3));

        CharIterable iterable1 = this.newWith();
        Verify.assertEmpty(iterable1);
        Assert.assertFalse(iterable1.containsAll((char) 1, (char) 2, (char) 3));

        CharIterable iterable2 = this.newWith((char) 1);
        Verify.assertSize(1, iterable2);
        Assert.assertFalse(iterable2.containsAll((char) 1, (char) 2, (char) 3));
    }

    @Test
    public void newCollection()
    {
        Assert.assertEquals(this.newMutableCollectionWith(), this.newWith());
        Assert.assertEquals(this.newMutableCollectionWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3));
        Assert.assertEquals(this.newMutableCollectionWith((char) 0, (char) 1, (char) 31, (char) 32), this.newWith((char) 0, (char) 1, (char) 31, (char) 32));
    }

    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.newWith());
        Verify.assertNotEmpty(this.classUnderTest());
        Verify.assertNotEmpty(this.newWith((char) 0, (char) 1, (char) 31, (char) 32));
        Verify.assertNotEmpty(this.newWith((char) 0, (char) 1, (char) 2));
        Verify.assertNotEmpty(this.newWith((char) 0, (char) 31));
        Verify.assertNotEmpty(this.newWith((char) 31, (char) 32));
        Verify.assertNotEmpty(this.newWith((char) 32, (char) 33));
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.newWith().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWith((char) 0, (char) 1, (char) 31, (char) 32).notEmpty());
        Assert.assertTrue(this.newWith((char) 0, (char) 1, (char) 2).notEmpty());
        Assert.assertTrue(this.newWith((char) 0, (char) 31).notEmpty());
        Assert.assertTrue(this.newWith((char) 31, (char) 32).notEmpty());
        Assert.assertTrue(this.newWith((char) 32, (char) 33).notEmpty());
    }

    @Test
    public void tap()
    {
        MutableCharList tapResult = CharLists.mutable.empty();
        CharIterable collection = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void contains()
    {
        CharIterable iterable = this.newWith((char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertFalse(iterable.contains((char) 29));
        Assert.assertFalse(iterable.contains((char) 49));

        char[] numbers = {(char) 14, (char) 2, (char) 30, (char) 31, (char) 32, (char) 35, (char) 0, (char) 1};
        for (char number : numbers)
        {
            Assert.assertTrue(iterable.contains(number));
        }

        Assert.assertFalse(iterable.contains((char) -1));
        Assert.assertFalse(iterable.contains((char) 29));
        Assert.assertFalse(iterable.contains((char) 49));

        CharIterable iterable1 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(iterable1.contains((char) 0));
        Assert.assertTrue(iterable1.contains((char) 1));
        Assert.assertTrue(iterable1.contains((char) 2));
        Assert.assertFalse(iterable1.contains((char) 3));

        CharIterable iterable2 = this.classUnderTest();
        for (char each = 1; each <= iterable2.size(); each++)
        {
            Assert.assertTrue(iterable2.contains(each));
        }
        Assert.assertFalse(iterable2.contains((char) (iterable2.size() + 1)));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(this.classUnderTest().toArray()));
        Assert.assertFalse(this.classUnderTest().containsAll((char) (this.classUnderTest().size() + 1)));

        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 3);
        Assert.assertTrue(iterable.containsAll((char) 1));
        Assert.assertTrue(iterable.containsAll((char) 1, (char) 2, (char) 3));
        Assert.assertFalse(iterable.containsAll((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertFalse(iterable.containsAll((char) 1, (char) 2, (char) 4));
        Assert.assertFalse(iterable.containsAll((char) 4, (char) 5, (char) 6));

        CharIterable iterable1 = this.newWith((char) 14, (char) 2, (char) 30, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertTrue(iterable1.containsAll((char) 14));
        Assert.assertTrue(iterable1.containsAll((char) 35));
        Assert.assertFalse(iterable1.containsAll((char) -1));
        Assert.assertTrue(iterable1.containsAll((char) 14, (char) 1, (char) 30));
        Assert.assertTrue(iterable1.containsAll((char) 14, (char) 1, (char) 32));
        Assert.assertTrue(iterable1.containsAll((char) 14, (char) 1, (char) 35));
        Assert.assertFalse(iterable1.containsAll((char) 0, (char) 2, (char) 35, (char) -1));
        Assert.assertFalse(iterable1.containsAll((char) 31, (char) -1));

        CharIterable iterable2 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(iterable2.containsAll((char) 0));
        Assert.assertTrue(iterable2.containsAll((char) 0, (char) 0, (char) 0));
        Assert.assertTrue(iterable2.containsAll((char) 0, (char) 1, (char) 1));
        Assert.assertTrue(iterable2.containsAll((char) 0, (char) 1, (char) 2));
        Assert.assertFalse(iterable2.containsAll((char) 0, (char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertFalse(iterable2.containsAll((char) 3, (char) 4));
    }

    @Test
    public void containsAllIterable()
    {
        CharIterable source = this.classUnderTest();
        Assert.assertTrue(source.containsAll(this.classUnderTest()));
        Assert.assertFalse(source.containsAll(CharArrayList.newListWith((char) (source.size() + 1))));

        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 3);
        Assert.assertTrue(this.newWith().containsAll(new CharArrayList()));
        Assert.assertFalse(this.newWith().containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Assert.assertFalse(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4)));
        Assert.assertFalse(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 4)));
        Assert.assertFalse(iterable.containsAll(CharArrayList.newListWith((char) 4, (char) 5, (char) 6)));

        CharIterable iterable1 = this.newWith((char) 14, (char) 2, (char) 30, (char) 32, (char) 35, (char) 0, (char) 1);
        Assert.assertTrue(iterable1.containsAll(CharHashSet.newSetWith((char) 14)));
        Assert.assertTrue(iterable1.containsAll(CharHashSet.newSetWith((char) 35)));
        Assert.assertFalse(iterable1.containsAll(CharHashSet.newSetWith((char) -1)));
        Assert.assertTrue(iterable1.containsAll(CharHashSet.newSetWith((char) 14, (char) 1, (char) 30)));
        Assert.assertTrue(iterable1.containsAll(CharHashSet.newSetWith((char) 14, (char) 1, (char) 32)));
        Assert.assertTrue(iterable1.containsAll(CharHashSet.newSetWith((char) 14, (char) 1, (char) 35)));
        Assert.assertFalse(iterable1.containsAll(CharHashSet.newSetWith((char) 0, (char) 2, (char) 35, (char) -1)));
        Assert.assertFalse(iterable1.containsAll(CharHashSet.newSetWith((char) 31, (char) -1)));

        CharIterable iterable2 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        Assert.assertTrue(iterable2.containsAll(CharArrayList.newListWith((char) 0)));
        Assert.assertTrue(iterable2.containsAll(CharArrayList.newListWith((char) 0, (char) 0, (char) 0)));
        Assert.assertTrue(iterable2.containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 1)));
        Assert.assertTrue(iterable2.containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 2)));
        Assert.assertFalse(iterable2.containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4)));
        Assert.assertFalse(iterable2.containsAll(CharArrayList.newListWith((char) 3, (char) 4)));
    }

    @Test
    public abstract void charIterator();

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

    @Test(expected = NoSuchElementException.class)
    public void charIterator_throws_non_empty_collection()
    {
        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 3);
        CharIterator iterator = iterable.charIterator();
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

        int size = this.classUnderTest().size();
        long sum1 = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum1, sum[0]);
    }

    @Test
    public void size()
    {
        Verify.assertSize(0, this.newWith());
        Verify.assertSize(1, this.newWith((char) 3));
        Verify.assertSize(3, this.newWith((char) 1, (char) 2, (char) 3));
    }

    @Test
    public void count()
    {
        CharIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 3 ? 3 : size, iterable.count(CharPredicates.lessThan((char) 4)));
        Assert.assertEquals(2L, this.newWith((char) 1, (char) 0, (char) 2).count(CharPredicates.greaterThan('\0')));

        Assert.assertEquals(1, this.newWith((char) 1).count(CharPredicates.alwaysTrue()));
        Assert.assertEquals(0, this.newWith((char) 1).count(CharPredicates.alwaysFalse()));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith((char) 1, (char) -1, (char) 2).anySatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 1, (char) -1, (char) 2).anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWith((char) -1, (char) -1, (char) -2, (char) 31, (char) 32).anySatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertTrue(this.newWith((char) 2, (char) -1, (char) -2, (char) 31, (char) 32).anySatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 1, (char) -1, (char) 31, (char) 32).anySatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWith((char) 32).anySatisfy(CharPredicates.greaterThan((char) 0)));
        CharIterable iterable = this.newWith((char) 0, (char) 1, (char) 2);
        Assert.assertTrue(iterable.anySatisfy(value -> value < (char) 3));
        Assert.assertFalse(iterable.anySatisfy(CharPredicates.greaterThan((char) 3)));

        CharIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size > 3, iterable1.anySatisfy(CharPredicates.greaterThan((char) 3)));
        Assert.assertEquals(size != 0, iterable1.anySatisfy(CharPredicates.lessThan((char) 3)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.newWith((char) 1, (char) 0, (char) 2).allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertTrue(this.newWith((char) 1, (char) 2, (char) 3).allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 1, (char) 0, (char) 31, (char) 32).allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 1, (char) 0, (char) 31, (char) 32).allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertTrue(this.newWith((char) 1, (char) 2, (char) 31, (char) 32).allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 32).allSatisfy(CharPredicates.equal((char) 33)));
        Assert.assertFalse(this.newWith((char) -32).allSatisfy(CharPredicates.equal((char) 33)));
        CharIterable iterable = this.newWith((char) 0, (char) 1, (char) 2);
        Assert.assertFalse(iterable.allSatisfy(value -> (char) 3 < value));
        Assert.assertTrue(iterable.allSatisfy(CharPredicates.lessThan((char) 3)));

        CharIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size == 0, iterable1.allSatisfy(CharPredicates.greaterThan((char) 3)));
        Assert.assertEquals(size < 3, iterable1.allSatisfy(CharPredicates.lessThan((char) 3)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.newWith((char) 1, (char) 0, (char) 2).noneSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 1, (char) 0, (char) 2).noneSatisfy(CharPredicates.equal((char) 0)));
        Assert.assertTrue(this.newWith((char) 1, (char) 2, (char) 3).noneSatisfy(CharPredicates.greaterThan((char) 3)));
        Assert.assertFalse(this.newWith((char) 1, (char) 0, (char) 31, (char) 32).noneSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 1, (char) 0, (char) 31, (char) 32).noneSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertTrue(this.newWith((char) 1, (char) 2, (char) 31, (char) 32).noneSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(this.newWith((char) 32).noneSatisfy(CharPredicates.greaterThan((char) 0)));
        CharIterable iterable = this.newWith((char) 0, (char) 1, (char) 2);
        Assert.assertFalse(iterable.noneSatisfy(value -> (char) 1 < value));
        Assert.assertTrue(iterable.noneSatisfy(CharPredicates.greaterThan((char) 3)));

        CharIterable iterable1 = this.classUnderTest();
        int size = iterable1.size();
        Assert.assertEquals(size <= 3, iterable1.noneSatisfy(CharPredicates.greaterThan((char) 3)));
        Assert.assertEquals(size == 0, iterable1.noneSatisfy(CharPredicates.lessThan((char) 3)));
    }

    @Test
    public void collect()
    {
        CharToObjectFunction<Character> function = parameter -> (char) (parameter - 1);
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 2), this.newWith((char) 1, (char) 2, (char) 3).collect(function));
        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2), iterable.collect(function));
        Assert.assertEquals(this.newObjectCollectionWith(), this.newWith().collect(function));
        Assert.assertEquals(this.newObjectCollectionWith((char) 2), this.newWith((char) 3).collect(function));
    }

    @Test
    public void collectWithTarget()
    {
        CharToObjectFunction<Character> function = parameter -> (char) (parameter - 1);
        Assert.assertEquals(Bags.mutable.with((char) 0, (char) 1, (char) 2), this.newWith((char) 1, (char) 2, (char) 3).collect(function, Bags.mutable.empty()));
        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(Sets.mutable.with((char) 0, (char) 1, (char) 2), iterable.collect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().collect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((char) 2), this.newWith((char) 3).collect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectWithTarget()
    {
        CharToObjectFunction<List<Character>> function = parameter -> Lists.mutable.with((char) (parameter - 1));
        Assert.assertEquals(Bags.mutable.with((char) 0, (char) 1, (char) 2), this.newWith((char) 1, (char) 2, (char) 3).flatCollect(function, Bags.mutable.empty()));
        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(Sets.mutable.with((char) 0, (char) 1, (char) 2), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((char) 2), this.newWith((char) 3).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void flatCollectIterableWithTarget()
    {
        CharToObjectFunction<Iterable<Character>> function = parameter -> Lists.mutable.with((char) (parameter - 1)).asLazy();
        Assert.assertEquals(Bags.mutable.with((char) 0, (char) 1, (char) 2), this.newWith((char) 1, (char) 2, (char) 3).flatCollect(function, Bags.mutable.empty()));
        CharIterable iterable = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(Sets.mutable.with((char) 0, (char) 1, (char) 2), iterable.flatCollect(function, Sets.mutable.empty()));
        Assert.assertEquals(Lists.mutable.empty(), this.newWith().flatCollect(function, Lists.mutable.empty()));
        Assert.assertEquals(Lists.mutable.with((char) 2), this.newWith((char) 3).flatCollect(function, Lists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToLists()
    {
        CharIterable iterable = this.newWith((char) 1, (char) 2);
        Assert.assertEquals(
                BooleanLists.mutable.with(true, true),
                iterable.collectBoolean(each -> true, BooleanLists.mutable.empty()));
        Assert.assertEquals(
                ByteLists.mutable.with((byte) 1, (byte) 1),
                iterable.collectByte(each -> (byte) 1, ByteLists.mutable.empty()));
        Assert.assertEquals(
                CharLists.mutable.with('a', 'a'),
                iterable.collectChar(each -> 'a', CharLists.mutable.empty()));
        Assert.assertEquals(
                ShortLists.mutable.with((short) 1, (short) 1),
                iterable.collectShort(each -> (short) 1, ShortLists.mutable.empty()));
        Assert.assertEquals(
                IntLists.mutable.with(1, 1),
                iterable.collectInt(each -> 1, IntLists.mutable.empty()));
        Assert.assertEquals(
                FloatLists.mutable.with(1.0f, 1.0f),
                iterable.collectFloat(each -> 1.0f, FloatLists.mutable.empty()));
        Assert.assertEquals(
                LongLists.mutable.with(1L, 1L),
                iterable.collectLong(each -> 1L, LongLists.mutable.empty()));
        Assert.assertEquals(
                DoubleLists.mutable.with(1.0d, 1.0d),
                iterable.collectDouble(each -> 1.0d, DoubleLists.mutable.empty()));
    }

    @Test
    public void collectPrimitivesToSets()
    {
        CharIterable iterable = this.newWith((char) 1, (char) 2);
        Assert.assertEquals(
                BooleanSets.mutable.with(false),
                iterable.collectBoolean(each -> false, BooleanSets.mutable.empty()));
        Assert.assertEquals(
                ByteSets.mutable.with((byte) 2),
                iterable.collectByte(each -> (byte) 2, ByteSets.mutable.empty()));
        Assert.assertEquals(
                CharSets.mutable.with('b'),
                iterable.collectChar(each -> 'b', CharSets.mutable.empty()));
        Assert.assertEquals(
                ShortSets.mutable.with((short) 2),
                iterable.collectShort(each -> (short) 2, ShortSets.mutable.empty()));
        Assert.assertEquals(
                IntSets.mutable.with(2),
                iterable.collectInt(each -> 2, IntSets.mutable.empty()));
        Assert.assertEquals(
                FloatSets.mutable.with(2.0f),
                iterable.collectFloat(each -> 2.0f, FloatSets.mutable.empty()));
        Assert.assertEquals(
                LongSets.mutable.with(2L),
                iterable.collectLong(each -> 2L, LongSets.mutable.empty()));
        Assert.assertEquals(
                DoubleSets.mutable.with(2.0d),
                iterable.collectDouble(each -> 2.0d, DoubleSets.mutable.empty()));
    }

    @Test
    public void select()
    {
        CharIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(CharPredicates.lessThan((char) 4)));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(CharPredicates.lessThan((char) 3)));
        CharIterable iterable1 = this.newWith((char) 0, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(this.newMutableCollectionWith((char) 0, (char) 1), iterable1.select(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 2, (char) 3, (char) 3, (char) 3), iterable1.select(CharPredicates.greaterThan((char) 1)));

        CharIterable iterable2 = this.newWith((char) 0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.select(CharPredicates.alwaysTrue()));
        Verify.assertSize(0, iterable2.select(CharPredicates.alwaysFalse()));
    }

    @Test
    public void selectWithTarget()
    {
        CharIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size >= 3 ? 3 : size, iterable.select(CharPredicates.lessThan((char) 4), CharSets.mutable.empty()));
        Verify.assertSize(size >= 2 ? 2 : size, iterable.select(CharPredicates.lessThan((char) 3), CharSets.mutable.empty()));
        CharIterable iterable1 = this.newWith((char) 0, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(CharSets.mutable.with((char) 0, (char) 1), iterable1.select(CharPredicates.lessThan((char) 2), CharSets.mutable.empty()));
        Assert.assertEquals(CharSets.mutable.with((char) 2, (char) 3), iterable1.select(CharPredicates.greaterThan((char) 1), CharSets.mutable.empty()));
    }

    @Test
    public void reject()
    {
        CharIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(CharPredicates.lessThan((char) 4)));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(CharPredicates.lessThan((char) 3)));
        CharIterable iterable1 = this.newWith((char) 0, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(this.newMutableCollectionWith((char) 2, (char) 2, (char) 3, (char) 3, (char) 3), iterable1.reject(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(this.newMutableCollectionWith((char) 0, (char) 1), iterable1.reject(CharPredicates.greaterThan((char) 1)));

        CharIterable iterable2 = this.newWith((char) 0);
        Verify.assertSize(iterable2.size() == 1 ? 1 : 0, iterable2.reject(CharPredicates.alwaysFalse()));
        Verify.assertSize(0, iterable2.reject(CharPredicates.alwaysTrue()));
    }

    @Test
    public void rejectWithTarget()
    {
        CharIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Verify.assertSize(size <= 3 ? 0 : size - 3, iterable.reject(CharPredicates.lessThan((char) 4), CharSets.mutable.empty()));
        Verify.assertSize(size <= 2 ? 0 : size - 2, iterable.reject(CharPredicates.lessThan((char) 3), CharSets.mutable.empty()));
        CharIterable iterable1 = this.newWith((char) 0, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(CharSets.mutable.with((char) 2, (char) 3), iterable1.reject(CharPredicates.lessThan((char) 2), CharSets.mutable.empty()));
        Assert.assertEquals(CharSets.mutable.with((char) 0, (char) 1), iterable1.reject(CharPredicates.greaterThan((char) 1), CharSets.mutable.empty()));
    }

    @Test
    public void detectIfNone()
    {
        CharIterable iterable = this.classUnderTest();
        int size = iterable.size();
        Assert.assertEquals(size >= 4 ? 4L : 0L, iterable.detectIfNone(CharPredicates.equal((char) 4), (char) 0));
        Assert.assertEquals(size >= 2 ? 2L : 0L, iterable.detectIfNone(CharPredicates.equal((char) 2), (char) 0));
        Assert.assertEquals(size > 0 ? 1L : 0L, iterable.detectIfNone(CharPredicates.lessThan((char) 2), (char) 0));
        Assert.assertEquals(size > 3 ? 4L : 0L, iterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));

        CharIterable iterable1 = this.newWith((char) 0, (char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(0L, iterable1.detectIfNone(CharPredicates.lessThan((char) 1), (char) 4));
        Assert.assertEquals(3L, iterable1.detectIfNone(CharPredicates.greaterThan((char) 2), (char) 4));
        Assert.assertEquals(4L, iterable1.detectIfNone(CharPredicates.greaterThan((char) 4), (char) 4));
    }

    @Test
    public void max()
    {
        Assert.assertEquals((char) -1, this.newWith((char) -1, (char) -2, (char) 9).max());
        Assert.assertEquals((char) 32, this.newWith((char) 1, (char) 0, (char) 9, (char) 30, (char) 31, (char) 32).max());
        Assert.assertEquals((char) -1, this.newWith((char) -1, (char) 0, (char) 9, (char) 30, (char) 31, (char) 32).max());
        Assert.assertEquals((char) 31, this.newWith((char) 31, (char) 0, (char) 30).max());
        Assert.assertEquals((char) 39, this.newWith((char) 32, (char) 39, (char) 35).max());
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyCollection()
    {
        this.newWith().max();
    }

    @Test
    public void min()
    {
        Assert.assertEquals(9L, this.newWith((char) -1, (char) -2, (char) 9).min());
        Assert.assertEquals(0L, this.newWith((char) 1, (char) 0, (char) 9, (char) 30, (char) 31, (char) 32).min());
        Assert.assertEquals(0L, this.newWith((char) -1, (char) 0, (char) 9, (char) 30, (char) 31, (char) 32).min());
        Assert.assertEquals(31L, this.newWith((char) 31, (char) 32, (char) 33).min());
        Assert.assertEquals(32L, this.newWith((char) 32, (char) 39, (char) 35).min());
        Assert.assertEquals(1L, this.classUnderTest().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyCollection()
    {
        this.newWith().min();
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5L, this.newWith().minIfEmpty((char) 5));
        Assert.assertEquals(0L, this.newWith().minIfEmpty((char) 0));
        Assert.assertEquals(0L, this.newWith((char) 1, (char) 0, (char) 9, (char) 7).minIfEmpty((char) 5));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? (char) 5 : (char) 1, this.classUnderTest().minIfEmpty((char) 5));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5L, this.newWith().maxIfEmpty((char) 5));
        Assert.assertEquals(0L, this.newWith().maxIfEmpty((char) 0));
        Assert.assertEquals(9L, this.newWith((char) 1, (char) 0, (char) 9, (char) 7).maxIfEmpty((char) 5));
        int size = this.classUnderTest().size();
        Assert.assertEquals(size == 0 ? (char) 5 : size, this.classUnderTest().maxIfEmpty((char) 5));
    }

    @Test
    public void sum()
    {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().sum());
        Assert.assertEquals(10L, this.newWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4).sum());
        Assert.assertEquals(93L, this.newWith((char) 30, (char) 31, (char) 32).sum());
    }

    @Test
    public void summaryStatistics()
    {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        Assert.assertEquals(sum, this.classUnderTest().summaryStatistics().getSum());
        Assert.assertEquals(10L, this.newWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4).summaryStatistics().getSum());
        Assert.assertEquals(93L, this.newWith((char) 30, (char) 31, (char) 32).summaryStatistics().getSum());
    }

    @Test
    public void average()
    {
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().average(), 0.0);
        Assert.assertEquals(2.5, this.newWith((char) 1, (char) 2, (char) 3, (char) 4).average(), 0.0);
        Assert.assertEquals(2.5, this.newWith((char) 1, (char) 2, (char) 3, (char) 4).average(), 0.0);
        Assert.assertEquals(31.0, this.newWith((char) 30, (char) 30, (char) 31, (char) 31, (char) 32, (char) 32).average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        this.newWith().average();
    }

    /**
     * @since 9.0
     */
    @Test
    public void averageIfEmpty()
    {
        Assert.assertEquals(2.5, this.newWith().averageIfEmpty(2.5), 0.0);
        int size = this.classUnderTest().size();
        long sum = (long) ((size * (size + 1)) / 2);
        double average = sum / size;
        Assert.assertEquals(average, this.classUnderTest().averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith((char) 1, (char) 2, (char) 3, (char) 4).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith((char) 1, (char) 2, (char) 3, (char) 4).averageIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith((char) 30, (char) 30, (char) 31, (char) 31, (char) 32, (char) 32).averageIfEmpty(0.0), 0.0);
    }

    @Test
    public void median()
    {
        Assert.assertEquals(1.0, this.newWith((char) 1).median(), 0.0);
        Assert.assertEquals(2.5, this.newWith((char) 1, (char) 2, (char) 3, (char) 4).median(), 0.0);
        Assert.assertEquals(3.0, this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).median(), 0.0);
        Assert.assertEquals(31.0, this.newWith((char) 30, (char) 30, (char) 31, (char) 31, (char) 32).median(), 0.0);
        Assert.assertEquals(30.5, this.newWith((char) 1, (char) 30, (char) 30, (char) 31, (char) 31, (char) 32).median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        this.newWith().median();
    }

    /**
     * @since 9.0
     */
    @Test
    public void medianIfEmpty()
    {
        Assert.assertEquals(2.5, this.newWith().medianIfEmpty(2.5), 0.0);
        Assert.assertEquals(1.0, this.newWith((char) 1).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(2.5, this.newWith((char) 1, (char) 2, (char) 3, (char) 4).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(3.0, this.newWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(31.0, this.newWith((char) 30, (char) 30, (char) 31, (char) 31, (char) 32).medianIfEmpty(0.0), 0.0);
        Assert.assertEquals(30.5, this.newWith((char) 1, (char) 30, (char) 30, (char) 31, (char) 31, (char) 32).medianIfEmpty(0.0), 0.0);
    }

    @Test
    public void toArray()
    {
        Assert.assertEquals(this.classUnderTest().size(), this.classUnderTest().toArray().length);
        CharIterable iterable = this.newWith((char) 1, (char) 2);
        Assert.assertTrue(Arrays.equals(new char[]{(char) 1, (char) 2}, iterable.toArray())
                || Arrays.equals(new char[]{(char) 2, (char) 1}, iterable.toArray()));
        Assert.assertTrue(Arrays.equals(new char[]{(char) 0, (char) 1}, this.newWith((char) 0, (char) 1).toArray())
                || Arrays.equals(new char[]{(char) 1, (char) 0}, this.newWith((char) 0, (char) 1).toArray()));
        Assert.assertTrue(Arrays.equals(new char[]{(char) 1, (char) 31}, this.newWith((char) 1, (char) 31).toArray())
                || Arrays.equals(new char[]{(char) 31, (char) 1}, this.newWith((char) 1, (char) 31).toArray()));
        Assert.assertTrue(Arrays.equals(new char[]{(char) 31, (char) 35}, this.newWith((char) 31, (char) 35).toArray())
                || Arrays.equals(new char[]{(char) 35, (char) 31}, this.newWith((char) 31, (char) 35).toArray()));
        Assert.assertArrayEquals(new char[]{}, this.newWith().toArray());
        Assert.assertArrayEquals(new char[]{(char) 32}, this.newWith((char) 32).toArray());
    }

    @Test
    public void toSortedArray()
    {
        CharIterable iterable = this.classUnderTest();
        int size = iterable.size();
        char[] array = new char[size];
        for (int i = 0; i < size; i++)
        {
            array[i] = (char) (i + 1);
        }

        Assert.assertArrayEquals(array, iterable.toSortedArray());
        Assert.assertArrayEquals(new char[]{(char) 1, (char) 3, (char) 7, (char) 9},
                this.newWith((char) 3, (char) 1, (char) 9, (char) 7).toSortedArray());
    }

    @Test
    public void testEquals()
    {
        CharIterable iterable1 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4);
        CharIterable iterable2 = this.newWith((char) 1, (char) 2, (char) 3, (char) 4);
        CharIterable iterable3 = this.newWith((char) 5, (char) 6, (char) 7, (char) 8);
        CharIterable iterable4 = this.newWith((char) 5, (char) 6, (char) 7);
        CharIterable iterable5 = this.newWith((char) 0, (char) 1, (char) 1, (char) 2, (char) 2, (char) 2);
        CharIterable iterable6 = this.newWith((char) 1, (char) 31, (char) 32);
        CharIterable iterable7 = this.newWith((char) 35, (char) 31, (char) 1);
        CharIterable iterable8 = this.newWith((char) 32, (char) 31, (char) 1, (char) 50);
        CharIterable iterable9 = this.newWith((char) 0, (char) 1, (char) 2);
        CharIterable iterable10 = this.newWith((char) 0, (char) 1, (char) 3);
        CharIterable iterable11 = this.newWith((char) 3, (char) 1, (char) 2);
        CharIterable iterable12 = this.newWith((char) 3);

        Verify.assertEqualsAndHashCode(iterable1, iterable2);
        Verify.assertPostSerializedEqualsAndHashCode(iterable1);
        Verify.assertPostSerializedEqualsAndHashCode(iterable12);
        Verify.assertPostSerializedEqualsAndHashCode(iterable5);
        Verify.assertPostSerializedEqualsAndHashCode(iterable6);
        Assert.assertNotEquals(iterable12, iterable11);
        Assert.assertNotEquals(iterable1, iterable3);
        Assert.assertNotEquals(iterable1, iterable4);
        Assert.assertNotEquals(iterable6, iterable7);
        Assert.assertNotEquals(iterable6, iterable8);
        Assert.assertNotEquals(iterable9, iterable10);
        Assert.assertNotEquals(iterable9, iterable11);
        Assert.assertNotEquals(this.newWith(), this.newWith((char) 100));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(this.newObjectCollectionWith((char) 1, (char) 2, (char) 3).hashCode(), this.newWith((char) 1, (char) 2, (char) 3).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((char) 0, (char) 1, (char) 31).hashCode(), this.newWith((char) 0, (char) 1, (char) 31).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((char) 32).hashCode(), this.newWith((char) 32).hashCode());
        Assert.assertNotEquals(this.newObjectCollectionWith((char) 32).hashCode(), this.newWith((char) 0).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((char) 31, (char) 32, (char) 50).hashCode(), this.newWith((char) 31, (char) 32, (char) 50).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith((char) 32, (char) 50, (char) 60).hashCode(), this.newWith((char) 32, (char) 50, (char) 60).hashCode());
        Assert.assertEquals(this.newObjectCollectionWith().hashCode(), this.newWith().hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[]", this.newWith().toString());
        Assert.assertEquals("[\u0001]", this.newWith((char) 1).toString());
        Assert.assertEquals("[\u001f]", this.newWith((char) 31).toString());
        Assert.assertEquals("[\u0020]", this.newWith((char) 32).toString());

        CharIterable iterable = this.newWith((char) 1, (char) 2);
        Assert.assertTrue("[\u0001, \u0002]".equals(iterable.toString())
                || "[\u0002, \u0001]".equals(iterable.toString()));

        CharIterable iterable1 = this.newWith((char) 0, (char) 31);
        Assert.assertTrue(
                iterable1.toString(),
                iterable1.toString().equals("[\u0000, \u001f]")
                        || iterable1.toString().equals("[\u001f, \u0000]"));

        CharIterable iterable2 = this.newWith((char) 31, (char) 32);
        Assert.assertTrue(
                iterable2.toString(),
                iterable2.toString().equals("[\u001f, \u0020]")
                        || iterable2.toString().equals("[\u0020, \u001f]"));

        CharIterable iterable3 = this.newWith((char) 32, (char) 33);
        Assert.assertTrue(
                iterable3.toString(),
                iterable3.toString().equals("[\u0020, \u0021]")
                        || iterable3.toString().equals("[\u0021, \u0020]"));

        CharIterable iterable4 = this.newWith((char) 0, (char) 1);
        Assert.assertTrue(
                iterable4.toString(),
                iterable4.toString().equals("[\u0000, \u0001]")
                        || iterable4.toString().equals("[\u0001, \u0000]"));
    }

    @Test
    public void makeString()
    {
        CharIterable iterable = this.classUnderTest();
        Assert.assertEquals("\u0001", this.newWith((char) 1).makeString("/"));
        Assert.assertEquals("\u001f", this.newWith((char) 31).makeString());
        Assert.assertEquals("\u0020", this.newWith((char) 32).makeString());
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", this.newWith().makeString());
        Assert.assertEquals("", this.newWith().makeString("/"));
        Assert.assertEquals("[]", this.newWith().makeString("[", ", ", "]"));

        CharIterable iterable1 = this.newWith((char) 0, (char) 31);
        Assert.assertTrue(
                iterable1.makeString(),
                iterable1.makeString().equals("\u0000, \u001f")
                        || iterable1.makeString().equals("\u001f, \u0000"));

        CharIterable iterable2 = this.newWith((char) 31, (char) 32);
        Assert.assertTrue(
                iterable2.makeString("[", "/", "]"),
                iterable2.makeString("[", "/", "]").equals("[\u001f/\u0020]")
                        || iterable2.makeString("[", "/", "]").equals("[\u0020/\u001f]"));

        CharIterable iterable3 = this.newWith((char) 32, (char) 33);
        Assert.assertTrue(
                iterable3.makeString("/"),
                iterable3.makeString("/").equals("\u0020/\u0021")
                        || iterable3.makeString("/").equals("\u0021/\u0020"));

        CharIterable iterable4 = this.newWith((char) 1, (char) 2);
        Assert.assertTrue("\u0001, \u0002".equals(iterable4.makeString())
                || "\u0002, \u0001".equals(iterable4.makeString()));
        Assert.assertTrue("\u0001/\u0002".equals(iterable4.makeString("/"))
                || "\u0002/\u0001".equals(iterable4.makeString("/")));
        Assert.assertTrue("[\u0001/\u0002]".equals(iterable4.makeString("[", "/", "]"))
                || "[\u0002/\u0001]".equals(iterable4.makeString("[", "/", "]")));

        CharIterable iterable5 = this.newWith((char) 0, (char) 1);
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
        StringBuilder appendable = new StringBuilder();
        this.newWith().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());
        this.newWith().appendString(appendable, "[", ", ", "]");
        Assert.assertEquals("[]", appendable.toString());
        StringBuilder appendable1 = new StringBuilder();
        this.newWith((char) 1).appendString(appendable1);
        Assert.assertEquals("\u0001", appendable1.toString());
        StringBuilder appendable2 = new StringBuilder();

        CharIterable iterable = this.newWith((char) 1, (char) 2);
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

        StringBuilder appendable5 = new StringBuilder();
        this.newWith((char) 31).appendString(appendable5);
        Assert.assertEquals("\u001f", appendable5.toString());

        StringBuilder appendable6 = new StringBuilder();
        this.newWith((char) 32).appendString(appendable6);
        Assert.assertEquals("\u0020", appendable6.toString());

        StringBuilder appendable7 = new StringBuilder();
        CharIterable iterable1 = this.newWith((char) 0, (char) 31);
        iterable1.appendString(appendable7);
        Assert.assertTrue(appendable7.toString(), "\u0000, \u001f".equals(appendable7.toString())
                || "\u001f, \u0000".equals(appendable7.toString()));

        StringBuilder appendable8 = new StringBuilder();
        CharIterable iterable2 = this.newWith((char) 31, (char) 32);
        iterable2.appendString(appendable8, "/");
        Assert.assertTrue(appendable8.toString(), "\u001f/\u0020".equals(appendable8.toString())
                || "\u0020/\u001f".equals(appendable8.toString()));

        StringBuilder appendable9 = new StringBuilder();
        CharIterable iterable4 = this.newWith((char) 32, (char) 33);
        iterable4.appendString(appendable9, "[", "/", "]");
        Assert.assertTrue(appendable9.toString(), "[\u0020/\u0021]".equals(appendable9.toString())
                || "[\u0021/\u0020]".equals(appendable9.toString()));

        StringBuilder appendable10 = new StringBuilder();
        CharIterable iterable5 = this.newWith((char) 0, (char) 1);
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
        CharIterable iterable = this.newWith((char) 31, (char) 32);
        Assert.assertTrue(CharArrayList.newListWith((char) 31, (char) 32).equals(iterable.toList())
                || CharArrayList.newListWith((char) 32, (char) 31).equals(iterable.toList()));
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.newWith((char) 0).toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 31), this.newWith((char) 31).toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 32), this.newWith((char) 32).toList());
        Assert.assertEquals(new CharArrayList(), this.newWith().toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(CharArrayList.newListWith(), this.newWith().toSortedList());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), this.newWith((char) 1).toSortedList());
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 1, (char) 31), this.newWith((char) 0, (char) 31, (char) 1).toSortedList());
        Assert.assertEquals(CharArrayList.newListWith((char) 0, (char) 1, (char) 31, (char) 32), this.newWith((char) 0, (char) 31, (char) 32, (char) 1).toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(CharHashSet.newSetWith(), this.newWith().toSet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), this.newWith((char) 1).toSet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3).toSet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31), this.newWith((char) 0, (char) 1, (char) 31).toSet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 31, (char) 32), this.newWith((char) 0, (char) 1, (char) 31, (char) 32).toSet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3).toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(new CharHashBag(), this.newWith().toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), this.newWith((char) 1).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), this.newWith((char) 1, (char) 2, (char) 3).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3), this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3).toBag());
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 31, (char) 32), this.newWith((char) 0, (char) 1, (char) 31, (char) 32).toBag());
    }

    @Test
    public void asLazy()
    {
        CharIterable iterable = this.classUnderTest();
        Assert.assertEquals(iterable.toBag(), iterable.asLazy().toBag());
        Verify.assertInstanceOf(LazyCharIterable.class, iterable.asLazy());

        CharIterable iterable1 = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(iterable1.toBag(), iterable1.asLazy().toBag());
        Verify.assertInstanceOf(LazyCharIterable.class, iterable1.asLazy());

        CharIterable iterable2 = this.newWith((char) 1, (char) 2, (char) 2, (char) 3, (char) 3, (char) 3);
        Assert.assertEquals(iterable2.toBag(), iterable2.asLazy().toBag());
        Verify.assertInstanceOf(LazyCharIterable.class, iterable2.asLazy());

        CharIterable iterable3 = this.newWith();
        Assert.assertEquals(iterable3.toBag(), iterable3.asLazy().toBag());
        Verify.assertInstanceOf(LazyCharIterable.class, iterable3.asLazy());

        CharIterable iterable4 = this.newWith((char) 1);
        Assert.assertEquals(iterable4.toBag(), iterable4.asLazy().toBag());
        Verify.assertInstanceOf(LazyCharIterable.class, iterable4.asLazy());
    }

    @Test
    public void injectInto()
    {
        CharIterable iterable1 = this.newWith((char) 0, (char) 2, (char) 31);
        Character sum1 = iterable1.injectInto(Character.valueOf((char) 0), (Character result, char value) -> Character.valueOf((char) (result + value + 1)));
        Assert.assertEquals(Character.valueOf((char) 36), sum1);

        CharIterable iterable2 = this.newWith((char) 1, (char) 2, (char) 31);
        Character sum2 = iterable2.injectInto(Character.valueOf((char) 0), (Character result, char value) -> Character.valueOf((char) (result + value + 1)));
        Assert.assertEquals(Character.valueOf((char) 37), sum2);

        CharIterable iterable3 = this.newWith((char) 0, (char) 1, (char) 2, (char) 31);
        Character sum3 = iterable3.injectInto(Character.valueOf((char) 0), (Character result, char value) -> Character.valueOf((char) (result + value + 1)));
        Assert.assertEquals(Character.valueOf((char) 38), sum3);
    }

    @Test
    public void chunk()
    {
        CharIterable iterable = this.newWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5);
        Assert.assertEquals(
                Lists.mutable.with(
                        this.newMutableCollectionWith((char) 0),
                        this.newMutableCollectionWith((char) 1),
                        this.newMutableCollectionWith((char) 2),
                        this.newMutableCollectionWith((char) 3),
                        this.newMutableCollectionWith((char) 4),
                        this.newMutableCollectionWith((char) 5)).toSet(),
                iterable.chunk(1).toSet());
        Assert.assertEquals(
                Lists.mutable.with(
                        this.newMutableCollectionWith((char) 0, (char) 1),
                        this.newMutableCollectionWith((char) 2, (char) 3),
                        this.newMutableCollectionWith((char) 4, (char) 5)).toSet(),
                iterable.chunk(2).toSet());
        Assert.assertEquals(
                Lists.mutable.with(
                        this.newMutableCollectionWith((char) 0, (char) 1, (char) 2),
                        this.newMutableCollectionWith((char) 3, (char) 4, (char) 5)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(
                        this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3),
                        this.newMutableCollectionWith((char) 4, (char) 5)).toSet(),
                iterable.chunk(4).toSet());
        Assert.assertEquals(
                Lists.mutable.with(this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5)).toSet(),
                iterable.chunk(6).toSet());
        Assert.assertEquals(
                Lists.mutable.with(this.newMutableCollectionWith((char) 0, (char) 1, (char) 2, (char) 3, (char) 4, (char) 5)).toSet(),
                iterable.chunk(7).toSet());
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));
        Assert.assertEquals(Lists.mutable.with(this.newMutableCollectionWith((char) 0)), this.newWith((char) 0).chunk(1));
        Assert.assertEquals(Lists.mutable.with(), this.newWith().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newMutableCollectionWith().chunk(-1));
    }
}
