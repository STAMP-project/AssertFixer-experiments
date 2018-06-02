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
import org.eclipse.collections.api.map.primitive.LongDoubleMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.LongDoublePair;
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
 * Abstract JUnit test for {@link LongDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractLongDoubleMapKeyValuesViewTestCase
{
    public abstract LongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3);

    public abstract LongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2);

    public abstract LongDoubleMap newWithKeysValues(long key1, double value1);

    public abstract LongDoubleMap newEmpty();

    public RichIterable<LongDoublePair> newWith()
    {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<LongDoublePair> newWith(long key1, double value1)
    {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<LongDoublePair> newWith(long key1, double value1, long key2, double value2)
    {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<LongDoublePair> newWith(long key1, double value1, long key2, double value2, long key3, double value3)
    {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(1L, 5.0))));
    }

    @Test
    public void containsAllArray()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(1L, 5.0)));
    }

    @Test
    public void forEach()
    {
        MutableList<LongDoublePair> result = Lists.mutable.of();
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0));

        MutableList<LongDoublePair> result2 = Lists.mutable.of();
        RichIterable<LongDoublePair> collection2 = this.newWith(0L, 2.0, 2L, 3.0, 3L, 4.0);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0));
    }

    @Test
    public void forEachWith()
    {
        MutableBag<LongDoublePair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<LongDoublePair> collection = this.newWith(1L, 0.0, 2L, 3.0, 3L, 4.0);
        collection.forEachWith((LongDoublePair argument1, Integer argument2) ->
            {
                result.add(argument1);
                result2.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 0.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);

        MutableBag<LongDoublePair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<LongDoublePair> collection2 = this.newWith(2L, 5.0, 6L, 3.0, 3L, 4.0);
        collection2.forEachWith((LongDoublePair argument1, Integer argument2) ->
            {
                result3.add(argument1);
                result4.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2L, 5.0), PrimitiveTuples.pair(6L, 3.0), PrimitiveTuples.pair(3L, 4.0)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex()
    {
        MutableBag<LongDoublePair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<LongDoublePair> collection = this.newWith(2L, 2.0, 6L, 3.0, 3L, 4.0);
        collection.forEachWithIndex((LongDoublePair object, int index) ->
            {
                elements.add(object);
                indexes.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2L, 2.0), PrimitiveTuples.pair(6L, 3.0), PrimitiveTuples.pair(3L, 4.0)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);

        MutableBag<LongDoublePair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<LongDoublePair> collection2 = this.newWith(0L, 1.0, 2L, 3.0, 3L, 4.0);
        collection2.forEachWithIndex((LongDoublePair object, int index) ->
            {
                elements2.add(object);
                indexes2.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0L, 1.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select()
    {
        MutableList<LongDoublePair> result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).select(PrimitiveTuples.pair(2L, 3.0)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4.0), result);
    }

    @Test
    public void selectWith()
    {
        MutableList<LongDoublePair> result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).selectWith(Object::equals, PrimitiveTuples.pair(2L, 3.0)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4.0), result);
    }

    @Test
    public void selectWith_target()
    {
        HashBag<LongDoublePair> result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, 3.0), HashBag.<LongDoublePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(3L, 4.0)), result);
    }

    @Test
    public void reject()
    {
        MutableList<LongDoublePair> result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).reject(Predicates.notEqual(PrimitiveTuples.pair(2L, 3.0))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4.0), result);
    }

    @Test
    public void rejectWith()
    {
        MutableList<LongDoublePair> result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, 3.0)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2.0), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4.0), result);
    }

    @Test
    public void rejectWith_target()
    {
        HashBag<LongDoublePair> result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).rejectWith(Object::equals, PrimitiveTuples.pair(2L, 3.0), HashBag.<LongDoublePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(3L, 4.0)), result);
    }

    @Test
    public void selectInstancesOf()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(LongDoublePair.class), PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(3L, 4.0), PrimitiveTuples.pair(2L, 3.0));
    }

    @Test
    public void collect()
    {
        RichIterable<Integer> result1 =
            this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collect((LongDoublePair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 =
            this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collect((LongDoublePair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean()
    {
        BooleanIterable result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectBoolean((LongDoublePair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte()
    {
        ByteIterable result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectByte((LongDoublePair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar()
    {
        CharIterable result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectChar((LongDoublePair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble()
    {
        DoubleIterable result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectDouble((LongDoublePair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat()
    {
        FloatIterable result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectFloat((LongDoublePair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt()
    {
        IntIterable result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectInt((LongDoublePair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong()
    {
        LongIterable result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectLong((LongDoublePair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort()
    {
        ShortIterable result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectShort((LongDoublePair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Function<LongDoublePair, MutableList<String>> function = (LongDoublePair object) -> FastList.newListWith(String.valueOf(object));

        Verify.assertListsEqual(
                FastList.newListWith("1:2.0", "2:3.0", "3:4.0"),
                collection.flatCollect(function).toSortedList());

        Verify.assertSetsEqual(
                UnifiedSet.newSetWith("1:2.0", "2:3.0", "3:4.0"),
                collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).detect(PrimitiveTuples.pair(2L, 3.0)::equals));
        Assert.assertNull(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).detect(PrimitiveTuples.pair(2L, 4.0)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).min(Comparators.naturalOrder()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3L, 4.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3L, 4.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).minBy((LongDoublePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0), this.newWith(1L, 2.0, 2L, 3.0, 4L, 5.0).maxBy((LongDoublePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).detectWith(Object::equals, PrimitiveTuples.pair(2L, 3.0)));
        Assert.assertNull(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone()
    {
        Function0<LongDoublePair> function = Functions0.value(PrimitiveTuples.pair(5L, 6.0));
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).detectIfNone(PrimitiveTuples.pair(2L, 3.0)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, 6.0), this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock()
    {
        Function0<LongDoublePair> function = Functions0.value(PrimitiveTuples.pair(5L, 6.0));
        Assert.assertEquals(
            PrimitiveTuples.pair(2L, 3.0),
            this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2L, 3.0),
                    function));
        Assert.assertEquals(
            PrimitiveTuples.pair(5L, 6.0),
            this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2, 4L),
                    function));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).allSatisfy(LongDoublePair.class::isInstance));
        Assert.assertFalse(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).allSatisfy(PrimitiveTuples.pair(2L, 3.0)::equals));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).allSatisfyWith(Predicates2.instanceOf(), LongDoublePair.class));
        Assert.assertFalse(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3.0)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).noneSatisfy(PrimitiveTuples.pair(2L, 3.0)::equals));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3.0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).anySatisfy(PrimitiveTuples.pair(2L, 3.0)::equals));
        Assert.assertFalse(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).anySatisfy(PrimitiveTuples.pair(2L, 5.0)::equals));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3.0)));
        Assert.assertFalse(this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 5.0)));
    }

    @Test
    public void count()
    {
        Assert.assertEquals(0, this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).count(LongDoublePair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).count(PrimitiveTuples.pair(2L, 3.0)::equals));
    }

    @Test
    public void countWith()
    {
        Assert.assertEquals(0, this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).countWith(Predicates2.instanceOf(), LongDoublePair.class));
        Assert.assertEquals(1, this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).countWith(Object::equals, PrimitiveTuples.pair(2L, 3.0)));
    }

    @Test
    public void collectIf()
    {
        Verify.assertContainsAll(
                this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectIf(
                        LongDoublePair.class::isInstance,
                        String::valueOf),
                "1:2.0", "2:3.0", "3:4.0");
        Verify.assertContainsAll(
                this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectIf(
                        LongDoublePair.class::isInstance,
                        String::valueOf,
                        UnifiedSet.<String>newSet()),
                "1:2.0", "2:3.0", "3:4.0");
    }

    @Test
    public void collectWith()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectWith((LongDoublePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).collectWith((LongDoublePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst()
    {
        LongDoublePair first = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1L, 2.0).equals(first)
                || PrimitiveTuples.pair(2L, 3.0).equals(first)
                || PrimitiveTuples.pair(3L, 4.0).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0), this.newWith(1L, 2.0).getFirst());
    }

    @Test
    public void getLast()
    {
        LongDoublePair last = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1L, 2.0).equals(last)
                || PrimitiveTuples.pair(2L, 3.0).equals(last)
                || PrimitiveTuples.pair(3L, 4.0).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0), this.newWith(1L, 2.0).getLast());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1L, 2.0));
        Assert.assertTrue(this.newWith(1L, 2.0).notEmpty());
    }

    @Test
    public void iterator()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 0L, 3.0, 3L, 4.0);
        MutableBag<LongDoublePair> actual = Bags.mutable.of();
        Iterator<LongDoublePair> iterator = objects.iterator();
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
        RichIterable<LongDoublePair> objects = this.newWith(2L, 3.0, 4L, 3.0, 3L, 4.0);
        MutableBag<LongDoublePair> actual = Bags.mutable.of();
        Iterator<LongDoublePair> iterator = objects.iterator();
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
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Iterator<LongDoublePair> iterator = objects.iterator();
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
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Iterator<LongDoublePair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Long result = objects.injectInto(1L, (Long argument1, LongDoublePair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        int result = objects.injectInto(1, (int intParameter, LongDoublePair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        long result = objects.injectInto(1L, (long parameter, LongDoublePair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        double result = objects.injectInto(1.0, (double parameter, LongDoublePair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        float result = objects.injectInto(1.0f, (float parameter, LongDoublePair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        double actual = objects.sumOfFloat((LongDoublePair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        double actual = objects.sumOfDouble((LongDoublePair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        long actual = objects.sumOfInt((LongDoublePair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        long actual = objects.sumOfLong((LongDoublePair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray()
    {
        RichIterable<LongDoublePair> objects = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        LongDoublePair[] array2 = objects.toArray(new LongDoublePair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition()
    {
        PartitionIterable<LongDoublePair> result = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).partition(PrimitiveTuples.pair(2L, 3.0)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1L, 2.0), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3L, 4.0), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList()
    {
        MutableList<LongDoublePair> list = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0));
    }

    @Test
    public void toBag()
    {
        MutableBag<LongDoublePair> bag = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0));
    }

    @Test
    public void toSortedList_natural_ordering()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableList<LongDoublePair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0)), list);
    }

    @Test
    public void toSortedList_with_comparator()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableList<LongDoublePair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3L, 4.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(1L, 2.0)), list);
    }

    @Test
    public void toSortedListBy()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableList<LongDoublePair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0)), list);
    }

    @Test
    public void toSortedBag_natural_ordering()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableSortedBag<LongDoublePair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0)), bag);
    }

    @Test
    public void toSortedBag_with_comparator()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableSortedBag<LongDoublePair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, 4.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(1L, 2.0)), bag);
    }

    @Test
    public void toSortedBagBy()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableSortedBag<LongDoublePair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableSortedSet<LongDoublePair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0)), set);
    }

    @Test
    public void toSortedSet_with_comparator()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableSortedSet<LongDoublePair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(),
                PrimitiveTuples.pair(3L, 4.0),
                PrimitiveTuples.pair(2L, 3.0),
                PrimitiveTuples.pair(1L, 2.0)),
                set);
    }

    @Test
    public void toSortedSetBy()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(2L, 3.0, 1L, 2.0, 3L, 4.0);
        MutableSortedSet<LongDoublePair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0)), set);
    }

    @Test
    public void toSet()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        MutableSet<LongDoublePair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1L, 2.0), PrimitiveTuples.pair(2L, 3.0), PrimitiveTuples.pair(3L, 4.0));
    }

    @Test
    public void toMap()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        MutableMap<String, String> map =
                pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMap()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMap_with_comparator()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMapBy()
    {
        RichIterable<LongDoublePair> pairs = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        MutableSortedMap<String, String> map =
                pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void testToString()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0);
        Assert.assertTrue("[1:2.0, 2:3.0]".equals(collection.toString())
                || "[2:3.0, 1:2.0]".equals(collection.toString()));
    }

    @Test
    public void makeString()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Function<LongDoublePair, Boolean> function = (LongDoublePair object) -> PrimitiveTuples.pair(1L, 2.0).equals(object);

        Multimap<Boolean, LongDoublePair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, 2.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, 3.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, 4.0)));
    }

    @Test
    public void groupByEach()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Function<LongDoublePair, MutableList<Boolean>> function = (LongDoublePair object) -> Lists.mutable.of(PrimitiveTuples.pair(1L, 2.0).equals(object));

        Multimap<Boolean, LongDoublePair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, 2.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, 3.0)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, 4.0)));
    }

    @Test
    public void zip()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0);
        RichIterable<Pair<LongDoublePair, Integer>> result = collection.zip(Interval.oneTo(5));

        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, 2.0), 1), Tuples.pair(PrimitiveTuples.pair(2L, 3.0), 2)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, 3.0), 1), Tuples.pair(PrimitiveTuples.pair(1L, 2.0), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0);
        RichIterable<Pair<LongDoublePair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, 2.0), 0), Tuples.pair(PrimitiveTuples.pair(2L, 3.0), 1)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, 3.0), 0), Tuples.pair(PrimitiveTuples.pair(1L, 2.0), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1L, 2.0)),
                FastList.newListWith(PrimitiveTuples.pair(2L, 3.0)),
                FastList.newListWith(PrimitiveTuples.pair(3L, 4.0))),
                collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size()
    {
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
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
        RichIterable<LongDoublePair> notEmpty = this.newWith(1L, 2.0);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, LongDoublePair> sumAggregator = (AtomicInteger aggregate, LongDoublePair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<LongDoublePair> collection = this.newWith(1L, 2.0, 2L, 3.0, 3L, 4.0);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4.0").intValue());
        Assert.assertEquals(2, aggregation.get("2:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1:2.0").intValue());
    }

    @Test
    public void aggregateByNonMutating()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, LongDoublePair, Integer> sumAggregator = (Integer aggregate, LongDoublePair value) -> (int) (aggregate + value.getOne());
        RichIterable<LongDoublePair> collection = this.newWith(1L, 1.0, 1L, 2.0, 2L, 3.0);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1:2.0").intValue());
    }
}
