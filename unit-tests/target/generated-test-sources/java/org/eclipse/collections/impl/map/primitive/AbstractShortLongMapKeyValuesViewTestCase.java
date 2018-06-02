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
import org.eclipse.collections.api.map.primitive.ShortLongMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ShortLongPair;
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
 * Abstract JUnit test for {@link ShortLongMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractShortLongMapKeyValuesViewTestCase
{
    public abstract ShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3);

    public abstract ShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2);

    public abstract ShortLongMap newWithKeysValues(short key1, long value1);

    public abstract ShortLongMap newEmpty();

    public RichIterable<ShortLongPair> newWith()
    {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<ShortLongPair> newWith(short key1, long value1)
    {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<ShortLongPair> newWith(short key1, long value1, short key2, long value2)
    {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<ShortLongPair> newWith(short key1, long value1, short key2, long value2, short key3, long value3)
    {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 1, 5L))));
    }

    @Test
    public void containsAllArray()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 1, 5L)));
    }

    @Test
    public void forEach()
    {
        MutableList<ShortLongPair> result = Lists.mutable.of();
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L));

        MutableList<ShortLongPair> result2 = Lists.mutable.of();
        RichIterable<ShortLongPair> collection2 = this.newWith((short) 0, 2L, (short) 2, 3L, (short) 3, 4L);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((short) 0, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L));
    }

    @Test
    public void forEachWith()
    {
        MutableBag<ShortLongPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 0L, (short) 2, 3L, (short) 3, 4L);
        collection.forEachWith((ShortLongPair argument1, Integer argument2) ->
            {
                result.add(argument1);
                result2.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, 0L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);

        MutableBag<ShortLongPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<ShortLongPair> collection2 = this.newWith((short) 2, 5L, (short) 6, 3L, (short) 3, 4L);
        collection2.forEachWith((ShortLongPair argument1, Integer argument2) ->
            {
                result3.add(argument1);
                result4.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 2, 5L), PrimitiveTuples.pair((short) 6, 3L), PrimitiveTuples.pair((short) 3, 4L)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex()
    {
        MutableBag<ShortLongPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ShortLongPair> collection = this.newWith((short) 2, 2L, (short) 6, 3L, (short) 3, 4L);
        collection.forEachWithIndex((ShortLongPair object, int index) ->
            {
                elements.add(object);
                indexes.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((short) 2, 2L), PrimitiveTuples.pair((short) 6, 3L), PrimitiveTuples.pair((short) 3, 4L)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);

        MutableBag<ShortLongPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<ShortLongPair> collection2 = this.newWith((short) 0, 1L, (short) 2, 3L, (short) 3, 4L);
        collection2.forEachWithIndex((ShortLongPair object, int index) ->
            {
                elements2.add(object);
                indexes2.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((short) 0, 1L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select()
    {
        MutableList<ShortLongPair> result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).select(PrimitiveTuples.pair((short) 2, 3L)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, 4L), result);
    }

    @Test
    public void selectWith()
    {
        MutableList<ShortLongPair> result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).selectWith(Object::equals, PrimitiveTuples.pair((short) 2, 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, 4L), result);
    }

    @Test
    public void selectWith_target()
    {
        HashBag<ShortLongPair> result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((short) 2, 3L), HashBag.<ShortLongPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 3, 4L)), result);
    }

    @Test
    public void reject()
    {
        MutableList<ShortLongPair> result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).reject(Predicates.notEqual(PrimitiveTuples.pair((short) 2, 3L))).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, 4L), result);
    }

    @Test
    public void rejectWith()
    {
        MutableList<ShortLongPair> result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((short) 2, 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, 4L), result);
    }

    @Test
    public void rejectWith_target()
    {
        HashBag<ShortLongPair> result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).rejectWith(Object::equals, PrimitiveTuples.pair((short) 2, 3L), HashBag.<ShortLongPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 3, 4L)), result);
    }

    @Test
    public void selectInstancesOf()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ShortLongPair.class), PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 3, 4L), PrimitiveTuples.pair((short) 2, 3L));
    }

    @Test
    public void collect()
    {
        RichIterable<Integer> result1 =
            this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collect((ShortLongPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 =
            this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collect((ShortLongPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean()
    {
        BooleanIterable result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectBoolean((ShortLongPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte()
    {
        ByteIterable result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectByte((ShortLongPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar()
    {
        CharIterable result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectChar((ShortLongPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble()
    {
        DoubleIterable result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectDouble((ShortLongPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat()
    {
        FloatIterable result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectFloat((ShortLongPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt()
    {
        IntIterable result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectInt((ShortLongPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong()
    {
        LongIterable result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectLong((ShortLongPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort()
    {
        ShortIterable result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectShort((ShortLongPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Function<ShortLongPair, MutableList<String>> function = (ShortLongPair object) -> FastList.newListWith(String.valueOf(object));

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
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).detect(PrimitiveTuples.pair((short) 2, 3L)::equals));
        Assert.assertNull(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).detect(PrimitiveTuples.pair((short) 2, 4L)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(PrimitiveTuples.pair((short) 3, 4L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair((short) 3, 4L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).minBy((ShortLongPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 4, 5L).maxBy((ShortLongPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith()
    {
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).detectWith(Object::equals, PrimitiveTuples.pair((short) 2, 3L)));
        Assert.assertNull(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone()
    {
        Function0<ShortLongPair> function = Functions0.value(PrimitiveTuples.pair((short) 5, 6L));
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, 3L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).detectIfNone(PrimitiveTuples.pair((short) 2, 3L)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((short) 5, 6L), this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock()
    {
        Function0<ShortLongPair> function = Functions0.value(PrimitiveTuples.pair((short) 5, 6L));
        Assert.assertEquals(
            PrimitiveTuples.pair((short) 2, 3L),
            this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair((short) 2, 3L),
                    function));
        Assert.assertEquals(
            PrimitiveTuples.pair((short) 5, 6L),
            this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2, 4L),
                    function));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).allSatisfy(ShortLongPair.class::isInstance));
        Assert.assertFalse(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).allSatisfy(PrimitiveTuples.pair((short) 2, 3L)::equals));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).allSatisfyWith(Predicates2.instanceOf(), ShortLongPair.class));
        Assert.assertFalse(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).allSatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, 3L)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).noneSatisfy(PrimitiveTuples.pair((short) 2, 3L)::equals));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, 3L)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).anySatisfy(PrimitiveTuples.pair((short) 2, 3L)::equals));
        Assert.assertFalse(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).anySatisfy(PrimitiveTuples.pair((short) 2, 5L)::equals));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, 3L)));
        Assert.assertFalse(this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, 5L)));
    }

    @Test
    public void count()
    {
        Assert.assertEquals(0, this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).count(ShortLongPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).count(PrimitiveTuples.pair((short) 2, 3L)::equals));
    }

    @Test
    public void countWith()
    {
        Assert.assertEquals(0, this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).countWith(Predicates2.instanceOf(), ShortLongPair.class));
        Assert.assertEquals(1, this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).countWith(Object::equals, PrimitiveTuples.pair((short) 2, 3L)));
    }

    @Test
    public void collectIf()
    {
        Verify.assertContainsAll(
                this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectIf(
                        ShortLongPair.class::isInstance,
                        String::valueOf),
                "1:2", "2:3", "3:4");
        Verify.assertContainsAll(
                this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectIf(
                        ShortLongPair.class::isInstance,
                        String::valueOf,
                        UnifiedSet.<String>newSet()),
                "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectWith((ShortLongPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).collectWith((ShortLongPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst()
    {
        ShortLongPair first = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((short) 1, 2L).equals(first)
                || PrimitiveTuples.pair((short) 2, 3L).equals(first)
                || PrimitiveTuples.pair((short) 3, 4L).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2L), this.newWith((short) 1, 2L).getFirst());
    }

    @Test
    public void getLast()
    {
        ShortLongPair last = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((short) 1, 2L).equals(last)
                || PrimitiveTuples.pair((short) 2, 3L).equals(last)
                || PrimitiveTuples.pair((short) 3, 4L).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, 2L), this.newWith((short) 1, 2L).getLast());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((short) 1, 2L));
        Assert.assertTrue(this.newWith((short) 1, 2L).notEmpty());
    }

    @Test
    public void iterator()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 0, 3L, (short) 3, 4L);
        MutableBag<ShortLongPair> actual = Bags.mutable.of();
        Iterator<ShortLongPair> iterator = objects.iterator();
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
        RichIterable<ShortLongPair> objects = this.newWith((short) 2, 3L, (short) 4, 3L, (short) 3, 4L);
        MutableBag<ShortLongPair> actual = Bags.mutable.of();
        Iterator<ShortLongPair> iterator = objects.iterator();
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
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Iterator<ShortLongPair> iterator = objects.iterator();
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
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Iterator<ShortLongPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Long result = objects.injectInto(1L, (Long argument1, ShortLongPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        int result = objects.injectInto(1, (int intParameter, ShortLongPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        long result = objects.injectInto(1L, (long parameter, ShortLongPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        double result = objects.injectInto(1.0, (double parameter, ShortLongPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        float result = objects.injectInto(1.0f, (float parameter, ShortLongPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        double actual = objects.sumOfFloat((ShortLongPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        double actual = objects.sumOfDouble((ShortLongPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        long actual = objects.sumOfInt((ShortLongPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        long actual = objects.sumOfLong((ShortLongPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray()
    {
        RichIterable<ShortLongPair> objects = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ShortLongPair[] array2 = objects.toArray(new ShortLongPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition()
    {
        PartitionIterable<ShortLongPair> result = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).partition(PrimitiveTuples.pair((short) 2, 3L)::equals);
        Verify.assertContains(PrimitiveTuples.pair((short) 2, 3L), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((short) 1, 2L), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((short) 3, 4L), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList()
    {
        MutableList<ShortLongPair> list = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L));
    }

    @Test
    public void toBag()
    {
        MutableBag<ShortLongPair> bag = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L));
    }

    @Test
    public void toSortedList_natural_ordering()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableList<ShortLongPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L)), list);
    }

    @Test
    public void toSortedList_with_comparator()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableList<ShortLongPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 3, 4L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 1, 2L)), list);
    }

    @Test
    public void toSortedListBy()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableList<ShortLongPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L)), list);
    }

    @Test
    public void toSortedBag_natural_ordering()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableSortedBag<ShortLongPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L)), bag);
    }

    @Test
    public void toSortedBag_with_comparator()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableSortedBag<ShortLongPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((short) 3, 4L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 1, 2L)), bag);
    }

    @Test
    public void toSortedBagBy()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableSortedBag<ShortLongPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableSortedSet<ShortLongPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L)), set);
    }

    @Test
    public void toSortedSet_with_comparator()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableSortedSet<ShortLongPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(),
                PrimitiveTuples.pair((short) 3, 4L),
                PrimitiveTuples.pair((short) 2, 3L),
                PrimitiveTuples.pair((short) 1, 2L)),
                set);
    }

    @Test
    public void toSortedSetBy()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 2, 3L, (short) 1, 2L, (short) 3, 4L);
        MutableSortedSet<ShortLongPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L)), set);
    }

    @Test
    public void toSet()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        MutableSet<ShortLongPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((short) 1, 2L), PrimitiveTuples.pair((short) 2, 3L), PrimitiveTuples.pair((short) 3, 4L));
    }

    @Test
    public void toMap()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        MutableMap<String, String> map =
                pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy()
    {
        RichIterable<ShortLongPair> pairs = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        MutableSortedMap<String, String> map =
                pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString())
                || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Function<ShortLongPair, Boolean> function = (ShortLongPair object) -> PrimitiveTuples.pair((short) 1, 2L).equals(object);

        Multimap<Boolean, ShortLongPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((short) 1, 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 2, 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 3, 4L)));
    }

    @Test
    public void groupByEach()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Function<ShortLongPair, MutableList<Boolean>> function = (ShortLongPair object) -> Lists.mutable.of(PrimitiveTuples.pair((short) 1, 2L).equals(object));

        Multimap<Boolean, ShortLongPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((short) 1, 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 2, 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 3, 4L)));
    }

    @Test
    public void zip()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L);
        RichIterable<Pair<ShortLongPair, Integer>> result = collection.zip(Interval.oneTo(5));

        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 1, 2L), 1), Tuples.pair(PrimitiveTuples.pair((short) 2, 3L), 2)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 2, 3L), 1), Tuples.pair(PrimitiveTuples.pair((short) 1, 2L), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L);
        RichIterable<Pair<ShortLongPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 1, 2L), 0), Tuples.pair(PrimitiveTuples.pair((short) 2, 3L), 1)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 2, 3L), 0), Tuples.pair(PrimitiveTuples.pair((short) 1, 2L), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((short) 1, 2L)),
                FastList.newListWith(PrimitiveTuples.pair((short) 2, 3L)),
                FastList.newListWith(PrimitiveTuples.pair((short) 3, 4L))),
                collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size()
    {
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
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
        RichIterable<ShortLongPair> notEmpty = this.newWith((short) 1, 2L);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ShortLongPair> sumAggregator = (AtomicInteger aggregate, ShortLongPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 2L, (short) 2, 3L, (short) 3, 4L);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ShortLongPair, Integer> sumAggregator = (Integer aggregate, ShortLongPair value) -> (int) (aggregate + value.getOne());
        RichIterable<ShortLongPair> collection = this.newWith((short) 1, 1L, (short) 1, 2L, (short) 2, 3L);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }
}
