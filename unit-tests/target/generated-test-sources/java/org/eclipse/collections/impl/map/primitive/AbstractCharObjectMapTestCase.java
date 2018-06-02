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

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleObjectToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatObjectToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntObjectToIntFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongObjectToLongFunction;
import org.eclipse.collections.api.block.predicate.Predicate;
import org.eclipse.collections.api.block.predicate.Predicate2;
import org.eclipse.collections.api.block.predicate.primitive.CharObjectPredicate;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.primitive.ImmutableCharObjectMap;
import org.eclipse.collections.api.map.primitive.CharObjectMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
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
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.StringFunctions;
import org.eclipse.collections.impl.block.factory.StringPredicates;
import org.eclipse.collections.impl.block.factory.StringPredicates2;
import org.eclipse.collections.impl.factory.primitive.CharObjectMaps;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMapTest;
import org.eclipse.collections.impl.multimap.list.FastListMultimap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.string.immutable.CharAdapter;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitiveObjectMapTestCase.stg.
 */
public abstract class AbstractCharObjectMapTestCase
{
    protected abstract CharObjectMap<String> classUnderTest();

    protected abstract <T> CharObjectMap<T> newWithKeysValues(char key1, T value1);

    protected abstract <T> CharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2);

    protected abstract <T> CharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2, char key3, T value3);

    protected abstract <T> CharObjectMap<T> getEmptyMap();

    @Test
    public void keySet()
    {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0), this.newWithKeysValues((char) 0, "zero").keySet());
        Assert.assertEquals(CharHashSet.newSetWith((char) 0, (char) 1, (char) 9),
                this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine").keySet());
    }

    @Test
    public void values()
    {
        Verify.assertEmpty(this.getEmptyMap().values());

        CharObjectMap<String> map = this.newWithKeysValues((char) 0, "zero");
        Verify.assertSize(1, map.values());
        Verify.assertContains("zero", map.values());

        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        Verify.assertSize(3, map1.values());
        Verify.assertContainsAll(map1.values(), "zero", "one", "nine");
    }

    @Test
    public void select()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 0, "zero", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 1, "one", (char) 9, "nine");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 5, "five", (char) 9, "nine");

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 9, "nine"),
            map1.select((char value, String object) -> (value % 2) != 0));

        CharObjectPredicate<String> keyGreaterThanOrEqualToSeven = (char value, String object) -> value <= 7;

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 1, "one"), map1.select(keyGreaterThanOrEqualToSeven));

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero"), map2.select(keyGreaterThanOrEqualToSeven));

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), map3.select(keyGreaterThanOrEqualToSeven));

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 5, "five"), map4.select(keyGreaterThanOrEqualToSeven));

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 9, "nine"),
            map1.select((char value, String object) -> object.endsWith("ne")));

        RichIterable<String> actual1 = map1.select(StringPredicates.endsWith("ne"));
        Assert.assertTrue(HashBag.newBagWith("one", "nine").equals(actual1));

        Assert.assertEquals(HashBag.newBagWith("nine"), map1.select(Predicates.equal("nine")));

        Assert.assertEquals(HashBag.newBagWith("zero"), map1.select(StringPredicates.endsWith("o")));

        Assert.assertEquals(HashBag.newBagWith("nine"), map1.select(Predicates.equal("nine"), HashBag.<String>newBag()));

        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.select(StringPredicates.endsWith("ne"), HashBag.<String>newBag()));

        Assert.assertEquals(HashBag.newBagWith("zero"), map1.select(StringPredicates.endsWith("o"), HashBag.<String>newBag()));
    }

    @Test
    public void selectWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.selectWith(StringPredicates2.endsWith(), "ne"));

        Assert.assertEquals(HashBag.newBagWith("nine"), map1.selectWith(Object::equals, "nine"));

        Assert.assertEquals(HashBag.newBagWith("zero"), map1.selectWith(StringPredicates2.endsWith(), "o"));
    }

    @Test
    public void selectWith_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.selectWith(StringPredicates2.endsWith(), "ne", HashBag.<String>newBag()));

        Assert.assertEquals(HashBag.newBagWith("nine"), map1.selectWith(Object::equals, "nine", HashBag.<String>newBag()));

        Assert.assertEquals(HashBag.newBagWith("zero"), map1.selectWith(StringPredicates2.endsWith(), "o", HashBag.<String>newBag()));
    }

    @Test
    public void selectInstancesOf()
    {
        CharObjectMap<Number> numbers = this.<Number>newWithKeysValues((char) 0, 0, (char) 1, 1.0, (char) 5, 5.0);

        Assert.assertEquals(HashBag.newBagWith(0), numbers.selectInstancesOf(Integer.class));
        Assert.assertEquals(HashBag.newBagWith(1.0, 5.0), numbers.selectInstancesOf(Double.class));
    }

    @Test
    public void collect()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("ZERO", "ONE", "NINE"), map1.collect(StringFunctions.toUpperCase()));
        Assert.assertEquals(HashBag.newBagWith("ZERO", "ONE", "NINE"), map1.collect(StringFunctions.toUpperCase(), HashBag.<String>newBag()));
    }

    @Test
    public void collectBoolean()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "true", (char) 1, "false", (char) 2, "nah");

        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), map1.collectBoolean(StringFunctions.toPrimitiveBoolean()));
    }

    @Test
    public void collectBoolean_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "true", (char) 1, "false", (char) 2, "nah");
        BooleanHashBag target = new BooleanHashBag();
        Assert.assertSame(target, map1.collectBoolean(StringFunctions.toPrimitiveBoolean(), target));
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), target);
    }

    @Test
    public void collectByte()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");

        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 9), map1.collectByte(Byte::parseByte));
    }

    @Test
    public void collectByte_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");
        ByteHashBag target = new ByteHashBag();
        Assert.assertSame(target, map1.collectByte(Byte::parseByte, target));
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 0, (byte) 1, (byte) 9), target);
    }

    @Test
    public void collectChar()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");

        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 9), map1.collectChar(StringFunctions.toPrimitiveChar()));
    }

    @Test
    public void collectChar_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");
        CharHashBag target = new CharHashBag();
        Assert.assertSame(target, map1.collectChar(StringFunctions.toPrimitiveChar(), target));
        Assert.assertEquals(CharHashBag.newBagWith((char) 0, (char) 1, (char) 9), target);
    }

    @Test
    public void collectDouble()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");

        Assert.assertEquals(DoubleHashBag.newBagWith(0.0d, 1.0d, 9.0d), map1.collectDouble(Double::parseDouble));
    }

    @Test
    public void collectDouble_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");
        DoubleHashBag target = new DoubleHashBag();
        Assert.assertSame(target, map1.collectDouble(Double::parseDouble, target));
        Assert.assertEquals(DoubleHashBag.newBagWith(0.0d, 1.0d, 9.0d), target);
    }

    @Test
    public void collectFloat()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");

        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 9.0f), map1.collectFloat(Float::parseFloat));
    }

    @Test
    public void collectFloat_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");
        FloatHashBag target = new FloatHashBag();
        Assert.assertSame(target, map1.collectFloat(Float::parseFloat, target));
        Assert.assertEquals(FloatHashBag.newBagWith(0.0f, 1.0f, 9.0f), target);
    }

    @Test
    public void collectInt()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");

        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 9), map1.collectInt(Integer::parseInt));
    }

    @Test
    public void collectInt_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");
        IntHashBag target = new IntHashBag();
        Assert.assertSame(target, map1.collectInt(Integer::parseInt, target));
        Assert.assertEquals(IntHashBag.newBagWith(0, 1, 9), target);
    }

    @Test
    public void collectLong()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");

        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 9L), map1.collectLong(Long::parseLong));
    }

    @Test
    public void collectLong_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");
        LongHashBag target = new LongHashBag();
        Assert.assertSame(target, map1.collectLong(Long::parseLong, target));
        Assert.assertEquals(LongHashBag.newBagWith(0L, 1L, 9L), target);
    }

    @Test
    public void collectShort()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");

        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 9), map1.collectShort(Short::parseShort));
    }

    @Test
    public void collectShort_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "0", (char) 1, "1", (char) 2, "9");
        ShortHashBag target = new ShortHashBag();
        Assert.assertSame(target, map1.collectShort(Short::parseShort, target));
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 9), target);
    }

    @Test
    public void collectWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("ZERO!", "ONE!", "NINE!"),
            map1.collectWith((String argument1, String argument2) -> argument1.toUpperCase() + argument2, "!"));
    }

    @Test
    public void collectWithTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("ZERO!", "ONE!", "NINE!"),
            map1.collectWith((String argument1, String argument2) -> argument1.toUpperCase() + argument2, "!", HashBag.<String>newBag()));
    }

    @Test
    public void collectIf()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("ONE", "NINE"), map1.collectIf(StringPredicates.endsWith("ne"), StringFunctions.toUpperCase()));
        Assert.assertEquals(HashBag.newBagWith("ZERO"), map1.collectIf(StringPredicates.endsWith("o"), StringFunctions.toUpperCase()));
        Assert.assertEquals(HashBag.newBagWith("ZERO"), map1.collectIf(StringPredicates.endsWith("o"), StringFunctions.toUpperCase(), HashBag.<String>newBag()));
    }

    @Test
    public void flatCollect()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "five", (char) 9, "nine");

        Function<String, MutableList<Character>> toChars = (String object) ->
            {
                MutableList<Character> list = FastList.newList();
                char[] chars = object.toCharArray();
                for (char aChar : chars)
                {
                    list.add(aChar);
                }
                return list;
            };

        Assert.assertEquals(UnifiedSet.newSetWith('z', 'e', 'r', 'o', 'n', 'i'), map1.flatCollect(toChars).toSet());
        Assert.assertEquals(UnifiedSet.newSetWith('o', 'n', 'e', 'i'), map2.flatCollect(toChars).toSet());
        Assert.assertEquals(UnifiedSet.newSetWith('f', 'i', 'v', 'e', 'n'), map3.flatCollect(toChars).toSet());
        Assert.assertEquals(UnifiedSet.newSetWith('f', 'i', 'v', 'e', 'n'), map3.flatCollect(toChars, UnifiedSet.<Character>newSet()));
    }

    @Test
    public void detect()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        Assert.assertTrue("one".equals(map1.detect(StringPredicates.endsWith("ne"))) || "nine".equals(map1.detect(StringPredicates.endsWith("ne"))));
        Assert.assertEquals("zero", map1.detect(StringPredicates.endsWith("o")));
        Assert.assertEquals("nine", map1.detect(Predicates.equal("nine")));
        Assert.assertNull(map1.detect(Predicates.equal("ten")));
    }

    @Test
    public void detectWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        Assert.assertTrue("one".equals(map1.detectWith(StringPredicates2.endsWith(), "ne")) || "nine".equals(map1.detectWith(StringPredicates2.endsWith(), "ne")));
        Assert.assertEquals("zero", map1.detectWith(StringPredicates2.endsWith(), "o"));
        Assert.assertEquals("nine", map1.detectWith(Object::equals, "nine"));
        Assert.assertNull(map1.detectWith(Object::equals, "ten"));
    }

    @Test
    public void detectOptional()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        Assert.assertTrue(Optional.of("one").equals(map1.detectOptional(StringPredicates.endsWith("ne"))) || Optional.of("nine").equals(map1.detectOptional(StringPredicates.endsWith("ne"))));
        Assert.assertEquals(Optional.of("zero"), map1.detectOptional(StringPredicates.endsWith("o")));
        Assert.assertEquals(Optional.of("nine"), map1.detectOptional(Predicates.equal("nine")));
        Assert.assertEquals(Optional.empty(), map1.detectOptional(Predicates.equal("ten")));
    }

    @Test
    public void detectWithOptional()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        Assert.assertTrue(Optional.of("one").equals(map1.detectWithOptional(StringPredicates2.endsWith(), "ne")) || Optional.of("nine").equals(map1.detectWithOptional(StringPredicates2.endsWith(), "ne")));
        Assert.assertEquals(Optional.of("zero"), map1.detectWithOptional(StringPredicates2.endsWith(), "o"));
        Assert.assertEquals(Optional.of("nine"), map1.detectWithOptional(Object::equals, "nine"));
        Assert.assertEquals(Optional.empty(), map1.detectWithOptional(Object::equals, "ten"));
    }

    @Test
    public void detectIfNone()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Function0<String> ifNone = () -> "ifNone";
        Assert.assertTrue("one".equals(map1.detectIfNone(StringPredicates.endsWith("ne"), ifNone))
            || "nine".equals(map1.detectIfNone(StringPredicates.endsWith("ne"), ifNone)));
        Assert.assertEquals("zero", map1.detectIfNone(StringPredicates.endsWith("o"), ifNone));
        Assert.assertEquals("nine", map1.detectIfNone(Predicates.equal("nine"), ifNone));
        Assert.assertEquals("ifNone", map1.detectIfNone(Predicates.equal("ten"), ifNone));
    }

    @Test
    public void detectWithIfNone()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Function0<String> ifNone = () -> "ifNone";
        Assert.assertTrue("one".equals(map1.detectWithIfNone(StringPredicates2.endsWith(), "ne", ifNone))
            || "nine".equals(map1.detectWithIfNone(StringPredicates2.endsWith(), "ne", ifNone)));
        Assert.assertEquals("zero", map1.detectWithIfNone(StringPredicates2.endsWith(), "o", ifNone));
        Assert.assertEquals("nine", map1.detectWithIfNone(Object::equals, "nine", ifNone));
        Assert.assertEquals("ifNone", map1.detectWithIfNone(Object::equals, "ten", ifNone));
    }

    @Test
    public void count()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Verify.assertCount(2, map1, StringPredicates.endsWith("ne"));
        Verify.assertCount(1, map1, StringPredicates.endsWith("o"));
        Verify.assertCount(1, map1, Predicates.equal("nine"));
        Verify.assertCount(0, map1, Predicates.equal("ten"));
    }

    @Test
    public void countWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(2, map1.countWith(StringPredicates2.endsWith(), "ne"));
        Assert.assertEquals(1, map1.countWith(StringPredicates2.endsWith(), "o"));
        Assert.assertEquals(1, map1.countWith(Object::equals, "nine"));
        Assert.assertNotEquals(1, map1.countWith(Object::equals, "ten"));
    }

    @Test
    public void anySatisfy()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        Verify.assertAnySatisfy(map1, StringPredicates.endsWith("ne"));
        Verify.assertAnySatisfy(map1, StringPredicates.endsWith("o"));
        Verify.assertAnySatisfy(map1, Predicates.equal("nine"));
        Assert.assertFalse(map1.anySatisfy(Predicates.equal("ten")));
    }

    @Test
    public void anySatisfyWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        Assert.assertTrue(map1.anySatisfyWith(StringPredicates2.endsWith(), "ne"));
        Assert.assertTrue(map1.anySatisfyWith(StringPredicates2.endsWith(), "o"));
        Assert.assertTrue(map1.anySatisfyWith(Object::equals, "nine"));
        Assert.assertFalse(map1.anySatisfyWith(Object::equals, "ten"));
    }

    @Test
    public void allSatisfy()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertTrue(map1.allSatisfy(StringPredicates.contains("e")));
        Assert.assertFalse(map1.allSatisfy(StringPredicates.endsWith("o")));
        Assert.assertFalse(map1.allSatisfy(StringPredicates.contains("o")));
        Assert.assertFalse(map1.allSatisfy(Predicates.equal("nine")));
        Assert.assertFalse(map1.allSatisfy(Predicates.equal("ten")));
    }

    @Test
    public void allSatisfyWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertTrue(map1.allSatisfyWith(StringPredicates2.contains(), "e"));
        Assert.assertFalse(map1.allSatisfyWith(StringPredicates2.endsWith(), "o"));
        Assert.assertFalse(map1.allSatisfyWith(StringPredicates2.contains(), "o"));
        Assert.assertFalse(map1.allSatisfyWith(Object::equals, "nine"));
        Assert.assertFalse(map1.allSatisfyWith(Object::equals, "ten"));
    }

    @Test
    public void noneSatisfy()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertTrue(map1.noneSatisfy(StringPredicates.notContains("e")));
        Assert.assertFalse(map1.noneSatisfy(StringPredicates.endsWith("o")));
        Assert.assertFalse(map1.noneSatisfy(StringPredicates.startsWith("o")));
        Assert.assertFalse(map1.noneSatisfy(StringPredicates.contains("o")));
        Assert.assertFalse(map1.noneSatisfy(Predicates.equal("nine")));
        Assert.assertTrue(map1.noneSatisfy(Predicates.equal("ten")));
    }

    @Test
    public void noneSatisfyWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertTrue(map1.noneSatisfyWith(StringPredicates2.notContains(), "e"));
        Assert.assertFalse(map1.noneSatisfyWith(StringPredicates2.endsWith(), "o"));
        Assert.assertFalse(map1.noneSatisfyWith(StringPredicates2.startsWith(), "o"));
        Assert.assertFalse(map1.noneSatisfyWith(StringPredicates2.contains(), "o"));
        Assert.assertFalse(map1.noneSatisfyWith(Object::equals, "nine"));
        Assert.assertTrue(map1.noneSatisfyWith(Object::equals, "ten"));
    }

    @Test
    public void injectInto()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "five", (char) 9, "nine");

        Function2<String, String, String> concat = (String argument1, String argument2) -> argument1 + '-' + argument2;

        Assert.assertTrue("Start-zero-nine".equals(map1.injectInto("Start", concat))
                || "Start-nine-zero".equals(map1.injectInto("Start", concat)));
        Assert.assertTrue("Start-one-nine".equals(map2.injectInto("Start", concat))
                || "Start-nine-one".equals(map2.injectInto("Start", concat)));
        Assert.assertTrue("Start-five-nine".equals(map3.injectInto("Start", concat))
                || "Start-nine-five".equals(map3.injectInto("Start", concat)));
    }

    @Test
    public void intInjectInto()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "a", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "abc", (char) 9, "abcd");

        IntObjectToIntFunction<String> function = (int intParameter, String objectParameter) -> intParameter + objectParameter.length();
        Assert.assertEquals(6, map1.injectInto(1, function));
        Assert.assertEquals(7, map2.injectInto(1, function));
        Assert.assertEquals(8, map3.injectInto(1, function));
    }

    @Test
    public void longInjectInto()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "a", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "abc", (char) 9, "abcd");

        LongObjectToLongFunction<String> function = (long longParameter, String objectParameter) -> longParameter + objectParameter.length();
        Assert.assertEquals(6L, map1.injectInto(1L, function));
        Assert.assertEquals(7L, map2.injectInto(1L, function));
        Assert.assertEquals(8L, map3.injectInto(1L, function));
    }

    @Test
    public void floatInjectInto()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "a", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "abc", (char) 9, "abcd");

        FloatObjectToFloatFunction<String> function = (float floatParameter, String objectParameter) -> floatParameter + objectParameter.length();
        Assert.assertEquals(6.0f, map1.injectInto(1.0f, function), 0.0);
        Assert.assertEquals(7.0f, map2.injectInto(1.0f, function), 0.0);
        Assert.assertEquals(8.0f, map3.injectInto(1.0f, function), 0.0);
    }

    @Test
    public void doubleInjectInto()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "a", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "abc", (char) 9, "abcd");

        DoubleObjectToDoubleFunction<String> function = (double doubleParameter, String objectParameter) -> doubleParameter + objectParameter.length();
        Assert.assertEquals(6.0, map1.injectInto(1.0, function), 0.0);
        Assert.assertEquals(7.0, map2.injectInto(1.0, function), 0.0);
        Assert.assertEquals(8.0, map3.injectInto(1.0, function), 0.0);
    }

    @Test
    public void toList()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "five", (char) 9, "nine");

        Assert.assertTrue(map1.toList().toString(), FastList.newListWith("zero", "nine").equals(map1.toList())
                || FastList.newListWith("nine", "zero").equals(map1.toList()));
        Assert.assertTrue(map2.toList().toString(), FastList.newListWith("one", "nine").equals(map2.toList())
                || FastList.newListWith("nine", "one").equals(map2.toList()));
        Assert.assertTrue(map3.toList().toString(), FastList.newListWith("five", "nine").equals(map3.toList())
                || FastList.newListWith("nine", "five").equals(map3.toList()));
    }

    @Test
    public void toSortedList()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "five", (char) 9, "nine");

        Assert.assertEquals(map1.toSortedList().toString(),
                FastList.newListWith("nine", "zero"), map1.toSortedList());
        Assert.assertEquals(map2.toSortedList().toString(),
                FastList.newListWith("nine", "one"), map2.toSortedList());
        Assert.assertEquals(map3.toSortedList().toString(), FastList.newListWith("five", "nine"), map3.toSortedList());

        Comparator<String> comparator = (String o1, String o2) -> o1.substring(1).compareTo(o2.substring(1));
        Assert.assertEquals(map1.toSortedList(comparator).toString(),
                FastList.newListWith("zero", "nine"), map1.toSortedList(comparator));
        Assert.assertEquals(map2.toSortedList(comparator).toString(),
                FastList.newListWith("nine", "one"), map2.toSortedList(comparator));
        Assert.assertEquals(map3.toSortedList(comparator).toString(), FastList.newListWith("nine", "five"), map3.toSortedList(comparator));

        Function<String, String> substring = (String object) -> object.substring(1);
        Assert.assertEquals(map1.toSortedListBy(substring).toString(),
                FastList.newListWith("zero", "nine"), map1.toSortedListBy(substring));
        Assert.assertEquals(map2.toSortedListBy(substring).toString(),
                FastList.newListWith("nine", "one"), map2.toSortedListBy(substring));
        Assert.assertEquals(map3.toSortedListBy(substring).toString(), FastList.newListWith("nine", "five"), map3.toSortedListBy(substring));
    }

    @Test
    public void toSet()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 5, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 5, "one", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "five", (char) 6, "five", (char) 9, "nine");

        Assert.assertEquals(map1.toSet().toString(), UnifiedSet.newSetWith("zero", "nine"), map1.toSet());
        Assert.assertEquals(map2.toSet().toString(), UnifiedSet.newSetWith("one", "nine"), map2.toSet());
        Assert.assertEquals(map3.toSet().toString(), UnifiedSet.newSetWith("five", "nine"), map3.toSet());
    }

    @Test
    public void toSortedSet()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 5, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 5, "one", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "five", (char) 6, "five", (char) 9, "nine");

        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "zero"), map1.toSortedSet());
        Assert.assertEquals(map2.toSortedSet().toString(),
                TreeSortedSet.newSetWith("nine", "one"), map2.toSortedSet());
        Assert.assertEquals(TreeSortedSet.newSetWith("five", "nine"), map3.toSortedSet());

        Comparator<String> comparator = (String o1, String o2) -> o1.substring(1).compareTo(o2.substring(1));
        Assert.assertEquals(TreeSortedSet.newSetWith("zero", "nine"), map1.toSortedSet(comparator));
        Assert.assertEquals(map2.toSortedSet(comparator).toString(),
                TreeSortedSet.newSetWith("nine", "one"), map2.toSortedSet(comparator));
        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "five"), map3.toSortedSet(comparator));

        Function<String, String> substring = (String object) -> object.substring(1);
        Assert.assertEquals(TreeSortedSet.newSetWith("zero", "nine"), map1.toSortedSetBy(substring));
        Assert.assertEquals(TreeSortedSet.newSetWith("nine", "one"), map2.toSortedSetBy(substring));
        Assert.assertEquals(map3.toSortedSetBy(substring).toString(), TreeSortedSet.newSetWith("nine", "five"), map3.toSortedSetBy(substring));
    }

    @Test
    public void toBag()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 5, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 5, "one", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "five", (char) 6, "five", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("zero", "zero", "nine"), map1.toBag());
        Assert.assertEquals(HashBag.newBagWith("one", "one", "nine"), map2.toBag());
        Assert.assertEquals(HashBag.newBagWith("five", "five", "nine"), map3.toBag());
    }

    @Test
    public void toMap()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "a", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "abc", (char) 9, "abcd");

        Function<String, Integer> keyFunction = StringFunctions.length();
        Function<String, String> valueFunction = Functions.getPassThru();
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, "a", 4, "abcd"), map1.toMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(2, "ab", 4, "abcd"), map2.toMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(3, "abc", 4, "abcd"), map3.toMap(keyFunction, valueFunction));
    }

    @Test
    public void toSortedMap()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "z", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "zyx", (char) 9, "abcd");

        Function<String, Integer> keyFunction = StringFunctions.length();
        Function<String, String> valueFunction = Functions.getPassThru();
        Assert.assertEquals(UnifiedMap.newWithKeysValues(4, "abcd", 1, "z"), map1.toSortedMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(2, "ab", 4, "abcd"), map2.toSortedMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(4, "abcd", 3, "zyx"), map3.toSortedMap(keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(4, "abcd", 3, "zyx"), map3.toSortedMap(Comparators.naturalOrder(), keyFunction, valueFunction));
        Assert.assertEquals(UnifiedMap.newWithKeysValues(4, "abcd", 3, "zyx"), map3.toSortedMapBy(Functions.getPassThru(), keyFunction, valueFunction));
    }

    @Test
    public void toArray()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "z", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "zyx", (char) 9, "abcd");

        Assert.assertTrue(map1.asLazy().toString(), Arrays.equals(new String[]{"abcd", "z"}, map1.toArray())
                || Arrays.equals(new String[]{"z", "abcd"}, map1.toArray()));
        Assert.assertTrue(map2.asLazy().toString(), Arrays.equals(new String[]{"abcd", "ab"}, map2.toArray())
                || Arrays.equals(new String[]{"ab", "abcd"}, map2.toArray()));
        Assert.assertTrue(map3.asLazy().toString(), Arrays.equals(new String[]{"abcd", "zyx"}, map3.toArray())
                || Arrays.equals(new String[]{"zyx", "abcd"}, map3.toArray()));

        Assert.assertTrue(map1.asLazy().toString(), Arrays.equals(new String[]{"abcd", "z"}, map1.toArray(new String[2]))
                || Arrays.equals(new String[]{"z", "abcd"}, map1.toArray()));
        Assert.assertTrue(map2.asLazy().toString(), Arrays.equals(new String[]{"abcd", "ab"}, map2.toArray(new String[4]))
                || Arrays.equals(new String[]{"ab", "abcd"}, map2.toArray()));
        Assert.assertTrue(map3.asLazy().toString(), Arrays.equals(new String[]{"abcd", "zyx"}, map3.toArray(new String[2]))
                || Arrays.equals(new String[]{"zyx", "abcd"}, map3.toArray()));
    }

    @Test
    public void min()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "z", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "zyx", (char) 9, "abcd");

        Assert.assertEquals("abcd", map1.min());
        Assert.assertEquals("ab", map2.min());
        Assert.assertEquals("abcd", map3.min());
        Assert.assertEquals("abcd", map3.min(Comparators.naturalOrder()));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_empty()
    {
        CharObjectHashMap.newMap().min();
    }

    @Test
    public void maxBy()
    {
        CharObjectMap<Class<?>> map1 = this.newWithKeysValues((char) 0, CharObjectHashMapTest.class, (char) 9, CharObjectHashMap.class);
        CharObjectMap<Class<?>> map2 = this.newWithKeysValues((char) 1, CharObjectHashMapTest.class, (char) 9, CharObjectHashMap.class);
        CharObjectMap<Class<?>> map3 = this.newWithKeysValues((char) 5, CharObjectHashMap.class, (char) 9, CharObjectHashMapTest.class);

        Function<Class<?>, Integer> classNameLength = (Class<?> aClass) -> aClass.getName().length();
        Assert.assertEquals(CharObjectHashMapTest.class, map1.maxBy(classNameLength));
        Assert.assertEquals(CharObjectHashMapTest.class, map2.maxBy(classNameLength));
        Assert.assertEquals(CharObjectHashMapTest.class, map3.maxBy(classNameLength));

        Verify.assertThrows(NoSuchElementException.class, () -> CharObjectHashMap.<Class<?>>newMap().maxBy(classNameLength));
    }

    @Test
    public void max()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "z", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "zyx", (char) 9, "abcd");

        Assert.assertEquals("z", map1.max());
        Assert.assertEquals("abcd", map2.max());
        Assert.assertEquals("zyx", map3.max());
        Assert.assertEquals("zyx", map3.max(Comparators.naturalOrder()));
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_empty()
    {
        CharObjectHashMap.newMap().max();
    }

    @Test
    public void minBy()
    {
        CharObjectMap<Class<?>> map1 = this.newWithKeysValues((char) 0, CharObjectHashMapTest.class, (char) 9, CharObjectHashMap.class);
        CharObjectMap<Class<?>> map2 = this.newWithKeysValues((char) 1, CharObjectHashMapTest.class, (char) 9, CharObjectHashMap.class);
        CharObjectMap<Class<?>> map3 = this.newWithKeysValues((char) 5, CharObjectHashMap.class, (char) 9, CharObjectHashMapTest.class);

        Function<Class<?>, Integer> classNameLength = (Class<?> object) -> object.getName().length();
        Assert.assertEquals(CharObjectHashMap.class, map1.minBy(classNameLength));
        Assert.assertEquals(CharObjectHashMap.class, map2.minBy(classNameLength));
        Assert.assertEquals(CharObjectHashMap.class, map3.minBy(classNameLength));

        Verify.assertThrows(NoSuchElementException.class, () -> CharObjectHashMap.<Class<?>>newMap().minBy(classNameLength));
    }

    @Test
    public void sumOfInt()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "z", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "zyx", (char) 9, "abcd");

        IntFunction<String> function = StringFunctions.length();
        Assert.assertEquals(5L, map1.sumOfInt(function));
        Assert.assertEquals(6L, map2.sumOfInt(function));
        Assert.assertEquals(7L, map3.sumOfInt(function));
    }

    @Test
    public void sumOfLong()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "z", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "zyx", (char) 9, "abcd");

        LongFunction<String> function = String::length;
        Assert.assertEquals(5L, map1.sumOfLong(function));
        Assert.assertEquals(6L, map2.sumOfLong(function));
        Assert.assertEquals(7L, map3.sumOfLong(function));
    }

    @Test
    public void sumOfDouble()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "z", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "zyx", (char) 9, "abcd");

        DoubleFunction<String> function = String::length;
        Assert.assertEquals(5.0, map1.sumOfDouble(function), 0.0);
        Assert.assertEquals(6.0, map2.sumOfDouble(function), 0.0);
        Assert.assertEquals(7.0, map3.sumOfDouble(function), 0.0);
    }

    @Test
    public void sumOfFloat()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "z", (char) 9, "abcd");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "ab", (char) 9, "abcd");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 5, "zyx", (char) 9, "abcd");

        FloatFunction<String> function = String::length;
        Assert.assertEquals(5.0, map1.sumOfFloat(function), 0.0);
        Assert.assertEquals(6.0, map2.sumOfFloat(function), 0.0);
        Assert.assertEquals(7.0, map3.sumOfFloat(function), 0.0);
    }

    @Test
    public void sumByInt()
    {
        RichIterable<String> values = this.newWithKeysValues((char) 1, "1", (char) 2, "2", (char) 3, "3");
        ObjectLongMap<Integer> result = values.sumByInt(s -> Integer.parseInt(s) % 2, Integer::parseInt);
        Assert.assertEquals(4, result.get(1));
        Assert.assertEquals(2, result.get(0));
    }

    @Test
    public void sumByFloat()
    {
        RichIterable<String> values = this.newWithKeysValues((char) 1, "1", (char) 2, "2", (char) 3, "3");
        ObjectDoubleMap<Integer> result = values.sumByFloat(s -> Integer.parseInt(s) % 2, Float::parseFloat);
        Assert.assertEquals(4.0f, result.get(1), 0.0);
        Assert.assertEquals(2.0f, result.get(0), 0.0);
    }

    @Test
    public void sumByLong()
    {
        RichIterable<String> values = this.newWithKeysValues((char) 1, "1", (char) 2, "2", (char) 3, "3");
        ObjectLongMap<Integer> result = values.sumByLong(s -> Integer.parseInt(s) % 2, Long::parseLong);
        Assert.assertEquals(4, result.get(1));
        Assert.assertEquals(2, result.get(0));
    }

    @Test
    public void sumByDouble()
    {
        RichIterable<String> values = this.newWithKeysValues((char) 1, "1", (char) 2, "2", (char) 3, "3");
        ObjectDoubleMap<Integer> result = values.sumByDouble(s -> Integer.parseInt(s) % 2, Double::parseDouble);
        Assert.assertEquals(4.0d, result.get(1), 0.0);
        Assert.assertEquals(2.0d, result.get(0), 0.0);
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(CharArrayList.newListWith(), this.getEmptyMap().keysView().toList());
        Assert.assertEquals(CharArrayList.newListWith((char) 1), this.newWithKeysValues((char) 1, "one").keysView().toList());
    }

    @Test
    public void reject()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 0, "zero", (char) 9, "nine");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 1, "one", (char) 9, "nine");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 5, "five", (char) 9, "nine");

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 9, "nine"),
            map1.reject((char value, String object) -> (value % 2) == 0));

        CharObjectPredicate<String> keyLessThanSeven = (char value, String object) -> value > 7;

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 1, "one"), map1.reject(keyLessThanSeven));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 0, "zero"), map2.reject(keyLessThanSeven));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), map3.reject(keyLessThanSeven));
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 5, "five"), map4.reject(keyLessThanSeven));

        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 9, "nine"),
            map1.reject((char value, String object) -> !object.endsWith("ne")));

        RichIterable<String> actual1 = map1.reject(StringPredicates.endsWith("ne").not());
        Assert.assertTrue(HashBag.newBagWith("one", "nine").equals(actual1));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.reject(Predicates.equal("nine").not()));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.reject(StringPredicates.endsWith("o").not()));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.reject(Predicates.equal("nine").not(), HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.reject(StringPredicates.endsWith("ne").not(), HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.reject(StringPredicates.endsWith("o").not(), HashBag.<String>newBag()));
    }

    @Test
    public void rejectWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.rejectWith(StringPredicates2.notEndsWith(), "ne"));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.rejectWith(Predicates2.notEqual(), "nine"));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.rejectWith(StringPredicates2.notEndsWith(), "o"));
    }

    @Test
    public void rejectWith_withTarget()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Assert.assertEquals(HashBag.newBagWith("one", "nine"), map1.rejectWith(StringPredicates2.notEndsWith(), "ne", HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("nine"), map1.rejectWith(Predicates2.notEqual(), "nine", HashBag.<String>newBag()));
        Assert.assertEquals(HashBag.newBagWith("zero"), map1.rejectWith(StringPredicates2.notEndsWith(), "o", HashBag.<String>newBag()));
    }

    @Test
    public void partition()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Predicate<String> endsWithNe = StringPredicates.endsWith("ne");
        PartitionIterable<String> partition = map1.partition(endsWithNe);
        Assert.assertTrue(HashBag.newBagWith("one", "nine").equals(partition.getSelected()));
        Assert.assertEquals(HashBag.newBagWith("zero"), partition.getRejected());
    }

    @Test
    public void partitionWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 9, "nine");

        Predicate2<String, String> endsWith = StringPredicates2.endsWith();
        PartitionIterable<String> partition = map1.partitionWith(endsWith, "ne");
        Assert.assertTrue(HashBag.newBagWith("one", "nine").equals(partition.getSelected()));
        Assert.assertEquals(HashBag.newBagWith("zero"), partition.getRejected());
    }

    @Test
    public void get()
    {
        Assert.assertEquals("zero", this.classUnderTest().get((char) 0));
        Assert.assertEquals("thirtyOne", this.classUnderTest().get((char) 31));
        Assert.assertEquals("thirtyTwo", this.classUnderTest().get((char) 32));

        Assert.assertNull(this.classUnderTest().get((char) 1));
        Assert.assertNull(this.classUnderTest().get((char) 33));

        CharObjectMap<Object> emptyMap = this.getEmptyMap();
        Assert.assertNull(emptyMap.get((char) 0));
        Assert.assertNull(emptyMap.get((char) 1));
        Assert.assertNull(emptyMap.get((char) 33));
    }

    @Test
    public void getIfAbsent()
    {
        Function0<String> ifAbsent = () -> "ifAbsent";

        Assert.assertEquals("zero", this.classUnderTest().getIfAbsent((char) 0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.classUnderTest().getIfAbsent((char) 31, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.classUnderTest().getIfAbsent((char) 32, ifAbsent));

        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.classUnderTest().getIfAbsent((char) 33, ifAbsent));

        CharObjectMap<Object> emptyMap = this.getEmptyMap();
        Assert.assertEquals("ifAbsent", emptyMap.getIfAbsent((char) 0, ifAbsent));
        Assert.assertEquals("ifAbsent", emptyMap.getIfAbsent((char) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", emptyMap.getIfAbsent((char) 33, ifAbsent));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.classUnderTest().containsKey((char) 0));
        Assert.assertTrue(this.classUnderTest().containsKey((char) 31));
        Assert.assertTrue(this.classUnderTest().containsKey((char) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 35));
    }

    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.classUnderTest().containsValue(null));
        Assert.assertTrue(this.classUnderTest().containsValue("zero"));
        Assert.assertTrue(this.classUnderTest().containsValue("thirtyOne"));
        Assert.assertTrue(this.classUnderTest().containsValue("thirtyTwo"));
    }

    @Test
    public void forEachValue()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");
        String[] concat = {"", "", "", ""};

        map1.forEachValue((String each) -> concat[0] += each);
        map2.forEachValue((String each) -> concat[1] += each);
        map3.forEachValue((String each) -> concat[2] += each);
        map4.forEachValue((String each) -> concat[3] += each);

        Assert.assertTrue(concat[0], "onefive".equals(concat[0]) || "fiveone".equals(concat[0]));
        Assert.assertTrue(concat[1], "onezero".equals(concat[1]) || "zeroone".equals(concat[1]));
        Assert.assertTrue(concat[2], "twofive".equals(concat[2]) || "fivetwo".equals(concat[2]));
        Assert.assertTrue(concat[3], "zerofive".equals(concat[3]) || "fivezero".equals(concat[3]));
    }

    @Test
    public void forEachKey()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");
        long[] sum = new long[4];

        map1.forEachKey((char each) -> sum[0] += each);
        map2.forEachKey((char each) -> sum[1] += each);
        map3.forEachKey((char each) -> sum[2] += each);
        map4.forEachKey((char each) -> sum[3] += each);

        Assert.assertEquals(6L, sum[0]);
        Assert.assertEquals(1L, sum[1]);
        Assert.assertEquals(7L, sum[2]);
        Assert.assertEquals(5L, sum[3]);
    }

    @Test
    public void forEachKeyValue()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");
        String[] concat = {"", "", "", ""};

        map1.forEachKeyValue((char each, String parameter) ->
        {
            concat[0] += each;
            concat[0] += parameter;
        });
        map2.forEachKeyValue((char each, String parameter) ->
        {
            concat[1] += each;
            concat[1] += parameter;
        });
        map3.forEachKeyValue((char each, String parameter) ->
        {
            concat[2] += each;
            concat[2] += parameter;
        });
        map4.forEachKeyValue((char each, String parameter) ->
        {
            concat[3] += each;
            concat[3] += parameter;
        });

        Assert.assertTrue(concat[0], "\u0001one\u0005five".equals(concat[0]) || "\u0005five\u0001one".equals(concat[0]));
        Assert.assertTrue(concat[1], "\u0001one\u0000zero".equals(concat[1]) || "\u0000zero\u0001one".equals(concat[1]));
        Assert.assertTrue(concat[2], "\u0002two\u0005five".equals(concat[2]) || "\u0005five\u0002two".equals(concat[2]));
        Assert.assertTrue(concat[3], "\u0000zero\u0005five".equals(concat[3]) || "\u0005five\u0000zero".equals(concat[3]));
    }

    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 1, "one", (char) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, "zero", (char) 5, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, "one", (char) 0, "zero", (char) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, "six", (char) 5, "five").size());
    }

    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.classUnderTest().isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 1, "one").isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 0, "zero").isEmpty());
        Assert.assertFalse(this.newWithKeysValues((char) 50, "fifty").isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.classUnderTest().notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 1, "one").notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 0, "zero").notEmpty());
        Assert.assertTrue(this.newWithKeysValues((char) 50, "fifty").notEmpty());
    }

    @Test
    public void getFirst()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");

        Assert.assertTrue(map1.getFirst(), "one".equals(map1.getFirst()) || "five".equals(map1.getFirst()));
        Assert.assertTrue(map2.getFirst(), "one".equals(map2.getFirst()) || "zero".equals(map2.getFirst()));
        Assert.assertTrue(map3.getFirst(), "two".equals(map3.getFirst()) || "five".equals(map3.getFirst()));
        Assert.assertTrue(map4.getFirst(), "zero".equals(map4.getFirst()) || "five".equals(map4.getFirst()));
        Assert.assertNull(CharObjectHashMap.newMap().getFirst());
    }

    @Test
    public void getLast()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");

        Assert.assertTrue(map1.getLast(), "one".equals(map1.getLast()) || "five".equals(map1.getLast()));
        Assert.assertTrue(map2.getLast(), "one".equals(map2.getLast()) || "zero".equals(map2.getLast()));
        Assert.assertTrue(map3.getLast(), "two".equals(map3.getLast()) || "five".equals(map3.getLast()));
        Assert.assertTrue(map4.getLast(), "zero".equals(map4.getLast()) || "five".equals(map4.getLast()));
        Assert.assertEquals("zero", this.newWithKeysValues((char) 0, "zero").getLast());
        Assert.assertNull(CharObjectHashMap.newMap().getLast());
    }

    @Test
    public void getOnly()
    {
        Assert.assertEquals("zero", this.newWithKeysValues((char) 0, "zero").getOnly());
        Assert.assertEquals("one", this.newWithKeysValues((char) 1, "one").getOnly());
        Assert.assertEquals("two", this.newWithKeysValues((char) 2, "two").getOnly());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_empty_throws()
    {
        this.getEmptyMap().getOnly();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_not_only_one_throws()
    {
        this.newWithKeysValues((char) 1, "one", (char) 5, "five").getOnly();
    }

    @Test
    public void contains()
    {
        Assert.assertFalse(this.classUnderTest().contains(null));
        Assert.assertTrue(this.classUnderTest().contains("zero"));
        Assert.assertTrue(this.classUnderTest().contains("thirtyOne"));
        Assert.assertTrue(this.classUnderTest().contains("thirtyTwo"));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertTrue(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAllIterable(FastList.newListWith("two", "one", "nine")));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne")));
        Assert.assertTrue(this.classUnderTest().containsAll(FastList.newListWith("zero", "thirtyOne", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("zero", "one", "thirtyTwo")));
        Assert.assertFalse(this.classUnderTest().containsAll(FastList.newListWith("two", "one", "nine")));
    }

    @Test
    public void containsAllArguments()
    {
        Assert.assertTrue(this.classUnderTest().containsAllArguments("zero", "thirtyOne"));
        Assert.assertTrue(this.classUnderTest().containsAllArguments("zero", "thirtyOne", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("zero", "one", "thirtyTwo"));
        Assert.assertFalse(this.classUnderTest().containsAllArguments("two", "one", "nine"));
    }

    @Test
    public void testEquals()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 32, "thirtyTwo");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 32, "thirtyTwo", (char) 0, "zero", (char) 1, "one");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 0, "zero", (char) 1, "two", (char) 32, "thirtyTwo");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "one", (char) 1, "one", (char) 32, "thirtyTwo");
        CharObjectMap<String> map5 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 32, "thirtyThree");
        CharObjectMap<String> map6 = this.newWithKeysValues((char) 1, "one", (char) 32, "thirtyTwo");
        CharObjectMap<String> map7 = this.newWithKeysValues((char) 0, "zero", (char) 32, "thirtyTwo");
        CharObjectMap<String> map8 = this.newWithKeysValues((char) 50, "zero", (char) 60, "one", (char) 70, "thirtyThree");
        CharObjectMap<String> map9 = this.newWithKeysValues((char) 50, "zero", (char) 60, "one");
        CharObjectMap<String> map10 = this.newWithKeysValues((char) 50, "zero");

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map7);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(map10);
        Verify.assertPostSerializedEqualsAndHashCode(CharObjectHashMap.newMap());
        Verify.assertEqualsAndHashCode(map1, map2);
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map1, map6);
        Assert.assertNotEquals(map1, map7);
        Assert.assertNotEquals(map8, map5);
        Assert.assertNotEquals(map9, map8);
        Assert.assertNotEquals(this.newWithKeysValues((char) 0, null), this.newWithKeysValues((char) 6, ""));
        Assert.assertNotEquals(this.newWithKeysValues((char) 5, null), this.newWithKeysValues((char) 6, ""));

        Assert.assertEquals(map1, CharObjectMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, CharObjectMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 32, "thirtyTwo").hashCode(), this.newWithKeysValues((char) 32, "thirtyTwo", (char) 0, "zero", (char) 1, "one").hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 0, null, (char) 1, null).hashCode(), this.newWithKeysValues((char) 0, null, (char) 1, null).hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 50, "zero", (char) 60, "one", (char) 70, "thirtyThree").hashCode(), this.newWithKeysValues((char) 50, "zero", (char) 60, "one", (char) 70, "thirtyThree").hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues((char) 50, null, (char) 60, null).hashCode(), this.newWithKeysValues((char) 50, null, (char) 60, null).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{\u0000=zero}", this.newWithKeysValues((char) 0, "zero").toString());
        Assert.assertEquals("{\u0001=one}", this.newWithKeysValues((char) 1, "one").toString());
        Assert.assertEquals("{\u0005=five}", this.newWithKeysValues((char) 5, "five").toString());

        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        Assert.assertTrue(
                map1.toString(),
                "{\u0000=zero, \u0001=one}".equals(map1.toString())
                        || "{\u0001=one, \u0000=zero}".equals(map1.toString()));

        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 32, "thirtyTwo");
        Assert.assertTrue(
                map2.toString(),
                "{\u0001=one, \u0020=thirtyTwo}".equals(map2.toString())
                        || "{\u0020=thirtyTwo, \u0001=one}".equals(map2.toString()));

        CharObjectMap<String> map3 = this.newWithKeysValues((char) 0, "zero", (char) 32, "thirtyTwo");
        Assert.assertTrue(
                map3.toString(),
                "{\u0000=zero, \u0020=thirtyTwo}".equals(map3.toString())
                        || "{\u0020=thirtyTwo, \u0000=zero}".equals(map3.toString()));

        CharObjectMap<String> map4 = this.newWithKeysValues((char) 32, "thirtyTwo", (char) 33, "thirtyThree");
        Assert.assertTrue(
                map4.toString(),
                "{\u0020=thirtyTwo, \u0021=thirtyThree}".equals(map4.toString())
                        || "{\u0021=thirtyThree, \u0020=thirtyTwo}".equals(map4.toString()));
    }

    @Test
    public void zip()
    {
        RichIterable<Pair<String, Integer>> zip1 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five")
                .zip(FastList.newListWith(0, 5, 6));
        RichIterable<Pair<String, Integer>> zip2 = this.newWithKeysValues((char) 1, "one", (char) 5, "five")
                .zip(FastList.newListWith(1));
        RichIterable<Pair<String, Integer>> zip3 = this.newWithKeysValues((char) 1, "one", (char) 5, "five")
                .zip(FastList.newListWith(1), FastList.<Pair<String, Integer>>newList());
        Assert.assertTrue(HashBag.newBagWith(Tuples.pair("zero", 0), Tuples.pair("five", 5)).equals(zip1)
                || HashBag.newBagWith(Tuples.pair("five", 0), Tuples.pair("zero", 5)).equals(zip1));
        Assert.assertTrue(HashBag.newBagWith(Tuples.pair("one", 1)).equals(zip2)
                || HashBag.newBagWith(Tuples.pair("five", 1)).equals(zip2));
        Assert.assertTrue(FastList.newListWith(Tuples.pair("one", 1)).equals(zip3)
                || FastList.newListWith(Tuples.pair("five", 1)).equals(zip3));
    }

    @Test
    public void zipWithIndex()
    {
        RichIterable<Pair<String, Integer>> zip1 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five")
                .zipWithIndex();
        RichIterable<Pair<String, Integer>> zip2 = this.newWithKeysValues((char) 1, "one", (char) 5, "five")
                .zipWithIndex();
        RichIterable<Pair<String, Integer>> zip3 = this.newWithKeysValues((char) 1, "one", (char) 5, "five")
                .zipWithIndex(FastList.<Pair<String, Integer>>newList());
        Assert.assertTrue(UnifiedSet.newSetWith(Tuples.pair("zero", 0), Tuples.pair("five", 1)).equals(zip1)
                || UnifiedSet.newSetWith(Tuples.pair("five", 0), Tuples.pair("zero", 1)).equals(zip1));
        Assert.assertTrue(UnifiedSet.newSetWith(Tuples.pair("one", 0), Tuples.pair("five", 1)).equals(zip2)
                || UnifiedSet.newSetWith(Tuples.pair("five", 0), Tuples.pair("one", 1)).equals(zip2));
        Assert.assertTrue(FastList.newListWith(Tuples.pair("one", 0), Tuples.pair("five", 1)).equals(zip3)
                || FastList.newListWith(Tuples.pair("five", 0), Tuples.pair("one", 1)).equals(zip3));
    }

    @Test
    public void chunk()
    {
        RichIterable<RichIterable<String>> chunk1 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five")
                .chunk(1);
        RichIterable<RichIterable<String>> chunk2 = this.newWithKeysValues((char) 1, "one", (char) 5, "five")
                .chunk(1);
        Assert.assertTrue(FastList.newListWith(FastList.newListWith("zero"), FastList.newListWith("five")).equals(chunk1)
                || FastList.newListWith(FastList.newListWith("five"), FastList.newListWith("zero")).equals(chunk1));
        Assert.assertTrue(FastList.newListWith(FastList.newListWith("one"), FastList.newListWith("five")).equals(chunk2)
                || FastList.newListWith(FastList.newListWith("five"), FastList.newListWith("one")).equals(chunk2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_throws_negative_size()
    {
        this.newWithKeysValues((char) 0, "zero", (char) 5, "five")
                .chunk(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_throws_zero_size()
    {
        this.newWithKeysValues((char) 0, "zero", (char) 5, "five")
                .chunk(0);
    }

    @Test
    public void aggregateInPlaceBy()
    {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, Integer> sumAggregator = AtomicInteger::addAndGet;
        CharObjectMap<Integer> collection = this.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(1, aggregation.get("1").intValue());
        Assert.assertEquals(2, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Test
    public void aggregateBy()
    {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, Integer, Integer> sumAggregator = (Integer aggregate, Integer value) -> aggregate + value;
        CharObjectMap<Integer> collection = this.newWithKeysValues((char) 1, 1, (char) 2, 2, (char) 3, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(1, aggregation.get("1").intValue());
        Assert.assertEquals(2, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Test
    public void groupBy()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 2, "two", (char) 3, "three");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 4, "four");

        FastListMultimap<Character, String> expected1 = FastListMultimap.newMultimap(Tuples.pair('z', "zero"), Tuples.pair('o', "one"));
        FastListMultimap<Character, String> expected2 = FastListMultimap.newMultimap(Tuples.pair('t', "two"), Tuples.pair('t', "three"));
        FastListMultimap<Character, String> expected4 = FastListMultimap.newMultimap(Tuples.pair('f', "four"));

        Function<String, Character> firstChar = (String object) -> object.charAt(0);

        Multimap<Character, String> actual1 = map1.groupBy(firstChar);
        Multimap<Character, String> actual2 = map2.groupBy(firstChar);
        Multimap<Character, String> actual3 = map2.groupBy(firstChar, FastListMultimap.<Character, String>newMultimap());
        Multimap<Character, String> actual4 = map3.groupBy(firstChar);
        Multimap<Character, String> actual5 = map3.groupBy(firstChar, FastListMultimap.<Character, String>newMultimap());

        Verify.assertSize(expected1.size(), actual1);
        expected1.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual1.containsKeyAndValue(argument1, argument2)));

        Verify.assertSize(expected2.size(), actual2);
        expected2.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual2.containsKeyAndValue(argument1, argument2)));

        Verify.assertSize(expected2.size(), actual3);
        expected2.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual3.containsKeyAndValue(argument1, argument2)));

        Verify.assertSize(expected4.size(), actual4);
        expected4.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual4.containsKeyAndValue(argument1, argument2)));

        Verify.assertSize(expected4.size(), actual5);
        expected4.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual5.containsKeyAndValue(argument1, argument2)));
    }

    @Test
    public void groupByEach()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one");

        Function<String, UnifiedSet<Character>> toChars = (String object) ->
            {
                UnifiedSet<Character> list = UnifiedSet.newSet();
                char[] chars = object.toCharArray();
                for (char aChar : chars)
                {
                    list.add(aChar);
                }
                return list;
            };

        FastListMultimap<Character, String> expected = FastListMultimap.newMultimap(Tuples.pair('z', "zero"), Tuples.pair('e', "zero"), Tuples.pair('r', "zero"), Tuples.pair('o', "zero"), Tuples.pair('n', "nine"), Tuples.pair('i', "nine"), Tuples.pair('e', "nine"));
        FastListMultimap<Character, String> expected2 = FastListMultimap.newMultimap(Tuples.pair('o', "one"), Tuples.pair('n', "one"), Tuples.pair('e', "one"));

        Multimap<Character, String> actual = map1.groupByEach(toChars);
        Multimap<Character, String> actual1 = map1.groupByEach(toChars, FastListMultimap.<Character, String>newMultimap());
        Multimap<Character, String> actual2 = map2.groupByEach(toChars);
        Multimap<Character, String> actual3 = map2.groupByEach(toChars, FastListMultimap.<Character, String>newMultimap());

        expected.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual.containsKeyAndValue(argument1, argument2)));

        expected.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual1.containsKeyAndValue(argument1, argument2)));

        expected2.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual2.containsKeyAndValue(argument1, argument2)));

        expected2.forEachKeyValue((Character argument1, String argument2) -> Assert.assertTrue(actual3.containsKeyAndValue(argument1, argument2)));
    }

    @Test
    public void groupByUniqueKey()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one", (char) 2, "two");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 2, "two");

        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        Assert.assertEquals(UnifiedMap.newWithKeysValues('z', "zero", 'o', "one", 't', "two"), map1.groupByUniqueKey(firstChar));
        Assert.assertEquals(UnifiedMap.newWithKeysValues('t', "two"), map2.groupByUniqueKey(firstChar));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        Function<String, Character> firstChar = (String object) -> 'a';
        map1.groupByUniqueKey(firstChar);
    }

    @Test
    public void groupByUniqueKey_target()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 0, "zero");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        Assert.assertEquals(UnifiedMap.newWithKeysValues('z', "zero", 'o', "one", 't', "two"), map1.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('t', "two")));
        Assert.assertEquals(UnifiedMap.newWithKeysValues('z', "zero", 't', "two"), map2.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('t', "two")));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws_1()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        map1.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('z', "zero"));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws_2()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        map1.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('z', "zero"));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws_3()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 2, "two");
        Function<String, Character> firstChar = (String object) -> object.charAt(0);
        map1.groupByUniqueKey(firstChar, UnifiedMap.newWithKeysValues('t', "two"));
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("zero", this.newWithKeysValues((char) 0, "zero").makeString());
        Assert.assertEquals("one", this.newWithKeysValues((char) 1, "one").makeString());
        Assert.assertEquals("five", this.newWithKeysValues((char) 5, "five").makeString());

        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        Assert.assertTrue(
                map1.makeString(),
                "zero, one".equals(map1.makeString())
                        || "one, zero".equals(map1.makeString()));

        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 32, "thirtyTwo");
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[one/thirtyTwo]".equals(map2.makeString("[", "/", "]"))
                        || "[thirtyTwo/one]".equals(map2.makeString("[", "/", "]")));

        CharObjectMap<String> map3 = this.newWithKeysValues((char) 0, "zero", (char) 32, "thirtyTwo");
        Assert.assertTrue(
                map3.makeString("~"),
                "zero~thirtyTwo".equals(map3.makeString("~"))
                        || "thirtyTwo~zero".equals(map3.makeString("~")));

        CharObjectMap<String> map4 = this.newWithKeysValues((char) 32, "thirtyTwo", (char) 33, "thirtyThree");
        Assert.assertTrue(
                map4.makeString("[", ", ", "]"),
                "[thirtyTwo, thirtyThree]".equals(map4.makeString("[", ", ", "]"))
                        || "[thirtyThree, thirtyTwo]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString()
    {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());

        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues((char) 0, "zero").appendString(appendable0);
        Assert.assertEquals("zero", appendable0.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues((char) 1, "one").appendString(appendable1);
        Assert.assertEquals("one", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues((char) 5, "five").appendString(appendable2);
        Assert.assertEquals("five", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "zero, one".equals(appendable3.toString())
                        || "one, zero".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 32, "thirtyTwo");
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(
                appendable4.toString(),
                "[one/thirtyTwo]".equals(appendable4.toString())
                        || "[thirtyTwo/one]".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 1, "one", (char) 32, "thirtyTwo");
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(
                appendable5.toString(),
                "[one/thirtyTwo]".equals(appendable5.toString())
                        || "[thirtyTwo/one]".equals(appendable5.toString()));

        Appendable appendable6 = new StringBuilder();
        map3.appendString(appendable6, "/");
        Assert.assertTrue(
                appendable6.toString(),
                "one/thirtyTwo".equals(appendable6.toString())
                        || "thirtyTwo/one".equals(appendable6.toString()));
    }

    @Test
    public void tap()
    {
        StringBuilder[] concat = new StringBuilder[4];
        concat[0] = new StringBuilder();
        concat[1] = new StringBuilder();
        concat[2] = new StringBuilder();
        concat[3] = new StringBuilder();

        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");

        Assert.assertSame(map1, map1.tap(concat[0]::append));
        Assert.assertSame(map2, map2.tap(concat[1]::append));
        Assert.assertSame(map3, map3.tap(concat[2]::append));
        Assert.assertSame(map4, map4.tap(concat[3]::append));

        Assert.assertTrue(concat[0].toString(), "onefive".equals(concat[0].toString()) || "fiveone".equals(concat[0].toString()));
        Assert.assertTrue(concat[1].toString(), "onezero".equals(concat[1].toString()) || "zeroone".equals(concat[1].toString()));
        Assert.assertTrue(concat[2].toString(), "twofive".equals(concat[2].toString()) || "fivetwo".equals(concat[2].toString()));
        Assert.assertTrue(concat[3].toString(), "zerofive".equals(concat[3].toString()) || "fivezero".equals(concat[3].toString()));
    }

    @Test
    public void forEach()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");
        String[] concat = {"", "", "", ""};

        map1.forEach(Procedures.cast(each -> concat[0] += each));
        map2.forEach(Procedures.cast(each -> concat[1] += each));
        map3.forEach(Procedures.cast(each -> concat[2] += each));
        map4.forEach(Procedures.cast(each -> concat[3] += each));

        Assert.assertTrue(concat[0], "onefive".equals(concat[0]) || "fiveone".equals(concat[0]));
        Assert.assertTrue(concat[1], "onezero".equals(concat[1]) || "zeroone".equals(concat[1]));
        Assert.assertTrue(concat[2], "twofive".equals(concat[2]) || "fivetwo".equals(concat[2]));
        Assert.assertTrue(concat[3], "zerofive".equals(concat[3]) || "fivezero".equals(concat[3]));
    }

    @Test
    public void forEachWithIndex()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");
        String[] concat = {"", "", "", ""};

        map1.forEachWithIndex((String each, int parameter) ->
        {
            concat[0] += each;
            concat[0] += parameter;
        });
        map2.forEachWithIndex((String each, int parameter) ->
        {
            concat[1] += each;
            concat[1] += parameter;
        });
        map3.forEachWithIndex((String each, int parameter) ->
        {
            concat[2] += each;
            concat[2] += parameter;
        });
        map4.forEachWithIndex((String each, int parameter) ->
        {
            concat[3] += each;
            concat[3] += parameter;
        });

        Assert.assertTrue(concat[0], "one0five1".equals(concat[0]) || "five0one1".equals(concat[0]));
        Assert.assertTrue(concat[1], "one0zero1".equals(concat[1]) || "zero0one1".equals(concat[1]));
        Assert.assertTrue(concat[2], "two0five1".equals(concat[2]) || "five0two1".equals(concat[2]));
        Assert.assertTrue(concat[3], "zero0five1".equals(concat[3]) || "five0zero1".equals(concat[3]));
    }

    @Test
    public void forEachWith()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 1, "one", (char) 5, "five");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 0, "zero");
        CharObjectMap<String> map3 = this.newWithKeysValues((char) 2, "two", (char) 5, "five");
        CharObjectMap<String> map4 = this.newWithKeysValues((char) 0, "zero", (char) 5, "five");
        String[] concat = {"", "", "", ""};

        map1.forEachWith((String argument1, String argument2) ->
            {
                concat[0] += argument1;
                concat[0] += argument2;
            }, "-");
        map2.forEachWith((String argument1, String argument2) ->
            {
                concat[1] += argument1;
                concat[1] += argument2;
            }, "-");
        map3.forEachWith((String argument1, String argument2) ->
            {
                concat[2] += argument1;
                concat[2] += argument2;
            }, "-");
        map4.forEachWith((String argument1, String argument2) ->
            {
                concat[3] += argument1;
                concat[3] += argument2;
            }, "-");

        Assert.assertTrue(concat[0], "one-five-".equals(concat[0]) || "five-one-".equals(concat[0]));
        Assert.assertTrue(concat[1], "one-zero-".equals(concat[1]) || "zero-one-".equals(concat[1]));
        Assert.assertTrue(concat[2], "two-five-".equals(concat[2]) || "five-two-".equals(concat[2]));
        Assert.assertTrue(concat[3], "zero-five-".equals(concat[3]) || "five-zero-".equals(concat[3]));
    }

    @Test
    public void iterator()
    {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();

        Iterator<String> iterator = this.classUnderTest().iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableCharObjectMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void toSortedBag()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 5, "zero", (char) 9, "nine");
        CharObjectMap<String> map2 = this.newWithKeysValues((char) 1, "one", (char) 5, "one", (char) 9, "nine");

        Verify.assertSortedBagsEqual(TreeBag.newBagWith("zero", "zero", "nine"), map1.toSortedBag());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparator.reverseOrder(), "one", "one", "nine"), map2.toSortedBag(Comparator.<String>reverseOrder()));
    }

    @Test
    public void toSortedBagBy()
    {
        CharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 5, "zero", (char) 9, "nine");

        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.byFunction(String::valueOf), "zero", "zero", "nine"), map1.toSortedBagBy(String::valueOf));
    }

    @Test
    public void stream()
    {
        CharObjectMap<String> map = this.newWithKeysValues((char) 1, "1", (char) 2, "2", (char) 9, "9");
        Assert.assertEquals("129", CharAdapter.adapt(map.stream().reduce("", (r, s) -> r + s)).toSortedList().makeString(""));
        Assert.assertEquals(map.reduce((r, s) -> r + s), map.stream().reduce((r, s) -> r + s));
    }

    @Test
    public void parallelStream()
    {
        CharObjectMap<String> map = this.newWithKeysValues((char) 1, "1", (char) 2, "2", (char) 9, "9");
        Assert.assertEquals("129", CharAdapter.adapt(map.parallelStream().reduce("", (r, s) -> r + s)).toSortedList().makeString(""));
        Assert.assertEquals(map.reduce((r, s) -> r + s), map.stream().reduce((r, s) -> r + s));
    }
}
