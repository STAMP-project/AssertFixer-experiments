/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.MutableByteBag;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.api.partition.PartitionIterable;
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
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.factory.StringPredicates;
import org.eclipse.collections.impl.block.factory.StringPredicates2;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.StringIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongObjectSingletonMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectSingletonMapTest.stg.
 */
public class ImmutableLongObjectSingletonMapTest extends AbstractImmutableLongObjectMapTestCase
{
    @Override
    protected ImmutableLongObjectMap<String> classUnderTest()
    {
        return LongObjectHashMap.newWithKeysValues(0L, "zero").toImmutable();
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.classUnderTest().containsValue(null));
        Assert.assertTrue(this.classUnderTest().containsValue("zero"));
        Assert.assertFalse(this.classUnderTest().containsValue("thirtyOne"));
        Assert.assertFalse(this.classUnderTest().containsValue("thirtyTwo"));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.classUnderTest().contains(null));
        Assert.assertTrue(this.classUnderTest().contains("zero"));
        Assert.assertFalse(this.classUnderTest().contains("thirtyOne"));
        Assert.assertFalse(this.classUnderTest().contains("thirtyTwo"));
    }

    @Override
    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith("zero")));
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith()));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("two", "one", "nine")));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith()));
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith("zero")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("two", "one", "nine")));
    }

    @Override
    @Test
    public void containsAllArguments()
    {
        Assert.assertTrue(this.classUnderTest().containsAllArguments());
        Assert.assertTrue(this.classUnderTest().containsAllArguments("zero"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "thirtyOne"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "thirtyOne", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "one", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("two", "one", "nine"));
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.classUnderTest().containsKey(0L));
        Assert.assertFalse(this.classUnderTest().containsKey(31L));
        Assert.assertFalse(this.classUnderTest().containsKey(32L));
        Assert.assertFalse(this.classUnderTest().containsKey(1L));
        Assert.assertFalse(this.classUnderTest().containsKey(5L));
        Assert.assertFalse(this.classUnderTest().containsKey(35L));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Function0<String> ifAbsent = () -> "ifAbsent";

        Assert.assertEquals("zero", this.classUnderTest().getIfAbsent(0L, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(31L, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(32L, ifAbsent));

        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(1L, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent(33L, ifAbsent));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals("zero", this.classUnderTest().get(0L));
        Assert.assertNull(this.classUnderTest().get(31L));
        Assert.assertNull(this.classUnderTest().get(32L));
        Assert.assertNull(this.classUnderTest().get(1L));
        Assert.assertNull(this.classUnderTest().get(33L));
    }

    @Override
    @Test
    public void iterator()
    {
        Iterator<String> iterator = this.classUnderTest().iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals("zero", iterator.next());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getFirst()
    {
        Assert.assertEquals("zero", this.classUnderTest().getFirst());
    }

    @Override
    @Test
    public void getLast()
    {
        Assert.assertEquals("zero", this.classUnderTest().getLast());
    }

    @Override
    @Test
    public void getOnly()
    {
        Assert.assertEquals("zero", this.classUnderTest().getOnly());
    }

    @Override
    @Test
    public void tap()
    {
        StringBuilder concat = new StringBuilder();
        ImmutableLongObjectMap<String> map = this.classUnderTest();
        Assert.assertSame(map,  map.tap(concat::append));
        Assert.assertEquals("zero", concat.toString());
    }

    @Override
    @Test
    public void forEach()
    {
        String[] concat = {""};

        this.classUnderTest().forEach(Procedures.cast(each -> concat[0] += each));

        Assert.assertEquals("zero", concat[0]);
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        String[] concat = {""};

        this.classUnderTest().forEachWithIndex((String each, int parameter) ->
            {
                concat[0] += each;
                concat[0] += parameter;
            });

        Assert.assertEquals("zero0", concat[0]);
    }

    @Override
    @Test
    public void forEachWith()
    {
        String[] concat = {""};

        this.classUnderTest().forEachWith((String argument1, String argument2) ->
            {
                concat[0] += argument1;
                concat[0] += argument2;
            }, "-");

        Assert.assertEquals("zero-", concat[0]);
    }

    @Override
    @Test
    public void forEachValue()
    {
        String[] concat = {""};

        this.classUnderTest().forEachValue((String each) -> concat[0] += each);

        Assert.assertEquals("zero", concat[0]);
    }

    @Override
    @Test
    public void forEachKey()
    {
        long[] sum = new long[4];

        this.classUnderTest().forEachKey((long each) -> sum[0] += each);

        Assert.assertEquals(0L, sum[0]);
    }

    @Override
    @Test
    public void forEachKeyValue()
    {
        String[] concat = {""};

        this.classUnderTest().forEachKeyValue((long each, String parameter) ->
            {
                concat[0] += each;
                concat[0] += parameter;
            });

        Assert.assertEquals("0zero", concat[0]);
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(
                LongObjectHashMap.newWithKeysValues(0L, "zero"),
                this.classUnderTest().select((long value, String object) -> value == 0));

        Verify.assertIterableEmpty(this.classUnderTest().select((long value, String object) -> value != 0));

        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().select(Predicates.equal("zero")));
        Verify.assertIterableEmpty(this.classUnderTest().select(Predicates.equal("one")));

        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().select(Predicates.equal("zero"), target));
        Assert.assertEquals(HashBag.newBagWith("zero"), target);
    }

    @Override
    public void selectWith()
    {
        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().selectWith(Object::equals, "zero"));

        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().selectWith(Object::equals, "zero", target));
        Assert.assertEquals(HashBag.newBagWith("zero"), target);
    }

    @Override
    @Test
    public void selectInstancesOf()
    {
        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().selectInstancesOf(String.class));
        Verify.assertIterableEmpty(this.classUnderTest().selectInstancesOf(Integer.class));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(
                LongObjectHashMap.newWithKeysValues(0L, "zero"),
                this.classUnderTest().reject((value, object) -> value != 0));

        Verify.assertIterableEmpty(this.classUnderTest().reject((value, object) -> value == 0));

        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().reject(Predicates.equal("one")));
        Verify.assertIterableEmpty(this.classUnderTest().reject(Predicates.equal("zero")));

        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().reject(Predicates.equal("one"), target));
        Assert.assertEquals(HashBag.newBagWith("zero"), target);
    }

    @Override
    @Test
    public void rejectWith()
    {
        Assert.assertEquals(HashBag.newBagWith("zero"), this.classUnderTest().rejectWith(Object::equals, "one"));
        Verify.assertIterableEmpty(this.classUnderTest().rejectWith(Object::equals, "zero"));

        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().rejectWith(Object::equals, "one", target));
        Assert.assertEquals(HashBag.newBagWith("zero"), target);
    }

    @Override
    @Test
    public void detect()
    {
        Assert.assertEquals("zero", this.classUnderTest().detect(Predicates.equal("zero")));
        Assert.assertNull(this.classUnderTest().detect(Predicates.equal("one")));
    }

    @Override
    @Test
    public void detectWith()
    {
        Assert.assertEquals("zero", this.classUnderTest().detectWith(Object::equals, "zero"));
        Assert.assertNull(this.classUnderTest().detectWith(Object::equals, "one"));
    }

    @Override
    @Test
    public void detectOptional()
    {
        Assert.assertEquals(Optional.of("zero"), this.classUnderTest().detectOptional(Predicates.equal("zero")));
        Assert.assertEquals(Optional.empty(), this.classUnderTest().detectOptional(Predicates.equal("one")));
    }

    @Override
    @Test
    public void detectWithOptional()
    {
        Assert.assertEquals(Optional.of("zero"), this.classUnderTest().detectWithOptional(Object::equals, "zero"));
        Assert.assertEquals(Optional.empty(), this.classUnderTest().detectWithOptional(Object::equals, "one"));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        Assert.assertEquals("zero", this.classUnderTest().detectIfNone(Predicates.equal("zero"), Functions0.value("default")));
        Assert.assertEquals("default", this.classUnderTest().detectIfNone(Predicates.equal("one"), Functions0.value("default")));
    }

    @Override
    @Test
    public void detectWithIfNone()
    {
        Assert.assertEquals("zero", this.classUnderTest().detectWithIfNone(Object::equals, "zero", Functions0.value("default")));
        Assert.assertEquals("default", this.classUnderTest().detectWithIfNone(Object::equals, "one", Functions0.value("default")));
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(1, this.classUnderTest().count(Predicates.equal("zero")));
        Assert.assertEquals(0, this.classUnderTest().count(Predicates.equal("one")));
    }

    @Override
    @Test
    public void countWith()
    {
        Assert.assertEquals(1, this.classUnderTest().countWith(Object::equals, "zero"));
        Assert.assertEquals(0, this.classUnderTest().countWith(Object::equals, "one"));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Verify.assertAnySatisfy(this.classUnderTest(), StringPredicates.endsWith("o"));
        Assert.assertFalse(this.classUnderTest().anySatisfy(Predicates.equal("ten")));
    }

    @Override
    @Test
    public void anySatisfyWith()
    {
        Assert.assertTrue(this.classUnderTest().anySatisfyWith(StringPredicates2.endsWith(), "o"));
        Assert.assertFalse(this.classUnderTest().anySatisfyWith(Object::equals, "ten"));
    }

    @Override
    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().allSatisfy(StringPredicates.endsWith("o")));
        Assert.assertFalse(this.classUnderTest().allSatisfy(Predicates.equal("nine")));
    }

    @Override
    @Test
    public void allSatisfyWith()
    {
        Assert.assertTrue(this.classUnderTest().allSatisfyWith(StringPredicates2.contains(), "o"));
        Assert.assertFalse(this.classUnderTest().allSatisfyWith(Object::equals, "nine"));
    }

    @Override
    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(StringPredicates.endsWith("o")));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(Predicates.equal("ten")));
    }

    @Override
    @Test
    public void noneSatisfyWith()
    {
        Assert.assertTrue(this.classUnderTest().noneSatisfyWith(StringPredicates2.notContains(), "e"));
        Assert.assertFalse(this.classUnderTest().noneSatisfyWith(StringPredicates2.endsWith(), "o"));
    }

    @Override
    @Test
    public void partition()
    {
        PartitionIterable<String> result = this.classUnderTest().partition(StringPredicates.endsWith("ne"));
        Verify.assertIterableEmpty(result.getSelected());
        Assert.assertEquals(HashBag.newBagWith("zero"), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith()
    {
        PartitionIterable<String> result = this.classUnderTest().partitionWith(StringPredicates2.endsWith(), "ro");
        Assert.assertEquals(HashBag.newBagWith("zero"), result.getSelected());
        Verify.assertIterableEmpty(result.getRejected());
    }

    @Test
    public void min_withComparator()
    {
        Assert.assertEquals("zero", this.classUnderTest().min(Comparators.naturalOrder()));
    }

    @Test
    public void max_withComparator()
    {
        Assert.assertEquals("zero", this.classUnderTest().max(Comparators.naturalOrder()));
    }

    @Override
    @Test
    public void minBy()
    {
        Assert.assertEquals("zero", this.classUnderTest().minBy(String::valueOf));
    }

    @Override
    @Test
    public void maxBy()
    {
        Assert.assertEquals("zero", this.classUnderTest().maxBy(String::valueOf));
    }

    @Override
    @Test
    public void min()
    {
        Assert.assertEquals("zero", this.classUnderTest().min());
    }

    @Override
    @Test
    public void max()
    {
        Assert.assertEquals("zero", this.classUnderTest().max());
    }

    @Override
    @Test
    public void sumOfInt()
    {
        Assert.assertEquals(4L, this.classUnderTest().sumOfInt(String::length));
    }

    @Override
    @Test
    public void sumOfFloat()
    {
        Assert.assertEquals(4.0d, this.classUnderTest().sumOfFloat(value -> (float) value.length()), 0.0d);
    }

    @Override
    @Test
    public void sumOfLong()
    {
        Assert.assertEquals(4L, this.classUnderTest().sumOfLong(value -> (long) value.length()));
    }

    @Override
    @Test
    public void sumOfDouble()
    {
        Assert.assertEquals(4.0d, this.classUnderTest().sumOfDouble(value -> (double) value.length()), 0.0d);
    }

    @Override
    @Test
    public void collectIf()
    {
        Assert.assertEquals(
                HashBag.newBagWith("ZERO"),
                this.classUnderTest().collectIf(StringPredicates.endsWith("ro"), StringFunctions.toUpperCase()));
        Verify.assertIterableEmpty(this.classUnderTest().collectIf(StringPredicates.endsWith("ne"), StringFunctions.toUpperCase()));
        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(
                target,
                this.classUnderTest().collectIf(StringPredicates.endsWith("ro"), StringFunctions.toUpperCase(), target));
        Assert.assertEquals(HashBag.newBagWith("ZERO"), target);
    }

    @Override
    @Test
    public void flatCollect()
    {
        Verify.assertBagsEqual(HashBag.newBagWith('z', 'e', 'r', 'o'), this.classUnderTest().flatCollect(StringIterate::toSet));
        MutableBag<Character> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().flatCollect(StringIterate::toSet, target));
        Verify.assertBagsEqual(HashBag.newBagWith('z', 'e', 'r', 'o'), target);
    }

    @Override
    @Test
    public void collect()
    {
        Assert.assertEquals(HashBag.newBagWith("ZERO"), this.classUnderTest().collect(StringFunctions.toUpperCase()));

        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().collect(StringFunctions.toUpperCase(), target));
        Assert.assertEquals(HashBag.newBagWith("ZERO"), target);
    }

    @Override
    @Test
    public void collectWith()
    {
        Function2<String, String, String> function = (String each, String param) -> each.toUpperCase() + param;
        Assert.assertEquals(HashBag.newBagWith("ZERO!"), this.classUnderTest().collectWith(function, "!"));

        MutableBag<String> target = HashBag.newBag();
        Assert.assertSame(target, this.classUnderTest().collectWith(function, "!", target));
        Assert.assertEquals(HashBag.newBagWith("ZERO!"), target);
    }

    @Override
    @Test
    public void collectBoolean()
    {
        Assert.assertEquals(
                BooleanHashBag.newBagWith(true),
                this.newWithKeysValues(0L, "true").collectBoolean(StringFunctions.toPrimitiveBoolean()));
    }

    @Override
    @Test
    public void collectBoolean_withTarget()
    {
        MutableBooleanBag target = new BooleanHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0L, "true").collectBoolean(StringFunctions.toPrimitiveBoolean(), target));
        Assert.assertEquals(BooleanHashBag.newBagWith(true), target);
    }

    @Override
    @Test
    public void collectByte()
    {
        Assert.assertEquals(
                ByteHashBag.newBagWith((byte) 0),
                this.newWithKeysValues(0L, "0").collectByte(Byte::parseByte));
    }

    @Override
    @Test
    public void collectByte_withTarget()
    {
        MutableByteBag target = new ByteHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0L, "0").collectByte(Byte::parseByte, target));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0), target);
    }

    @Override
    @Test
    public void collectChar()
    {
        Assert.assertEquals(
                CharHashBag.newBagWith((char) 0),
                this.newWithKeysValues(0L, "0").collectChar(StringFunctions.toPrimitiveChar()));
    }

    @Override
    @Test
    public void collectChar_withTarget()
    {
        MutableCharBag target = new CharHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0L, "0").collectChar(StringFunctions.toPrimitiveChar(), target));
        Assert.assertEquals(CharHashBag.newBagWith((char) 0), target);
    }

    @Override
    @Test
    public void collectDouble()
    {
        Assert.assertEquals(
                DoubleHashBag.newBagWith((double) 0),
                this.newWithKeysValues(0L, "0").collectDouble(Double::parseDouble));
    }

    @Override
    @Test
    public void collectDouble_withTarget()
    {
        MutableDoubleBag target = new DoubleHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0L, "0").collectDouble(Double::parseDouble, target));
        Assert.assertEquals(DoubleHashBag.newBagWith((double) 0), target);
    }

    @Override
    @Test
    public void collectFloat()
    {
        Assert.assertEquals(
                FloatHashBag.newBagWith((float) 0),
                this.newWithKeysValues(0L, "0").collectFloat(Float::parseFloat));
    }

    @Override
    @Test
    public void collectFloat_withTarget()
    {
        MutableFloatBag target = new FloatHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0L, "0").collectFloat(Float::parseFloat, target));
        Assert.assertEquals(FloatHashBag.newBagWith((float) 0), target);
    }

    @Override
    @Test
    public void collectInt()
    {
        Assert.assertEquals(
                IntHashBag.newBagWith((int) 0),
                this.newWithKeysValues(0L, "0").collectInt(Integer::parseInt));
    }

    @Override
    @Test
    public void collectInt_withTarget()
    {
        MutableIntBag target = new IntHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0L, "0").collectInt(Integer::parseInt, target));
        Assert.assertEquals(IntHashBag.newBagWith((int) 0), target);
    }

    @Override
    @Test
    public void collectLong()
    {
        Assert.assertEquals(
                LongHashBag.newBagWith(0L),
                this.newWithKeysValues(0L, "0").collectLong(Long::parseLong));
    }

    @Override
    @Test
    public void collectLong_withTarget()
    {
        MutableLongBag target = new LongHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0L, "0").collectLong(Long::parseLong, target));
        Assert.assertEquals(LongHashBag.newBagWith(0L), target);
    }

    @Override
    @Test
    public void collectShort()
    {
        Assert.assertEquals(
                ShortHashBag.newBagWith((short) 0),
                this.newWithKeysValues(0L, "0").collectShort(Short::parseShort));
    }

    @Override
    @Test
    public void collectShort_withTarget()
    {
        MutableShortBag target = new ShortHashBag();
        Assert.assertSame(target, this.newWithKeysValues(0L, "0").collectShort(Short::parseShort, target));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0), target);
    }

    @Override
    @Test
    public void toSortedBag()
    {
        ImmutableLongObjectMap<String> map1 = this.classUnderTest();
        ImmutableLongObjectMap<String> map2 = this.classUnderTest();

        Verify.assertSortedBagsEqual(TreeBag.newBagWith("zero"), map1.toSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparator.<String>reverseOrder(), "zero"), map2.toSortedBag(Comparator.<String>reverseOrder()));
    }

    @Override
    @Test
    public void toSortedBagBy()
    {
        ImmutableLongObjectMap<String> map1 = this.classUnderTest();

        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(String::valueOf), "zero"), map1.toSortedBagBy(String::valueOf));
    }
}
