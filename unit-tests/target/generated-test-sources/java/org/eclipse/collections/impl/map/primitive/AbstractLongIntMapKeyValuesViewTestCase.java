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
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.LongIntMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.LongIntPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
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
 * Abstract JUnit test for {@link LongIntMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractLongIntMapKeyValuesViewTestCase
{
    public abstract LongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3);

    public abstract LongIntMap newWithKeysValues(long key1, int value1, long key2, int value2);

    public abstract LongIntMap newWithKeysValues(long key1, int value1);

    public abstract LongIntMap newEmpty();

    public RichIterable<LongIntPair> newWith()
    {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<LongIntPair> newWith(long key1, int value1)
    {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<LongIntPair> newWith(long key1, int value1, long key2, int value2)
    {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<LongIntPair> newWith(long key1, int value1, long key2, int value2, long key3, int value3)
    {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(1L, 5))));
    }

    @Test
    public void containsAllArray()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(1L, 5)));
    }

    @Test
    public void forEach()
    {
        MutableList<LongIntPair> result = Lists.mutable.of();
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4));

        MutableList<LongIntPair> result2 = Lists.mutable.of();
        RichIterable<LongIntPair> collection2 = this.newWith(0L, 2, 2L, 3, 3L, 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4));
    }

    @Test
    public void forEachWith()
    {
        MutableBag<LongIntPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<LongIntPair> collection = this.newWith(1L, 0, 2L, 3, 3L, 4);
        collection.forEachWith((LongIntPair argument1, Integer argument2) ->
            {
                result.add(argument1);
                result2.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 0), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);

        MutableBag<LongIntPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<LongIntPair> collection2 = this.newWith(2L, 5, 6L, 3, 3L, 4);
        collection2.forEachWith((LongIntPair argument1, Integer argument2) ->
            {
                result3.add(argument1);
                result4.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2L, 5), PrimitiveTuples.pair(6L, 3), PrimitiveTuples.pair(3L, 4)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex()
    {
        MutableBag<LongIntPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<LongIntPair> collection = this.newWith(2L, 2, 6L, 3, 3L, 4);
        collection.forEachWithIndex((LongIntPair object, int index) ->
            {
                elements.add(object);
                indexes.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2L, 2), PrimitiveTuples.pair(6L, 3), PrimitiveTuples.pair(3L, 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);

        MutableBag<LongIntPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<LongIntPair> collection2 = this.newWith(0L, 1, 2L, 3, 3L, 4);
        collection2.forEachWithIndex((LongIntPair object, int index) ->
            {
                elements2.add(object);
                indexes2.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0L, 1), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select()
    {
        MutableList<LongIntPair> result = this.newWith(1L, 2, 2L, 3, 3L, 4).select(PrimitiveTuples.pair(2L, 3)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4), result);
    }

    @Test
    public void selectWith()
    {
        MutableList<LongIntPair> result = this.newWith(1L, 2, 2L, 3, 3L, 4).selectWith(Object::equals, PrimitiveTuples.pair(2L, 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4), result);
    }

    @Test
    public void selectWith_target()
    {
        HashBag<LongIntPair> result = this.newWith(1L, 2, 2L, 3, 3L, 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, 3), HashBag.<LongIntPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(3L, 4)), result);
    }

    @Test
    public void reject()
    {
        MutableList<LongIntPair> result = this.newWith(1L, 2, 2L, 3, 3L, 4).reject(Predicates.notEqual(PrimitiveTuples.pair(2L, 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4), result);
    }

    @Test
    public void rejectWith()
    {
        MutableList<LongIntPair> result = this.newWith(1L, 2, 2L, 3, 3L, 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4), result);
    }

    @Test
    public void rejectWith_target()
    {
        HashBag<LongIntPair> result = this.newWith(1L, 2, 2L, 3, 3L, 4).rejectWith(Object::equals, PrimitiveTuples.pair(2L, 3), HashBag.<LongIntPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(3L, 4)), result);
    }

    @Test
    public void selectInstancesOf()
    {
        RichIterable<LongIntPair> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(LongIntPair.class), PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(3L, 4), PrimitiveTuples.pair(2L, 3));
    }

    @Test
    public void collect()
    {
        RichIterable<Integer> result1 =
            this.newWith(1L, 2, 2L, 3, 3L, 4).collect((LongIntPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 =
            this.newWith(1L, 2, 2L, 3, 3L, 4).collect((LongIntPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean()
    {
        BooleanIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectBoolean((LongIntPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte()
    {
        ByteIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectByte((LongIntPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar()
    {
        CharIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectChar((LongIntPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble()
    {
        DoubleIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectDouble((LongIntPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat()
    {
        FloatIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectFloat((LongIntPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt()
    {
        IntIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectInt((LongIntPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong()
    {
        LongIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectLong((LongIntPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort()
    {
        ShortIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectShort((LongIntPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Function<LongIntPair, MutableList<String>> function = (LongIntPair object) -> FastList.newListWith(String.valueOf(object));

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
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3), this.newWith(1L, 2, 2L, 3, 3L, 4).detect(PrimitiveTuples.pair(2L, 3)::equals));
        Assert.assertNull(this.newWith(1L, 2, 2L, 3, 3L, 4).detect(PrimitiveTuples.pair(2L, 4)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2), this.newWith(1L, 2, 2L, 3, 3L, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3L, 4), this.newWith(1L, 2, 2L, 3, 3L, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2), this.newWith(1L, 2, 2L, 3, 3L, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3L, 4), this.newWith(1L, 2, 2L, 3, 3L, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3), this.newWith(1L, 2, 2L, 3, 3L, 4).minBy((LongIntPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2), this.newWith(1L, 2, 2L, 3, 4L, 5).maxBy((LongIntPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3), this.newWith(1L, 2, 2L, 3, 3L, 4).detectWith(Object::equals, PrimitiveTuples.pair(2L, 3)));
        Assert.assertNull(this.newWith(1L, 2, 2L, 3, 3L, 4).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone()
    {
        Function0<LongIntPair> function = Functions0.value(PrimitiveTuples.pair(5L, 6));
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3), this.newWith(1L, 2, 2L, 3, 3L, 4).detectIfNone(PrimitiveTuples.pair(2L, 3)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, 6), this.newWith(1L, 2, 2L, 3, 3L, 4).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock()
    {
        Function0<LongIntPair> function = Functions0.value(PrimitiveTuples.pair(5L, 6));
        Assert.assertEquals(
            PrimitiveTuples.pair(2L, 3),
            this.newWith(1L, 2, 2L, 3, 3L, 4).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2L, 3),
                    function));
        Assert.assertEquals(
            PrimitiveTuples.pair(5L, 6),
            this.newWith(1L, 2, 2L, 3, 3L, 4).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2, 4L),
                    function));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).allSatisfy(LongIntPair.class::isInstance));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).allSatisfy(PrimitiveTuples.pair(2L, 3)::equals));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).allSatisfyWith(Predicates2.instanceOf(), LongIntPair.class));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).noneSatisfy(PrimitiveTuples.pair(2L, 3)::equals));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).anySatisfy(PrimitiveTuples.pair(2L, 3)::equals));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).anySatisfy(PrimitiveTuples.pair(2L, 5)::equals));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3)));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 5)));
    }

    @Test
    public void count()
    {
        Assert.assertEquals(0, this.newWith(1L, 2, 2L, 3, 3L, 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1L, 2, 2L, 3, 3L, 4).count(LongIntPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1L, 2, 2L, 3, 3L, 4).count(PrimitiveTuples.pair(2L, 3)::equals));
    }

    @Test
    public void countWith()
    {
        Assert.assertEquals(0, this.newWith(1L, 2, 2L, 3, 3L, 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1L, 2, 2L, 3, 3L, 4).countWith(Predicates2.instanceOf(), LongIntPair.class));
        Assert.assertEquals(1, this.newWith(1L, 2, 2L, 3, 3L, 4).countWith(Object::equals, PrimitiveTuples.pair(2L, 3)));
    }

    @Test
    public void collectIf()
    {
        Verify.assertContainsAll(
                this.newWith(1L, 2, 2L, 3, 3L, 4).collectIf(
                        LongIntPair.class::isInstance,
                        String::valueOf),
                "1:2", "2:3", "3:4");
        Verify.assertContainsAll(
                this.newWith(1L, 2, 2L, 3, 3L, 4).collectIf(
                        LongIntPair.class::isInstance,
                        String::valueOf,
                        UnifiedSet.<String>newSet()),
                "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith(1L, 2, 2L, 3, 3L, 4).collectWith((LongIntPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith(1L, 2, 2L, 3, 3L, 4).collectWith((LongIntPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst()
    {
        LongIntPair first = this.newWith(1L, 2, 2L, 3, 3L, 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1L, 2).equals(first)
                || PrimitiveTuples.pair(2L, 3).equals(first)
                || PrimitiveTuples.pair(3L, 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2), this.newWith(1L, 2).getFirst());
    }

    @Test
    public void getLast()
    {
        LongIntPair last = this.newWith(1L, 2, 2L, 3, 3L, 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1L, 2).equals(last)
                || PrimitiveTuples.pair(2L, 3).equals(last)
                || PrimitiveTuples.pair(3L, 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2), this.newWith(1L, 2).getLast());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1L, 2));
        Assert.assertTrue(this.newWith(1L, 2).notEmpty());
    }

    @Test
    public void iterator()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 0L, 3, 3L, 4);
        MutableBag<LongIntPair> actual = Bags.mutable.of();
        Iterator<LongIntPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; )
        {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels()
    {
        RichIterable<LongIntPair> objects = this.newWith(2L, 3, 4L, 3, 3L, 4);
        MutableBag<LongIntPair> actual = Bags.mutable.of();
        Iterator<LongIntPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; )
        {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Iterator<LongIntPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; )
        {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Iterator<LongIntPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Long result = objects.injectInto(1L, (Long argument1, LongIntPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        int result = objects.injectInto(1, (int intParameter, LongIntPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        long result = objects.injectInto(1L, (long parameter, LongIntPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        double result = objects.injectInto(1.0, (double parameter, LongIntPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        float result = objects.injectInto(1.0f, (float parameter, LongIntPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        double actual = objects.sumOfFloat((LongIntPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        double actual = objects.sumOfDouble((LongIntPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        long actual = objects.sumOfInt((LongIntPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        long actual = objects.sumOfLong((LongIntPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray()
    {
        RichIterable<LongIntPair> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        LongIntPair[] array2 = objects.toArray(new LongIntPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition()
    {
        PartitionIterable<LongIntPair> result = this.newWith(1L, 2, 2L, 3, 3L, 4).partition(PrimitiveTuples.pair(2L, 3)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2L, 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1L, 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3L, 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList()
    {
        MutableList<LongIntPair> list = this.newWith(1L, 2, 2L, 3, 3L, 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4));
    }

    @Test
    public void toBag()
    {
        MutableBag<LongIntPair> bag = this.newWith(1L, 2, 2L, 3, 3L, 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4));
    }

    @Test
    public void toSortedList_natural_ordering()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableList<LongIntPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4)), list);
    }

    @Test
    public void toSortedList_with_comparator()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableList<LongIntPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3L, 4), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(1L, 2)), list);
    }

    @Test
    public void toSortedListBy()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableList<LongIntPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4)), list);
    }

    @Test
    public void toSortedBag_natural_ordering()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedBag<LongIntPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4)), bag);
    }

    @Test
    public void toSortedBag_with_comparator()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedBag<LongIntPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, 4), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(1L, 2)), bag);
    }

    @Test
    public void toSortedBagBy()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedBag<LongIntPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedSet<LongIntPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4)), set);
    }

    @Test
    public void toSortedSet_with_comparator()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedSet<LongIntPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(),
                PrimitiveTuples.pair(3L, 4),
                PrimitiveTuples.pair(2L, 3),
                PrimitiveTuples.pair(1L, 2)),
                set);
    }

    @Test
    public void toSortedSetBy()
    {
        RichIterable<LongIntPair> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedSet<LongIntPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4)), set);
    }

    @Test
    public void toSet()
    {
        RichIterable<LongIntPair> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableSet<LongIntPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1L, 2), PrimitiveTuples.pair(2L, 3), PrimitiveTuples.pair(3L, 4));
    }

    @Test
    public void toMap()
    {
        RichIterable<LongIntPair> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableMap<String, String> map =
                pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap()
    {
        RichIterable<LongIntPair> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator()
    {
        RichIterable<LongIntPair> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy()
    {
        RichIterable<LongIntPair> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableSortedMap<String, String> map =
                pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString())
                || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Function<LongIntPair, Boolean> function = (LongIntPair object) -> PrimitiveTuples.pair(1L, 2).equals(object);

        Multimap<Boolean, LongIntPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, 4)));
    }

    @Test
    public void groupByEach()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Function<LongIntPair, MutableList<Boolean>> function = (LongIntPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1L, 2).equals(object));

        Multimap<Boolean, LongIntPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, 4)));
    }

    @Test
    public void zip()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3);
        RichIterable<Pair<LongIntPair, Integer>> result = collection.zip(Interval.oneTo(5));

        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, 2), 1), Tuples.pair(PrimitiveTuples.pair(2L, 3), 2)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, 3), 1), Tuples.pair(PrimitiveTuples.pair(1L, 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3);
        RichIterable<Pair<LongIntPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, 2), 0), Tuples.pair(PrimitiveTuples.pair(2L, 3), 1)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, 3), 0), Tuples.pair(PrimitiveTuples.pair(1L, 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1L, 2)),
                FastList.newListWith(PrimitiveTuples.pair(2L, 3)),
                FastList.newListWith(PrimitiveTuples.pair(3L, 4))),
                collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size()
    {
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
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
        RichIterable<LongIntPair> notEmpty = this.newWith(1L, 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, LongIntPair> sumAggregator = (AtomicInteger aggregate, LongIntPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<LongIntPair> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, LongIntPair, Integer> sumAggregator = (Integer aggregate, LongIntPair value) -> (int) (aggregate + value.getOne());
        RichIterable<LongIntPair> collection = this.newWith(1L, 1, 1L, 2, 2L, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }
}
