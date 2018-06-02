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
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.LongBooleanMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.LongBooleanPair;
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
import org.eclipse.collections.impl.block.factory.Procedures;
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
 * Abstract JUnit test for {@link LongBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitiveBooleanMapKeyValuesViewTest.stg.
 */
public abstract class AbstractLongBooleanMapKeyValuesViewTestCase
{
    public abstract LongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3);

    public abstract LongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2);

    public abstract LongBooleanMap newWithKeysValues(long key1, boolean value1);

    public abstract LongBooleanMap newEmpty();

    public RichIterable<LongBooleanPair> newWith()
    {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<LongBooleanPair> newWith(long key1, boolean value1)
    {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<LongBooleanPair> newWith(long key1, boolean value1, long key2, boolean value2)
    {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<LongBooleanPair> newWith(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3)
    {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(1L, true))));
    }

    @Test
    public void containsAllArray()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(1, 5L)));
    }

    @Test
    public void forEach()
    {
        MutableList<LongBooleanPair> result = Lists.mutable.of();
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        collection.forEach(Procedures.cast(result::add));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false));

        MutableList<LongBooleanPair> result2 = Lists.mutable.of();
        RichIterable<LongBooleanPair> collection2 = this.newWith(0L, false, 2L, true, 3L, false);
        collection2.forEach(Procedures.cast(result2::add));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false));
    }

    @Test
    public void forEachWith()
    {
        MutableBag<LongBooleanPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        collection.forEachWith((LongBooleanPair argument1, Integer argument2) ->
            {
                result.add(argument1);
                result2.add(argument2);
            }, 0);

        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
    }

    @Test
    public void forEachWithIndex()
    {
        MutableBag<LongBooleanPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 0L, true, 3L, false);
        collection.forEachWithIndex((LongBooleanPair object, int index) ->
            {
                elements.add(object);
                indexes.add(index);
            });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(0L, true), PrimitiveTuples.pair(3L, false)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
    }

    @Test
    public void select()
    {
        MutableList<LongBooleanPair> result = this.newWith(1L, false, 2L, true, 3L, false).select(PrimitiveTuples.pair(2L, true)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, false), result);
    }

    @Test
    public void selectWith()
    {
        MutableList<LongBooleanPair> result = this.newWith(1L, false, 2L, true, 3L, false).selectWith(Object::equals, PrimitiveTuples.pair(2L, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, false), result);
    }

    @Test
    public void selectWith_target()
    {
        HashBag<LongBooleanPair> result = this.newWith(1L, false, 2L, true, 3L, false).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, true), HashBag.<LongBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(3L, false)), result);
    }

    @Test
    public void reject()
    {
        MutableList<LongBooleanPair> result = this.newWith(1L, false, 2L, true, 3L, false).reject(Predicates.notEqual(PrimitiveTuples.pair(2L, true))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, false), result);
    }

    @Test
    public void rejectWith()
    {
        MutableList<LongBooleanPair> result = this.newWith(1L, false, 2L, true, 3L, false).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, true)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, true), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, false), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, false), result);
    }

    @Test
    public void rejectWith_target()
    {
        HashBag<LongBooleanPair> result = this.newWith(1L, false, 2L, true, 3L, false).rejectWith(Object::equals, PrimitiveTuples.pair(2L, true), HashBag.<LongBooleanPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(3L, false)), result);
    }

    @Test
    public void selectInstancesOf()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(1L, false, 2L, true, 3L, false);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(LongBooleanPair.class), PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(3L, false), PrimitiveTuples.pair(2L, true));
    }

    @Test
    public void collect()
    {
        RichIterable<Integer> result1 =
            this.newWith(1L, false, 2L, true, 3L, false).collect((LongBooleanPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Boolean> result2 =
            this.newWith(1L, false, 2L, true, 3L, false).collect(LongBooleanPair::getTwo);
        Assert.assertEquals(Bags.immutable.of(false, true, false), result2.toBag());
    }

    @Test
    public void collectBoolean()
    {
        BooleanIterable result =
            this.newWith(1L, false, 2L, true, 3L, false).collectBoolean((LongBooleanPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte()
    {
        ByteIterable result = this.newWith(1L, false, 2L, true, 3L, false).collectByte((LongBooleanPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar()
    {
        CharIterable result = this.newWith(1L, false, 2L, true, 3L, false).collectChar((LongBooleanPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble()
    {
        DoubleIterable result = this.newWith(1L, false, 2L, true, 3L, false).collectDouble((LongBooleanPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat()
    {
        FloatIterable result = this.newWith(1L, false, 2L, true, 3L, false).collectFloat((LongBooleanPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt()
    {
        IntIterable result = this.newWith(1L, false, 2L, true, 3L, false).collectInt((LongBooleanPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong()
    {
        LongIterable result = this.newWith(1L, false, 2L, true, 3L, false).collectLong((LongBooleanPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort()
    {
        ShortIterable result = this.newWith(1L, false, 2L, true, 3L, false).collectShort((LongBooleanPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Function<LongBooleanPair, MutableList<String>> function = (LongBooleanPair object) -> FastList.newListWith(String.valueOf(object));

        Verify.assertListsEqual(
                FastList.newListWith("1:false", "2:true", "3:false"),
                collection.flatCollect(function).toSortedList());

        Verify.assertSetsEqual(
                UnifiedSet.newSetWith("1:false", "2:true", "3:false"),
                collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2L, true), this.newWith(1L, false, 2L, true, 3L, false).detect(PrimitiveTuples.pair(2L, true)::equals));
        Assert.assertNull(this.newWith(1L, false, 2L, true, 3L, false).detect(PrimitiveTuples.pair(2, 4L)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1L, false), this.newWith(1L, false, 2L, true, 3L, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3L, false), this.newWith(1L, false, 2L, true, 3L, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1L, false), this.newWith(1L, false, 2L, true, 3L, false).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator()
    {
        Assert.assertEquals(PrimitiveTuples.pair(3L, false), this.newWith(1L, false, 2L, true, 3L, false).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2L, true),
            this.newWith(1L, false, 2L, true, 3L, false).minBy((LongBooleanPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy()
    {
        Assert.assertEquals(PrimitiveTuples.pair(1L, false),
            this.newWith(1L, false, 2L, true, 4L, false).maxBy((LongBooleanPair object) ->  (int) object.getOne() & 1));
    }

    @Test
    public void detectWith()
    {
        Assert.assertEquals(PrimitiveTuples.pair(2L, true), this.newWith(1L, false, 2L, true, 3L, false).detectWith(Object::equals, PrimitiveTuples.pair(2L, true)));
        Assert.assertNull(this.newWith(1L, false, 2L, true, 3L, false).detectWith(Object::equals, PrimitiveTuples.pair(2L, false)));
    }

    @Test
    public void detectIfNone()
    {
        Function0<LongBooleanPair> function = Functions0.value(PrimitiveTuples.pair(5L, true));
        Assert.assertEquals(PrimitiveTuples.pair(2L, true), this.newWith(1L, false, 2L, true, 3L, false).detectIfNone(PrimitiveTuples.pair(2L, true)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, true), this.newWith(1L, false, 2L, true, 3L, false).detectIfNone(PrimitiveTuples.pair(2L, false)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock()
    {
        Function0<LongBooleanPair> function = Functions0.value(PrimitiveTuples.pair(5L, true));
        Assert.assertEquals(PrimitiveTuples.pair(2L, true), this.newWith(1L, false, 2L, true, 3L, false).detectWithIfNone(
                Object::equals,
                PrimitiveTuples.pair(2L, true),
                function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, true), this.newWith(1L, false, 2L, true, 3L, false).detectWithIfNone(
                Object::equals,
                PrimitiveTuples.pair(2L, false),
                function));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.newWith(1L, false, 2L, true, 3L, false).allSatisfy(LongBooleanPair.class::isInstance));
        Assert.assertFalse(this.newWith(1L, false, 2L, true, 3L, false).allSatisfy(PrimitiveTuples.pair(2L, true)::equals));
    }

    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, false, 2L, true, 3L, false).allSatisfyWith(Predicates2.instanceOf(), LongBooleanPair.class));
        Assert.assertFalse(this.newWith(1L, false, 2L, true, 3L, false).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, true)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.newWith(1L, false, 2L, true, 3L, false).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1L, false, 2L, true, 3L, false).noneSatisfy(PrimitiveTuples.pair(2L, true)::equals));
    }

    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, false, 2L, true, 3L, false).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1L, false, 2L, true, 3L, false).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, true)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.newWith(1L, false, 2L, true, 3L, false).anySatisfy(PrimitiveTuples.pair(2L, true)::equals));
        Assert.assertFalse(this.newWith(1L, false, 2L, true, 3L, false).anySatisfy(PrimitiveTuples.pair(2, 5L)::equals));
    }

    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.newWith(1L, false, 2L, true, 3L, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, true)));
        Assert.assertFalse(this.newWith(1L, false, 2L, true, 3L, false).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, 5L)));
    }

    @Test
    public void count()
    {
        Assert.assertEquals(0, this.newWith(1L, false, 2L, true, 3L, false).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1L, false, 2L, true, 3L, false).count(LongBooleanPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1L, false, 2L, true, 3L, false).count(PrimitiveTuples.pair(2L, true)::equals));
    }

    @Test
    public void countWith()
    {
        Assert.assertEquals(0, this.newWith(1L, false, 2L, true, 3L, false).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1L, false, 2L, true, 3L, false).countWith(Predicates2.instanceOf(), LongBooleanPair.class));
        Assert.assertEquals(1, this.newWith(1L, false, 2L, true, 3L, false).countWith(Object::equals, PrimitiveTuples.pair(2L, true)));
    }

    @Test
    public void collectIf()
    {
        Verify.assertContainsAll(
                this.newWith(1L, false, 2L, true, 3L, false).collectIf(
                        LongBooleanPair.class::isInstance,
                        String::valueOf),
                "1:false", "2:true", "3:false");
        Verify.assertContainsAll(
                this.newWith(1L, false, 2L, true, 3L, false).collectIf(
                        LongBooleanPair.class::isInstance,
                        String::valueOf,
                        UnifiedSet.<String>newSet()),
                "1:false", "2:true", "3:false");
    }

    @Test
    public void collectWith()
    {
        Assert.assertEquals(
                Bags.mutable.of("3:false-", "2:true-", "1:false-"),

                this.newWith(1L, false, 2L, true, 3L, false)
                    .collectWith((LongBooleanPair argument1, String argument2) -> argument1 + argument2, "-")
                    .toBag());
    }

    @Test
    public void collectWith_target()
    {
        Assert.assertEquals(
                Bags.mutable.of("1:false-", "2:true-", "3:false-"),
                this.newWith(1L, false, 2L, true, 3L, false)
                    .collectWith((LongBooleanPair argument1, String argument2) -> argument1 + argument2, "-", HashBag.<String>newBag()));
    }

    @Test
    public void getFirst()
    {
        LongBooleanPair first = this.newWith(1L, false, 2L, true, 3L, false).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1L, false).equals(first)
                || PrimitiveTuples.pair(2L, true).equals(first)
                || PrimitiveTuples.pair(3L, false).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1L, false), this.newWith(1L, false).getFirst());
    }

    @Test
    public void getLast()
    {
        LongBooleanPair last = this.newWith(1L, false, 2L, true, 3L, false).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1L, false).equals(last)
                || PrimitiveTuples.pair(2L, true).equals(last)
                || PrimitiveTuples.pair(3L, false).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1L, false), this.newWith(1L, false).getLast());
    }

    @Test
    public void isEmpty()
    {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1L, false));
        Assert.assertTrue(this.newWith(1L, false).notEmpty());
    }

    @Test
    public void iterator()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 0L, true, 3L, false);
        MutableBag<LongBooleanPair> actual = Bags.mutable.of();
        Iterator<LongBooleanPair> iterator = objects.iterator();
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
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        Iterator<LongBooleanPair> iterator = objects.iterator();
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
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        Iterator<LongBooleanPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        Long result = objects.injectInto(1L, (Long argument1, LongBooleanPair argument2) -> (long) (argument1 + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(Long.valueOf(9), result);
    }

    @Test
    public void injectIntoInt()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        int result = objects.injectInto(1, (int intParameter, LongBooleanPair argument2) -> (int) (intParameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoLong()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        long result = objects.injectInto(1L, (long parameter, LongBooleanPair argument2) -> (long) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9, result);
    }

    @Test
    public void injectIntoDouble()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        double result = objects.injectInto(1.0, (double parameter, LongBooleanPair argument2) -> (double) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        float result = objects.injectInto(1.0f, (float parameter, LongBooleanPair argument2) -> (float) (parameter + argument2.getOne() + (argument2.getTwo() ? 0 : 1)));
        Assert.assertEquals(9.0, result, 0.0);
    }

    @Test
    public void sumFloat()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        double actual = objects.sumOfFloat((LongBooleanPair each) -> (float) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumDouble()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        double actual = objects.sumOfDouble((LongBooleanPair each) -> (double) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8.0, actual, 0.0);
    }

    @Test
    public void sumInteger()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        long actual = objects.sumOfInt((LongBooleanPair each) -> (int) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void sumLong()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        long actual = objects.sumOfLong((LongBooleanPair each) -> (long) (each.getOne() + (each.getTwo() ? 0 : 1)));
        Assert.assertEquals(8, actual);
    }

    @Test
    public void toArray()
    {
        RichIterable<LongBooleanPair> objects = this.newWith(1L, false, 2L, true, 3L, false);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        LongBooleanPair[] array2 = objects.toArray(new LongBooleanPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition()
    {
        PartitionIterable<LongBooleanPair> result = this.newWith(1L, false, 2L, true, 3L, false).partition(PrimitiveTuples.pair(2L, true)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2L, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1L, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3L, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void partitionWith()
    {
        PartitionIterable<LongBooleanPair> result = this.newWith(1L, false, 2L, true, 3L, false).partitionWith(Object::equals, PrimitiveTuples.pair(2L, true));
        Verify.assertContains(PrimitiveTuples.pair(2L, true), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1L, false), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3L, false), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList()
    {
        MutableList<LongBooleanPair> list = this.newWith(1L, false, 2L, true, 3L, false).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false));
    }

    @Test
    public void toBag()
    {
        MutableBag<LongBooleanPair> bag = this.newWith(1L, false, 2L, true, 3L, false).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false));
    }

    @Test
    public void toSortedList_natural_ordering()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableList<LongBooleanPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false)), list);
    }

    @Test
    public void toSortedList_with_comparator()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableList<LongBooleanPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(1L, false)), list);
    }

    @Test
    public void toSortedListBy()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableList<LongBooleanPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false)), list);
    }

    @Test
    public void toSortedBag_natural_ordering()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableSortedBag<LongBooleanPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false)), bag);
    }

    @Test
    public void toSortedBag_with_comparator()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableSortedBag<LongBooleanPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(1L, false)), bag);
    }

    @Test
    public void toSortedBagBy()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableSortedBag<LongBooleanPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableSortedSet<LongBooleanPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false)), set);
    }

    @Test
    public void toSortedSet_with_comparator()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableSortedSet<LongBooleanPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(),
                PrimitiveTuples.pair(3L, false),
                PrimitiveTuples.pair(2L, true),
                PrimitiveTuples.pair(1L, false)),
                set);
    }

    @Test
    public void toSortedSetBy()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(2L, true, 1L, false, 3L, false);
        MutableSortedSet<LongBooleanPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false)), set);
    }

    @Test
    public void toSet()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(1L, false, 2L, true, 3L, false);
        MutableSet<LongBooleanPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1L, false), PrimitiveTuples.pair(2L, true), PrimitiveTuples.pair(3L, false));
    }

    @Test
    public void toMap()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(1L, false, 2L, true, 3L, false);
        MutableMap<String, String> map =
                pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), map);
    }

    @Test
    public void toSortedMap()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(1L, false, 2L, true, 3L, false);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), map);
    }

    @Test
    public void toSortedMap_with_comparator()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(1L, false, 2L, true, 3L, false);
        MutableSortedMap<String, String> map =
                pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), map);
    }

    @Test
    public void toSortedMapBy()
    {
        RichIterable<LongBooleanPair> pairs = this.newWith(1L, false, 2L, true, 3L, false);
        MutableSortedMap<String, String> map =
                pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:false", "1:false", "2:true", "2:true", "3:false", "3:false"), map);
    }

    @Test
    public void testToString()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true);
        Assert.assertTrue("[1:false, 2:true]".equals(collection.toString())
                || "[2:true, 1:false]".equals(collection.toString()));
    }

    @Test
    public void makeString()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Function<LongBooleanPair, Boolean> function = (LongBooleanPair object) -> PrimitiveTuples.pair(1L, false).equals(object);

        Multimap<Boolean, LongBooleanPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, false)));
    }

    @Test
    public void groupByEach()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Function<LongBooleanPair, MutableList<Boolean>> function = (LongBooleanPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1L, false).equals(object));

        Multimap<Boolean, LongBooleanPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, false)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, true)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, false)));
    }

    @Test
    public void zip()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true);
        RichIterable<Pair<LongBooleanPair, Integer>> result = collection.zip(Interval.oneTo(5));

        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, false), 1), Tuples.pair(PrimitiveTuples.pair(2L, true), 2)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, true), 1), Tuples.pair(PrimitiveTuples.pair(1L, false), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true);
        RichIterable<Pair<LongBooleanPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, false), 0), Tuples.pair(PrimitiveTuples.pair(2L, true), 1)).equals(result.toBag())
                || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, true), 0), Tuples.pair(PrimitiveTuples.pair(1L, false), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1L, false)),
                FastList.newListWith(PrimitiveTuples.pair(2L, true)),
                FastList.newListWith(PrimitiveTuples.pair(3L, false))),
                collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size()
    {
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
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
        RichIterable<LongBooleanPair> notEmpty = this.newWith(1L, false);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, LongBooleanPair> sumAggregator = (AtomicInteger aggregate, LongBooleanPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 2L, true, 3L, false);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:false").intValue());
        Assert.assertEquals(2, aggregation.get("2:true").intValue());
        Assert.assertEquals(1, aggregation.get("1:false").intValue());
    }

    @Test
    public void aggregateByNonMutating()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, LongBooleanPair, Integer> sumAggregator = (Integer aggregate, LongBooleanPair value) -> (int) (aggregate + value.getOne());
        RichIterable<LongBooleanPair> collection = this.newWith(1L, false, 1L, false, 2L, true);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:true").intValue());
        Assert.assertEquals(1, aggregation.get("1:false").intValue());
    }
}
