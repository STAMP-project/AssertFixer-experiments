/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.primitive;

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.map.primitive.LongShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongShortMap;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.tuple.primitive.LongShortPair;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongShortHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractLongShortMapTestCase
{
    protected final LongShortMap map = this.classUnderTest();

    protected abstract LongShortMap classUnderTest();

    protected abstract LongShortMap newWithKeysValues(long key1, short value1);

    protected abstract LongShortMap newWithKeysValues(long key1, short value1, long key2, short value2);

    protected abstract LongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3);

    protected abstract LongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3, long key4, short value4);

    protected abstract LongShortMap getEmptyMap();

    @Test
    public void keySet()
    {
        Verify.assertEmpty(this.getEmptyMap().keySet());
        Assert.assertEquals(LongHashSet.newSetWith(0L), this.newWithKeysValues(0L, (short) 0).keySet());
        Assert.assertEquals(LongHashSet.newSetWith(0L, 31L, 32L),
                this.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32).keySet());
    }

    @Test
    public void values()
    {
        Verify.assertEmpty(this.getEmptyMap().values());

        LongShortMap map = this.newWithKeysValues(0L, (short) 0);
        Verify.assertSize(1, map.values());
        Assert.assertTrue(map.values().contains((short) 0));

        LongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32);
        Verify.assertSize(3, map1.values());
        Assert.assertTrue(map1.values().contains((short) 0));
        Assert.assertTrue(map1.values().contains((short) 31));
        Assert.assertTrue(map1.values().contains((short) 32));
    }

    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0L));
        Assert.assertEquals(31L, this.map.get(31L));
        Assert.assertEquals(32L, this.map.get(32L));

        Assert.assertEquals(0L, this.map.get(1L));
        Assert.assertEquals(0L, this.map.get(33L));
    }

    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0L, (short) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31L, (short) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32L, (short) 5));
    }

    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0L));
        Assert.assertEquals(31L, this.map.getOrThrow(31L));
        Assert.assertEquals(32L, this.map.getOrThrow(32L));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1L));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33L));
    }

    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey(0L));
        Assert.assertTrue(this.map.containsKey(31L));
        Assert.assertTrue(this.map.containsKey(32L));
        Assert.assertFalse(this.map.containsKey(1L));
        Assert.assertFalse(this.map.containsKey(5L));
        Assert.assertFalse(this.map.containsKey(35L));
    }

    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertTrue(this.map.containsValue((short) 31));
        Assert.assertTrue(this.map.containsValue((short) 32));
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains((short) 0));
        Assert.assertTrue(this.map.contains((short) 31));
        Assert.assertTrue(this.map.contains((short) 32));
    }

    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.map.containsAll((short) 0, (short) 31, (short) 32));
        Assert.assertFalse(this.map.containsAll((short) 0, (short) 31, (short) 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Test
    public void containsAll_Iterable()
    {
        Assert.assertTrue(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 32)));
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 35)));
        Assert.assertTrue(this.map.containsAll(new ShortArrayList()));
    }

    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0L, (short) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1L, (short) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1L, (short) 1, 5L, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0L, (short) 0, 5L, (short) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1L, (short) 1, 0L, (short) 0, 5L, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6L, (short) 6, 5L, (short) 5).size());
    }

    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.getEmptyMap().isEmpty());
        Assert.assertFalse(this.map.isEmpty());
        Assert.assertFalse(this.newWithKeysValues(1L, (short) 1).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(0L, (short) 0).isEmpty());
        Assert.assertFalse(this.newWithKeysValues(50L, (short) 50).isEmpty());
    }

    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.getEmptyMap().notEmpty());
        Assert.assertTrue(this.map.notEmpty());
        Assert.assertTrue(this.newWithKeysValues(1L, (short) 1).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(0L, (short) 0).notEmpty());
        Assert.assertTrue(this.newWithKeysValues(50L, (short) 50).notEmpty());
    }

    @Test
    public void testEquals()
    {
        LongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 32L, (short) 32);
        LongShortMap map2 = this.newWithKeysValues(32L, (short) 32, 0L, (short) 0, 1L, (short) 1);
        LongShortMap map3 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 2, 32L, (short) 32);
        LongShortMap map4 = this.newWithKeysValues(0L, (short) 1, 1L, (short) 1, 32L, (short) 32);
        LongShortMap map5 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 32L, (short) 33);
        LongShortMap map6 = this.newWithKeysValues(50L, (short) 0, 60L, (short) 1, 70L, (short) 33);
        LongShortMap map7 = this.newWithKeysValues(50L, (short) 0, 60L, (short) 1);
        LongShortMap map8 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        LongShortMap map9 = this.newWithKeysValues(0L, (short) 0);

        Verify.assertEqualsAndHashCode(map1, map2);
        Verify.assertPostSerializedEqualsAndHashCode(map1);
        Verify.assertPostSerializedEqualsAndHashCode(map6);
        Verify.assertPostSerializedEqualsAndHashCode(map8);
        Verify.assertPostSerializedEqualsAndHashCode(this.getEmptyMap());
        Assert.assertNotEquals(map1, map3);
        Assert.assertNotEquals(this.getEmptyMap(), map3);
        Assert.assertNotEquals(map9, this.getEmptyMap());
        Assert.assertNotEquals(this.getEmptyMap(), map9);
        Assert.assertNotEquals(ShortArrayList.newListWith((short) 0), map9);
        Assert.assertNotEquals(map1, map4);
        Assert.assertNotEquals(map1, map5);
        Assert.assertNotEquals(map7, map6);
        Assert.assertNotEquals(map7, map8);

        Assert.assertEquals(map1, LongShortMaps.mutable.ofAll(map1));
        Assert.assertEquals(map1, LongShortMaps.immutable.ofAll(map1));
    }

    @Test
    public void testHashCode()
    {
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 32L, (short) 32).hashCode(),
                this.newWithKeysValues(32L, (short) 32, 0L, (short) 0, 1L, (short) 1).hashCode());
        Assert.assertEquals(
                UnifiedMap.newWithKeysValues(50L, (short) 0, 60L, (short) 1, 70L, (short) 33).hashCode(),
                this.newWithKeysValues(50L, (short) 0, 60L, (short) 1, 70L, (short) 33).hashCode());
        Assert.assertEquals(UnifiedMap.newMap().hashCode(), this.getEmptyMap().hashCode());
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1L, (short) 2).hashCode(), this.newWithKeysValues(1L, (short) 2).hashCode());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("{}", this.getEmptyMap().toString());
        Assert.assertEquals("{0=0}", this.newWithKeysValues(0L, (short) 0).toString());
        Assert.assertEquals("{1=1}", this.newWithKeysValues(1L, (short) 1).toString());
        Assert.assertEquals("{5=5}", this.newWithKeysValues(5L, (short) 5).toString());

        LongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        Assert.assertTrue(
                map1.toString(),
                "{0=0, 1=1}".equals(map1.toString())
                        || "{1=1, 0=0}".equals(map1.toString()));

        LongShortMap map2 = this.newWithKeysValues(1L, (short) 1, 32L, (short) 32);
        Assert.assertTrue(
                map2.toString(),
                "{1=1, 32=32}".equals(map2.toString())
                        || "{32=32, 1=1}".equals(map2.toString()));

        LongShortMap map3 = this.newWithKeysValues(0L, (short) 0, 32L, (short) 32);
        Assert.assertTrue(
                map3.toString(),
                "{0=0, 32=32}".equals(map3.toString())
                        || "{32=32, 0=0}".equals(map3.toString()));

        LongShortMap map4 = this.newWithKeysValues(32L, (short) 32, 33L, (short) 33);
        Assert.assertTrue(
                map4.toString(),
                "{32=32, 33=33}".equals(map4.toString())
                        || "{33=33, 32=32}".equals(map4.toString()));
    }

    @Test
    public void forEach()
    {
        LongShortMap map0 = this.newWithKeysValues(0L, (short) 1, 3L, (short) 4);
        short[] sum0 = new short[1];
        map0.forEach(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);

        LongShortMap map1 = this.newWithKeysValues(1L, (short) 2, 3L, (short) 4);
        short[] sum1 = new short[1];
        map1.forEach(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);

        LongShortMap map01 = this.newWithKeysValues(0L, (short) 1, 1L, (short) 2);
        short[] sum01 = new short[1];
        map01.forEach(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);

        LongShortMap map = this.newWithKeysValues(3L, (short) 4, 4L, (short) 5);
        short[] sum = new short[1];
        map.forEach(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);

        LongShortMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEach(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        LongShortMap map3 = this.newWithKeysValues(1L, (short) 2);
        short[] sum3 = new short[1];
        map3.forEach(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachValue()
    {
        LongShortMap map0 = this.newWithKeysValues(0L, (short) 1, 3L, (short) 4);
        short[] sum0 = new short[1];
        map0.forEachValue(each -> sum0[0] += each);
        Assert.assertEquals(5L, sum0[0]);

        LongShortMap map1 = this.newWithKeysValues(1L, (short) 2, 3L, (short) 4);
        short[] sum1 = new short[1];
        map1.forEachValue(each -> sum1[0] += each);
        Assert.assertEquals(6L, sum1[0]);

        LongShortMap map01 = this.newWithKeysValues(0L, (short) 1, 1L, (short) 2);
        short[] sum01 = new short[1];
        map01.forEachValue(each -> sum01[0] += each);
        Assert.assertEquals(3L, sum01[0]);

        LongShortMap map = this.newWithKeysValues(3L, (short) 4, 4L, (short) 5);
        short[] sum = new short[1];
        map.forEachValue(each -> sum[0] += each);
        Assert.assertEquals(9L, sum[0]);

        LongShortMap map2 = this.getEmptyMap();
        short[] sum2 = new short[1];
        map2.forEachValue(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        LongShortMap map3 = this.newWithKeysValues(1L, (short) 2);
        short[] sum3 = new short[1];
        map3.forEachValue(each -> sum3[0] += each);
        Assert.assertEquals(2L, sum3[0]);
    }

    @Test
    public void forEachKey()
    {
        LongShortMap map0 = this.newWithKeysValues(0L, (short) 1, 3L, (short) 4);
        long[] sum0 = new long[1];
        map0.forEachKey(each -> sum0[0] += each);
        Assert.assertEquals(3L, sum0[0]);

        LongShortMap map1 = this.newWithKeysValues(1L, (short) 2, 3L, (short) 4);
        long[] sum1 = new long[1];
        map1.forEachKey(each -> sum1[0] += each);
        Assert.assertEquals(4L, sum1[0]);

        LongShortMap map01 = this.newWithKeysValues(0L, (short) 1, 1L, (short) 2);
        long[] sum01 = new long[1];
        map01.forEachKey(each -> sum01[0] += each);
        Assert.assertEquals(1L, sum01[0]);

        LongShortMap map = this.newWithKeysValues(3L, (short) 4, 4L, (short) 5);
        long[] sum = new long[1];
        map.forEachKey(each -> sum[0] += each);
        Assert.assertEquals(7L, sum[0]);

        LongShortMap map2 = this.getEmptyMap();
        long[] sum2 = new long[1];
        map2.forEachKey(each -> sum2[0] += each);
        Assert.assertEquals(0L, sum2[0]);

        LongShortMap map3 = this.newWithKeysValues(1L, (short) 1);
        long[] sum3 = new long[1];
        map3.forEachKey(each -> sum3[0] += each);
        Assert.assertEquals(1L, sum3[0]);
    }

    @Test
    public void forEachKeyValue()
    {
        LongShortMap map0 = this.newWithKeysValues(0L, (short) 1, 3L, (short) 4);
        long[] sumKey0 = new long[1];
        short[] sumValue0 = new short[1];
        map0.forEachKeyValue((long eachKey, short eachValue) ->
        {
            sumKey0[0] += eachKey;
            sumValue0[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey0[0]);
        Assert.assertEquals(5L, sumValue0[0]);

        LongShortMap map1 = this.newWithKeysValues(1L, (short) 2, 3L, (short) 4);
        long[] sumKey1 = new long[1];
        short[] sumValue1 = new short[1];
        map1.forEachKeyValue((long eachKey, short eachValue) ->
        {
            sumKey1[0] += eachKey;
            sumValue1[0] += eachValue;
        });
        Assert.assertEquals(4L, sumKey1[0]);
        Assert.assertEquals(6L, sumValue1[0]);

        LongShortMap map01 = this.newWithKeysValues(0L, (short) 1, 1L, (short) 2);
        long[] sumKey01 = new long[1];
        short[] sumValue01 = new short[1];
        map01.forEachKeyValue((long eachKey, short eachValue) ->
        {
            sumKey01[0] += eachKey;
            sumValue01[0] += eachValue;
        });
        Assert.assertEquals(1L, sumKey01[0]);
        Assert.assertEquals(3L, sumValue01[0]);

        LongShortMap map = this.newWithKeysValues(3L, (short) 4, 4L, (short) 5);
        long[] sumKey = new long[1];
        short[] sumValue = new short[1];
        map.forEachKeyValue((long eachKey, short eachValue) ->
        {
            sumKey[0] += eachKey;
            sumValue[0] += eachValue;
        });
        Assert.assertEquals(7L, sumKey[0]);
        Assert.assertEquals(9L, sumValue[0]);

        LongShortMap map2 = this.getEmptyMap();
        long[] sumKey2 = new long[1];
        short[] sumValue2 = new short[1];
        map2.forEachKeyValue((long eachKey, short eachValue) ->
        {
            sumKey2[0] += eachKey;
            sumValue2[0] += eachValue;
        });
        Assert.assertEquals(0L, sumKey2[0]);
        Assert.assertEquals(0L, sumValue2[0]);

        LongShortMap map3 = this.newWithKeysValues(3L, (short) 5);
        long[] sumKey3 = new long[1];
        short[] sumValue3 = new short[1];
        map3.forEachKeyValue((long eachKey, short eachValue) ->
        {
            sumKey3[0] += eachKey;
            sumValue3[0] += eachValue;
        });
        Assert.assertEquals(3L, sumKey3[0]);
        Assert.assertEquals(5L, sumValue3[0]);
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("", this.getEmptyMap().makeString());
        Assert.assertEquals("", this.getEmptyMap().makeString(", "));
        Assert.assertEquals("[]", this.getEmptyMap().makeString("[", "/", "]"));
        Assert.assertEquals("0", this.newWithKeysValues(0L, (short) 0).makeString());
        Assert.assertEquals("0", this.newWithKeysValues(0L, (short) 0).makeString(", "));
        Assert.assertEquals("[0]", this.newWithKeysValues(0L, (short) 0).makeString("[", "/", "]"));
        Assert.assertEquals("1", this.newWithKeysValues(1L, (short) 1).makeString());
        Assert.assertEquals("5", this.newWithKeysValues(5L, (short) 5).makeString());

        LongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        Assert.assertTrue(
                map1.makeString(),
                "0, 1".equals(map1.makeString())
                        || "1, 0".equals(map1.makeString()));

        LongShortMap map2 = this.newWithKeysValues(1L, (short) 1, 32L, (short) 32);
        Assert.assertTrue(
                map2.makeString("[", "/", "]"),
                "[1/32]".equals(map2.makeString("[", "/", "]"))
                        || "[32/1]".equals(map2.makeString("[", "/", "]")));

        LongShortMap map3 = this.newWithKeysValues(0L, (short) 0, 32L, (short) 32);
        Assert.assertTrue(
                map3.makeString("~"),
                "0~32".equals(map3.makeString("~"))
                        || "32~0".equals(map3.makeString("~")));

        LongShortMap map4 = this.newWithKeysValues(32L, (short) 32, 33L, (short) 33);
        Assert.assertTrue(
                map4.makeString("[", ", ", "]"),
                "[32, 33]".equals(map4.makeString("[", ", ", "]"))
                        || "[33, 32]".equals(map4.makeString("[", ", ", "]")));
    }

    @Test
    public void appendString()
    {
        Appendable appendable = new StringBuilder();
        this.getEmptyMap().appendString(appendable);
        Assert.assertEquals("", appendable.toString());

        this.getEmptyMap().appendString(appendable, "/");
        Assert.assertEquals("", appendable.toString());

        this.getEmptyMap().appendString(appendable, "{", "/", "}");
        Assert.assertEquals("{}", appendable.toString());

        Appendable appendable0 = new StringBuilder();
        this.newWithKeysValues(0L, (short) 0).appendString(appendable0);
        Assert.assertEquals("0", appendable0.toString());

        Appendable appendable01 = new StringBuilder();
        this.newWithKeysValues(0L, (short) 0).appendString(appendable01, "/");
        Assert.assertEquals("0", appendable01.toString());

        Appendable appendable02 = new StringBuilder();
        this.newWithKeysValues(0L, (short) 0).appendString(appendable02, "{", "/", "}");
        Assert.assertEquals("{0}", appendable02.toString());

        Appendable appendable1 = new StringBuilder();
        this.newWithKeysValues(1L, (short) 1).appendString(appendable1);
        Assert.assertEquals("1", appendable1.toString());

        Appendable appendable2 = new StringBuilder();
        this.newWithKeysValues(5L, (short) 5).appendString(appendable2);
        Assert.assertEquals("5", appendable2.toString());

        Appendable appendable3 = new StringBuilder();
        LongShortMap map1 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1);
        map1.appendString(appendable3);
        Assert.assertTrue(
                appendable3.toString(),
                "0, 1".equals(appendable3.toString())
                        || "1, 0".equals(appendable3.toString()));

        Appendable appendable4 = new StringBuilder();
        LongShortMap map2 = this.newWithKeysValues(1L, (short) 1, 32L, (short) 32);
        map2.appendString(appendable4, "[", "/", "]");
        Assert.assertTrue(
                appendable4.toString(),
                "[1/32]".equals(appendable4.toString())
                        || "[32/1]".equals(appendable4.toString()));

        Appendable appendable5 = new StringBuilder();
        LongShortMap map3 = this.newWithKeysValues(1L, (short) 1, 32L, (short) 32);
        map3.appendString(appendable5, "[", "/", "]");
        Assert.assertTrue(
                appendable5.toString(),
                "[1/32]".equals(appendable5.toString())
                        || "[32/1]".equals(appendable5.toString()));

        Appendable appendable6 = new StringBuilder();
        map1.appendString(appendable6, "/");
        Assert.assertTrue(
                appendable6.toString(),
                "0/1".equals(appendable6.toString())
                        || "1/0".equals(appendable6.toString()));
    }

    @Test
    public void select()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        LongShortMap actual1 = map.select((long key, short value) -> key == 1L || value == (short) 3);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1, 3L, (short) 3), actual1);
        LongShortMap actual2 = map.select((long key, short value) -> key == 0L || value == (short) 2);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0, 2L, (short) 2), actual2);
    }

    @Test
    public void reject()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        LongShortMap actual1 = map.reject((long key, short value) -> key == 1L || value == (short) 3);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(0L, (short) 0, 2L, (short) 2), actual1);
        LongShortMap actual2 = map.reject((long key, short value)-> key == 0L || value == (short) 2);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1, 3L, (short) 3), actual2);
    }

    @Test
    public void select_value()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        ShortIterable actual1 = map.select(ShortPredicates.greaterThan((short) 1));
        Assert.assertEquals(ShortBags.immutable.with((short) 2, (short) 3), actual1);
        ShortIterable actual2 = map.select(ShortPredicates.lessThan((short) 2));
        Assert.assertEquals(ShortBags.immutable.with((short) 0, (short) 1), actual2);
    }

    @Test
    public void reject_value()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        ShortIterable actual1 = map.reject(ShortPredicates.lessThan((short) 2));
        Assert.assertEquals(ShortBags.immutable.with((short) 2, (short) 3), actual1);
        ShortIterable actual2 = map.reject(ShortPredicates.greaterThan((short) 1));
        Assert.assertEquals(ShortBags.immutable.with((short) 0, (short) 1), actual2);
    }

    @Test
    public void collect()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);

        ShortToObjectFunction<Short> function = (parameter) -> (short) (parameter + 1);
        Assert.assertEquals(Bags.immutable.with((short) 1, (short) 2, (short) 3, (short) 4), map.collect(function));
        Assert.assertEquals(Bags.immutable.empty(), this.getEmptyMap().collect(function));
        Assert.assertEquals(Bags.immutable.with((short) 2), this.newWithKeysValues(1L, (short) 1).collect(function));
    }

    @Test
    public void count()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals(2, map.count(ShortPredicates.greaterThan((short) 1)));
        Assert.assertEquals(2, map.count(ShortPredicates.lessThan((short) 2)));
    }

    @Test
    public void detectIfNone_value()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        short resultNotFound = map.detectIfNone(ShortPredicates.greaterThan((short) 5), (short) 5);
        Assert.assertEquals((short) 5, resultNotFound);

        Assert.assertEquals((short) 5, this.getEmptyMap().detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 5, this.newWithKeysValues(1L, (short) 1).detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 1, this.newWithKeysValues(1L, (short) 1).detectIfNone(ShortPredicates.equal((short) 1), (short) 5));
        Assert.assertEquals((short) 0, map.detectIfNone(ShortPredicates.equal((short) 0), (short) 5));
        Assert.assertEquals((short) 1, map.detectIfNone(ShortPredicates.equal((short) 1), (short) 5));
        Assert.assertEquals((short) 2, map.detectIfNone(ShortPredicates.equal((short) 2), (short) 5));
    }

    @Test
    public void anySatisfy()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertFalse(this.getEmptyMap().anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (short) 1).anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (short) 1).anySatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertTrue(map.anySatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertFalse(map.anySatisfy(ShortPredicates.greaterThan((short) 5)));
    }

    @Test
    public void allSatisfy()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertTrue(this.getEmptyMap().allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (short) 1).allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (short) 1).allSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.allSatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertTrue(map.allSatisfy(ShortPredicates.lessThan((short) 5)));
        LongShortMap map1 = this.newWithKeysValues(2L, (short) 2, 3L, (short) 3);
        Assert.assertFalse(map1.allSatisfy(ShortPredicates.equal((short) 0)));
    }

    @Test
    public void noneSatisfy()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertTrue(this.getEmptyMap().noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertTrue(this.newWithKeysValues(1L, (short) 1).noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(this.newWithKeysValues(1L, (short) 1).noneSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 0)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 1)));
        Assert.assertFalse(map.noneSatisfy(ShortPredicates.equal((short) 2)));
        Assert.assertTrue(map.noneSatisfy(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void max()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals((short) 3, map.max());
        Assert.assertEquals((short) 3, this.newWithKeysValues(3L, (short) 3).max());
    }

    @Test
    public void min()
    {
        LongShortMap map = this.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3, 0L, (short) 0);
        Assert.assertEquals((short) 0, map.min());
        Assert.assertEquals((short) 3, this.newWithKeysValues(3L, (short) 3).min());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws()
    {
        this.getEmptyMap().max();
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws()
    {
        this.getEmptyMap().min();
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty((short) 5));
        Assert.assertEquals(0L, this.getEmptyMap().minIfEmpty((short) 0));
        LongShortMap map = this.newWithKeysValues(1L, (short) 1, 0L, (short) 0, 9L, (short) 9, 7L, (short) 7);
        Assert.assertEquals(0L, map.minIfEmpty((short) 5));
        Assert.assertEquals((short) 3, this.newWithKeysValues(3L, (short) 3).maxIfEmpty((short) 5));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5L, this.getEmptyMap().maxIfEmpty((short) 5));
        Assert.assertEquals(0L, this.getEmptyMap().maxIfEmpty((short) 0));
        LongShortMap map = this.newWithKeysValues(1L, (short) 1, 0L, (short) 0, 9L, (short) 9, 7L, (short) 7);
        Assert.assertEquals(9L, map.maxIfEmpty((short) 5));
        Assert.assertEquals((short) 3, this.newWithKeysValues(3L, (short) 3).minIfEmpty((short) 5));
    }

    @Test
    public void sum()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals((short) 6, map.sum());
        LongShortMap map2 = this.newWithKeysValues(2L, (short) 2, 3L, (short) 3, 4L, (short) 4);
        Assert.assertEquals((short) 9, map2.sum());
        LongShortMap map3 = this.newWithKeysValues(2L, (short) 2);
        Assert.assertEquals((short) 2, map3.sum());
    }

    @Test
    public void average()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals(1.5, map.average(), 0.0);
        LongShortMap map1 = this.newWithKeysValues(1L, (short) 1);
        Assert.assertEquals(1.0, map1.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        this.getEmptyMap().average();
    }

    @Test
    public void median()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals(1.5, map.median(), 0.0);
        LongShortMap map2 = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2);
        Assert.assertEquals(1.0, map2.median(), 0.0);
        LongShortMap map3 = this.newWithKeysValues(1L, (short) 1);
        Assert.assertEquals(1.0, map3.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        this.getEmptyMap().median();
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), this.newWithKeysValues(0L, (short) 0).toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), this.newWithKeysValues(1L, (short) 1).toList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 2), this.newWithKeysValues(2L, (short) 2).toList());
        Assert.assertTrue(this.newWithKeysValues(2L, (short) 2, 3L, (short) 3).toList().equals(ShortArrayList.newListWith((short) 2, (short) 3))
                || this.newWithKeysValues(2L, (short) 2, 3L, (short) 3).toList().equals(ShortArrayList.newListWith((short) 3, (short) 2)));
    }

    @Test
    public void toSortedList()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2, (short) 3), map.toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith(), this.getEmptyMap().toSortedList());
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), this.newWithKeysValues(1L, (short) 1).toSortedList());
    }

    @Test
    public void toSet()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals(ShortHashSet.newSetWith((short) 0, (short) 1, (short) 2, (short) 3), map.toSet());
        Assert.assertEquals(ShortHashSet.newSetWith(), this.getEmptyMap().toSet());
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1), this.newWithKeysValues(1L, (short) 1).toSet());
    }

    @Test
    public void toBag()
    {
        LongShortMap map = this.newWithKeysValues(0L, (short) 0, 1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 0, (short) 1, (short) 2, (short) 3), map.toBag());
        Assert.assertEquals(ShortHashBag.newBagWith(), this.getEmptyMap().toBag());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1), this.newWithKeysValues(1L, (short) 1).toBag());
    }

    @Test
    public void shortIterator()
    {
        MutableShortSet expected = ShortHashSet.newSetWith((short) 0, (short) 31, (short) 32);
        MutableShortSet actual = ShortHashSet.newSetWith();

        ShortIterator iterator = this.map.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
        Verify.assertThrows(NoSuchElementException.class, () -> this.getEmptyMap().shortIterator().next());
    }

    @Test
    public void asLazy()
    {
        LazyShortIterable lazy = this.map.asLazy();
        Assert.assertTrue(lazy.toList().containsAll((short) 0, (short) 31, (short) 32));
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(LongArrayList.newListWith(0L, 31L, 32L), this.map.keysView().toSortedList());
    }

    @Test
    public void keyValuesView()
    {
        MutableBag<LongShortPair> expected = Bags.mutable.of();
        this.map.forEachKeyValue((long key, short value) -> expected.add(PrimitiveTuples.pair(key, value)));
        Assert.assertEquals(expected, this.map.keyValuesView().toBag());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new short[]{(short) 0, (short) 31, (short) 32}, this.map.toSortedArray()));
    }

    @Test
    public void toArray()
    {
        LongShortMap map = this.newWithKeysValues(1L, (short) 1, 2L, (short) 2);
        short[] array = map.toArray();
        Assert.assertTrue(Arrays.equals(new short[]{(short) 1, (short) 2}, array)
                || Arrays.equals(new short[]{(short) 2, (short) 1}, array));
        Assert.assertEquals(0, this.getEmptyMap().toArray().length);
        Assert.assertTrue(Arrays.equals(new short[]{(short) 1}, this.newWithKeysValues(1L, (short) 1).toArray()));
    }

    @Test
    public void toImmutable()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().toImmutable());
        Verify.assertInstanceOf(ImmutableLongShortMap.class, this.classUnderTest().toImmutable());
    }

    @Test
    public void chunk()
    {
        ShortIterable iterable = this.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        Assert.assertEquals(
                Lists.mutable.with(
                        ShortBags.mutable.with((short) 1),
                        ShortBags.mutable.with((short) 2),
                        ShortBags.mutable.with((short) 3)).toSet(),
                iterable.chunk(1).toSet());
        Assert.assertTrue(
                Lists.mutable.with(
                        ShortBags.mutable.with((short) 1, (short) 2),
                        ShortBags.mutable.with((short) 3)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        ShortBags.mutable.with((short) 2, (short) 3),
                        ShortBags.mutable.with((short) 1)).toSet().equals(iterable.chunk(2).toSet())
                || Lists.mutable.with(
                        ShortBags.mutable.with((short) 1, (short) 3),
                        ShortBags.mutable.with((short) 2)).toSet().equals(iterable.chunk(2).toSet()));
        Assert.assertEquals(
                Lists.mutable.with(
                        ShortBags.mutable.with((short) 1, (short) 2, (short) 3)).toSet(),
                iterable.chunk(3).toSet());
        Assert.assertEquals(
                Lists.mutable.with(ShortBags.mutable.with((short) 1, (short) 2, (short) 3)).toSet(),
                iterable.chunk(4).toSet());
        Assert.assertEquals(
                Lists.mutable.with(ShortBags.mutable.with((short) 1)).toSet(),
                this.newWithKeysValues(1L, (short) 1).chunk(1).toSet());

        Verify.assertIterablesEqual(Lists.mutable.empty(), this.getEmptyMap().chunk(1));

        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(0));
        Verify.assertThrows(IllegalArgumentException.class, () -> iterable.chunk(-1));
        Verify.assertThrows(IllegalArgumentException.class, () -> this.newWithKeysValues(1L, (short) 1).chunk(-1));
    }
}
