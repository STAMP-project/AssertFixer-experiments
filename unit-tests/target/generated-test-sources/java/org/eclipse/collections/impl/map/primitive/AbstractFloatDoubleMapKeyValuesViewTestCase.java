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
import org.eclipse.collections.api.map.primitive.FloatDoubleMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.FloatDoublePair;
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
 * Abstract JUnit test for {@link FloatDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractFloatDoubleMapKeyValuesViewTestCase
{
    public abstract FloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3);

    public abstract FloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2);

    public abstract FloatDoubleMap newWithKeysValues(float key1, double value1);

    public abstract FloatDoubleMap newEmpty();

    public RichIterable<FloatDoublePair> newWith()
    {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<FloatDoublePair> newWith(float key1, double value1)
    {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<FloatDoublePair> newWith(float key1, double value1, float key2, double value2)
    {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<FloatDoublePair> newWith(float key1, double value1, float key2, double value2, float key3, double value3)
    {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(1.0f, 5.0))));
    }

    @Test
    public void containsAllArray()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(1.0f, 5.0)));
    }

    @Test
    public void forEach()
    {
        MutableList<FloatDoublePair> result = Lists.mutable.of();
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0));

        MutableList<FloatDoublePair> result2 = Lists.mutable.of();
        RichIterable<FloatDoublePair> collection2 = this.newWith(0.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0));
    }

    @Test
    public void forEachWith()
    {
        MutableBag<FloatDoublePair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 0.0, 2.0f, 3.0, 3.0f, 4.0);
        collection.forEachWith((FloatDoublePair argument1, Integer argument2) ->
            {
                result.add(argument1);
                result2.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, 0.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);

        MutableBag<FloatDoublePair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<FloatDoublePair> collection2 = this.newWith(2.0f, 5.0, 6.0f, 3.0, 3.0f, 4.0);
        collection2.forEachWith((FloatDoublePair argument1, Integer argument2) ->
            {
                result3.add(argument1);
                result4.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2.0f, 5.0), PrimitiveTuples.pair(6.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex()
    {
        MutableBag<FloatDoublePair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<FloatDoublePair> collection = this.newWith(2.0f, 2.0, 6.0f, 3.0, 3.0f, 4.0);
        collection.forEachWithIndex((FloatDoublePair object, int index) ->
            {
                elements.add(object);
                indexes.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2.0f, 2.0), PrimitiveTuples.pair(6.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);

        MutableBag<FloatDoublePair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<FloatDoublePair> collection2 = this.newWith(0.0f, 1.0, 2.0f, 3.0, 3.0f, 4.0);
        collection2.forEachWithIndex((FloatDoublePair object, int index) ->
            {
                elements2.add(object);
                indexes2.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0.0f, 1.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select()
    {
        MutableList<FloatDoublePair> result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).select(PrimitiveTuples.pair(2.0f, 3.0)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, 4.0), result);
    }

    @Test
    public void selectWith()
    {
        MutableList<FloatDoublePair> result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).selectWith(Object::equals, PrimitiveTuples.pair(2.0f, 3.0)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, 4.0), result);
    }

    @Test
    public void selectWith_target()
    {
        HashBag<FloatDoublePair> result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0f, 3.0), HashBag.<FloatDoublePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(3.0f, 4.0)), result);
    }

    @Test
    public void reject()
    {
        MutableList<FloatDoublePair> result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).reject(Predicates.notEqual(PrimitiveTuples.pair(2.0f, 3.0))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, 4.0), result);
    }

    @Test
    public void rejectWith()
    {
        MutableList<FloatDoublePair> result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0f, 3.0)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, 4.0), result);
    }

    @Test
    public void rejectWith_target()
    {
        HashBag<FloatDoublePair> result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).rejectWith(Object::equals, PrimitiveTuples.pair(2.0f, 3.0), HashBag.<FloatDoublePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(3.0f, 4.0)), result);
    }

    @Test
    public void selectInstancesOf()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(FloatDoublePair.class), PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(3.0f, 4.0), PrimitiveTuples.pair(2.0f, 3.0));
    }

    @Test
    public void collect()
    {
        RichIterable<Integer> result1 =
            this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collect((FloatDoublePair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 =
            this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collect((FloatDoublePair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean()
    {
        BooleanIterable result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectBoolean((FloatDoublePair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte()
    {
        ByteIterable result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectByte((FloatDoublePair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar()
    {
        CharIterable result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectChar((FloatDoublePair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble()
    {
        DoubleIterable result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectDouble((FloatDoublePair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat()
    {
        FloatIterable result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectFloat((FloatDoublePair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt()
    {
        IntIterable result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectInt((FloatDoublePair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong()
    {
        LongIterable result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectLong((FloatDoublePair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort()
    {
        ShortIterable result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectShort((FloatDoublePair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Function<FloatDoublePair, MutableList<String>> function = (FloatDoublePair object) -> FastList.newListWith(String.valueOf(object));

        Verify.assertListsEqual(
                FastList.newListWith("1.0:2.0", "2.0:3.0", "3.0:4.0"),
                collection.flatCollect(function).toSortedList());

        Verify.assertSetsEqual(
                UnifiedSet.newSetWith("1.0:2.0", "2.0:3.0", "3.0:4.0"),
                collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).detect(PrimitiveTuples.pair(2.0f, 3.0)::equals));
        Assert.assertNull(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).detect(PrimitiveTuples.pair(2.0f, 4.0)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).min(Comparators.naturalOrder()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3.0f, 4.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3.0f, 4.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).minBy((FloatDoublePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 4.0f, 5.0).maxBy((FloatDoublePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).detectWith(Object::equals, PrimitiveTuples.pair(2.0f, 3.0)));
        Assert.assertNull(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone()
    {
        Function0<FloatDoublePair> function = Functions0.value(PrimitiveTuples.pair(5.0f, 6.0));
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).detectIfNone(PrimitiveTuples.pair(2.0f, 3.0)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0f, 6.0), this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock()
    {
        Function0<FloatDoublePair> function = Functions0.value(PrimitiveTuples.pair(5.0f, 6.0));
        Assert.assertEquals(
            PrimitiveTuples.pair(2.0f, 3.0),
            this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2.0f, 3.0),
                    function));
        Assert.assertEquals(
            PrimitiveTuples.pair(5.0f, 6.0),
            this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2, 4L),
                    function));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).allSatisfy(FloatDoublePair.class::isInstance));
        Assert.assertFalse(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).allSatisfy(PrimitiveTuples.pair(2.0f, 3.0)::equals));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).allSatisfyWith(Predicates2.instanceOf(), FloatDoublePair.class));
        Assert.assertFalse(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, 3.0)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).noneSatisfy(PrimitiveTuples.pair(2.0f, 3.0)::equals));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, 3.0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).anySatisfy(PrimitiveTuples.pair(2.0f, 3.0)::equals));
        Assert.assertFalse(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).anySatisfy(PrimitiveTuples.pair(2.0f, 5.0)::equals));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, 3.0)));
        Assert.assertFalse(this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, 5.0)));
    }

    @Test
    public void count()
    {
        Assert.assertEquals(0, this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).count(FloatDoublePair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).count(PrimitiveTuples.pair(2.0f, 3.0)::equals));
    }

    @Test
    public void countWith()
    {
        Assert.assertEquals(0, this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).countWith(Predicates2.instanceOf(), FloatDoublePair.class));
        Assert.assertEquals(1, this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).countWith(Object::equals, PrimitiveTuples.pair(2.0f, 3.0)));
    }

    @Test
    public void collectIf()
    {
        Verify.assertContainsAll(
                this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectIf(
                        FloatDoublePair.class::isInstance,
                        String::valueOf),
                "1.0:2.0", "2.0:3.0", "3.0:4.0");
        Verify.assertContainsAll(
                this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectIf(
                        FloatDoublePair.class::isInstance,
                        String::valueOf,
                        UnifiedSet.<String>newSet()),
                "1.0:2.0", "2.0:3.0", "3.0:4.0");
    }

    @Test
    public void collectWith()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectWith((FloatDoublePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).collectWith((FloatDoublePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst()
    {
        FloatDoublePair first = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1.0f, 2.0).equals(first)
                || PrimitiveTuples.pair(2.0f, 3.0).equals(first)
                || PrimitiveTuples.pair(3.0f, 4.0).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2.0), this.newWith(1.0f, 2.0).getFirst());
    }

    @Test
    public void getLast()
    {
        FloatDoublePair last = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1.0f, 2.0).equals(last)
                || PrimitiveTuples.pair(2.0f, 3.0).equals(last)
                || PrimitiveTuples.pair(3.0f, 4.0).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2.0), this.newWith(1.0f, 2.0).getLast());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1.0f, 2.0));
        Assert.assertTrue(this.newWith(1.0f, 2.0).notEmpty());
    }

    @Test
    public void iterator()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 0.0f, 3.0, 3.0f, 4.0);
        MutableBag<FloatDoublePair> actual = Bags.mutable.of();
        Iterator<FloatDoublePair> iterator = objects.iterator();
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
        RichIterable<FloatDoublePair> objects = this.newWith(2.0f, 3.0, 4.0f, 3.0, 3.0f, 4.0);
        MutableBag<FloatDoublePair> actual = Bags.mutable.of();
        Iterator<FloatDoublePair> iterator = objects.iterator();
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
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Iterator<FloatDoublePair> iterator = objects.iterator();
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
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Iterator<FloatDoublePair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Long result = objects.injectInto(1L, (Long argument1, FloatDoublePair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        int result = objects.injectInto(1, (int intParameter, FloatDoublePair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        long result = objects.injectInto(1L, (long parameter, FloatDoublePair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        double result = objects.injectInto(1.0, (double parameter, FloatDoublePair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        float result = objects.injectInto(1.0f, (float parameter, FloatDoublePair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        double actual = objects.sumOfFloat((FloatDoublePair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        double actual = objects.sumOfDouble((FloatDoublePair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        long actual = objects.sumOfInt((FloatDoublePair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        long actual = objects.sumOfLong((FloatDoublePair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray()
    {
        RichIterable<FloatDoublePair> objects = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        FloatDoublePair[] array2 = objects.toArray(new FloatDoublePair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition()
    {
        PartitionIterable<FloatDoublePair> result = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).partition(PrimitiveTuples.pair(2.0f, 3.0)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3.0), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1.0f, 2.0), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3.0f, 4.0), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList()
    {
        MutableList<FloatDoublePair> list = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0));
    }

    @Test
    public void toBag()
    {
        MutableBag<FloatDoublePair> bag = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0));
    }

    @Test
    public void toSortedList_natural_ordering()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableList<FloatDoublePair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), list);
    }

    @Test
    public void toSortedList_with_comparator()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableList<FloatDoublePair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3.0f, 4.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(1.0f, 2.0)), list);
    }

    @Test
    public void toSortedListBy()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableList<FloatDoublePair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), list);
    }

    @Test
    public void toSortedBag_natural_ordering()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableSortedBag<FloatDoublePair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), bag);
    }

    @Test
    public void toSortedBag_with_comparator()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableSortedBag<FloatDoublePair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0f, 4.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(1.0f, 2.0)), bag);
    }

    @Test
    public void toSortedBagBy()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableSortedBag<FloatDoublePair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableSortedSet<FloatDoublePair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), set);
    }

    @Test
    public void toSortedSet_with_comparator()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableSortedSet<FloatDoublePair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(),
                PrimitiveTuples.pair(3.0f, 4.0),
                PrimitiveTuples.pair(2.0f, 3.0),
                PrimitiveTuples.pair(1.0f, 2.0)),
                set);
    }

    @Test
    public void toSortedSetBy()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(2.0f, 3.0, 1.0f, 2.0, 3.0f, 4.0);
        MutableSortedSet<FloatDoublePair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0)), set);
    }

    @Test
    public void toSet()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        MutableSet<FloatDoublePair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1.0f, 2.0), PrimitiveTuples.pair(2.0f, 3.0), PrimitiveTuples.pair(3.0f, 4.0));
    }

    @Test
    public void toMap()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        MutableMap<String, String> map =
                pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1.0:2.0", "1.0:2.0", "2.0:3.0", "2.0:3.0", "3.0:4.0", "3.0:4.0"), map);
    }

    @Test
    public void toSortedMap()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1.0:2.0", "1.0:2.0", "2.0:3.0", "2.0:3.0", "3.0:4.0", "3.0:4.0"), map);
    }

    @Test
    public void toSortedMap_with_comparator()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1.0:2.0", "1.0:2.0", "2.0:3.0", "2.0:3.0", "3.0:4.0", "3.0:4.0"), map);
    }

    @Test
    public void toSortedMapBy()
    {
        RichIterable<FloatDoublePair> pairs = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        MutableSortedMap<String, String> map =
                pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1.0:2.0", "1.0:2.0", "2.0:3.0", "2.0:3.0", "3.0:4.0", "3.0:4.0"), map);
    }

    @Test
    public void testToString()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0);
        Assert.assertTrue("[1.0:2.0, 2.0:3.0]".equals(collection.toString())
                || "[2.0:3.0, 1.0:2.0]".equals(collection.toString()));
    }

    @Test
    public void makeString()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Function<FloatDoublePair, Boolean> function = (FloatDoublePair object) -> PrimitiveTuples.pair(1.0f, 2.0).equals(object);

        Multimap<Boolean, FloatDoublePair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0f, 2.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0f, 3.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0f, 4.0)));
    }

    @Test
    public void groupByEach()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Function<FloatDoublePair, MutableList<Boolean>> function = (FloatDoublePair object) -> Lists.mutable.of(PrimitiveTuples.pair(1.0f, 2.0).equals(object));

        Multimap<Boolean, FloatDoublePair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0f, 2.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0f, 3.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0f, 4.0)));
    }

    @Test
    public void zip()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0);
        RichIterable<Pair<FloatDoublePair, Integer>> result = collection.zip(Interval.oneTo(5));

        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0f, 2.0), 1), Tuples.pair(PrimitiveTuples.pair(2.0f, 3.0), 2)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0f, 3.0), 1), Tuples.pair(PrimitiveTuples.pair(1.0f, 2.0), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0);
        RichIterable<Pair<FloatDoublePair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0f, 2.0), 0), Tuples.pair(PrimitiveTuples.pair(2.0f, 3.0), 1)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0f, 3.0), 0), Tuples.pair(PrimitiveTuples.pair(1.0f, 2.0), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1.0f, 2.0)),
                FastList.newListWith(PrimitiveTuples.pair(2.0f, 3.0)),
                FastList.newListWith(PrimitiveTuples.pair(3.0f, 4.0))),
                collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size()
    {
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
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
        RichIterable<FloatDoublePair> notEmpty = this.newWith(1.0f, 2.0);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, FloatDoublePair> sumAggregator = (AtomicInteger aggregate, FloatDoublePair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3.0:4.0").intValue());
        Assert.assertEquals(2, aggregation.get("2.0:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:2.0").intValue());
    }

    @Test
    public void aggregateByNonMutating()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, FloatDoublePair, Integer> sumAggregator = (Integer aggregate, FloatDoublePair value) -> (int) (aggregate + value.getOne());
        RichIterable<FloatDoublePair> collection = this.newWith(1.0f, 1.0, 1.0f, 2.0, 2.0f, 3.0);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2.0:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:2.0").intValue());
    }
}
