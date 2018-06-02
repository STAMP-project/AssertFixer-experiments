/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectLongPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link ObjectLongMap#keyValuesView()}.
 * This file was automatically generated from template file abstractObjectPrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractObjectLongMapKeyValuesViewTestCase
{
    public abstract <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3);

    public abstract <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2);

    public abstract <T> ObjectLongMap<T> newWithKeysValues(T key1, long value1);

    public abstract <T> ObjectLongMap<T> newEmpty();

    public RichIterable<ObjectLongPair<Object>> newWith()
    {
        return this.newEmpty().keyValuesView();
    }

    public <T> RichIterable<ObjectLongPair<T>> newWith(T key1, long value1)
    {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public <T> RichIterable<ObjectLongPair<T>> newWith(T key1, long value1, T key2, long value2)
    {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public <T> RichIterable<ObjectLongPair<T>> newWith(T key1, long value1, T key2, long value2, T key3, long value3)
    {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 3L))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(1L, Integer.valueOf(5)))));
    }

    @Test
    public void containsAllArray()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(1L, Integer.valueOf(5))));
    }

    @Test
    public void forEach()
    {
        MutableList<ObjectLongPair<Integer>> result = Lists.mutable.of();
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 3L), PrimitiveTuples.pair(Integer.valueOf(3), 4L));
    }

    @Test
    public void forEachWith()
    {
        MutableBag<ObjectLongPair<Integer>> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        collection.forEachWith((ObjectLongPair<Integer> argument1, Integer argument2) ->
            {
                result.add(argument1);
                result2.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 3L), PrimitiveTuples.pair(Integer.valueOf(3), 4L)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
    }

    @Test
    public void forEachWithIndex()
    {
        MutableBag<ObjectLongPair<Integer>> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        collection.forEachWithIndex((ObjectLongPair<Integer> object, int index) ->
            {
                elements.add(object);
                indexes.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 3L), PrimitiveTuples.pair(Integer.valueOf(3), 4L)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
    }

    @Test
    public void select()
    {
        MutableList<ObjectLongPair<Integer>> result = this.newWith(1, 2L, 2, 3L, 3, 4L).select(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3L))).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), 4L), result);
    }

    @Test
    public void selectWith()
    {
        MutableList<ObjectLongPair<Integer>> result = this.newWith(1, 2L, 2, 3L, 3, 4L).selectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), 4L), result);
    }

    @Test
    public void selectWith_target()
    {
        HashBag<ObjectLongPair<Integer>> result = this.newWith(1, 2L, 2, 3L, 3, 4L).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(Integer.valueOf(2), 3L), HashBag.<ObjectLongPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(3), 4L)), result);
    }

    @Test
    public void reject()
    {
        MutableList<ObjectLongPair<Integer>> result = this.newWith(1, 2L, 2, 3L, 3, 4L).reject(Predicates.notEqual(PrimitiveTuples.pair(Integer.valueOf(2), 3L))).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), 4L), result);
    }

    @Test
    public void rejectWith()
    {
        MutableList<ObjectLongPair<Integer>> result = this.newWith(1, 2L, 2, 3L, 3, 4L).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(Integer.valueOf(2), 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(1), 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(Integer.valueOf(3), 4L), result);
    }

    @Test
    public void rejectWith_target()
    {
        HashBag<ObjectLongPair<Integer>> result = this.newWith(1, 2L, 2, 3L, 3, 4L).rejectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3L), HashBag.<ObjectLongPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(3), 4L)), result);
    }

    @Test
    public void selectInstancesOf()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ObjectLongPair.class), PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(3), 4L), PrimitiveTuples.pair(Integer.valueOf(2), 3L));
    }

    @Test
    public void collect()
    {
        RichIterable<Integer> result1 =
            this.newWith(1, 2L, 2, 3L, 3, 4L).collect((ObjectLongPair<Integer> object) -> (int) object.getTwo());

        Assert.assertEquals(FastList.newListWith(2, 3, 4), result1.toList());
    }

    @Test
    public void collectBoolean()
    {
        BooleanIterable result = this.newWith(1, 2L, 2, 3L, 3, 4L) .collectBoolean(pair -> (pair.getTwo() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(false, true, true), result.toBag());
    }

    @Test
    public void collectByte()
    {
        ByteIterable result = this.newWith(1, 2L, 2, 3L, 3, 4L) .collectByte(pair -> (byte) pair.getTwo());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 2, (byte) 3, (byte) 4), result.toBag());
    }

    @Test
    public void collectChar()
    {
        CharIterable result = this.newWith(1, 2L, 2, 3L, 3, 4L) .collectChar(pair -> (char) pair.getTwo());
        Assert.assertEquals(CharHashBag.newBagWith((char) 2, (char) 4, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble()
    {
        DoubleIterable result = this.newWith(1, 2L, 2, 3L, 3, 4L).collectDouble(pair -> (double) pair.getTwo());
        Assert.assertEquals(DoubleHashBag.newBagWith(4.0, 3.0, 2.0), result.toBag());
    }

    @Test
    public void collectFloat()
    {
        FloatIterable result = this.newWith(1, 2L, 2, 3L, 3, 4L).collectFloat(pair -> (float) pair.getTwo());
        Assert.assertEquals(FloatHashBag.newBagWith(3.0f, 4.0f, 2.0f), result.toBag());
    }

    @Test
    public void collectInt()
    {
        IntIterable result = this.newWith(1, 2L, 2, 3L, 3, 4L).collectInt(pair -> (int) pair.getTwo());
        Assert.assertEquals(IntHashBag.newBagWith(2, 4, 3), result.toBag());
    }

    @Test
    public void collectLong()
    {
        LongIterable result = this.newWith(1, 2L, 2, 3L, 3, 4L).collectLong(pair -> (long) pair.getTwo());
        Assert.assertEquals(LongHashBag.newBagWith(4L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort()
    {
        ShortIterable result = this.newWith(1, 2L, 2, 3L, 3, 4L).collectShort(pair -> (short) pair.getTwo());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 2, (short) 4, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Function<ObjectLongPair<Integer>, MutableList<String>> function = pair -> FastList.newListWith(String.valueOf(pair));

        Verify.assertListsEqual(
                FastList.newListWith("1:2", "2:3", "3:4"),
                collection.flatCollect(function).toSortedList());

        Verify.assertSetsEqual(
                UnifiedSet.newSetWith("1:2", "2:3", "3:4"),
                collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect()
    {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3L), this.newWith(1, 2L, 2, 3L, 3, 4L).detect(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3L))));
        Assert.assertNull(this.newWith(1, 2L, 2, 3L, 3, 4L).detect(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(4)))));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws()
    {
        this.newWith().min(Comparators.naturalOrder());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws()
    {
        this.newWith().max(Comparators.naturalOrder());
    }

    @Test
    public void min()
    {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2L), this.newWith(1, 2L, 2, 3L, 3, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(3), 4L), this.newWith(1, 2L, 2, 3L, 3, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2L), this.newWith(1, 2L, 2, 3L, 3, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(3), 4L), this.newWith(1, 2L, 2, 3L, 3, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2L), this.newWith(1, 2L, 2, 3L, 3, 4L).minBy(pair -> (int) pair.getTwo() & 1));
    }

    @Test
    public void maxBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3L), this.newWith(1, 2L, 2, 3L, 3, 4L).maxBy(pair -> (int) pair.getTwo() & 1));
    }

    @Test
    public void detectWith()
    {
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3L), this.newWith(1, 2L, 2, 3L, 3, 4L).detectWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
        Assert.assertNull(this.newWith(1, 2L, 2, 3L, 3, 4L).detectWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(4))));
    }

    @Test
    public void detectIfNone()
    {
        Function0<ObjectLongPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(Integer.valueOf(5), 6L));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3L), this.newWith(1, 2L, 2, 3L, 3, 4L).detectIfNone(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3L)), function));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(5), 6L), this.newWith(1, 2L, 2, 3L, 3, 4L).detectIfNone(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(4))), function));
    }

    @Test
    public void detectWithIfNoneBlock()
    {
        Function0<ObjectLongPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(Integer.valueOf(5), 6L));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(2), 3L), this.newWith(1, 2L, 2, 3L, 3, 4L).detectWithIfNone(
                Object::equals,
                PrimitiveTuples.pair(Integer.valueOf(2), 3L),
                function));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(5), 6L), this.newWith(1, 2L, 2, 3L, 3, 4L).detectWithIfNone(
                Object::equals,
                PrimitiveTuples.pair(2L, Integer.valueOf(4)),
                function));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.newWith(1, 2L, 2, 3L, 3, 4L).allSatisfy(ObjectLongPair.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2L, 2, 3L, 3, 4L).allSatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3L))));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1, 2L, 2, 3L, 3, 4L).allSatisfyWith(Predicates2.instanceOf(), ObjectLongPair.class));
        Assert.assertFalse(this.newWith(1, 2L, 2, 3L, 3, 4L).allSatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.newWith(1, 2L, 2, 3L, 3, 4L).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2L, 2, 3L, 3, 4L).noneSatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3L))));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1, 2L, 2, 3L, 3, 4L).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1, 2L, 2, 3L, 3, 4L).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith(1, 2L, 2, 3L, 3, 4L).anySatisfy(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3L))));
        Assert.assertFalse(this.newWith(1, 2L, 2, 3L, 3, 4L).anySatisfy(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(5)))));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newWith(1, 2L, 2, 3L, 3, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
        Assert.assertFalse(this.newWith(1, 2L, 2, 3L, 3, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(5))));
    }

    @Test
    public void count()
    {
        Assert.assertEquals(0, this.newWith(1, 2L, 2, 3L, 3, 4L).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1, 2L, 2, 3L, 3, 4L).count(ObjectLongPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1, 2L, 2, 3L, 3, 4L).count(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3L))));
    }

    @Test
    public void countWith()
    {
        Assert.assertEquals(0, this.newWith(1, 2L, 2, 3L, 3, 4L).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1, 2L, 2, 3L, 3, 4L).countWith(Predicates2.instanceOf(), ObjectLongPair.class));
        Assert.assertEquals(1, this.newWith(1, 2L, 2, 3L, 3, 4L).countWith(Object::equals, PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
    }

    @Test
    public void collectIf()
    {
        Verify.assertContainsAll(
                this.newWith(1, 2L, 2, 3L, 3, 4L).collectIf(
                        ObjectLongPair.class::isInstance,
                        String::valueOf),
                "1:2", "2:3", "3:4");
        Verify.assertContainsAll(
                this.newWith(1, 2L, 2, 3L, 3, 4L).collectIf(
                        ObjectLongPair.class::isInstance,
                        String::valueOf,
                        UnifiedSet.<String>newSet()),
                "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith()
    {
        Assert.assertEquals(
                Bags.mutable.of(5L, 7L, 9L),
                this.newWith(1, 2L, 2, 3L, 3, 4L).collectWith((ObjectLongPair<Integer> argument1, Long argument2) -> (long) (argument1.getTwo() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target()
    {
        Assert.assertEquals(
                Bags.mutable.of(5L, 7L, 9L),
                this.newWith(1, 2L, 2, 3L, 3, 4L).collectWith((ObjectLongPair<Integer> argument1, Long argument2) -> (long) (argument1.getTwo() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst()
    {
        ObjectLongPair<Integer> first = this.newWith(1, 2L, 2, 3L, 3, 4L).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(Integer.valueOf(1), 2L).equals(first)
                || PrimitiveTuples.pair(Integer.valueOf(2), 3L).equals(first)
                || PrimitiveTuples.pair(Integer.valueOf(3), 4L).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2L), this.newWith(1, 2L).getFirst());
    }

    @Test
    public void getLast()
    {
        ObjectLongPair<Integer> last = this.newWith(1, 2L, 2, 3L, 3, 4L).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(Integer.valueOf(1), 2L).equals(last)
                || PrimitiveTuples.pair(Integer.valueOf(2), 3L).equals(last)
                || PrimitiveTuples.pair(Integer.valueOf(3), 4L).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(Integer.valueOf(1), 2L), this.newWith(1, 2L).getLast());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1, 2L));
        Assert.assertTrue(this.newWith(1, 2L).notEmpty());
    }

    @Test
    public void iterator()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        MutableBag<ObjectLongPair<Integer>> actual = Bags.mutable.of();
        Iterator<ObjectLongPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; )
        {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }

        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Iterator<ObjectLongPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; )
        {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test
    public void injectInto()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Long result = objects.injectInto(Long.valueOf(1L), (Long argument1, ObjectLongPair<Integer> argument2) -> (long) (argument1 + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(19), result);
    }

    @Test
    public void injectIntoInt()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        int result = objects.injectInto(1, (int intParameter, ObjectLongPair<Integer> argument2) -> (int) (intParameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19, result);
    }

    @Test
    public void injectIntoLong()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        long result = objects.injectInto(1L, (long parameter, ObjectLongPair<Integer> argument2) -> (long) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19, result);
    }

    @Test
    public void injectIntoDouble()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        double result = objects.injectInto(1.0, (double parameter, ObjectLongPair<Integer> argument2) -> (double) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        float result = objects.injectInto(1.0f, (float parameter, ObjectLongPair<Integer> argument2) -> (float) (parameter + argument2.getTwo() + argument2.getTwo()));
        Assert.assertEquals(19.0, result, 0.0);
    }

    @Test
    public void sumFloat()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        double actual = objects.sumOfFloat(pair -> (float) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18.0, actual, 0.0);
    }

    @Test
    public void sumDouble()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        double actual = objects.sumOfDouble(pair -> (double) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18.0, actual, 0.0);
    }

    @Test
    public void sumInteger()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        long actual = objects.sumOfInt(pair -> (int) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18, actual);
    }

    @Test
    public void sumLong()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        long actual = objects.sumOfLong(pair -> (long) (pair.getTwo() + pair.getTwo()));
        Assert.assertEquals(18, actual);
    }

    @Test
    public void toArray()
    {
        RichIterable<ObjectLongPair<Integer>> objects = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ObjectLongPair<Integer>[] array2 = objects.toArray(new ObjectLongPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition()
    {
        PartitionIterable<ObjectLongPair<Integer>> result = this.newWith(1, 2L, 2, 3L, 3, 4L).partition(Predicates.equal(PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(2), 3L), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(1), 2L), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(Integer.valueOf(3), 4L), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList()
    {
        MutableList<ObjectLongPair<Integer>> list = this.newWith(1, 2L, 2, 3L, 3, 4L).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 3L), PrimitiveTuples.pair(Integer.valueOf(3), 4L));
    }

    @Test
    public void toBag()
    {
        MutableBag<ObjectLongPair<Integer>> bag = this.newWith(1, 2L, 2, 3L, 3, 4L).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 3L), PrimitiveTuples.pair(Integer.valueOf(3), 4L));
    }

    @Test
    public void toSortedList_natural_ordering()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableList<ObjectLongPair<Integer>> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 4L), PrimitiveTuples.pair(Integer.valueOf(5), 3L)), list);
    }

    @Test
    public void toSortedList_with_comparator()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableList<ObjectLongPair<Integer>> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(5), 3L), PrimitiveTuples.pair(Integer.valueOf(2), 4L), PrimitiveTuples.pair(Integer.valueOf(1), 2L)), list);
    }

    @Test
    public void toSortedListBy()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableList<ObjectLongPair<Integer>> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 4L), PrimitiveTuples.pair(Integer.valueOf(5), 3L)), list);
    }

    @Test
    public void toSortedBag_natural_ordering()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableSortedBag<ObjectLongPair<Integer>> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 4L), PrimitiveTuples.pair(Integer.valueOf(5), 3L)), bag);
    }

    @Test
    public void toSortedBag_with_comparator()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableSortedBag<ObjectLongPair<Integer>> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(Integer.valueOf(5), 3L), PrimitiveTuples.pair(Integer.valueOf(2), 4L), PrimitiveTuples.pair(Integer.valueOf(1), 2L)), bag);
    }

    @Test
    public void toSortedBagBy()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableSortedBag<ObjectLongPair<Integer>> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 4L), PrimitiveTuples.pair(Integer.valueOf(5), 3L)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableSortedSet<ObjectLongPair<Integer>> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 4L), PrimitiveTuples.pair(Integer.valueOf(5), 3L)), set);
    }

    @Test
    public void toSortedSet_with_comparator()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableSortedSet<ObjectLongPair<Integer>> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(),
                PrimitiveTuples.pair(Integer.valueOf(5), 3L),
                PrimitiveTuples.pair(Integer.valueOf(2), 4L),
                PrimitiveTuples.pair(Integer.valueOf(1), 2L)),
                set);
    }

    @Test
    public void toSortedSetBy()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(5, 3L, 1, 2L, 2, 4L);
        MutableSortedSet<ObjectLongPair<Integer>> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 4L), PrimitiveTuples.pair(Integer.valueOf(5), 3L)), set);
    }

    @Test
    public void toSet()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(1, 2L, 2, 3L, 3, 4L);
        MutableSet<ObjectLongPair<Integer>> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(Integer.valueOf(1), 2L), PrimitiveTuples.pair(Integer.valueOf(2), 3L), PrimitiveTuples.pair(Integer.valueOf(3), 4L));
    }

    @Test
    public void toMap()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(1, 2L, 2, 3L, 3, 4L);
        MutableMap<String, String> map =
                pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(1, 2L, 2, 3L, 3, 4L);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(1, 2L, 2, 3L, 3, 4L);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy()
    {
        RichIterable<ObjectLongPair<Integer>> pairs = this.newWith(1, 2L, 2, 3L, 3, 4L);
        MutableSortedMap<String, String> map =
                pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString())
                || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Function<ObjectLongPair<Integer>, Boolean> function = pair -> PrimitiveTuples.pair(Integer.valueOf(1), 2L).equals(pair);

        Multimap<Boolean, ObjectLongPair<Integer>> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(Integer.valueOf(1), 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(3), 4L)));
    }

    @Test
    public void groupByEach()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Function<ObjectLongPair<Integer>, MutableList<Boolean>> function = pair -> Lists.mutable.of(PrimitiveTuples.pair(Integer.valueOf(1), 2L).equals(pair));

        Multimap<Boolean, ObjectLongPair<Integer>> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(Integer.valueOf(1), 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(2), 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(Integer.valueOf(3), 4L)));
    }

    @Test
    public void zip()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L);
        RichIterable<Pair<ObjectLongPair<Integer>, Integer>> result = collection.zip(Interval.oneTo(5));

        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), 2L), 1), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), 3L), 2)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), 3L), 1), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), 2L), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L);
        RichIterable<Pair<ObjectLongPair<Integer>, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), 2L), 0), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), 3L), 1)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(2), 3L), 0), Tuples.pair(PrimitiveTuples.pair(Integer.valueOf(1), 2L), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(1), 2L)),
                FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(2), 3L)),
                FastList.newListWith(PrimitiveTuples.pair(Integer.valueOf(3), 4L))),
                collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size()
    {
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        Verify.assertIterableSize(3, collection.chunk(10).getFirst());
    }

    @Test
    public void empty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Assert.assertTrue(this.newWith().isEmpty());
        Assert.assertFalse(this.newWith().notEmpty());
    }

    @Test
    public void notEmpty()
    {
        RichIterable<ObjectLongPair<Integer>> notEmpty = this.newWith(1, 2L);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ObjectLongPair<Integer>> sumAggregator = (aggregate, pair) -> { aggregate.addAndGet((int) pair.getTwo()); };
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 2L, 2, 3L, 3, 4L);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(4, aggregation.get("3:4").intValue());
        Assert.assertEquals(3, aggregation.get("2:3").intValue());
        Assert.assertEquals(2, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ObjectLongPair<Integer>, Integer> sumAggregator = (aggregate, pair) -> (int) (aggregate + pair.getTwo());
        RichIterable<ObjectLongPair<Integer>> collection = this.newWith(1, 1L, 1, 2L, 2, 3L);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("2:3").intValue());
        Assert.assertEquals(2, aggregation.get("1:2").intValue());
    }
}
