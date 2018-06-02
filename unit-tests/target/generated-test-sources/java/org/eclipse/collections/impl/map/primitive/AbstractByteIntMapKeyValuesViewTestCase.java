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
import org.eclipse.collections.api.map.primitive.ByteIntMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ByteIntPair;
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
 * Abstract JUnit test for {@link ByteIntMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractByteIntMapKeyValuesViewTestCase
{
    public abstract ByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3);

    public abstract ByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2);

    public abstract ByteIntMap newWithKeysValues(byte key1, int value1);

    public abstract ByteIntMap newEmpty();

    public RichIterable<ByteIntPair> newWith()
    {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<ByteIntPair> newWith(byte key1, int value1)
    {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<ByteIntPair> newWith(byte key1, int value1, byte key2, int value2)
    {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<ByteIntPair> newWith(byte key1, int value1, byte key2, int value2, byte key3, int value3)
    {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 1, 5))));
    }

    @Test
    public void containsAllArray()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 1, 5)));
    }

    @Test
    public void forEach()
    {
        MutableList<ByteIntPair> result = Lists.mutable.of();
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4));

        MutableList<ByteIntPair> result2 = Lists.mutable.of();
        RichIterable<ByteIntPair> collection2 = this.newWith((byte) 0, 2, (byte) 2, 3, (byte) 3, 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((byte) 0, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4));
    }

    @Test
    public void forEachWith()
    {
        MutableBag<ByteIntPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 0, (byte) 2, 3, (byte) 3, 4);
        collection.forEachWith((ByteIntPair argument1, Integer argument2) ->
            {
                result.add(argument1);
                result2.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 0), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);

        MutableBag<ByteIntPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<ByteIntPair> collection2 = this.newWith((byte) 2, 5, (byte) 6, 3, (byte) 3, 4);
        collection2.forEachWith((ByteIntPair argument1, Integer argument2) ->
            {
                result3.add(argument1);
                result4.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 2, 5), PrimitiveTuples.pair((byte) 6, 3), PrimitiveTuples.pair((byte) 3, 4)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex()
    {
        MutableBag<ByteIntPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ByteIntPair> collection = this.newWith((byte) 2, 2, (byte) 6, 3, (byte) 3, 4);
        collection.forEachWithIndex((ByteIntPair object, int index) ->
            {
                elements.add(object);
                indexes.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 2, 2), PrimitiveTuples.pair((byte) 6, 3), PrimitiveTuples.pair((byte) 3, 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);

        MutableBag<ByteIntPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<ByteIntPair> collection2 = this.newWith((byte) 0, 1, (byte) 2, 3, (byte) 3, 4);
        collection2.forEachWithIndex((ByteIntPair object, int index) ->
            {
                elements2.add(object);
                indexes2.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 0, 1), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select()
    {
        MutableList<ByteIntPair> result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).select(PrimitiveTuples.pair((byte) 2, 3)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4), result);
    }

    @Test
    public void selectWith()
    {
        MutableList<ByteIntPair> result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).selectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4), result);
    }

    @Test
    public void selectWith_target()
    {
        HashBag<ByteIntPair> result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, 3), HashBag.<ByteIntPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 3, 4)), result);
    }

    @Test
    public void reject()
    {
        MutableList<ByteIntPair> result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).reject(Predicates.notEqual(PrimitiveTuples.pair((byte) 2, 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4), result);
    }

    @Test
    public void rejectWith()
    {
        MutableList<ByteIntPair> result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4), result);
    }

    @Test
    public void rejectWith_target()
    {
        HashBag<ByteIntPair> result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).rejectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3), HashBag.<ByteIntPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 3, 4)), result);
    }

    @Test
    public void selectInstancesOf()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ByteIntPair.class), PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 3, 4), PrimitiveTuples.pair((byte) 2, 3));
    }

    @Test
    public void collect()
    {
        RichIterable<Integer> result1 =
            this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collect((ByteIntPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 =
            this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collect((ByteIntPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean()
    {
        BooleanIterable result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectBoolean((ByteIntPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte()
    {
        ByteIterable result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectByte((ByteIntPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar()
    {
        CharIterable result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectChar((ByteIntPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble()
    {
        DoubleIterable result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectDouble((ByteIntPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat()
    {
        FloatIterable result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectFloat((ByteIntPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt()
    {
        IntIterable result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectInt((ByteIntPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong()
    {
        LongIterable result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectLong((ByteIntPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort()
    {
        ShortIterable result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectShort((ByteIntPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Function<ByteIntPair, MutableList<String>> function = (ByteIntPair object) -> FastList.newListWith(String.valueOf(object));

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
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).detect(PrimitiveTuples.pair((byte) 2, 3)::equals));
        Assert.assertNull(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).detect(PrimitiveTuples.pair((byte) 2, 4)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, 4), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, 4), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).minBy((ByteIntPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 4, 5).maxBy((ByteIntPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith()
    {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).detectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3)));
        Assert.assertNull(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone()
    {
        Function0<ByteIntPair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, 6));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).detectIfNone(PrimitiveTuples.pair((byte) 2, 3)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, 6), this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock()
    {
        Function0<ByteIntPair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, 6));
        Assert.assertEquals(
            PrimitiveTuples.pair((byte) 2, 3),
            this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair((byte) 2, 3),
                    function));
        Assert.assertEquals(
            PrimitiveTuples.pair((byte) 5, 6),
            this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).detectWithIfNone(
                    Object::equals,
                    PrimitiveTuples.pair(2, 4L),
                    function));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).allSatisfy(ByteIntPair.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).allSatisfy(PrimitiveTuples.pair((byte) 2, 3)::equals));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).allSatisfyWith(Predicates2.instanceOf(), ByteIntPair.class));
        Assert.assertFalse(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).noneSatisfy(PrimitiveTuples.pair((byte) 2, 3)::equals));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).anySatisfy(PrimitiveTuples.pair((byte) 2, 3)::equals));
        Assert.assertFalse(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).anySatisfy(PrimitiveTuples.pair((byte) 2, 5)::equals));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3)));
        Assert.assertFalse(this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 5)));
    }

    @Test
    public void count()
    {
        Assert.assertEquals(0, this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).count(ByteIntPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).count(PrimitiveTuples.pair((byte) 2, 3)::equals));
    }

    @Test
    public void countWith()
    {
        Assert.assertEquals(0, this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).countWith(Predicates2.instanceOf(), ByteIntPair.class));
        Assert.assertEquals(1, this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).countWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3)));
    }

    @Test
    public void collectIf()
    {
        Verify.assertContainsAll(
                this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectIf(
                        ByteIntPair.class::isInstance,
                        String::valueOf),
                "1:2", "2:3", "3:4");
        Verify.assertContainsAll(
                this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectIf(
                        ByteIntPair.class::isInstance,
                        String::valueOf,
                        UnifiedSet.<String>newSet()),
                "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectWith((ByteIntPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target()
    {
        Assert.assertEquals(
                Bags.mutable.of(4L, 6L, 8L),
                this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).collectWith((ByteIntPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst()
    {
        ByteIntPair first = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, 2).equals(first)
                || PrimitiveTuples.pair((byte) 2, 3).equals(first)
                || PrimitiveTuples.pair((byte) 3, 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2), this.newWith((byte) 1, 2).getFirst());
    }

    @Test
    public void getLast()
    {
        ByteIntPair last = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, 2).equals(last)
                || PrimitiveTuples.pair((byte) 2, 3).equals(last)
                || PrimitiveTuples.pair((byte) 3, 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2), this.newWith((byte) 1, 2).getLast());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((byte) 1, 2));
        Assert.assertTrue(this.newWith((byte) 1, 2).notEmpty());
    }

    @Test
    public void iterator()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 0, 3, (byte) 3, 4);
        MutableBag<ByteIntPair> actual = Bags.mutable.of();
        Iterator<ByteIntPair> iterator = objects.iterator();
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
        RichIterable<ByteIntPair> objects = this.newWith((byte) 2, 3, (byte) 4, 3, (byte) 3, 4);
        MutableBag<ByteIntPair> actual = Bags.mutable.of();
        Iterator<ByteIntPair> iterator = objects.iterator();
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
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Iterator<ByteIntPair> iterator = objects.iterator();
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
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Iterator<ByteIntPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Long result = objects.injectInto(1L, (Long argument1, ByteIntPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        int result = objects.injectInto(1, (int intParameter, ByteIntPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        long result = objects.injectInto(1L, (long parameter, ByteIntPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        double result = objects.injectInto(1.0, (double parameter, ByteIntPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        float result = objects.injectInto(1.0f, (float parameter, ByteIntPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        double actual = objects.sumOfFloat((ByteIntPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        double actual = objects.sumOfDouble((ByteIntPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        long actual = objects.sumOfInt((ByteIntPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        long actual = objects.sumOfLong((ByteIntPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray()
    {
        RichIterable<ByteIntPair> objects = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ByteIntPair[] array2 = objects.toArray(new ByteIntPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition()
    {
        PartitionIterable<ByteIntPair> result = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).partition(PrimitiveTuples.pair((byte) 2, 3)::equals);
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((byte) 1, 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((byte) 3, 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList()
    {
        MutableList<ByteIntPair> list = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4));
    }

    @Test
    public void toBag()
    {
        MutableBag<ByteIntPair> bag = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4));
    }

    @Test
    public void toSortedList_natural_ordering()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableList<ByteIntPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4)), list);
    }

    @Test
    public void toSortedList_with_comparator()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableList<ByteIntPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 3, 4), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 1, 2)), list);
    }

    @Test
    public void toSortedListBy()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableList<ByteIntPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4)), list);
    }

    @Test
    public void toSortedBag_natural_ordering()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableSortedBag<ByteIntPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4)), bag);
    }

    @Test
    public void toSortedBag_with_comparator()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableSortedBag<ByteIntPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, 4), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 1, 2)), bag);
    }

    @Test
    public void toSortedBagBy()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableSortedBag<ByteIntPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableSortedSet<ByteIntPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4)), set);
    }

    @Test
    public void toSortedSet_with_comparator()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableSortedSet<ByteIntPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(),
                PrimitiveTuples.pair((byte) 3, 4),
                PrimitiveTuples.pair((byte) 2, 3),
                PrimitiveTuples.pair((byte) 1, 2)),
                set);
    }

    @Test
    public void toSortedSetBy()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 2, 3, (byte) 1, 2, (byte) 3, 4);
        MutableSortedSet<ByteIntPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4)), set);
    }

    @Test
    public void toSet()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        MutableSet<ByteIntPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((byte) 1, 2), PrimitiveTuples.pair((byte) 2, 3), PrimitiveTuples.pair((byte) 3, 4));
    }

    @Test
    public void toMap()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        MutableMap<String, String> map =
                pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy()
    {
        RichIterable<ByteIntPair> pairs = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        MutableSortedMap<String, String> map =
                pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString())
                || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Function<ByteIntPair, Boolean> function = (ByteIntPair object) -> PrimitiveTuples.pair((byte) 1, 2).equals(object);

        Multimap<Boolean, ByteIntPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, 4)));
    }

    @Test
    public void groupByEach()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Function<ByteIntPair, MutableList<Boolean>> function = (ByteIntPair object) -> Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2).equals(object));

        Multimap<Boolean, ByteIntPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, 4)));
    }

    @Test
    public void zip()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3);
        RichIterable<Pair<ByteIntPair, Integer>> result = collection.zip(Interval.oneTo(5));

        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, 2), 1), Tuples.pair(PrimitiveTuples.pair((byte) 2, 3), 2)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, 3), 1), Tuples.pair(PrimitiveTuples.pair((byte) 1, 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3);
        RichIterable<Pair<ByteIntPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, 2), 0), Tuples.pair(PrimitiveTuples.pair((byte) 2, 3), 1)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, 3), 0), Tuples.pair(PrimitiveTuples.pair((byte) 1, 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2)),
                FastList.newListWith(PrimitiveTuples.pair((byte) 2, 3)),
                FastList.newListWith(PrimitiveTuples.pair((byte) 3, 4))),
                collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size()
    {
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
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
        RichIterable<ByteIntPair> notEmpty = this.newWith((byte) 1, 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ByteIntPair> sumAggregator = (AtomicInteger aggregate, ByteIntPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 2, (byte) 2, 3, (byte) 3, 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ByteIntPair, Integer> sumAggregator = (Integer aggregate, ByteIntPair value) -> (int) (aggregate + value.getOne());
        RichIterable<ByteIntPair> collection = this.newWith((byte) 1, 1, (byte) 1, 2, (byte) 2, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }
}
