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
import org.eclipse.collections.api.map.primitive.IntFloatMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.IntFloatPair;
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
 * Abstract JUnit test for {@link IntFloatMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractIntFloatMapKeyValuesViewTestCase
{
    public abstract IntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3);

    public abstract IntFloatMap newWithKeysValues(int key1, float value1, int key2, float value2);

    public abstract IntFloatMap newWithKeysValues(int key1, float value1);

    public abstract IntFloatMap newEmpty();

    public RichIterable<IntFloatPair> newWith()
    {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<IntFloatPair> newWith(int key1, float value1)
    {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<IntFloatPair> newWith(int key1, float value1, int key2, float value2)
    {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<IntFloatPair> newWith(int key1, float value1, int key2, float value2, int key3, float value3)
    {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(1, 5.0f))));
    }

    @Test
    public void containsAllArray()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(1, 5.0f)));
    }

    @Test
    public void forEach()
    {
        MutableList<IntFloatPair> result = Lists.mutable.of();
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f));

        MutableList<IntFloatPair> result2 = Lists.mutable.of();
        RichIterable<IntFloatPair> collection2 = this.newWith(0, 2.0f, 2, 3.0f, 3, 4.0f);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f));
    }

    @Test
    public void forEachWith()
    {
        MutableBag<IntFloatPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<IntFloatPair> collection = this.newWith(1, 0.0f, 2, 3.0f, 3, 4.0f);
        collection.forEachWith((IntFloatPair argument1, Integer argument2) ->
            {
                result.add(argument1);
                result2.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, 0.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);

        MutableBag<IntFloatPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<IntFloatPair> collection2 = this.newWith(2, 5.0f, 6, 3.0f, 3, 4.0f);
        collection2.forEachWith((IntFloatPair argument1, Integer argument2) ->
            {
                result3.add(argument1);
                result4.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2, 5.0f), PrimitiveTuples.pair(6, 3.0f), PrimitiveTuples.pair(3, 4.0f)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex()
    {
        MutableBag<IntFloatPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<IntFloatPair> collection = this.newWith(2, 2.0f, 6, 3.0f, 3, 4.0f);
        collection.forEachWithIndex((IntFloatPair object, int index) ->
            {
                elements.add(object);
                indexes.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2, 2.0f), PrimitiveTuples.pair(6, 3.0f), PrimitiveTuples.pair(3, 4.0f)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);

        MutableBag<IntFloatPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<IntFloatPair> collection2 = this.newWith(0, 1.0f, 2, 3.0f, 3, 4.0f);
        collection2.forEachWithIndex((IntFloatPair object, int index) ->
            {
                elements2.add(object);
                indexes2.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0, 1.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select()
    {
        MutableList<IntFloatPair> result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).select(PrimitiveTuples.pair(2, 3.0f)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, 4.0f), result);
    }

    @Test
    public void selectWith()
    {
        MutableList<IntFloatPair> result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).selectWith(Object::equals, PrimitiveTuples.pair(2, 3.0f)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, 4.0f), result);
    }

    @Test
    public void selectWith_target()
    {
        HashBag<IntFloatPair> result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2, 3.0f), HashBag.<IntFloatPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(3, 4.0f)), result);
    }

    @Test
    public void reject()
    {
        MutableList<IntFloatPair> result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).reject(Predicates.notEqual(PrimitiveTuples.pair(2, 3.0f))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, 4.0f), result);
    }

    @Test
    public void rejectWith()
    {
        MutableList<IntFloatPair> result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2, 3.0f)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, 4.0f), result);
    }

    @Test
    public void rejectWith_target()
    {
        HashBag<IntFloatPair> result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).rejectWith(Object::equals, PrimitiveTuples.pair(2, 3.0f), HashBag.<IntFloatPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(3, 4.0f)), result);
    }

    @Test
    public void selectInstancesOf()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(IntFloatPair.class), PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(3, 4.0f), PrimitiveTuples.pair(2, 3.0f));
    }

    @Test
    public void collect()
    {
        RichIterable<Integer> result1 =
            this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collect((IntFloatPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 =
            this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collect((IntFloatPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean()
    {
        BooleanIterable result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectBoolean((IntFloatPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte()
    {
        ByteIterable result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectByte((IntFloatPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar()
    {
        CharIterable result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectChar((IntFloatPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble()
    {
        DoubleIterable result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectDouble((IntFloatPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat()
    {
        FloatIterable result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectFloat((IntFloatPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt()
    {
        IntIterable result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectInt((IntFloatPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong()
    {
        LongIterable result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectLong((IntFloatPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort()
    {
        ShortIterable result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectShort((IntFloatPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Function<IntFloatPair, MutableList<String>> function = (IntFloatPair object) -> FastList.newListWith(String.valueOf(object));

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
        Assert.assertEquals(PrimitiveTuples.pair(2, 3.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).detect(PrimitiveTuples.pair(2, 3.0f)::equals));
        Assert.assertNull(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).detect(PrimitiveTuples.pair(2, 4.0f)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1, 2.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).min(Comparators.naturalOrder()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3, 4.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1, 2.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3, 4.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2, 3.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).minBy((IntFloatPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1, 2.0f), this.newWith(1, 2.0f, 2, 3.0f, 4, 5.0f).maxBy((IntFloatPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2, 3.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).detectWith(Object::equals, PrimitiveTuples.pair(2, 3.0f)));
        Assert.assertNull(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone()
    {
        Function0<IntFloatPair> function = Functions0.value(PrimitiveTuples.pair(5, 6.0f));
        Assert.assertEquals(PrimitiveTuples.pair(2, 3.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).detectIfNone(PrimitiveTuples.pair(2, 3.0f)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5, 6.0f), this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock()
    {
        Function0<IntFloatPair> function = Functions0.value(PrimitiveTuples.pair(5, 6.0f));
        Assert.assertEquals(
            PrimitiveTuples.pair(2, 3.0f),
            this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2, 3.0f),
                    function));
        Assert.assertEquals(
            PrimitiveTuples.pair(5, 6.0f),
            this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2, 4L),
                    function));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).allSatisfy(IntFloatPair.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).allSatisfy(PrimitiveTuples.pair(2, 3.0f)::equals));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).allSatisfyWith(Predicates2.instanceOf(), IntFloatPair.class));
        Assert.assertFalse(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2, 3.0f)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).noneSatisfy(PrimitiveTuples.pair(2, 3.0f)::equals));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2, 3.0f)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).anySatisfy(PrimitiveTuples.pair(2, 3.0f)::equals));
        Assert.assertFalse(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).anySatisfy(PrimitiveTuples.pair(2, 5.0f)::equals));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, 3.0f)));
        Assert.assertFalse(this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, 5.0f)));
    }

    @Test
    public void count()
    {
        Assert.assertEquals(0, this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).count(IntFloatPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).count(PrimitiveTuples.pair(2, 3.0f)::equals));
    }

    @Test
    public void countWith()
    {
        Assert.assertEquals(0, this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).countWith(Predicates2.instanceOf(), IntFloatPair.class));
        Assert.assertEquals(1, this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).countWith(Object::equals, PrimitiveTuples.pair(2, 3.0f)));
    }

    @Test
    public void collectIf()
    {
        Verify.assertContainsAll(
                this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectIf(
                        IntFloatPair.class::isInstance,
                        String::valueOf),
                "1:2.0", "2:3.0", "3:4.0");
        Verify.assertContainsAll(
                this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectIf(
                        IntFloatPair.class::isInstance,
                        String::valueOf,
                        UnifiedSet.<String>newSet()),
                "1:2.0", "2:3.0", "3:4.0");
    }

    @Test
    public void collectWith()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectWith((IntFloatPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).collectWith((IntFloatPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst()
    {
        IntFloatPair first = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1, 2.0f).equals(first)
                || PrimitiveTuples.pair(2, 3.0f).equals(first)
                || PrimitiveTuples.pair(3, 4.0f).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1, 2.0f), this.newWith(1, 2.0f).getFirst());
    }

    @Test
    public void getLast()
    {
        IntFloatPair last = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1, 2.0f).equals(last)
                || PrimitiveTuples.pair(2, 3.0f).equals(last)
                || PrimitiveTuples.pair(3, 4.0f).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1, 2.0f), this.newWith(1, 2.0f).getLast());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1, 2.0f));
        Assert.assertTrue(this.newWith(1, 2.0f).notEmpty());
    }

    @Test
    public void iterator()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 0, 3.0f, 3, 4.0f);
        MutableBag<IntFloatPair> actual = Bags.mutable.of();
        Iterator<IntFloatPair> iterator = objects.iterator();
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
        RichIterable<IntFloatPair> objects = this.newWith(2, 3.0f, 4, 3.0f, 3, 4.0f);
        MutableBag<IntFloatPair> actual = Bags.mutable.of();
        Iterator<IntFloatPair> iterator = objects.iterator();
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
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Iterator<IntFloatPair> iterator = objects.iterator();
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
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Iterator<IntFloatPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Long result = objects.injectInto(1L, (Long argument1, IntFloatPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        int result = objects.injectInto(1, (int intParameter, IntFloatPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        long result = objects.injectInto(1L, (long parameter, IntFloatPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        double result = objects.injectInto(1.0, (double parameter, IntFloatPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        float result = objects.injectInto(1.0f, (float parameter, IntFloatPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        double actual = objects.sumOfFloat((IntFloatPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        double actual = objects.sumOfDouble((IntFloatPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        long actual = objects.sumOfInt((IntFloatPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        long actual = objects.sumOfLong((IntFloatPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray()
    {
        RichIterable<IntFloatPair> objects = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        IntFloatPair[] array2 = objects.toArray(new IntFloatPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition()
    {
        PartitionIterable<IntFloatPair> result = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).partition(PrimitiveTuples.pair(2, 3.0f)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2, 3.0f), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1, 2.0f), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3, 4.0f), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList()
    {
        MutableList<IntFloatPair> list = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f));
    }

    @Test
    public void toBag()
    {
        MutableBag<IntFloatPair> bag = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f));
    }

    @Test
    public void toSortedList_natural_ordering()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableList<IntFloatPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f)), list);
    }

    @Test
    public void toSortedList_with_comparator()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableList<IntFloatPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3, 4.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(1, 2.0f)), list);
    }

    @Test
    public void toSortedListBy()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableList<IntFloatPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f)), list);
    }

    @Test
    public void toSortedBag_natural_ordering()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableSortedBag<IntFloatPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f)), bag);
    }

    @Test
    public void toSortedBag_with_comparator()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableSortedBag<IntFloatPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3, 4.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(1, 2.0f)), bag);
    }

    @Test
    public void toSortedBagBy()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableSortedBag<IntFloatPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableSortedSet<IntFloatPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f)), set);
    }

    @Test
    public void toSortedSet_with_comparator()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableSortedSet<IntFloatPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(),
                PrimitiveTuples.pair(3, 4.0f),
                PrimitiveTuples.pair(2, 3.0f),
                PrimitiveTuples.pair(1, 2.0f)),
                set);
    }

    @Test
    public void toSortedSetBy()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(2, 3.0f, 1, 2.0f, 3, 4.0f);
        MutableSortedSet<IntFloatPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f)), set);
    }

    @Test
    public void toSet()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        MutableSet<IntFloatPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1, 2.0f), PrimitiveTuples.pair(2, 3.0f), PrimitiveTuples.pair(3, 4.0f));
    }

    @Test
    public void toMap()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        MutableMap<String, String> map =
                pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMap()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMap_with_comparator()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMapBy()
    {
        RichIterable<IntFloatPair> pairs = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        MutableSortedMap<String, String> map =
                pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void testToString()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f);
        Assert.assertTrue("[1:2.0, 2:3.0]".equals(collection.toString())
                || "[2:3.0, 1:2.0]".equals(collection.toString()));
    }

    @Test
    public void makeString()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Function<IntFloatPair, Boolean> function = (IntFloatPair object) -> PrimitiveTuples.pair(1, 2.0f).equals(object);

        Multimap<Boolean, IntFloatPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1, 2.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2, 3.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3, 4.0f)));
    }

    @Test
    public void groupByEach()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Function<IntFloatPair, MutableList<Boolean>> function = (IntFloatPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1, 2.0f).equals(object));

        Multimap<Boolean, IntFloatPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1, 2.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2, 3.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3, 4.0f)));
    }

    @Test
    public void zip()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f);
        RichIterable<Pair<IntFloatPair, Integer>> result = collection.zip(Interval.oneTo(5));

        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1, 2.0f), 1), Tuples.pair(PrimitiveTuples.pair(2, 3.0f), 2)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2, 3.0f), 1), Tuples.pair(PrimitiveTuples.pair(1, 2.0f), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f);
        RichIterable<Pair<IntFloatPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1, 2.0f), 0), Tuples.pair(PrimitiveTuples.pair(2, 3.0f), 1)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2, 3.0f), 0), Tuples.pair(PrimitiveTuples.pair(1, 2.0f), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1, 2.0f)),
                FastList.newListWith(PrimitiveTuples.pair(2, 3.0f)),
                FastList.newListWith(PrimitiveTuples.pair(3, 4.0f))),
                collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size()
    {
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
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
        RichIterable<IntFloatPair> notEmpty = this.newWith(1, 2.0f);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, IntFloatPair> sumAggregator = (AtomicInteger aggregate, IntFloatPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<IntFloatPair> collection = this.newWith(1, 2.0f, 2, 3.0f, 3, 4.0f);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4.0").intValue());
        Assert.assertEquals(2, aggregation.get("2:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1:2.0").intValue());
    }

    @Test
    public void aggregateByNonMutating()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, IntFloatPair, Integer> sumAggregator = (Integer aggregate, IntFloatPair value) -> (int) (aggregate + value.getOne());
        RichIterable<IntFloatPair> collection = this.newWith(1, 1.0f, 1, 2.0f, 2, 3.0f);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1:2.0").intValue());
    }
}
